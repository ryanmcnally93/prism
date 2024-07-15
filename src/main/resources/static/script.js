function commentsCalloutTrigger(id) {
	let comments = document.getElementById("calloutComment" + id)
	if(comments.style.display == "block"){
		comments.style.display = "none";
	} else {
		comments.style.display = "block";
	}
}
function commentsFameTrigger(id) {
	let comments = document.getElementById("fameComment" + id)
	if(comments.style.display == "block"){
		comments.style.display = "none";
	} else {
		comments.style.display = "block";
	}
}
