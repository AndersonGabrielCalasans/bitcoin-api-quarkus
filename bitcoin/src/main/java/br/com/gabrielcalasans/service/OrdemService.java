package br.com.gabrielcalasans.service;

import br.com.gabrielcalasans.model.Ordem;
import br.com.gabrielcalasans.model.Usuario;
import br.com.gabrielcalasans.repository.OrdemRepository;
import br.com.gabrielcalasans.repository.UsuarioRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Transactional
    @RolesAllowed("user") // Só dá permissão de enviar uma ordem caso a role seja user
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
    // @Context SecurityContext retorna os dados de sessão do usuário

        // Verifica se o usuáio logado é o mesmo do usuário passado na ordem
        Optional<Usuario> usuarioOptional = usuarioRepository.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();

        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new RuntimeException("O usuário logado é diferente do userId");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    @RolesAllowed("admin")
    public List<Ordem> listar() {
        return ordemRepository.listAll();
    }
}
