package io.github.marcelosrg.cadastroDeNinjas.mappers;

import io.github.marcelosrg.cadastroDeNinjas.dtos.MissoesDto;
import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel toEntity(MissoesDto dto){

        MissoesModel missoesEntity = new MissoesModel();
        missoesEntity.setId(dto.id());
        missoesEntity.setNome(dto.nome());
        missoesEntity.setDificuldade(dto.dificuldade());
        return missoesEntity;
    }

    public MissoesDto toDto(MissoesModel entity){

        return new MissoesDto(
                entity.getId(),
                entity.getNome(),
                entity.getDificuldade()
        );
    }
}
