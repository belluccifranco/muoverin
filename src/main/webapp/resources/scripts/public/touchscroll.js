/* This function makes a div scrollable with android and iphone */

function isTouchDevice(){
	/* Added Android 3.0 honeycomb detection because touchscroll.js breaks
		the built in div scrolling of android 3.0 mobile safari browser */
	if((navigator.userAgent.match(/android 3/i)) ||
		(navigator.userAgent.match(/honeycomb/i)))
		return false;
	try{
		document.createEvent("TouchEvent");
		return true;
	}catch(e){
		return false;
	}
}

function touchScroll(elementSelector, exclusionSelector) {
    if(isTouchDevice()){ //if touch events exist...
        var $el = $(elementSelector),
            scrollStartPosY= 0, scrollStartPosX= 0;

        function isExcluded(target) {
            var $resultElements, $excludedElements;
            if (exclusionSelector) {
                $excludedElements = $el.find(exclusionSelector);
                if ($excludedElements.length > 0) {
                    $resultElements = $excludedElements.has(target);
                    return $resultElements.length > 0;
                }
            }
            return false;
        }

        $el.on('touchstart', function(e){
            if (isExcluded(e.target)) {
                return;
            }
            scrollStartPosY=this.scrollTop+event.touches[0].pageY;
			scrollStartPosX=this.scrollLeft+event.touches[0].pageX;
        });

        $el.on('touchmove', function (e) {
            if (isExcluded(e.target)) {
                return;
            }
            if ((this.scrollTop < this.scrollHeight-this.offsetHeight &&
				this.scrollTop+event.touches[0].pageY < scrollStartPosY-5) ||
				(this.scrollTop != 0 && this.scrollTop+event.touches[0].pageY > scrollStartPosY+5))
					event.preventDefault();
			if ((this.scrollLeft < this.scrollWidth-this.offsetWidth &&
				this.scrollLeft+event.touches[0].pageX < scrollStartPosX-5) ||
				(this.scrollLeft != 0 && this.scrollLeft+event.touches[0].pageX > scrollStartPosX+5))
					event.preventDefault();
			this.scrollTop=scrollStartPosY-event.touches[0].pageY;
			this.scrollLeft=scrollStartPosX-event.touches[0].pageX;
        });
	}
}


