package com.fclabs.todolist.repositories;

import com.fclabs.todolist.entities.ListEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {
}
