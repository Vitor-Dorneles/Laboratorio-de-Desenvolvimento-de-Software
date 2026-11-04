// Data: 21/10/2026
Para a prova, sem relacionamento
- Relacionamento foi o conteúdo do PDF desta pasta (Relacionando tabelas): tabela `veiculo` com `id_pessoa` (chave estrangeira), combo com objetos `Pessoa`, `toString` e `equals` na `Pessoa`.
- Código do relacionamento: `CadastroPessoas/src/view/CadastroVeiculo.java`, `ConsultaEdicao.java`, `RelatorioVeiculo.java` e `dao/VeiculoDAO.java`.
principalmente inserir e consultar 
- Inserir: `CadastroPessoa` → `PessoaDAO.inserir`. Consultar: por id `getPessoa(id)` (`ModificarDados`), todos `getPessoas()` (`TabelaRelatorio`), por nome `getPessoasNome` (`PesquisaNome`).
- Tudo em `CadastroPessoas/`; o banco sai de `CadastroPessoas/bdaula01.sql`.