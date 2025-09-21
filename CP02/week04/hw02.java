package homework.handout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame {
    private static final int SCISSORS = 0;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int CHOICES_COUNT = 3;
    private static final String[] CHOICES = {"가위", "바위", "보"};
    private static final Color USER_COLOR = Color.ORANGE;
    private static final Color COMPUTER_COLOR = Color.RED;

    private final JPanel contentPane;
    private final JButton[] userButtons = new JButton[CHOICES_COUNT];
    private final JButton[] computerButtons = new JButton[CHOICES_COUNT];
    private JLabel resultLabel;
    private int userChoice;
    private int computerChoice;

    public RockPaperScissors() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        addLabel("가위 바위 보 게임", new Font("굴림", Font.PLAIN, 20), 140, 10, 189, 30);
        addLabel("VS", new Font("굴림", Font.PLAIN, 30), 198, 101, 72, 42);
        addLabel("사용자", new Font("굴림", Font.PLAIN, 14), 53, 217, 57, 15);
        addLabel("컴퓨터", new Font("굴림", Font.PLAIN, 14), 330, 211, 57, 15);

        for (int i = 0; i < CHOICES_COUNT; i++) {
	//TODO: user 버튼과 computer 버튼을 생성하고, user 버튼에 이벤트 리스너 등록
            userButtons[i] = createButton(CHOICES[i], 50,50+ (i*50), 100, 30);
            computerButtons[i] = createButton(CHOICES[i],280, 50+(i*50), 100, 30);
            userButtons[i].addActionListener(new UserButtonListener());
        }

        resultLabel = new JLabel("결과");
        resultLabel.setBounds(200, 240, 100, 15);
        contentPane.add(resultLabel);
    }

    private void addLabel(String text, Font font, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        contentPane.add(label);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        contentPane.add(button);
        return button;
    }

    private void updateButtonColors(JButton[] buttons, int selectedIndex, Color color) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(i == selectedIndex ? color : null);
        }
    }

    private void determineWinner() {
        if (userChoice == computerChoice) {
            resultLabel.setText("무승부");
        } else if (computerChoice == (userChoice + 1) % CHOICES_COUNT) {
            resultLabel.setText("컴퓨터 승리");
        } else {
            resultLabel.setText("사용자 승리");
        }

        if(userChoice == computerChoice) {
            resultLabel.setText("무승부");
        } else if ((userChoice == ROCK && computerChoice == SCISSORS) ||
                (userChoice == PAPER && computerChoice == ROCK) ||
                (userChoice == SCISSORS && computerChoice == PAPER)) {
            resultLabel.setText("사용자 승리");
        } else {
            resultLabel.setText("컴퓨터 승리");
        }
    }

    private class UserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < CHOICES_COUNT; i++) {
                   //TODO: 이벤트 소스가 어떤 버튼인지 확인하고, userCoice에 하나의 값 할당
                if(e.getSource() == userButtons[i]){
                    userChoice = i;
                    break;

                }
            }
            computerChoice = (int) (Math.random() * CHOICES_COUNT);

            updateButtonColors(userButtons, userChoice, USER_COLOR);
            updateButtonColors(computerButtons, computerChoice, COMPUTER_COLOR);

            determineWinner();

        }
    }

    public static void main(String[] args) { new RockPaperScissors(); }
}
