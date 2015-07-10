package com.bankonet.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class ClientDao
	{
	private String			DRIVER_NAME	= "com.mysql.jdbc.Driver";
	private String			DB_URL		= "jdbc:mysql:///banque";
	private String			DB_LOGIN		= "ben";
	private String			DB_PASSWORD	= "";
	private Connection	connexion;

	public ClientDao() throws CreationConnexionException
		{
		try
			{
			Class.forName(DRIVER_NAME);
			connexion= DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
			}
		catch(ClassNotFoundException ex)
			{
			System.err.println("Impossible de charger le driver");

			throw new CreationConnexionException(
																"Erreur lors de la connexion au réseau");
			}
		catch(SQLException e)
			{
			throw new CreationConnexionException(
																"Erreur lors de la connexion au réseau");
			}
		}

	public void closeConnection()
		{
		try
			{
			connexion.close();
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		}

	public List<Client> lireClients()
		{
		List<Client> clients= new ArrayList<Client>();
		Statement statement= null;
		ResultSet res= null;
		try
			{
			statement= connexion.createStatement();
			res= statement.executeQuery("SELECT * FROM `client`");
			while(res.next())
				{
				clients.add(new Client((Integer)res.getInt("ID"), res
						.getString("NOM"), res.getString("PRENOM"), null, null));

				}
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		finally
			{
			if(statement != null)
				{
				try
					{
					statement.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			if(res != null)
				{
				try
					{
					res.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			}

		return clients;
		}

	public Client lireClient(int identifiant)
		{
		PreparedStatement preparedStatement= null;
		ResultSet res= null;
		Client client= null;

		try
			{
			preparedStatement= connexion
					.prepareStatement("SELECT * FROM `client` WHERE ID=?");
			preparedStatement.setInt(1, identifiant);
			res= preparedStatement.executeQuery();
			while(res.next())
				{
				return new Client(identifiant, res.getString("NOM"),
										res.getString("PRENOM"), null, null);
				}
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		finally
			{
			if(preparedStatement != null)
				{
				try
					{
					preparedStatement.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			if(res != null)
				{
				try
					{
					res.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			}

		return client;
		}

	public ArrayList<Compte> lireComptesCourant(Client client)
		{
		ArrayList<Compte> comptes= new ArrayList<Compte>();

		PreparedStatement preparedStatement= null;
		ResultSet res= null;

		try
			{
			preparedStatement= connexion
					.prepareStatement("SELECT * FROM `compte` WHERE `ID_CLIENT` = ? AND `LIBELLE` REGEXP '^courant.*$'");
			preparedStatement.setInt(1, client.getIdentifiant());
			res= preparedStatement.executeQuery();
			while(res.next())
				{
				comptes.add(new CompteCourant(res.getInt("ID"), res
						.getInt("ID_CLIENT"), res.getString("LIBELLE"), res
						.getFloat("SOLDE"), res.getFloat("DECOUVERTAUTORISE")));
				}
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		finally
			{
			if(preparedStatement != null)
				{
				try
					{
					preparedStatement.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			if(res != null)
				{
				try
					{
					res.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			}

		return comptes;
		}

	public ArrayList<Compte> lireComptesEpargne(Client client)
		{
		ArrayList<Compte> comptes= new ArrayList<Compte>();

		PreparedStatement preparedStatement= null;
		ResultSet res= null;

		try
			{
			preparedStatement= connexion
					.prepareStatement("SELECT * FROM `compte` WHERE `ID_CLIENT` = ? AND `LIBELLE` REGEXP '^epargne.*$'");
			preparedStatement.setInt(1, client.getIdentifiant());
			res= preparedStatement.executeQuery();
			while(res.next())
				{
				comptes.add(new CompteEpargne(res.getInt("ID"), res
						.getString("LIBELLE"), res.getFloat("SOLDE"), res
						.getFloat("TAUX"), res.getFloat("PLAFOND")));
				}
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		finally
			{
			if(preparedStatement != null)
				{
				try
					{
					preparedStatement.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			if(res != null)
				{
				try
					{
					res.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			}

		return comptes;
		}

	public void ecrireClient(Client client, Compte compte)
		{
		PreparedStatement preparedStatement= null;

		try
			{
			preparedStatement= connexion
					.prepareStatement("INSERT INTO `compte` (ID,LIBELLE,SOLDE,ID_CLIENT,DECOUVERTAUTORISE,DISCRIMINANT) VALUES(?,?,?,?,?,?)");
			
			if(compte instanceof CompteCourant)
				{
				preparedStatement.setInt(1, 123);
				preparedStatement.setString(2, ((CompteCourant)compte).getLibelle());
				preparedStatement.setFloat(3,	((CompteCourant)compte).getSolde());
				preparedStatement.setInt(4, client.getIdentifiant());
				preparedStatement.setFloat(5,	((CompteCourant)compte).getDecouvertAutorise());
				preparedStatement.setString(6, "CC");
				}
			if(compte instanceof CompteEpargne)
				{
				preparedStatement.setInt(1, 321);
				preparedStatement.setString(2, ((CompteEpargne)compte).getIntitule());
				preparedStatement.setFloat(3,	((CompteEpargne)compte).getSolde());
				preparedStatement.setInt(4, client.getIdentifiant());
				preparedStatement.setFloat(5,	(Float)null);
				preparedStatement.setString(6, "CE");
				}
			preparedStatement.executeUpdate();
			preparedStatement.close();
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
		finally
			{
			if(preparedStatement != null)
				{
				try
					{
					preparedStatement.close();
					}
				catch(SQLException e)
					{
					e.printStackTrace();
					}
				}
			}
		}

	}
