package com.crjj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module {
	@Id
	@Column(name="code_mod")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idModule;
	@Column(name="titre_mod")
	String titre;
	@Column(name="nb_heure")
	String nb;
	@Column(name="filiere")
	String filiere;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNb() {
		return nb;
	}
	public void setNb(String nb) {
		this.nb = nb;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public int getIdModule() {
		return idModule;
	}
	public Module(int idModule, String titre, String nb, String filiere) {
		this.idModule = idModule;
		this.titre = titre;
		this.nb = nb;
		this.filiere = filiere;
	}
	public Module() {
	}
	
	
}
