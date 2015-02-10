<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="uploadSong" class="hide">
    <form id="uploadSongForm" data-abide="ajax">                               
        <div id="mainContainer" class="small-12 small-centered medium-10 large-8 columns">
            <div>
                <label for="song-track">Track Nº:</label>
                <input id="song-track" type="text" pattern="integer">
                <small id="song-track-error" class="error"><spring:message code="Pattern-song-track"/></small>
            </div>

            <div>                
                <label for="song-name">Name:</label>
                <input id="song-name" type="text" required>
                <small id="song-name-error" class="error"><spring:message code="NotNull-song-name"/></small>
            </div>

            <div>
                <label for="song-artist">Artist:</label>
                <div class="row collapse">
                    <div class="small-10 columns">
                        <input id="song-artist" type="hidden" required>
                        <small id="song-artist-error" class="error"><spring:message code="NotNull-song-artist"/></small>
                    </div>
                    <div class="small-2 columns">
                        <a href="#" class="button postfix" data-reveal-id="newArtistModal"><i class="fi-plus"></i> Add</a>
                    </div>
                </div>
            </div>

            <div>
                <label for="song-album">Album:</label>
                <div class="row collapse">
                    <div class="small-10 columns">
                        <select id="song-album" required>
                        </select>
                        <small id="song-album-error" class="error"><spring:message code="NotNull-song-album"/></small>
                    </div>
                    <div class="small-2 columns">
                        <a href="#" class="button postfix" data-reveal-id="newAlbumModal"><i class="fi-plus"></i> Add</a>
                    </div>
                </div>
            </div>

            <div>
                <label for="song-link-hostingAccount">Hosting:</label>
                <div class="row collapse">
                    <div class="small-10 columns">
                        <select id="song-link-hostingAccount" required>
                        </select>
                        <small id="song-link-hostingAccount-error" class="error"><spring:message code="NotNull-song-link-hostingAccount"/></small>
                    </div>
                    <div class="small-2 columns">
                        <a href="#" class="button postfix" data-reveal-id="newHostingModal"><i class="fi-plus"></i> Add</a>
                    </div>
                </div>
            </div>

            <div>
                <label for="song-link-url">Link:</label>
                <input id="song-link-url" type="url" required>
                <small id="song-link-url-error" class="error"><spring:message code="URL-song-link-url"/></small>
            </div>

            <input id="save-button" class="button radius"  type="submit" value="Save!"/>
        </div>
    </form>

    <jsp:include page="artistModalForm.jsp"/>
    <jsp:include page="albumModalForm.jsp"/>
    <jsp:include page="hostingModalForm.jsp"/>    
</div>