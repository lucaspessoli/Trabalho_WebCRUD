package Model;


import jakarta.persistence.*;
import jdk.incubator.foreign.CLinker;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double total;

    @Column
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", orphanRemoval = true)
    @JoinColumn(name = "venda_id")
    private List<ItensVenda> lista;
}
