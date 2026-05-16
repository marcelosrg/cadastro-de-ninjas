package io.github.marcelosrg.cadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "missoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String dificuldade;

    //@OneToMany -> uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes",cascade = CascadeType.ALL)
    private List<NinjaModel> ninjas;

}
