package Service;

import Model.ItensVenda;
import Repository.ItensVendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ItensVendaService {

    @Inject
    private ItensVendaRepository itensVendaRepository;

    public void salvar(ItensVenda itensVenda) throws Exception {
        itensVendaRepository.cadastrar(itensVenda);
    }
}
