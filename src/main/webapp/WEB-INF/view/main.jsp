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
            <h1 class="title"><span id="menu-toggle" class="right"><i class="fi-list"></i></span>&nbsp;<i class="fi-record"></i> VINILO</h1>
            <div class="playlist" style="height: 100%;">
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
    </div>
        <%--<div data-role="page" id="playlist-page">
            <div data-role="header" data-position="fixed">
                <a data-ajax="false" href="<c:url value='j_spring_security_logout'/>" data-icon="back" &lt;%&ndash;data-iconpos="notext"&ndash;%&gt;><spring:message code="message.logout"/></a>
                <h1><spring:message code="message.songs"/></h1>
                <a href="#search-music-page" data-rel="dialog" data-icon="search" &lt;%&ndash;data-iconpos="notext"&ndash;%&gt; class="ui-btn-right"><spring:message code="message.search"/></a>
                <div class="segmented-control ui-bar-d">
                    <a href="#" id="remove-sound" data-role="button" data-icon="delete" data-iconpos="notext" data-inline="true" style="margin-right: 50px;"></a>
                    <div data-role="controlgroup" data-type="horizontal" style="display: inline-block;">
                        <a href="#" id="up-sound" data-role="button" data-icon="arrow-u" data-iconpos="notext"></a>
                        <a href="#" id="down-sound" data-role="button" data-icon="arrow-d" data-iconpos="notext"></a>
                    </div>
                </div>
            </div>

            <div data-role="content">
                <ul data-role="listview" id="main-play-list">

                </ul>
            </div>

            <div data-role="footer" data-position="fixed">
                <div style="text-align: center;">
                    <a id="prev" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="<spring:url value="/resources/images/prev.png"/>">
                    </a>
                    <a id="play" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="play" src="<spring:url value="/resources/images/play.png"/>">
                    </a>
                    <a id="pause" class="ui-screen-hidden" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="pause" src="<spring:url value="/resources/images/pause.png"/>">
                    </a>
                    <a id="next" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="next" src="<spring:url value="/resources/images/next.png"/>">
                    </a>
                    <fieldset data-role="controlgroup" data-type="horizontal" style="display: inline;">
                        <input type="checkbox" id="loop">
                        <label for="loop" style="border: 0;"><img alt="loop" title="loop" src="<spring:url value="/resources/images/repeat.png"/>"></label>
                    </fieldset>
                </div>
            </div>
        </div>

        <div data-role="page" id="search-music-page">
            <div data-role="header" data-theme="b">
                <h1><spring:message code="message.searchSong"/></h1>
            </div>
            <div data-role="content" data-theme="c">
                <fieldset class="ui-grid-a">
                    <div class="ui-block-a" style="width: 90%;">
                        <input type="search" name="search-mini" id="song-search-input" data-mini="true"/>
                    </div>
                    <div class="ui-block-b" style="width: 10%;">
                        <a data-role="button" data-inline="true" data-icon="search" data-iconpos="notext" id="song-search-button">Buscar</a>
                    </div>
                </fieldset>
                <div style="text-align: right; margin-bottom: 20px; text-align: center;">
                    <button id="song-search-pager-prev-button" data-iconpos="left" data-inline="true" data-icon="arrow-l" data-mini="true"><spring:message code="message.previous"/></button>
                    <button id="song-search-pager-next-button" data-iconpos="right" data-inline="true" data-icon="arrow-r" data-mini="true"><spring:message code="message.next"/></button>
                </div>
                <ul id="song-search-list" data-role="listview"></ul>
            </div>
        </div>--%>
        <spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
        <script src="${JSsoundManager2}"></script>
        <spring:url value="/resources/scripts/playlist2.js" var="JSplaylist2" />
        <script src="${JSplaylist2}"></script>
        <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
        <script src="${JSsearcher}"></script>
        <spring:url value="/resources/scripts/main.js" var="JSapp" />
        <script src="${JSapp}"></script>
    </body>
</html>
