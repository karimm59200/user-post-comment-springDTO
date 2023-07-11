package com.example.tpuserpostcommentlike.repository;

import com.example.tpuserpostcommentlike.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
}
