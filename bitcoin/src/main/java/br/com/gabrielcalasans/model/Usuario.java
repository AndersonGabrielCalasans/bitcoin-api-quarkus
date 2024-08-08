package br.com.gabrielcalasans.model;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@UserDefinition // Essa anotação indica que a entidade anotada é a que o framework irá utilizar para validar as informações do usuário.
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getNome() {
        return nome;
    }
}
