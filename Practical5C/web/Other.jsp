
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>CHOOSE WHEN OTHERWISE</title> 
    </head> 
    <body> 
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        <c:set var="income" value="${40000*4}"/> 
        YOUR INCOME IS : <c:out value="${income}"/> 
        <c:choose> 
            <c:when test="${income <=1000}"> 
                INCOME IS NOT GOOD !!! 
            </c:when> 
                <c:when test="${income > 10000}"> 
                    INCOME IS VERY GOOD !!! 
                </c:when> 
                    <c:otherwise> 
                        INCOME IS UNDETERMINED !!! 
                    </c:otherwise> 
        </c:choose> 
    </body> 
</html> 