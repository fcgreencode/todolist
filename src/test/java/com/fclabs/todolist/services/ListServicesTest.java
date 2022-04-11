package com.fclabs.todolist.services;

import com.fclabs.todolist.entities.ListEntity;
import com.fclabs.todolist.repositories.ListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListServicesTest {

    @Mock
    ListRepository listRepository;

    @InjectMocks
    ListService listService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getAll() {
        List<ListEntity> expectedEntities = Collections.singletonList(buildList("test"));
        when(listRepository.findAll()).thenReturn(expectedEntities);

        List<ListEntity> responseEntities = listService.getAll();

        verify(listRepository, times(1)).findAll();
        assertEquals(expectedEntities, responseEntities);
    }

    private ListEntity buildList(String name) {
        return ListEntity.builder().name(name).description("unit test").build();
    }

}
