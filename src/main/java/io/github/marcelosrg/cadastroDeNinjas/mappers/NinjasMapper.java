package io.github.marcelosrg.cadastroDeNinjas.mappers;

import io.github.marcelosrg.cadastroDeNinjas.dtos.NinjaDto;
import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import io.github.marcelosrg.cadastroDeNinjas.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjasMapper{

    public NinjaModel toEntity(NinjaDto dto, MissoesModel missoesModel){

        NinjaModel ninjaEntity = new NinjaModel();
        ninjaEntity.setId(dto.id());
        ninjaEntity.setNome(dto.nome());
        ninjaEntity.setEmail(dto.email());
        ninjaEntity.setIdade(dto.idade());
        ninjaEntity.setImg_url(dto.img_url());
        ninjaEntity.setRank(dto.rank());
        ninjaEntity.setMissao(missoesModel);

        return ninjaEntity;
    }

    public NinjaDto toDto(NinjaModel entity){

        return new NinjaDto(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getIdade(),
                entity.getImg_url(),
                entity.getRank(),
                entity.getMissao().getId()
        );
    }
}
