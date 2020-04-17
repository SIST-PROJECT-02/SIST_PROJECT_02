var initModalList = ()=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	wrap.innerHTML = "";
    layoutDataForModalList.startPoint = 0;
}


var modalListConstructor = (data) =>{
	modalData.modalIsReview = data.isMyReview;
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	
	injectDataModalList(data);
    
	wrap.querySelector('.modal-more-data').addEventListener('click',(e)=>{
		updateModalListAjax();
	});
	createModalReviewForm();
	initModalReviewForm();
	wrap.querySelector('.modal-review-form #review-content').addEventListener('keyup',(e)=>{
		var MAX_SIZE = 50;
		var len = e.target.value.length;
		console.log('len : ' + len);
		if(len > MAX_SIZE){
			alert('최대 50자까지 입력 가능합니다!');
			e.target.value = e.target.value.substr(0,MAX_SIZE);
		}
	})
	layoutDataForModalList.startPoint += 6;
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

var initModalReviewForm = ()=>{
	console.log('initModalReviewForm ... ok!');
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	var innerWrap = wrap.querySelector('.modal-review-form .star');
	var inWrap = wrap.querySelector('.modal-review-form');
	var reviewList = innerWrap.querySelectorAll('li');
	for(var i = 0; i < 3; i++){
		reviewList[i].innerText = '★';
	}
	for(var i = 3; i < 5; i++){
		reviewList[i].innerText = '☆';
	}
	innerWrap.querySelector('.star-num').innerText = '3';
	inWrap.querySelector('textarea').innerText = '';
	if(modalData.modalIsReview === 'false'){
		inWrap.querySelector('.bottom .delete').style.display = 'none';
		inWrap.querySelector('.bottom .update').style.display = 'none';
		inWrap.querySelector('.bottom .create').style.display = 'block';
	}else{
		inWrap.querySelector('.bottom .delete').style.display = 'block';
		inWrap.querySelector('.bottom .update').style.display = 'block';
		inWrap.querySelector('.bottom .create').style.display = 'none';
	}
}

var createModalReviewForm = ()=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	var innerWrap = wrap.querySelector('.modal-review-form .star');
	var reviewList = innerWrap.querySelectorAll('li');
	var reviewNum = innerWrap.querySelector('.star-num');
	innerWrap.addEventListener('click',(e)=>{
		var target = e.target;
		var targetName = target.getAttribute('name');
		if(targetName === null){
			return;
		}
		if(parseInt(targetName) > 0 && parseInt(targetName) <= 5){
			for(var i = 0; i < parseInt(targetName); i++){
				reviewList[i].innerText = '★';
			}
			for(var i = parseInt(targetName); i < 5; i++){
				reviewList[i].innerText = '☆';
			}
			reviewNum.innerText = parseInt(targetName);
		}
	})
	var createBtn = wrap.querySelector('.bottom .create');
	var content = wrap.querySelector('textarea');
	createBtn.addEventListener('click',(e)=>{
		console.log('createBtn clicked!');
		var sendData = "";
		sendData += "rate=" + reviewNum.innerText;
		sendData += "&content=" + content.value;
		sendData += "&product_id=" + modalData.modalId;
		
		console.log('create btn ->sendData : ' + sendData);
		ajaxFunc('modalReviewCreate.do',sendData,createModalReview);
	})
}

var createModalReview = (data)=>{
	if(data.modalRes === 'true'){
		alert('댓글이 등록되었습니다!');
	}else{
		alert('로그인을 해주세요!');
	}
}