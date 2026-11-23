package io.github.batchuka.hermes.proposals.model;

import java.util.Map;

public record ProposalDocument(String type, Map<String, Object> fields) {
}