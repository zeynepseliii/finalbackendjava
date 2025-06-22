package com.obs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnaController {

    @GetMapping("/")
    public String anaMesaj() {
        return "Merhaba Dünya!";
    }
}

