package com.mancinilucas.sbmongo.config;

import com.mancinilucas.sbmongo.domain.Post;
import com.mancinilucas.sbmongo.domain.User;
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

        Post p1 = new Post(null, sdf.parse("21/03/2023"), "Partiu Maruin", "Vou ali ver Ddog!", maria);
        Post p2 = new Post(null, sdf.parse("10/04/2023"), "Partiu Capelinha", "Vou ali visitar Aline!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(p1,p2));
    }
}
