package br.com.gabrielcalasans.resource;

import br.com.gabrielcalasans.model.Usuario;
import br.com.gabrielcalasans.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    private UsuarioService usuarioService;

    // Encaminha a inserção para a classe service atraves de uma requisicao POST
    // consumindo no formato json
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        usuarioService.inserir(usuario);
    }
}
