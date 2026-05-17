package io.github.marcelosrg.cadastroDeNinjas.services;

import io.github.marcelosrg.cadastroDeNinjas.dtos.NinjaDto;
import io.github.marcelosrg.cadastroDeNinjas.exception.NotFoundException;
import io.github.marcelosrg.cadastroDeNinjas.mappers.NinjasMapper;
import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import io.github.marcelosrg.cadastroDeNinjas.model.NinjaModel;
import io.github.marcelosrg.cadastroDeNinjas.repository.MissoesRepository;
import io.github.marcelosrg.cadastroDeNinjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NinjasService {
    private final NinjaRepository ninjaRepository;
    private final MissoesRepository missoesRepository;
    private final NinjasMapper ninjasMapper;

    public NinjasService(NinjaRepository ninjaRepository,
                         NinjasMapper ninjasMapper,
                         MissoesRepository missoesRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjasMapper = ninjasMapper;
        this.missoesRepository = missoesRepository;
    }

    public List<NinjaDto> listarNinjas() {
        return ninjaRepository.findAll().stream()
                .map(ninjasMapper::toDto)
                .toList();
    }

    public NinjaDto buscarNinja(UUID id) {

        return ninjaRepository.findById(id)
                .map(ninjasMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Ninja não encontrado"));

    }

    public NinjaDto createNinja(NinjaDto ninjaDto) {
       Optional<MissoesModel> missao =  this.missoesRepository.findById(ninjaDto.missaoId());
       if(missao.isEmpty()){
           throw new IllegalArgumentException("missão não encontrada");
       }
        NinjaModel ninja = this.ninjaRepository.save(this.ninjasMapper.toEntity(ninjaDto,missao.get()));

       return this.ninjasMapper.toDto(ninja);
    }

    public NinjaDto updateNinja(UUID id, NinjaDto ninjaDto) {
        NinjaModel ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ninja não encontrado"));

        ninja.setNome(ninjaDto.nome());
        ninja.setEmail(ninjaDto.email());
        ninja.setIdade(ninjaDto.idade());
        ninja.setRank(ninjaDto.rank());
        ninja.setImg_url(ninjaDto.img_url());
        return this.ninjasMapper.toDto(ninjaRepository.save(ninja));

    }


    public NinjaDto updateMissao(UUID id, UUID missaoId) {

        NinjaModel ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ninja não encontrado"));

        MissoesModel missao = missoesRepository.findById(missaoId)
                .orElseThrow(() -> new NotFoundException("Missao não encontrado"));
        ninja.setMissao(missao);
        return this.ninjasMapper.toDto(ninjaRepository.save(ninja));

    }


    public void deleteNinja(UUID id) {
        NinjaModel ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ninja não encontrado"));

        ninjaRepository.delete(ninja);
    }




}
