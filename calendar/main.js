var CDate = new Date(); //현재 달력 위한 날짜 객체
var today = new Date(); //금일을 위한 날짜 객체
var selectCk = 0; //기간설정 스위치 변수
var selectFrom = 0; //기간설정 임시저장 변수

buildCalendar();

function buildCalendar(){
	// console.log("buildCalendar() called");
	document.getElementById("year").innerHTML = CDate.getFullYear() + "년";
	document.getElementById("month").innerHTML = (CDate.getMonth() + 1) + "월";

	var prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0); //전월 마지막날
	var thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1); //금월 첫날
	var thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0); //금월 마지막날
	
	const dates = []; //달력에 뿌려줄 날짜 담을 배열 준비
	if(thisFirst.getDay()!=0){ //금월 첫날이 일요일이 아니라면
		for(var i = 0; i < thisFirst.getDay(); i++){
			dates.unshift(prevLast.getDate()-i);
		} //첫날 요일 이전 요일의 전월 날짜(숫자i)들을 배열의 앞부터 추가
	}
	for(var i = 1; i <= thisLast.getDate(); i++){
		dates.push(i);
	} //마지막날 요일까지 날짜(숫자i)들을 배열에 차례대로 추가
	for(var i = 1; i <= 13 - thisLast.getDay(); i++){
		dates.push(i);
	} //마지막날 이후 다음 일요일까지의 익월 날짜(숫자i)들을 배열에 차례대로 추가
	// console.log("thisLast.getDay() : ", thisLast.getDay());
	// dates.forEach((item)=>{ console.log(item) });

	var htmlDates = ''; //달력 뿌려줄 html 담을 문자열 준비
	for(var i = 0; i<42; i++){ // 42: 7일*6줄
		if(i < thisFirst.getDay()){ //전월 구간
			htmlDates += '<div class="date last">'+dates[i]+'</div>';
		}else if(today.getDate()==dates[i] && today.getMonth()==CDate.getMonth() 
				&& today.getFullYear()==CDate.getFullYear()){
			//오늘=해당 칸 && 오늘=금월 && 오늘=금년 일 때 (즉 오늘)
			htmlDates += '<div id="date_'+dates[i]+'" class="date today" onclick="fn_selectDate('
					+dates[i]+');">'+dates[i]+'</div>';
		}else if(i >= thisFirst.getDay() + thisLast.getDate()){
			//첫날 요일 + 마지막날 요일 합 보다 큰 칸 (즉 익월 구간)
			htmlDates += '<div class="date next">'+dates[i]+'</div>';
		}else{ //나머지 (즉 오늘 이외 금월 구간)
			htmlDates += '<div id="date_'+dates[i]+'" class="date" onclick="fn_selectDate('
					+dates[i]+');">'+dates[i]+'</div>';
		}
	}
	document.getElementById("dates").innerHTML = htmlDates;	//동적으로 얻어진 달력 html 꽂아주기
	// console.log("htmlDates : ",htmlDates); // htmlDates 뭐가 들었나 확인 -> test.txt
}

function prevCal(){ //[<] 클릭시 : 전월 달력 띄우기
	CDate.setMonth(CDate.getMonth()-1);
	buildCalendar();
}

function nextCal(){ //[>] 클릭시 : 익월 달력 띄우기
	CDate.setMonth(CDate.getMonth()+1);
	buildCalendar();
}

function fn_selectDate(date){ //금월 구간 클릭시 : 기간 설정 
	var year = CDate.getFullYear();
	var month = CDate.getMonth() + 1;
	var date_txt = "";
	if(CDate.getMonth + 1 < 10){ //1~9월
		month = "0" + (CDate.getMonth() + 1);
	}
	if(date < 10){ //1~9일
		date_txt = "0" + date;
	}else{ 
		date_txt = date;
	}
	var txt = { //선택한 날짜 정보를 한번에 전달하기 위한 Json객체( { 키:값,키:값... } 형태)
		'year':year, 'month':month, 'date_txt':date_txt } 
	switch(selectCk){
		case 0 :
			fn_selectDate_from(date, txt); //기간 첫날 선택 (기존 코드 따로 뺌)
			break;
		case 1 :
			fn_selectDate_to(date, txt); //기간 끝날 선택 (기존 코드 따로 뺌)
			break;
		case 2 :
			fn_selectDate_clear(); //이전 기간 설정 clear
			fn_selectDate_from(date, txt); //다시 기간 첫날 선택
			break;
	}
}
function fn_selectDate_from(date, txt){ //기간 첫날 선택
	// $(".date").CSS("background-color", "red");
	// $(".date").CSS("color", "");
	// $("#date_" +date).CSS("background-color", "red");
	// $("#date_"+date).CSS("color","white");
	// $("#period_1").val(year+"-"+month+"-"+date);
	// $("#period_2").val("");
	/* ---위 jQuery 코드 아래에 풀어씀.-------------- */
	// /* -------이만큼은 없어야 의도에 맞게 작동됨. ------ */
	// let elements = document.getElementsByClassName("date");
	// let len = elements.length;
	// for (let i = 0; i < len; i++){
	// 	elements.item(i).style.backgroundColor="red";
	// 	elements.item(i).style.color="";
	// }
	// /* -------이만큼은 없어야 의도에 맞게 작동됨.끝 ------ */
	document.getElementById("date_"+date).style.backgroundColor = "red";
	document.getElementById("date_"+date).style.color = "white";
	document.getElementById("period_1").value = txt.year+"-"+txt.month+"-"+txt.date_txt;
	document.getElementById("period_2").value = "";
	// ---위 jQuery 코드 아래에 풀어씀.끝.-------------	
	selectCk = 1;
	selectFrom = date;
}
function fn_selectDate_to(date, txt){ //기간 끝날 선택
	// $("date_"+date).CSS("background-color", "red");
	// $("date_"+date).CSS("color","white");
	// for(var i = selectCk + 1 ; i < date ; i++){
	// 	$("#date_"+i).CSS("background-color","#FFDDDD");
	// }
	// $("#period_2").val(year+"-"+month+"-"+date);
	// ---위 jQuery 코드 아래에 풀어씀.--------------
	document.getElementById("date_"+date).style.backgroundColor = "red";
	document.getElementById("date_"+date).style.color = "white";
	let elements = document.getElementsByClassName("date_"+date);
	let len = elements.length;
	for (let i = 0; i < len; i++){
		elements.item(i).style.backgroundColor="red";
		elements.item(i).style.color="white";
	}
	for(var i=selectFrom+1 ; i < date ; i++){
		document.getElementById("date_"+i).style.backgroundColor = "#FFDDDD";
	}
	document.getElementById("period_2").value = txt.year+"-"+txt.month+"-"+txt.date_txt;
	// ---위 jQuery 코드 아래에 풀어씀.끝.-------------
	selectCk = 2;
}
function fn_selectDate_clear(){ //기간 설정 clear
	let elements = document.getElementsByClassName("date");
	let len = elements.length;
	for (let i = 0; i < len; i++){
		elements.item(i).style.backgroundColor="";
		elements.item(i).style.color="";
	}
	selectCk = 0;
}
