package com.fclabs.todolist.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fclabs.todolist.BaseRepositoryTest;
import com.fclabs.todolist.entities.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ListRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private ListRepository listRepository;

    @Test
    public void createList_withSuccess() {
        List newList = buildList("work");

        List response = listRepository.save(newList);

        assertNotNull(response.getId());
        assertEquals(newList.getName(), response.getName());
    }

    private List buildList(String name) {
        return List.builder().name(name).description("unit test").build();
    }

}
