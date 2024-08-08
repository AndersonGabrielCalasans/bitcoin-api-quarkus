package br.com.gabrielcalasans.resource;

import br.com.gabrielcalasans.model.Ordem;
import br.com.gabrielcalasans.model.Usuario;
import br.com.gabrielcalasans.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
}
