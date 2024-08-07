package br.com.gabrielcalasans.resource;

import br.com.gabrielcalasans.model.Bitcoin;
import br.com.gabrielcalasans.service.BitcoinService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

//Endpoint de saída da minha api, embora tenha o mesmo nome em BitcoinService, são diferentes
//no BitcoinService ele faz a chamada para API externa
@Path("/bitcoins")
public class BitcoinResource {

//    Aqui, BitcoinService é uma interface que define os métodos para chamar endpoints REST,
//    e a anotação @RestClient indica que uma implementação dessa interface deve ser injetada.
    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar() {
        return bitcoinService.listar();
    }

}
