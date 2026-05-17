package io.github.marcelosrg.cadastroDeNinjas.dtos;

import java.util.UUID;

public record NinjaDto(
        UUID id,
        String nome,
        String email,
        int idade,
        String img_url,
        String rank,
        UUID missaoId
) {}