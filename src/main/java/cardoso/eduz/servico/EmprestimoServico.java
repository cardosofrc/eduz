package cardoso.eduz.servico;

import cardoso.eduz.genericos.ServicoGenerico;
import cardoso.eduz.modelo.Aluno;
import cardoso.eduz.modelo.Emprestimo;
import cardoso.eduz.modelo.Livro;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cardoso
 */
@Stateless
public class EmprestimoServico extends ServicoGenerico<Emprestimo> {

    public EmprestimoServico() {
        super(Emprestimo.class);
    }

    // Esse método retorna todos os empréstimos
    public List<Emprestimo> consultar(Emprestimo emprestimo) {
        String sql = "select l from Emprestimo l where ";

        sql += "l.ativo = true";

        Query query = getEntityManager().createQuery(sql);

        return query.getResultList();
    }

    

    public List<Emprestimo> pesquisarAlunoNome(Emprestimo emprestimo, Aluno aluno) {

        String sql = "select e from Emprestimo e JOIN a.aluno a where ";

        if (aluno != null && !aluno.getNome().equals("")) {
            sql += "lower(a.nome) like lower(:nome) and ";
        }

        sql += "e.ativo = true";

        Query query = getEntityManager().createQuery(sql,Emprestimo.class);

        if (aluno != null && !aluno.getNome().equals("")) {
            query.setParameter("nome", "%" + aluno.getNome() + "%");
        }

        return query.getResultList();
    }

    public List<Livro> findLivro(String titulo) {
        String sql = "select c from Livro c where ";

        if (titulo != null && !titulo.equals(titulo)) {
            sql += "lower(c.titulo) like lower(:titulo) and ";
        }
        sql += "c.ativo = true ORDER BY c.titulo ASC";

        Query query = getEntityManager().createQuery(sql);

        if (titulo != null && !titulo.equals(titulo)) {
            query.setParameter("titulo", "%" + titulo.trim() + "%");
        }

        return query.getResultList();
    }

    public List<Aluno> findAluno(String nome) {
        String sql = "select a from Aluno a where ";

        if (nome != null && !nome.equals(nome)) {
            sql += "lower(a.nome) like lower(:nome) and ";
        }
        sql += "a.ativo = true ORDER BY a.nome ASC";

        Query query = getEntityManager().createQuery(sql);

        if (nome != null && !nome.equals(nome)) {
            query.setParameter("nome", "%" + nome.trim() + "%");
        }

        return query.getResultList();
    }
}
