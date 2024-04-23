package Repository;

import Model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listarClientes(){
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscarPorId(Integer id){
        try{
            return em.find(Cliente.class, id);
        }catch (Exception e){
            return null;
        }
    }

    public void cadastrar(Cliente cliente) throws Exception{
        try{
            em.persist(cliente);
        }catch(Exception e){
            throw new Exception("Cliente não pôde ser cadastrado! " + e.getMessage());
        }
    }

    public void deletar(Integer id) throws Exception{
        try{
            Cliente cliente = em.find(Cliente.class, id);

            em.remove(cliente);
        }catch (Exception e){
            throw new Exception("Cliente não pôde ser deletado!" + e.getMessage());
        }
    }

    public void editarCliente(Cliente cliente, Integer id) throws Exception{
        try{
            Cliente clienteEditado = em.find(Cliente.class, id);

            if(clienteEditado != null){
                clienteEditado.setNome(cliente.getNome());
                clienteEditado.setTelefone(cliente.getTelefone());
                em.merge(clienteEditado);
            }else{
                throw new Exception("O ID está nulo");
            }
        }catch(Exception e){
            throw new Exception("Erro ao editar cliente: " + e.getMessage());
        }
    }
}
