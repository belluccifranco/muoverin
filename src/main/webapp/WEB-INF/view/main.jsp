<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <jsp:include page="fragments/common-header.jsp"/>        
        <link rel="stylesheet" href="<c:url value="/resources/styles/main.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/styles/widgets.css"/>">
        <title><spring:message code="message-muoverin" /></title>
    </head>
    <body>
        <div id="container">
            <h1 id="title" class="title">
                <div class="title-main">
                    <span id="menu-toggle"><i class="fi-list"></i></span><span id="title-text"><spring:message code="message-muoverin" /></span>
                </div>
                <div class="toolbar">
                    <a class="toolbar-button" id="search-toggle">
                        <i class="fi-magnifying-glass"></i>
                    </a>
                </div>
                <div class="toolbar">
                    <a class="toolbar-button without-margin-right" href="#" id="jqvp-prev" class="button size1_5x prev">
                        <i class="fi-previous"></i>
                    </a><a class="toolbar-button without-margin-right" href="#" id="jqvp-play" class="button size1_5x play">
                        <i class="fi-play"></i>
                    </a><a class="toolbar-button without-margin-right hide" href="#" id="jqvp-pause" class="button size1_5x pause">
                        <i class="fi-pause"></i>
                    </a><a class="toolbar-button" href="#" id="jqvp-next" class="button size1_5x next">
                        <i class="fi-next"></i>
                    </a>
                </div>
            </h1>
            <div id="main-container">
                <nav id="main-menu" class="menu">
                    <div>
                        <h1 class="title"><i class="fi-record"></i> Menu</h1>
                        <ul class="list list-hover">
                            <li class="first"><a id="playing-list-button" href="#"><i class="fi-music"></i> &nbsp;Playing</a></li>
                            <li><a id="upload"><i class="fi-upload"></i> &nbsp;Upload a Song</a></li>
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
        <div class="hide" id="viewsHolder">
            <jsp:include page="playingList.jsp"/>
            <jsp:include page="uploadSong.jsp"/>
        </div>
        <jsp:include page="fragments/common-footer.jsp"/>
        <script src="<c:url value="/resources/scripts/jquery-vinilo-search.js"/>"></script>
        <script src="<c:url value="/resources/scripts/jquery-vinilo-playlist.js"/>"></script>
        <script src="<c:url value="/resources/scripts/main.js"/>"></script>           
        <script src="<c:url value="/resources/scripts/uploadSong.js"/>"></script>
    </body>
</html>
