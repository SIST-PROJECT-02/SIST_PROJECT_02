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
	if(data.thumbnail === 'null' || !(data.thumbnail)){
    	data.thumbnail = "./../../hotel/img/imgPrepare.png";
	}
	thumbnail.src = data.thumbnail;
	var hashTag = modal.querySelector('.data-wrap .img-wrap span');
	if(data.hashTag === 'null' || !(data.hashTag)){
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
		if(modalLocalData.description === 'null' || !(modalLocalData.description)){
			modalLocalData.description = '설명 준비중이에요!';
		}
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
		var content = document.querySelector('#template-mark').innerHTML;
		content = content.replace('{thumbnail}',otData.thumbnail)
						 .replace('{title}',otData.title);
		chData.content = content;
		latlng = new kakao.maps.LatLng(otData.latitude,otData.longitude);
		chData.latlng = latlng;
		
		var pos;
		switch(otData.product_kind){
		case '관광지': pos = 0; break;
		case '숙박': pos = 1; break;
		case '음식점': pos = 2; break;
		}
		chData.pos = pos;
		
		positions.push(chData);
	});
	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	var imageSrcs = [];
	imageSrcs.push('./../../hotel/img/attraction.png');
	imageSrcs.push('./../../hotel/img/hotel.png');
	imageSrcs.push('./../../hotel/img/food.png');
	for (var i = 0; i < positions.length; i ++) {
	    
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(24, 35); 
	    
	    switch(positions[i].pos){
	    case 0: imageSrc = imageSrcs[0]; break;
	    case 1: imageSrc = imageSrcs[1]; break;
	    case 2: imageSrc = imageSrcs[2]; break;
	    }
	    // 마커 이미지를 생성합니다    
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	    
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng, // 마커를 표시할 위치
	        image : markerImage // 마커 이미지 
	    });
	 // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });

	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	    
	}
	
}
//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}

var registModalDrag = ()=>{
	var modal = document.querySelector('.modal-wrap');
	var style = window.getComputedStyle(modal,null);
	var modalX = (style.left).substr(0,(style.left).indexOf('px'));
	var modalY = (style.top).substr(0,(style.top).indexOf('px'));
	var gapX = 0;
	var gapY = 0;

	modal.addEventListener('drag',(e)=>{
	});
	modal.addEventListener('dragstart',(e)=>{
		console.log("dd");
		modalX = (style.left).substr(0,(style.left).indexOf('px'));
		modalY = (style.top).substr(0,(style.top).indexOf('px'));
		gapX = modalX - e.pageX;
		gapY = modalY - e.pageY;
	});
	modal.addEventListener('dragover',(e)=>{
		modal.style.top = gapY + e.pageY + 'px';
		modal.style.left = gapX + e.pageX + 'px';
	});
}
document.querySelector('.modal-wrap .reservation-btn').addEventListener('click',(e)=>{
	console.log('reservation button clicked!');
	
	window.location.href = 'reservation.do?product_id=' + modalData.modalId;
});
