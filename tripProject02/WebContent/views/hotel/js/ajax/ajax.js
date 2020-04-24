function ajaxFunc(url, sendData, func){
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	      if(this.readyState === 4 && this.status === 200){
	          var serverData = this.responseText;
	          
	          var serverDataObj = JSON.parse(serverData);
	          localData = serverDataObj;
	          func(serverDataObj);
	      }
	  };
	  xhttp.open('POST', url, true);
	  xhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	  xhttp.send(sendData);
	}