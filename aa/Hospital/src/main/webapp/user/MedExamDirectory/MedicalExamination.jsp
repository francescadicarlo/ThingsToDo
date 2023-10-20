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
       <select name="Tipologie" id="TipologiaSelect">
         <option value="">Tipologia</option>
         <option value="dermatologica">Dermatologica</option>
         <option value="pediatrica">Pediatrica</option>
         <option value="odontoiatrica">Odontoiatrica</option>
         <option value="reumatolgica">Reumatolgica</option>
         <option value="dermatologica">Dermatologica</option>
         <option value="oculistica">Oculistica</option>
       </select>

       <select
        name="Costo" id="CostoSelect">
                <option value="">Costo</option>
                <option value="20">20</option>
                <option value="30+">30+</option>
                <option value="40+">40+</option>
                <option value="50+">50+</option>
                <option value="100+">100+</option>
              </select>
        <select
                name="Orario" id="OrarioSelect">
                        <option value="">Orario</option>
                        <option value="8:00-9:00">8:00-9:00</option>
                        <option value="9:00-10:00">9:00-10:00</option>
                        <option value="10:00-11:00">10:00-11:00</option>
                        <option value="11:00-12:00">11:00-12:00</option>
                        <option value="12:00-13:00">12:00-13:00</option>
                        <option value="13:00-14:00">13:00-14:00</option>
                        <option value="14:00-15:00">14:00-15:00</option>
                        <option value="15:00-16:00">15:00-16:00</option>
                        <option value="16:00-17:00">16:00-17:00</option>
                        <option value="17:00-18:00">17:00-18:00</option>
                        <option value="18:00-19:00">18:00-19:00</option>
                      </select>
        <input type="text" placeholder="Cerca una visita..">

        <a href="MedicalExaminationServlet?mode=READ">Modifica</a>

        <form action="MedicalExaminationServlet?mode=READ">
          <button type="submit">
            Visita dermatologica
          </button>
        </form>

        <%@ include file="../../../../css/footer.jsp" %>

    </body>
    </html>