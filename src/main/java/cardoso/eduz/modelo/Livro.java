
package cardoso.eduz.modelo;

import cardoso.eduz.enums.Editora;
import cardoso.eduz.enums.Genero;
import cardoso.eduz.genericos.EntidadeGenerica;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author cardoso
 */
@Entity
public class Livro extends EntidadeGenerica {
    
    @Id
    @SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", initialValue = 1)
    @GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String codigoIsbn;
    
    @Column(unique = true)
    private String titulo;
    private String autor;
    
    @Enumerated(EnumType.STRING)
    private Editora editora;
    
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String ano;
    
    private int qnt;
    
    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }

    public void setCodigoIsbn(String codigoIsbn) {
        this.codigoIsbn = codigoIsbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.codigoIsbn);
        hash = 11 * hash + Objects.hashCode(this.titulo);
        hash = 11 * hash + Objects.hashCode(this.autor);
        hash = 11 * hash + Objects.hashCode(this.editora);
        hash = 11 * hash + Objects.hashCode(this.genero);
        hash = 11 * hash + Objects.hashCode(this.ano);
        hash = 11 * hash + this.qnt;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.qnt != other.qnt) {
            return false;
        }
        if (!Objects.equals(this.codigoIsbn, other.codigoIsbn)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.editora != other.editora) {
            return false;
        }
        return this.genero == other.genero;
    }

    @Override
    public String toString() {
        return titulo;
    }

}
