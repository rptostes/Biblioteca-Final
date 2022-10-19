package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private Long codigo;

    private static Long proximoCodigo = 1L;
    private String titulo;

    private Autor autor;

    private List<Autor> listaAutores = new ArrayList<>();
    private List<Exemplar> listaExemplares = new ArrayList<>();

    public Livro(){
    }

    public Livro(String titulo, List<Autor> autores){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        listaAutores.addAll(autores);
    }

    public static void imprimeLivro(Livro livro){
        System.out.println("Codigo do livro: " + livro.codigo);
        System.out.println("Titulo: " + livro.titulo);
        System.out.println("Informacoes do autor: ");
        Autor.imprimeAutor(livro.autor);
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
