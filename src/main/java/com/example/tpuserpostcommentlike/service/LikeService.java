package com.example.tpuserpostcommentlike.service;


import com.example.tpuserpostcommentlike.Mapping.LikeMapping;
import com.example.tpuserpostcommentlike.dto.LikeDto;
import com.example.tpuserpostcommentlike.entity.Liked;
import com.example.tpuserpostcommentlike.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    LikeMapping likeMapping;

    public LikeDto createLike(LikeDto likeDto){
        Liked likeCreated = likeRepository.save(likeMapping.convertToEntity(likeDto));
        return likeMapping.convertToDto(likeCreated);
    }

    public LikeDto getLikeById(Integer id){
        return likeMapping.convertToDto(likeRepository.findById(id).orElse(null));
    }

    public List<LikeDto> getAllLike(){
        List<Liked> likes = (List<Liked>) likeRepository.findAll();
        return likes.stream().map(liked -> likeMapping.convertToDto(liked)).collect(Collectors.toList());
    }

    public void deleteLike(Integer id){
        likeRepository.deleteById(id);
    }

    public void updateLike(LikeDto likeDto){
        likeRepository.save(likeMapping.convertToEntity(likeDto));
    }



}
