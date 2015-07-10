package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client implements Comparable<Client>
	{

	private String			identifiant;
	private String			nom;
	private String			prenom;
	// private CompteCourant compteCourant;
	// private CompteEpargne compteEpargne;
	private List<Compte>	comptes	= new ArrayList<Compte>();

	public Client(String identifiant, String nom, String prenom)
		{
		super();
		this.identifiant= identifiant;
		this.nom= nom;
		this.prenom= prenom;
		}

	public void creerCompte(Compte compte)
		{
		this.comptes.add(compte);
		}

	public void supprimerCompte(Compte compte)
		{
		this.comptes.remove(compte);
		}

	public void supprimerCompte(String numero) throws CompteNonTrouveException
		{
		Compte compte = this.retournerCompte(numero);
		this.comptes.remove(compte);
		}
	public Compte retournerCompte(String numero) throws CompteNonTrouveException
		{
		for(Compte compte: comptes)
			{
			if(compte.getNumero().equals(numero))
				{
				return compte;
				}
			}
		throw new CompteNonTrouveException();
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
		for(Compte compte: this.getComptes())
			{
			res+= compte.getSolde();
			}
		return res;
		}

	public List<Compte> getComptes()
		{
		return Collections.unmodifiableList(comptes);
		}

	public String toString()
		{
		String res= "nom:" + this.nom + "\nprenom:" + this.prenom +
						"\navoirGlobal:" + this.calculerAvoirGlobal();

		return(res);
		}

	@Override
	public int compareTo(Client client)
		{
		if(client instanceof Client)
			{
			return this.getIdentifiant().compareTo(((Client)client).getIdentifiant());
			}
		throw new ClassCastException();
		}
	}
