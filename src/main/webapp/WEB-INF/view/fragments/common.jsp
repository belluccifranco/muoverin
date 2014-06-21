<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon"/>

<spring:url value="/resources/styles/jquery_mobile/jquery.mobile-1.3.2.min.css" var="CSSjQueryMobile"/>
<link rel="stylesheet" href="${CSSjQueryMobile}"/>

<spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
<script src="${JSjQuery}"></script>

<spring:url value="/resources/scripts/public/jquery.mobile-1.3.2.min.js" var="JSjQueryMobile"/>
<script src="${JSjQueryMobile}"></script>