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

var modalSetting = (data)=>{
	modalLocalData = data;
	var modal = document.querySelector('.modal-wrap');
	var thumbnail = modal.querySelector('.data-wrap .img-wrap img');
	thumbnail.src = data.thumbnail;
	var hashTag = modal.querySelector('.data-wrap .img-wrap span');
	if(data.hashTag === 'null'){
		console.log('data.hashTag is null : ' + data.hashTag);
		data.hashTag = '즐거운 숙박!!♡행';
	}
	hashTag.innerText ='#' + data.hashTag.replace(/,/ig,',#');
	
	var title = modal.querySelector('.data-wrap .basic-info-wrap p');
	title.innerHTML = "";
	title.innerHTML += data.title + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	var star = '';
	var starRes = 0;
	if(data.reviewCount > 1){
		starRes = parseInt((data.sumOfRate)/(data.reviewCount - 1));
	}else{
		starRes = parseInt(data.evelPoint);
	}
	for(var i = 0; i < starRes; i++){
		star += '★';
	}
	for(var i = starRes; i < 5; i++){
		star += '☆';
	}
	title.innerHTML += star;
	var dynamicModal = modal.querySelector('.dynamic-info-wrap');
	var templateModal = document.querySelector('#template-modal-detail').innerHTML;
	templateModal = templateModal.replace('{description}',data.description);
	dynamicModal.innerHTML = templateModal;
}

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