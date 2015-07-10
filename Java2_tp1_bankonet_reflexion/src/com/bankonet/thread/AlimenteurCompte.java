package com.bankonet.thread;

import com.bankonet.model.Compte;

public class AlimenteurCompte implements Runnable
	{
	private Compte compte;
	private Float somme;
	private Integer timer;
	
	public AlimenteurCompte(Compte compte, Float somme,Integer timer)
		{
		this.set_compte(compte);
		this.set_somme(somme);
		this.set_timer(timer);
		}
	
	@Override
	public void run()
		{
		Float solde = this.get_compte().getSolde();
		System.out.println("Thread ("+this.toString()+") Solde:"+solde);
		
		try
			{
			Thread.sleep(this.get_timer());
			}
		catch(InterruptedException e)
			{
			System.err.println("Problème de sleep dans run()");
			e.printStackTrace();
			}
		this.get_compte().setSolde(this.get_compte().getSolde()+this.get_somme());
		
		solde = this.get_compte().getSolde();
		System.out.println("Thread ("+this.toString()+") Solde:"+solde);
		}

	private Compte get_compte()
		{
		return compte;
		}

	private Float get_somme()
		{
		return somme;
		}

	private Integer get_timer()
		{
		return timer;
		}

	private void set_compte(Compte compte)
		{
		this.compte= compte;
		}

	private void set_somme(Float somme)
		{
		this.somme= somme;
		}

	private void set_timer(Integer timer)
		{
		this.timer= timer;
		}

	}
