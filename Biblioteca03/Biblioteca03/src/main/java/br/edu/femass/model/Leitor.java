package br.edu.femass.model;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.List;

public class Leitor {

    private Long codigo;
    private static Long proximoCodigo = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private int prazoMaximoDevolucao;
    private List<Exemplar> exemplarList;

    public Leitor(){

    }

    public Leitor(String nome, String endereco, String telefone){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

//    public void realizarEmprestimo(Livro livro){
//        Emprestimo emprestimo = new Emprestimo(this);
//    }

    public void realizarDevolucao(Emprestimo emprestimo){
        emprestimo.setDataDevolucao(LocalDate.now());

        System.out.println("Devolucao realizada.");
    }

    public static void setProximoCodigo(Long proximoCodigo) {
        Leitor.proximoCodigo = proximoCodigo;
    }

    //Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(int prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
