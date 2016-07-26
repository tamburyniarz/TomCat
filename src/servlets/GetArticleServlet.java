package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Other.ArticleParser;
import Other.Article;
import Other.ArticleDAO;

/**
 * Servlet implementation class GetArticleServlet
 */
@WebServlet("/GetArticleServlet")
public class GetArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleParser articleParser;
	private ArticleDAO articleDAO;

	public GetArticleServlet() {
		articleParser = new ArticleParser();
		// articleDAO = new ArticleDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

	    out.println("Article:");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		//Wykorzystaj parser do artyku³ów i pobierz artyku³ z requesta
		Article article = articleParser.parseArticleFromRequest(request);
		PrintWriter out = response.getWriter();
	     
        out.println(article);
		//zapisz artyku³ do bazy danych
		articleDAO.save(article);
	}

}
