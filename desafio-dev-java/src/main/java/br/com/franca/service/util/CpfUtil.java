package br.com.franca.service.util;

public class CpfUtil {

	public static boolean isValid(String cpf) {
		
		if (cpf.contains("-") || cpf.contains(".")) {
			return false;
		}

		if (cpf.length() != 11) {
			return false;
		}

		try {
			Long cpfNumber = Long.valueOf(cpf);
		} catch (NumberFormatException e) {
			System.out.println("CPF:" + cpf + " não é válido");
			return false;
		}

		return true;
	}

}
