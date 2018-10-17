// https://stackoverflow.com/questions/9617481/jsf2ajax-keep-scrollbar-position-plain-mojarra

function saveScrollbarPos(id) {
	var scrollbarid = id;

	function savePos() {
	    var scrollbar = document.getElementById(scrollbarid);
	    document.cookie = scrollbarid+".scrolltop="+scrollbar.scrollTop+"; path=/";
	}

	function readCookie(name) {
	    var nameEQ = name + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0;i < ca.length;i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1,c.length);
	        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	    }
	    return null;
	}

	function restorePos() {
	    var scrollbar = document.getElementById(scrollbarid);
	    scrollbar.scrollTop = readCookie(scrollbarid+".scrolltop");
	}

	function onStatusChange(data) {
	    var status = data.status;
	    if (status == "begin") {
	        savePos();
	    }
	    else {
	        restorePos();
	    }
	};

	var scrollbar = document.getElementById(scrollbarid);
	if (scrollbar != null) {
	    jsf.ajax.addOnEvent(onStatusChange);
	    jsf.ajax.addOnError(onStatusChange);
	}
};
