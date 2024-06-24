
package cardoso.eduz.servico;

import cardoso.eduz.genericos.ServicoGenerico;
import cardoso.eduz.modelo.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cardoso
 */
@Stateless
public class LivroServico extends ServicoGenerico<Livro>{
    
    public LivroServico() {
        super(Livro.class);
    }
    
    public Livro findByTitle(String titulo){
        return null;
    }
    
    public void removerLivro(Livro livro){
        livro.setAtivo(Boolean.FALSE);
    }
    
    public List<Livro> pesquisarLivro(Livro livro){
        // Essa string sql vai ser concatenada com o restante da consulta desejada
        // l é a variável do tipo Livro
        String sql = "select l from Livro l where ";
        
        // Compara se o título não é nulo ou vazio
        if (livro.getTitulo() != null && !livro.getTitulo().equals("")){
            sql += "lower(l.titulo) like lower(:titulo) and ";
        }
        
        // Compara o nome do Autor se está vazio ou nulo
        if (livro.getAutor() != null && !livro.getAutor().equals("")){
            sql += "lower(l.autor) like lower(:autor) and ";
        }
        
        // Verifica se o campo está ativo ou não
        sql += "l.ativo = true";
        
        Query query = getEntityManager().createQuery(sql);
        
        if (livro.getTitulo() != null && !livro.getTitulo().equals("")){
            query.setParameter("titulo","%" + livro.getTitulo() +"%");
        }
        if (livro.getAutor() != null && !livro.getAutor().equals("")){
            query.setParameter("autor","%" + livro.getAutor() +"%");
        }
                
        return query.getResultList();
    }
    
    public List<Livro> pesquisarLivroTitulo(Livro livro){
        // Essa string sql vai ser concatenada com o restante da consulta desejada
        // l é a variável do tipo Livro
        String sql = "select l from Livro l where ";
        
        // Compara se o título não é nulo ou vazio
        if (livro.getTitulo() != null && !livro.getTitulo().equals("")){
            sql += "lower(l.titulo) like lower(:titulo) and ";
        }
        
        // Verifica se o campo está ativo ou não
        sql += "l.ativo = true";
        
        Query query = getEntityManager().createQuery(sql);
        
        if (livro.getTitulo() != null && !livro.getTitulo().equals("")){
            query.setParameter("titulo","%" + livro.getTitulo() +"%");
        }
                
        return query.getResultList();
    }
/*    
    public List<Livro> findLivro(String titulo) {
        String sql = "select l from Livro l where ";

        if (titulo != null && !titulo.equals(titulo)) {
            sql += "lower(l.titulo) like lower(:titulo) and ";
        }
        sql += "l.ativo = true ORDER BY l.nome ASC";

        Query query = getEntityManager().createQuery(sql);

        if (titulo != null && !titulo.equals("")) {
            query.setParameter("titulo", "%" + titulo.trim() + "%");
        }

        return query.getResultList();
    }
*/
    
}
