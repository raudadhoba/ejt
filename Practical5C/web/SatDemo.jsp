<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Demo</title>
    </head>
    <body>
        <c:set var="pageTitle" scope="application" value="Indian Premier League: Registration" />
        <h1>${pageTitle}</h1>
    </body>
</html>
