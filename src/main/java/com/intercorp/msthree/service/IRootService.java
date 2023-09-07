package com.intercorp.msthree.service;

import com.intercorp.msthree.models.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRootService {

    Page<Root> listAll(Pageable pageable) throws Exception;
    Page<Root> findByParameters(String textSearch, Integer page, Integer pageSize) throws Exception;

}
