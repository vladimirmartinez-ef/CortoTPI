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
 * @author edwin
 */
@Entity
@Table(name = "prestamohistoricodomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Prestamohistoricodomain.findAll", query = "SELECT p FROM Prestamohistoricodomain p"),
    @NamedQuery(name = "Prestamohistoricodomain.findByIdEjemplar", query = "SELECT p FROM Prestamohistoricodomain p WHERE p.idEjemplar = :idEjemplar"),
    @NamedQuery(name = "Prestamohistoricodomain.findByLogin", query = "SELECT p FROM Prestamohistoricodomain p WHERE p.login = :login"),
    @NamedQuery(name = "Prestamohistoricodomain.findByFechaPrestamo", query = "SELECT p FROM Prestamohistoricodomain p WHERE p.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "Prestamohistoricodomain.findByFechaDevolucion", query = "SELECT p FROM Prestamohistoricodomain p WHERE p.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "Prestamohistoricodomain.findByFechaDevolucionReal", query = "SELECT p FROM Prestamohistoricodomain p WHERE p.fechaDevolucionReal = :fechaDevolucionReal")})
public class Prestamohistoricodomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEjemplar", nullable = false)
    private Integer idEjemplar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
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
    @Column(name = "fechaDevolucionReal", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucionReal;

    public Prestamohistoricodomain() {
    }

    public Prestamohistoricodomain(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Prestamohistoricodomain(Integer idEjemplar, String login, Date fechaPrestamo, Date fechaDevolucion, Date fechaDevolucionReal) {
        this.idEjemplar = idEjemplar;
        this.login = login;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
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
        if (!(object instanceof Prestamohistoricodomain)) {
            return false;
        }
        Prestamohistoricodomain other = (Prestamohistoricodomain) object;
        if ((this.idEjemplar == null && other.idEjemplar != null) || (this.idEjemplar != null && !this.idEjemplar.equals(other.idEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Prestamohistoricodomain[ idEjemplar=" + idEjemplar + " ]";
    }
    
}
