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
        <h1 id="title" class="title">
            <span id="menu-toggle"><i class="fi-list"></i></span>&nbsp;<i class="fi-record"></i> VINILO
            <span class="right" id="search-toggle"><i class="fi-magnifying-glass"></i></span>
        </h1>
        <div id="main-container">
            <nav id="main-menu" class="menu">
                <div>
                    <h1 class="title"><i class="fi-record"></i> Menu</h1>
                    <ul class="list list-hover">
                        <li class="first"><a href="#"><i class="fi-music"></i> &nbsp;Playing</a></li>
                        <li class="last"><a href="<spring:url value="upload" />"><i class="fi-upload"></i> &nbsp;Upload Song</a></li>
                        <li class="last"><a href="<spring:url value='j_spring_security_logout'/>"><i class="fi-power"></i> &nbsp;Logout</a></li>
                    </ul>
                </div>
                <div>
                    <h1 class="title"><i class="fi-star"></i> Playlists</h1>
                    <ul class="list list-hover">
                        <li class="first"><a href="#">Aerosmith</a></li>
                        <li><a href="#">Counting Crows</a></li>
                        <li class="last"><a href="#">Brasileras</a></li>
                    </ul>
                </div>
            </nav>
            <div id="main">
                <ul class="list play-list" style="height: 100%;" id="playing-list">
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
                <div id="song-searcher" class="jq-vinilo-search">
                    <form class="jq-vinilo-search-form" data-url="<spring:url value='songs'/>">
                        <div class="row collapse search-form">
                            <div class="small-10 columns">
                                <input name="criteria" id="song-search-input" class="remove-margin-bottom" type="text" placeholder="Search Term">
                            </div>
                            <div class="small-2 columns">
                                <a href="#" class="button postfix remove-margin-bottom jq-vinilo-search-form-button"><i class="fi-magnifying-glass"></i></a>
                            </div>
                        </div>
                    </form>
                    <div id="song-search-list" class="jq-vinilo-search-list-container">
                        <ul class="list search-list jq-vinilo-search-list">

                        </ul>
                    </div>
                    <div class="jq-vinilo-search-actions">
                        <ul class="button-group radius">
                            <li><a href="#" class="button check-all-button"><i class="fi-checkbox"></i> Check All</a></li>
                            <li><a href="#" class="button add-selected-button"><i class="fi-plus"></i> Add selected</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <spring:url value="/resources/scripts/touchscroll.js" var="JSTouchScroll"/>
    <script src="${JSTouchScroll}"></script>
    <spring:url value="/resources/scripts/public/jquery-2.1.1.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
    <spring:url value="/resources/scripts/public/jquery-ui.min.js" var="JSjQueryUI"/>
    <script src="${JSjQueryUI}"></script>
    <spring:url value="/resources/scripts/public/jquery.ui.touch-punch.min.js" var="JSjQueryUITouchPunch"/>
    <script src="${JSjQueryUITouchPunch}"></script>
    <spring:url value="/resources/scripts/soundmanager2/soundmanager2-nodebug-jsmin.js" var="JSsoundManager2" />
    <script src="${JSsoundManager2}"></script>
    <spring:url value="/resources/scripts/jquery-vinilo-search.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>
    <spring:url value="/resources/scripts/jquery-vinilo-playlist.js" var="JSplaylist" />
    <script src="${JSplaylist}"></script>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>
    </body>
</html>
