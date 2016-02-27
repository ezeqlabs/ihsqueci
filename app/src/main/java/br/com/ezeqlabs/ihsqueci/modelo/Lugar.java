package br.com.ezeqlabs.ihsqueci.modelo;

import java.io.Serializable;

public class Lugar implements Serializable {
    private Long id;
    private String nome;
    private String trouxe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTrouxe() {
        return trouxe;
    }

    public void setTrouxe(String trouxe) {
        this.trouxe = trouxe;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
