package com.example.tpuserpostcommentlike.repository;

import com.example.tpuserpostcommentlike.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
}
