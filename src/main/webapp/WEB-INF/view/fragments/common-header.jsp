<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">

<spring:url value="resources/styles/foundation/normalize.css" var="CSSNormalize"/>
<link rel="stylesheet" href="${CSSNormalize}">
<spring:url value="resources/styles/foundation/foundation.min.css" var="CSSFoundation"/>
<link rel="stylesheet" href="${CSSFoundation}">
<spring:url value="resources/styles/foundation/foundation-icons/foundation-icons.css" var="CSSFoundationIcons"/>
<link rel="stylesheet" href="${CSSFoundationIcons}">
<spring:url value="resources/styles/main.css" var="CSSMain"/>
<link rel="stylesheet" href="${CSSMain}"/>
<spring:url value="resources/styles/widgets.css" var="CSSWidgets"/>
<link rel="stylesheet" href="${CSSWidgets}"/>

<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"/>