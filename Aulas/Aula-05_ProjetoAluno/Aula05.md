// Data: 02/09/2026
# Prova 01
Prova semana que vem
parte prática, permitido usar github
Cadastro Aluno é fundamental
colocar objetos em uma lista
**Preciso colocar leitura de arquivo**, cada vez que o sistema iniciar

## Atividade 
•Criar um cadastro de alunos em um sistema
•Cadastro de Aluno:

•O usuário deve poder adicionar um novo aluno ao sistema. Cada aluno deve ter os seguintes atributos: Nome completo, Data de nascimento (no formato DD/MM/AAAA), Sexo, Matrícula (um número único), Curso, CPF (Cadastro de Pessoa Física), Endereço completo (rua, número, bairro, cidade, CEP), Estado (combo box), Telefone de contato,

•Utilize classes e adicione em uma lista os dados e apresenta na tabela.

•Após, faça a implementação de leitura e escrita em arquivos.

•Faça com que a lista seja salva em um arquivo texto.

•Ao abrir o sistema, ele deverá carregar a lista e apresentar na tabela.

•Adicione a exclusão e edição dos elementos já cadastrados

## Destilado


## Perguntas
?? Como funciona um método estático :: Ele pertence a classe, não precisa de um novo objeto para ser chamado, pode ser chamado de tal forma NomeDaClasse.método(parametro)

?? O que determina como a classe é gravada em arquivo? :: É o método toStrign, ele determina a sequencia e como é a gravaçao



## Erro que cometi
O desalinhamento dos 13 campos: você usou a ordem do construtor achando que ela determinava o arquivo.
O == no sexo: funcionaria no aluno recém-cadastrado e falharia no lido do arquivo. Esse é o card mais rico do dia, porque a resposta exige explicar por que os dois casos divergem.
O proximaMatricula local escondendo o campo da classe.
Sua decisão de usar "maior valor" em vez de "contagem" — e o que a contagem quebraria depois de uma exclusão.
lista.add() na tela alterando a lista interna do Arquivo.