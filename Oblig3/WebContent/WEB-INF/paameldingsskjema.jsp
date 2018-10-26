<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value="${skjema.fornavn}" /> <font color="red"
					${skjema.fornavn != "" ? "hidden" : "visible" }>Ugyldig
					fornavn, må starte med stor bokstav og kun inneholde bokstaver</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${ skjema.etternavn }" /> <font
					color="red" ${skjema.etternavn != "" ? "hidden" : "visible" }>Ugyldig
					etternavn, må starte med stor bokstav og kun inneholde bokstaver</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" value="${skjema.mobil}" /> <font color="red"
					${skjema.mobil != "" ? "hidden" : "visible" }>Ugyldig mobil, 8 siffer uten noe mellomrom</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="" /> <font color="red"
					${skjema.passordGyldig != false ? "hidden" : "visible" }>Ugyldig
					passord, minimum 5 tegn</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert" value="" /> <font
					color="red"
					${skjema.passordRepetert != false ? "hidden" : "visible" }>Passordene
					må være like</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${skjema.kjonn == "mann" ? "checked" : "" } />mann
				<input type="radio" name="kjonn" value="kvinne"
					${skjema.kjonn == "kvinne" ? "checked" : "" } />kvinne <font
					color="red" ${skjema.kjonn != "" ? "hidden" : "visible" }>Du
					må oppgi kjonn</font>
			</div>
			<font color="red"
				${skjema.mobilLedig != false || skjema.mobil == "" ? "hidden" : "visible" }>
				Mobilnummeret er allerede registrert </font>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>