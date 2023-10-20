 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1" import="java.util.List"
 	import="it.contrader.dto.MedicalExaminationDTO"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <link href="../css/vittoriostyle.css" rel="stylesheet">
    <title>User Manager</title>
    </head>
    <body>


  <div class="main">
  <%MedicalExaminationDTO u = (MedicalExaminationDTO) request.getAttribute("dto");%>

     <h1>Medical Examination Details</h1>

      <%MedicalExaminationDTO u = (MedicalExaminationDTO) request.getAttribute("dto");%>



<table>
	<tr>
		<th>Typology</th>
		<th>Cost</th>
		<th>Code</th>
		<th>img</th>
	</tr>
	<tr>
		<td><%=u.getTypology()%></td>
		<td> <%=u.getCost()%></td>
		<td> <%=u.getCode()%></td>
		<td> <%=u.getImg()%></td>

	</tr>
</table>

</div>

    </body>
