/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofesores;

import java.io.Serializable;

/**
 *nif, su nombre, la departamento y su edad.
 *Incluye un método toString() que concatene todos los atributos y lo muestre por pantalla. 
 * @author daw1
 */
public class Profesor implements Serializable{
    private String nombre;
    private String dni;
    private String departamento;
    private int edad;

    public Profesor(String nombre, String dni, String departamento, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.departamento = departamento;
        this.edad = edad;
    }
    
    public Profesor(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: "+ nombre +".\n"+
               "Dni:"+dni+".\n"+
               "Departamento:"+".\n"+
               "Edad:"+ edad;    
    }
}
