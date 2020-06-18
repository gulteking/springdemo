package com.gulteking.springdemo.controller;

import com.gulteking.springdemo.entity.Author;
import com.gulteking.springdemo.model.AuthorRequest;
import com.gulteking.springdemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/author/search")
    public List<Author> searchAuthor(@RequestParam("name") String name){
        List<Author> authors = authorRepository.findByNameContainsIgnoreCase(name);

        return authors;
    }

    @GetMapping("/author/quicksearch")
    public List<Author> quickSearch(@RequestParam("keyword") String keyword){
        List<Author> authors = authorRepository.findByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(keyword,keyword);

        return authors;
    }


    @DeleteMapping("/author")
    public void deleteAuthor(@RequestParam(name = "id") Long id) throws Exception {
        Author existingAuthor = getAuthor(id);

        authorRepository.delete(existingAuthor);
    }

    @PostMapping("/author")
    public void editAuthor(@RequestBody @Valid AuthorRequest authorRequest,
                           @RequestParam(name = "id") Long id) throws Exception {
        Author existingAuthor = getAuthor(id);

        existingAuthor.setName(authorRequest.getName());
        existingAuthor.setSurname(authorRequest.getSurname());
        existingAuthor.setBirthDate(authorRequest.getBirthDate());
        authorRepository.save(existingAuthor);
    }

    private Author getAuthor(Long id) throws Exception {
        Author existingAuthor = authorRepository.findFirstById(id);
        if (existingAuthor == null) {
            throw new Exception("Author not exists");
        }
        return existingAuthor;
    }


    @PutMapping("/author")
    public void createAuthor(@RequestBody @Valid AuthorRequest request) {

        Author newAuthor = new Author();
        newAuthor.setName(request.getName());
        newAuthor.setSurname(request.getSurname());
        newAuthor.setBirthDate(request.getBirthDate());
        authorRepository.save(newAuthor);

    }


    @GetMapping("/author")
    public List<Author> listAuthors() {
        List<Author> authors = authorRepository.findAll();

        return authors;
    }
}
