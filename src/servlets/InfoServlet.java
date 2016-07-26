package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,
            HttpServletResponse response)    throws ServletException, IOException {
      PrintWriter out = response.getWriter();

      String number1 = request.getParameter("n1");
      String number2 = request.getParameter("n2");
      String number3 = request.getParameter("n3");
      String number4 = request.getParameter("n4");
      String number5 = request.getParameter("n5");

      out.println("Wczytanie 5 liczb z zadania :");
      out.println(number1);
      out.println(number2);
      out.println(number3);
      out.println(number4);
      out.println(number5);
      out.println("Srednia: "+ avarge(number1, number2));
  }
	
	public float avarge(String n1, String n2){
		float avarge;
		
		avarge = Integer.parseInt(n1);
		
		return avarge;
	}
	
}


