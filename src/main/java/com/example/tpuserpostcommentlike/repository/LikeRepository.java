package com.example.tpuserpostcommentlike.repository;

import com.example.tpuserpostcommentlike.entity.Liked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends CrudRepository<Liked, Integer> {
}
