package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Other.Article;
import Other.ArticleDAO;
import Other.ArticleParser;

/**
 * Servlet implementation class RemoveRecordServlet
 */
@WebServlet("/RemoveRecordServlet")
public class RemoveRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticleParser articleParser;
	private ArticleDAO articleDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRecordServlet() {
		articleParser = new ArticleParser();
		articleDAO = new ArticleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

	    out.println("Remove article:");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Wykorzystaj parser do artyku³ów i pobierz artyku³ z requesta
		Article article = articleParser.parseArticleFromRequest(request);
		PrintWriter out = response.getWriter();
		
		out.println(article);
		//zapisz artyku³ do bazy danych
		//articleDAO.save(article);
        articleDAO.Connect();
        articleDAO.remove(article);
        articleDAO.closeConnection();
	}

}
