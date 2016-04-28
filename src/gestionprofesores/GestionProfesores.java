/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofesores;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class GestionProfesores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profesor p1=new Profesor("Pedro","123141","FOL",34);
        Profesor p2=new Profesor("Maria","123141123","PRG",26);
        Profesor p3=new Profesor("Jose","123141123","BDS",40);
        Profesor p4=new Profesor("Luis","123141132","LJM",60);
        Profesor p5=new Profesor("Juan","1231411231","EDD",37);
        Profesor p6=new Profesor("ROsa","1231411231","FOL",37);
        
        List<Profesor>listaProfesores=new ArrayList();
         
        listaProfesores.add(p1);
        listaProfesores.add(p2);
        listaProfesores.add(p3);
        listaProfesores.add(p4);
        listaProfesores.add(p5);
        listaProfesores.add(p6);
         
         
         
         
         ArchivoProfesores gestion= new ArchivoProfesores(Paths.get("listaProfesores.dat"));
         
         gestion.guardarProfesores(listaProfesores);
         
         System.out.println(gestion.mostrarProfesores("FOL"));
         System.out.println(gestion.mostrarProfesores("FOL").size());
         System.out.println(gestion.mostrarProfesores("BDS"));
         System.out.println(gestion.clasificarProfesores(39));
         
    }
    
}
