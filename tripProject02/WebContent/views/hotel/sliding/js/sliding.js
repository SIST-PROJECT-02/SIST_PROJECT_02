'strict mode'

var data = {
    list: [
        {
            img: "./../img/check-off.png",
            title: "1번 타이틀 입니다",
            information: "1번 인포메이션 입니다."
        },
        {
            img: "./../img/check-on.png",
            title: "2번 타이틀 입니다",
            information: "2번 인포메이션 입니다."
        },
        {
            img: "./../img/play-btn.png",
            title: "3번 타이틀 입니다",
            information: "3번 인포메이션 입니다."
        }
    ]
};

var movingData ={
    curPos : 0,
    nextPos : 0,
    len : 0,
    mode : 'true',
    width : 0,
    transLoc : 0,
    playMode : 1,
    timefunc : 0
};
var makeSlidingMainTemplate = (width, height, data) => {
    //1. 사이즈 결정하기

    //wrap 결정하기
    var slidingWrap = document.querySelector('.sliding-wrap');
    slidingWrap.style.width = width + "px";
    slidingWrap.style.height = height + "px";

    //arrow 결정하기
    var arrowWidth = width / 10;
    var arrowHeight = height / 5;
    var leftArrow = document.querySelector('.sliding-left-arrow > img');
    var rightArrow = document.querySelector('.sliding-right-arrow > img');
    leftArrow.style.width = arrowWidth + "px";
    leftArrow.style.height = arrowHeight + "px";
    rightArrow.style.width = arrowWidth + "px";
    rightArrow.style.height = arrowHeight + "px";
    leftArrow.style.left = (height + arrowHeight) / 2 + "px";

    var la = document.querySelector('.sliding-left-arrow');
    var ra = document.querySelector('.sliding-right-arrow');
    la.style.top = (height - arrowHeight) / 2 + "px";
    ra.style.top = (height - arrowHeight) / 2 + "px";
    ra.style.left = (width - arrowWidth) + "px";

    //check div 결정하기
    var slidingCheck = document.querySelector('.sliding-check-box');
    slidingCheck.style.height = "50px";
    slidingCheck.style.width = (width - 2 * arrowWidth) + "px";
    slidingCheck.style.left = arrowWidth + "px";
    slidingCheck.style.top = height - 60 + "px";

    //data 반영하기
    var list = data.list;
    var checkListItems = document.querySelector('.sliding-check-items');
    checkListItems.innerHTML = "";
    var checkListItem = document.querySelector('#template-sliding-check-item').innerHTML;
    var len = list.length;

    for (var i = 0; i < len; i++) {
        checkListItems.innerHTML += checkListItem.replace('{img-kind}', './../img/check-off.png')
                                                 .replace('{class}','sliding-check-' + i);
    }
    checkListItems.firstElementChild.querySelector('img').src = './../img/check-on.png';
    checkListItems.innerHTML += checkListItem.replace('{img-kind}', './../img/stop-btn.png')
                                             .replace('{class}', 'sliding-check-play-stop');

    //item div 결정하기
    var slidingItem = document.querySelector('.sliding-item');
    slidingItem.style.width = width * (len + 3) + "px";
    slidingItem.innerHTML = "";
    
    var slidingItems = document.querySelector('#template-sliding-items').innerHTML;
    slidingItem.innerHTML += slidingItems.replace('{name}','-1')
                                         .replace('{img}', data.list[len-1].img)
                                         .replace('{title}',data.list[len-1].title)
                                         .replace('{information}',data.list[len-1].information);
    for(var i = 0; i < len; i++){
        console.log('hello');
        slidingItem.innerHTML += slidingItems.replace('{name}',i + ' ')
                                            .replace('{img}', data.list[i].img)
                                            .replace('{title}',data.list[i].title)
                                            .replace('{information}',data.list[i].information);
    }
    slidingItem.innerHTML += slidingItems.replace('{name}',(len-1) + '')
                                         .replace('{img}', data.list[0].img)
                                         .replace('{title}',data.list[0].title)
                                         .replace('{information}',data.list[0].information);
    slidingItem.style.left = -1 * width + 'px';

    //movingData len 설정
    movingData.len = len;
    movingData.width = width;

    //item div의 이미지, 리스트 크기 조정하기
    var slidingListImg = slidingItem.querySelectorAll('li img');
    slidingListImg.forEach((v,i)=>{
        v.style.width = width+ 'px';
        v.style.height = height+ 'px';
    });
    var slidingList = slidingItem.querySelectorAll('li');
    slidingList.forEach((v,i)=>{
        v.style.width = width + 'px';
        v.style.height = height + 'px';
    });
    //item div의 title, info 조정하기
    slidingItem.querySelectorAll('li a:nth-child(2)').forEach((v,i)=>{
        v.style.fontSize = '25px';
        v.style.top = (height - 50) / 2 + 'px';
        v.style.left = '30px';
    });
    slidingItem.querySelectorAll('li a:nth-child(3)').forEach((v,i)=>{
        v.style.fontSize = '15px';
        v.style.top = (height - 50) / 2 + 50 +  'px';
        v.style.left = '30px';
    });
    setTimeout(timeoutOperation,2000);
}

