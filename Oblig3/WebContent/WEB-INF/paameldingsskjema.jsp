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
<script defer src="${pageContext.request.contextPath}/javascript/script.js"></script>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" id="fornavn" onkeyup="updateFornavn();" value="${skjema.fornavn}" /> <font id="fornavnFeil" color="red"
					${skjema.fornavn != "" ? "hidden" : "visible" }>Ugyldig
					fornavn, må starte med stor bokstav og kun inneholde bokstaver</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" id="etternavn" onkeyup="updateEtternavn();" value="${ skjema.etternavn }" /> <font
					color="red" id="etternavnFeil" ${skjema.etternavn != "" ? "hidden" : "visible" }>Ugyldig
					etternavn, må starte med stor bokstav og kun inneholde bokstaver</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" id="mobil" onkeyup="updateMobil();" value="${skjema.mobil}" /> <font color="red" id="mobilFeil"
					${skjema.mobil != "" ? "hidden" : "visible" }>Ugyldig mobil, 8 siffer uten noe mellomrom</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" id="passord" onkeyup="updatePassord();"  value="" /> <font color="red" id="passordFeil"
					${skjema.passordGyldig != false ? "hidden" : "visible" }>Ugyldig
					passord, minimum 5 tegn</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" id="passordRepetert" onkeyup="updatePassordRepetert();" name="passordRepetert" value=""/> <font
					color="red" id="passordRepetertFeil"
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