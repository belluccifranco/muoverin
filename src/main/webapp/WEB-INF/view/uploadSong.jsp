<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <jsp:include page="fragments/common-header.jsp"/>
        <spring:url value="resources/styles/uploadSong.css" var="CSSUploadSong"/>
        <link rel="stylesheet" href="${CSSUploadSong}">
        <title>Upload a song</title>
    </head>
    <body>        
        <form id="uploadSongForm" data-abide>
            <div id="title-band" class="label small-12 text-center">
                <h2>Add new Song</h2>
            </div>

            <div class="small-12 small-centered medium-5 large-4 columns">
                <div>
                    <label for="track-label">Track Nº:</label>
                    <input id="track" type="text" pattern="integer">
                    <small id="track-error" class="error"><spring:message code="Integer.song.track"/></small>
                </div>

                <div>                
                    <label for="name-label">Name:</label>
                    <input id="name" type="text" required>
                    <small id="name-error" class="error"><spring:message code="NotNull.song.name"/></small>
                </div>

                <div>
                    <label for="artist-label">Artist:</label>
                    <input id="artist-combo" type="hidden">
                    <small id="artist-error" class="error"><spring:message code="NotNull.song.artist"/></small>
                    <a href="#" data-reveal-id="newArtistModal">Add!</a>
                </div>

                <div>
                    <label for="album-label">Album:</label>
                    <select id="album-combo" required>
                    </select>
                    <small id="album-error" class="error"><spring:message code="NotNull.song.album"/></small>
                    <a href="#" data-reveal-id="newAlbumModal">Add!</a>
                </div>

                <div>
                    <label for="lyrics-label">Lyrics:</label>                
                    <textarea id="lyrics" maxlength="255" rows="5"></textarea>
                </div>

                <div>
                    <label for="hosting-label">Hosting:</label>
                    <select id="hosting-combo" required>
                    </select>
                    <small id="link-hostingAccount-error" class="error"><spring:message code="NotNull.song.link.hostingAccount"/></small>
                    <a href="#" data-reveal-id="newHostingModal">Add!</a>
                </div>

                <div>
                    <label for="link-label">Link:</label>
                    <input id="url" type="url" required>
                    <small id="link-url-error" class="error"><spring:message code="URL.song.link.url"/></small>
                </div>

                <input id="save-button" class="button radius" type="submit" value="Save!"/>
            </div>
        </form>

        <div id="newArtistModal" class="reveal-modal tiny" data-reveal>
            <h2>Add new Artist</h2>
            <div class="flex-video">
            </div>
            <a class="close-reveal-modal">&#215;</a>
        </div>

        <div id="newAlbumModal" class="reveal-modal tiny" data-reveal>
            <h2>Add new Album</h2>
            <div class="flex-video">
            </div>
            <a class="close-reveal-modal">&#215;</a>
        </div>

        <div id="newHostingModal" class="reveal-modal tiny" data-reveal>
            <h2>Add new Hosting</h2>
            <div class="flex-video">
            </div>
            <a class="close-reveal-modal">&#215;</a>
        </div>
                
        <jsp:include page="fragments/common-footer.jsp"/>
        <spring:url value="/resources/scripts/uploadSong.js" var="uploadSong"/>
        <script src="${uploadSong}"></script>
    </body>
</html>
