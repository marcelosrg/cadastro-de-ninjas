package io.github.marcelosrg.cadastroDeNinjas.repository;

import io.github.marcelosrg.cadastroDeNinjas.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissoesRepository extends JpaRepository<MissoesModel, UUID> {
}
