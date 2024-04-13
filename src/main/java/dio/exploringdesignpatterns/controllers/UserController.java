package dio.exploringdesignpatterns.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @GetMapping("/teste")
    public HashMap<String, String> retornarObjeto() {

        HashMap<String, String> objeto = new HashMap<>();

        objeto.put("a", "b");

        return objeto;
    }
}
