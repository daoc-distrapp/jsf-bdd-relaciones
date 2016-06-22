
package code;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alumnos
 */
@ManagedBean
public class MbBdd implements Serializable {
    
    @EJB
    private EjbBdd bdd;
    
    private Autor autor;
    private Libro libro;
    private Cantante cantante;
    private Cd cd;
    
    private int autorId;
    
    public MbBdd() {
        autor = new Autor();
        libro = new Libro();
        cantante = new Cantante();
        cd = new Cd();
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
    
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }    
    public List<Autor> autores() {
        return bdd.todosAutor();
    }
    public String crearAutor() {
        bdd.nuevo(autor);
        return null;
    }

    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public String crearLibro() {
        autor = bdd.getAutorById(autorId);
        bdd.nuevo(libro, autor);
        return null;
    }    

    public Cantante getCantante() {
        return cantante;
    }
    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }
    public List<Cantante> cantantes() {
        return bdd.todosCantante();
    }
    public String crearCantante() {
        bdd.nuevo(cantante);
        return null;
    } 
    
    public Cd getCd() {
        return cd;
    }
    public void setCd(Cd cd) {
        this.cd = cd;
    }
    public List<Cd> cds() {
        return bdd.todosCd();
    }    
    public String crearCd() {
        bdd.nuevo(cd);
        return null;
    }
    
    public String cantanteCd() {
        bdd.nuevo(cantante, cd);
        return null;
    }
    
    public String getLibrosDeAutor() {
        autor = bdd.getAutorById(autorId);
        return null;
    }
    
}
