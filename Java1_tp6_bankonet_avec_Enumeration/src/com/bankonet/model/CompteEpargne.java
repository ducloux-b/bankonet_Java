package com.bankonet.model;

public class CompteEpargne extends Compte
	{
	private String	numero;
	private String	intitule;
	private float	tauxInteret;

	public CompteEpargne(String numero, String intitule, float solde,
								float tauxInteret)
		{
		super(solde);
		this.numero= numero;
		this.intitule= intitule;
		this.tauxInteret= tauxInteret;
		}

	@Override
	public String toString()
		{
		String res= "numero:" + this.getNumero() + "\nintitule:" +
						this.getIntitule() + "\n" + super.toString() +
						"\ntauxInteret" + this.getTauxInteret() + "%";
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

	public float getTauxInteret()
		{
		return tauxInteret;
		}

	@Override
	public boolean debitAutorise(float montant)
		{
		return(montant<this.getSolde());
		}

	@Override
	public TypeCompte typeCompte()
		{
		return TypeCompte.EPARGNE;
		}
	
	}
