package com.example.StudentCrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    private int id;
    private String name;
    private String address;
}
