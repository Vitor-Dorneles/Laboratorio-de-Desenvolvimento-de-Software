// Data: 28/10/2026
Atividade de revisão para a prova 02
- É Swing + MySQL, segue o projeto `../Aula-11_Relacionamentos/CadastroPessoas/`, com Categoria no lugar de Pessoa e Produto no lugar de Veiculo.
- Ordem: script `.sql` → `beans` → `dao` → telas em `view` → `MenuPrincipal`.

Crie uma tabela chamada Categorias com os seguintes atributos:
- id: chave primária, auto-incrementável.
- nome
- Modelo: tabela `pessoa` em `../Aula-11_Relacionamentos/CadastroPessoas/bdaula01.sql`.

Crie uma tabela chamada Produtos com os seguintes atributos:
- id: chave primária, auto-incrementável.
- Nome
- Preco
  - `DECIMAL(10,2)` no banco, `double` no bean (`setDouble` / `getDouble`).
- Quantidade
- categoria_id: chave estrangeira
  - Modelo: `id_pessoa` da tabela `veiculo`: `FOREIGN KEY (categoria_id) REFERENCES categorias(id)`.
  - Categorias precisa ser criada antes de Produtos, e uma categoria com produtos não pode ser excluída.

Implemente um formulário que permita o cadastro de novos produtos.
- Modelo: `CadastroVeiculo.java` + `VeiculoDAO.inserir`; no bean, o produto guarda o objeto `Categoria`, e o DAO grava `getCategoria().getId()`.

O formulário deve incluir a possibilidade de selecionar a categoria do produto, listando as categorias cadastradas.
- Modelo: `cmbPessoa` em `CadastroVeiculo.java`, preenchido com `addItem` para cada objeto de `getPessoas()`.
- A `Categoria` precisa de `toString()` devolvendo o nome (é o que o combo mostra) e `equals()` comparando o id.

As operações de CRUD (Criar, Ler, Atualizar, Deletar) devem ser implementadas para o cadastro de produtos.
- Modelo: `VeiculoDAO`: `inserir`, `getVeiculo(id)`, `getVeiculos()`, `editar`, `excluir(id)`.
- O botão de excluir não existe na tela de veículo; o modelo é o de `ModificarDados.java` (pessoa).

O sistema deve permitir que a categoria de um produto seja alterada durante a edição.
- Modelo: `ConsultaEdicao.java`: `cmbPessoa.setSelectedItem(v.getPessoaObj())` ao consultar (usa o `equals`) e `UPDATE ... id_pessoa = ?` ao salvar.

Desenvolva uma tela que exiba todos os produtos cadastrados, mostrando o nome do produto, o preço, a quantidade em estoque e a categoria associada.
- Modelo: `RelatorioVeiculo.java`: `DefaultTableModel` + `addRow` por produto; a coluna categoria mostra o `toString()`.
- No DAO, a categoria vem de `getCategoria(rs.getInt("categoria_id"))`, como em `VeiculoDAO.getVeiculos`.

Implemente uma tela separada para cadastrar, editar e listar as categorias.
- Modelo: telas da pessoa (`CadastroPessoa`, `ModificarDados`, `TabelaRelatorio`), juntas numa tela só.

Adicione uma funcionalidade de busca que permita procurar produtos por nome ou categoria.
- Por nome: `PesquisaNome.java` + `getPessoasNome` (`WHERE nome LIKE ?` com `"%" + nome + "%"`, `setNumRows(0)` antes de preencher).
- Por categoria: combo de categorias e `WHERE categoria_id = ?`; dois filtros juntos seguem `getAlunos(nome, sexo)` em `../Aula-11_Relacionamentos/CadastroEscola/src/dao/AlunoDAO.java`.

## Destilado


## Perguntas


## Erro que cometi
