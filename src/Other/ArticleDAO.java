package Other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ArticleDAO {

	/**
    * Tutaj nale¿y zdefiniowaæ u¿ytkownika, has³o, adres oraz
    * sterownik do bazy danych z któr¹ zamierzamy siê po³¹czyæ.
    */
   private final static String DBURL = "jdbc:mysql://127.0.0.1:3306";
   private final static String DBUSER = "root";
   private final static String DBPASS = "koliko";
   private final static String DBDRIVER = "com.mysql.jdbc.Driver";

   //obiekt tworz¹cy po³¹czenie z baz¹ danych.
   private Connection connection;
   //obiekt pozwalaj¹cy tworzyæ nowe wyra¿enia SQL
   private Statement statement;
   //zapytanie SQL
   private String query;
   //parser zapytañ SQL dla obiektów klasy Article
   private SQLArticleParser sqlArticleParser;

   public ArticleDAO() {
       //inicjalizacja parserów
       sqlArticleParser = new SQLArticleParser();
   }

   public void save(Article article) {
       query = sqlArticleParser.createSaveQuery(article);

       try {
           Class.forName(DBDRIVER).newInstance();
           connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
           statement = connection.createStatement();
           statement.executeUpdate(query);

                       //zwolnienie zasobów i zamkniêcie po³¹czenia
                       statement.close();
                       connection.close();
       }
   }
   
}
