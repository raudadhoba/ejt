<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>IF DEMO</title> 
    </head> 
    <body> 
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        <c:set var="x" value="${param.x}"/> 
        <c:set var="y" value="${param.y}"/> 

        <c:if test="${x > y}"> 
            <font color="blue"><h2>The Ans is:</h2></font> 
            <c:out value="${x} is greater than ${y}"/> 
        </c:if> 
        <c:if test="${y > x}"> 
            <font color="blue"><h2>The Ans is:</h2></font> 
            <c:out value="${y} is greater than ${x}"/> 
        </c:if>
        <c:if test="${x == y}"> 
            <font color="blue"><h2>The Ans is:</h2></font> 
            <c:out value="${x} is equal to ${y}"/> 
        </c:if>
    </body> 
</html> 
