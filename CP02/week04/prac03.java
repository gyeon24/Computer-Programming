package practice.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private static final int SCISSORS = 0, ROCK = 1, PAPER = 2;
    private static final int CHOICES_COUNT = 3;
    private final JPanel panel;
    private final JLabel output, information;
    private final JButton rockButton, paperButton, scissorsButton;

    public RockPaperScissors() {
        setTitle("가위바위보 게임");
        setSize(400, 150);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, CHOICES_COUNT));	// 그리드 배치 관리자 선택

        information = new JLabel("아래의 버튼 중에서 하나를 클릭하시오!");
        output = new JLabel("Good Luck!");

        rockButton = createButton("src/practice/handout/images/rock.png", "바위");
        paperButton = createButton("src/practice/handout/images/paper.png", "보");
        scissorsButton = createButton("src/practice/handout/images/scissors.png", "가위");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        panel.add(rockButton); panel.add(paperButton); panel.add(scissorsButton);

        add(information, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(output, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	// 아래 createButton() 메소드를 완성하시오.
    private JButton createButton(String imageName, String altText) {
		JButton button = new JButton();
        ImageIcon icon = new ImageIcon(imageName);
        button.setIcon(icon);
        button.setText(altText);

        return button;
    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }

    public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();

        int userChoice = getUserChoice(clickedButton);
        int computerChoice = getComputerChoice();
        displayResult(userChoice, computerChoice);
    }

    private int getUserChoice(JButton clickedButton) {
        if (clickedButton == rockButton) {
            return ROCK;
        }
		else if (clickedButton == paperButton) {
            return PAPER;
        }
        else if (clickedButton == scissorsButton) {
            return SCISSORS;
        }
        return -1;
    }

	// 컴퓨터의 선택을 반환하는 메소드
    private int getComputerChoice() {
        return new Random().nextInt(CHOICES_COUNT);
    }

    private void displayResult(int userChoice, int computerChoice) {
        String result;
        if (userChoice == computerChoice) {
            result = "비겼습니다!";
        } else if ((userChoice == ROCK && computerChoice == SCISSORS) ||
                (userChoice == PAPER && computerChoice == ROCK) ||
                (userChoice == SCISSORS && computerChoice == PAPER)) {
            result = "인간 승리";
        } else {
            result = "컴퓨터 승리";
        }

        String userChoiceStr = getChoiceString(userChoice);
        String computerChoiceStr = getChoiceString(computerChoice);
        output.setText("인간: "+userChoiceStr+", 컴퓨터: "+computerChoiceStr+" => "+result);
    }

    private String getChoiceString(int choice) {
        switch (choice) {
            case ROCK: return "바위";
            case PAPER: return "보";
            case SCISSORS: return "가위";
            default: return "";
        }
    }
}