package br.com.evandrolacerda.reader.pojo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Address {

    private String cidade;
    private String cep;
    private String endereco;
    private String bairro;
    private String estado;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    private String complemento;



    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BasicDBObject toDBObject(){
        return new BasicDBObject()
                .append("endereco", this.getEndereco() )
                .append("numero", this.getNumber() )
                .append("complemento", this.getComplemento() )
                .append("bairro", this.getBairro() )
                .append("cidade", this.getCidade() )
                .append("estado", this.getEstado() )
                .append("cep", this.getCep() );
    }
}
