package com.example.tpuserpostcommentlike.service;

import com.example.tpuserpostcommentlike.Mapping.PostMapping;
import com.example.tpuserpostcommentlike.dto.PostDto;
import com.example.tpuserpostcommentlike.entity.Post;
import com.example.tpuserpostcommentlike.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapping postMapping;

    public PostDto createPost(Post post){
        Post postCreated = postRepository.save(post);
        return postMapping.convertToDto(postCreated);
    }

    public PostDto getPostById(Integer id){
        return postMapping.convertToDto(postRepository.findById(id).orElse(null));
    }

    public List<PostDto> getAllPost(){
       List<Post> posts = (List<Post>) postRepository.findAll();
       return posts.stream().map(post -> postMapping.convertToDto(post)).collect(Collectors.toList());
    }

    public void updatePost(PostDto dto){
        postRepository.save(postMapping.convertToEntity(dto));
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }


}
