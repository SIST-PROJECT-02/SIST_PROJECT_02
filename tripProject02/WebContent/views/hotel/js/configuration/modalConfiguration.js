var modalData = {
    operation : 'false',
    operating : 'false',
    modalNavMenu : 0,
    modalId : 0,
    modalLike : 0,
    modalIsReview : 'false'
};
var modalLocalData = {};
// modal background layout
window.addEventListener('DOMContentLoaded',(e)=>{
    var modalBack = document.querySelector('.modal-background');
    modalBack.style.width = document.body.clientWidth + 'px';
    modalBack.style.height = '2000px';
    var modal = document.querySelector('.modal-wrap');
});

var layoutDataForModalList = {
	    width : 500,
	    rowCount : 1,
	    elementHeight : 200,
	    startPoint : 0,
	    getCount : 6,
	    mainClassName : 'modal-list',
		navClassName : 'modal-nav'
};