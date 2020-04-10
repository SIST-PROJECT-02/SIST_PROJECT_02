//생성에만 관여한다

//1. 생성에 필요한 임시 데이터(나중에 ajax로 대체)
'strict mode'

var layoutData = {
    width : 1200,
    rowCount : 3,
    elementHeight : 400,
    startPoint : 0,
    getCount : 6,
    sortCondition : 1,
    search : ''
};


function ajaxFunc(url, sendData, func){
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	      if(this.readyState === 4 && this.status === 200){
	          var serverData = this.responseText; // String
	          
	          var serverDataObj = JSON.parse(serverData);
	          console.log('ajax list! : ' + serverDataObj);
	          //json 객체 - 배열을 품고 있다
	          localData = serverDataObj;
	          func(serverDataObj);
	      }
	  };
	  xhttp.open('POST', url, true);
	  xhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	  /*
	    startPoint : 0,
    	getCount : 6,
    	sortCondition : 0
	   */
	  xhttp.send(sendData);
	}

window.addEventListener('DOMContentLoaded', ()=>{
	document.querySelector('section.list ul').innerHTML = "";
	getListAjax();
});

var initList = ()=>{
	var wrap = document.querySelector('section.list');
    var innerWrap = wrap.querySelector('ul');
    innerWrap.innerHTML = "";
    layoutData.startPoint = 0;
}
var makeList = (data) =>{
    var wrap = document.querySelector('section.list');
    var innerWrap = wrap.querySelector('ul');
    var listData = data.list;
    var moreData = wrap.querySelector('.more-data');
    var templateData = document.querySelector('#template-list-items').innerHTML;
    //innerWrap.innerHTML = "";

	console.log('datacount ::::::::::::::: ' + data.count);
	wrap.querySelector('.list-count').innerText = "총 " + data.count + " 개의 검색결과가 있어요!";
    listData.forEach((v,i)=>{
    	var evelText = "";
    	for(var i = 0; i < v.evelPoint; i++){
    		evelText += " ★ ";
    	}
    	for(var i = v.evelPoint; i < 5; i++){
    		evelText += " ☆ ";
    	}
        innerWrap.innerHTML += templateData.replace('{name}',v.id)
                                           .replace('{img}', v.thumbnail)
                                           .replace('{title}',v.title)
                                           .replace('{label}',evelText)
                                           .replace('{information}',v.information);
        
        
    });
    if(data.more === 'true'){
    	moreData.style.display = 'block';
    }else{
    	moreData.style.display = 'none';
    }
    var items = innerWrap.querySelectorAll('li');
    items.forEach((v,i)=>{
        v.addEventListener('mouseover',(e)=>{
            var aItem = v.querySelector('a:nth-child(3)');
            aItem.style.backgroundColor = '#7643ea';
            aItem.style.color = 'white';
        });
        v.addEventListener('mouseout',(e)=>{
            var aItem = v.querySelector('a:nth-child(3)');
            aItem.style.backgroundColor = '#f4f6f8';
            aItem.style.color = 'black';
        });
        v.addEventListener('click',(e)=>{
        	var id = e.currentTarget.getAttribute('name');
        	var sendData = "id=" + id;
        	ajaxFunc('listDetail.do',sendData,getModal);
        });
    })
    setLayout(layoutData);
}

document.querySelector(".more-data").addEventListener('click',(e)=>{
	//먼저, 개수와 정렬 조건을 얻는 것이 필요하지만 생략하자 일단은
	getListAjax();
});

var getListAjax = ()=>{
	var sendData = "";
	  sendData += "startPoint=" + layoutData.startPoint;
	  sendData += "&getCount=" + layoutData.getCount;
	  sendData += "&sortCondition=" + layoutData.sortCondition;
	  sendData += "&search=" + layoutData.search;
	  console.log("sendData : " + sendData);
	ajaxFunc('list.do',sendData,makeList);
	layoutData.startPoint += 6;
}
