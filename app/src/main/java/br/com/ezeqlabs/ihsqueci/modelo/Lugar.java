package br.com.ezeqlabs.ihsqueci.modelo;

import java.io.Serializable;

public class Lugar implements Serializable {
    private Long id;
    private String nome;
    private String trouxe;
    private String endereco;
    private double latitude;
    private double longitude;


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

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
