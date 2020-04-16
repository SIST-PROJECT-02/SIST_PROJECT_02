document.querySelector('.search-wrap').addEventListener('mouseover',(e)=>{
    var searchBack = document.querySelector('.search-wrap .search-data-wrap');
    searchBack.style.opacity = 0.9;
});
document.querySelector('.search-wrap').addEventListener('mouseout',(e)=>{
    var searchBack = document.querySelector('.search-wrap .search-data-wrap');
    searchBack.style.opacity = 0.2;
})
document.querySelector('.search-wrap .search-data-wrap .text-search input').addEventListener('keyup',(e)=>{
	var wrap = document.querySelector('.search-wrap');
    var searchData = wrap.querySelector('.text-search input');
    var sortData = wrap.querySelector('#sort-search-wrap');
    if(layoutDataForMainList.sortCondition === parseInt(sortData.value)){
    	if(layoutDataForMainList.search === searchData.value){
    		return;
    	}
    }
    initList();
    layoutDataForMainList.sortCondition = parseInt(sortData.value);
    layoutDataForMainList.search = searchData.value;
    updateListAjax();
});
document.querySelector('.search-wrap .search-data-wrap .sort-search select').addEventListener('change',(e)=>{
	console.log('hello change!');
	var wrap = document.querySelector('.search-wrap');
    var searchData = wrap.querySelector('.text-search input');
    var sortData = wrap.querySelector('#sort-search-wrap');
    if(layoutDataForMainList.sortCondition === parseInt(sortData.value)){
    	if(layoutDataForMainList.search === searchData.value){
    		return;
    	}
    }
    initList();
    layoutDataForMainList.sortCondition = parseInt(sortData.value);
    layoutDataForMainList.search = searchData.value;
    updateListAjax();
});
document.querySelector('.search-wrap .submit-search').addEventListener('click',(e)=>{
    
    var wrap = document.querySelector('.search-wrap');
    var searchData = wrap.querySelector('.text-search input');
    var sortData = wrap.querySelector('#sort-search-wrap');
    if(layoutDataForMainList.sortCondition === parseInt(sortData.value)){
    	if(layoutDataForMainList.search === searchData.value){
    		return;
    	}
    }
    initList();
    layoutDataForMainList.sortCondition = parseInt(sortData.value);
    layoutDataForMainList.search = searchData.value;
    updateListAjax();
});