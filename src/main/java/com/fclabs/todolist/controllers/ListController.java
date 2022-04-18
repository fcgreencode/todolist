package com.fclabs.todolist.controllers;

import java.util.List;

import com.fclabs.todolist.services.ListService;
import com.fclabs.todolist.entities.ListEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping
    public List<ListEntity> findAll() {
        return listService.getAll();
    }

}
