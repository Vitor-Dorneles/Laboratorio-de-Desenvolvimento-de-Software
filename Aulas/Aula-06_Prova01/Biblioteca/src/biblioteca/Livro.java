/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author laboratorio
 */
public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String tipo;
    private String categoria;
    private String situacao;

    public Livro(String titulo, String autor, int anoPublicacao,
            String tipo, String categoria, String situacao) {

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.tipo = tipo;
        this.categoria = categoria;
        this.situacao = situacao;
    }
    
    public Object[] obterDados() {
        return new Object[] { getTitulo(), getAutor(), getAnoPublicacao(),getTipo(), getCategoria(), getSituacao() };
    }

    @Override
    public String toString() {
        return titulo + ";" + autor + ";" + anoPublicacao + ";" + tipo + ";" + categoria + ";" + situacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}