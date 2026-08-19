/*
 * ============================================================================
 *  VERSÃO DE ESTUDO — CalculadoraInterface.java
 * ============================================================================
 *  Este arquivo é uma CÓPIA comentada da calculadora, feita só para revisão.
 *  Ele segue a mesma didática usada no PDF da aula (Introdução ao Java Swing
 *  + Calculadora): primeiro os conceitos de componente/evento, depois a
 *  lógica de "guardar o 1º valor + operação, limpar o campo, esperar o 2º
 *  valor, calcular no botão =".
 *
 *  IMPORTANTE (leia antes de usar no projeto de verdade):
 *  O método initComponents() abaixo é gerado automaticamente pelo Form
 *  Editor (GUI Builder) do NetBeans. Se você abrir esse arquivo no editor
 *  visual do NetBeans e mexer em qualquer componente pela tela, o NetBeans
 *  REESCREVE esse método do zero — e os comentários que coloquei ali dentro
 *  seriam apagados. Por isso: use este arquivo só para ESTUDAR. O arquivo
 *  que fica de fato no projeto NetBeans continua sendo o
 *  CalculadoraInterface.java "oficial", sem esses comentários extras dentro
 *  do initComponents().
 * ============================================================================
 */
package calculadora;

/**
 * CalculadoraInterface
 * ---------------------
 * Essa classe HERDA de javax.swing.JFrame (por isso "extends JFrame").
 * Ou seja: CalculadoraInterface *é* uma janela — ela já nasce com tudo que
 * uma JFrame tem (título, botão de fechar, barra de título...) e a gente só
 * adiciona os componentes (botões, label, campo de texto) dentro dela.
 *
 * Roteiro de leitura sugerido (na ordem que faz mais sentido pra estudar):
 *   1) Os atributos da classe (n1, n2, operacao) — é a "memória" da conta.
 *   2) O construtor.
 *   3) initComponents() — SÓ a leitura, não precisa decorar a álgebra do
 *      GroupLayout, é gerado sozinho pelo NetBeans (explico o que ele faz
 *      logo abaixo).
 *   4) Os métodos ...ActionPerformed(...) — é AQUI que mora a lógica da
 *      calculadora, um método por botão.
 *   5) O método main() — onde o programa começa a rodar.
 *
 * @author vitor
 */
public class CalculadoraInterface extends javax.swing.JFrame {

    // ========================================================================
    //  ATRIBUTOS DA CLASSE — a "memória" da calculadora
    // ========================================================================
    //  Esses valores precisam ser atributos (variáveis fora de qualquer
    //  método, "globais" da classe) e não variáveis locais, porque eles
    //  precisam SOBREVIVER entre um clique e outro. Uma variável local
    //  criada dentro de um método morre assim que o método termina; aqui a
    //  gente precisa lembrar do primeiro número e da operação escolhida até
    //  o usuário clicar em "=".
    //
    //  n1 -> guarda o primeiro número digitado (antes de escolher +,-,x,/)
    //  n2 -> guarda o segundo número digitado (depois da operação escolhida,
    //        preenchido só na hora do "=")
    //  operacao -> guarda qual operação foi escolhida ("soma", "subtracao",
    //        "multiplicacao", "divisao") ou null se nenhuma foi escolhida
    //        ainda. É comparando esse texto que o botão "=" decide a conta.
    double n1, n2;
    String operacao;

