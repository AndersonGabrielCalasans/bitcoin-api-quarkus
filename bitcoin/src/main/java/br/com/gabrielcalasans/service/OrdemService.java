package br.com.gabrielcalasans.service;

import br.com.gabrielcalasans.model.Ordem;
import br.com.gabrielcalasans.repository.OrdemRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@RequestScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    @Transactional
    public void inserir(Ordem ordem) {
        try{
            ordem.setData(LocalDate.now());
            ordem.setStatus("ENVIADA");
            ordemRepository.persist(ordem);
        } catch (Exception e) {
            throw new RuntimeException("Ordem não inserida", e);
        }
    }
}
