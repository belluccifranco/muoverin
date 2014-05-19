<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/foundation/normalize.css">
        <link rel="stylesheet" href="resources/styles/foundation/foundation.min.css">
        <title>Upload a song</title>
    </head>
    <body>             
        <form>            
            <div class="label small-12 text-center">
                <h2>Add new Song</h2>                
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label for="track-label" class="right inline">Track Nº:</label>
                </div>
                <div class="small-7 columns">
                    <input type="text" id="track-label" placeholder="">
                </div>
                <div class="small-2 columns">

                </div>
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label for="name-label" class="right inline">Name:</label>
                </div>
                <div class="small-7 columns">
                    <input type="text" id="name-label" placeholder="">
                </div>
                <div class="small-2 columns">

                </div>
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label for="artist-label" class="right inline">Artist:</label>
                </div>
                <div class="small-7 columns">
                    <select id="artist-label">
                        <option value="husker">AC DC</option>
                        <option value="starbuck">Led Zeppelin</option>
                        <option value="hotdog">The Offpring</option>
                        <option value="apollo">Jimi Hendrix</option>
                    </select>                            
                </div>
                <div class="small-2 columns">
                    <a href="#" data-reveal-id="newArtistModal">Add !</a>                            
                </div>
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label for="album-label" class="right inline">Album:</label>
                </div>
                <div class="small-7 columns">
                    <select id="album-label">
                        <option value="husker">ABC</option>
                        <option value="starbuck">DEF</option>
                        <option value="hotdog">GHI</option>                                
                    </select>                            
                </div>
                <div class="small-2 columns">
                    <a href="#" data-reveal-id="newAlbumModal">Add !</a>
                </div>
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label class="right inline">Tracks:</label>
                </div>
                <div class="small-7 columns">
                    <table>
                        <thead>
                            <tr>
                                <th width="50">Nº</th>
                                <th width="800">Name</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Song name 1</td>                                                                 
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Song name 2</td>                                
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Song name 3</td>                                
                            </tr>
                        </tbody>
                    </table>                          
                </div>
                <div class="small-2 columns">

                </div>
            </div>

            <div class="row">                
                <div class="small-3 columns">
                    <label for="lyrics-label" class="right inline">Lyrics:</label>
                </div>
                <div class="small-7 columns">
                    <textarea id="lyrics-label" placeholder=""></textarea>
                </div>
                <div class="small-2 columns">

                </div>                
            </div>

            <div class="row">
                <div class="small-3 columns">
                    <label for="link-label" class="right inline">Link:</label>
                </div>
                <div class="small-7 columns">
                    <input id="link-label" type="text" placeholder="">
                </div>
                <div class="small-2 columns">

                </div>
            </div>

            <a href="#" id="save-button" class="button small expand">Save!</a>
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

        <spring:url value="/resources/scripts/foundation/vendor/jquery.js" var="JSFoundationVendor"/>
        <script src="${JSFoundationVendor}"></script>
        <spring:url value="/resources/scripts/foundation/foundation.min.js" var="JSFoundation"/>
        <script src="${JSFoundation}"></script>    
        <spring:url value="/resources/scripts/uploadSong.js" var="uploadSong"/>
        <script src="${uploadSong}"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>
