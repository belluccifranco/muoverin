<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/styles/foundation/normalize.css" var="CSSNormalize"/>
<link rel="stylesheet" href="${ CSSNormalize }">

<spring:url value="resources/styles/foundation/foundation.min.css" var="CSSFoundation"/>
<link rel="stylesheet" href="${ CSSFoundation }">

<spring:url value="resources/styles/foundation/foundation-icons/foundation-icons.css" var="CSSFoundationIcons"/>
<link rel="stylesheet" href="${ CSSFoundationIcons }">

<spring:url value="/resources/styles/main.css" var="CSSMain"/>
<link rel="stylesheet" href="${CSSMain}"/>

<link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon"/>
<%--
<spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
<script src="${JSjQuery}"></script>


<spring:url value="/resources/scripts/public/jquery.mobile-1.3.2.min.js" var="JSjQueryMobile"/>
<script src="${JSjQueryMobile}"></script>
--%>
