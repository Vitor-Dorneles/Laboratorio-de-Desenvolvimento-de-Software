// Data: 28/10/2026
Na aula de hoje estudaremos sobre o Maven, uma ferramenta de gerenciamento de dependências. Na sequência, estudaremos sobre Spring boot e desenvolveremos uma API utilizando-a.

## Maven
- **Dependência:** biblioteca externa que o projeto usa para alguma funcionalidade.
- Visto na Aula 07 (Início Banco de Dados): o `mysql-connector-j` foi baixado e adicionado à mão em `lib/`; com Maven basta declarar no `pom.xml` e ele baixa do repositório (Maven Central).
- **POM (`pom.xml`):** XML que descreve o projeto: nome, versão, dependências e plugins.
- **Coordenadas:** `groupId` (prefixo dos pacotes), `artifactId` (nome do projeto), `version`.
- **Archetype:** modelo de projeto pronto com o Maven configurado (`maven-archetype-quickstart`).
- **Convenção sobre configuração:** estrutura de pastas e configurações já vêm no padrão.
- Erro de versão ao compilar: ajustar `<source>` e `<target>` do `maven-compiler-plugin` (no mínimo 8).
- **Gradle:** alternativa ao Maven, mais flexível e rápida; o Maven é mais rígido e padronizado.

## Spring Boot
- Framework que simplifica criar aplicações Java: convenção sobre configuração, sem arquivos XML de configuração.
- Projeto gerado no Spring Initializr (https://start.spring.io/), já com as dependências escolhidas.
- **API:** conjunto de regras que permite que sistemas se comuniquem sem conhecer a implementação um do outro.
- **REST:** API web sobre HTTP; GET consulta, POST cadastra, PUT edita, DELETE exclui.
- MVC na API: Model é a classe `Cliente` + a interface de repositório; Controller é a `ClienteController`, que recebe as requisições HTTP. Visto na Aula 01 (Arquitetura MVC).
- A interface de repositório (Spring Data) faz o papel do DAO da Aula 07 sem escrever SQL.
- `application.properties`: URL, usuário e senha do MySQL, o papel da classe `Conexao` nos projetos Swing.
- `@RequestMapping`: liga uma URL e um método HTTP a um método da controller; teste em `http://localhost:8080/clientes` pelo Postman.
- **`Optional`:** retorno que pode vir vazio (ex.: buscar por id que não existe) em vez de `null`.

Atividade de revisão para a prova: `RevisaoProva02.md`, nesta pasta.

## Destilado


## Perguntas


## Erro que cometi
