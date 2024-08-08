package br.com.gabrielcalasans.resource;

import br.com.gabrielcalasans.model.Ordem;
import br.com.gabrielcalasans.service.OrdemService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/ordens")
public class OrdemResource {

    @Inject
    private OrdemService ordemService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
        ordemService.inserir(securityContext, ordem);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar() {
        return ordemService.listar();
    }
}
