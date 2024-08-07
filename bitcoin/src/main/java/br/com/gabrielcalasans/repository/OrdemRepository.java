package br.com.gabrielcalasans.repository;

import br.com.gabrielcalasans.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
}
