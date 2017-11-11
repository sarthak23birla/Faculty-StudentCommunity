$(function(){
	$("#ans").on("click",".askmodal",function(){
	var student=$(this).attr("studentid");
	var qid=$(this).attr("qid");
	var qus=$(this).attr("qus");
	console.log(qus);
	$(".fname").text(qus);
	$("#qid").val(qid);
		$("#studentid").val(student);
		
		$("#ansview").modal();
	});
	$(".saveq").click(function(){
		
		$.post("AnswerSubmit",{qid:$("#qid").val(),studentid:$("#studentid").val(),ans:$("#answer").val(),st:$("#st").val(),ajax:true},function(data){
			$("#result").html(data);
		});
		
	});
	
});