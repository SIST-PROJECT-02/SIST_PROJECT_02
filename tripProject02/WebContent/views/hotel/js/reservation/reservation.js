'use strict'

var modeTabUI = function(mode){
	
	var targetWrap = document.querySelector('.reservation-wrap .reservation-tab-UI');
	var target = targetWrap.querySelector('li');
	
	switch(mode){
	case 0:
        targetWrap.className='reservation-tab-UI tab-UI-0';
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
	setProduct_id(location.href);
    modeTabUI(0);
    getCalendarAjax(-1,-1);
    
    var targetWrap = document.querySelector('.reservation-wrap .reservation-tab-UI');
    
    targetWrap.addEventListener('click',(e)=>{
    	if(e.target.getAttribute('name') === '0'){
    		getCalendar();
    		var calendar = document.querySelector('.reservation-wrap .reservation-input .year');
    	    var calendarM = document.querySelector('.reservation-wrap .reservation-input .month');
    		modeTabUI(0);
    		reservationData.mode = 0;
    		var year = calendar.value;
        	var month = calendarM.value;
        	getCalendarAjax(-1,-1);
    	}else if(e.target.getAttribute('name') === '1'){
    		getCalendar();
    		var calendar = document.querySelector('.reservation-wrap .reservation-input .year');
    	    var calendarM = document.querySelector('.reservation-wrap .reservation-input .month');
    		modeTabUI(1);
    		reservationData.mode = 1;
    		var year = calendar.value;
        	var month = calendarM.value;
        	getCalendarAjax(-1,-1);
    	}else if(e.target.getAttribute('name') === '2'){
    		modeTabUI(2);
    		reservationData.mode = 2;
    		getInwon();
    	}
    });
    var targetInput = document.querySelector('.reservation-wrap .reservation-input');
    targetInput.addEventListener('click',(e)=>{
    	
    	var target = e.currentTarget;
    	
    	if(e.target.className === 'reservation-possible'){
    		//1. check in/out에 값 싣기
    		//2. 다음 UI로 넘어가기
    		//3. reservation-result에 값 싣기
    		//4. 모든 데이터가 다 찼는지 검사하기 - 다 찼으면 예매 버튼 활성화
    		switch(reservationData.mode){
    		case 0:
    			reservationData.checkIn = target.querySelector('.year').value + '/' +
    									  target.querySelector('.month').value + '/' +
    									  e.target.innerHTML;
    			var a = reservationData.checkIn;
    			var b = reservationData.checkOut;
    			if(a > b){
    				reservationData.checkOut = reservationData.checkIn;
    			}
    			setReservationOutput();
    			reservationData.mode = 1;
    			modeTabUI(reservationData.mode);
    			checkAllData();
    			break;
    		case 1:
    			reservationData.checkOut = target.querySelector('.year').value + '/' +
										  target.querySelector('.month').value + '/' +
										  e.target.innerHTML;
    			if(reservationData.checkOut == '2020/4/29'){
    			}
    			setReservationOutput();
    			reservationData.mode = 2;
    			modeTabUI(reservationData.mode);
    			getInwon();
    			checkAllData();
    			break;
    		default:break;
    		}
    	}
    	
    })
    
    document.querySelector('.reservation-wrap .reservation-final-btn').addEventListener('click',(e)=>{
    	reservationAjax();
    })
})

var getCalendarAjax = (year, month)=>{
	var sendData = "";
	sendData += "year=" + year;
	sendData += "&month=" + month;
	sendData += "&product_id=" + reservationData.product_id;
	ajaxFunc('reservationCalendar.do', sendData, outputCalendar);
}
var outputCalendar = (data) =>{
	//캘린더를 만든다. data를 이용해서... totalDay, week, month
	var target = document.querySelector('section.reservation-wrap .reservation-input');
	var resultHTML = document.querySelector('#reservation-calender').innerHTML;
	var calendarContent = '';
	var day = 1;
	for(var i = 0; i < 6; i++){
		calendarContent += '<tr>';
		for(var j = 0; j < 7; j++){
			
			if(i === 0 && j < data.week){
				calendarContent += '<td> </td>';
			}else if(day > data.totalDay){
				calendarContent += '<td> </td>';
			}else{
				var bCheck = 'false';
				
				for(var ii = 0; ii < data.list.length; ii++){
					
					if(day === data.list[ii]){
						calendarContent += '<td class="reservation-possible">'+(day++)+'</td>';
						bCheck = 'true';
						break;
					}
					
				}
				
				if(bCheck === 'false'){
					calendarContent += '<td>'+(day++)+'</td>';
				}
				
			}
		}
		calendarContent += '</tr>';
	}
	target.innerHTML = resultHTML.replace('{calendarContent}',calendarContent);
	var calendar = document.querySelector('.reservation-wrap .reservation-input .year');
    var calendarM = document.querySelector('.reservation-wrap .reservation-input .month');
    
    calendar.selectedIndex = data.year - 2020;
    calendarM.selectedIndex = data.month.toString();
    
    calendar.addEventListener('change', (e)=>{
    	var year = e.target.value;
    	var month = calendarM.value;
    	getCalendarAjax(year,month);
    });
    calendarM.addEventListener('change', (e)=>{
    	var year = calendar.value;
    	var month = e.target.value;
    	getCalendarAjax(year,month);
    });
    
    
    var resOut = document.querySelector('.reservation-wrap .reservation-output');
    reservationData.title = data.title;
    resOut.querySelector('li:nth-child(1) img').src = data.thumbnail;
    resOut.querySelector('li:nth-child(2)').innerHTML = data.title;
}

