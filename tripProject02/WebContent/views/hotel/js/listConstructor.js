
'use strict'

window.addEventListener('DOMContentLoaded', ()=>{
	console.log('it is changed - configuration5');
	document.querySelector('.' + layoutDataForMainList.mainClassName +' ul').innerHTML = "";
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
	
	initList();
	
	injectDataMainList(data);
    
	document.querySelector('.' + layoutDataForMainList.mainClassName + " .more-data").addEventListener('click',(e)=>{
		updateListAjax();
	});
	
    setLayout(layoutDataForMainList);
}
var updateList = (data)=>{
	injectDataMainList(data);
    
    setLayout(layoutDataForMainList);
}
