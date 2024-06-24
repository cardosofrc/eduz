
package cardoso.eduz.enums;

/**
 *
 * @author cardoso
 */
public enum Genero {
    LITERARIO (1,"Literatura"),
    DIDATICO (2,"Didático");
    
    private int valor;
    private String descricao;

    private Genero(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}