package com.gokhantamkoc.todobackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gokhantamkoc.todobackend.model.Todo;
import com.gokhantamkoc.todobackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TodoService todoService;

    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<?> list(Pageable pageable) {
        try {
            return new ResponseEntity(todoService.list(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public ResponseEntity<?> create(@RequestBody String json) {
        try {
            Todo todo = objectMapper.readValue(json, Todo.class);
            return new ResponseEntity(todoService.create(todo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody String json) {
        try {
            Todo todo = objectMapper.readValue(json, Todo.class);
            return new ResponseEntity(todoService.update(todo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<?> create(@PathVariable long id) {
        try {
            Todo todo = todoService.getTodo(id);
            return new ResponseEntity(todoService.create(todo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
