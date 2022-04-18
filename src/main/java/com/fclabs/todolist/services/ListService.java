package com.fclabs.todolist.services;

import java.util.List;

import com.fclabs.todolist.entities.ListEntity;
import com.fclabs.todolist.repositories.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    ListRepository listRepository;

    public List<ListEntity> getAll() {
        return listRepository.findAll();
    }

    public ListEntity getById(Long id) {
        return listRepository.getById(id);
    }

    public ListEntity save(ListEntity listEntity) {
        return listRepository.save(listEntity);
    }

    public void delete(Long id) {
        listRepository.deleteById(id);
    }

}
