/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofesores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 */
public class ArchivoProfesores {

    Path archivo;

    public ArchivoProfesores(Path archivo) {
        if (archivo != null) {
            this.archivo = archivo;
        } else {
            throw new RuntimeException("No hay archivo");
        }
    }

    ArchivoProfesores() {

    }

    public boolean guardarProfesores(List<Profesor> listaProfesores) {
        boolean res = true;
        try (ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(archivo.toFile()))) {
            for (Profesor p : listaProfesores) {
                s.writeObject(p);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoProfesores.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProfesores.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
        }
        return res;
    }

    public List<Profesor> mostrarProfesores(String dept) {

        List<Profesor> listaFinal = new ArrayList();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo.toFile()))) {
            Profesor prof;
            while ((prof = (Profesor) entrada.readObject()) != null) {
                if (prof.getDepartamento().equalsIgnoreCase(dept)) {
                    listaFinal.add(prof);
                }
            }

        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return listaFinal;

    }

    public boolean clasificarProfesores(int edad) {
        List<Profesor> lista = new ArrayList();
        boolean res=true;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo.toFile()));
                ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(archivo.toFile()));) {
            Profesor p = null;
            while ((p = (Profesor) entrada.readObject()) != null) {
                if (p.getEdad() >= edad) {
                    lista.add(p);
                    s.writeObject(p);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ArchivoProfesores.class.getName()).log(Level.SEVERE, null, ex);
            res=false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoProfesores.class.getName()).log(Level.SEVERE, null, ex);
            res=false;
        }
       return res; 
    }
}
