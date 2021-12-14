/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByNomeOpcao", query = "SELECT m FROM Menu m WHERE m.nomeOpcao = :nomeOpcao"),
    @NamedQuery(name = "Menu.findByUrl", query = "SELECT m FROM Menu m WHERE m.url = :url"),
    @NamedQuery(name = "Menu.findByModulo", query = "SELECT m FROM Menu m WHERE m.modulo = :modulo"),
    @NamedQuery(name = "Menu.findByModulo2", query = "SELECT m FROM Menu m WHERE m.modulo = :modulo and m not in (select d.menu from Menucolaborador d where d.colaborador = :colaborador )"),
    @NamedQuery(name = "Menu.findByMenuPrincipal", query = "SELECT m FROM Menu m WHERE m.menuPrincipal = :menuPrincipal"),
    @NamedQuery(name = "Menu.findByIconeMenu", query = "SELECT m FROM Menu m WHERE m.nomeIcone = :nomeIcone")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMenu")
    private BigDecimal idMenu;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "nomeOpcao")
    private String nomeOpcao;
    //@Size(max = 50)
    @Column(name = "nomeIcone")
    private String nomeIcone;
    //@Size(max = 100)
    @Column(name = "url")
    private String url;
    //@Size(max = 45)
    @Column(name = "modulo")
    private String modulo;
    //@Size(max = 100)
    @Column(name = "descricaoBundle")
    private String descricaoBundle;
    @OneToMany(mappedBy = "menu")
    private List<Menucolaborador> menucolaboradorList;
    @JoinColumn(name = "idMenuPrincipal", referencedColumnName = "idMenu")
    @ManyToOne
    private Menu menuPrincipal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuPrincipal")
    private List<Menu> menuList;

    public Menu() {
    }

    public BigDecimal getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(BigDecimal idMenu) {
        this.idMenu = idMenu;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenuPrincipal() {
        return menuPrincipal;
    }

    public void setMenuPrincipal(Menu menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu idMenu=" + idMenu + "-" + nomeOpcao;
    }

    public String getNomeOpcao() {
        return nomeOpcao;
    }

    public void setNomeOpcao(String nomeOpcao) {
        this.nomeOpcao = nomeOpcao;
    }

    public String getNomeIcone() {
        return nomeIcone;
    }

    public void setNomeIcone(String nomeIcone) {
        this.nomeIcone = nomeIcone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getDescricaoBundle() {
        return descricaoBundle;
    }

    public void setDescricaoBundle(String descricaoBundle) {
        this.descricaoBundle = descricaoBundle;
    }

    @XmlTransient
    public List<Menucolaborador> getMenucolaboradorList() {
        return menucolaboradorList;
    }

    public void setMenucolaboradorList(List<Menucolaborador> menucolaboradorList) {
        this.menucolaboradorList = menucolaboradorList;
    }
    
}
