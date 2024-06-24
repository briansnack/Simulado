package br.edu.up.model;
 
public class Pessoa {
    protected String id;
    protected String nome;
    protected String rua;
    protected String cidade;
    
    public Pessoa(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setEndereco(String rua, String cidade){
        this.rua = rua;
        this.cidade = cidade;
    }

    public String toCSV(){
        return id + ";" + nome + ";" + rua + ";" + cidade + ";";
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

}
