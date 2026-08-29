/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroaluno;

/**
 *
 * @author vitor
 */
public class Aluno {
    private String nome; // deve ser nome completo
    private String dataNascimento; // terei de fazer um split depois
    private String sexo;
    private  int idMatricula; // provavelmente temos que gerar, num único
    private String curso;
    private String cpf;
    //farei uma classe endereço
    private Endereco endereco;
    private String telefone;
    
    public Aluno(String nome, String dataNascimento, String sexo,
            int idMatricula, String curso, String cpf, 
            Endereco endereco, String telefone){
        //validações
        validarNome(nome);
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
        this.idMatricula = idMatricula;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome vazio");
        } 
        if (!nome.trim().contains(" ")){ // verificamos se o nome contém espaço
            throw new IllegalArgumentException("Informe o nome completo");
        }
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
}
