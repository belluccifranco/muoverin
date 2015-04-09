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
            <div class="small-12 small-centered medium-6 large-4 columns">
                <h1 class="title text-center">
                    <img src="<c:url value="/resources/images/logo.png"/>" alt="logo" style="width: 64px;"> <spring:message code="message-muoverin"/>
                </h1>   
                <form id="signupForm" data-abide="ajax">
                    <div>
                        <label for="userAccount-username"><spring:message code="message-username"/></label>
                        <input id="userAccount-username" type="text" required/>
                        <small id="userAccount-username-error" class="error"><spring:message code="NotEmpty-userAccount-username"/></small>
                    </div>
                    <div>
                        <label for="userAccount-password"><spring:message code="message-password"/></label>
                        <input id="userAccount-password" type="password" required/>
                        <small id="userAccount-password-error" class="error"><spring:message code="NotEmpty-userAccount-password"/></small>
                    </div>                        
                    <div>
                        <label for="userAccount-cpassword"><spring:message code="message-confirm-password"/></label>
                        <input id="userAccount-cpassword" type="password" required/>
                        <small id="userAccount-cpassword-error" class="error"><spring:message code="NotEmpty-userAccount-password"/></small>
                    </div>
                    <input class="button radius expand" type="submit" value="<spring:message code="message-signup"/>">
                    <a href="<c:url value="/login"/>" class="button radius expand"><spring:message code="message-back-login"/></a>
                </form>
            </div>
        </div>    
        <jsp:include page="fragments/common-footer.jsp"/>
        <script src="<c:url value="/resources/scripts/public/signup.js"/>"></script>
    </body>
</html>
