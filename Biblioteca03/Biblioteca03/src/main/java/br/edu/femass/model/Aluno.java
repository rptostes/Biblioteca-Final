package br.edu.femass.model;

public class Aluno extends Leitor{

    private String matricula;

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone, String matricula) {
        super(nome, endereco, telefone);
        setPrazoMaximoDevolucao(15);
        setProximoCodigo(this.getCodigo() + 1);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
