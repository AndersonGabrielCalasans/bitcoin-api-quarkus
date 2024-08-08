package br.com.gabrielcalasans.service;

import br.com.gabrielcalasans.model.Usuario;
import br.com.gabrielcalasans.repository.UsuarioRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "service-api")
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    // Faz a persistencia de uma usuario no banco
    // Caso erro, o @Transactional faz rollback
    @Transactional
    public void inserir(Usuario usuario) {
        try {
            usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
            usuario.setRole(validarUsername(usuario.getUsername()));
            usuarioRepository.persist(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar usuário", e);
        }
    }

    private static String validarUsername(String username) {
        if (username.equals("gabriel")) {
            return "admin";
        }
        return "user";
    }

    @RolesAllowed("admin")
    public List<Usuario> listar() {
        return usuarioRepository.listAll();
    }
}
