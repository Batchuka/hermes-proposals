package io.github.batchuka.hermes.proposals.model;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;

public record ProposalDocument(@NotBlank String type, Map<String, Object> fields) {
}