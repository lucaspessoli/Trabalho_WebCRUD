package Service;

import Model.Produto;
import Repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ProdutoService {
    @Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() throws Exception{
        return produtoRepository.listarProdutos();
    }

    public void salvar(Produto produto) throws Exception{
        produtoRepository.cadastrar(produto);
    }

    public Produto buscarPorId(Integer id){
        return produtoRepository.buscarPorID(id);
    }

    public void deletarProduto(Integer id) throws Exception{
        produtoRepository.deletarProduto(id);
    }

    public void editarProduto(Integer id, Produto produto) throws Exception{
        produtoRepository.editarProduto(produto);
    }
}
