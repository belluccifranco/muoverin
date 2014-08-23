<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <jsp:include page="fragments/common-header.jsp"/>
        <spring:url value="resources/styles/rangeslider.css" var="CSSRangeSlider"/>
        <link rel="stylesheet" href="${CSSRangeSlider}">
        <title>Vinilo</title>
    </head>
    <body>
    <div id="container">
        <h1 id="title" class="title">
            <span id="menu-toggle"><i class="fi-list"></i></span>&nbsp;<i class="fi-record"></i> VINILO
            <id class="toolbar">
                <ul class="button-group radius" id="main-toolbar">
                    <li><a id="search-toggle" class="button prev size1_5x"><i class="fi-magnifying-glass"></i></a></li>
                </ul>
            </id>
        </h1>
        <div id="main-container">
            <nav id="main-menu" class="menu">
                <div>
                    <h1 class="title"><i class="fi-record"></i> Menu</h1>
                    <ul class="list list-hover">
                        <li class="first"><a href="#"><i class="fi-music"></i> &nbsp;Playing</a></li>
                        <li><a href="<spring:url value="upload" />"><i class="fi-upload"></i> &nbsp;Upload Song</a></li>
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
                <div class="jq-vinilo-playlist">
                    <div class="jq-vinilo-playlist-list-container">
                        <ul class="jq-vinilo-playlist-list list play-list" style="height: 100%;" id="playing-list">
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
                    <div class="jq-vinilo-playlist-controls">
                        <div class="row">
                            <div class="small-12 large-6 columns" style="padding-top: 1rem;">
                                <input type="range" id="sound-progress" value="50">
                            </div>
                            <div class="small-12 large-6 columns">
                                <ul class="button-group radius">
                                    <li><a href="#" id="jqvp-prev" class="button size1_5x prev"><i class="fi-previous"></i></a></li>
                                    <li><a href="#" id="jqvp-play" class="button size1_5x play"><i class="fi-play"></i></a></li>
                                    <li><a href="#" id="jqvp-pause" class="button size1_5x pause"><i class="fi-pause"></i></a></li>
                                    <li><a href="#" id="jqvp-next" class="button size1_5x next"><i class="fi-next"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
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
    <jsp:include page="fragments/common-footer.jsp"/>
    <spring:url value="/resources/scripts/public/rangeslider.min.js" var="JSRangeSlider" />
    <script src="${JSRangeSlider}"></script>
    <spring:url value="/resources/scripts/jquery-vinilo-search.js" var="JSsearcher" />
    <script src="${JSsearcher}"></script>
    <spring:url value="/resources/scripts/jquery-vinilo-playlist.js" var="JSplaylist" />
    <script src="${JSplaylist}"></script>
    <spring:url value="/resources/scripts/main.js" var="JSapp" />
    <script src="${JSapp}"></script>
    <script type="text/javascript">
        (function($){
            var $sp = $('#sound-progress').rangeslider({polyfill: false});
        })(jQuery);
    </script>
    </body>
</html>
