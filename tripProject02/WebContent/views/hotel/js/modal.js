var modalData = {
    operation : 'false',
    operating : 'false',
    modalNavMenu : 0
};
var modalLocalData = {};
// modal background layout
window.addEventListener('DOMContentLoaded',(e)=>{
    var modalBack = document.querySelector('.modal-background');
    modalBack.style.width = document.body.clientWidth + 'px';
    modalBack.style.height = '2000px';
    var modal = document.querySelector('.modal-wrap');
});
document.querySelector('.modal-wrap nav').addEventListener('click',(e)=>{
	console.log('modal click operation');
	var modal = document.querySelector('.modal-wrap');
	var dynamicModal = modal.querySelector('.dynamic-info-wrap');
	switch(e.target.id){
	case "nav-detail":
		console.log('nav-detail');
		var templateModal = document.querySelector('#template-modal-detail').innerHTML;
		templateModal = templateModal.replace('{description}',modalLocalData.description);
		dynamicModal.innerHTML = templateModal;
		break;
	case "nav-info":
		console.log('nav-info');
		var templateModal = document.querySelector('#template-modal-info').innerHTML;
		templateModal = templateModal.replace('{introduction}',modalLocalData.introduction)
									 .replace('{short_introduction}',modalLocalData.shortIntroduction)
									 .replace('{convenience}', modalLocalData.convenience);
		
		templateModal = templateModal.replace(/undefined/ig,'')
									 .replace(/null/ig, '');
		dynamicModal.innerHTML = templateModal;
		break;
	}
});
var modalSetting = (data)=>{
	modalLocalData = data;
	var modal = document.querySelector('.modal-wrap');
	var thumbnail = modal.querySelector('.data-wrap .img-wrap img');
	thumbnail.src = data.thumbnail;
	var hashTag = modal.querySelector('.data-wrap .img-wrap span');
	console.log('da.hashTag : ' + data.hashTag);
	if(data.hashTag === 'null'){
		console.log('data.hashTag is null : ' + data.hashTag);
		data.hashTag = '즐거운 숙박!!♡행';
	}
	hashTag.innerText ='#' + data.hashTag.replace(/,/ig,',#');
	
	var title = modal.querySelector('.data-wrap .basic-info-wrap p');
	title.innerHTML = "";
	title.innerHTML += data.title + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	var star = '';
	for(var i = 0; i < data.evelPoint; i++){
		star += '★';
	}
	for(var i = data.evelPoint; i < 5; i++){
		star += '☆';
	}
	title.innerHTML += star;
	var dynamicModal = modal.querySelector('.dynamic-info-wrap');
	var templateModal = document.querySelector('#template-modal-detail').innerHTML;
	templateModal = templateModal.replace('{description}',data.description);
	dynamicModal.innerHTML = templateModal;
}
var getModal = (data) =>{
	if(modalData.operation === 'true' || modalData.operating === 'true'){
        return;
    }
    modalData.operating = 'true';
    var modal = document.querySelector('.modal-wrap');
    var modalBack = document.querySelector('.modal-background');
    initNav();
    modalBack.style.display = 'block';
    modal.style.display = 'block';
    document.body.style.overflow = 'hidden';
    modalSetting(data);
    modalOperating();
}

var initNav = function(){
    var list = document.querySelectorAll('.modal-wrap nav li');
    list.forEach((v,i)=>{
        if(i === list.length-1){
            v.style.borderRight = '1px solid #e5e5e5';
        }else{
            v.style.borderRight = '0px';
        }
        
        v.style.borderTop = '1px solid #e5e5e5';
        v.style.borderLeft = '1px solid #e5e5e5';
        v.style.borderBottom = '2px solid #ef6d00';
    })

}

var modalOperating = function(){
    var modal = document.querySelector('.modal-wrap');
    setTimeout(()=>{
        modalData.operation = 'true';
        modal.style.display = 'block';
        modalData.operating = 'false';
    },200);
}

document.querySelector('.modal-wrap nav').addEventListener('click',(e)=>{
    var target = e.target;
    if(target.tagName === 'LI'){

        initNav();
        target.style.border = '2px solid #ef6d00';
        target.style.borderBottom = '0px';
    }
});

// 모달 종료시키기
window.addEventListener('click',(e)=>{
    if(modalData.operation === 'false' || modalData.operating === 'true'){
        return;
    }
    var modal = document.querySelector('.modal-wrap');
    var target = e.target;
    // target을 찾는데, modal을 못찾고 body를 만나면 return
    var count = 0;
    while(target.tagName !=='BODY' && count < 10){
        console.log(target.tagName);
        if(target === modal){
            return;
        }
        target = target.parentNode;
        count++;
    }

    var modalBack = document.querySelector('.modal-background');
    modalBack.style.display = 'none';
    modal.style.display = 'none';
    document.body.style.overflow = 'auto';
    modalData.operation = 'false';
});
