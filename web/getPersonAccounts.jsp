<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

id: <input type="text" id="personid"/>
<button id="search">get books</button>
<div id="content"></div>

<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	var input = $("#personid");
	var btn = $("#search");
	var content = $("#content")
	
	btn.click(function(){
		var id = input.val();
		
		$.ajax({
			  url: "rest/people/"+id+"/books",
			  method:'GET',
			  success: function( result ) {
			    content.html('<p>'+result[0].currency+'</p>'+'<p>'+result[0].amount+'</p>')
			  }
			});
	})
	
	
	
</script>

</body>
</html>