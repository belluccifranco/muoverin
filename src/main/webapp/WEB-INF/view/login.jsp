<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Vinilo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <spring:url value="/resources/styles/jquery_mobile/jquery.mobile-1.3.2.min.css" var="CSSjQueryMobile"/>
        <link rel="stylesheet" href="${CSSjQueryMobile}"/>
        <spring:url value="/resources/styles/main.css" var="CSSapp"/>
        <link rel="stylesheet" href="${CSSapp}"/>
        <style>
            .errorblock {
                color: #ff0000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body <%--onload='document.f.j_username.focus();'--%>>
    <div data-role="page" id="login-page">
        <div data-role="header" data-position="fixed">
            <h1>Bienvenido a VINILO !</h1>
        </div>

        <div data-role="content">
            <c:if test="${not empty error}">
                <div class="errorblock">
                    Your login attempt was not successful, try again.<br /> Caused :
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

            <form name='f' action="<c:url value='j_spring_security_check'/>" method='POST'>
                <div class="ui-grid-c">
                    <div class="ui-block-a"><input type="text"></div>
                    <div class="ui-block-b"><input type="text"></div>
                    <div class="ui-block-c"><input type="text"></div>
                    <div class="ui-block-d"><input type="text"></div>
                </div>
                <table>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type='text' name='j_username' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>PIN:</td>
                        <td><input type='password' name='j_password'/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="Ingresar"/>
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
    <%--<spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
    <script src="${JSsoundManager2}"></script>
    <spring:url value="/resources/scripts/playlist.js" var="JSplaylist" />
    <script src="${JSplaylist}"></script>
    <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>--%>
    </body>
</html>