
package cardoso.eduz.modelo;

import cardoso.eduz.genericos.EntidadeGenerica;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cardoso
 */
@Entity
public class Emprestimo extends EntidadeGenerica{
    
    @Id
    @SequenceGenerator(name = "seq_emprestimo", sequenceName = "seq_emprestimo", initialValue = 1)
    @GeneratedValue(generator = "seq_emprestimo", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeDevolucao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrevista;
    
    @OneToOne
    private Aluno aluno;
    
    @OneToMany
    private List<Livro> livros;

    public Emprestimo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.dataDeDevolucao);
        hash = 67 * hash + Objects.hashCode(this.dataPrevista);
        hash = 67 * hash + Objects.hashCode(this.aluno);
        hash = 67 * hash + Objects.hashCode(this.livros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataDeDevolucao, other.dataDeDevolucao)) {
            return false;
        }
        if (!Objects.equals(this.dataPrevista, other.dataPrevista)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return Objects.equals(this.livros, other.livros);
    }
}
