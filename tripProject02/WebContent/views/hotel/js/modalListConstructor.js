var initModalList = ()=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	wrap.innerHTML = "";
    layoutDataForModalList.startPoint = 0;
}


var modalListConstructor = (data) =>{
	modalData.modalIsReview = data.isMyReview;
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	
	injectDataModalList(data);
    document.querySelector('.modal-wrap').scrollTop = document.querySelector('.modal-wrap').scrollHeight;
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
		inWrap.querySelector('.bottom .create').style.display = 'inline-block';
		inWrap.querySelector('textarea').disabled = false;
	}else{
		inWrap.querySelector('.bottom .delete').style.display = 'inline-block';
		inWrap.querySelector('.bottom .update').style.display = 'inline-block';
		inWrap.querySelector('.bottom .create').style.display = 'none';
		inWrap.querySelector('textarea').placeholder = '이미 댓글을 쓰셨습니다!';
		inWrap.querySelector('textarea').disabled = true;
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
		if(content.value === null ||
				content.value.trim() === ''){
			alert('내용을 입력하세요!');
			return;
		}
		var sendData = "";
		sendData += "rate=" + reviewNum.innerText;
		sendData += "&content=" + content.value;
		sendData += "&product_id=" + modalData.modalId;
		
		ajaxFunc('modalReviewCreate.do',sendData,createModalReview);
	});
	
	var deleteBtn = wrap.querySelector('.bottom .delete');
	deleteBtn.addEventListener('click',(e)=>{
		
		if(confirm("정말로 삭제하겠습니까?")){
			var sendData = "";
			sendData += "&product_id=" + modalData.modalId;
			ajaxFunc('modalReviewDelete.do',sendData,deleteModalReview);
		}
		
	});
	
	var updateBtn = wrap.querySelector('.bottom .update');
	updateBtn.addEventListener('click',(e)=>{
		if(content.disabled === true){
			content.disabled = false;
			content.placeholder='댓글을 수정해주세요!';
			e.target.value = '쓰 기';
			return;
		}
		if(content.value === null ||
				content.value.trim() === ''){
			alert('내용을 입력하세요!');
			return;
		}
		var sendData = "";
		sendData += "rate=" + reviewNum.innerText;
		sendData += "&content=" + content.value;
		sendData += "&product_id=" + modalData.modalId;
		
		ajaxFunc('modalReviewUpdate.do',sendData,updateModalReview);
	});
}

var updateModalStar = (data)=>{
	var modal = document.querySelector('.modal-wrap');
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
	
	var target = document.querySelectorAll('.list ul > li');
	target.forEach((v,i)=>{
		if(v.getAttribute('name') === modalData.modalId){
			v.querySelector('label').innerText = star;
		}
	})
}
var createModalReview = (data)=>{
	if(data.modalRes === 'true'){
		initModalList();
		getModalListAjax();
		updateModalStar(data);
		alert('댓글이 등록되었습니다!');
		
	}else{
		alert('로그인을 해주세요!');
	}
}
var deleteModalReview = (data) =>{
	if(data.modalRes === 'true'){
		initModalList();
		getModalListAjax();
		updateModalStar(data);
		alert('댓글이 삭제되었습니다!');
	}
}
var updateModalReview = (data)=>{
	if(data.modalRes === 'true'){
		initModalList();
		getModalListAjax();
		updateModalStar(data);
		alert('댓글이 수정되었습니다!');
		
	}else{
		alert('로그인을 해주세요!');
	}
}