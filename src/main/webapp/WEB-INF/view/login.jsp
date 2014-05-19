<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <spring:url value="/resources/styles/jquery_mobile/jquery.mobile-1.3.2.min.css" var="CSSjQueryMobile"/>
        <link rel="stylesheet" href="${CSSjQueryMobile}"/>
        <spring:url value="/resources/styles/login.css" var="CSSlogin"/>
        <link rel="stylesheet" href="${CSSlogin}"/>        
    </head>
    <body onload='document.f.j_username.focus();'>
        <div data-role="page" id="login-page">
            <div data-role="header" data-position="fixed">
                <h1><spring:message code="message.bienvenida"/></h1>
            </div>

            <div data-role="content">
                <form name='f' data-ajax="false" action="<c:url value='j_spring_security_check'/>" method='POST' >
                    <c:if test="${not empty error}">
                        <div class="errorblock">
                            <spring:message code="message.errorLogin"/>
                            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                        </div>
                    </c:if>                
                    <table style="margin: 0 auto;">
                        <tr>
                            <td><spring:message code="message.usuario"/></td>
                            <td><input type='text' name='j_username' value=''></td>
                        </tr>
                        <tr>
                            <td><spring:message code="message.contraseña"/></td>
                            <td><input type='password' name='j_password'/></td>
                        </tr>
                        <tr>
                            <td colspan='2'>
                                <input name="submit" type="submit" data-icon="forward" value=<spring:message code="message.ingresar"/>>
                            </td>
                        </tr>
                    </table>
                    <%--<a href="<c:url value="j_spring_security_logout"/>" >Salir</a>--%>
                </form>
            </div>
        </div>
        <spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
        <script src="${JSjQuery}"></script>
        <spring:url value="/resources/scripts/public/jquery.mobile-1.3.2.min.js" var="JSjQueryMobile"/>
        <script src="${JSjQueryMobile}"></script>        
    </body>
</html>