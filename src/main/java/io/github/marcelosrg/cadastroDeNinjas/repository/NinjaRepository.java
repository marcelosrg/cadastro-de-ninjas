package io.github.marcelosrg.cadastroDeNinjas.repository;

import io.github.marcelosrg.cadastroDeNinjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NinjaRepository extends JpaRepository<NinjaModel, UUID> {
}
