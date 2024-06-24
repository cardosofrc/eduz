package cardoso.eduz.servico;

import cardoso.eduz.genericos.ServicoGenerico;
import cardoso.eduz.modelo.Funcionario;
import javax.ejb.Stateless;


/**
 *
 * @author cardoso
 */

@Stateless
public class FuncionarioServico extends ServicoGenerico<Funcionario>{
    
    public FuncionarioServico(){
        super(Funcionario.class); 
    }
    
}
