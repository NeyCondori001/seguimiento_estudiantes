package com.emergentes.bean;

import com.emergentes.entidades.Estudiante;
import com.emergentes.jpa.EstudianteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanEstudiante {
    private EntityManagerFactory emf;
    private EstudianteJpaController jpaEstudiante;

    public BeanEstudiante() {
        emf = Persistence.createEntityManagerFactory("UPestudiante");
        jpaEstudiante = new EstudianteJpaController(emf);
    }
    
    public List<Estudiante> listarTodos(){
        return jpaEstudiante.findEstudianteEntities();
    }
    
    public void insertar (Estudiante c) {
        jpaEstudiante.create(c);
    }
    public void editar(Estudiante c) {
        try {
            jpaEstudiante.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaEstudiante.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Estudiante buscar(Integer id)
    {
        Estudiante c = new Estudiante();
        c = jpaEstudiante.findEstudiante(id);
        return c;
    }
}
