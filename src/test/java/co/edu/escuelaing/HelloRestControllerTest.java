package co.edu.escuelaing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloRestController.class)
public class HelloRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetingWithName() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "Diego"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Diego!"));
    }

    @Test
    public void testGreetingDefaultName() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testGreetingWithDifferentName() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "AREP"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, AREP!"));
    }
}
