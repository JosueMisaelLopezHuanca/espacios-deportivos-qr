package com.espaciosdeportivos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioControlDTO {

    private Long idUsControl;
    private LocalDate fechaNacimiento;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String telefono;
    private String email;
    private String ci;
    private String estadoOperativo;
    private LocalDateTime horaInicioTurno;
    private LocalDateTime horaFinTurno;
    private String direccion;

    public UsuarioControlDTO() {}

    public Long getIdUsControl() {
        return idUsControl;
    }

    public void setIdUsControl(Long idUsControl) {
        this.idUsControl = idUsControl;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(String estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public LocalDateTime getHoraInicioTurno() {
        return horaInicioTurno;
    }

    public void setHoraInicioTurno(LocalDateTime horaInicioTurno) {
        this.horaInicioTurno = horaInicioTurno;
    }

    public LocalDateTime getHoraFinTurno() {
        return horaFinTurno;
    }

    public void setHoraFinTurno(LocalDateTime horaFinTurno) {
        this.horaFinTurno = horaFinTurno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
