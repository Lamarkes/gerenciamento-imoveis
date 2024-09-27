package br.edu.catolica.Enum;

public enum TipoDeImovel {

    CASA("casa"),
    APARTAMENTO("apartamento");

    private final String valor;

    TipoDeImovel(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }
}
