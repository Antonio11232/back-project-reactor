package com.project.reactor.repository;

import com.project.reactor.model.Todo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TodoRepository extends ReactiveMongoRepository<Todo,String> {



}
