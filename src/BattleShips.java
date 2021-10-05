import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

class BattleShips extends JFrame {

    final String TITLE_OF_PROGRAM = "Морской бой";
    final int AI_PANEL_SIZE = 500;
    final int HUMAN_PANEL_SIZE = AI_PANEL_SIZE / 2;
    final String BTN_INIT = "Новая игра";
    final String BTN_RULES = "Правила";


    JTextArea board;
    Canvas leftPanel, humanPanel;


    BattleShips() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        leftPanel = new Canvas();
        leftPanel.setPreferredSize(new Dimension(AI_PANEL_SIZE, AI_PANEL_SIZE));
        leftPanel.setBackground(Color.white);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        leftPanel.addMouseListener(new MouseAdapter() {

        });

        humanPanel = new Canvas();
        humanPanel.setPreferredSize(new Dimension(HUMAN_PANEL_SIZE, HUMAN_PANEL_SIZE));
        humanPanel.setBackground(Color.white);
        humanPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton init = new JButton(BTN_INIT);
        init.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPanel.repaint();
                humanPanel.repaint();
            }
        });


        board = new JTextArea();
        board.setEditable(false);
        JScrollPane scroll = new JScrollPane(board);

        JFrame rulesFrame = new JFrame();
        JTextArea setOfRules = new JTextArea();
        setOfRules.setEditable(false);
        setOfRules.setLineWrap(true);
        setOfRules.setWrapStyleWord(true);
        rulesFrame.setSize(new Dimension(300, 200));
        rulesFrame.setResizable(false);
        setOfRules.setText("Правила: \nПри нажатии на кнопку 'Новая игра' ваши корабли размещаются случайным образом (в правом верхнем окне), ровно как и корабли противника (левое окно). \nЛКМ - выстрел\nПКМ - отметить клетку");
        rulesFrame.add(setOfRules);
        rulesFrame.setLocationRelativeTo(null);
        JButton rules = new JButton(BTN_RULES);

        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesFrame.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.add(init);
        buttonPanel.add(rules);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        rightPanel.add(humanPanel, BorderLayout.NORTH);
        rightPanel.add(scroll, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);


        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(leftPanel);
        add(rightPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }

    class Canvas extends JPanel {

    }

    public static void main(String[] args) {
        new BattleShips();
    }

}
