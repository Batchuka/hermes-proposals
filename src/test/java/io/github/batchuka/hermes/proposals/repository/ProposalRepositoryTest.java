package io.github.batchuka.hermes.proposals.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;

import io.github.batchuka.hermes.proposals.model.Proposal;
import io.github.batchuka.hermes.proposals.model.ProposalDocument;

@DataMongoTest
@Testcontainers
class ProposalRepositoryTest {

	@Container
	@ServiceConnection
	static MongoDBContainer mongo = new MongoDBContainer("mongo:8");

	@Autowired
	ProposalRepository repository;

	@Test
	void savesAProposalWithADocumentOfATypeNobodyHasSeen() {
		var document = new ProposalDocument("never-seen", Map.of("anything", "works"));
		var proposal = new Proposal(null, "Joao Silva", "Trator 6110J", new BigDecimal("450000.00"), 48, List.of(document));

		var saved = repository.save(proposal);
		var found = repository.findById(saved.id()).orElseThrow();

		assertThat(found.documents()).hasSize(1);
		assertThat(found.documents().get(0).type()).isEqualTo("never-seen");
		assertThat(found.documents().get(0).fields()).containsEntry("anything", "works");
	}
}