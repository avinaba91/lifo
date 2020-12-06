package com.stack.lifo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = LifoApplication.class)
@ActiveProfiles("test")
public class StackControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPush() throws Exception {
		this.mockMvc.perform(post("/stack/push/67895")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("67895")));
	}
	
	@Test
	public void testPop() throws Exception {
		this.mockMvc.perform(post("/stack/push/15")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(delete("/stack/pop")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("15")));
	}
}
