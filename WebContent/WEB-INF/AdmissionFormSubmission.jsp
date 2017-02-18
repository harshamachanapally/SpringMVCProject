<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.Iterator" import="org.springmvc.controller.Skill"
    	import="org.springmvc.controller.Student" import="org.springmvc.controller.Address"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>Submitted Successfully</title>
</head>
<body>
	<h1>${headermessage}</h1>
	
	<h3>${message}</h3>
	
	<table>
		<tr>
			<td>Student Name: </td>
			<td>${student.getstudentName()}</td>
		</tr>
		<tr>
			<td>Student Hobby: </td>
			<td>${student.getHobby()}</td>
			
		</tr>
		<tr>
			<td>Date of Birth: </td>
			<td>${student.getDate()}</td>
		</tr>
		<tr>
			<td>Skills: </td>
		</tr>
		<tr>
		<c:forEach var="skill" items="${student.getStudentSkill()}">
    	<option><c:out value="${skill.getSkill()}"/></option>
		</c:forEach>
		</tr>
		
		 <tr>
			<td>Address: </td>
			<br>
			<td>${student.studentAddress.getStreet()}
				${student.studentAddress.getCity()}
			    ${student.studentAddress.getCountry()}
			    ${student.studentAddress.getPincode()}</td>
		</tr>
	</table>

</body>
</html>