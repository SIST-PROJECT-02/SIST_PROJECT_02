//생성에만 관여한다

//1. 생성에 필요한 임시 데이터(나중에 ajax로 대체)
'strict mode'

var layoutData = {
    width : 500,
    rowCount : 2,
    elementHeight : 300
};

var data = {
    list: [
        {
            img: "https://api.cdn.visitjeju.net/photomng/imgpath/201804/30/dbfd984b-399a-4c3b-834c-69a3cc1556a3.jpg",
            title: "a번 타이틀 입니다",
            information: "a번 인포메이션 입니다."
        },
        {
            img: "./../img/check-on.png",
            title: "b번 타이틀 입니다",
            information: "b번 인포메이션 입니다."
        },
        {
            img: "./../img/play-btn.png",
            title: "c번 타이틀 입니다",
            information: "c번 인포메이션 입니다."
        }
    ]
};

window.addEventListener('DOMContentLoaded', (e)=>{
    makeList(data);
})

var makeList = (data) =>{
    var wrap = document.querySelector('section');
    var innerWrap = wrap.querySelector('ul');
    var listData = data.list;
    var templateData = document.querySelector('#template-list-items').innerHTML;
    innerWrap.innerHTML = "";
    listData.forEach((v,i)=>{
        innerWrap.innerHTML += templateData.replace('{name}',"myid")
                                           .replace('{img}', v.img)
                                           .replace('{title}',v.title)
                                           .replace('{information}',v.information);
        
    });
    var items = innerWrap.querySelectorAll('li');
    items.forEach((v,i)=>{
        v.addEventListener('mouseover',(e)=>{
            var aItem = v.querySelector('a:nth-child(2)');
            aItem.style.backgroundColor = '#7643ea';
        });
        v.addEventListener('mouseout',(e)=>{
            var aItem = v.querySelector('a:nth-child(2)');
            aItem.style.backgroundColor = '#f4f6f8';
        });
    })
    setLayout(layoutData);
}
