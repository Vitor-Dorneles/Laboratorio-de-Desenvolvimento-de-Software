// Data: 23/09/2026
Começamos a conexão com banco de dados
Trabalharemos com java swing e mySql
usamos o command line do mySql e o workbench
- Comandos do dia: `SHOW DATABASES;`, `CREATE DATABASE`, `USE banco;`, `CREATE TABLE`, `DESC tabela;`, `SHOW TABLES;`, `INSERT` com vários registros num só `VALUES`.
- Senha do root no laboratório: `laboratorio` (é a que vai na classe de conexão).

tudo o que seguiremos a partir será do banco bdAula01
- Script do dia: `BdAula01.sql` (tabela `pessoa`: id, nome, sexo, idioma). Versão usada no projeto: `../Aula-11_Relacionamentos/CadastroPessoas/bdaula01.sql`.

hoje criamos os schemas de dois bancos bdAula e escola
- `escola` (aluno, professor, matricula) foi a atividade do slide: `ESCOLA.sql`. Versão final, com `sexo`: `../Aula-11_Relacionamentos/CadastroEscola/escola.sql`.
- `matricula` tem duas chaves estrangeiras: `FOREIGN KEY (id_aluno) REFERENCES aluno(id)`.
agora baixamos uma biblioteca para conectar o mysql no apache com java swing
- É o driver JDBC `mysql-connector-j-8.1.0.jar`; nos projetos ele fica em `lib/`.

fizemos por meio de jarfile
- No NetBeans: botão direito no projeto → Properties → Libraries → Add JAR/Folder.
- A conexão usa o jar em `conexao/Conexao.java`: `DriverManager.getConnection("jdbc:mysql://localhost:3306/bdaula01", "root", "laboratorio")`. Na aula a classe se chamava `Conectar`.

Estamos organizando os pacotes como uma estrutura MVC, 
- Pacotes: `beans` (uma classe por tabela, ex. `Pessoa`), `dao` (SQL), `conexao`, `view` (telas). Visto na Aula 01 (Arquitetura MVC).
DAO -- DATA ACESS OBJECT
    - onde ficam as querys sql (os schemas ficam nos scripts .sql)
      - Primeiro método: `inserir(Pessoa p)` em `../Aula-11_Relacionamentos/CadastroPessoas/src/dao/PessoaDAO.java`.
      - Usa `PreparedStatement` com `?` no SQL, `stmt.setString(1, p.getNome())` para cada `?` e `stmt.execute()`.


## Destilado


## Perguntas


## Erro que cometi
