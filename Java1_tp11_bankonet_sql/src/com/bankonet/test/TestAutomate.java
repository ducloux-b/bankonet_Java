package com.bankonet.test;

import com.bankonet.model.CompteStat;

public class TestAutomate
	{

	public static void main(String[] args)
		{
		CompteStat[] compteTab = DonneesTest.construitEchantillonComptes();
		
		float somme = 0;
		for(CompteStat compteStat: compteTab)
			{
			somme+= compteStat.getSolde();
			}
		float res = somme/compteTab.length;
		
		System.out.println("moyenne des soldes:"+res);
		}

	}
