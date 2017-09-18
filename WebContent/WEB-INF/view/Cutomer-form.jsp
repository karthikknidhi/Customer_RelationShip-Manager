<%@ taglib prefix = "form" uri= "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id = "wrapper">
	<div id = "header">
	
	<h2> CRM-Customer Relationship Manager</h2>
	
	
	</div>
</div>

<div id = "container">
	<h3>Save a customer</h3>
	<form:form action = "saveCustomer" modelAttribute = "customer" method = "POST">
	<form:hidden path = "id"/> 
	<table>
	<tbody>
	<tr>
	<td><label>FirstName:</label></td>
	<td><form:input path = "firstName"/></td>
	</tr>
	<tr>
	<td><label>LastName:</label></td>
	<td><form:input path = "lastName"/></td>
	</tr>
	<tr>
	<td> <label>Email:</label></td>
	<td><form:input path = "email"/></td>
	</tr>
	<tr>
	<td> <label></label></td>
	<td><input type = "submit" value = "Save" class = "save"/></td>
	</tr>
	</tbody>
	</table>
	</form:form>
	<div style = "clear;both;"></div>
	<p>
	<a href = "${pageContext.request.contextPath}/customer/list"> Back To list</a>
	</p>
</div>
</body>
</html>