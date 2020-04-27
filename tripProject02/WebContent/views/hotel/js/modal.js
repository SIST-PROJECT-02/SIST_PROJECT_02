
var initNav = function(){
    var list = document.querySelectorAll('.modal-wrap nav li');
    list.forEach((v,i)=>{
        if(i === list.length-1){
            v.style.borderRight = '2px solid rgba(255,255,255,.15)';
        }else{
            v.style.borderRight = '0px';
        }
        
        v.style.borderTop = '1px solid rgba(255,255,255,.15)';
        v.style.borderLeft = '2px solid rgba(255,255,255,.15)';
        v.style.borderBottom = '3px solid #7643ea';
    });
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
        target.style.border = '2px solid #7643ea';
        target.style.borderBottom = '0px ';
    }
});
document.querySelector('.modal-wrap .img-wrap div').addEventListener('click',(e)=>{
	//1. ajax로 보내기 - session정보와 product 정보가 필요하다 (config에 있다) modalData.modalId
	
	var sendData = "productId=" + modalData.modalId;
	ajaxFunc('modalLike.do',sendData,changeModalLike);
	//2. 함수 실행 끝
})

// 모달 종료시키기
window.addEventListener('click',(e)=>{
    if(modalData.operation === 'false' || modalData.operating === 'true'){
        return;
    }
    var modal = document.querySelector('.modal-wrap');
    var target = e.target;
    // target을 찾는데, modal을 못찾고 body를 만나면 return
    var count = 0;
    while(target.tagName !=='BODY' && count < 20){
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

window.addEventListener('DOMContentLoaded',(e)=>{
	registModalDrag();
});
