$(function(){
	
	$(".submit002").click(function(){
		var but=$(this).attr("nd");
		if(but=="1"){
			
			$("#cvresult").attr("value","通过");
		}
		if(but=="2"){
			$("#cvresult").attr("value","拒绝");
		}
		if(but=="3"){
			$("#cvresult").attr("value","打回");
		}
		$("#resultFrom").submit();
	});
	
	
	
});