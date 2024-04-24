package Service;

import Model.Cliente;
import Repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {
    @Inject
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() throws Exception{
        return clienteRepository.listarClientes();
    }

    public void salvar(Cliente cliente) throws Exception{
        clienteRepository.cadastrar(cliente);
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepository.buscarPorId(id);
    }

    public void deletarCliente(Integer id) throws Exception{
        clienteRepository.deletar(id);
    }

    public void editarCliente(Integer id, String nome, String telefone) throws Exception{
        Cliente clienteAtualizado = new Cliente();


        if (nome != null) {
            clienteAtualizado.setNome(nome);
        }

        if (telefone != null) {
            clienteAtualizado.setTelefone(telefone);
        }

        clienteRepository.editarCliente(clienteAtualizado, id);
    }
}
