
function validaPassageiro(){
	if (document.formRegistrar.nomeMT.value == "" || document.formRegistrar.nomeNP.value == "" 
		|| document.formRegistrar.nomeVC.value == "") {
		alert("Por favor preencha o campo .");
		document.formeRegistrar.nomeNt.focus();
		return false;
	}
}



function validaMotorista() {
	
	if (document.formMotorista.nomeMT.value == "" || document.formMotorista.dataNas.value == "" ||
			document.formMotorista.cpf.value == "") {
		alert("Por favor, preencha o campo  .");
		document.formMotorista.nomeNt.focus();
		return false;
	}else if(document.formMotorista.cpf.value != 11){
		alert("Por favor, preencha o campo CPF com 11 Digitos.");
		document.formMotorista.cpf.focus();
		return false;
	}
	
}


function validarPassageiro() {
	if (document.formPassageiro.nomePs.value == "" || documente.formPassageiro.cpfPs.value == "" || 
		document.formPassageiro.dataNascimento.value == "") {
		alert("Por favor, preencha o campo  ")
		document.formPassageiro.nomePs.focus();
	}else if (document.formPassageiro.cpfPs.value < 11) {
		alert("Por favor, preencha o campo CPF com 11 Digitos.");
		document.formMotorista.cpfPs.focus();
		return false;
		
	}
}

