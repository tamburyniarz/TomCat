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
 * Servlet implementation class SelectRecordServlet
 */
@WebServlet("/SelectRecordServlet")
public class SelectRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleParser articleParser;
	private ArticleDAO articleDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRecordServlet() {
		articleParser = new ArticleParser();
		articleDAO = new ArticleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

	    out.println("Selected item:");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		//Wykorzystaj parser do artyku³ów i pobierz artyku³ z requesta
		Article article = articleParser.parseArticleFromRequest(request);
		PrintWriter out = response.getWriter();
		
        articleDAO.Connect();
        String selected_item = articleDAO.select(article);

	    out.println(selected_item);
        articleDAO.closeConnection();
	}

}
