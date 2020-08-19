package com.ricadoca.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricadoca.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
