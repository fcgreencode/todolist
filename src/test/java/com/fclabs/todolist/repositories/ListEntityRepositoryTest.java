package com.fclabs.todolist.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fclabs.todolist.BaseRepositoryTest;
import com.fclabs.todolist.entities.ListEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ListEntityRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private ListRepository listRepository;

    @Test
    public void createList_withSuccess() {
        ListEntity newListEntity = buildList("work");

        ListEntity response = listRepository.save(newListEntity);

        assertNotNull(response.getId());
        assertEquals(newListEntity.getName(), response.getName());
    }

    private ListEntity buildList(String name) {
        return ListEntity.builder().name(name).description("unit test").build();
    }

}
