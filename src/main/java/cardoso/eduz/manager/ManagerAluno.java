
package cardoso.eduz.manager;

import cardoso.eduz.enums.Estado;
import cardoso.eduz.modelo.Aluno;
import cardoso.eduz.modelo.Endereco;
import cardoso.eduz.servico.AlunoServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class ManagerAluno implements Serializable{
    
    @EJB
    AlunoServico alunoServico;
    
    private Aluno aluno;
    
    private List<Aluno> alunos;
    
    @PostConstruct
    public void instanciar(){
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        
        String remover = params.get("remover");
        String editar = params.get("editar");
        
        if (editar != null){
            aluno = alunoServico.find(Long.parseLong(editar));
        } else if (remover != null){
            aluno = alunoServico.find(Long.parseLong(remover));
        } else {
            aluno = new Aluno();
            aluno.setEndereco(new Endereco());
            alunos = new ArrayList<>();
        }
    }
    
    public void adiconarAluno(){
        if (aluno.getId() == null){
            alunoServico.salvar(aluno);
            instanciar();
        } else {
            alunoServico.atualizar(aluno);
            instanciar();
        }
        
    }
    
    public void pesquisar(){
        alunos = alunoServico.pesquisarAluno(aluno);
    }
    
    public void removerAluno(){
        aluno.setAtivo(Boolean.FALSE);
        aluno.setDataDeAtualizacao(new Date());
        alunoServico.atualizar(aluno);
    }
    
    public List<Aluno> completarAluno(String nome) {
        return alunoServico.pesquisarPorNome(nome);
    }
    
    public void editar(){
        
    }
    
    public Estado[] getEstado(){
        return Estado.values();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
