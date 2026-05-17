package io.github.marcelosrg.cadastroDeNinjas.controller;

import io.github.marcelosrg.cadastroDeNinjas.dtos.NinjaDto;
import io.github.marcelosrg.cadastroDeNinjas.services.NinjasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ninjas")
public class NinjaController {

    public final NinjasService ninjasService;
    public NinjaController(NinjasService ninjasService) {
        this.ninjasService = ninjasService;
    }

    @GetMapping
    public ResponseEntity<List<NinjaDto>> findAll() {
        List<NinjaDto> ninjas = this.ninjasService.listarNinjas();

        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaDto> findById(@PathVariable  UUID id) {
        NinjaDto ninja = this.ninjasService.buscarNinja(id);
        return ResponseEntity.ok(ninja);
    }

   @PostMapping
    public ResponseEntity<NinjaDto> ninja(@RequestBody NinjaDto ninjaDto) {
       this.ninjasService.createNinja(ninjaDto);

       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(ninjaDto.id())
               .toUri();
       return ResponseEntity.created(location).body(ninjaDto);
   }


   @PutMapping("/{id}")
    public ResponseEntity<NinjaDto> update(@PathVariable UUID id, @RequestBody NinjaDto ninjaDto) {
        this.ninjasService.updateNinja(id, ninjaDto);

       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(ninjaDto.id())
               .toUri();
       return ResponseEntity.created(location).body(ninjaDto);
   }

   @PatchMapping("/{id}")
    public ResponseEntity<NinjaDto> updateMissao(@PathVariable UUID id, @RequestBody UUID idMissao) {
       NinjaDto updateMisao = this.ninjasService.updateMissao(id, idMissao);
       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(updateMisao.id())
               .toUri();
       return ResponseEntity.created(location).body(updateMisao);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<NinjaDto> deleteNinja(@PathVariable UUID id) {
        this.ninjasService.deleteNinja(id);
        return  ResponseEntity.noContent().build();

   }

}
