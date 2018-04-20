	var i=0;						//记录
	var rowNumber=0;				//一共多少item
	var totalAccount = 0;			//合计--给总金额赋值
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
		$(".submit001").click(function(){
			
			if($("#rowNumber").val()<1){  
				$('#myModal2').modal(
					
				);
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
		var account=$("#itemMoney").val();		//金额
		var des=$("#itemDoc").val();		//说明
		if(account==""&&des==""){
				sbblur();
				itemDocBlur();
			return;
		}else{
			//新增:
			var tr=$("#myTable tr").eq(1).clone();						//复制第1个
			++i;
			var j=i-1;													//记录第几个
			totalAccount=parseFloat(totalAccount)+parseFloat(account);	//合计
			tr.find("td").get(1).innerHTML="<input name= bizCvDetailly["+j+"].item  id=item"+j+" type=hidden value="+item+" >"+item;		//项目名称
			tr.find("td").get(2).innerHTML="<input name= bizCvDetailly["+j+"].acount  id=account"+j+" type=hidden value="+account+">"+account; //费用       
			tr.find("td").get(3).innerHTML="<input name= bizCvDetailly["+j+"].des  id=desc"+j+" type=hidden value="+ des +">"+des;	//费用说明	
			tr.find("td").get(4).innerHTML="<a  name=DelRow"+j+"   id=DelRow"+j+"  onclick=delRow("+j+") title=删除 >" +
					"<span class='glyphicon glyphicon-trash'></span> </a>";
			tr.attr("class","a");				//显示
			tr.appendTo("#myTable");			//追加
			rowNumber=i;
			$("#itemMoney").val("");		//金额
			$("#itemDoc").val("");			//说明
			$("#totalAccount").attr("value",totalAccount);		//给总金额赋值
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
	//当前时间
	function p(s) {
		    return s < 10 ? '0' + s: s;
	}
		var myDate = new Date();
		//获取当前年
		var year=myDate.getFullYear();
		//获取当前月
		var month=myDate.getMonth()+1;
		//获取当前日
		var date=myDate.getDate(); 
		var h=myDate.getHours();       //获取当前小时数(0-23)
		var m=myDate.getMinutes();     //获取当前分钟数(0-59)
		var s=myDate.getSeconds();  
		
		var now=year+'-'+p(month)+"-"+p(date);
					
		$("#shijian").val(now);
			
});

function delRow(id){	
	var account = $("#account"+id).val();		//获取删除的金额
	$("#myTable tr").eq(id+2).remove();			//删除    按下标
		for(var s=id+1;s<rowNumber;s++){		//删除这一个 吧下一个的 的id 减一
			//名称
			$("#item"+s).attr("name","bizCvDetailly["+(s-1)+"].item");				//名字减一
			$("#item"+s).attr("id","item"+(s-1));									//id -1
			//费用
			$("#account"+s).attr("name","bizCvDetailly["+(s-1)+"].acount");		
			$("#account"+s).attr("id","account"+(s-1));
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

	totalAccount=parseFloat(totalAccount)-parseFloat(account);	//减金额
	$("#totalAccount").attr("value",totalAccount);				//赋值

}