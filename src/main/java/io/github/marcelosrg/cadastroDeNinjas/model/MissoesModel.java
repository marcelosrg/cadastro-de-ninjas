package io.github.marcelosrg.cadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "missoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dificuldade;

    //@OneToMany -> uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missao",cascade = CascadeType.ALL)
    private List<NinjaModel> ninjas;

}
