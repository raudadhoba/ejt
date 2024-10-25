<%@page contentType="text/html" pageEncoding="UTF-8" import="mypackage.*"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP PAGE</title> 
    </head> 
    <body> 
    <body> 
        <h1>VALIDATION PAGE</h1> 
        <jsp:useBean id="obj" scope="request" class="mypackage.CheckerBean"> 
            <jsp:setProperty name="obj" property="*"/> 
        </jsp:useBean> 
        <%if(obj.validate()) {%> 
        <jsp:forward page="Sucessful.jsp"/> 
        <% } 
        else 
       {%> 
         <jsp:include page="index.html"/> 
         <%}%> 
        <%=obj.getError()%> 
    </body> 
</html> 