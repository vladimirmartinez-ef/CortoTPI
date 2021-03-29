/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vladimir
 */
@Entity
@Table(name = "alumnodomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alumnodomain.findAll", query = "SELECT a FROM Alumnodomain a"),
    @NamedQuery(name = "Alumnodomain.findByIdAlumno", query = "SELECT a FROM Alumnodomain a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumnodomain.findByLogin", query = "SELECT a FROM Alumnodomain a WHERE a.login = :login"),
    @NamedQuery(name = "Alumnodomain.findByTutor", query = "SELECT a FROM Alumnodomain a WHERE a.tutor = :tutor")})
public class Alumnodomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "tutor")
    private String tutor;

    public Alumnodomain() {
    }

    public Alumnodomain(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumnodomain(Integer idAlumno, String login, String tutor) {
        this.idAlumno = idAlumno;
        this.login = login;
        this.tutor = tutor;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnodomain)) {
            return false;
        }
        Alumnodomain other = (Alumnodomain) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Alumnodomain[ idAlumno=" + idAlumno + " ]";
    }
    
}
