package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class DonneesTest {

	public static List<ArrayList<Compte>> construitEchantillonComptes() {
		List<Compte> tabComptesCourant = new ArrayList<Compte>();
		tabComptesCourant.add(new CompteCourant("1",1, "compte courant 1", 0, 1000));
		tabComptesCourant.add(new CompteCourant("2",2, "compte courant 2", 500, 200));
		tabComptesCourant.add(new CompteCourant("3",3, "compte courant 3", 20, 0));
		
		List<Compte> tabComptesEpargne = new ArrayList<Compte>();
		tabComptesEpargne.add(new CompteEpargne("4", "compte épargne 4", 1, 2.54F, 20000000F));
		tabComptesEpargne.add(new CompteEpargne("5", "compte épargne 5", 1000000,13.42F,123456789F));

		List<ArrayList<Compte>> res = new ArrayList<ArrayList<Compte>>();
		res.add((ArrayList<Compte>)tabComptesCourant);
		res.add((ArrayList<Compte>)tabComptesEpargne);
		return res;

	}

	
}
