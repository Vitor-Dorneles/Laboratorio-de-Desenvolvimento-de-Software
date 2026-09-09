package cadastroaluno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    private FileWriter arqEscrita;
    private BufferedWriter escritor;

    private FileReader arqLeitor;
    private BufferedReader leitor;

    private List<Aluno> listaAlunos;

    public String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaAlunos = new ArrayList<>();
    }

    public List<Aluno> leArquivo() {
        listaAlunos.clear();

        try {
            arqLeitor = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqLeitor);

            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(";");

                int idMatricula = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String dataNasc = campos[2];
                String sexo = campos[3];
                String curso = campos[4];
                String cpf = campos[5];
                String telefone = campos[6];
                String rua = campos[7];
                int numero = Integer.parseInt(campos[8]);
                String bairro = campos[9];
                String cidade = campos[10];
                String cep = campos[11];
                String estado = campos[12];

                Endereco enderecoArq = new Endereco(rua, numero, bairro, cidade, cep, estado);
                Aluno alunoArq = new Aluno(idMatricula, nome, dataNasc, sexo, curso, cpf, enderecoArq, telefone);

                listaAlunos.add(alunoArq);
            }
            leitor.close();
            arqLeitor.close();
        } catch (FileNotFoundException e) {
            //arquivo ainda não existe.
            //começa com a lista vazia
            System.out.println("Arquivo ainda não existe");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAlunos;
    }
    
    public void gravaArquivo() {
        try {
            arqEscrita = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqEscrita);

            for (Aluno aluno : listaAlunos) {

                escritor.write(
                        aluno.getIdMatricula() + ";" +
                                aluno.getNome() + ";" +
                                aluno.getDataNascimento() + ";" +
                                aluno.getSexo() + ";" +
                                aluno.getCurso() + ";" +
                                aluno.getCpf() + ";" +
                                aluno.getTelefone() + ";" +
                                aluno.getEndereco());
                escritor.newLine();

            }
            escritor.close();
            arqEscrita.close();

            System.out.println("Lista salva no arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}
