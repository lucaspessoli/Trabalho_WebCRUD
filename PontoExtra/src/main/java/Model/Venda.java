package Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Venda implements Serializable {

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
    private List<ItensVenda> lista;
}
