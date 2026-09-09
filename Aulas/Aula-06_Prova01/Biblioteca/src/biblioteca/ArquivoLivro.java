package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArquivoLivro {
    private FileWriter arqEscrita;
    private BufferedWriter escritor;

    private FileReader arqLeitor;
    private BufferedReader leitor;

    private List<Livro> listaLivros;

    public String nomeArquivo;

    public ArquivoLivro(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaLivros = new ArrayList<>();
    }

    public List<Livro> leArquivo() {
        listaLivros.clear();

        try {
            arqLeitor = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqLeitor);

            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(";");

                String titulo = campos[0];
                String autor = campos[1];
                int anoPublicacao = Integer.parseInt(campos[2]);
                String tipo = campos[3];
                String categoria = campos[4];
                String situacao = campos[5];

                Livro livroArq = new Livro(titulo, autor, anoPublicacao, tipo, categoria, situacao);

                listaLivros.add(livroArq);
            }
            leitor.close();
            arqLeitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não existe");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaLivros;
    }
    
    public void gravaArquivo() {
        try {
            arqEscrita = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqEscrita);

            for (Livro livro : listaLivros) {

                escritor.write(
                         livro.getTitulo()+ ";" +
                                livro.getAutor() + ";" +
                                livro.getAnoPublicacao() + ";" +
                                livro.getTipo() + ";" +
                                livro.getCategoria() + ";" +
                                livro.getSituacao()
                        );
                escritor.newLine();

            }
            escritor.close();
            arqEscrita.close();

            System.out.println("Lista salva no arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }
}
