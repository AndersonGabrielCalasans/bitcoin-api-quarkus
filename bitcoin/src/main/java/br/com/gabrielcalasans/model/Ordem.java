package br.com.gabrielcalasans.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;

    private String tipo;

    private LocalDate data;

    private String status;

    @Column(name = "user_id")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
