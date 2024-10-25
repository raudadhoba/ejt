 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP PAGE</title> 
    </head> 
    <body> 
        <h1>USE OF INTRINSIC OBJECTS</h1> 
        <h1>REQUEST OBJECTS</h1> 
        Query String : <%=request.getQueryString() %><br> 
        Context Path : <%=request.getContextPath() %><br> 
        Remote Host : <%=request.getRemoteHost()%><br> 
 
        <h1>RESPONSE OBJECT</h1> 
        Character Encoding Type : <%=response.getCharacterEncoding()%><br> 
        Content Type : <%=response.getContentType()%><br> 
        Locale : <%=response.getLocale()%><br> 
 
        <h1>SESSION OBJECT</h1> 
        ID : <%=session.getId()%><br> 
        Creation Time : <%=new java.util.Date(session.getCreationTime())%><br> 
        Last Access Time : <%=new 
java.util.Date(session.getLastAccessedTime())%><br> 
    </body> 
</html> 