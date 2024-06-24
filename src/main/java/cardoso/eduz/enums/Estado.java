
package cardoso.eduz.enums;

/**
 *
 * @author cardoso
 */
public enum Estado {
    AC(1,"AC"), AL(2, "AL"), AP(3,"AP"), AM(4,"AM"), 
    BA(5,"BA"), CE(6,"CE"), DF(7,"DF"), ES(8,"ES"),
    GO(9,"GO"), MA(10,"MA"), MT(11,"MT"), MS(12,"MS"),
    MG(13,"MG"), PA(14,"PA"), PB(15,"PR"), PR(16,"PR"),
    PE(17,"PE"), PI(18,"PI"), RR(19,"RR"), RO(20,"RO"),
    RJ(21,"RJ"), RN(22,"RN"), RS(23,"RS"), SC(24,"SC"),
    SP(25,"SP"), SE(26,"SE"), TO(27,"TO");
    
    private int valor;
    private String descricao;

    private Estado(int valor, String descricao) {
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
