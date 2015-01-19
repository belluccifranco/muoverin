<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="uploadSong" class="hide">
    <form id="uploadSongForm" data-abide="ajax">                               
        <div id="mainContainer" class="small-12 small-centered medium-5 large-4 columns">
            <div>
                <label for="song-track">Track Nº:</label>
                <input id="song-track" type="text" pattern="integer">
                <small id="song-track-error" class="error"><spring:message code="Integer-song-track"/></small>
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

    <div id="newArtistModal" class="reveal-modal tiny" data-reveal>
        <h2>Add new Artist</h2>
        <div>
            <form id="artistForm" data-abide>
                <div class="small-12">
                    <div>                
                        <label for="artist-name">Name:</label>
                        <input id="artist-name" type="text" required>
                        <small id="artist-name-error" class="error"><spring:message code="NotNull-artist-name"/></small>
                    </div>

                    <div>
                        <label for="artist-info">Info:</label>                
                        <textarea id="artist-info" maxlength="255" rows="5"></textarea>
                    </div>

                    <input id="saveArtist-button" class="button radius" type="submit" value="Save!"/>
                </div>
            </form>
        </div>
        <a class="close-reveal-modal">&#215;</a>
    </div>

    <div id="newAlbumModal" class="reveal-modal tiny" data-reveal>
        <h2>Add new Album</h2>    
        <a class="close-reveal-modal">&#215;</a>
    </div>

    <div id="newHostingModal" class="reveal-modal tiny" data-reveal>
        <h2>Add new Hosting</h2>    
        <a class="close-reveal-modal">&#215;</a>
    </div>
</div>