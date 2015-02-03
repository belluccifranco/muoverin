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