<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<!--  aaffaa fffff cccccc -->
			<th>Kjonn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="d" items="${deltagere}">
			<tr bgcolor=${d.mobil == deltager.mobil ? "#AAFFAA" : "#FFFFFF" }>
				<th>${ d.kjonn == "mann" ? "&#9794" : "&#9792" }</th>
				<th align="left">${d.fornavn} ${d.etternavn}</th>
				<th align="left">
					${fn:substring(d.mobil, 0, 3)} ${fn:substring(d.mobil, 3, 5)} ${fn:substring(d.mobil, 5, 8)} 
				</th>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>