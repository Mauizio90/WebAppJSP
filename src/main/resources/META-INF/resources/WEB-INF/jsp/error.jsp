<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <%@ page isErrorPage="true" %>  
  
            <h3>Sorry an exception occured!</h3>  
  
            Exception is: <%= exception %>  
        </div>
    </body>
</html>
