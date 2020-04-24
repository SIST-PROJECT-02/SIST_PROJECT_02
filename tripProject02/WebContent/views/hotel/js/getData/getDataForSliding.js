document.querySelector('section.sliding-wrap').addEventListener('click', (e) => {
    //이미지 자체, 왼쪽화살, 오른쪽화살, 네모버튼, 재생버튼
    if (e.target === document.querySelector('section.sliding-wrap > .sliding-left-arrow > img')) {
        //동작 가능하다
        if(movingData.mode === 'true'){
            movingData.nextPos -= 1;
            moveSlider();
        }
    } else if (e.target === document.querySelector('section.sliding-wrap > .sliding-right-arrow > img')) {
        if(movingData.mode === 'true'){
            movingData.nextPos += 1;
            moveSlider();
        }
    } else if(e.target.getAttribute('class') === 'sliding-check-play-stop'){
        movingData.playMode = (movingData.playMode + 1) % 2;
        if(movingData.playMode === 1){
            e.target.src = './../../hotel/img/stop-btn.png';
            timeoutOperation();
        }else{
            e.target.src = './../../hotel/img/play-btn.png';
            clearTimeout(movingData.timefunc);
        }
    }
    for(var i = 0 ; i < movingData.slidingCount; i++){
        if(e.target.getAttribute('class') === 'sliding-check-' + i){
            movingData.nextPos = i;
            moveSlider();
        }
    }
});
document.querySelector('section.sliding-wrap').addEventListener('mouseover', (e) => {
    var tmpList = document.querySelectorAll('section.sliding-wrap > a > img');
    tmpList.forEach((v, i) => {
        v.style.display = 'block';
    });
});
document.querySelector('section.sliding-wrap').addEventListener('mouseout', (e) => {
    var tmpList = document.querySelectorAll('section.sliding-wrap > a > img');
    tmpList.forEach((v, i) => {
        v.style.display = 'none';
    });
});

document.querySelector('.sliding-item').addEventListener('transitionend', (e)=>{
    var leftValue = e.currentTarget.style.left;
    leftValue = leftValue.toString();
    leftValue = leftValue.substr(0,leftValue.indexOf('p'));
    leftValue = parseInt(leftValue);
    if(movingData.curPos === -1){
        movingData.curPos = movingData.nextPos = movingData.len-1;
        e.currentTarget.style.left = (leftValue + (-1 * movingData.len) * movingData.width) + 'px';
    }else if(movingData.curPos === movingData.len){
        movingData.curPos = movingData.nextPos = 0;
        e.currentTarget.style.left = (leftValue + movingData.len*movingData.width) + 'px';
    }
    movingData.mode = 'true';
});

window.addEventListener('DOMContentLoaded', ajaxFunc());

document.querySelector('.sliding-item').addEventListener('click', (e)=>{
	if(e.target.tagName === 'IMG' ||e.target.tagName === 'DIV'){
		var id = '';
		var parentSlidingItem = e.target;
		while(parentSlidingItem.tagName !== 'LI'){
			parentSlidingItem = parentSlidingItem.parentNode;
		}
		id = parentSlidingItem.getAttribute('name');
		console.log('sliding id : ' + id);
		var sendData = "id=" + id;
		modalData.modalId = id;
		ajaxFunc('listDetail.do',sendData,getModal);
	}
});
