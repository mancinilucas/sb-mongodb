package com.mancinilucas.sbmongo.config;

import com.mancinilucas.sbmongo.domain.Post;
import com.mancinilucas.sbmongo.domain.User;
import com.mancinilucas.sbmongo.dto.AuthorDTO;
import com.mancinilucas.sbmongo.dto.CommentDTO;
import com.mancinilucas.sbmongo.repository.PostRepository;
import com.mancinilucas.sbmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2023"), "Partiu Maruin", "Vou ali ver Ddog!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("10/04/2023"), "Partiu Capelinha", "Vou ali visitar Aline!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2023"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveita pra ver Vitória!", sdf.parse("21/03/2023"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("21/03/2023"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p2));
        userRepository.save(maria);
    }
}
