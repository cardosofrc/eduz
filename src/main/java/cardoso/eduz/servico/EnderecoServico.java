
package cardoso.eduz.servico;

import cardoso.eduz.genericos.ServicoGenerico;
import cardoso.eduz.modelo.Endereco;
import javax.ejb.Stateless;

/**
 *
 * @author cardoso
 */

@Stateless
public class EnderecoServico extends ServicoGenerico<Endereco> {
    
    public EnderecoServico(){
        super(Endereco.class);
    }
    
    public void pesquisaCep(){
        
    }
}