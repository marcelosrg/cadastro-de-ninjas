package io.github.marcelosrg.cadastroDeNinjas.services;


import io.github.marcelosrg.cadastroDeNinjas.dtos.MissoesDto;
import io.github.marcelosrg.cadastroDeNinjas.mappers.MissoesMapper;
import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import io.github.marcelosrg.cadastroDeNinjas.repository.MissoesRepository;
import org.springframework.stereotype.Service;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDto create(MissoesDto missoesDto) {
       MissoesModel create = this.missoesRepository.save(missoesMapper.toEntity(missoesDto));


       return this.missoesMapper.toDto(create);
    }
}
