package Controller;

import Model.Venda;
import Service.VendaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarVenda() throws Exception {
        return Response.ok(vendaService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response salvarVenda(Venda venda) {
        try {
            vendaService.salvar(venda);

            return Response.status(200)
                    .entity(venda)
                    .build();
        } catch (Exception e) {
            return Response.status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }

}
