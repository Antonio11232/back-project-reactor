package com.project.reactor.controller;

import com.project.reactor.model.Todo;
import com.project.reactor.service.ITodoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/todo")
public class TodoController {

    private final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Mono<Todo> save(@RequestBody Todo request) {
        return todoService.save(request);
    }

    @GetMapping
    public Flux<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Todo> findById(@PathVariable String id) {
        return todoService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return todoService.deleteById(id);
    }


}
