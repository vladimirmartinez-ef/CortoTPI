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

/**
 *
 * @author elmer_interiano
 */
@Entity
@Table(name = "multadomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Multadomain.findAll", query = "SELECT m FROM Multadomain m"),
    @NamedQuery(name = "Multadomain.findByIdMulta", query = "SELECT m FROM Multadomain m WHERE m.idMulta = :idMulta"),
    @NamedQuery(name = "Multadomain.findByLogin", query = "SELECT m FROM Multadomain m WHERE m.login = :login"),
    @NamedQuery(name = "Multadomain.findByFechaInicio", query = "SELECT m FROM Multadomain m WHERE m.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Multadomain.findByFechaFin", query = "SELECT m FROM Multadomain m WHERE m.fechaFin = :fechaFin"),
    @NamedQuery(name = "Multadomain.findByEstadoHistorico", query = "SELECT m FROM Multadomain m WHERE m.estadoHistorico = :estadoHistorico")})
public class Multadomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMulta", nullable = false)
    private Integer idMulta;
    @Basic(optional = false)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @Column(name = "fechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fechaFin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "estadoHistorico", nullable = false, length = 45)
    private String estadoHistorico;

    public Multadomain() {
    }

    public Multadomain(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public Multadomain(Integer idMulta, String login, Date fechaInicio, Date fechaFin, String estadoHistorico) {
        this.idMulta = idMulta;
        this.login = login;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoHistorico = estadoHistorico;
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        hash += (idMulta != null ? idMulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multadomain)) {
            return false;
        }
        Multadomain other = (Multadomain) object;
        if ((this.idMulta == null && other.idMulta != null) || (this.idMulta != null && !this.idMulta.equals(other.idMulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.entitys.Multadomain[ idMulta=" + idMulta + " ]";
    }
    
}
