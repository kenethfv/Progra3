package com.application.proyecto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Pais")
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idpais")
	private Integer idPais;
	
	@Column(name = "nompais")
	private String NomPais;
	
	//RELACIONES UNO A MUCHOS

		@OneToMany(mappedBy = "paisIdPais")
	   	private List<Ciudad> ciudadList;
		
		@OneToMany(mappedBy = "IdSalPais")
	   	private List<Vuelo> vueloSalList;
	
		@OneToMany(mappedBy = "IdDesPais")
	   	private List<Vuelo> vueloDesList;

		public Integer getIdPais() {
			return idPais;
		}

		public void setIdPais(Integer idPais) {
			this.idPais = idPais;
		}

		public String getNomPais() {
			return NomPais;
		}

		public void setNomPais(String nomPais) {
			NomPais = nomPais;
		}

		public List<Ciudad> getCiudadList() {
			return ciudadList;
		}

		public void setCiudadList(List<Ciudad> ciudadList) {
			this.ciudadList = ciudadList;
		}

		public List<Vuelo> getVueloSalList() {
			return vueloSalList;
		}

		public void setVueloSalList(List<Vuelo> vueloSalList) {
			this.vueloSalList = vueloSalList;
		}

		public List<Vuelo> getVueloDesList() {
			return vueloDesList;
		}

		public void setVueloDesList(List<Vuelo> vueloDesList) {
			this.vueloDesList = vueloDesList;
		}



		

}
