package io.github.batchuka.hermes.proposals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.batchuka.hermes.proposals.model.Proposal;

public interface ProposalRepository extends MongoRepository<Proposal, String> {
}