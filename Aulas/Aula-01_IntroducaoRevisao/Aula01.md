// Data: 29/07/2026
# Unidade 1: Planejamento de projeto de software
1.1 Ambientes de Desenvolvimento de software
3 ides, Eclipse -> Netbeans -> Intelijea
- Na disciplina o projeto é feito no NetBeans, tipo Java with Ant (a partir da Aula 02).
1.2 Codificação em camadas
Encontrar bugs e melhorias, cada camada responsável por uma função do software.
1.3 Arquitetura de Software
Arquitetura MVC
- Model: classes de dados (`beans`) e acesso ao banco (`dao`); View: telas (`view`); Controller: os eventos dos botões (`ActionPerformed`).
- Aplicado a partir da Aula 07: `../Aula-11_Relacionamentos/CadastroPessoas/src/` tem um pacote por camada.
# Unidade 2: Interface gráfica
2.1 Principais componentes gráficos
2.2 Desenvolvimento de Software
2.3 Estudos de caso

# Unidade 3: Integração com banco de dados
3.1 Fundamentos de banco de dados
3.2 Desenvolvimento de software
3.3 Configuração e comunicação em rede
# Unidade 4: Desenvolvimento de software
- 4.1 Gerenciamento de Dependências
  Maven
- 4.2 Repos de projeto
Git e github
- 4.3 Implementação e Distribuição
Implementação de banco de dados com MARIADB

## Revisão POO
### Conceitos
**Classe:** classe é uma estrutura que define caracteristicas de um conjunto de objetos
**Subclasse:** classe filha que herda atributos e métodos da classe mãe
**Objetos:** o objeto é a instância de uma classe, a classe é a especificação e o objeto é criado a partir dela, podemos criar diversos objetos
**Encapsulamento**: é a proteção de acesso dos atributos, como public(+), private(-), protected(#).
- Falta o quarto: default/package (`~`, sem palavra-chave), visível só no mesmo pacote.
- Atributo `private` é lido e alterado só por getters e setters (`getNome()`, `setNome()`).

**Métodos - Parâmetros**
os parametros são os valores passados para o método, na sua chamada, ex: public double somar(double n1, double n2);
ex2: public String carro(String marca, String modelo){
  obj.setMarca(teclado.nextLine());
}

**Construtores**
construtores são usados para inicializar objetos com atributos desejados, o java tem o construtor padrão quando não definimos nada.
podemos ter sobrecarga de construtores, o java difere eles conforme a quantidade, o tipo e a ordem dos parametros pré-definidos




**Exercícios de revisão**
- Enunciados em `Exercicios/exercicios.md`; cada exercício é um projeto em `Exercicios/`.
- `ContaCorrente`: atributos e métodos (`sacar` devolve `boolean`). `Casa`: sobrecarga de `calcularPreco`.
- `FormaGeometrica` → `TrianguloForma`: herança (`extends`) e sobrescrita (`@Override`).
- `MetodoPagamento`: classe abstrata com 3 filhas (Cartão, PayPal, Pix). `ImplementarInterface`: `ICalculadora` com `implements`.