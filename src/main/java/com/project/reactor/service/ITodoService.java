package com.project.reactor.service;

import com.project.reactor.model.Todo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITodoService {

    public Flux<Todo> findAll();
    public Mono<Todo> findById(String id);
    public Mono<Void> deleteById(String id);
    public Mono<Todo> save(Todo todo);

}
