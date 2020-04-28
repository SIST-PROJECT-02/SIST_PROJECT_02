//1. 받을 데이터들을 정리한다

'use strict'

function setLayout(layoutData){
	var nav = document.querySelector('.' + layoutDataForMainList.navClassName);
    var wrap = document.querySelector('.' + layoutDataForMainList.mainClassName);
    var innerWrap = wrap.querySelector('ul');
    var items = innerWrap.querySelectorAll('li');
    var itemsValue = [];
    itemsValue.push(innerWrap.querySelectorAll('img'));
    itemsValue.push(innerWrap.querySelectorAll('li a:nth-child(3) div:nth-child(1)'));
    itemsValue.push(innerWrap.querySelectorAll('li a:nth-child(3) div:nth-child(2)'));
    nav.style.width = layoutData.width + 'px';
    wrap.style.width = layoutData.width + 'px';
    
        //(x+20) * rowCount + 2 < width
    var elementWidth = parseInt((layoutData.width - 20*layoutData.rowCount-2) / (layoutData.rowCount));
    var imgHeight = parseInt(layoutData.elementHeight * 0.6);
    var titleHeight = parseInt(layoutData.elementHeight * 0.2);
    var itemsData = [imgHeight,0,titleHeight,imgHeight,titleHeight,imgHeight];

    items.forEach((v,i)=>{
        v.style.width = elementWidth + 'px';
        v.style.height = layoutData.elementHeight + 'px';
    });
    itemsValue.forEach((v1,i1)=>{
        v1.forEach((v2,i2)=>{
            v2.style.width = elementWidth + 'px';
            v2.style.height = itemsData[i1*2] + 'px';
            v2.parentNode.style.top = itemsData[i1*2+1] + 'px';
            v2.style.lineHeight = itemsData[i1*2] + 'px';
        });
    });
    
}


