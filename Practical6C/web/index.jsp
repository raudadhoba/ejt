<%@page import="java.util.Iterator, java.util.List, javax.naming.InitialContext, ejb.ShoppingCart" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%! 
private static ShoppingCart cart;

public void jspInit() {
    try {
        InitialContext ic = new InitialContext();
       cart = (ShoppingCart) ic.lookup("java:global/PRACTICAL6C/PRACTICAL6C-MyPkg/ShoppingCart");

    } catch (Exception ex) {
        System.out.println("Could not create cart bean: " + ex.getMessage());
    }
}
%>

<%
if (request.getParameter("txtCustomerName") != null) {
    cart.initialize(request.getParameter("txtCustomerName"));
} else {
    cart.initialize("Guest");
}

if (request.getParameter("btnRmvBook") != null) {
    String[] books = request.getParameterValues("chkBook");
    if (books != null) {
        for (String book : books) {
            cart.removeBook(book);
        }
    }
}

if (request.getParameter("btnAddBook") != null) {
    String[] books = request.getParameterValues("chkBook");
    if (books != null) {
        for (String book : books) {
            cart.addBook(book);
        }
    }
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Cart</title>
</head>
<body style="background-color: pink;">
    <h1 style="text-align: center;">Books For Sale</h1><br>

    <form method="post">
        Customer Name: 
        <input type="text" name="txtCustomerName" value="<%= request.getParameter("txtCustomerName") %>" /><br>

        <b>Book Titles</b><br>
        <input type="checkbox" name="chkBook" value="Struts 2.0 For Beginners"> Struts 2.0 For Beginners<br>
        <input type="checkbox" name="chkBook" value="Oracle 11g For Professionals"> Oracle 11g For Professionals<br>
        <input type="checkbox" name="chkBook" value="Hibernate 3 For Beginners"> Hibernate 3 For Beginners<br>
        <input type="checkbox" name="chkBook" value="Java Persistence API In EJB 3 For Beginners"> Java Persistence API In EJB 3 For Beginners<br><br>

        <input type='submit' value='Add To My Basket' name='btnAddBook'>
        <input type='submit' value='Remove From My Basket' name='btnRmvBook'><br><br><br>

        <%
        if (cart != null) {
            out.print("<b>Basket</b><br>");
            List<String> bookList = cart.getContents();
            for (String title : bookList) {
                out.print(title + "<br>");
            }
        }
        %>
    </form>
</body>
</html>
