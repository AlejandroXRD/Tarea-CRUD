/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author AlejandroXRD
 */
public class Participante {
    private String nombres;
    private String apellidos;
    private String ci;
    private String direccion;

    public Participante() {
        this.nombres = "";
        this.apellidos = "";
        this.ci = "";
        this.direccion = "";
    }

    public Participante(String nombres, String apellidos, String ci, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.direccion = direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCi() {
        return ci;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
