
package cardoso.eduz.enums;

/**
 *
 * @author cardoso
 */
public enum Editora {
    FTD (1,"FTD"), 
    MODERNA (2, "Moderna"), 
    VOZES (3, "Vozes"),
    ATICA (4, "Ática"),
    ZAHAR (5, "Zahar");
    
    private int valor;
    private String descricao;

    private Editora(int valor, String descricao) {
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
