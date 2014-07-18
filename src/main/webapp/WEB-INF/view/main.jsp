<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <jsp:include page="fragments/common.jsp"/>
    </head>
    <body>
    <div id="container">
        <h1 id="title" class="title"><span id="menu-toggle"><i class="fi-list"></i></span>&nbsp;<i class="fi-record"></i> VINILO</h1>
        <div id="main-container">
            <nav id="main-menu" class="menu">
                <div>
                    <h1 class="title"><i class="fi-record size2x"></i> Menu</h1>
                    <ul class="list list-hover">
                        <li class="first"><a href="#"><i class="fi-music"></i> &nbsp;Playing</a></li>
                        <li class="last"><a href="<spring:url value="upload" />"><i class="fi-upload"></i> &nbsp;Upload Song</a></li>
                        <li class="last"><a href="<c:url value='j_spring_security_logout'/>"><i class="fi-power"></i> &nbsp;Logout</a></li>
                    </ul>
                </div>
                <div>
                    <h1 class="title"><i class="fi-star size2x"></i> Playlists</h1>
                    <ul class="list list-hover">
                        <li class="first"><a href="#">Aerosmith</a></li>
                        <li><a href="#">Counting Crows</a></li>
                        <li class="last"><a href="#">Brasileras</a></li>
                    </ul>
                </div>
            </nav>
            <div id="main">
                <ul class="list">
                    <%--<li>
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
                    </li>--%>
                </ul>
            </div>
            <div id="main-searcher">
                <div style="position: relative; height: 100%;">
                    <div class="row collapse search-form">
                        <div class="small-10 columns">
                            <input id="song-search-input" class="remove-margin-bottom" type="text" placeholder="Search Term">
                        </div>
                        <div class="small-2 columns">
                            <a href="#" id="song-search-button" class="button postfix remove-margin-bottom"><i class="fi-magnifying-glass"></i></a>
                        </div>
                    </div>
                    <div class="list-container">
                        <ul class="list search-list" id="song-search-list">

                        </ul>
                    </div>
                    <div class="search-dialog">
                        <ul class="button-group radius">
                            <li><a id="song-search-checkall-button" href="#" class="button"><i class="fi-checkbox"></i> Check All</a></li>
                            <li><a id="song-search-add-selected-button" href="#" class="button"><i class="fi-plus"></i> Add selected</a></li>
                        </ul>
                    </div>
                    <div class="row collapse search-pager">
                        <div class="small-4 columns">
                            <a href="#" id="main-searcher-prev-button" class="button prefix remove-margin-bottom"><i class="fi-arrow-left size2x"></i></a>
                        </div>
                        <div class="small-4 columns">
                            <input class="remove-margin-bottom" type="text" disabled="disabled">
                        </div>
                        <div class="small-4 columns">
                            <a href="#" id="main-searcher-next-button" class="button postfix remove-margin-bottom"><i class="fi-arrow-right size2x"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <spring:url value="/resources/scripts/touchscroll.js" var="JSTouchScroll"/>
    <script src="${JSTouchScroll}"></script>
    <spring:url value="/resources/scripts/public/jquery-2.1.1.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
<%--
    <spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
--%>
    <spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
    <script src="${JSsoundManager2}"></script>
    <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>
    </body>
</html>
