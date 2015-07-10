package com.bankonet.model;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client>
	{

	public ClientComparator()
		{
		// TODO Auto-generated constructor stub
		}

	@Override
	public int compare(Client arg0, Client arg1)
		{
		int cmp = arg0.getPrenom().compareTo(arg1.getPrenom());
		if(cmp==0)
			{
			cmp = arg0.getNom().compareTo(arg1.getNom());
			}
		return cmp;
		}

	}
