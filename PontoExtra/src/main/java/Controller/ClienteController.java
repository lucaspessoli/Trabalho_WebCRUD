package Controller;

import Model.Cliente;
import Service.ClienteService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes() throws Exception{
        return Response.ok(clienteService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response salvarCliente(Cliente cliente){
        try{
            clienteService.salvar(cliente);

            return Response.status(200)
                    .entity(cliente)
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
    public Response buscarClientePorId(@PathParam("id") Integer id){
        return Response.ok(clienteService.buscarPorId(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("id") Integer id){
        try{
            clienteService.deletarCliente(id);

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
    public Response editarCliente(@PathParam("id") Integer id, Cliente cliente){
        try{
            clienteService.editarCliente(id, cliente.getNome(), cliente.getTelefone());
            return Response.status(200)
                    .entity(cliente)
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }

}
