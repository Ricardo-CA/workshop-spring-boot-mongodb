package com.ricadoca.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricadoca.workshopmongo.domain.Post;
import com.ricadoca.workshopmongo.repository.PostRepository;
import com.ricadoca.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


	public List<Post> findByTittle(String text) {
		return postRepository.searchTitle(text);
	}
}
