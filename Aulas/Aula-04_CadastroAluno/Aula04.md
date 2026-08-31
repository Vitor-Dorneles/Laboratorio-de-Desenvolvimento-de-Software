## Atividade Casa
Criar um cadastro de alunos em um sistema
• Cadastro de Aluno:
• O usuário deve poder adicionar um novo aluno ao sistema.  Cada aluno deve ter os 
seguintes atributos: Nome completo, Data  de nascimento (no formato DD/MM/AAAA), 
Sexo, Matrícula (um número único), Curso, CPF (Cadastro de Pessoa Física), 
Endereço completo (rua, número, bairro, cidade, CEP), Estado (combo box), Telefone 
de contato, 
• Utilize classes e adicione em um TextArea os dados com cada atributo separado com ;.
• Por exemplo: Ricardo Frohlich da Silva;17/01/1985;Masculino,102030;Ciência  da 
Computação ...

## Resolução
Primeiro construi a classe aluno com os dados pedidos, fiz todos privados e construi uma classe que será usada para composição em aluno, não é herança
usaremos assim: public Endereco endereco;
faremos os construtores para que nada fique mal completado,
quem for criar um aluno(construtor), deve montar o endereço primeiro, pois meu aluno recebe o endereco completo
### construtor
O construtor deve validar dados em seu formato, para que a cada chamada de construtor não precisemos validar novamente, enquanto a unicidade(duplicidade de dados) deve ser validada fora da classe de construtor

as validações devem ficar antes das atribuições, ex:
validarNome(String nome);
this.nome = nome;

um dos construtores finalizados
```java
try {
            Endereco endereco = new Endereco(
                    txtRua.getText(), numero, txtBairro.getText(),
                    txtCidade.getText(), txtCep.getText(),
                    (String) cmbEstado.getSelectedItem());
```
### Validações
As validaçoes são feitas por campo, para que sirvam no futuro onde o sistema pode mudar e podemos usar em outros sistemas java
exemplo básico de validação de nome completo, onde validamos se temos um nome e se ele tem espaço
```java
    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome vazio");
        } 
        if (!nome.trim().contains(" ")){ // verificamos se o nome contém espaço
            throw new IllegalArgumentException("Informe o nome completo");
        }
    }
```

#### Validações de Data
``` java
 private void validarData(String dataNascimento) {
        try {
            LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // localdate parse interpreta a string como o formato escolhido
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
    }
```

#### Strings tamanho
**Validar CEP:** Validei se a String era null e se o tamanho era diferente de 8 digitos
```java
private void validarCep(String cep) {
        if (cep == null || cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido");
            // falta validar se são só numeros, mas é mais complexo
        }
    }
```

## ToString 
?? ToString :: Método importante para cada classe, que a torna responsável pela sua própria exibição e as outras só tem de chamar o método já concatenado

