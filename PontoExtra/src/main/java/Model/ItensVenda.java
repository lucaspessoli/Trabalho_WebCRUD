package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class ItensVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double valorUnitario;

    @Column
    private Double valorTotal;

    @Column
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fk_venda_id")
    private Venda venda;
}
