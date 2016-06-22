
package code;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alumnos
 */
@Stateless
public class EjbBdd {
    
    @PersistenceContext(unitName="JsfBddPU")
    EntityManager em;
    
    public void nuevo(Autor autor) {
        em.persist(autor);
    }
    public void nuevo(Libro libro, Autor autor) {
        libro.setAutor(autor);
        autor.getLibros().add(libro);
        em.persist(libro);
        em.merge(autor);
    }
    public void nuevo(Cantante cantante) {
        em.persist(cantante);
    }    
    public void nuevo(Cd cd) {
        em.persist(cd);
    }
    public void nuevo(Cantante cantante, Cd cd) {
        cantante.getCds().add(cd);
        cd.getCantantes().add(cantante);
        em.merge(cantante);
        em.merge(cd);
    }
    
    public List<Autor> todosAutor() {
        Query q = em.createNamedQuery("autores");
        return q.getResultList();
    }
    public List<Cantante> todosCantante() {
        Query q = em.createNamedQuery("cantantes");
        return q.getResultList();
    }    
    public List<Cd> todosCd() {
        Query q = em.createNamedQuery("cds");
        return q.getResultList();
    }    
    
    public Autor getAutorById(int id) {
        return em.find(Autor.class, id);
    }
    public Cantante getCantanteById(String id) {
        return em.find(Cantante.class, Long.parseLong(id));
    }  
    public Cd getCdById(String id) {
        return em.find(Cd.class, Long.parseLong(id));
    }    
}
