
'use strict'

window.addEventListener('DOMContentLoaded', ()=>{
	document.querySelector('.' + layoutDataForMainList.mainClassName +' ul').innerHTML = "";
	document.querySelector('.' + layoutDataForMainList.navClassName + ' ul li select').addEventListener('change',(e)=>{
    	switch(e.target.value){
    	case "1":
    		layoutDataForMainList.width = 800;
    		layoutDataForMainList.rowCount = parseInt(e.target.value);
    		layoutDataForMainList.elementHeight = 500;
    		break;
    	case "2":
    		layoutDataForMainList.width = 900;
    		layoutDataForMainList.rowCount = parseInt(e.target.value);
    		layoutDataForMainList.elementHeight = 400;
    		break;
    	case "3":
    		layoutDataForMainList.width = 1000;
    		layoutDataForMainList.rowCount = parseInt(e.target.value);
    		layoutDataForMainList.elementHeight = 300;
    		break;
    	}
    	setLayout(layoutDataForMainList);
    });
	getListAjax();
});

var initList = ()=>{
	var wrap = document.querySelector('.' + layoutDataForMainList.mainClassName);
    var innerWrap = wrap.querySelector('ul');
    innerWrap.innerHTML = "";
    layoutDataForMainList.startPoint = 0;
}


var listConstructor = (data, mainClass, navClass) =>{
	
	// 임시 데이터
	mainClass = layoutDataForMainList.mainClassName;
	navClass = layoutDataForMainList.navClassName;
	// ////////
	
	document.querySelector('.' + layoutDataForMainList.mainClassName).className = mainClass;
	document.querySelector('.' + layoutDataForMainList.navClassName).className = navClass;
	layoutDataForMainList.mainClassName = mainClass;
	layoutDataForMainList.navClassName = navClass;
	
	injectDataMainList(data);
    
	document.querySelector('.' + layoutDataForMainList.mainClassName + " .more-data").addEventListener('click',(e)=>{
		updateListAjax();
	});
	layoutDataForMainList.startPoint += 6;
    setLayout(layoutDataForMainList);
}
var updateList = (data)=>{
	injectDataMainList(data);
	layoutDataForMainList.startPoint += 6;
    setLayout(layoutDataForMainList);
}
