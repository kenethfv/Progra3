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
@Table(name ="Ciudad")

public class Ciudad implements Serializable{

	
	private static final long serialVersionUID = 6L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "idciudad")
	private Integer idCiudad;
	
	@Column(name = "nomciudad")
	private String nomCiudad;
	
	@Column(name= "Pais_idpais")
	private Integer paisIdPais;
	
	//RELACIONES UNO A MUCHOS
	
			@OneToMany(mappedBy = "idsalciudad")
		   	private List<Vuelo> ciudadSalList;
			
			@OneToMany(mappedBy = "iddesciudad")
		   	private List<Vuelo> ciudadDesList;

			public Integer getIdCiudad() {
				return idCiudad;
			}

			public void setIdCiudad(Integer idCiudad) {
				this.idCiudad = idCiudad;
			}

			public String getNomCiudad() {
				return nomCiudad;
			}

			public void setNomCiudad(String nomCiudad) {
				this.nomCiudad = nomCiudad;
			}

			public Integer getPaisIdPais() {
				return paisIdPais;
			}

			public void setPaisIdPais(Integer paisIdPais) {
				this.paisIdPais = paisIdPais;
			}

			public List<Vuelo> getCiudadSalList() {
				return ciudadSalList;
			}

			public void setCiudadSalList(List<Vuelo> ciudadSalList) {
				this.ciudadSalList = ciudadSalList;
			}

			public List<Vuelo> getCiudadDesList() {
				return ciudadDesList;
			}

			public void setCiudadDesList(List<Vuelo> ciudadDesList) {
				this.ciudadDesList = ciudadDesList;
			}

			
			
}
