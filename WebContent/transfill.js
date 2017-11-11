$('document').ready(function(){
	
	$.getJSON('FatchFaculty',{ajax:true},
			function(data){
		    $('#fid').empty();
		    $('#fid').append($('<option>').text('-Select-'));
		    $.each(data,function(i,item){
		    
		  $('#fid').append($('<option>').text(item.FACULTYNAME).attr('value',item.FACULTYID));	
		    	alert(item.FACULTYID);
		    	
		    	
		    });
		});
});	
$('document').ready(function(){
	
	$.getJSON('FetchBranch',{ajax:true},
			function(data){
		    $('#sb').empty();
		    $('#sb').append($('<option>').text('-Select-'));
		    $('#ss').append($('<option>').text('-Select-'));
		    $('#sub').append($('<option>').text('-Select-'));
		    $.each(data,function(i,item){
		    
		  $('#sb').append($('<option>').text(item.BRANCHNAME).attr('value',item.BRANCHID));	
		    	
		    	
		    });
		});
	

	$('#sb').change(function(){
		
		
		$.getJSON('FetchSemester',{branid:$('#sb').val(),ajax:true},
				function(data){
			    $('#ss').empty();
			    $('#ss').append($('<option>').text('-Select-'));
			    $.each(data,function(i,item){
			    
			  $('#ss').append($('<option>').text(item.SEMESTERNAME).attr('value',item.SEMESTERID));	
			    	
			    	
			    });
			});
		
	$('#ss').change(function(){
		 //alert('1');
		$.getJSON('FetchSubject',{semid:$('#ss').val(),ajax:true},
				
		function(data){
		  $('#sub').empty();
		  $('#sub').append($('<option>').text('-Select-'));
		  $.each(data,function(i,item){
			  $('#sub').append($('<option>').text(item.SUBJECTNAME).attr('value',item.SUBJECTID));
			  
		  });
			
		});
		
		
		
	});	
		
		
	});
	
	
	
	
	
	
});