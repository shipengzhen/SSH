	
$(function(){	
	
	
	
		//金额 鼠标已开
		function sbblur(){
			var s=$("#itemMoney");
			var reg=/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
			var span=s.next();
			span.html("");
			if(s.val()==""){
				s.val("");
				span.html("不能为空");
			}
			if(reg.test(s.val())==false){
				s.val("");
				span.html("金额错误");
			};
		};
		//项目说明 移开
		function itemDocBlur(){
			var s=$("#itemDoc");
			var span=s.next();
			span.html("");
			if(s.val()==""){
				s.val("");
				span.html("不能为空");	
			}
		};
		//提交
		$(".submit002").click(function(){
			if($("#rowNumber").val()<1){  
				$('#myModal2').modal();
				return;
			}
			var but=$(this);
			var action=but.attr("nd");
			if(action=='1'){
				$("#status").val("新创建");
			}else{
				
				$("#status").val("已提交");
			
			}
			$("form[name='claimForm']").submit();
		});
		//表单提交
		$("form[name='claimForm']").submit(function(){
			return true;
		});
		
		
	
	//模态框保存
	$("#modelAdd").click(function(){
		$(this).attr("data-dismiss","123");	//保存
		
		var item=$("#itemName").val();		//项名称
		var acount=$("#itemMoney").val();		//金额
		var des=$("#itemDoc").val();		//说明
		if(acount==""&&des==""){
				sbblur();
				itemDocBlur();
			return;
		}else{
			//新增:
			var tr=$("#myTable tr").eq(1).clone();						//复制第1个
			++i;
			var j=i-1;													//记录第几个
			totalAccount=parseFloat(totalAccount)+parseFloat(acount);	//合计
			tr.find("td").get(1).innerHTML="<input name= bizCvDetailly["+j+"].item  id=item"+j+" type=hidden value="+item+" >"+item;		//项目名称
			tr.find("td").get(2).innerHTML="<input name= bizCvDetailly["+j+"].acount  id=acount"+j+" type=hidden value="+acount+">"+acount; //费用       
			tr.find("td").get(3).innerHTML="<input name= bizCvDetailly["+j+"].des  id=desc"+j+" type=hidden value="+ des +">"+des;	//费用说明	
			tr.find("td").get(4).innerHTML="<a  name='DelRow"+j+"'   id='DelRow"+j+"'  onclick=delRow("+j+")   class='tooltip-test' data-toggle='tooltip'  title='删除' >" +
					"<span class='glyphicon glyphicon-trash'></span></a>";
			tr.attr("class","a");				//显示
			tr.appendTo("#myTable");			//追加
			rowNumber=i;
			$("#itemMoney").val("");		//金额
			$("#itemDoc").val("");			//说明
			$("#totalAccount").attr("value",totalAccount);		//给总金额赋值
			$("#totalAccount2").html(totalAccount);				//赋值
			
			// -----
			$("#rowNumber").attr("value",rowNumber);			//给个数添加
			$(this).attr("data-dismiss","modal");	//保存
		}
		
	});
	
	//模态框关闭 --清空
	$("#modelclose").click(function(){
		$("#itemMoney").val("");
		$("#itemDoc").val("");
		$("#span1").text("");
		$("#span2").text("");
		
	});
	//金额 鼠标已开
	$("#itemMoney").blur(sbblur);
	//项目说明 鼠标已开
	$("#itemDoc").blur(itemDocBlur);
	
	$(".ll").click(function(){
		var cdid=$(this).attr("ng");
		$.ajax({
			type:"GET",
			url:"delCd.action",
			data:"cdId="+cdid,
			dataType:"json",
			success:function(data){
			
			}
		});
		
		
	})

			
});



function delRow(id){	
	//ajax 删除
	var acount = $("#acount"+id).val();		//获取删除的金额
	$("#myTable tr").eq(id+2).remove();			//删除    按下标
		for(var s=id+1;s<rowNumber;s++){		//删除这一个 吧下一个的 的id 减一
			//名称
			$("#item"+s).attr("name","bizCvDetailly["+(s-1)+"].item");				//名字减一
			$("#item"+s).attr("id","item"+(s-1));									//id -1
			//费用
			$("#acount"+s).attr("name","bizCvDetailly["+(s-1)+"].acount");		
			$("#acount"+s).attr("id","acount"+(s-1));
			//费用说明
			$("#desc"+s).attr("name","bizCvDetailly["+(s-1)+"].des");
			$("#desc"+s).attr("id","desc"+(s-1));		
			var js="delRow("+(s-1)+");";
			
			var newclick=eval("(false||function (){"+js+"});");
			$("#DelRow"+s).unbind('click').removeAttr('onclick').click(newclick);
			$("#DelRow"+s).attr("id","DelRow"+(s-1));					
		}
		var number=parseInt($("#rowNumber").val());
	$("#rowNumber").attr("value",number-1);
	--i;
	totalAccount=parseFloat(totalAccount)-parseFloat(acount);	//减金额
	if(isNaN(totalAccount)){
		totalAccount=0;
	}
	
	$("#totalAccount").attr("value",totalAccount);				//赋值

	$("#totalAccount2").html(totalAccount);						//赋值
	
	
	

}

