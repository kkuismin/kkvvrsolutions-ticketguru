package kkvvsolutions.TicketGuru;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class TicketGuruIntegrationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	//Test API Status
	@Test
	public void apiStatusOk() throws Exception {
		mockMvc.perform(get("/api/")).andExpect(status().isOk());
	}
	
	//Index ("/") Content Type Test
	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
				.andExpect(status().isOk());
	}
	
	//Try to get ticket without authorization
	 @Test
	    public void testTicketUnauthorized() throws Exception {
	        mockMvc.perform(get("/api/tickets/1"))
	                .andExpect(status().isUnauthorized());
	    }

}
