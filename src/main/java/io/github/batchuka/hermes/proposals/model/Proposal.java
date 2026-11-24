package io.github.batchuka.hermes.proposals.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("proposals")
public record Proposal(
		@Id String id,
		@NotBlank String farmer,
		@NotBlank String equipment,
		@NotNull @Positive BigDecimal amount,
		@NotNull @Positive Integer termMonths,
		List<@Valid ProposalDocument> documents) {
}