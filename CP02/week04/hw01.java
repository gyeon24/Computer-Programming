package homework.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorFrame extends JFrame implements ActionListener {
    private JTextField outputText = new JTextField(20);
    private JPanel p1, p2, p3, p_final;
    private String[] labels = {
            "7", "8", "9", "/",
            "4", "5", "6", "x",
            "1", "2", "3", "-",
            "0", "back", "=", "+"
    };

    private int state = 0; // 0: 아무 것도 없는 상태, 1: 좌측 operand 입력 시작, 2: 숫자와 operator가 입력된 상태
    private JLabel alarm;

    private int operand1, operand2;
    private String operator;

    public CalculatorFrame() {
        setTitle("My Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 4, 5, 5));
        p2.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        p3 = new JPanel();
        p3.setLayout(new GridLayout(4, 0, 5, 5));
        p3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p_final = new JPanel();
        p_final.setLayout(new BorderLayout());

        alarm = new JLabel();
        alarm.setText("Welcome!");
        p1.add(alarm, "North");
        p1.add(outputText);
        JButton b_c = new JButton("C");
        b_c.addActionListener(this);
       //TODO: 버튼 b_c에 이벤트 리스너를 등록
        

        p2.add(b_c);
        for (String s : labels){
            JButton b = new JButton(s);
            b.addActionListener(this);
            //TODO: 버튼 b에 이벤트리스너 등록
            

            p3.add(b);
        }

        p_final.add(p1, BorderLayout.NORTH);
        p_final.add(p2, BorderLayout.CENTER);
        p_final.add(p3, BorderLayout.SOUTH);
        add(p_final);
        pack();
        setVisible(true);
    }

    public static boolean isNumeric(String str) {
        if (str.length() != 1) {
            return false; // 문자열의 길이가 1이 아니면 숫자가 아님
        }
        char c = str.charAt(0);
        return Character.isDigit(c);
    }

    public void clear(){     // 초기화 함수 
        alarm.setText("Cleared!");
        outputText.setText("");
        operand1 = 0;
        operand2 = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: 이벤트 소스를 얻어서 srcButton에 할당

        JButton srcButton = (JButton) e.getSource();
        String btnText = srcButton.getText();

        alarm.setText("처리 진행 중");
        System.out.println("state: "+state+" operand: "+ operand1);
        if(btnText.equals("C")){
            clear();
            state = 0;
            return;
        }

        if(state==0){
            if(!isNumeric(btnText)){     // 아무 것도 없을 때 숫자가 아닌 다른 걸 입력하면 경고 출력
                alarm.setText("숫자 입력이 필요합니다.");
                return;
            }
            else{     // 숫자 하나를 입력하는 경우 숫자 입력을 계속 받는 상태인 state 1로 이동
                operand1 = Integer.parseInt(btnText);
                state = 1;
                outputText.setText(outputText.getText() + btnText);
                return;
            }
        }

        else if(state==1){
            if(btnText.equals("=")){     // 숫자가 있는 상태에서 = 을 입력하면 아무 일도 하지 않음
                return;
            }
            else if(btnText.equals("back")){     // back 버튼을 누르면 operand1을 10으로 나누어 자리수를 하나씩 지우고, 하나 남은 숫자를 지운 경우 글자를 모두 지우고 state 0으로 변경
                operand1 = operand1 / 10;
                if (outputText.getText().length() > 1) {
                    outputText.setText(outputText.getText().substring(0, outputText.getText().length() - 1));
                }else{
                    outputText.setText("");
                    operand1 = 0;
                    state = 0;
                }
            }
            else if(!isNumeric(btnText)){     // 숫자가 아닌 operator(+, -, /, x)가 입력되면 operator를 저장하고 state 2로 변경
                operator = btnText;
                state = 2;
                outputText.setText(outputText.getText() + btnText);
                return;
            }
            else{    
	            int btnNumber = Integer.parseInt(btnText);
                // TODO: 숫자가 계속 입력되는 경우 operand1에 10을 곱해서 입력된 숫자를 더해주고, outputText에 입력되는 모든 숫자 표현

                operand1 = operand1*10 + btnNumber;
                outputText.setText(String.valueOf(operand1));

            }
        }

        else if(state==2){
            if(btnText.equals("back")){     // back 버튼을 누르면 operand2를 10으로 나누어 자리수를 하나씩 지우고,
                // operand2가 없는 상태에서 지운 경우 operator를 지우고 state 1으로 변경
                if(operand2==0 && !Character.isDigit(outputText.getText().charAt(outputText.getText().length()-1))){
                    operator = "";
                    state = 1;
                }

                operand2 = operand2 / 10;
                outputText.setText(outputText.getText().substring(0, outputText.getText().length() - 1));
            }
            else if(!isNumeric(btnText) && !Character.isDigit(outputText.getText().charAt(outputText.getText().length()-1))){
                alarm.setText("숫자 입력이 필요합니다.");
            }
            else if (!isNumeric(btnText)){
                int result = 0;
	    // TODO: 숫자 두 개가 있을 때, 추가적인 연산자가 들어오는 경우 입력된 숫자 두 개와 연산자를 이용해 계산을 먼저 수행하고 다음 연산 처리
                try{
                    switch(operator){
                        case "+" :
                            operand1 = operand1 + operand2;
                            break;
                        case "-" :
                            operand1 = operand1 - operand2;
                            break;
                        case "x" :
                            operand1 = operand1 * operand2;
                            break;
                        case "/" :
                            if(operand2 == 0){
                                throw new ArithmeticException();
                            }
                            operand1 = operand1 / operand2;
                            break;
                        default:
                            return;
                    }
                    operand2 = 0;
                    state = 1;

                } catch(ArithmeticException ex){
                    outputText.setText("");
                    outputText.setText("unresolvable");
                    operand1 = 0;
                    operand2 = 0;
                    state = 0;
                    return;
                }

                if(btnText.equals("=")){
                    outputText.setText(Integer.toString(operand1));
                    state = 1;
                    return;
                }

                if(btnText.equals("-") || btnText.equals("+") || btnText.equals("/") || btnText.equals("x")){     // 연산자가 입력된 경우, 앞의 계산에 연산자가 추가로 입력되었다 가정 후 state 2로 이동
                    state = 2;
                    operator = btnText;
                    outputText.setText(result+btnText);
                }else{      // btnText: "=",    = 이 입력된 경우, 계산 결과만 출력 후 숫자 추가 입력 혹은 operator 입력을 위한 state1로 이동
                    state = 1;
                    outputText.setText(""+result);
                }
            }
            else{
                int btnNumber = Integer.parseInt(btnText);
                operand2 = operand2 * 10 + btnNumber;
                outputText.setText(outputText.getText() + btnText);
            }
        }
    }
}

public class MyCalculator {
    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
