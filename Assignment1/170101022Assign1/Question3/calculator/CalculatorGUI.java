
package calculator;

import java.awt.Color;

public class CalculatorGUI extends javax.swing.JFrame {

    private void MyInitialisation()
    {
        numbersLabels = new javax.swing.JLabel[11];
        numbersLabels[0] = Num0Label;
        numbersLabels[1] = Num1Label;
        numbersLabels[2] = Num2Label;
        numbersLabels[3] = Num3Label;
        numbersLabels[4] = Num4Label;
        numbersLabels[5] = Num5Label;
        numbersLabels[6] = Num6Label;
        numbersLabels[7] = Num7Label;
        numbersLabels[8] = Num8Label;
        numbersLabels[9] = Num9Label;
        numbersLabels[10] = StopLabel;

        functionsLabels = new javax.swing.JLabel[4];
        functionsLabels[0] = PlusLabel;
        functionsLabels[1] = MinusLabel;
        functionsLabels[2] = MultLabel;
        functionsLabels[3] = DivideLabel;

        display = Display;

        Thread thread1 = new Thread(new NumberHighlighter());
        Thread thread2 = new Thread(new FunctionsHighlighter());
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        
        this.addKeyListener(new CustomKeyListener());
    }

    public CalculatorGUI() {
        initComponents();
        MyInitialisation();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        Display = new javax.swing.JLabel();
        Num1Label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Num2Label = new javax.swing.JLabel();
        Num3Label = new javax.swing.JLabel();
        Num4Label = new javax.swing.JLabel();
        Num5Label = new javax.swing.JLabel();
        Num6Label = new javax.swing.JLabel();
        Num7Label = new javax.swing.JLabel();
        Num8Label = new javax.swing.JLabel();
        StopLabel = new javax.swing.JLabel();
        PlusLabel = new javax.swing.JLabel();
        MinusLabel = new javax.swing.JLabel();
        MultLabel = new javax.swing.JLabel();
        DivideLabel = new javax.swing.JLabel();
        Num9Label = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Num0Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SpecialCalculator");

        Display.setBackground(java.awt.Color.black);
        Display.setForeground(java.awt.Color.white);
        Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Display.setLabelFor(Display);
        Display.setText("Display");
        Display.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Display.setOpaque(true);

        Num1Label.setBackground(new java.awt.Color(255,255,204));
        Num1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num1Label.setText("1");
        Num1Label.setToolTipText("");
        Num1Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num1Label.setOpaque(true);

        jSeparator1.setBackground(java.awt.Color.black);
        jSeparator1.setForeground(java.awt.Color.black);
        jSeparator1.setOpaque(true);

        Num2Label.setBackground(new java.awt.Color(255,255,204));
        Num2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num2Label.setText("2");
        Num2Label.setToolTipText("");
        Num2Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num2Label.setOpaque(true);

        Num3Label.setBackground(new java.awt.Color(255,255,204));
        Num3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num3Label.setText("3");
        Num3Label.setToolTipText("");
        Num3Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num3Label.setOpaque(true);

        Num4Label.setBackground(new java.awt.Color(255,255,204));
        Num4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num4Label.setText("4");
        Num4Label.setToolTipText("");
        Num4Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num4Label.setOpaque(true);

        Num5Label.setBackground(new java.awt.Color(255,255,204));
        Num5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num5Label.setText("5");
        Num5Label.setToolTipText("");
        Num5Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num5Label.setOpaque(true);

        Num6Label.setBackground(new java.awt.Color(255,255,204));
        Num6Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num6Label.setText("6");
        Num6Label.setToolTipText("");
        Num6Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num6Label.setOpaque(true);

        Num7Label.setBackground(new java.awt.Color(255,255,204));
        Num7Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num7Label.setText("7");
        Num7Label.setToolTipText("");
        Num7Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num7Label.setOpaque(true);

        Num8Label.setBackground(new java.awt.Color(255,255,204));
        Num8Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num8Label.setText("8");
        Num8Label.setToolTipText("");
        Num8Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num8Label.setOpaque(true);

        StopLabel.setBackground(new java.awt.Color(255,255,204));
        StopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StopLabel.setText("Stop");
        StopLabel.setToolTipText("");
        StopLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        StopLabel.setOpaque(true);

        PlusLabel.setBackground(new java.awt.Color(255,255,204));
        PlusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlusLabel.setText("+");
        PlusLabel.setToolTipText("");
        PlusLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PlusLabel.setOpaque(true);

        MinusLabel.setBackground(new java.awt.Color(255,255,204));
        MinusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinusLabel.setText("-");
        MinusLabel.setToolTipText("");
        MinusLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        MinusLabel.setOpaque(true);

        MultLabel.setBackground(new java.awt.Color(255,255,204));
        MultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MultLabel.setText("*");
        MultLabel.setToolTipText("");
        MultLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        MultLabel.setOpaque(true);

        DivideLabel.setBackground(new java.awt.Color(255,255,204));
        DivideLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DivideLabel.setText("/");
        DivideLabel.setToolTipText("");
        DivideLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        DivideLabel.setOpaque(true);

        Num9Label.setBackground(new java.awt.Color(255,255,204));
        Num9Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num9Label.setText("9");
        Num9Label.setToolTipText("");
        Num9Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num9Label.setOpaque(true);

        jSeparator2.setBackground(java.awt.Color.black);
        jSeparator2.setForeground(java.awt.Color.black);
        jSeparator2.setOpaque(true);

        Num0Label.setBackground(new java.awt.Color(255,255,204));
        Num0Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Num0Label.setText("0");
        Num0Label.setToolTipText("");
        Num0Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Num0Label.setOpaque(true);

        jLabel1.setText("Choose: SPACE");

        jLabel2.setText("Choose: Enter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Num9Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num0Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Num1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Num7Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Num4Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Num2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Num8Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Num5Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(StopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PlusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(MinusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(MultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(DivideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Display, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(10, 10, 10))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Display, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Num0Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Num3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Num8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num7Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num9Label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DivideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MinusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(347, 347, 347)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("Calculator");

        pack();
    }
    
    public synchronized static void NumberSelectEvent()
    {
        String content = display.getText();
        if(content.startsWith("Display") || content.startsWith("Invalid") || content.indexOf('=') != -1)
        {
            content = "";
            display.setBackground(java.awt.Color.black);
        }
        int temp = getHighlightedNumber();
        if(temp == 10)
        {
            String temp1 = HelperMethods.CalculateExpression(content);
            
            if(temp1 == null)
               content = "Invalid Expression: " + content;
            else
            {
                content = content + " = " + temp1;
                display.setBackground(Color.black);
            }
           
        }
        else
            content = content + Integer.toString(getHighlightedNumber());
        display.setText(content);
    }
   
    public synchronized static void FunctionSelectEvent()
    {
        String content = display.getText();
        if(content.indexOf("=") != -1)
        {
            content = content.substring(content.indexOf('=')+2);
        }
        if(content.startsWith("Display") || content.startsWith("Invalid"))
            content = "";
        int function = getHighlightedFunction();
        if(function == 1)
            content += '+';
        else if(function == 2)
            content += '-';
        else if(function == 3)
            content += '*';
        else if(function == 4)
            content += '/';
        else
            content = "Invalid: Function selected is invalid";
        display.setText(content);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
        
    }


    private javax.swing.JLabel Display;
    private javax.swing.JLabel DivideLabel;
    private javax.swing.JLabel MinusLabel;
    private javax.swing.JLabel MultLabel;
    private javax.swing.JLabel Num0Label;
    private javax.swing.JLabel Num1Label;
    private javax.swing.JLabel Num2Label;
    private javax.swing.JLabel Num3Label;
    private javax.swing.JLabel Num4Label;
    private javax.swing.JLabel Num5Label;
    private javax.swing.JLabel Num6Label;
    private javax.swing.JLabel Num7Label;
    private javax.swing.JLabel Num8Label;
    private javax.swing.JLabel Num9Label;
    private javax.swing.JLabel PlusLabel;
    private javax.swing.JLabel StopLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;


    private static javax.swing.JLabel[] numbersLabels;
    private static javax.swing.JLabel[] functionsLabels;
    private volatile static int highlightedNumber;
    private volatile static int highlightedFunction;
    private static javax.swing.JLabel display;
    

    public static int getHighlightedNumber()
    {
        return highlightedNumber;
    }
    
    public static int getHighlightedFunction()
    {
        return highlightedFunction;
    }
    
    public static void setNumberColor(int labelNumber, java.awt.Color c)
    {
        try
        {
            highlightedNumber = labelNumber;
            numbersLabels[labelNumber].setBackground(c);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    

    public static void setFunctionColor(int labelNumber, java.awt.Color c)
    {
        try
        {
            highlightedFunction = labelNumber+1;
            functionsLabels[labelNumber].setBackground(c);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
