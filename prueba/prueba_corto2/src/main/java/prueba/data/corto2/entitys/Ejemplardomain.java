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
 * @author elmer_interiano
 */
@Entity
@Table(name = "ejemplardomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ejemplardomain.findAll", query = "SELECT e FROM Ejemplardomain e"),
    @NamedQuery(name = "Ejemplardomain.findByIdEjemplar", query = "SELECT e FROM Ejemplardomain e WHERE e.idEjemplar = :idEjemplar"),
    @NamedQuery(name = "Ejemplardomain.findByIsbn", query = "SELECT e FROM Ejemplardomain e WHERE e.isbn = :isbn"),
    @NamedQuery(name = "Ejemplardomain.findByLogin", query = "SELECT e FROM Ejemplardomain e WHERE e.login = :login"),
    @NamedQuery(name = "Ejemplardomain.findByFechaAdquisicion", query = "SELECT e FROM Ejemplardomain e WHERE e.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "Ejemplardomain.findByObservaciones", query = "SELECT e FROM Ejemplardomain e WHERE e.observaciones = :observaciones"),
    @NamedQuery(name = "Ejemplardomain.findByFechaPrestamo", query = "SELECT e FROM Ejemplardomain e WHERE e.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "Ejemplardomain.findByFechaDevolucion", query = "SELECT e FROM Ejemplardomain e WHERE e.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "Ejemplardomain.findByEstadoEjemplar", query = "SELECT e FROM Ejemplardomain e WHERE e.estadoEjemplar = :estadoEjemplar"),
    @NamedQuery(name = "Ejemplardomain.findByLocalizacion", query = "SELECT e FROM Ejemplardomain e WHERE e.localizacion = :localizacion")})
public class Ejemplardomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEjemplar", nullable = false)
    private Integer idEjemplar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbn", nullable = false)
    private int isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAdquisicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Size(max = 45)
    @Column(name = "observaciones", length = 45)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPrestamo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDevolucion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoEjemplar", nullable = false, length = 45)
    private String estadoEjemplar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localizacion", nullable = false, length = 45)
    private String localizacion;

    public Ejemplardomain() {
    }

    public Ejemplardomain(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Ejemplardomain(Integer idEjemplar, int isbn, String login, Date fechaAdquisicion, Date fechaPrestamo, Date fechaDevolucion, String estadoEjemplar, String localizacion) {
        this.idEjemplar = idEjemplar;
        this.isbn = isbn;
        this.login = login;
        this.fechaAdquisicion = fechaAdquisicion;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoEjemplar = estadoEjemplar;
        this.localizacion = localizacion;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstadoEjemplar() {
        return estadoEjemplar;
    }

    public void setEstadoEjemplar(String estadoEjemplar) {
        this.estadoEjemplar = estadoEjemplar;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjemplar != null ? idEjemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplardomain)) {
            return false;
        }
        Ejemplardomain other = (Ejemplardomain) object;
        if ((this.idEjemplar == null && other.idEjemplar != null) || (this.idEjemplar != null && !this.idEjemplar.equals(other.idEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.entitys.Ejemplardomain[ idEjemplar=" + idEjemplar + " ]";
    }
    
}
