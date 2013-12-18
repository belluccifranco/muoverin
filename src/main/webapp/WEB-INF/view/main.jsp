<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>        
        <title>Vinilo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <spring:url value="/resources/styles/jquery_mobile/jquery.mobile-1.3.2.min.css" var="CSSjQueryMobile"/>
        <link rel="stylesheet" href="${CSSjQueryMobile}"/>
        <spring:url value="/resources/styles/main.css" var="CSSapp"/>
        <link rel="stylesheet" href="${CSSapp}"/> 
    </head>

    <body>
        <div data-role="page" id="playlist-page">
            <div data-role="header" data-position="fixed">
                <h1>Canciones</h1>
                <a href="#search-music-page" data-rel="dialog" data-icon="search" data-iconpos="notext" class="ui-btn-right">Buscar</a>
            </div>

            <div data-role="content">
                <ul data-role="listview" id="main-play-list">

                </ul>
            </div>

            <div data-role="footer" data-position="fixed">
                <div style="text-align: center;">
                    <a id="prev" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/prev.png">
                    </a>
                    <a id="play" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/play.png">
                    </a>
                    <a id="pause" class="ui-screen-hidden" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/pause.png">
                    </a>
                    <a id="next" data-inline="true" data-role="button" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/next.png">
                    </a>
                </div>
            </div>

        </div>

        <div data-role="page" id="search-music-page">
            <div data-role="header" data-theme="b">
                <h1>Buscador de canciones</h1>
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
                <div class="segmented-control" style="margin-bottom: 20px;">
                    <div data-role="controlgroup" data-type="horizontal">
                        <a href="#" data-role="button" data-icon="arrow-l" data-iconpos="notext" data-mini="true">Anterior</a>
                        <a href="#" data-role="button" data-icon="arrow-r" data-iconpos="notext" data-mini="true">Siguiente</a>
                    </div>
                </div>
                <ul id="song-search-list" data-role="listview" data-filter-placeholder="Ingrese texto a buscar..."></ul>
            </div>
        </div>

        <spring:url value="/resources/scripts/jquery-2.0.3.min.js" var="JSjQuery"/>
        <script src="${JSjQuery}"></script>
        <spring:url value="/resources/scripts/jquery.mobile-1.3.2.min.js" var="JSjQueryMobile"/>
        <script src="${JSjQueryMobile}"></script>
        <spring:url value="/resources/scripts/soundmanager2/soundmanager2-jsmin.js" var="JSsoundManager2" />
        <script src="${JSsoundManager2}"></script>
        <spring:url value="/resources/scripts/playlist.js" var="JSplaylist" />
        <script src="${JSplaylist}"></script>
        <spring:url value="/resources/scripts/searcher.js" var="JSsearcher" />
        <script src="${JSsearcher}"></script>
        <spring:url value="/resources/scripts/main.js" var="JSapp" />
        <script src="${JSapp}"></script>
    </body>
</html>
