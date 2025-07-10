package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Department;

public class DepartmentDTO {

    private Long id;
    private String name;

    public DepartmentDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public DepartmentDTO(Department entity) {
        name = entity.getName();
        id = entity.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
