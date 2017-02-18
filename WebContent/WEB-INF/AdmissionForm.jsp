<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 --%>
 <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdmissionForm</title>
</head>
<body>
	<h1>${headermessage}</h1>
	<h3>Student Engineering Form</h3>
	
	<form:errors path="student.*"/>
	
	<form action="/SpringMVCProject/AdmissionFormSubmission.html" method = "post" >
		<table>
		<tr>
			<td>Student Name  :</td> <td> <input type = "text" name="studentName" /> </td>
		</tr>
		<tr>
			<td>Student Hobby : </td> <td> <input type = "text" name="Hobby" /> </td>
		</tr>
		<tr>
			<td>Student BOD	  : </td> <td> <input type = "text" name="date" /> </td>
		</tr>
		<tr>
			<td>Student Skills: </td> 
			<td><select name = "studentSkill" multiple>
										 <option value="JavaCore">JavaCore</option>
									     <option value="SpringCore">SpringCore</option>
										 <option value="SpringMVC">SpringMVC</option>
										 </select>	</td>
		</tr>
		</table>
		 <tabel>
			<tr><td>Student's Address</td></tr>
			<br>
			<tr>
				<td>Street 	: <input type="text" name="studentAddress.street"/></td>
				<td>City 	: <input type="text" name="studentAddress.city"/></td>
				<td>Country : <input type="text" name="studentAddress.country"/></td>
				<td>Pincode : <input type="text" name="studentAddress.pincode"/></td>
			</tr>
			<br>
			 <tr><td><input type = "submit" value = "submit this form by clicking here"/></td></tr>
		</tabel>
 	</form>
	
</body>
</html>