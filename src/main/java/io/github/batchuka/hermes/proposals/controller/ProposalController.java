package io.github.batchuka.hermes.proposals.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import io.github.batchuka.hermes.proposals.model.Proposal;
import io.github.batchuka.hermes.proposals.repository.ProposalRepository;

@RestController
public class ProposalController {

	private final ProposalRepository repository;


	public ProposalController(ProposalRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/proposals")
	public Proposal create(@Valid @RequestBody Proposal proposal) {
		return repository.save(proposal);
	}
}