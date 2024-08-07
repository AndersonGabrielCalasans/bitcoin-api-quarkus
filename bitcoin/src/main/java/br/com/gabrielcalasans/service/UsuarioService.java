package br.com.gabrielcalasans.service;

import br.com.gabrielcalasans.model.Usuario;
import br.com.gabrielcalasans.repository.UsuarioRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RequestScoped
@RegisterRestClient(configKey = "service-api")

public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    // Faz a persistencia de uma usuario no banco
    // Caso erro, o @Transactional faz rollback
    @Transactional
    public void inserir(Usuario usuario) {
        try{
            usuarioRepository.persist(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar usuário", e);
        }
    }
}
