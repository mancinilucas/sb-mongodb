package com.mancinilucas.sbmongo.services;

import com.mancinilucas.sbmongo.domain.Post;
import com.mancinilucas.sbmongo.repository.PostRepository;
import com.mancinilucas.sbmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchByTitle(text);
    }

}
