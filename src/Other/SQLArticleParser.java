package Other;

public class SQLArticleParser {

	public String createSaveQuery(Article article) {
		String query = "";
		 
        /**
         * Dodaj do tabeli "articles" warto�ci id, title i text.
         * id jest nullem, poniewa� pole id jest autoinkrementowane
         * przez baz� danych.
         * INSERT INTO articles VALUES (NULL, 'title', 'text');
         */
        //query = "INSERT INTO articles VALUES (NULL, '" + article.getTite() + "', '" + article.getText() +"');";
 
        return query;
	}

}
