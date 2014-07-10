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
            </div>
            <div id="main-searcher">
                <div style="position: relative; height: 100%;">
                    <div class="row collapse" class="search-form" style="position: absolute; top:0; left: 0; right: 0;">
                        <div class="small-10 columns">
                            <input id="song-search-input" class="remove-margin-bottom" type="text" placeholder="Search Term">
                        </div>
                        <div class="small-2 columns">
                            <a href="#" id="song-search-button" class="button postfix remove-margin-bottom"><i class="fi-magnifying-glass"></i></a>
                        </div>
                    </div>
                    <div style="position: absolute; top: 2.313rem; left: 0; right: 0; bottom: 4rem;">
                        <ul class="list search-list" id="song-search-list">

                        </ul>
                    </div>
                    <div class="search-dialog" style="position: absolute; bottom: 0; left: 0; right: 0; height: 4rem; background: white;">
                        <h1>Hola Mundo</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <spring:url value="/resources/scripts/public/jquery-1.10.2.min.js" var="JSjQuery"/>
    <script src="${JSjQuery}"></script>
    <spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
    <script src="${JSsoundManager2}"></script>
    <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>
    </body>
</html>
