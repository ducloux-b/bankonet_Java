package com.bankonet.model;

final public class CompteCourant extends Compte
	{

	private int		numero;
	private int		identifiant;
	private String	libelle;
	private float	decouvertAutorise;

	public CompteCourant(int numero, int identifiant, String libelle,
								float solde, float decouvertAutorise)
		{
		super(solde);
		this.setNumero(numero);
		this.identifiant= identifiant;
		this.libelle= libelle;

		this.decouvertAutorise= decouvertAutorise;
		}

	public int getIdentifiant()
		{
		return identifiant;
		}

	public void setIdentifiant(int identifiant)
		{
		this.identifiant= identifiant;
		}

	public String getLibelle()
		{
		return libelle;
		}

	public void setLibelle(String libelle)
		{
		this.libelle= libelle;
		}

	public float getDecouvertAutorise()
		{
		return decouvertAutorise;
		}

	public void setDecouvertAutorise(float decouvertAutorise)
		{
		this.decouvertAutorise= decouvertAutorise;
		}

	@Override
	public boolean debitAutorise(float montant)
		{
		return(this.getSolde() + this.decouvertAutorise >= montant);
		}

	public boolean creditAutorise(float montant)
		{
		return(true);
		}

	@Override
	public String toString()
		{
		String res= "id:" + this.identifiant + " libelle:" + this.libelle + " " +
						super.toString() + " decouvert autorisé:" +
						this.decouvertAutorise;
		return(res);
		}

	@Override
	public TypeCompte typeCompte()
		{
		return TypeCompte.COURANT;
		}

	@Override
	public void crediter(float montant)
		{
		this.setSolde(this.getSolde() + montant);
		}

	public int getNumero()
		{
		return this.numero;
		}

	public void setNumero(int numero)
		{
		this.numero= numero;
		}

	}
