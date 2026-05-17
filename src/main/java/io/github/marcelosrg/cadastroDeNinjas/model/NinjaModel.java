package io.github.marcelosrg.cadastroDeNinjas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "ninjas")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = true, name ="img_url")
    private String img_url;

    @Column(nullable = false,name = "rank")
    private String rank;

    // @ManyToOne - muitos ninja podem ter apenas uma missao
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="missoes_id") //foreing Key
    private MissoesModel missao;
}
