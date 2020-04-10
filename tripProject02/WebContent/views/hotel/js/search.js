document.querySelector('.search-wrap').addEventListener('mouseover',(e)=>{
    var searchBack = document.querySelector('.search-wrap .search-data-wrap');
    searchBack.style.opacity = 0.9;
});
document.querySelector('.search-wrap').addEventListener('mouseout',(e)=>{
    var searchBack = document.querySelector('.search-wrap .search-data-wrap');
    searchBack.style.opacity = 0.2;
})
document.querySelector('.search-wrap .submit-search').addEventListener('click',(e)=>{
    
    var wrap = document.querySelector('.search-wrap');
    var searchData = wrap.querySelector('.text-search input');
    var sortData = wrap.querySelector('#sort-search-wrap');
    if(layoutData.sortCondition === parseInt(sortData.value)){
    	if(layoutData.search === searchData.value){
    		return;
    	}
    }
    initList();
    layoutData.sortCondition = parseInt(sortData.value);
    layoutData.search = searchData.value;
    getListAjax();
});
/*
var layoutData = {
	    width : 1200,
	    rowCount : 3,
	    elementHeight : 400,
	    startPoint : 0,
	    getCount : 6,
	    sortCondition : 1,
	    search : ''
	};
*/