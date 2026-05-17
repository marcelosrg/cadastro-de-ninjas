package io.github.marcelosrg.cadastroDeNinjas.services;

import io.github.marcelosrg.cadastroDeNinjas.dtos.NinjaDto;
import io.github.marcelosrg.cadastroDeNinjas.mappers.NinjasMapper;
import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import io.github.marcelosrg.cadastroDeNinjas.model.NinjaModel;
import io.github.marcelosrg.cadastroDeNinjas.repository.MissoesRepository;
import io.github.marcelosrg.cadastroDeNinjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public NinjaDto createNinja(NinjaDto ninjaDto) {
       Optional<MissoesModel> missao =  this.missoesRepository.findById(ninjaDto.missaoId());
       if(missao.isEmpty()){
           throw new IllegalArgumentException("missão não encontrada");
       }
        NinjaModel ninja = this.ninjaRepository.save(this.ninjasMapper.toEntity(ninjaDto,missao.get()));

       return this.ninjasMapper.toDto(ninja);
    }




}
