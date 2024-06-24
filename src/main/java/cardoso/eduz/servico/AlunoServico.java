
package cardoso.eduz.servico;

import cardoso.eduz.genericos.ServicoGenerico;
import cardoso.eduz.modelo.Aluno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cardoso
 */

@Stateless
public class AlunoServico extends ServicoGenerico<Aluno> {
    
    public AlunoServico(){
        super(Aluno.class);
    }
    
    public List<Aluno> findByName(String nome){
        return getEntityManager().createQuery("SELECT a FROM aluno a WERE a.nome like '"+nome+"'")
                .getResultList();
    }
    
    public Boolean pesquisarCpf(){
        
        return true;
    }
    
    public List<Aluno> pesquisarPorNome(String nome){
        String sql = "select a from Aluno a where ";
        
        if (nome != null && !nome.equals(nome)){
            sql += "lower(a.nome) like lower(:nome) and ";
        }
        
        sql += "a.ativo = true ORDER BY a.nome ASC";
        
        Query query = getEntityManager().createNamedQuery(sql);
        
        if (nome != null && !nome.equals("")){
            query.setParameter("nome","%" + nome.trim() +"%");
        }
                
        return query.getResultList();
    }
           
    public List<Aluno> pesquisarAluno(Aluno aluno){
        // Essa string sql vai ser concatenada com o restante da consulta desejada
        // a é a variável do tipo Aluno
        // as buscas são efetuadas usando o nome ou o CPF
        String sql = "select a from Aluno a where ";
        
        // Compara se o CPF não é nulo ou vazio
        if (aluno.getCpf() != null && !aluno.getCpf().equals("")){
            sql += "a.cpf like :cpf and ";
        }
        
        // Compara o nome do Aluno se está vazio ou nulo
        if (aluno.getNome() != null && !aluno.getNome().equals("")){
            sql += "lower(a.nome) like lower(:nome) and ";
        }
        
        // Verifica se o campo está ativo ou não
        sql += "a.ativo = true";
        
        Query query = getEntityManager().createQuery(sql);
        
        if (aluno.getCpf() != null && !aluno.getCpf().equals("")){
            query.setParameter("cpf","%" + aluno.getCpf() +"%");
        }
        if (aluno.getNome() != null && !aluno.getNome().equals("")){
            query.setParameter("nome","%" + aluno.getNome() +"%");
        }
                
        return query.getResultList();
    }
    
}
