package com.bankonet.model;

abstract public class Compte implements CompteStat
	{
	private float	solde;	// on peut aussi le déclarer en protected pour y
									// avoir accès dans les classes filles

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
		String res= "TypeCompte:" + this.typeCompte() + "\nsolde:" +
						this.getSolde();
		return res;
		}

	public float getSolde()
		{
		return solde;
		}

	abstract public boolean debitAutorise(float montant);

	public void debiter(float montant)
		{
		try
			{
			if(debitAutorise(montant))
				{
				this.setSolde(this.getSolde() - montant);
				}
			else
				{
				throw new DebitException();
				}
			}
		catch(DebitException e)
			{
			e.printStackTrace();
			}

		}

	public void effectuerVirement(Compte compte, float montant) throws CreditException
		{
		this.debiter(montant);
		compte.crediter(montant);
		}

	abstract public void crediter(float montant) throws CreditException;

	protected void setSolde(float solde)
		{
		this.solde= solde;
		}

	abstract public TypeCompte typeCompte();
	}
