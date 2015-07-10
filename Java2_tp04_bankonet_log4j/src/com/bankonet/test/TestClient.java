package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.TypeCompte;
import com.bankonet.model.jdbc.ClientDao;
import com.bankonet.model.jdbc.CreationConnexionException;

public class TestClient
	{
	
	static Logger logger = Logger.getLogger(TestClient.class);

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

		logger.setLevel(Level.INFO);
		logger.warn("message affiché");
		logger.debug("on ne doit pas voir");
		
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
			logger.info(client.toString());
			System.out.println();
			}
		
		System.out.println("test lireClient():");
		Client client = clientDao.lireClient(1);
		logger.info(client.toString());
		
		logger.info("test lireComptesCourant():");
		ArrayList<Compte> ComptesCourantClient1 = clientDao.lireComptesCourant(client);
		for(Compte compte: ComptesCourantClient1)
			{
			logger.info(compte.toString());
			}
		System.out.println();
		
		logger.info("test lireComptesEpargne():");
		ArrayList<Compte> ComptesEpargneClient1 = clientDao.lireComptesEpargne(client);
		for(Compte compte: ComptesEpargneClient1)
			{
			logger.info(compte.toString());
			}
		System.out.println();
		}
	}
