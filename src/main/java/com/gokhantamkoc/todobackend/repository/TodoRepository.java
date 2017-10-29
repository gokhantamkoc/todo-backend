package com.gokhantamkoc.todobackend.repository;

import com.gokhantamkoc.todobackend.model.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> {
}
