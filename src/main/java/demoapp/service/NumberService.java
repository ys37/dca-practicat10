package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public String number(Integer num) {
        if (num > 0) {
            if (num % 2 == 0) {
                return "El numero " + num + " es par";
            } else {
                return "El numero " + num + " no es par";
            }
        } else {
            return "Tiene que ser un número mayor que 0";
        }

    }


}
