// Data: 07/10/2026
ajustar o código do projeto pessoa, organizar o projeto para a proxima aula(21/10) e filtar por sexo 
- O projeto pessoa agora é `../Aula-11_Relacionamentos/CadastroPessoas/`.
- Do dia: relatório em `JTable` (`view/TabelaRelatorio.java` + `getPessoas()`), `MenuPrincipal` com `JMenuBar`, telas com `DISPOSE_ON_CLOSE` e pesquisa por nome (`view/PesquisaNome.java` + `getPessoasNome`, `WHERE nome LIKE ?` com `"%" + nome + "%"`).
- O filtro por sexo ainda não está no projeto pessoa; o modelo é `getAlunos(nome, sexo)` em `CadastroEscola/src/dao/AlunoDAO.java`.

fazer o mesmo para o projeto alunos, professores e alunos com (rdo_masculino e feminino)
- Feito em `../Aula-11_Relacionamentos/CadastroEscola/`: `PesquisaAluno` e `PesquisaProfessor` com `rdoTodos`, `rdoMasculino` e `rdoFeminino`.
eventos dos botoes preencherTabela
- `preencherTabela()`: pega a lista do DAO e faz `addRow` por objeto no `DefaultTableModel`; é chamado no construtor da tela.
- Em `PesquisaNome` ele também é chamado no evento `txtNomeCaretUpdate`, a cada letra digitada; por isso começa com `setNumRows(0)`, senão as linhas se repetem.



