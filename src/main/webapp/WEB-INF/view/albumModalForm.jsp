<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="newAlbumModal" class="reveal-modal tiny" data-reveal>
    <h2>Add new Album</h2>    
    <div>
        <form id="albumForm" data-abide>
            <div class="small-12">
                <div>
                    <label for="album-artists">Artist:</label>                        
                    <input id="album-artists" type="hidden" required>
                    <small id="album-artists-error" class="error"><spring:message code="NotNull-song-artist"/></small>
                </div>

                <div>                
                    <label for="album-name">Name:</label>
                    <input id="album-name" type="text" required>
                    <small id="album-name-error" class="error"><spring:message code="NotEmpty-album-name"/></small>
                </div>

                <div>
                    <label for="album-releaseYear">Release Year:</label>
                    <input id="album-releaseYear" type="text" pattern="integer">
                    <small id="album-releaseYear-error" class="error"><spring:message code="Pattern-album-releaseYear"/></small>
                </div>                

                <input id="saveArtist-button" class="button radius expand" type="submit" value="Save!"/>
            </div>
        </form>
    </div>
    <a class="close-reveal-modal">&#215;</a>
</div>
