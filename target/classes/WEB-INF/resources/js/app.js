	function getById() {
		var str = document.getElementById("number").value;
		var status = document.getElementById("status");
		if(isEmpty(str)){
			status.innerHTML = "Please enter id";
		} else {
			var xmlhttp;
			if (window.XMLHttpRequest){
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			var url = window.contextRoot + '/user/' + str;
			xmlhttp.open("GET", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
					status.innerHTML=xmlhttp.responseText;
				}
			}
			xmlhttp.send();
		}
	}

	function isEmpty(str){
		return (str == null) || (str.length == 0);
	}

	function getAllAccounts(){
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("res").innerHTML=xmlhttp.responseText;
			}
		}
		var url = window.contextRoot + '/all/accounts';
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
	
	
	function getRichestUsers(){
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
				document.getElementById("result").innerHTML=xmlhttp.responseText;
			}
		}
		var url = window.contextRoot + '/richest-users';
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
    }

   	function getAccountsSum(){
		var xmlhttp;
		if (window.XMLHttpRequest){
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
				document.getElementById("result1").innerHTML=xmlhttp.responseText;
			}
		}
		var url = window.contextRoot + '/accounts-sum';
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
    }	