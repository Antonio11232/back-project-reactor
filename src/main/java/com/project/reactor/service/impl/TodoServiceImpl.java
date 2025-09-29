package com.project.reactor.service.impl;

import com.project.reactor.exception.TodoNotFoundException;
import com.project.reactor.model.Todo;
import com.project.reactor.repository.TodoRepository;
import com.project.reactor.service.ITodoService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements ITodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Flux<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Mono<Todo> findById(String id) {

        return todoRepository.findById(id).switchIfEmpty(Mono.error(new TodoNotFoundException(id)));

    }

    @Override
    public Mono<Void> deleteById(String id) {
        return this.findById(id).flatMap(todo -> todoRepository.deleteById(id));
    }

    @Override
    public Mono<Todo> save(Todo todo) {
        return todoRepository.save(todo);
    }

}
