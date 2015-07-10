package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.TypeCompte;

public class TestClient
	{

	public static void main(String[] args)
		{
		List<Client> clientTab= new ArrayList<Client>();
		List<ArrayList<Compte>> tmp= DonneesTest.construitEchantillonComptes();
		clientTab.add(new Client("2", "Client", "Paul", tmp.get(0), tmp.get(1)));
		clientTab.add(new Client("3", "Client", "Henry", tmp.get(0), tmp.get(1)));
		clientTab.add(new Client("1", "Client", "Jean", tmp.get(0), tmp.get(1)));

		for(Client client: clientTab)
			{
			for(Compte compte: client.getCompteCourantList())
				{
				if(compte.typeCompte() == TypeCompte.COURANT)
					{
					System.out.println("Compte Courant:");
					System.out.println(compte.toString());
					}
				}
			System.out.println();
			for(Compte compte1: client.getCompteEpargneList())
				{
				if(compte1.typeCompte() == TypeCompte.EPARGNE)
					{
					System.out.println("Compte Epargne:");
					System.out.println(compte1.toString());
					}
				}
			System.out.println();
			System.out.println();
			}

		}
	}
