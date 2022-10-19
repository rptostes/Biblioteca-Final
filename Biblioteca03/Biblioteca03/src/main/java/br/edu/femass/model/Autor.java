package br.edu.femass.model;

public class Autor {

    private String nome;
    private String sobrenome;
    private String nacionalidade;

    //O JSon precisa de um construtor vazio
    public Autor(){

    }

    public Autor(String nome, String sobrenome, String nacionalidade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
    }

    public static void imprimeAutor(Autor autor){
        System.out.println("Nome: " + autor.nome);
        System.out.println("Sobrenome: " + autor.sobrenome);
        System.out.println("Nacionalidade: " + autor.nacionalidade);
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
