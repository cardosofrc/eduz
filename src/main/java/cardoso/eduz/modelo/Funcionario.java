
package cardoso.eduz.modelo;

import cardoso.eduz.genericos.PessoaGenerica;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author cardoso
 */

@Entity
public class Funcionario extends PessoaGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funconario", initialValue = 1)
    @GeneratedValue(generator = "seq_funcionario", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String login;
    private String senha;

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
