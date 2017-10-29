package com.gokhantamkoc.todobackend.service;

import com.gokhantamkoc.todobackend.exception.TodoNotFoundException;
import com.gokhantamkoc.todobackend.model.Todo;
import com.gokhantamkoc.todobackend.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TodoServiceImpl implements TodoService {

    @Resource
    TodoRepository todoRepository;

    @Override
    public Page<Todo> list(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) throws TodoNotFoundException {
        Todo todoToBeUpdated = todoRepository.findOne(todo.getId());

        if(todoToBeUpdated == null) {
            throw new TodoNotFoundException();
        }

        todoToBeUpdated.setDescription(todo.getDescription());
        todoToBeUpdated.setStatus(todo.getStatus());

        return todoRepository.save(todoToBeUpdated);
    }

    @Override
    public Todo getTodo(long id) throws TodoNotFoundException {
        Todo todoToFound = todoRepository.findOne(id);

        if(todoToFound == null) {
            throw new TodoNotFoundException();
        }

        return todoToFound;
    }
}
