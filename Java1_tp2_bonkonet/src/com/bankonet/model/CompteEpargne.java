package com.bankonet.model;

public class CompteEpargne
	{
	private String	numero;
	private String	intitule;
	private double	solde;
	private double	tauxInteret;

	public CompteEpargne(String numero, String intitule, double solde,
								double tauxInteret)
		{
		super();
		this.numero= numero;
		this.intitule= intitule;
		this.solde= solde;
		this.tauxInteret= tauxInteret;
		}
	
	public String toString()
		{
		String res="numero:"+this.getNumero()+
				"\nintitule:"+this.getIntitule()+
				"\nsolde:"+this.getSolde()+
				"\ntauxInteret"+this.getTauxInteret()+"%";
		return(res);
		}

	public String getNumero()
		{
		return numero;
		}

	public String getIntitule()
		{
		return intitule;
		}

	public double getSolde()
		{
		return solde;
		}

	public double getTauxInteret()
		{
		return tauxInteret;
		}

	}
