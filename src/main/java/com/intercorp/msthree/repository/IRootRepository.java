package com.intercorp.msthree.repository;

import com.intercorp.msthree.models.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRootRepository extends JpaRepository<Root, Long> {

    @Query("SELECT t FROM Root t "
            + "WHERE (:firstname IS NULL OR t.person.firstname = :firstname) "
            + "AND (:lastname IS NULL OR t.person.lastname = :lastname) "
            + "AND (:city IS NULL OR t.person.city = :city) "
            + "AND (:country IS NULL OR t.person.country = :country) "
            + "AND (:email IS NULL OR t.person.email = :email) ")
    List<Root> findByParameters(String firstname,
                                String lastname,
                                String city,
                                String country,
                                String email);

}
