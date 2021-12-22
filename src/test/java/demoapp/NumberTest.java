package demoapp;

import demoapp.service.NumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NumberTest {
    @Autowired
    NumberService numero;

    @Test
    public void contexLoads() throws Exception {
        assertThat(numero).isNotNull();
    }

    @Test
    public void serviceNumber1() throws Exception {
        assertThat(numero.number(2)).isEqualTo("El numero 2 es par");
    }

    @Test
    public void serviceNumber2() throws Exception {
        assertThat(numero.number(3)).isEqualTo("El numero 3 no es par");
    }

    @Test
    public void serviceNumber3() throws Exception {
        assertThat(numero.number(0)).isEqualTo("Tiene que ser un número mayor que 0");
    }
}
