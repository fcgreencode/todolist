package com.fclabs.todolist.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.fclabs.todolist.entities.ListEntity;
import com.fclabs.todolist.services.ListService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ListController.class)
public class ListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListService listService;

    @Test
    public void test_findAll() throws Exception {
        List<ListEntity> lists = Arrays.asList(buildList(102030L, "test"), buildList(102031L, "test two"));

        when(listService.getAll()).thenReturn(lists);

        this.mockMvc
                .perform(get("/list"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(lists.get(0).getId().toString()))
                .andExpect(jsonPath("$[0].name").value(lists.get(0).getName()));
    }

    private ListEntity buildList(Long id, String name) {
        return ListEntity.builder().id(id).name(name).description("unit test").build();
    }
}