var setProduct_id = (location)=>{
	var start = location.indexOf('?')+1;
	var data = location.substring(start);
	reservationData.product_id = parseInt(data.substring((data.indexOf('=')+1)));
}
var setReservationByMode = (data)=>{
}

var setReservationOutput = ()=>{
	
	var target = document.querySelector('.reservation-wrap .reservation-output');
	switch(reservationData.mode){
	case 0:
		target.querySelector('li:nth-child(3)').innerText = '체크인 시간:' + reservationData.checkIn;
		target.querySelector('li:nth-child(4)').innerText = '체크아웃 시간:' + reservationData.checkOut;
		break;
	case 1:
		target.querySelector('li:nth-child(4)').innerText = '체크아웃 시간:' + reservationData.checkOut;
		break;
	case 2:
		target.querySelector('li:nth-child(5)').innerText = '인원:' + reservationData.inwon;
		break;
	}
}

var getInwon = ()=>{
	var target = document.querySelector('.reservation-wrap .reservation-input');
	var template = document.querySelector('#reservation-inwon');
	var outputTarget = document.querySelector('.reservation-wrap .reservation-output');
	target.innerHTML = template.innerHTML;
	target.querySelector('select').addEventListener('change',(e)=>{
		reservationData.inwon = target.querySelector('select').value;
		setReservationOutput();
		checkAllData();
	})
}
var getCalendar = ()=>{
	var target = document.querySelector('.reservation-wrap .reservation-input');
	var template = document.querySelector('#reservation-calender');
	target.innerHTML = template.innerHTML;
}

var checkAllData = ()=>{
	if(reservationData.inwon > 0 &&
	   reservationData.checkIn > '0'&&
	   reservationData.checkOut > '0'){
		document.querySelector('.reservation-wrap .reservation-final-btn').style.display = 'block';
		getPriceAjax();
	}else{
		document.querySelector('.reservation-wrap .reservation-final-btn').style.display = 'none';
	}
}
var getPriceAjax = ()=>{
	var sendData = '';
	sendData += 'product_id=' + reservationData.product_id;
	sendData +='&inwon=' + reservationData.inwon;
	sendData += '&checkIn=' + reservationData.checkIn;
	sendData += '&checkOut=' + reservationData.checkOut;
	
	ajaxFunc('reservationSelected.do',sendData,getReservationResult);
}
var getReservationResult = (data)=>{
	//regdate, price, id
	localReservationData = data;
	var price = 0;
	data.list.forEach((v,i)=>{
		price += parseInt(v.price);
	})
	price = price * reservationData.inwon;
	reservationData.price = price;
	var outputTarget = document.querySelector('.reservation-wrap .reservation-output');
	outputTarget.querySelector('li:nth-child(6)').innerHTML = '가격 : ' + price + '원';
}

var reservationAjax = ()=>{
	var sendData = '';
	sendData += 'checkIn=' + reservationData.checkIn;
	sendData += '&checkOut=' + reservationData.checkOut;
	sendData += '&inwon=' + reservationData.inwon;
	sendData += '&product_id=' + reservationData.product_id;
	sendData += '&price='+reservationData.price;
	ajaxFunc('reservationFinal.do',sendData, endReservation);
}

var endReservation = (data)=>{
	if(data.isSuc === 'true'){
		alert('예약이 완료되었습니다.');
		window.location.href = 'index.jsp';
	}else{
		alert('권한이 없습니다!');
	}
}