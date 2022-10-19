package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {

    private Long codigo;
    private static Long proximoCodigo = 1L;
    private LocalDate dataAquisicao;
    private Livro livro;

    public Exemplar(){

    }

    public Exemplar(Livro livro){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = LocalDate.now();
        this.livro = livro;
    }

    public Long getCodigo() {
        return codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }


}
