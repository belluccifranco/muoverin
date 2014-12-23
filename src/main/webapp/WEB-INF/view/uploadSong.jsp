<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="uploadSongForm" data-abide="ajax">                               
    <div id="mainContainer" class="small-12 small-centered medium-5 large-4 columns">
        <div>
            <label for="track">Track Nº:</label>
            <input id="track" name="track" type="text" pattern="integer">
            <small id="track-error" class="error"><spring:message code="Integer.song.track"/></small>
        </div>

        <div>                
            <label for="name">Name:</label>
            <input id="name" name="name" type="text" required>
            <small id="name-error" class="error"><spring:message code="NotNull.song.name"/></small>
        </div>

        <div>
            <label for="artist-combo">Artist:</label>
            <div class="row collapse">
                <div class="small-10 columns">
                    <input id="artist-combo" name="artist-combo" type="hidden" required>
                    <small id="artist-error" class="error"><spring:message code="NotNull.song.artist"/></small>
                </div>
                <div class="small-2 columns">
                    <a href="#" class="button postfix" data-reveal-id="newArtistModal"><i class="fi-plus"></i> Add</a>
                </div>
            </div>
        </div>

        <div>
            <label for="album-combo">Album:</label>
            <div class="row collapse">
                <div class="small-10 columns">
                    <select id="album-combo" name="album-combo" required>
                    </select>
                    <small id="album-error" class="error"><spring:message code="NotNull.song.album"/></small>
                </div>
                <div class="small-2 columns">
                    <a href="#" class="button postfix" data-reveal-id="newAlbumModal"><i class="fi-plus"></i> Add</a>
                </div>
            </div>
        </div>

        <div>
            <label for="lyrics">Lyrics:</label>
            <textarea id="lyrics" name="lyrics" maxlength="255" rows="5"></textarea>
        </div>

        <div>
            <label for="hosting-combo">Hosting:</label>
            <div class="row collapse">
                <div class="small-10 columns">
                    <select id="hosting-combo" name="hosting-combo" required>
                    </select>
                    <small id="link-hostingAccount-error" class="error"><spring:message code="NotNull.song.link.hostingAccount"/></small>
                </div>
                <div class="small-2 columns">
                    <a href="#" class="button postfix" data-reveal-id="newHostingModal"><i class="fi-plus"></i> Add</a>
                </div>
            </div>
        </div>

        <div>
            <label for="url">Link:</label>
            <input id="url" name="url" type="url" required>
            <small id="link-url-error" class="error"><spring:message code="URL.song.link.url"/></small>
        </div>

        <input id="save-button" class="button radius"  type="submit" value="Save!"/>
    </div>
</form>

<div id="newArtistModal" class="reveal-modal tiny" data-reveal>
    <h2>Add new Artist</h2>
    <div>
        <form id="uploadSongForm" data-abide>
            <div class="small-12">
                <div>                
                    <label for="name-label">Name:</label>
                    <input id="name" type="text" required>
                    <small id="name-error" class="error"><spring:message code="NotNull.song.name"/></small>
                </div>        

                <div>
                    <label for="lyrics-label">Lyrics:</label>                
                    <textarea id="lyrics" maxlength="255" rows="5"></textarea>
                </div>

                <input id="save-button" class="button radius" type="submit" value="Save!"/>
            </div>
        </form>
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

<script src="<c:url value="/resources/scripts/uploadSong.js"/>"></script>