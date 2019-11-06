/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otras_Clases;

/**
 *
 * @author dilan
 */
public class Usuario {
    private int Carne;
    private String nombre;
    private boolean activo;

    public Usuario(int Carne, String nombre, boolean activo) {
        this.Carne = Carne;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getCarne() {
        return Carne;
    }

    public void setCarne(int Carne) {
        this.Carne = Carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Carne=" + Carne + ", nombre=" + nombre + ", activo=" + activo + '}';
    }
    
    
    
}
