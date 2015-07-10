package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.TypeCompte;
import com.bankonet.model.jdbc.ClientDao;
import com.bankonet.model.jdbc.CreationConnexionException;

public class TestClient
	{

	public static void main(String[] args)
		{
//		List<Client> clientTab= new ArrayList<Client>();
//		List<ArrayList<Compte>> tmp= DonneesTest.construitEchantillonComptes();
//		clientTab.add(new Client("2", "Client", "Paul", tmp.get(0), tmp.get(1)));
//		clientTab.add(new Client("3", "Client", "Henry", tmp.get(0), tmp.get(1)));
//		clientTab.add(new Client("1", "Client", "Jean", tmp.get(0), tmp.get(1)));
//
//		for(Client client: clientTab)
//			{
//			for(Compte compte: client.getCompteCourantList())
//				{
//				if(compte.typeCompte() == TypeCompte.COURANT)
//					{
//					System.out.println("Compte Courant:");
//					System.out.println(compte.toString());
//					}
//				}
//			System.out.println();
//			for(Compte compte1: client.getCompteEpargneList())
//				{
//				if(compte1.typeCompte() == TypeCompte.EPARGNE)
//					{
//					System.out.println("Compte Epargne:");
//					System.out.println(compte1.toString());
//					}
//				}
//			System.out.println();
//			System.out.println();
//			}

		ClientDao clientDao = null;
		try
			{
			clientDao= new ClientDao();
			}
		catch(CreationConnexionException e)
			{
			e.printStackTrace();
			}
		List<Client> clients = clientDao.lireClients();
		for(Client client: clients)
			{
			System.out.println(client.toString());
			System.out.println();
			}
		
		System.out.println("test lireClient():");
		Client client = clientDao.lireClient(1);
		System.out.println(client.toString());
		System.out.println();
		
		System.out.println("test lireComptesCourant():");
		ArrayList<Compte> ComptesCourantClient1 = clientDao.lireComptesCourant(client);
		for(Compte compte: ComptesCourantClient1)
			{
			System.out.println(compte.toString());
			}
		System.out.println();
		
		System.out.println("test lireComptesEpargne():");
		ArrayList<Compte> ComptesEpargneClient1 = clientDao.lireComptesEpargne(client);
		for(Compte compte: ComptesEpargneClient1)
			{
			System.out.println(compte.toString());
			}
		System.out.println();
		}
	}
