<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>        
        <jsp:include page="fragments/common-header.jsp"/>      
        <link rel="stylesheet" href="<c:url value="/resources/styles/main.css"/>">
        <title><spring:message code="message-muoverin"/></title>
    </head>
    <body>
        <div id="container">
            <div class="row">
                <div class="small-12 small-centered medium-6 large-4 columns">
                    <div id="login-form">
                        <h1 class="title text-center">
                            <img src="resources/images/vinilo.png" alt="logo" style="width: 64px;"> <spring:message code="message-muoverin" />
                        </h1>
                        <c:if test="${not empty error}">
                            <div class="alert-box alert radius">
                                <spring:message code="message-errorLogin"/>
                            </div>
                        </c:if>
                        <form  name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
                            <label for="username"><spring:message code="message-username"/> </label>
                            <input type="email" id="username" name="j_username" value="">
                            <label for="pass"><spring:message code="message-password"/> </label>
                            <input type='password' name='j_password'/>
                            <input class="button radius" name="submit" type="submit" data-icon="forward" value="<spring:message code="message-login"/>">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="fragments/common-footer.jsp"/>
        <script src="<c:url value="/resources/scripts/public/login.js"/>"></script>
    </body>

</html>