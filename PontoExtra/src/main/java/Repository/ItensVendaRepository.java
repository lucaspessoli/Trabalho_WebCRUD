package Repository;

import Model.ItensVenda;
import Model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ItensVendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public void cadastrar(ItensVenda itensVenda) throws Exception{
        try{
            em.persist(itensVenda);
        }catch(Exception e){
            throw new Exception("Itens Venda não pôde ser cadastrada! " + e.getMessage());
        }
    }
}
