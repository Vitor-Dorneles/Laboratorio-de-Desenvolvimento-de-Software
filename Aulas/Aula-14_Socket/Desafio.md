# Desenvolvimento de uma Aplicação Cliente-Servidor para Cadastro de Pessoas

**Peso: 1,0 na terceira nota**

## 1. Objetivo

Desenvolver uma aplicação utilizando a arquitetura **cliente-servidor** para realizar o cadastro de uma Pessoa em um banco de dados.

## 2. Cliente

O cliente deve possuir uma interface gráfica (janela) com os campos referentes aos dados da Pessoa e um botão para cadastrar.

### Funcionamento

1. O usuário preenche os dados da Pessoa na interface gráfica.
2. Ao clicar no botão **Cadastrar**, o cliente monta um objeto `Pessoa` com os dados digitados.
3. O cliente envia o objeto `Pessoa` para o servidor.
4. Após receber a resposta do servidor, o cliente exibe a mensagem retornada para o usuário.

## 3. Servidor

O servidor deve ficar aguardando conexões de clientes e atender cada conexão em uma **Thread separada**, permitindo que vários clientes realizem cadastros simultaneamente.

### Funcionamento

1. Recebe o objeto `Pessoa` enviado pelo cliente.
2. Tenta inserir os dados recebidos no banco de dados.
3. Devolve uma mensagem ao cliente:
   - **Sucesso:** caso a inserção seja realizada corretamente.
   - **Erro:** caso ocorra alguma exceção, como banco de dados indisponível ou campo obrigatório vazio.

## 4. Fluxo completo da aplicação

O funcionamento da aplicação deve seguir esta sequência:

1. Usuário preenche os dados na tela do cliente.
2. Cliente envia o objeto `Pessoa` para o servidor.
3. Servidor tenta inserir os dados no banco de dados.
4. Servidor responde com uma mensagem de `"sucesso"` ou `"erro: motivo"`.
5. Cliente exibe a resposta recebida na tela.

## 5. Requisitos mínimos

- A classe `Pessoa` deve possuir os seguintes atributos:
  - `nome`;
  - `sexo`;
  - `idioma`.
- Cliente e servidor devem ser dois programas separados (dois projetos ou duas classes com método `main`).
- A classe `Pessoa` deve ser a mesma nos dois lados (cliente e servidor).
- O servidor deve utilizar **Threads**, atendendo cada conexão aceita em uma Thread própria.
- O servidor deve tratar as exceções e nunca encerrar sua execução por causa de um cadastro com problemas.
- O campo `nome` deve ser obrigatório no banco de dados (`NOT NULL`), permitindo testar o retorno de mensagens de erro.

## 6. O que entregar

A entrega deve conter:

- [ ] Código-fonte do cliente.
- [ ] Código-fonte do servidor.
- [ ] Script SQL para criação da tabela no banco de dados.

## 7. Resultado esperado

Ao final do desenvolvimento, a aplicação deverá permitir que diferentes clientes realizem cadastros de pessoas simultaneamente, utilizando a comunicação cliente-servidor, com armazenamento dos dados no banco de dados e retorno de mensagens informando o sucesso ou a falha de cada operação.