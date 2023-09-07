package com.intercorp.msthree.service.impl;

import com.intercorp.msthree.models.Root;
import com.intercorp.msthree.repository.IRootRepository;
import com.intercorp.msthree.service.IRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRootServiceImpl implements IRootService {

    @Autowired
    private IRootRepository rootRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Root> listAll(Pageable pageable) throws Exception {
        return this.rootRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Root> findByParameters(String textSearch, Integer page, Integer pageSize) throws Exception {

        List<Root> list = new ArrayList<>();

        System.out.println("BUSCANDO POR PALABRA: "+textSearch);

        List<Root> list1 = this.rootRepository.findByParameters(textSearch,null,null,null,null);
        if(list1.size() > 0){
            System.out.println("Exec1");
            list = list1;
        }else{
            List<Root> list2 = this.rootRepository.findByParameters(null,textSearch,null,null,null);
            if(list2.size() > 0){
                System.out.println("Exec2");
                list = list2;
            }else{
                List<Root> list3 = this.rootRepository.findByParameters(null,null,textSearch,null,null);
                if(list3.size() > 0){
                    System.out.println("Exec3");
                    list = list3;
                }else{
                    List<Root> list4 = this.rootRepository.findByParameters(null,null,null,textSearch,null);
                    if(list4.size() > 0){
                        System.out.println("Exec4");
                        list = list4;
                    }else{
                        List<Root> list5 = this.rootRepository.findByParameters(null,null,null,null,textSearch);
                        if (list5.size() > 0){
                            System.out.println("Exec5");
                            list = list5;
                        }else{
                            System.out.println("Exec6");
                            list = this.rootRepository.findByParameters(null,null,null,null,null);
                        }
                    }
                }
            }
        }

        Pageable paging = PageRequest.of(page, pageSize);
        int start = Math.min((int)paging.getOffset(), list.size());
        int end = Math.min((start + paging.getPageSize()), list.size());;

        return new PageImpl<>(list.subList(start, end), paging, list.size());
    }

}
