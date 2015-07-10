package com.bankonet.model;

public class Client
	{

	private String				identifiant;
	private String				nom;
	private String				prenom;
	private CompteCourant	compteCourant;
	private CompteEpargne	compteEpargne;

	public Client(String identifiant, String nom, String prenom)
		{
		super();
		this.identifiant= identifiant;
		this.nom= nom;
		this.prenom= prenom;
		}

	public CompteCourant getCompteCourant()
		{
		return compteCourant;
		}

	public void setCompteCourant(	int identifiant,
											String libelle,
											float solde,
											float decouvertAutorise)
		{
		this.compteCourant= new CompteCourant(identifiant, libelle, solde,
															decouvertAutorise);
		}

	public CompteEpargne getCompteEpargne()
		{
		return compteEpargne;
		}

	public void setCompteEpargne(	String numero,
											String intitule,
											float solde,
											float tauxInteret,
											float plafond)
		{
		this.compteEpargne= new CompteEpargne(numero, intitule, solde,
															tauxInteret, plafond);
		}

	public String getIdentifiant()
		{
		return identifiant;
		}

	public String getNom()
		{
		return nom;
		}

	public String getPrenom()
		{
		return prenom;
		}

	public float calculerAvoirGlobal()
		{
		float res= 0;
		if(this.compteCourant != null)
			{
			res+= (float)this.compteCourant.getSolde();
			}
		if(this.compteEpargne != null)
			{
			res+= (float)this.compteEpargne.getSolde();
			}

		return res;
		}

	public String toString()
		{
		String res= "nom:" + this.nom + "\nprenom:" + this.prenom +
						"\navoirGlobal:" + this.calculerAvoirGlobal();

		return(res);
		}
	}
