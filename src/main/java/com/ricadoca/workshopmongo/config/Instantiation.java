package com.ricadoca.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricadoca.workshopmongo.domain.Post;
import com.ricadoca.workshopmongo.domain.User;
import com.ricadoca.workshopmongo.dto.AuthorDTO;
import com.ricadoca.workshopmongo.repository.PostRepository;
import com.ricadoca.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1  = new Post(null, sdf1.parse("21/03/2018"), "Partiu Viagem",
				"Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		
		Post post2 = new Post(null, sdf1.parse("23/03/2018"), "Bom Dia",  "Acordei feliz hoje!",
				new AuthorDTO(maria));

		
		
		postRepo.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepo.save(maria);
	}

}
