package Other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ArticleDAO {

	/**
    * Tutaj nale�y zdefiniowa� u�ytkownika, has�o, adres oraz
    * sterownik do bazy danych z kt�r� zamierzamy si� po��czy�.
    */
   private final static String DBURL = "jdbc:mysql://127.0.0.1:3306";
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

   public void save(Article article) {
       query = sqlArticleParser.createSaveQuery(article);

       try {
           Class.forName(DBDRIVER).newInstance();
           connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
           statement = connection.createStatement();
           statement.executeUpdate(query);

                       //zwolnienie zasob�w i zamkni�cie po��czenia
                       statement.close();
                       connection.close();
       }
   }
   
}
