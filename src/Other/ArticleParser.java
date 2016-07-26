package Other;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

public class ArticleParser {
	
	public Article parseArticleFromRequest(HttpServletRequest request) {
		
		Article article = new Other.Article();
		
		article.setId(Integer.parseInt(request.getParameter("id")));
		article.setTite(request.getParameter("title"));
		article.setText(request.getParameter("text"));
		return article;
	}

}
