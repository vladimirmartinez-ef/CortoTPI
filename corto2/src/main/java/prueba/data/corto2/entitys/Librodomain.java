/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "librodomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Librodomain.findAll", query = "SELECT l FROM Librodomain l"),
    @NamedQuery(name = "Librodomain.findByIsbn", query = "SELECT l FROM Librodomain l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Librodomain.findByTitulo", query = "SELECT l FROM Librodomain l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Librodomain.findByAutor", query = "SELECT l FROM Librodomain l WHERE l.autor = :autor"),
    @NamedQuery(name = "Librodomain.findByNumPaginas", query = "SELECT l FROM Librodomain l WHERE l.numPaginas = :numPaginas"),
    @NamedQuery(name = "Librodomain.findByFechaAlta", query = "SELECT l FROM Librodomain l WHERE l.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Librodomain.findByNumDisponibles", query = "SELECT l FROM Librodomain l WHERE l.numDisponibles = :numDisponibles")})
public class Librodomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isbn", nullable = false)
    private Integer isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "autor", nullable = false, length = 45)
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numPaginas", nullable = false)
    private int numPaginas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAlta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numDisponibles", nullable = false)
    private int numDisponibles;

    public Librodomain() {
    }

    public Librodomain(Integer isbn) {
        this.isbn = isbn;
    }

    public Librodomain(Integer isbn, String titulo, String autor, int numPaginas, Date fechaAlta, int numDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.fechaAlta = fechaAlta;
        this.numDisponibles = numDisponibles;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
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

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getNumDisponibles() {
        return numDisponibles;
    }

    public void setNumDisponibles(int numDisponibles) {
        this.numDisponibles = numDisponibles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librodomain)) {
            return false;
        }
        Librodomain other = (Librodomain) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Librodomain[ isbn=" + isbn + " ]";
    }
    
}
