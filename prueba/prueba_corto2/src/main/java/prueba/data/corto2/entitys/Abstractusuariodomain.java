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
 * @author elmer_interiano
 */
@Entity
@Table(name = "abstractusuariodomain", catalog = "cortoDosTPI", schema = "")
@NamedQueries({
    @NamedQuery(name = "Abstractusuariodomain.findAll", query = "SELECT a FROM Abstractusuariodomain a"),
    @NamedQuery(name = "Abstractusuariodomain.findByLogin", query = "SELECT a FROM Abstractusuariodomain a WHERE a.login = :login"),
    @NamedQuery(name = "Abstractusuariodomain.findByPassword", query = "SELECT a FROM Abstractusuariodomain a WHERE a.password = :password"),
    @NamedQuery(name = "Abstractusuariodomain.findByEmail", query = "SELECT a FROM Abstractusuariodomain a WHERE a.email = :email"),
    @NamedQuery(name = "Abstractusuariodomain.findByNombre", query = "SELECT a FROM Abstractusuariodomain a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Abstractusuariodomain.findByApellido1", query = "SELECT a FROM Abstractusuariodomain a WHERE a.apellido1 = :apellido1"),
    @NamedQuery(name = "Abstractusuariodomain.findByApellido2", query = "SELECT a FROM Abstractusuariodomain a WHERE a.apellido2 = :apellido2"),
    @NamedQuery(name = "Abstractusuariodomain.findByEstadoUsuario", query = "SELECT a FROM Abstractusuariodomain a WHERE a.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Abstractusuariodomain.findByDireccion", query = "SELECT a FROM Abstractusuariodomain a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Abstractusuariodomain.findByCiudad", query = "SELECT a FROM Abstractusuariodomain a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Abstractusuariodomain.findByCodigoPostal", query = "SELECT a FROM Abstractusuariodomain a WHERE a.codigoPostal = :codigoPostal")})
public class Abstractusuariodomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1", nullable = false, length = 45)
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido2", nullable = false, length = 45)
    private String apellido2;
    @Column(name = "estadoUsuario")
    private Short estadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoPostal", nullable = false)
    private int codigoPostal;

    public Abstractusuariodomain() {
    }

    public Abstractusuariodomain(String login) {
        this.login = login;
    }

    public Abstractusuariodomain(String login, String password, String email, String nombre, String apellido1, String apellido2, String direccion, String ciudad, int codigoPostal) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Short getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Short estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abstractusuariodomain)) {
            return false;
        }
        Abstractusuariodomain other = (Abstractusuariodomain) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.data.corto2.entitys.Abstractusuariodomain[ login=" + login + " ]";
    }
    
}
