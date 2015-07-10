package com.bankonet.test;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteException;
import com.bankonet.model.CreditException;

public class TestClient
	{

	public static void main(String[] args)
		{
		Client[] clientTab= {
				new Client("1", "Client", "Jean"),
				new Client("2", "Client", "Paul"),
				new Client("3", "Client", "Henry")};
		clientTab[0].setCompteCourant(1, "CC1", 1000000000, 10);
		clientTab[0].setCompteEpargne("CE1",
												"compteEpargneClient1",
												1000,
												(float)0.1,
												200000F);
		clientTab[1].setCompteCourant(2, "CC2", 200, 20);
		clientTab[1].setCompteEpargne("CE2",
												"compteEpargneClient2",
												2000,
												(float)0.2,
												100000000F);
		clientTab[2].setCompteCourant(3, "CC3", 300, 30);

		for(Client client: clientTab)
			{
			if(client.getCompteCourant() != null)
				{
				System.out.println("CC:" + client.getCompteCourant().toString());
				}
			if(client.getCompteEpargne() != null)
				{
				System.out.println("CE:" + client.getCompteEpargne().toString());
				}
			// System.out.println("avoirGlobal:" + client.calculerAvoirGlobal());
			}
		// clientTab[0].getCompteCourant().debiter(150);

		Compte compteN= clientTab[1].getCompteCourant();
		System.out.println(compteN.toString());

		try
			{
			clientTab[1].getCompteCourant()
					.effectuerVirement(clientTab[1].getCompteEpargne(), 2000);
			}
		catch(CreditException e1)
			{
			e1.printStackTrace();
			}

		// clientTab[0].getCompteCourant()
		// .effectuerVirement(clientTab[0].getCompteEpargne(), 1000000000);

		try
			{
			clientTab[0].getCompteCourant()
					.effectuerVirement(clientTab[0].getCompteEpargne(), 1000000000);
			}
		catch(CompteException e)
			{
			System.out.println("Halala il y a un problème!...!");
			}
		}
	}
