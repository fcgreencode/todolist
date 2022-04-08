package com.fclabs.todolist.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fclabs.todolist.BaseRepositoryTest;
import com.fclabs.todolist.entities.Todo;
import com.fclabs.todolist.entities.TodoStatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoRepositoryTest extends BaseRepositoryTest {
    
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void createTodo_withSuccess() {
        Todo newTodo = buildTodo("work 8 hours", TodoStatus.PENDING);

        Todo response = todoRepository.save(newTodo);

        assertNotNull(response.getId());
        assertEquals(newTodo.getName(), response.getName());
    }

    private Todo buildTodo(String name, TodoStatus status) {
        return Todo.builder().name(name).status(status).build();
    }

}
