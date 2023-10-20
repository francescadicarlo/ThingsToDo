<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">
 	<!DOCTYPE html>
        <title>Hospital</title>
        <meta charset="ISO-8859-1">
    </head>
    <body>
<%@ include file="../../../../css/header.jsp" %>

    <%MedicalExaminationDTO m = (MedicalExaminationDTO) request.getAttribute("dto");%>

    <h1>
        <%=m.getMedicalExamination()%>
    </h1>

    <h2>Descrizione</h2>
    <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
<%@ include file="../../../../css/footer.jsp" %>
    <>
    </body>
    </html>
