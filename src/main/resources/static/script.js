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

document.addEventListener("DOMContentLoaded", function () {
document
    .getElementById("choice")
    .addEventListener("change", function (event) {
		console.log("Hello");
			let choice = document.getElementById("choice").value;
			if(choice == 1){
				console.log("You picked one");
				var elements = document.getElementsByClassName('1');
			    for (var i = 0; i < elements.length; i++) {
			      elements[i].style.display = 'block';
			    }
				var otherElements = document.getElementsByClassName('2');
			    for (var i = 0; i < otherElements.length; i++) {
			      otherElements[i].style.display = 'none';
			    }
			} else if(choice == 2){
				console.log("You picked two");
				var elements = document.getElementsByClassName('2');
			    for (var i = 0; i < elements.length; i++) {
			      elements[i].style.display = 'block';
			    }
				var otherElements = document.getElementsByClassName('1');
			    for (var i = 0; i < otherElements.length; i++) {
			      otherElements[i].style.display = 'none';
			    }
			} else {
				var elements = document.getElementsByClassName('2');
			    for (var i = 0; i < elements.length; i++) {
			      elements[i].style.display = 'block';
			    }
				var otherElements = document.getElementsByClassName('1');
			    for (var i = 0; i < otherElements.length; i++) {
			      otherElements[i].style.display = 'block';
			    }
			}
		})
	})