<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>        
        <%-- CSS references van en el HEAD --%>
        <spring:url value="/resources/styles/cssTest.css" var="CSSvar"/>
        <link href="${CSSvar}" rel="stylesheet"/>        
        <title>VINILO</title>
    </head>
    <body>
        <audio controls>                        
            <source src="/vinilo/reproductor/10">
        </audio>

        <div id="container">
            <h2>Lista de Reproduccion</h2>
            <input type="submit" id="btn_buscar" value="Buscar lista de reproducción"/><br/><br/>
            <div id="respuesta">
            </div>           
        </div>

        <%-- JS files siempre al final --%>
        <spring:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" var="jQuery"/>
        <script src="${jQuery}"></script>
        <spring:url value="/resources/scripts/test.js" var="JSvar"/>
        <script src="${JSvar}"></script>        
    </body>
</html>
