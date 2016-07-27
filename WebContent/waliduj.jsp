<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <!-- Użycie tagu jsp:useBean. Tag ten szuka obiektu klasy User z pakiecie
    javastart.jspexample.model w sesji użytkownika. Jeśli znajdzie, to go 
    wykorzysta, jeśli nie stworzy nowy obiekt klasy user o nazwie "user"-->
    <jsp:useBean id="user" class="javastart.jspexample.model.User"
        scope="session"></jsp:useBean>
 
    <!-- Użycie tagu jsp:setProperty. Tag ten umieszcza wszystkie parametry
    przesyłane z innych plików jsp pasujące do obiektu o nazwie user. Jeśli
    parametry te nie będą się zgadzać, tomcat wyrzuci wyjątkiem -->
    <jsp:setProperty property="*" name="user" />
        
        <%
        System.out.println( user );
        %>
</body>
</html>