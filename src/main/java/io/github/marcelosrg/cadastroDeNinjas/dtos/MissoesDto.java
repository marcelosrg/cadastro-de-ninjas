package io.github.marcelosrg.cadastroDeNinjas.dtos;

import java.util.UUID;

public record MissoesDto(
        UUID id,
        String nome,
        String dificuldade
) {}