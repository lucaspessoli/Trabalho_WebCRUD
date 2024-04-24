package Repository;

import Model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class VendaRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Venda> listarVendas(){
        String jpql = "SELECT v FROM Venda v";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public void cadastrar(Venda venda) throws Exception{
        try{
            em.persist(venda);
        }catch(Exception e){
            throw new Exception("Venda não pôde ser cadastrada! " + e.getMessage());
        }
    }
}
