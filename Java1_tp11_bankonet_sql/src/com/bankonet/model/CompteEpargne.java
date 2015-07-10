package com.bankonet.model;

public class CompteEpargne extends Compte
	{
	private int	numero;
	private String	intitule;
	private float	tauxInteret;
	private float plafond;

	public CompteEpargne(int numero,
	                     String intitule,
	                     float solde,
								float tauxInteret,
								float plafond)
		{
		super(solde);
		this.numero= numero;
		this.intitule= intitule;
		this.tauxInteret= tauxInteret;
		this.plafond = plafond;
		}

	public float getPlafond()
		{
		return plafond;
		}

	public void setPlafond(float plafond)
		{
		this.plafond= plafond;
		}

	@Override
	public String toString()
		{
		String res= "numero:" + this.getNumero() + " intitule:" +
						this.getIntitule() + " " + super.toString() +
						" tauxInteret:" + this.getTauxInteret() + "%";
		return(res);
		}

	public int getNumero()
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
	
	@Override
	public void crediter(float montant) throws CreditException{
		try
			{
			if(montant+this.getSolde()<this.getPlafond())
				{
				this.setSolde(this.getSolde()+montant);;
				}
			else
				{
				throw new CreditException();
				}
			}
		catch(CreditException e)
			{
			throw e;
			}
	}
	
	}
