package io.github.marcelosrg.cadastroDeNinjas.controller;

import io.github.marcelosrg.cadastroDeNinjas.dtos.MissoesDto;
import io.github.marcelosrg.cadastroDeNinjas.services.MissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/missoes")
public class MissoesController {

    private final MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping
    public ResponseEntity<MissoesDto> createMissoes(@RequestBody MissoesDto missoesDto) {

        this.missoesService.create(missoesDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(missoesDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
