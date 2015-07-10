package com.bankonet.thread;

import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CreditException;
import com.bankonet.model.TypeCompte;

public class TestThreads
	{

	public static void main(String[] args)
		{
		Compte compte =  new CompteCourant(0, 0, "000", 1000, 200);
		
		Thread th1 = new Thread(new AlimenteurCompte(compte, new Float(100), 10000));
		Thread th2 = new Thread(new AlimenteurCompte(compte, new Float(-100), 5000));
		
		th1.start();
		th2.start();
		}

	}
