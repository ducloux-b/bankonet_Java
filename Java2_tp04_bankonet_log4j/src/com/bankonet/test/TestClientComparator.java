package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.ClientComparator;
import com.bankonet.model.Compte;
import com.bankonet.model.TypeCompte;

public class TestClientComparator
	{

	public static void main(String[] args)
		{
		List<Client> clientTab= new ArrayList<Client>();
		clientTab.add(new Client(0, "Jean", "Paul", new ArrayList<Compte>(), new ArrayList<Compte>()));
		clientTab.add(new Client(1, "Pierre", "Henry", new ArrayList<Compte>(), new ArrayList<Compte>()));
		clientTab.add(new Client(2, "Marie", "Lou", new ArrayList<Compte>(), new ArrayList<Compte>()));
		
//		clientTab.get(2).creerCompte(new CompteCourant("1",1, "CC1", 1000000000, 10));
//		clientTab.get(2).creerCompte(new CompteEpargne("CE1",
//												"compteEpargneClient1",
//												1000,
//												(float)0.1,
//												200000F));
//		clientTab.get(0).creerCompte(new CompteCourant("2",2, "CC2", 200, 20));
//		clientTab.get(0).creerCompte(new CompteEpargne("CE2",
//												"compteEpargneClient2",
//												2000,
//												(float)0.2,
//												100000000F));
//		clientTab.get(1).creerCompte(new CompteCourant("3",3, "CC3", 300, 30));
//
//		for(Client client: clientTab)
//			{
//			for(Compte compte: client.getComptes())
//				{
//				if(compte.typeCompte()==TypeCompte.COURANT){
//				System.out.println("Compte Courant:");
//				System.out.println(compte.toString());
//				}
//				if(compte.typeCompte()==TypeCompte.EPARGNE){
//				System.out.println("Compte Epargne:");
//				System.out.println(compte.toString());
//				}
//				}
//			}
		
		Collections.sort(clientTab, new ClientComparator());
		Collections.sort(clientTab,(o1,o2)->((Client)o1).getNom().compareTo(((Client)o2).getNom()));
		
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
