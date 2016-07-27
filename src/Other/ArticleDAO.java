package Other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Biblioteka;

public class ArticleDAO {

	/**
    * Tutaj nale�y zdefiniowa� u�ytkownika, has�o, adres oraz
    * sterownik do bazy danych z kt�r� zamierzamy si� po��czy�.
    */
   private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/db";
   private final static String DBUSER = "root";
   private final static String DBPASS = "koliko";
   private final static String DBDRIVER = "com.mysql.jdbc.Driver";

   //obiekt tworz�cy po��czenie z baz� danych.
   private Connection connection;
   //obiekt pozwalaj�cy tworzy� nowe wyra�enia SQL
   private Statement statement;
   //zapytanie SQL
   private String query;
   //parser zapyta� SQL dla obiekt�w klasy Article
   private SQLArticleParser sqlArticleParser;

   public ArticleDAO() {
       //inicjalizacja parser�w
       sqlArticleParser = new SQLArticleParser();
   }
   
   public void Connect(){
       try {
           Class.forName(ArticleDAO.DBDRIVER);
       } catch (ClassNotFoundException e) {
           System.err.println("Brak sterownika JDBC");
           e.printStackTrace();
       }

       try {
           connection = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
           statement = connection.createStatement();
       } catch (SQLException e) {
           System.err.println("Problem z otwarciem polaczenia");
           e.printStackTrace();
       }
   }

   public void save(Article article) {
       query = sqlArticleParser.createSaveQuery(article);
       try {
    	   statement.execute(query);
       } catch (SQLException e) {
           System.err.println("Blad przy tworzeniu tabeli");
    	   e.printStackTrace();
       }
   }

   public void remove(Article article) {
       query = sqlArticleParser.createRemoveQuery(article);
       try {
    	   statement.execute(query);
       } catch (SQLException e) {
           System.err.println("Blad przy usuwaniu tabeli");
    	   e.printStackTrace();
       }
   }

   public String select(Article article) {
	   String record = "";
       query = sqlArticleParser.createSelectQuery(article);
       try {
    	   ResultSet result = statement.executeQuery(query);
    	   while(result.next()){
    		   int id = result.getInt("id");
    		   String title = result.getString("title");
    		   String description = result.getString("description");
    		   
    		   record += "ID: " + id + "\n"
    		   		+ "Title: " + title +"\n"
    		   		+ "Description: " + description;
    	   }
       } catch (SQLException e) {
           System.err.println("Blad przy usuwaniu tabeli");
    	   e.printStackTrace();
       }
       return record;
   }
   
   public boolean createTables()  {
       String createArticle = "CREATE TABLE IF NOT EXISTS `articles` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT, `title` varchar(255), `description` varchar(255))";
       try {
           statement.execute(createArticle);
       } catch (SQLException e) {
           System.err.println("Blad przy tworzeniu tabeli");
           e.printStackTrace();
           return false;
       }
       return true;
   }
   
   public void closeConnection() {
       try {
    	   statement.close();
           connection.close();
       } catch (SQLException e) {
           System.err.println("Problem z zamknieciem polaczenia");
           e.printStackTrace();
       }
   }
   
}
