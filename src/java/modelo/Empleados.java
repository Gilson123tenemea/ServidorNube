/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmpl", query = "SELECT e FROM Empleados e WHERE e.idEmpl = :idEmpl")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empl")
    private Integer idEmpl;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne
    private Departamento id;

    public Empleados() {
    }

    public Empleados(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public Integer getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getId() {
        return id;
    }

    public void setId(Departamento id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpl != null ? idEmpl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpl == null && other.idEmpl != null) || (this.idEmpl != null && !this.idEmpl.equals(other.idEmpl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ idEmpl=" + idEmpl + " ]";
    }
    
}
