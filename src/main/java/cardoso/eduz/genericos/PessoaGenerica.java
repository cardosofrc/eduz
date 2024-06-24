
package cardoso.eduz.genericos;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author cardoso
 */
@MappedSuperclass
public abstract class PessoaGenerica extends EntidadeGenerica {
    
    public String nome;
    public String email;
    public String cpf;
 
    public PessoaGenerica() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