document.querySelector('section.sliding-wrap').addEventListener('click', (e) => {
    console.log(e.target);
    //이미지 자체, 왼쪽화살, 오른쪽화살, 네모버튼, 재생버튼
    if (e.target === document.querySelector('section.sliding-wrap > .sliding-left-arrow > img')) {
        console.log("left btn clicked!");
        console.log('mode : ' + movingData.mode);
        console.log('curPos : ' + movingData.curPos);
        console.log('nextPos : ' + movingData.nextPos);
        //동작 가능하다
        if(movingData.mode === 'true'){
            movingData.nextPos -= 1;
            moveSlider();
        }
    } else if (e.target === document.querySelector('section.sliding-wrap > .sliding-right-arrow > img')) {
        console.log("right btn clicked!");
        if(movingData.mode === 'true'){
            movingData.nextPos += 1;
            moveSlider();
        }
    } else if(e.target.getAttribute('class') === 'sliding-check-play-stop'){
        console.log('play - stop btn clicked!');
        movingData.playMode = (movingData.playMode + 1) % 2;
        if(movingData.playMode === 1){
            e.target.src = './../img/stop-btn.png';
            timeoutOperation();
        }else{
            e.target.src = './../img/play-btn.png';
            clearTimeout(movingData.timefunc);
        }
    }
    for(var i = 0 ; i < data.list.length; i++){
        if(e.target.getAttribute('class') === 'sliding-check-' + i){
            console.log('[' + i + '] btn is clicked!');
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
    console.log('transitioned!');
    var leftValue = e.currentTarget.style.left;
    leftValue = leftValue.toString();
    leftValue = leftValue.substr(0,leftValue.indexOf('p'));
    leftValue = parseInt(leftValue);
    if(movingData.curPos === -1){
        movingData.curPos = movingData.nextPos = movingData.len-1;
        e.currentTarget.style.left = (leftValue + (-1 * movingData.len) * movingData.width) + 'px';
        //e.currentTarget.transform ='initial';
        console.log(e.currentTarget.style.left);
    }else if(movingData.curPos === movingData.len){
        movingData.curPos = movingData.nextPos = 0;
        e.currentTarget.style.left = (leftValue + movingData.len*movingData.width) + 'px';
    }
    movingData.mode = 'true';
});

function moveSlider() {
    //1. 불을 전부 끈다
    let totalMove = movingData.curPos - movingData.nextPos;
    let changedLoc = totalMove * movingData.width;
    
    movingData.mode = 'false';
    movingData.curPos = movingData.nextPos;
    let checkItems = document.querySelectorAll('.sliding-check-box ul li img');
    checkItems.forEach((v,i) =>{
        if(v.getAttribute('class') !== 'sliding-check-play-stop'){
            v.src = './../img/check-off.png';
        }
    });
    let tmpCur = movingData.curPos;
    tmpCur = (movingData.len + movingData.curPos) % movingData.len;
    checkItems[tmpCur].src = './../img/check-on.png';
    //2. 이동시킨다
    var sliding = document.querySelector('.sliding-item');
    movingData.transLoc += changedLoc;
    sliding.style.transform = 'translate(' + movingData.transLoc + 'px, '+ 0+'px)';
};

function timeoutOperation(){
    if(movingData.mode === 'true'){
        movingData.nextPos += 1;
        moveSlider();
        movingData.timefunc = window.setTimeout(timeoutOperation,2000);
    }
};

window.addEventListener('DOMContentLoaded', makeSlidingMainTemplate(400, 400, data));