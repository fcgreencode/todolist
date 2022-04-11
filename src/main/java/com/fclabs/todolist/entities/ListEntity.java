package com.fclabs.todolist.entities;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "list")
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    
    private String name;
    
    private String description;
}
