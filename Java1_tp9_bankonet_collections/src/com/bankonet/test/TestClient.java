package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.CompteNonTrouveException;
import com.bankonet.model.TypeCompte;

public class TestClient
	{

	public static void main(String[] args)
		{
		List<Client> clientTab= new ArrayList<Client>();
		clientTab.add(new Client("2", "Client", "Paul"));
		clientTab.add(new Client("3", "Client", "Henry"));
		clientTab.add(new Client("1", "Client", "Jean"));
		
		clientTab.get(2).creerCompte(new CompteCourant("1",1, "CC1", 1000000000, 10));
		clientTab.get(2).creerCompte(new CompteEpargne("CE1",
												"compteEpargneClient1",
												1000,
												(float)0.1,
												200000F));
		clientTab.get(0).creerCompte(new CompteCourant("2",2, "CC2", 200, 20));
		clientTab.get(0).creerCompte(new CompteEpargne("CE2",
												"compteEpargneClient2",
												2000,
												(float)0.2,
												100000000F));
		clientTab.get(1).creerCompte(new CompteCourant("3",3, "CC3", 300, 30));

		for(Client client: clientTab)
			{
			for(Compte compte: client.getComptes())
				{
				if(compte.typeCompte()==TypeCompte.COURANT){
				System.out.println("Compte Courant:");
				System.out.println(compte.toString());
				}
				if(compte.typeCompte()==TypeCompte.EPARGNE){
				System.out.println("Compte Epargne:");
				System.out.println(compte.toString());
				}
				}
			}
		
		try
			{
			clientTab.get(0).retournerCompte("3");
			}
		catch(CompteNonTrouveException e)
			{
			e.printStackTrace();
			}
		
		Collections.sort(clientTab);
		for(Client client: clientTab)
			{
			for(Compte compte: client.getComptes())
				{
				if(compte.typeCompte()==TypeCompte.COURANT){
				System.out.println("Compte Courant:");
				System.out.println(compte.toString());
				}
				if(compte.typeCompte()==TypeCompte.EPARGNE){
				System.out.println("Compte Epargne:");
				System.out.println(compte.toString());
				}
				}
			}
		}
	}
