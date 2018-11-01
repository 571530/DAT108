"use strict";

function validFornavn(str) {
	return str.length <= 20 && /^([A-Z\u00C6\u00D8\u00C5][\\-\\sa-zA-Z\u00C6\u00D8\u00C5\u00E6\u00F8\u00E5]+)/.test(str);
}
function validEtternavn(str) {
	 return str.length <= 20 && /^([A-Z\u00C6\u00D8\u00C5][\\sa-zA-Z\u00C6\u00D8\u00C5\u00E6\u00F8\u00E5]+)/.test(str);
}
function validMobil(mob) {
	return /^[0-9]{8}$/.test(mob);
}
function validPassord(pass) {
	return pass.length >= 5;
}

function updateFornavn() {
	let fornavn = document.getElementById("fornavn");
	let fornavnFeil = document.getElementById("fornavnFeil");
	
	fornavnFeil.hidden = validFornavn(fornavn.value);
}
function updateEtternavn() {
	let etternavn = document.getElementById("etternavn");
	let etternavnFeil = document.getElementById("etternavnFeil");
	
	etternavnFeil.hidden = validEtternavn(etternavn.value);
}
function updateMobil() {
	let mobil = document.getElementById("mobil");
	let mobilFeil = document.getElementById("mobilFeil");
	
	mobilFeil.hidden = validMobil(mobil.value);
}
function updatePassord() {
	let passord = document.getElementById("passord");
	let passordFeil = document.getElementById("passordFeil");
	
	passordFeil.hidden = validPassord(passord.value);
}
function updatePassordRepetert() {
	let passord = document.getElementById("passord");
	let passordRepetert = document.getElementById("passordRepetert");
	let passordRepetertFeil = document.getElementById("passordRepetertFeil");
	
	passordRepetertFeil.hidden = passord.value == passordRepetert.value;
}

