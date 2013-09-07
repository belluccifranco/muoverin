<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Audio test</title>
		<style>
			#playlist ul.nav {
				margin: 0;
				padding: 0;
			}
			#playlist ul.nav li {
				display: inline;
				margin-left: 10px;
			}
			#playlist ul.nav a {
				text-decoration: none;
				padding: 3px 15px;
				-moz-box-shadow:inset 0px 1px 0px 0px #fed897;
				-webkit-box-shadow:inset 0px 1px 0px 0px #fed897;
				box-shadow:inset 0px 1px 0px 0px #fed897;
				background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #f6b33d), color-stop(1, #d29105) );
				background:-moz-linear-gradient( center top, #f6b33d 5%, #d29105 100% );
				filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f6b33d', endColorstr='#d29105');
				background-color:#f6b33d;
				-webkit-border-top-left-radius:20px;
				-moz-border-radius-topleft:20px;
				border-top-left-radius:20px;
				-webkit-border-top-right-radius:20px;
				-moz-border-radius-topright:20px;
				border-top-right-radius:20px;
				-webkit-border-bottom-right-radius:20px;
				-moz-border-radius-bottomright:20px;
				border-bottom-right-radius:20px;
				-webkit-border-bottom-left-radius:20px;
				-moz-border-radius-bottomleft:20px;
				border-bottom-left-radius:20px;
			}
			.playlist ul.nav a:hover {
				background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #d29105), color-stop(1, #f6b33d) );
				background:-moz-linear-gradient( center top, #d29105 5%, #f6b33d 100% );
				filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d29105', endColorstr='#f6b33d');
				background-color:#d29105;
			}
			.playlist ul.nav a:active {
				position:relative;
				top:1px;
			}
		</style>
	</head>
	<body>
		<div id="playlist">
			<span></span><br />
			<label><input type="checkbox" class="loop" /> loop</label>
			<label><input type="checkbox" class="playall" /> play all</label><br />
			<audio controls="" name="media">
				<source src="" type="audio/mpeg">
			</audio>
			<ul class="nav">
				<li><a class="prev" href="#" onClick="return false;" title="Anterior">&lt;</a></li>
				<li><a class="next" href="#" onClick="return false;" title="Siguiente">&gt;</a></li>
			</ul>
		</div>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script>
			(function($){
				var $playlist = $("#playlist"),
				    $audio = $playlist.find('audio');
				    $label = $playlist.find('span');
					$loop = $playlist.find('input[type="checkbox"].loop');
					$playall = $playlist.find('input[type="checkbox"].playall');
					urls = [
						"http://www.largesound.com/ashborytour/sound/AshboryBYU.mp3",
						"http://www.largesound.com/ashborytour/sound/brobob.mp3",
					],
					first = 0, last = urls.length-1, current = -1;
					
				function play(pos) {
					$audio.find('source').attr('src', urls[pos]);
					$label.text(urls[pos]);
					$audio.get(0).load();
					$audio.get(0).play();
				}
				
				function prev(){
					if (current <= first) {
						if ($loop.is(':checked')) {
							current = last;
						} else { return; }
					} else {
						current--;
					}
					play(current);
				}
				
				function next(){
					if (current >= last) {
						if ($loop.is(':checked')) {
							current = first;
						} else { return; }
					} else {
						current++;
					}
					play(current);
				}
				
				if (urls.length > 0) {
					current = 0;
					play(current);
					
					var $prev = $playlist.find('.nav .prev'),
					    $next = $playlist.find('.nav .next');
				
					$prev.click(prev);
					$next.click(next);
					
					$playall.change(function(){
						if ($playall.is(':checked')) {
							$audio.on('ended', next);
						} else {
							$audio.off('ended', next);
						}
					});
					$playall.change();
				}
			})(jQuery);
		</script>
	</body>
</html>
