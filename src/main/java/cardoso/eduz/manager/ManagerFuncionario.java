package cardoso.eduz.manager;

import cardoso.eduz.modelo.Funcionario;
import cardoso.eduz.servico.FuncionarioServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cardoso
 */
@Named
@ViewScoped
public class ManagerFuncionario implements Serializable {
    
    @EJB
    FuncionarioServico funcionarioServico;
    
    private Funcionario funcionario;
    
    @PostConstruct
    public void instanciar(){
        funcionario = new Funcionario();
    }
}
