package com.espaciosdeportivos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invitado")
@PrimaryKeyJoinColumn(name = "id_invitado")
public class Invitado extends Persona {

    @Column(name = "verificado", nullable = false)
    private Boolean verificado;

    public Invitado() {}

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }
}
