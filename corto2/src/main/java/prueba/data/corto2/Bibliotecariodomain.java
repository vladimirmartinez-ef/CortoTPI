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
@Table(name = "bibliotecariodomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bibliotecariodomain.findAll", query = "SELECT b FROM Bibliotecariodomain b"),
    @NamedQuery(name = "Bibliotecariodomain.findByBibliotecario", query = "SELECT b FROM Bibliotecariodomain b WHERE b.bibliotecario = :bibliotecario"),
    @NamedQuery(name = "Bibliotecariodomain.findByLogin", query = "SELECT b FROM Bibliotecariodomain b WHERE b.login = :login"),
    @NamedQuery(name = "Bibliotecariodomain.findByPassword", query = "SELECT b FROM Bibliotecariodomain b WHERE b.password = :password"),
    @NamedQuery(name = "Bibliotecariodomain.findByNif", query = "SELECT b FROM Bibliotecariodomain b WHERE b.nif = :nif")})
public class Bibliotecariodomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bibliotecario")
    private Integer bibliotecario;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "nif")
    private int nif;

    public Bibliotecariodomain() {
    }

    public Bibliotecariodomain(Integer bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Bibliotecariodomain(Integer bibliotecario, String login, String password, int nif) {
        this.bibliotecario = bibliotecario;
        this.login = login;
        this.password = password;
        this.nif = nif;
    }

    public Integer getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Integer bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bibliotecario != null ? bibliotecario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliotecariodomain)) {
            return false;
        }
        Bibliotecariodomain other = (Bibliotecariodomain) object;
        if ((this.bibliotecario == null && other.bibliotecario != null) || (this.bibliotecario != null && !this.bibliotecario.equals(other.bibliotecario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.Bibliotecariodomain[ bibliotecario=" + bibliotecario + " ]";
    }
    
}
