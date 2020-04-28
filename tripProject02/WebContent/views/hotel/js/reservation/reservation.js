'use strict'

var modeTabUI = function(mode){
	
	var targetWrap = document.querySelector('.reservation-wrap .reservation-tab-UI');
	var target = targetWrap.querySelector('li');
	switch(mode){
	case 0:
        targetWrap.className='reservation-tab-UI tab-UI-0';
        console.log('mode = 0');
        break;
    case 1:
        targetWrap.className='reservation-tab-UI tab-UI-1';
        break;
    case 2:
        targetWrap.className='reservation-tab-UI tab-UI-2';
        break;
	}
}

window.addEventListener('DOMContentLoaded', (e)=>{
	console.log('reservation loaded!');
    modeTabUI(0);
    getCalendarAjax(-1,-1);
    var targetWrap = document.querySelector('.reservation-wrap .reservation-tab-UI');
	
    targetWrap.addEventListener('click',(e)=>{
    	if(e.target.getAttribute('name') === '0'){
    		modeTabUI(0);
    	}else if(e.target.getAttribute('name') === '1'){
    		modeTabUI(1);
    	}else if(e.target.getAttribute('name') === '2'){
    		modeTabUI(2);
    	}
    });
    
})

var getCalendarAjax = (year, month)=>{
	var sendData = "";
	sendData += "year=" + year;
	sendData += "&month=" + month;
	ajaxFunc('reservationCalendar.do', sendData, outputCalendar);
}
var outputCalendar = (data) =>{
	console.log('totalDay : ' + data.totalDay);
	console.log('week : ' + data.week);
	
	//캘린더를 만든다. data를 이용해서...
	var target = document.querySelector('section.reservation-wrap .reservation-input');
	var resultHTML = document.querySelector('#reservation-calender').innerHTML;
	var calendarContent = '';
	var day = 1;
	for(var i = 0; i < 5; i++){
		calendarContent += '<tr>';
		for(var j = 0; j < 7; j++){
			
			if(i === 0 && j < data.week){
				calendarContent += '<td> </td>';
			}else if(day > data.totalDay){
				calendarContent += '<td> </td>';
			}else{
				calendarContent += '<td>'+(day++)+'</td>'
			}
		}
		calendarContent += '</tr>';
	}
	console.log('calendarContent : ' + calendarContent);
	target.innerHTML = resultHTML.replace('{calendarContent}',calendarContent);
	var calendar = document.querySelector('.reservation-wrap .reservation-input .year');
    var calendarM = document.querySelector('.reservation-wrap .reservation-input .month');
    calendar.addEventListener('change', (e)=>{
    	var year = e.target.value;
    	var month = calendarM.value;
    	console.log('year : ' + year + ', month : ' + month);
    	getCalendarAjax(year,month);
    });
    calendarM.addEventListener('change', (e)=>{
    	var year = calendar.value;
    	var month = e.target.value;
    	console.log('year : ' + year + ', month : ' + month);
    	getCalendarAjax(year,month);
    });
}