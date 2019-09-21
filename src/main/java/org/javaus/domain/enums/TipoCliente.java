package org.javaus.domain.enums;

public enum TipoCliente {
	
	// lista de enum
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	// Retorna Enum TipoCliente cujo codigo for passado como parametro 
	public static TipoCliente toEnum(Integer cod){
		if (cod == null){
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()){
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	

}
