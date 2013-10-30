<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Playlist app</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <spring:url value="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" var="CSSjQueryMobile"/>
        <link rel="stylesheet" href="${CSSjQueryMobile}"/>
        <spring:url value="/resources/styles/app.css" var="CSSapp"/>
        <link rel="stylesheet" href="${CSSapp}"/> 
    </head>
    <body>
        <div data-role="page" id="playlist-page">
            <div data-role="header" data-position="fixed">
                <h1>Canciones</h1>
                <a href="#search-music-page" data-rel="dialog" data-icon="search" data-iconpos="notext" class="ui-btn-right">Buscar</a>
            </div><!-- /header -->

            <div data-role="content">
                <ul data-role="listview" id="main-song-list">

                </ul>
            </div><!-- /content -->

            <div data-role="footer" data-position="fixed">
                <div id="jquery_jplayer_1"></div>
                <div id="player_container">
                    <a class="jp-plui-prev" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/prev.png">
                    </a>
                    <a class="jp-plui-play" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/play.png">
                    </a>
                    <a class="jp-plui-pause" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/pause.png">
                    </a>
                    <a class="jp-plui-next" data-inline="true" data-role="button" href="javascript:;" data-theme="b" data-shadow="false" >
                        <img alt="prev" src="/vinilo/resources/images/next.png">
                    </a>
                </div>
            </div>

        </div><!-- /page -->

        <div data-role="page" id="search-music-page">
            <div data-role="header" data-theme="b">
                <h1>Buscador de temas</h1>
            </div>
            <div data-role="content" data-theme="b">
                <ul data-role="listview"  data-filter="true" data-filter-placeholder="Ingrese texto a buscar...">

                </ul>
            </div>
        </div>
        <spring:url value="/resources/scripts/jquery-2.0.3.min.js" var="JSjQuery"/>
        <script src="${JSjQuery}"></script>
        <spring:url value="/resources/scripts/jquery.mobile-1.3.2.min.js" var="JSjQueryMobile"/>
        <script src="${JSjQueryMobile}"></script>
        <spring:url value="/resources/scripts/jplayer/jquery.jplayer.min.js" var="JSjplayer" />
        <script src="${JSjplayer}"></script>
        <spring:url value="/resources/scripts/playlist-interface.js" var="JSjplayelist" />
        <script src="${JSjplayelist}"></script>
        <spring:url value="/resources/scripts/app.js" var="JSapp" />
        <script src="${JSapp}"></script>
    </body>
</html>
