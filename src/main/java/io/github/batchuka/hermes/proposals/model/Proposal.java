package io.github.batchuka.hermes.proposals.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("proposals")
public record Proposal(
		@Id String id,
		String farmer,
		String equipment,
		BigDecimal amount,
		int termMonths) {
}