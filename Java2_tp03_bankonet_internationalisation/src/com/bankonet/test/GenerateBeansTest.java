package com.bankonet.test;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.bankonet.model.Client;

public class GenerateBeansTest
	{

	public static void main(String[] args)
		{
		GenerateBeansTest gb= new GenerateBeansTest();
		Client client= new Client();

		// exemple de chargement par réflexion
		gb.generateBeanInstance(client);

		// exemple de chargement par valeurs
		gb.generateBeanInstance(client);
		}

	public void generateBeanInstance(Client client)
		{
		Map clientData = getClientData();
		Set clientDataKeys = clientData.keySet();
		Iterator clientDataKeysIterator = clientDataKeys.iterator();
		
		try
			{
			Class clientClass = client.getClass();
			while(clientDataKeysIterator.hasNext())
				{
				String key = (String) clientDataKeysIterator.next();
				Class[] parameterTypes = new Class[]
							{
				         clientData.get(key).getClass()                        
							};
				String methodName = "set" + key;
				Method setterMethod = clientClass.getMethod(methodName, parameterTypes);
				Object[] arguments = new Object[] {getClientData().get(key)};
				System.out.println("Invocation de la méthode trouvée ("+setterMethod+")...");
				setterMethod.invoke(client, arguments);
				}
			System.out.println();
			System.out.println("2ème méthode d'instanciation (par réflexion"+"avec la méthode generateBeanInstance");
			System.out.println();
			this.print(client);
			}
		catch(Exception e)
			{
			// TODO: handle exception
			}
		}

	private void print(Client client)
		{
		// TODO Auto-generated method stub
		
		}

	public Map getClientData()
		{
		Map dataBeans= new HashMap();
		dataBeans.put("Identifiant", new Integer(43));
		dataBeans.put("Prenom", "Marcel");
		dataBeans.put("Nom", "Aymé");
		return dataBeans;
		}

	}
