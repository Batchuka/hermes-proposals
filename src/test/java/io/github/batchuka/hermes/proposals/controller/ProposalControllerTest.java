package io.github.batchuka.hermes.proposals.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import io.github.batchuka.hermes.proposals.repository.ProposalRepository;

@WebMvcTest(ProposalController.class)
class ProposalControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	ProposalRepository repository;

	@Test
	void anEmptyProposalIsRejectedAndNothingIsSaved() throws Exception {
		mockMvc.perform(post("/proposals").contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.fields.farmer").exists())
				.andExpect(jsonPath("$.fields.termMonths").exists());

		verifyNoInteractions(repository);
	}

	@Test
	void anUnknownIdIsNotFound() throws Exception {
		given(repository.findById("nope")).willReturn(Optional.empty());

		mockMvc.perform(get("/proposals/nope")).andExpect(status().isNotFound());
	}
}