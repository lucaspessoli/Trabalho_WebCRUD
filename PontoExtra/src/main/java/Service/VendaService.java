package Service;

import Model.ItensVenda;
import Model.Venda;
import Repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {

    @Inject
    private VendaRepository vendaRepository;

    @Inject
    private ItensVendaService itensVendaService;

    public List<Venda> listar() throws Exception {
        return vendaRepository.listarVendas();
    }


    public void salvar(Venda venda) throws Exception {
        vendaRepository.cadastrar(venda);

        for (ItensVenda itens : venda.getLista()) {
            itensVendaService.salvar(itens);
        }
    }

}
