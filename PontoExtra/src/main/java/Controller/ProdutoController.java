package Controller;

import Model.Cliente;
import Model.Produto;
import Service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProdutos() throws Exception {
        return Response.ok(produtoService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response salvarProduto(Produto produto){
        try{
            produtoService.salvar(produto);

            return Response.status(200)
                    .entity(produto)
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarProdutoPorId(@PathParam("id") Integer id){
        return Response.ok(produtoService.buscarPorId(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarProduto(@PathParam("id") Integer id){
        try{
            produtoService.deletarProduto(id);

            return Response.status(200)
                    .entity("deletado com sucesso!")
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarProduto(@PathParam("id") Integer id, Produto produto){
        try{
            produtoService.editarProduto(id, produto);
            return Response.status(200)
                    .entity(produto)
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
