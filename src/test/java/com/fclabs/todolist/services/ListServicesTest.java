package com.fclabs.todolist.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.fclabs.todolist.entities.ListEntity;
import com.fclabs.todolist.repositories.ListRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    @Test
    public void test_getById_withSuccess() {
        ListEntity listEntity = buildList("test");
        listEntity.setId(102030);

        when(listRepository.getById(listEntity.getId())).thenReturn(listEntity);

        ListEntity response = listService.getById(listEntity.getId());

        verify(listRepository, times(1)).getById(listEntity.getId());

        assertEquals(listEntity, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        ListEntity listEntity = buildList("test");
        listEntity.setId(102030);

        when(listRepository.getById(listEntity.getId())).thenThrow(new EntityNotFoundException("Fake Error"));

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            listService.getById(listEntity.getId());
        });

        verify(listRepository, times(1)).getById(listEntity.getId());
        assertEquals("Fake Error", exception.getMessage());
    }

    @Test
    public void test_save() {
        ListEntity listEntityNew = buildList("test new");
        ListEntity listEntitySaved = buildList("test saved");

        when(listRepository.save(listEntityNew)).thenReturn(listEntitySaved);

        ListEntity response = listService.save(listEntityNew);

        verify(listRepository, times(1)).save(listEntityNew);

        assertEquals(response, listEntitySaved);
    }

    @Test
    public void test_delete() {
        doNothing().when(listRepository).deleteById(102030L);

        listService.delete(102030L);

        verify(listRepository, times(1)).deleteById(102030L);
    }

    private ListEntity buildList(String name) {
        return ListEntity.builder().name(name).description("unit test").build();
    }

}
