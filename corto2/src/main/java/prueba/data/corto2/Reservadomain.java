/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2;

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

/**
 *
 * @author vladimir
 */
@Entity
@Table(name = "reservadomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reservadomain.findAll", query = "SELECT r FROM Reservadomain r"),
    @NamedQuery(name = "Reservadomain.findByIdReserva", query = "SELECT r FROM Reservadomain r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reservadomain.findByIsbn", query = "SELECT r FROM Reservadomain r WHERE r.isbn = :isbn"),
    @NamedQuery(name = "Reservadomain.findByLogin", query = "SELECT r FROM Reservadomain r WHERE r.login = :login"),
    @NamedQuery(name = "Reservadomain.findByFecha", query = "SELECT r FROM Reservadomain r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Reservadomain.findByFechaFin", query = "SELECT r FROM Reservadomain r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "Reservadomain.findByTipoFinalizacion", query = "SELECT r FROM Reservadomain r WHERE r.tipoFinalizacion = :tipoFinalizacion"),
    @NamedQuery(name = "Reservadomain.findByEstadoHistorico", query = "SELECT r FROM Reservadomain r WHERE r.estadoHistorico = :estadoHistorico")})
public class Reservadomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReserva")
    private Integer idReserva;
    @Basic(optional = false)
    @Column(name = "isbn")
    private int isbn;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "tipoFinalizacion")
    private String tipoFinalizacion;
    @Basic(optional = false)
    @Column(name = "estadoHistorico")
    private String estadoHistorico;

    public Reservadomain() {
    }

    public Reservadomain(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reservadomain(Integer idReserva, int isbn, String login, Date fecha, Date fechaFin, String tipoFinalizacion, String estadoHistorico) {
        this.idReserva = idReserva;
        this.isbn = isbn;
        this.login = login;
        this.fecha = fecha;
        this.fechaFin = fechaFin;
        this.tipoFinalizacion = tipoFinalizacion;
        this.estadoHistorico = estadoHistorico;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoFinalizacion() {
        return tipoFinalizacion;
    }

    public void setTipoFinalizacion(String tipoFinalizacion) {
        this.tipoFinalizacion = tipoFinalizacion;
    }

    public String getEstadoHistorico() {
        return estadoHistorico;
    }

    public void setEstadoHistorico(String estadoHistorico) {
        this.estadoHistorico = estadoHistorico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservadomain)) {
            return false;
        }
        Reservadomain other = (Reservadomain) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Reservadomain[ idReserva=" + idReserva + " ]";
    }
    
}
