package br.com.gabrielcalasans.resource;

import br.com.gabrielcalasans.model.Ordem;
import br.com.gabrielcalasans.service.OrdemService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/ordens")
public class OrdemResource {

    @Inject
    private OrdemService ordemService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Ordem ordem) {
        ordemService.inserir(ordem);
    }
}
