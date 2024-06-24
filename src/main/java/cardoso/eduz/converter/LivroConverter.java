package cardoso.eduz.converter;

import cardoso.eduz.modelo.Livro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author arthur
 */
@FacesConverter(value = "livroconverter", forClass = Livro.class)
public class LivroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Livro) uiComponent.getAttributes().get(value);
        } else {
            return null;
        }   
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value instanceof Livro) {

            Livro entity = (Livro) value;

            if (entity != null && entity instanceof Livro && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
