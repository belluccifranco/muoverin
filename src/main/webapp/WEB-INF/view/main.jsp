<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <%--<meta name="viewport" content="width=device-width, initial-scale=1">                --%>
        <%--<spring:url value="/resources/styles/main.css" var="CSSapp"/>
        <link rel="stylesheet" href="${CSSapp}"/>--%>
        <jsp:include page="fragments/common.jsp"/>
    </head>
    <body>
    <div id="container">
        <h1 class="title"><span id="menu-toggle"><i class="fi-list"></i></span>&nbsp;<i class="fi-record"></i> VINILO</h1>
        <nav id="main-menu" class="menu">
            <div>
                <h1 class="title"><i class="fi-record size2x"></i> Menu</h1>
                <ul class="list list-hover">
                    <li class="first"><a href="#"><i class="fi-music"></i> &nbsp;Playing</a></li>
                    <li class="last"><a href="#"><i class="fi-power"></i> &nbsp;Logout</a></li>
                </ul>
            </div>
            <div>
                <h1 class="title"><i class="fi-star size2x"></i> Playlists</h1>
                <ul class="list list-hover">
                    <li class="first"><a href="#">Aerosmith</a></li>
                    <li><a href="#">Counting Crows</a></li>
                    <li><a href="#">Counting Crows</a></li>
                    <li class="last"><a href="#">Brasileras</a></li>
                </ul>
            </div>
        </nav>
        <div id="main">
            <ul class="list">
                <li>
                    <div class="item-img"></div>
                    <div class="item-info">
                        <div class="other-info ellipsis">Counting Crows - August And Everything After</div>
                        <div class="main-info ellipsis">Mr. Jones</div>
                    </div>
                </li>
                <li>
                    <div class="item-img"></div>
                    <div class="item-info">
                        <div class="other-info ellipsis">Counting Crows - August And Everything After</div>
                        <div class="main-info ellipsis">Round Here</div>
                    </div>
                </li>
                <li>
                    <div class="item-img"></div>
                    <div class="item-info">
                        <div class="other-info ellipsis">Aerosmith - Get a grip</div>
                        <div class="main-info ellipsis">Get a grip</div>
                    </div>
                </li>
                <li>
                    <div class="item-img"></div>
                    <div class="item-info">
                        <div class="other-info ellipsis">Aerosmith - Get a grip</div>
                        <div class="main-info ellipsis">Crazy</div>
                    </div>
                </li>
            </ul>

            <%--<div class="controls">
                <ul class="button-group radius">
                    <li><a href="#" class="button small"><i class="fi-previous size-24"></i></a></li>
                    <li><a href="#" class="button small"><i class="fi-play size-24"></i></a></li>
                    <li><a href="#" class="button small"><i class="fi-next size-24"></i></a></li>
                </ul>
            </div>--%>
        </div>
    </div>
    <spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
    <spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
    <script src="${JSsoundManager2}"></script>
    <%--<spring:url value="/resources/scripts/playlist2.js" var="JSplaylist2" />
    <script src="${JSplaylist2}"></script>
    <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>--%>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>
    </body>
</html>
