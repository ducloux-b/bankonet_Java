package com.bankonet.model;

public class CompteCourant {

	private int identifiant;
	private String libelle;
	private float solde;
	private float decouvertAutorise;

	public CompteCourant(int identifiant, String libelle, float solde,
			float decouvertAutorise) {
		this.identifiant = identifiant;
		this.libelle = libelle;
		
		if (solde<0) {
			this.solde = 0;
		} else {
			this.solde = solde;
		}
		
		this.decouvertAutorise = decouvertAutorise;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getSolde() {
		return solde;
	}

	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public boolean debitAutorise(float montant){
		return(this.solde+this.decouvertAutorise>=montant);
	}
	
	public boolean creditAutorise(float montant) {
		return(true);
	}
	
	public String toString() {
		String res = "id:"+this.identifiant+'\n'+"libelle:"+this.libelle+'\n'+"solde:"+this.solde+'\n'+"decouvert autorisé:"+this.decouvertAutorise+'\n';
		return(res);
	}
	
	
}
