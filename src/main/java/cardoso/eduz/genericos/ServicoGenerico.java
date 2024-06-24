
package cardoso.eduz.genericos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cardoso
 */

public class ServicoGenerico<T> {
    
    private Class<T> entidade;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public ServicoGenerico(Class<T> entidade){
        this.entidade = entidade;
    }
    
    public void salvar(T entidade){
        entityManager.persist(entidade);
    }
    
    public void atualizar(T entidade){
        entityManager.merge(entidade);
        entityManager.flush();
    }
    
    public T find(Long id){
        T objeto = getEntityManager().find(entidade, id);
        getEntityManager().refresh(objeto);
        return objeto;
    }
    
    public void remover(){
        
    }
    
    public List<T> findAll(){
        return entityManager.createQuery("SELECT e FROM " + entidade.getName() + " e WERE e.ativo = true ").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
