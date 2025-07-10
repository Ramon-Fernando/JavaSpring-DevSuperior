package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private DepartmentRepository departmentRepository;
    private PersonRepository repository;

    public PersonService(PersonRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        entity.setDepartment(dept);
        entity = repository.save(entity);

        return new  PersonDepartmentDTO(entity);
    }
}


