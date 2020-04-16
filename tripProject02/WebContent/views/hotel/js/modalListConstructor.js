var initModalList = ()=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	wrap.innerHTML = "";
    layoutDataForModalList.startPoint = 0;
}


var modalListConstructor = (data) =>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	
	injectDataModalList(data);
    
	wrap.querySelector('.modal-more-data').addEventListener('click',(e)=>{
		updateModalListAjax();
	});
	
	layoutForModalList();
}
var updateModalList = (data)=>{
	injectDataModalListUpdate(data);
	layoutForModalList();
}

var layoutForModalList = ()=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	var modalReview = wrap.querySelector('.modal-review');
	modalReview.style.width = layoutDataForModalList.width + 'px';
}