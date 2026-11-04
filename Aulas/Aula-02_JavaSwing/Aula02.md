// Data: 05/08/2026
## Java Swing
Desenvolveremos um sistema multiplataforma com interface gráfica e banco de dados
## O que é?
É uma biblioteca gráfica, permite criar aplicativos com uma aparência e comportamento visual interativos
## base semestre passado
todas as aplicações jar que fizemos no semestre passado poderiam ser executados em diversos S.O
## Vantagens Java Swing
As aplicações Swing funcionam em várias plataformas sem a necessidade de reescrita
- Componentes personalizados
- Variedade de Componentes
- Interface Responsiva
- Adaptação da aplicação ao S.O
## Desvantagens
- Desempenho lento
- Aparencia diferente em cada S.O

## Etapa no Netbeans
Criaremos uma interface simples para um calculadora
para isso criamos o projeto com Java Ant
e depois criamos a "interface" com JFrame Form
- Código: `Calculadora/src/calculadora/CalculadoraInterface.java` (`extends javax.swing.JFrame`); `CalculadoraInterface_COMENTADA.java` é a mesma, comentada.
- Dois cliques no botão criam o evento `actionPerformed`, executado a cada clique; o número sai do campo com `Double.parseDouble(txtNum.getText())`.
- Padrão de nomes dos componentes: `btn` botão, `lbl` rótulo, `txt` campo de texto, `pnl` painel (o mesmo da Prova 01 e dos projetos de banco).
