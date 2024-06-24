
package cardoso.eduz.utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author cardoso
 */

public class Message {
    public static void mensagem(String nome){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nome ));
    }
}
