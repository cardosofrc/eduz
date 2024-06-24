
package cardoso.eduz.modelo;

import cardoso.eduz.genericos.PessoaGenerica;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author cardoso
 */

@Entity
public class Aluno extends PessoaGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno", initialValue = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date dataDeNascimento;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}