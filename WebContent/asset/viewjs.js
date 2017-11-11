$(function(){
	$(".experts").on("click",".askmodal",function(){
		$("#fid").val($(this).attr("id"));
		$(".fname").text($(this).attr("name"));
		$("#qus").val("");
		$("#question").modal();
	});
	$(".saveq").click(function(){
		
		$.post("QuestionSubmit",{fid:$("#fid").val(),qus:$("#qus").val(),ajax:true},function(data){
			$("#result").html(data);
		});
		
	});
	
});