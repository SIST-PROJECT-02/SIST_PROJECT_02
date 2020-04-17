var getListAjax = ()=>{
	initList();
	var sendData = "";
	  sendData += "startPoint=" + layoutDataForMainList.startPoint;
	  sendData += "&getCount=" + layoutDataForMainList.getCount;
	  sendData += "&sortCondition=" + layoutDataForMainList.sortCondition;
	  sendData += "&search=" + layoutDataForMainList.search;
	  console.log("sendData : " + sendData);
	ajaxFunc('list.do',sendData,listConstructor);
}

var updateListAjax = ()=>{
	var sendData = "";
	  sendData += "startPoint=" + layoutDataForMainList.startPoint;
	  sendData += "&getCount=" + layoutDataForMainList.getCount;
	  sendData += "&sortCondition=" + layoutDataForMainList.sortCondition;
	  sendData += "&search=" + layoutDataForMainList.search;
	  console.log("sendData : " + sendData);
	ajaxFunc('list.do',sendData,updateList);
}

var injectDataMainList = (data)=>{
	console.log('injectData - s start : ' + layoutDataForMainList.startPoint);
	var wrap = document.querySelector('.' + layoutDataForMainList.mainClassName);
    var innerWrap = wrap.querySelector('ul');
    var listData = data.list;
    var moreData = wrap.querySelector('.more-data');
    
	wrap.querySelector('.list-count').innerText = "총 " + data.count + " 개의 검색결과가 있어요!";
    listData.forEach((v,i)=>{
    	var evelText = "";
    	var evelRes = 0;
    	if(v.reviewCount > 1){
    		evelRes = parseInt((v.sumOfRate)/(v.reviewCount - 1));
    	}else{
    		evelRes = parseInt(v.evelPoint);
    	}
    	for(var i = 0; i < evelRes; i++){
    		evelText += " ★ ";
    	}
    	for(var i = evelRes; i < 5; i++){
    		evelText += " ☆ ";
    	}
    	var templateData = document.querySelector('#template-list-items').innerHTML;
        templateData = templateData.replace('{name}',v.id)
                                           .replace('{img}', v.thumbnail)
                                           .replace('{title}',v.title)
                                           .replace('{label}',evelText)
                                           .replace('{information}',v.information);
        if(v.like == 'false'){
        	templateData = templateData.replace('{like}','♡');
        }else{
        	templateData = templateData.replace('{like}','♥');
        }
        innerWrap.innerHTML += templateData;
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
        	modalData.modalId = id;
        	ajaxFunc('listDetail.do',sendData,getModal);
        });
    })
}