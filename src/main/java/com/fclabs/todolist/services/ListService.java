package com.fclabs.todolist.services;

import com.fclabs.todolist.entities.ListEntity;
import com.fclabs.todolist.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    ListRepository listRepository;

    public List<ListEntity> getAll() {
        return listRepository.findAll();
    }

}
