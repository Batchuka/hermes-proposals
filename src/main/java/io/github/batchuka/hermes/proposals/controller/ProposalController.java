package io.github.batchuka.hermes.proposals.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

import io.github.batchuka.hermes.proposals.model.Proposal;
import io.github.batchuka.hermes.proposals.repository.ProposalRepository;


@RestController
@RequestMapping("/proposals")
public class ProposalController {

	private final ProposalRepository repository;


	public ProposalController(ProposalRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Proposal> list() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proposal> get(@PathVariable String id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Proposal create(@Valid @RequestBody Proposal proposal) {
		return repository.save(proposal);
	}
}