    // Objeto usado só para registrar erros no console (ex.: se o Look and
    // Feel "Nimbus" não estiver disponível lá no main()). Não tem relação
    // com a lógica da calculadora, é só uma boa prática de log que o
    // NetBeans já inclui por padrão.
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CalculadoraInterface.class.getName());

    /**
     * Construtor da classe.
     * Todo objeto CalculadoraInterface criado (veja o main() lá embaixo)
     * passa por aqui primeiro. A única coisa que ele faz é chamar
     * initComponents(), que monta a tela.
     */
    public CalculadoraInterface() {
        initComponents(); // método do NetBeans que cria e organiza os componentes da interface
    }

    // ========================================================================
    //  initComponents() — MONTAGEM DA TELA (gerado pelo NetBeans)
    // ========================================================================
    //  Esse método faz 3 coisas, nessa ordem:
    //
    //  (1) CRIA cada componente:
    //          lblCalculadora, lblValor  -> JLabel  (texto, não editável)
    //          txtNum                    -> JTextField (campo onde o usuário
    //                                        digita/vê os números)
    //          btnC, btnCE, btnZero...   -> JButton (botões clicáveis)
    //
    //      Repare no PREFIXO de cada nome: btn/lbl/txt. É a convenção de
    //      nomenclatura ensinada no PDF (slides 20-22): o prefixo já diz
    //      que TIPO de componente é aquele, sem precisar abrir o código.
    //
    //  (2) CONFIGURA cada componente: define o texto do botão (setText),
    //      alinhamento do texto, cor de fundo, e o mais importante —
    //      registra o "ouvinte de clique" (addActionListener). É esse
    //      listener que faz o Swing chamar o método certo (ex.:
    //      btnAdicaoActionPerformed) toda vez que aquele botão é clicado.
    //      Essa ligação "botão -> método" é criada automaticamente quando
    //      você dá 2 cliques no botão pelo editor visual do NetBeans.
    //
    //  (3) DEFINE O LAYOUT (GroupLayout): essa é a parte mais "estranha" de
    //      ler à mão. O NetBeans usa o layout chamado GroupLayout, que
    //      descreve a posição de cada componente através de dois "grupos":
    //
    //        - Grupo SEQUENCIAL: os componentes ficam um do LADO do outro
    //          (em fila), tipo uma linha.
    //        - Grupo PARALELO: os componentes ocupam o MESMO espaço,
    //          alinhados uns sobre os outros — usado para dizer "esses
    //          componentes aqui pertencem à mesma coluna/linha".
    //
    //      Isso é feito DUAS vezes: uma para o eixo horizontal
    //      (setHorizontalGroup) e outra para o eixo vertical
    //      (setVerticalGroup). É a combinação dos dois que define a posição
    //      X,Y final de cada botão.
    //
    //      Não é preciso decorar essa álgebra — no dia a dia você edita
    //      isso ARRASTANDO os componentes no editor visual do NetBeans, e
    //      ele reescreve esse código sozinho. Por isso o aviso oficial do
    //      NetBeans diz "Do NOT modify this code" (não mexa aqui na mão).
    //
    //      Para ajudar a "traduzir" esse emaranhado de grupos em algo
    //      visual, aqui está o resultado final, célula por célula
    //      (é a grade de botões que esse código produz):
    //
    //          [ ................  C  (largura total)  ................. ]
    //          [   %    ] [  CE    ] [ DELETE ] [   /    ]
    //          [   7    ] [   8    ] [   9    ] [   X    ]
    //          [   4    ] [   5    ] [   6    ] [   -    ]
    //          [   1    ] [   2    ] [   3    ] [   +    ]
    //          [      0 (dobro de largura)    ] [ . ] [ = ]
    //
    //      Cada "coluna" que você vê acima existe porque os botões daquela
    //      coluna estão dentro do MESMO grupo paralelo no eixo horizontal
    //      (ex.: %, 7, 4, 1 estão todos no mesmo grupo -> mesma coluna 1).
    //      Cada "linha" existe pelo mesmo motivo, só que no grupo paralelo
    //      do eixo VERTICAL.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // --- (1) criação dos componentes -----------------------------------
        lblCalculadora = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        btnC = new javax.swing.JButton();
        btnPercent = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDivisao = new javax.swing.JButton();
        btnVezes = new javax.swing.JButton();
        btnSete = new javax.swing.JButton();
        btnOito = new javax.swing.JButton();
        btnNove = new javax.swing.JButton();
        btnQuatro = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnSubtracao = new javax.swing.JButton();
        btnUm = new javax.swing.JButton();
        btnDois = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnAdicao = new javax.swing.JButton();
        btnPonto = new javax.swing.JButton();
        btnIgualdade = new javax.swing.JButton();
        btnZero = new javax.swing.JButton();

        // fecha o processo do Java quando a janela é fechada no X
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCalculadora.setText("Calculator");

        // texto do "visor de cima" alinhado à direita, como em calculadora de verdade
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        // texto digitado também alinhado à direita
        txtNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        // "this::txtNumActionPerformed" é uma referência de método (method
        // reference) — forma moderna e mais enxuta de escrever
        // "new ActionListener() { public void actionPerformed(...) {...} }"
        txtNum.addActionListener(this::txtNumActionPerformed);

        // --- (2) texto + listener de cada botão -----------------------------
        // Repare no padrão que se repete em TODOS os botões:
        //   btnX.setText("...")               -> o que aparece escrito
        //   btnX.addActionListener(this::btnXActionPerformed) -> qual método
        //        roda quando o usuário clica

        btnC.setText("C");
        btnC.addActionListener(this::btnCActionPerformed);

        btnPercent.setText("%");
        btnPercent.addActionListener(this::btnPercentActionPerformed);

        btnCE.setText("CE");
        btnCE.addActionListener(this::btnCEActionPerformed);

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnDivisao.setText("/");
        btnDivisao.addActionListener(this::btnDivisaoActionPerformed);

        btnVezes.setText("X");
        btnVezes.addActionListener(this::btnVezesActionPerformed);

        btnSete.setText("7");
        btnSete.addActionListener(this::btnSeteActionPerformed);

        btnOito.setText("8");
        btnOito.addActionListener(this::btnOitoActionPerformed);

        btnNove.setText("9");
        btnNove.addActionListener(this::btnNoveActionPerformed);

        btnQuatro.setText("4");
        btnQuatro.addActionListener(this::btnQuatroActionPerformed);

        btnCinco.setText("5");
        btnCinco.addActionListener(this::btnCincoActionPerformed);

        btnSeis.setText("6");
        btnSeis.addActionListener(this::btnSeisActionPerformed);

        btnSubtracao.setText("-");
        btnSubtracao.addActionListener(this::btnSubtracaoActionPerformed);

        btnUm.setText("1");
        btnUm.addActionListener(this::btnUmActionPerformed);

        btnDois.setText("2");
        btnDois.addActionListener(this::btnDoisActionPerformed);

        btnTres.setText("3");
        btnTres.addActionListener(this::btnTresActionPerformed);

        btnAdicao.setText("+");
        btnAdicao.addActionListener(this::btnAdicaoActionPerformed);

        btnPonto.setText(".");
        btnPonto.addActionListener(this::btnPontoActionPerformed);

        // botão "=" ganha uma cor de fundo diferente pra se destacar dos demais
        btnIgualdade.setBackground(new java.awt.Color(0, 153, 204));
        btnIgualdade.setText("=");
        btnIgualdade.addActionListener(this::btnIgualdadeActionPerformed);

        btnZero.setText("0");
        btnZero.addActionListener(this::btnZeroActionPerformed);

        // --- (3) GroupLayout: posicionamento -------------------------------
        // (ver explicação completa no comentário grande acima do método)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIgualdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnQuatro)
                                    .addComponent(btnUm))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCinco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSeis)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSubtracao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDois)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTres)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdicao))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnOito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNove)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnVezes))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDivisao)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        // linkSize força vários botões a terem sempre a MESMA largura entre si
        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicao, btnCE, btnCinco, btnDelete, btnDivisao, btnDois, btnNove, btnOito, btnPonto, btnQuatro, btnSeis, btnSete, btnSubtracao, btnTres, btnUm, btnVezes, btnZero});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNum, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblCalculadora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDivisao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVezes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIgualdade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCE, btnDelete, btnDivisao, btnDois, btnNove, btnOito, btnQuatro, btnSeis, btnSete, btnSubtracao, btnUm, btnVezes});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicao, btnIgualdade, btnPonto, btnTres, btnZero});

        pack(); // ajusta o tamanho da janela para caber tudo certinho
    }// </editor-fold>//GEN-END:initComponents

    // ========================================================================
    //  EVENTOS DOS BOTÕES — é aqui que mora a lógica da calculadora
    // ========================================================================
    //  Cada método abaixo roda automaticamente quando o botão correspondente
    //  é clicado (é o addActionListener lá de cima que faz essa ligação).
    //  Existem, no fundo, só 4 "padrões" diferentes de comportamento:
    //
    //   PADRÃO 1 — dígitos (0-9) e ponto:
    //       simplesmente concatenam o caractere no final do texto do txtNum.
    //       txtNum.setText(txtNum.getText() + "7")  -> "junta" o 7 no que já
    //       estava digitado.
    //
    //   PADRÃO 2 — operadores (+, -, x, /):
    //       1) guarda o número que está no txtNum dentro de n1
    //       2) guarda qual operação foi escolhida na variável operacao
    //       3) mostra "n1 +" no lblValor (pra lembrar o usuário o que já foi
    //          digitado)
    //       4) LIMPA o txtNum, para o usuário digitar o segundo número
    //
    //   PADRÃO 3 — botão "=":
    //       1) guarda o número que está no txtNum dentro de n2
    //       2) olha o que está guardado em operacao e faz a conta certa
    //       3) mostra o resultado no txtNum
    //       4) zera a variável operacao (a "conta" acabou)
    //
    //   PADRÃO 4 — utilitários (C, CE, DELETE, %):
    //       cada um mexe no estado de um jeito diferente — comentado
    //       individualmente abaixo.
    // ========================================================================

    private void txtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumActionPerformed
        // Disparado se o usuário der ENTER dentro do campo de texto.
        // Não foi implementado nada aqui (poderia, por exemplo, simular um
        // clique no "="). Deixado vazio de propósito, é só um "gancho"
        // criado automaticamente pelo NetBeans quando o campo txtNum foi
        // criado.
    }//GEN-LAST:event_txtNumActionPerformed

    // ---------------------------------------------------------------------
    //  C  x  CE — os dois botões de "limpar", só que com alcances diferentes
    // ---------------------------------------------------------------------

    private void btnCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEActionPerformed
        // CE = "Clear Entry": limpa só o que está sendo digitado agora.
        // NÃO mexe em n1 nem em operacao -> se o usuário já tinha escolhido
        // uma operação, ela continua guardada, só o número atual é apagado.
        // Útil para corrigir um erro de digitação sem perder a conta.
        txtNum.setText("");
    }//GEN-LAST:event_btnCEActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        // C = "Clear": reset TOTAL. Apaga o campo de texto, o rótulo que
        // mostra a operação em andamento, e zera as variáveis de estado
        // (n1, n2, operacao). É como se a calculadora tivesse acabado de
        // ser aberta.
        txtNum.setText("");
        lblValor.setText("");
        n1 = 0;
        n2 = 0;
        operacao = null;
    }//GEN-LAST:event_btnCActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // "Backspace": remove só o ÚLTIMO caractere digitado.
        String texto = txtNum.getText();
        if (texto.length() > 0) {
            // substring(0, tamanho - 1) pega o texto inteiro MENOS o
            // último caractere. Ex.: "123".substring(0,2) -> "12"
            txtNum.setText(texto.substring(0, texto.length() - 1));
        }
        // se o campo já estiver vazio (length() == 0), não faz nada —
        // evita um erro de "índice inválido" ao tentar cortar uma String vazia.
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPercentActionPerformed
        // Botão extra (não pedido no exercício original, mas incluso como
        // reforço de aprendizado). Regra usada aqui:
        //   - se JÁ existe uma operação em andamento (operacao != null),
        //     calcula a porcentagem EM CIMA do primeiro valor (n1);
        //     ex.: 200 [+] 10 [%] -> calcula 10% de 200 = 20
        //   - se não há operação em andamento, apenas divide o valor
        //     digitado por 100 (10% -> 0.1)
        if (txtNum.getText().isEmpty())
            return; // nada digitado, não há o que calcular

        double valor = Double.parseDouble(txtNum.getText());
        double resultado;
        if (operacao != null) {
            resultado = n1 * (valor / 100);
        } else {
            resultado = valor / 100;
        }
        txtNum.setText(String.valueOf(resultado));
    }//GEN-LAST:event_btnPercentActionPerformed

    // ---------------------------------------------------------------------
    //  Dígitos 0-9 — todos seguem exatamente o mesmo padrão (PADRÃO 1)
    // ---------------------------------------------------------------------
    //  txtNum.getText() lê o que já está escrito, e a gente concatena mais
    //  um caractere no final com o operador "+".

    private void btnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeteActionPerformed
        txtNum.setText(txtNum.getText() + "7");
    }//GEN-LAST:event_btnSeteActionPerformed

    private void btnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOitoActionPerformed
        txtNum.setText(txtNum.getText() + "8");
    }//GEN-LAST:event_btnOitoActionPerformed

    private void btnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoveActionPerformed
        txtNum.setText(txtNum.getText() + "9");
    }//GEN-LAST:event_btnNoveActionPerformed

    private void btnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuatroActionPerformed
        txtNum.setText(txtNum.getText() + "4");
    }//GEN-LAST:event_btnQuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        txtNum.setText(txtNum.getText() + "5");
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        txtNum.setText(txtNum.getText() + "6");
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUmActionPerformed
        txtNum.setText(txtNum.getText() + "1");
    }//GEN-LAST:event_btnUmActionPerformed

    private void btnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoisActionPerformed
        txtNum.setText(txtNum.getText() + "2");
    }//GEN-LAST:event_btnDoisActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        txtNum.setText(txtNum.getText() + "3");
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        txtNum.setText(txtNum.getText() + "0");
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPontoActionPerformed
        // Só adiciona o ponto se ainda NÃO existir um ponto no texto atual
        // (contains(".")) — evita algo como "12.5.3", que o
        // Double.parseDouble não conseguiria converter depois.
        if (!txtNum.getText().contains(".")) {
            // Se o campo estiver vazio, começa com "0." em vez de só ".",
            // pra não gerar um número inválido como ".5"
            txtNum.setText(txtNum.getText().isEmpty() ? "0." : txtNum.getText() + ".");
        }
    }//GEN-LAST:event_btnPontoActionPerformed

    // ---------------------------------------------------------------------
    //  Operadores (+, -, x, /) — todos seguem o PADRÃO 2 (explicado acima)
    // ---------------------------------------------------------------------
    //  A ordem dentro de cada método importa:
    //    1º) lblValor.setText(...)   -> mostra "n +" pro usuário
    //    2º) n1 = Double.parseDouble(txtNum.getText())  -> converte o TEXTO
    //        digitado (String) para NÚMERO (double), e guarda em n1
    //    3º) operacao = "..."        -> "lembra" qual operação foi escolhida
    //    4º) txtNum.setText("")      -> limpa o campo pro 2º número

    private void btnAdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicaoActionPerformed
        if (txtNum.getText().isEmpty()) return; // nada digitado ainda, ignora o clique
        lblValor.setText(txtNum.getText() + " +");
        n1 = Double.parseDouble(txtNum.getText());
        operacao = "soma";
        txtNum.setText("");
    }//GEN-LAST:event_btnAdicaoActionPerformed

    private void btnSubtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtracaoActionPerformed
        if (txtNum.getText().isEmpty()) return;
        lblValor.setText(txtNum.getText() + " -");
        n1 = Double.parseDouble(txtNum.getText());
        operacao = "subtracao";
        txtNum.setText("");
    }//GEN-LAST:event_btnSubtracaoActionPerformed

    private void btnVezesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVezesActionPerformed
        if (txtNum.getText().isEmpty()) return;
        lblValor.setText(txtNum.getText() + " X");
        n1 = Double.parseDouble(txtNum.getText());
        operacao = "multiplicacao";
        txtNum.setText("");
    }//GEN-LAST:event_btnVezesActionPerformed

    private void btnDivisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisaoActionPerformed
        if (txtNum.getText().isEmpty())
            return;

        lblValor.setText(txtNum.getText() + " /");
        n1 = Double.parseDouble(txtNum.getText());
        operacao = "divisao";
        txtNum.setText(""); // limpa a tela para o segundo número
    }//GEN-LAST:event_btnDivisaoActionPerformed

    // ---------------------------------------------------------------------
    //  "=" — PADRÃO 3: aqui a conta realmente acontece
    // ---------------------------------------------------------------------

    private void btnIgualdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualdadeActionPerformed
        // Só calcula se o usuário JÁ escolheu uma operação (operacao != null)
        // e JÁ digitou o segundo número (txtNum não vazio). Sem isso, o
        // clique é ignorado — evita, por exemplo, apertar "=" sem ter
        // escolhido nenhuma operação antes.
        if (operacao == null || txtNum.getText().isEmpty()) return;

        // converte o segundo número digitado (texto) para double
        n2 = Double.parseDouble(txtNum.getText());
        double resultado = 0;

        // O PDF, no slide do "=", usa "if (operacao == "soma")" para
        // comparar Strings. Isso até funciona por causa do "pool" de
        // Strings do Java, mas NÃO é a forma recomendada de comparar texto
        // (o certo seria "soma".equals(operacao)). Aqui usamos um
        // switch(String), que é mais seguro e mais legível quando há várias
        // opções — o switch usa .equals() por baixo dos panos.
        switch (operacao) {
            case "soma":
                resultado = n1 + n2;
                break;
            case "subtracao":
                resultado = n1 - n2;
                break;
            case "multiplicacao":
                resultado = n1 * n2;
                break;
            case "divisao":
                // divisão por zero é matematicamente indefinida — em vez de
                // deixar o Java devolver "Infinity", tratamos como erro e
                // saímos do método mais cedo (o "return" aqui interrompe a
                // execução, então as duas últimas linhas do método não
                // rodam nesse caso).
                if (n2 == 0) {
                    lblValor.setText("Erro: divisão por zero");
                    txtNum.setText("");
                    operacao = null;
                    return;
                }
                resultado = n1 / n2;
                break;
        }

        // mostra o resultado e "reseta" a operação (mas mantém n1/n2 caso
        // você queira, por exemplo, reaproveitar em alguma extensão futura)
        txtNum.setText(String.valueOf(resultado));
        operacao = null;
    }//GEN-LAST:event_btnIgualdadeActionPerformed

    // ========================================================================
    //  main() — ponto de entrada do programa
    // ========================================================================
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // --- escolhe o "Look and Feel" (aparência visual) Nimbus, se disponível ---
        // Percorre todos os L&F instalados no sistema procurando por "Nimbus"
        // (mais moderno que o padrão do Java). Se não achar (ex.: rodando em
        // outro SO/ambiente), a calculadora simplesmente usa a aparência
        // padrão — o try/catch garante que isso nunca quebre o programa.
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        // --- cria e exibe a janela ---
        // Interfaces gráficas em Java rodam numa thread própria chamada
        // Event Dispatch Thread (EDT) — é ela quem cuida de desenhar a tela
        // e reagir aos cliques. EventQueue.invokeLater(...) agenda a
        // criação da janela para rodar DENTRO dessa thread, em vez da
        // thread "main" comum — é a forma correta (e recomendada pela
        // documentação do Swing) de iniciar uma aplicação gráfica.
        java.awt.EventQueue.invokeLater(() -> new CalculadoraInterface().setVisible(true));
    }

    // ========================================================================
    //  Variáveis dos componentes gerados pelo NetBeans (não editar manualmente)
    // ========================================================================
    private javax.swing.JButton btnAdicao;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDivisao;
    private javax.swing.JButton btnDois;
    private javax.swing.JButton btnIgualdade;
    private javax.swing.JButton btnNove;
    private javax.swing.JButton btnOito;
    private javax.swing.JButton btnPercent;
    private javax.swing.JButton btnPonto;
    private javax.swing.JButton btnQuatro;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSete;
    private javax.swing.JButton btnSubtracao;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUm;
    private javax.swing.JButton btnVezes;
    private javax.swing.JButton btnZero;
    private javax.swing.JLabel lblCalculadora;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtNum;
    // End of variables declaration
}
