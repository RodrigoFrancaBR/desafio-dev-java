package br.com.franca.domain;

public enum Genre {

	MASCULINE("Masculino"), FEMININE("Feminino");

	private String value;

	Genre(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
