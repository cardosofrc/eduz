package cardoso.eduz.manager;

import cardoso.eduz.enums.Editora;
import cardoso.eduz.enums.Genero;
import cardoso.eduz.modelo.Livro;
import cardoso.eduz.servico.LivroServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cardoso
 */
@Named
@ViewScoped
public class ManagerLivro implements Serializable {

    @EJB
    LivroServico livroServico;

    private Livro livro;
    private List<Livro> livros;

    @PostConstruct
    public void instanciar() {
        livro = new Livro();
        livros = new ArrayList<>();
    }

    public void adicionarLivro() {
        livroServico.salvar(livro);
        instanciar();
    }

    public void listarTodos() {
        livros = livroServico.findAll();
    }

    public void pesquisar() {
        livros = livroServico.pesquisarLivro(livro);
    }

    public void pesquisarTitulo() {
        livros = livroServico.pesquisarLivroTitulo(livro);
    }
/*
    public List<Livro> autocompleteLivro(String titulo) {
        return livroServico.findLivro(titulo);
    }
*/
    
    
    
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Genero[] getGenero() {
        return Genero.values();
    }

    public Editora[] getEditora() {
        return Editora.values();
    }
}
