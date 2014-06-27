<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>        
        <meta name="viewport" content="width=device-width, initial-scale=1">                
        <spring:url value="/resources/styles/login.css" var="CSSlogin"/>
        <link rel="stylesheet" href="${CSSlogin}"/>
        <jsp:include page="fragments/common.jsp"/>
    </head>
    <body>
        <div id="container">
            <div class="row">
                <div class="small-12 small-centered medium-5 large-4 columns">
                    <div id="login-form">
                        <h1 class="title text-center" style="text-transform: uppercase;"><i class="fi-record"></i> <spring:message code="message.vinilo"/></h1>
                        <c:if test="${not empty error}">
                            <div class="alert-box alert radius">
                                <spring:message code="message.errorLogin"/>
                            </div>
                        </c:if>
                        <form  name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
                            <label for="username"><spring:message code="message.username"/> </label>
                            <input type="text" id="username" name="j_username" value="">
                            <label for="pass"><spring:message code="message.password"/> </label>
                            <input type='password' name='j_password'/>
                            <input class="button radius" name="submit" type="submit" data-icon="forward" value="<spring:message code="message.login"/>">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
    <script type="text/javascript">
        (function($){
            $('input#username').focus();
        })(jQuery);
    </script>
</html>