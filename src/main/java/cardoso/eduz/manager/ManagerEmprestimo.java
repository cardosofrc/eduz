package cardoso.eduz.manager;

import cardoso.eduz.modelo.Aluno;
import cardoso.eduz.modelo.Emprestimo;
import cardoso.eduz.modelo.Livro;
import cardoso.eduz.servico.EmprestimoServico;
import cardoso.eduz.utilitario.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cardoso
 */
@Named
@ViewScoped
public class ManagerEmprestimo implements Serializable {

    @EJB
    EmprestimoServico emprestimoServico;

    private Emprestimo emprestimo;
    private Aluno aluno;
    private Livro livro;

    private List<Emprestimo> emprestimos;

    @PostConstruct
    public void instanciar() {

        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        String detalhes = params.get("detalhes");
        String renovar = params.get("renovar");

        if (detalhes != null) {
            emprestimo = emprestimoServico.find(Long.parseLong(detalhes));
        } else if (renovar != null) {
            emprestimo = emprestimoServico.find(Long.parseLong(renovar));
        } else {
            emprestimo = new Emprestimo();
            aluno = new Aluno();
            emprestimo.setAluno(aluno);
            emprestimo.setLivros(new ArrayList());
            emprestimos = new ArrayList<>();
            livro = new Livro();
        }
    }

    public List<Livro> autocompleteLivro(String titulo) {
        return emprestimoServico.findLivro(titulo);
    }

    public List<Aluno> autocompleteAluno(String nome) {
        return emprestimoServico.findAluno(nome);
    }

    public void selecionarAluno() {

        if (aluno.getId() == null) {
            System.out.println("Não deu certo");
        } else {
            System.out.println("Deu certo");
            this.aluno = aluno;
            emprestimo.setAluno(this.aluno);
            System.out.println(emprestimo.getAluno().getNome());

        }

    }

    public void selecionarLivro() {
        emprestimo.getLivros().add(livro);
        System.out.println(livro.getId());
        livro = new Livro();
    }

    public void salvar() {
        selecionarAluno();
        emprestimoServico.salvar(emprestimo);
        instanciar();
        Message.mensagem("Operação realizada com sucesso");
    }

    public void pesquisar() {
        emprestimos = emprestimoServico.consultar(emprestimo);
    }

    public void pesquisarAlunoNome() {
        emprestimos = emprestimoServico.pesquisarAlunoNome(emprestimo, emprestimo.getAluno());
        System.out.println(emprestimos);
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
