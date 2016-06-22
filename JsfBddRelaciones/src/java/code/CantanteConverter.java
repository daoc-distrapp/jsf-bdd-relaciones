
package code;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author dordonez
 */

@ManagedBean
public class CantanteConverter implements Converter {
    @EJB
    EjbBdd bdd;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null) return null;
        return bdd.getCantanteById(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) return null;
        return ((Cantante)value).getId().toString();
    }
    
}
