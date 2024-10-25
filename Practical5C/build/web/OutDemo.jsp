<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>OUT DEMO</title> 
    </head> 
    <body> 
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        <c:set var="name" value="ABC"/> 
        My name is: <c:out value= "${name}" /> 
    </body> 
</html>