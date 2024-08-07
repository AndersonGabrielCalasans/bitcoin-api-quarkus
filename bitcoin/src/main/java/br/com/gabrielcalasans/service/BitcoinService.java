package br.com.gabrielcalasans.service;

import br.com.gabrielcalasans.model.Bitcoin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

// Aqui ele informa que quando chamar a interface ele vai usar o recurso /bitcoin e que o serviço pode ser injetado em algum lugar
@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {

    // Informa que o método é uma requisição GET e produz um retorno do tipo Json
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar();
}
