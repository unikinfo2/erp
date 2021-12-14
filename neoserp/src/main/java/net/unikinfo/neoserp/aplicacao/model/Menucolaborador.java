/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "menucolaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menucolaborador.findAll", query = "SELECT m FROM Menucolaborador m"),
    @NamedQuery(name = "Menucolaborador.findByIdMenuColaborador", query = "SELECT m FROM Menucolaborador m WHERE m.idMenuColaborador = :idMenuColaborador"),
    @NamedQuery(name = "Menucolaborador.findByDireitos", query = "SELECT m FROM Menucolaborador m WHERE m.direitos = :direitos"),
    @NamedQuery(name = "Menucolaborador.findByMenuColaborador", query = "SELECT m FROM Menucolaborador m WHERE m.menu = :menu and m.colaborador = :colaborador"),
    @NamedQuery(name = "Menucolaborador.findByMenu", query = "SELECT m FROM Menucolaborador m WHERE m.menu = :menu"),
    @NamedQuery(name = "Menucolaborador.findByColaborador", query = "SELECT m FROM Menucolaborador m WHERE m.colaborador = :colaborador order by m.menu.nomeOpcao")})
public class Menucolaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)    
    @Column(name = "idMenuColaborador")
    private Long idMenuColaborador;
    //@Size(max = 200)
    @Column(name = "direitos")
    private String direitos;
    @JoinColumn(name = "idColaborador", referencedColumnName = "idColaborador")
    @ManyToOne
    private Colaborador colaborador;
    @JoinColumn(name = "idMenu", referencedColumnName = "idMenu")
    @ManyToOne
    private Menu menu;

    public Menucolaborador() {
    }

    public Menucolaborador(Long idMenuColaborador) {
        this.idMenuColaborador = idMenuColaborador;
    }

    public Long getIdMenuColaborador() {
        return idMenuColaborador;
    }

    public void setIdMenuColaborador(Long idMenuColaborador) {
        this.idMenuColaborador = idMenuColaborador;
    }

    public String getDireitos() {
        return direitos;
    }

    public void setDireitos(String direitos) {
        this.direitos = direitos;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenuColaborador != null ? idMenuColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menucolaborador)) {
            return false;
        }
        Menucolaborador other = (Menucolaborador) object;
        if ((this.idMenuColaborador == null && other.idMenuColaborador != null) || (this.idMenuColaborador != null && !this.idMenuColaborador.equals(other.idMenuColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idMenuColaborador=" + idMenuColaborador + " - "+menu;
    }
    
}
