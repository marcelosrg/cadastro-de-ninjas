package io.github.marcelosrg.cadastroDeNinjas.controller;

import io.github.marcelosrg.cadastroDeNinjas.dtos.NinjaDto;
import io.github.marcelosrg.cadastroDeNinjas.services.NinjasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/ninjas/")
public class NinjaController {

    public final NinjasService ninjasService;
    public NinjaController(NinjasService ninjasService) {
        this.ninjasService = ninjasService;
    }

   @PostMapping
    public ResponseEntity<NinjaDto> ninja(@RequestBody NinjaDto ninjaDto) {
       this.ninjasService.createNinja(ninjaDto);

       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(ninjaDto.id())
               .toUri();

       return ResponseEntity.created(location).build();

   }

}
