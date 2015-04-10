<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>        
        <jsp:include page="fragments/common-header.jsp"/>      
        <link rel="stylesheet" href="<c:url value="/resources/styles/main.css"/>">
        <title><spring:message code="message-muoverin"/></title>
    </head>
    <body>
        <div id="container">
            <h1 class="title text-center">
                <img src="<c:url value="/resources/images/logo.png"/>" alt="logo" style="width: 64px;"> <spring:message code="message-muoverin"/>
            </h1>
            <div class="row">
            <div class="small-12 small-centered medium-6 large-5 columns">
                <div class="login-form">
                <c:if test="${not empty error}">
                    <div class="alert-box alert radius">
                        <spring:message code="message-errorLogin"/>
                    </div>
                </c:if>
                <form id="login-form" action="<c:url value='j_spring_security_check'/>" method="POST">
                    <label for="username"><spring:message code="message-username"/></label>
                    <input id="username" type="email" name="j_username"/>
                    <label for="password"><spring:message code="message-password"/></label>
                    <input id="password" type='password' name="j_password"/>
                    <input class="button expand radius" type="submit" value="<spring:message code="message-login"/>">                        
                    <a href="<c:url value="/signup"/>" class="button expand radius"><spring:message code="message-signup"/></a>
                </form>
                </div>
            </div>
            </div>
        </div>
        <jsp:include page="fragments/common-footer.jsp"/>
        <script src="<c:url value="/resources/scripts/public/login.js"/>"></script>
    </body>
</html>