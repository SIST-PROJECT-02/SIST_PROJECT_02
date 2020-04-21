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
	
	if(data.like === 'true'){
		modal.querySelector('.img-wrap div').innerText = '♥';
	}else{
		modal.querySelector('.img-wrap div').innerText = '♡';
	}
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
	
	var navReview = document.querySelector('.modal-wrap .data-wrap nav ul #nav-review');
    navReview.innerHTML = '리뷰[<span style="color:red;">' +data.count +'</span>]';
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
	case "nav-review":
		console.log('nav-review');
		initModalList();
		//1. ajax로 데이터를 가져온다
		getModalListAjax();
		break;
	case "nav-attraction":
		console.log('nav-attraction');
		var templateModal = document.querySelector('#template-modal-map-wrap').innerHTML;
		dynamicModal.innerHTML = templateModal;
		getModalMapAjax();
	}
});

var getModalListAjax = ()=>{
	var sendData = "";
	  sendData += "startPoint=" + layoutDataForModalList.startPoint;
	  sendData += "&getCount=" + layoutDataForModalList.getCount;
	  sendData += "&productId=" + modalData.modalId;
	ajaxFunc('modalList.do',sendData,modalListConstructor);
}


var injectDataModalListUpdate = (data) =>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	var innerWrap = wrap.querySelector('ul');
    var listData = data.list;
    var moreData = wrap.querySelector('.modal-more-data');
    var templateData = document.querySelector('#template-modal-review').innerHTML;
    wrap.querySelector('.list-modal-count').innerText = "총 " + data.count + " 개의 리뷰가 있어요!";
    var navReview = document.querySelector('.modal-wrap .data-wrap nav ul #nav-review');
    navReview.innerHTML = '리뷰[<span style="color:red;">' +data.count +'</span>]';
    listData.forEach((v,i)=>{
    	var evelText = "";
    	for(var i = 0; i < v.evelPoint; i++){
    		evelText += " ★ ";
    	}
    	for(var i = v.evelPoint; i < 5; i++){
    		evelText += " ☆ ";
    	}
    	
        innerWrap.innerHTML += templateData.replace('{user-id}',v.id)
                                           .replace('{user-name}', v.memberEmail)
                                           .replace('{user-date}',v.regdate)
                                           .replace('{user-star}',evelText)
                                           .replace('{user-content}',v.content);
        
        
    });
    if(data.more === 'true'){
    	moreData.style.display = 'block';
    }else{
    	moreData.style.display = 'none';
    }
    
}
var injectDataModalList = (data)=>{
	var wrap = document.querySelector('.modal-wrap .data-wrap .dynamic-info-wrap');
	var templateDataWrap = document.querySelector('#template-modal-review-wrap').innerHTML;
	templateDataWrap.replace('{count}',data.count);
	wrap.innerHTML = templateDataWrap;
    var innerWrap = wrap.querySelector('ul');
    var listData = data.list;
    var moreData = wrap.querySelector('.modal-more-data');
    var templateData = document.querySelector('#template-modal-review').innerHTML;
    
    
	wrap.querySelector('.list-modal-count').innerText = "총 " + data.count + " 개의 리뷰가 있어요!";
	var navReview = document.querySelector('.modal-wrap .data-wrap nav ul #nav-review');
    navReview.innerHTML = '리뷰[<span style="color:red;">' +data.count +'</span>]';
    listData.forEach((v,i)=>{
    	var evelText = "";
    	for(var i = 0; i < v.evelPoint; i++){
    		evelText += " ★ ";
    	}
    	for(var i = v.evelPoint; i < 5; i++){
    		evelText += " ☆ ";
    	}
    	
        innerWrap.innerHTML += templateData.replace('{user-id}',v.id)
                                           .replace('{user-name}', v.memberEmail)
                                           .replace('{user-date}',v.regdate)
                                           .replace('{user-star}',evelText)
                                           .replace('{user-content}',v.content);
        
        
    });
    if(data.more === 'true'){
    	moreData.style.display = 'block';
    }else{
    	moreData.style.display = 'none';
    }
}

var updateModalListAjax = () =>{
	var sendData = "";
	  sendData += "startPoint=" + layoutDataForModalList.startPoint;
	  sendData += "&getCount=" + layoutDataForModalList.getCount;
	  sendData += "&productId=" + modalData.modalId;
	  console.log("sendData : " + sendData);
	ajaxFunc('modalList.do',sendData,updateModalList);
	layoutDataForModalList.startPoint += 6;
}

var changeModalLike = (data)=>{
	if(data.like === 'no'){
		alert('로그인이 필요합니다!');
	}
	else if(data.like === 'on'){
		document.querySelector('.modal-wrap .img-wrap div').innerText = '♥';
		var target = document.querySelectorAll('.list ul > li');
		target.forEach((v,i)=>{
			if(v.getAttribute('name') === modalData.modalId){
				v.querySelector('#title span').innerText = '♥';
			}
		})
		alert('좋아요에 추가되었습니다!');
	}else{
		document.querySelector('.modal-wrap .img-wrap div').innerText = '♡';
		var target = document.querySelectorAll('.list ul > li');
		target.forEach((v,i)=>{
			if(v.getAttribute('name') === modalData.modalId){
				v.querySelector('#title span').innerText = '♡';
			}
		})
		alert('좋아요가 취소되었습니다!');
	}
}

var getModalMapAjax = ()=>{
	sendData = "";
	var sendData = "";
	  sendData += "&productId=" + modalData.modalId;
	ajaxFunc('modalMap.do',sendData,getMapAPI);
}
var getMapAPI = (data)=>{
	//ACOS( COS( RADIANS( 90-위도1 )) * COS( RADIANS( 90-위도2 )) + SIN( RADIANS( 90-위도1 )) * SIN( RADIANS( 90-위도2 )) * COS( RADIANS( 경도1-경도2 ))) * 6378.137
	var modal = document.querySelector('.modal-wrap');
	var dynamicModal = modal.querySelector('.dynamic-info-wrap'); 
	var container = dynamicModal.querySelector('section.modal-map-wrap'); //지도를 담을 영역의 DOM 레퍼런스
	console.log('modal-data : ' + data);
	var myData = JSON.parse(data.myData);
	console.log('위도 경도 : ' + myData.longitude +','+ myData.latitude);
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(myData.latitude,myData.longitude), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	// 마커를 표시할 위치와 title 객체 배열입니다 
	var positions = [];
	data.othersData.forEach((v,i)=>{
		var otData = JSON.parse(v);
		var chData = {};
		var latlng;
		chData.title = otData.title;
		// latlng: new kakao.maps.LatLng(33.450705, 126.570677)
		latlng = new kakao.maps.LatLng(otData.latitude,otData.longitude);
		chData.latlng = latlng;
		positions.push(chData);
		console.log(chData.title);
		console.log(chData.latlng);
	});
	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	    
	for (var i = 0; i < positions.length; i ++) {
	    
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(24, 35); 
	    
	    // 마커 이미지를 생성합니다    
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	    
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng, // 마커를 표시할 위치
	        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	        image : markerImage // 마커 이미지 
	    });
	}
	
}
