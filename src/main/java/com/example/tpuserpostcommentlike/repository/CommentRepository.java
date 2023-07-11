package com.example.tpuserpostcommentlike.repository;

import com.example.tpuserpostcommentlike.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends CrudRepository<Comment, Integer> {
}
