package com.bankonet.test;

import com.bankonet.model.CompteCourant;

public class TestCompteCourant
	{

	public static void main(String[] args)
		{
		CompteCourant compteCourant1= new CompteCourant("1",1, "compte1", 100, 20);
		CompteCourant compteCourant2= new CompteCourant("2",2, "compte2", 3000, 0);
		CompteCourant compteCourant3= new CompteCourant("3",3, "compte3", 100000, 200);

		// System.out.println(compteCourant1.toString());
		// System.out.println(compteCourant2.toString());
		// System.out.println(compteCourant3.toString());

		CompteCourant[] compteCourantTab= {
				compteCourant1,
				compteCourant2,
				compteCourant3};

		CompteCourant compteCourant4= new CompteCourant("4",4, "compte4", -50, 20);
		System.out.println(compteCourant4.toString());

		int solde= 0;
		switch(solde)
			{
			case 0:
				System.out.println("solde nul");
				break;
			case 10000:
				System.out.println("solde créditeur");
				break;
			default:
				System.out.println("ras");
				break;
			}

		for(CompteCourant compteCourant: compteCourantTab)
			{
			System.out.println(compteCourant.toString());
			}

		int i= 0;
		while(i < compteCourantTab.length)
			{
			CompteCourant compteCourant= (CompteCourant)compteCourantTab[i];
			System.out.println(compteCourant.toString());
			i++;
			}

		for(CompteCourant compteCourant: compteCourantTab)
			{
			switch(compteCourant.typeCompte())
				{
				case EPARGNE:
					System.out.println("EPARGNER!!!!!");
					break;
				case COURANT:
					System.out.println("DEPENSER!!!");
					break;
				default:
					System.out.println("pas un type de compte valide");
					break;
				}
			}
		
		compteCourant4.debiter(1000);
		}
	}
