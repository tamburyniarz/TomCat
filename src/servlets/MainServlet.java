package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.fastinfoset.util.StringArray;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)    throws ServletException, IOException {
      PrintWriter out = response.getWriter();

      String n1 = request.getParameter("n1");
      String n2 = request.getParameter("n2");
      String n3 = request.getParameter("n3");

      
      out.println("Wczytanie 3 liczb z zadania :");
      out.println("Srednia: ");
  }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)   throws ServletException, IOException {
        PrintWriter out = response.getWriter();
     
        out.println("Wczytanie 3 parametrow z zadania :");
        out.println(request.getParameter("parametr1"));
        out.println(request.getParameter("parametr2"));
        out.println(request.getParameter("parametr3"));
    }
}
