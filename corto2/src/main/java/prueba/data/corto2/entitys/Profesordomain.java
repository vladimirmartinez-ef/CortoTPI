/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "profesordomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Profesordomain.findAll", query = "SELECT p FROM Profesordomain p"),
    @NamedQuery(name = "Profesordomain.findByIdProfesor", query = "SELECT p FROM Profesordomain p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesordomain.findByLogin", query = "SELECT p FROM Profesordomain p WHERE p.login = :login"),
    @NamedQuery(name = "Profesordomain.findByDepartamento", query = "SELECT p FROM Profesordomain p WHERE p.departamento = :departamento")})
public class Profesordomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProfesor", nullable = false)
    private Integer idProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departamento", nullable = false, length = 45)
    private String departamento;

    public Profesordomain() {
    }

    public Profesordomain(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesordomain(Integer idProfesor, String login, String departamento) {
        this.idProfesor = idProfesor;
        this.login = login;
        this.departamento = departamento;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesordomain)) {
            return false;
        }
        Profesordomain other = (Profesordomain) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Profesordomain[ idProfesor=" + idProfesor + " ]";
    }
    
}
