package io.github.marcelosrg.cadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/ninjas/")
public class NinjaController {

    @GetMapping
    public String boasVindas(){
        return("Charice danada");
    }

}
