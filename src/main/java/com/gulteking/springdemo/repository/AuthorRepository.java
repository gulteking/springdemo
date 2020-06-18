package com.gulteking.springdemo.repository;

import com.gulteking.springdemo.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    List<Author> findAll();
    Author findFirstById(Long id);

    ////select * from author where name like '%mustafa%'
    List<Author> findByNameContainsIgnoreCase(String name);

    //// select * from author where name like '%adivar%' or surname like '%adivar%'
    List<Author> findByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(String name, String surname);

    ////select * from author where name = 'mustafa'
    //List<Author> findByName(String name);
}
