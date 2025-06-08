package com.example.project4.repository;



import com.example.project4.model.User;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // You can define custom query methods here later if needed
    
}
