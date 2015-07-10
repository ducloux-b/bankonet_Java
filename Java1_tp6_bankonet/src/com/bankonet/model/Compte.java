package com.bankonet.model;

abstract public class Compte
	{
	private float solde;

	public Compte(float solde)
		{
		if(solde < 0)
			{
			this.setSolde(0);
			}
		else
			{
			this.setSolde(solde);
			}
		}

	public String toString()
		{
		String res="solde:"+this.getSolde();
		return res;
		}

	public float getSolde()
		{
		return solde;
		}
	
	abstract public boolean debitAutorise(float montant);
	
	public boolean debiter(float montant)
		{
		if(debitAutorise(montant))
			{
			this.setSolde(this.getSolde()-montant);
			return true; 
			}
		else
			{
			System.err.println("Débit CC impossiburu!!");
			return false;
			}
		}

	private void setSolde(float solde)
		{
		this.solde= solde;
		}
	}
