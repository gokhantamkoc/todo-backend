package com.gokhantamkoc.todobackend.service;

import com.gokhantamkoc.todobackend.exception.TodoNotFoundException;
import com.gokhantamkoc.todobackend.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {
    Page<Todo> list(Pageable pageable);
    Todo create(Todo todo);
    Todo update(Todo todo) throws TodoNotFoundException;
    Todo getTodo(long id) throws TodoNotFoundException;
}
