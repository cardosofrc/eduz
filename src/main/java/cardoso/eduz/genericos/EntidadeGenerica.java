
package cardoso.eduz.genericos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cardoso
 */

@MappedSuperclass
public abstract class EntidadeGenerica implements Serializable {
    
    public Boolean ativo;
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date dataDeCadastro;
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date dataDeAtualizacao;

    public EntidadeGenerica() {
        dataDeCadastro = new Date();
        ativo = Boolean.TRUE;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(Date dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }
    
    
}
