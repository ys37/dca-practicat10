package demoapp;

import demoapp.service.NumberService;
import demoapp.NumberForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebNumberMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void numeroMessage() throws Exception {
        this.mockMvc.perform(get("/numberplantilla"))
                .andExpect(status().isOk());
    }

    // Mockear el servicio
    @MockBean
    private NumberService service;

    @Test
    public void numberShouldReturnMessageFromService1() throws Exception {
        NumberForm n = new NumberForm();
        n.setNum(2);
        when(service.number(n.getNum())).thenReturn("El numero 2 es par");

        this.mockMvc.perform(get("/numberplantilla"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teclée un número:")));
    }

    @Test
    public void numberShouldReturnMessageFromService2() throws Exception {
        NumberForm n = new NumberForm();
        n.setNum(3);
        when(service.number(n.getNum())).thenReturn("El numero 3 es impar");

        this.mockMvc.perform(get("/numberplantilla"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teclée un número:")));
    }
}
