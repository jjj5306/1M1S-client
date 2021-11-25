package signUpPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import db.*;

public class signUpPage extends JFrame {
    private Long interest_selected = Long.parseLong(Integer.toString(0)); //유저 관심 분야, 순서대로 운동, 프로그래밍, 취업
    private final Font BigFont = new Font("나눔고딕", Font.PLAIN, 30);
    private final Font mainFont = new Font("나눔고딕", Font.PLAIN, 20);
    private final myPanel1 panel1 = new myPanel1();
    private final myPanel2 panel2 = new myPanel2();
    private final myPanel3 panelExercise1 = new myPanel3();
    private final myPanel3 panelExercise2 = new myPanel3();
    private final myPanel3 panelPrograming1 = new myPanel3();
    private final myPanel3 panelPrograming2 = new myPanel3();
    private final myPanel3 panelEmploy1 = new myPanel3();
    private final myPanel3 panelEmploy2 = new myPanel3();

    public signUpPage() {
        //프레임 설정
        setVisible(true);
        setTitle("1M1S");
        add(panel1);
        add(panel2);
        add(panelExercise1);
        add(panelExercise2);
        add(panelPrograming1);
        add(panelPrograming2);
        add(panelEmploy1);
        add(panelEmploy2);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        //x누르면 현재 프레임만 끔
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //****************************************************************************************************************************************************************

        //패널 설정
        //패널1에서 회원가입 기본 정보입력 받기
        panel1.setSize(1100, 824);
        panel1.setLayout(null);
        panel1.setVisible(true);
        //패널2에서 관심분야 선택
        panel2.setSize(1100, 824);
        panel2.setLayout(null);
        panel2.setVisible(false);
        //운동 분야 설문조사 패널
        panelExercise1.setSize(1100, 824);
        panelExercise1.setLayout(null);
        panelExercise1.setVisible(false);
        panelExercise2.setSize(1100, 824);
        panelExercise2.setLayout(null);
        panelExercise2.setVisible(false);
        //프로그래밍 분야 설문조사 패널
        panelPrograming1.setSize(1100, 824);
        panelPrograming1.setLayout(null);
        panelPrograming1.setVisible(false);
        panelPrograming2.setSize(1100, 824);
        panelPrograming2.setLayout(null);
        panelPrograming2.setVisible(false);
        //취업준비 설문조사 패널
        panelEmploy1.setSize(1100, 824);
        panelEmploy1.setLayout(null);
        panelEmploy1.setVisible(false);
        panelEmploy2.setSize(1100, 824);
        panelEmploy2.setLayout(null);
        panelEmploy2.setVisible(false);

        //****************************************************************************************************************************************************************

        //패널1
        //패널1 되돌아가기 버튼
        JButton rollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        rollBackButton.addActionListener(e -> dispose());
        rollBackButton.setFont(mainFont);
        rollBackButton.setBounds(155, 105, 80, 80);
        rollBackButton.setContentAreaFilled(false);
        panel1.add(rollBackButton);

        //이름 입력받기
        Label nameLabel = new Label();
        nameLabel.setText("Name");
        nameLabel.setFont(mainFont);
        nameLabel.setBounds(320, 200, 60, 30);
        panel1.add(nameLabel);
        TextField nameText = new TextField();
        nameText.setFont(mainFont);
        nameText.setBounds(390, 200, 100, 30);
        panel1.add(nameText);

        //성별 입력받기
        JCheckBox manBox = new JCheckBox();
        manBox.setText("man");
        manBox.setFont(mainFont);
        manBox.setBounds(580, 200, 70, 30);
        panel1.add(manBox);
        JCheckBox womanBox = new JCheckBox();
        womanBox.setText("woman");
        womanBox.setFont(mainFont);
        womanBox.setBounds(660, 200, 97, 30);
        panel1.add(womanBox);

        //닉네임 입력받기
        Label nicknameLabel = new Label();
        nicknameLabel.setText("Nickname : ");
        nicknameLabel.setFont(mainFont);
        nicknameLabel.setBounds(320, 260, 95, 30);
        panel1.add(nicknameLabel);
        TextField nickNameText = new TextField();
        nickNameText.setFont(mainFont);
        nickNameText.setBounds(430, 260, 100, 30);
        panel1.add(nickNameText);

        //이메일 입력받기
        Label emailIdLabel = new Label();
        emailIdLabel.setText("E-mail");
        emailIdLabel.setFont(mainFont);
        emailIdLabel.setBounds(320, 320, 70, 30);
        panel1.add(emailIdLabel);
        TextField emailText = new TextField();
        emailText.setFont(mainFont);
        emailText.setBounds(400, 320, 300, 30);
        panel1.add(emailText);

        //아이디 입력받기
        Label userIdLabel = new Label();
        userIdLabel.setText("User ID");
        userIdLabel.setFont(mainFont);
        userIdLabel.setBounds(320, 380, 70, 30);
        panel1.add(userIdLabel);
        TextField userIdText = new TextField();
        userIdText.setFont(mainFont);
        userIdText.setBounds(400, 380, 100, 30);
        panel1.add(userIdText);

        //비밀번호
        Label passwdLabel = new Label();
        passwdLabel.setText("PASSWORD");
        passwdLabel.setFont(mainFont);
        passwdLabel.setBounds(320, 440, 125, 30);
        panel1.add(passwdLabel);
        TextField passwdText = new TextField();
        passwdText.setFont(mainFont);
        passwdText.setBounds(460, 440, 220, 30);
        passwdText.setEchoChar('*');
        panel1.add(passwdText);

        //비밀번호 확인
        Label passwd2Label = new Label();
        passwd2Label.setText("PASSWORD Check");
        passwd2Label.setFont(mainFont);
        passwd2Label.setBounds(320, 500, 190, 30);
        panel1.add(passwd2Label);
        TextField passwd2Text = new TextField();
        passwd2Text.setFont(mainFont);
        passwd2Text.setBounds(525, 500, 220, 30);
        passwd2Text.setEchoChar('*');
        panel1.add(passwd2Text);

        //제출 버튼 누른 후 아래의 사항들 체크
            //필드별 빈칸
            //성별 두 개 선택했는지 체크
            //아이디, 닉네임, 폰, 이메일 중복체크
            //확인, 비밀번호, 비밀번호 확인 같은지 체크
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            //각 칸마다 빈칸이 있는지 체크
            if (nameText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (!manBox.isSelected() && !womanBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "성별을 선택해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (manBox.isSelected() && womanBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "성별은 하나만 선택해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (emailText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (userIdText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (passwdText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (passwd2Text.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (!passwdText.getText().equals(passwd2Text.getText())) {
                JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인이 일치하지 않습니다.", "Message", JOptionPane.ERROR_MESSAGE);
                passwdText.setText("");
                passwd2Text.setText("");
            } else {
                //기본 인적 사항 서버로 전송
                ObjectMapper objectMapper = new ObjectMapper();
                MemberInformation memberInformation = new MemberInformation(nameText.getText(), nickNameText.getText(), emailText.getText(), manBox.isSelected(), userIdText.getText(), passwdText.getText());

                try {
                    String requestBody = objectMapper.writeValueAsString(memberInformation);
                    System.out.println(requestBody);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
                //다음 패널로 이동
                panel1.setVisible(false);
                panel2.setVisible(true);
            }
        });
        nextButton.setFont(mainFont);
        nextButton.setBounds(550, 600, 120, 50);
        panel1.add(nextButton);
        //이메일 포맷확인은 보류

        //****************************************************************************************************************************************************************

        //패널 2 - 관심분야 선택
        //안내 글
        JLabel text = new JLabel();
        text.setText("관심 분야를 선택해주세요!");
        text.setFont(BigFont);
        text.setBounds(300 ,180, 500, 70);
        panel2.add(text);

        //운동 선택 버튼
        JButton exerciseButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\exercise.png")));
        exerciseButton.addActionListener(e -> {
            //panelExercise로 전환
            panel2.setVisible(false);
            panelExercise1.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(1));
        });
        exerciseButton.setFont(mainFont);
        exerciseButton.setBounds(300, 310, 150, 150);
        exerciseButton.setContentAreaFilled(false);
        panel2.add(exerciseButton);
        JLabel exerciseLabel = new JLabel();
        exerciseLabel.setText("운동");
        exerciseLabel.setFont(mainFont);
        exerciseLabel.setBounds(355, 470, 60, 30);
        panel2.add(exerciseLabel);

        //프로그래밍 선택 버튼
        JButton programingButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\programing.png")));
        programingButton.addActionListener(e -> {
            //panelPrograming로 전환
            panel2.setVisible(false);
            panelPrograming1.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(2));
        });
        programingButton.setFont(mainFont);
        programingButton.setBounds(480, 310, 150, 150);
        programingButton.setContentAreaFilled(false);
        panel2.add(programingButton);
        JLabel programingLabel = new JLabel();
        programingLabel.setText("프로그래밍");
        programingLabel.setFont(mainFont);
        programingLabel.setBounds(505, 470, 150, 30);
        panel2.add(programingLabel);

        //취업 선택 버튼
        JButton employButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\employ.png")));
        employButton.addActionListener(e -> {
            //panelEmploy로 전환
            panel2.setVisible(false);
            panelEmploy1.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(3));
        });
        employButton.setFont(mainFont);
        employButton.setBounds(660, 310, 150, 150);
        employButton.setContentAreaFilled(false);
        panel2.add(employButton);
        JLabel employLabel = new JLabel();
        employLabel.setText("취업 준비");
        employLabel.setFont(mainFont);
        employLabel.setBounds(695, 470, 120, 30);
        panel2.add(employLabel);

        //****************************************************************************************************************************************************************

        //각 관심분야별 패널 부분
        //운동 패널 - 설문조사 1
        //서버에 유저 정보를 넘겨주고 다시 user_id만 받아서 사용
        Long user_id = Long.parseLong(Integer.toString(1));
        //관심분야 선택 전으로 돌아가기
        JButton exercise1RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        exercise1RollBackButton.addActionListener(e -> {
            panelExercise1.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        exercise1RollBackButton.setFont(mainFont);
        exercise1RollBackButton.setBounds(155, 105, 80, 80);
        exercise1RollBackButton.setContentAreaFilled(false);
        panelExercise1.add(exercise1RollBackButton);

        //설문조사의 질문과 선택지는 서버에서 api로 string을 받아서 사용한다.
        //설문조사 1
        JLabel exerciseSurvey1 = new JLabel();
        exerciseSurvey1.setText("질문 1");
        exerciseSurvey1.setFont(BigFont);
        exerciseSurvey1.setBounds(280, 120, 100, 70);
        panelExercise1.add(exerciseSurvey1);
        //이 부분도 api로 |로 구분된 string을 받는다.
        String str = "선택1_1|선택1_2|선택1_3";
        String[] ansarr = str.split("\\|");
        //설문조사 1의 선택지 1
        JCheckBox exerciseSurvey1Ans1 = new JCheckBox();
        exerciseSurvey1Ans1.setText(ansarr[0]);
        exerciseSurvey1Ans1.setFont(mainFont);
        exerciseSurvey1Ans1.setBounds(330, 190, 150, 50);
        exerciseSurvey1Ans1.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey1Ans1);
        //설문조사 1의 선택지 2
        JCheckBox exerciseSurvey1Ans2 = new JCheckBox();
        exerciseSurvey1Ans2.setText(ansarr[1]);
        exerciseSurvey1Ans2.setFont(mainFont);
        exerciseSurvey1Ans2.setBounds(500, 190, 150, 50);
        exerciseSurvey1Ans2.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey1Ans2);
        //설문조사 1의 선택지 3
        JCheckBox exerciseSurvey1Ans3 = new JCheckBox();
        exerciseSurvey1Ans3.setText(ansarr[2]);
        exerciseSurvey1Ans3.setFont(mainFont);
        exerciseSurvey1Ans3.setBounds(650, 190, 150, 50);
        exerciseSurvey1Ans3.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey1Ans3);

        //설문조사 2
        JLabel exerciseSurvey2 = new JLabel();
        exerciseSurvey2.setText("질문 2");
        exerciseSurvey2.setFont(BigFont);
        exerciseSurvey2.setBounds(280, 270, 100, 70);
        panelExercise1.add(exerciseSurvey2);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택2_1|선택2_2|선택2_3";
        ansarr = str.split("\\|");
        //설문조사 2의 선택지 1
        JCheckBox exerciseSurvey2Ans1 = new JCheckBox();
        exerciseSurvey2Ans1.setText(ansarr[0]);
        exerciseSurvey2Ans1.setFont(mainFont);
        exerciseSurvey2Ans1.setBounds(330, 340, 150, 50);
        exerciseSurvey2Ans1.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey2Ans1);
        //설문조사 2의 선택지 2
        JCheckBox exerciseSurvey2Ans2 = new JCheckBox();
        exerciseSurvey2Ans2.setText(ansarr[1]);
        exerciseSurvey2Ans2.setFont(mainFont);
        exerciseSurvey2Ans2.setBounds(500, 340, 150, 50);
        exerciseSurvey2Ans2.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey2Ans2);
        //설문조사 2의 선택지 3
        JCheckBox exerciseSurvey2Ans3 = new JCheckBox();
        exerciseSurvey2Ans3.setText(ansarr[2]);
        exerciseSurvey2Ans3.setFont(mainFont);
        exerciseSurvey2Ans3.setBounds(650, 340, 150, 50);
        exerciseSurvey2Ans3.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey2Ans3);

        //설문조사 3
        JLabel exerciseSurvey3 = new JLabel();
        exerciseSurvey3.setText("질문 3");
        exerciseSurvey3.setFont(BigFont);
        exerciseSurvey3.setBounds(280, 420, 100, 70);
        panelExercise1.add(exerciseSurvey3);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택3_1|선택3_2|선택3_3";
        ansarr = str.split("\\|");
        //설문조사 3의 선택지 1
        JCheckBox exerciseSurvey3Ans1 = new JCheckBox();
        exerciseSurvey3Ans1.setText(ansarr[0]);
        exerciseSurvey3Ans1.setFont(mainFont);
        exerciseSurvey3Ans1.setBounds(330, 490, 150, 50);
        exerciseSurvey3Ans1.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey3Ans1);
        //설문조사 3의 선택지 2
        JCheckBox exerciseSurvey3Ans2 = new JCheckBox();
        exerciseSurvey3Ans2.setText(ansarr[1]);
        exerciseSurvey3Ans2.setFont(mainFont);
        exerciseSurvey3Ans2.setBounds(500, 490, 150, 50);
        exerciseSurvey3Ans2.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey3Ans2);
        //설문조사 3의 선택지 3
        JCheckBox exerciseSurvey3Ans3 = new JCheckBox();
        exerciseSurvey3Ans3.setText(ansarr[2]);
        exerciseSurvey3Ans3.setFont(mainFont);
        exerciseSurvey3Ans3.setBounds(650, 490, 150, 50);
        exerciseSurvey3Ans3.setContentAreaFilled(false);
        panelExercise1.add(exerciseSurvey3Ans3);

        //다음 버튼
        JButton exercise1NextButton = new JButton();
        exercise1NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(exerciseSurvey1Ans1.isSelected()) flag++;
            if(exerciseSurvey1Ans2.isSelected()) flag++;
            if(exerciseSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey2Ans1.isSelected()) flag++;
                if (exerciseSurvey2Ans2.isSelected()) flag++;
                if (exerciseSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey3Ans1.isSelected()) flag++;
                if (exerciseSurvey3Ans2.isSelected()) flag++;
                if (exerciseSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelExercise1.setVisible(false);
                panelExercise2.setVisible(true);
            }
        });
        exercise1NextButton.setText("Next");
        exercise1NextButton.setFont(mainFont);
        exercise1NextButton.setBounds(700, 600, 80, 50);
        panelExercise1.add(exercise1NextButton);

        //현재 페이지 index 버튼
        JButton exercise1Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        exercise1Index1Button.addActionListener(e -> {
        });
        exercise1Index1Button.setFont(mainFont);
        exercise1Index1Button.setBounds(170, 185, 70, 50);
        exercise1Index1Button.setContentAreaFilled(false);
        panelExercise1.add(exercise1Index1Button);

        //다음 페이지 index 버튼
        JButton exercise1Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        exercise1Index2Button.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(exerciseSurvey1Ans1.isSelected()) flag++;
            if(exerciseSurvey1Ans2.isSelected()) flag++;
            if(exerciseSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey2Ans1.isSelected()) flag++;
                if (exerciseSurvey2Ans2.isSelected()) flag++;
                if (exerciseSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey3Ans1.isSelected()) flag++;
                if (exerciseSurvey3Ans2.isSelected()) flag++;
                if (exerciseSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelExercise1.setVisible(false);
                panelExercise2.setVisible(true);
            }
        });
        exercise1Index2Button.setFont(mainFont);
        exercise1Index2Button.setBounds(170, 235, 70, 50);
        exercise1Index2Button.setContentAreaFilled(false);
        panelExercise1.add(exercise1Index2Button);

        //운동 패널 - 설문조사 2
        //관심분야 선택 전으로 돌아가기
        JButton exercise2RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        exercise2RollBackButton.addActionListener(e -> {
            panelExercise2.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        exercise2RollBackButton.setFont(mainFont);
        exercise2RollBackButton.setBounds(155, 105, 80, 80);
        exercise2RollBackButton.setContentAreaFilled(false);
        panelExercise2.add(exercise2RollBackButton);

        //설문조사 4
        JLabel exerciseSurvey4 = new JLabel();
        exerciseSurvey4.setText("질문 4");
        exerciseSurvey4.setFont(BigFont);
        exerciseSurvey4.setBounds(280, 120, 100, 70);
        panelExercise2.add(exerciseSurvey4);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택4_1|선택4_2|선택4_3";
        ansarr = str.split("\\|");
        //설문조사 4의 선택지 1
        JCheckBox exerciseSurvey4Ans1 = new JCheckBox();
        exerciseSurvey4Ans1.setText(ansarr[0]);
        exerciseSurvey4Ans1.setFont(mainFont);
        exerciseSurvey4Ans1.setBounds(330, 190, 150, 50);
        exerciseSurvey4Ans1.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey4Ans1);
        //설문조사 4의 선택지 2
        JCheckBox exerciseSurvey4Ans2 = new JCheckBox();
        exerciseSurvey4Ans2.setText(ansarr[1]);
        exerciseSurvey4Ans2.setFont(mainFont);
        exerciseSurvey4Ans2.setBounds(500, 190, 150, 50);
        exerciseSurvey4Ans2.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey4Ans2);
        //설문조사 1의 선택지 3
        JCheckBox exerciseSurvey4Ans3 = new JCheckBox();
        exerciseSurvey4Ans3.setText(ansarr[2]);
        exerciseSurvey4Ans3.setFont(mainFont);
        exerciseSurvey4Ans3.setBounds(650, 190, 150, 50);
        exerciseSurvey4Ans3.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey4Ans3);

        //설문조사 5
        JLabel exerciseSurvey5 = new JLabel();
        exerciseSurvey5.setText("질문 5");
        exerciseSurvey5.setFont(BigFont);
        exerciseSurvey5.setBounds(280, 270, 100, 70);
        panelExercise2.add(exerciseSurvey5);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택5_1|선택5_2|선택5_3";
        ansarr = str.split("\\|");
        //설문조사 5의 선택지 1
        JCheckBox exerciseSurvey5Ans1 = new JCheckBox();
        exerciseSurvey5Ans1.setText(ansarr[0]);
        exerciseSurvey5Ans1.setFont(mainFont);
        exerciseSurvey5Ans1.setBounds(330, 340, 150, 50);
        exerciseSurvey5Ans1.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey5Ans1);
        //설문조사 5의 선택지 2
        JCheckBox exerciseSurvey5Ans2 = new JCheckBox();
        exerciseSurvey5Ans2.setText(ansarr[1]);
        exerciseSurvey5Ans2.setFont(mainFont);
        exerciseSurvey5Ans2.setBounds(500, 340, 150, 50);
        exerciseSurvey5Ans2.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey5Ans2);
        //설문조사 5의 선택지 3
        JCheckBox exerciseSurvey5Ans3 = new JCheckBox();
        exerciseSurvey5Ans3.setText(ansarr[2]);
        exerciseSurvey5Ans3.setFont(mainFont);
        exerciseSurvey5Ans3.setBounds(650, 340, 150, 50);
        exerciseSurvey5Ans3.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey5Ans3);

        //설문조사 6
        JLabel exerciseSurvey6 = new JLabel();
        exerciseSurvey6.setText("질문 6");
        exerciseSurvey6.setFont(BigFont);
        exerciseSurvey6.setBounds(280, 420, 100, 70);
        panelExercise2.add(exerciseSurvey6);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택6_1|선택6_2|선택6_3";
        ansarr = str.split("\\|");
        //설문조사 6의 선택지 1
        JCheckBox exerciseSurvey6Ans1 = new JCheckBox();
        exerciseSurvey6Ans1.setText(ansarr[0]);
        exerciseSurvey6Ans1.setFont(mainFont);
        exerciseSurvey6Ans1.setBounds(330, 490, 150, 50);
        exerciseSurvey6Ans1.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey6Ans1);
        //설문조사 6의 선택지 2
        JCheckBox exerciseSurvey6Ans2 = new JCheckBox();
        exerciseSurvey6Ans2.setText(ansarr[1]);
        exerciseSurvey6Ans2.setFont(mainFont);
        exerciseSurvey6Ans2.setBounds(500, 490, 150, 50);
        exerciseSurvey6Ans2.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey6Ans2);
        //설문조사 6의 선택지 3
        JCheckBox exerciseSurvey6Ans3 = new JCheckBox();
        exerciseSurvey6Ans3.setText(ansarr[2]);
        exerciseSurvey6Ans3.setFont(mainFont);
        exerciseSurvey6Ans3.setBounds(650, 490, 150, 50);
        exerciseSurvey6Ans3.setContentAreaFilled(false);
        panelExercise2.add(exerciseSurvey6Ans3);

        //최종 제출 버튼
        JButton exercise2NextButton = new JButton();
        exercise2NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(exerciseSurvey4Ans1.isSelected()) flag++;
            if(exerciseSurvey4Ans2.isSelected()) flag++;
            if(exerciseSurvey4Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey5Ans1.isSelected()) flag++;
                if (exerciseSurvey5Ans2.isSelected()) flag++;
                if (exerciseSurvey5Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (exerciseSurvey6Ans1.isSelected()) flag++;
                if (exerciseSurvey6Ans2.isSelected()) flag++;
                if (exerciseSurvey6Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (flag == 1) {
                //유저들의 레벨 관리, 임시로 1 설정
                Long exerciseLevel = Long.parseLong(Integer.toString(1));
                //관심분야 관련 사항 서버로 전송
                var userexerciseValues_exercise = new HashMap<String, Long>() {{
                    put("user_id", user_id);
                    put("interested_id", interest_selected);
                    put("level", exerciseLevel);
                }};
                var userexerciseValues_exercise_objectMapper = new ObjectMapper();
                try {
                    String requestBody = userexerciseValues_exercise_objectMapper.writeValueAsString(userexerciseValues_exercise);
                    System.out.println(requestBody);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                dispose();
            }

        });
        exercise2NextButton.setText("Final Submit");
        exercise2NextButton.setFont(mainFont);
        exercise2NextButton.setBounds(620, 600, 160, 50);
        panelExercise2.add(exercise2NextButton);

        //이전 페이지 index 버튼
        JButton exercise2Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        exercise2Index1Button.addActionListener(e -> {
            panelExercise2.setVisible(false);
            panelExercise1.setVisible(true);
        });
        exercise2Index1Button.setFont(mainFont);
        exercise2Index1Button.setBounds(170, 185, 70, 50);
        exercise2Index1Button.setContentAreaFilled(false);
        panelExercise2.add(exercise2Index1Button);

        //현재 페이지 index 버튼
        JButton exercise2Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        exercise2Index2Button.addActionListener(e -> {
        });
        exercise2Index2Button.setFont(mainFont);
        exercise2Index2Button.setBounds(170, 235, 70, 50);
        exercise2Index2Button.setContentAreaFilled(false);
        panelExercise2.add(exercise2Index2Button);

        //****************************************************************************************************************************************************************

        //프로그래밍 패널 - 설문조사 1
        //관심분야 선택 전으로 돌아가기
        JButton programingRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        programingRollBackButton.addActionListener(e -> {
            panelPrograming1.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        programingRollBackButton.setFont(mainFont);
        programingRollBackButton.setBounds(155, 105, 80, 80);
        programingRollBackButton.setContentAreaFilled(false);
        panelPrograming1.add(programingRollBackButton);

        //설문조사의 질문과 선택지는 서버에서 api로 string을 받아서 사용한다.
        //설문조사 1
        JLabel programingSurvey1 = new JLabel();
        programingSurvey1.setText("질문 1");
        programingSurvey1.setFont(BigFont);
        programingSurvey1.setBounds(280, 120, 100, 70);
        panelPrograming1.add(programingSurvey1);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택1_1|선택1_2|선택1_3";
        ansarr = str.split("\\|");
        //설문조사 1의 선택지 1
        JCheckBox programingSurvey1Ans1 = new JCheckBox();
        programingSurvey1Ans1.setText(ansarr[0]);
        programingSurvey1Ans1.setFont(mainFont);
        programingSurvey1Ans1.setBounds(330, 190, 150, 50);
        programingSurvey1Ans1.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey1Ans1);
        //설문조사 1의 선택지 2
        JCheckBox programingSurvey1Ans2 = new JCheckBox();
        programingSurvey1Ans2.setText(ansarr[1]);
        programingSurvey1Ans2.setFont(mainFont);
        programingSurvey1Ans2.setBounds(500, 190, 150, 50);
        programingSurvey1Ans2.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey1Ans2);
        //설문조사 1의 선택지 3
        JCheckBox programingSurvey1Ans3 = new JCheckBox();
        programingSurvey1Ans3.setText(ansarr[2]);
        programingSurvey1Ans3.setFont(mainFont);
        programingSurvey1Ans3.setBounds(650, 190, 150, 50);
        programingSurvey1Ans3.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey1Ans3);

        //설문조사 2
        JLabel programingSurvey2 = new JLabel();
        programingSurvey2.setText("질문 2");
        programingSurvey2.setFont(BigFont);
        programingSurvey2.setBounds(280, 270, 100, 70);
        panelPrograming1.add(programingSurvey2);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택2_1|선택2_2|선택2_3";
        ansarr = str.split("\\|");
        //설문조사 2의 선택지 1
        JCheckBox programingSurvey2Ans1 = new JCheckBox();
        programingSurvey2Ans1.setText(ansarr[0]);
        programingSurvey2Ans1.setFont(mainFont);
        programingSurvey2Ans1.setBounds(330, 340, 150, 50);
        programingSurvey2Ans1.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey2Ans1);
        //설문조사 2의 선택지 2
        JCheckBox programingSurvey2Ans2 = new JCheckBox();
        programingSurvey2Ans2.setText(ansarr[1]);
        programingSurvey2Ans2.setFont(mainFont);
        programingSurvey2Ans2.setBounds(500, 340, 150, 50);
        programingSurvey2Ans2.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey2Ans2);
        //설문조사 2의 선택지 3
        JCheckBox programingSurvey2Ans3 = new JCheckBox();
        programingSurvey2Ans3.setText(ansarr[2]);
        programingSurvey2Ans3.setFont(mainFont);
        programingSurvey2Ans3.setBounds(650, 340, 150, 50);
        programingSurvey2Ans3.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey2Ans3);

        //설문조사 3
        JLabel programingSurvey3 = new JLabel();
        programingSurvey3.setText("질문 3");
        programingSurvey3.setFont(BigFont);
        programingSurvey3.setBounds(280, 420, 100, 70);
        panelPrograming1.add(programingSurvey3);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택3_1|선택3_2|선택3_3";
        ansarr = str.split("\\|");
        //설문조사 3의 선택지 1
        JCheckBox programingSurvey3Ans1 = new JCheckBox();
        programingSurvey3Ans1.setText(ansarr[0]);
        programingSurvey3Ans1.setFont(mainFont);
        programingSurvey3Ans1.setBounds(330, 490, 150, 50);
        programingSurvey3Ans1.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey3Ans1);
        //설문조사 3의 선택지 2
        JCheckBox programingSurvey3Ans2 = new JCheckBox();
        programingSurvey3Ans2.setText(ansarr[1]);
        programingSurvey3Ans2.setFont(mainFont);
        programingSurvey3Ans2.setBounds(500, 490, 150, 50);
        programingSurvey3Ans2.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey3Ans2);
        //설문조사 3의 선택지 3
        JCheckBox programingSurvey3Ans3 = new JCheckBox();
        programingSurvey3Ans3.setText(ansarr[2]);
        programingSurvey3Ans3.setFont(mainFont);
        programingSurvey3Ans3.setBounds(650, 490, 150, 50);
        programingSurvey3Ans3.setContentAreaFilled(false);
        panelPrograming1.add(programingSurvey3Ans3);

        //다음 버튼
        JButton programing1NextButton = new JButton();
        programing1NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(programingSurvey1Ans1.isSelected()) flag++;
            if(programingSurvey1Ans2.isSelected()) flag++;
            if(programingSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey2Ans1.isSelected()) flag++;
                if (programingSurvey2Ans2.isSelected()) flag++;
                if (programingSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey3Ans1.isSelected()) flag++;
                if (programingSurvey3Ans2.isSelected()) flag++;
                if (programingSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelPrograming1.setVisible(false);
                panelPrograming2.setVisible(true);
            }
        });
        programing1NextButton.setText("Next");
        programing1NextButton.setFont(mainFont);
        programing1NextButton.setBounds(700, 600, 80, 50);
        panelPrograming1.add(programing1NextButton);

        //현재 페이지 index 버튼
        JButton programing1Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        programing1Index1Button.addActionListener(e -> {
        });
        programing1Index1Button.setFont(mainFont);
        programing1Index1Button.setBounds(170, 185, 70, 50);
        programing1Index1Button.setContentAreaFilled(false);
        panelPrograming1.add(programing1Index1Button);

        //다음 페이지 index 버튼
        JButton programing1Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        programing1Index2Button.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(programingSurvey1Ans1.isSelected()) flag++;
            if(programingSurvey1Ans2.isSelected()) flag++;
            if(programingSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey2Ans1.isSelected()) flag++;
                if (programingSurvey2Ans2.isSelected()) flag++;
                if (programingSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey3Ans1.isSelected()) flag++;
                if (programingSurvey3Ans2.isSelected()) flag++;
                if (programingSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelPrograming1.setVisible(false);
                panelPrograming2.setVisible(true);
            }
        });
        programing1Index2Button.setFont(mainFont);
        programing1Index2Button.setBounds(170, 235, 70, 50);
        programing1Index2Button.setContentAreaFilled(false);
        panelPrograming1.add(programing1Index2Button);

        //프로그래밍 패널 - 설문조사 2
        //관심분야 선택 전으로 돌아가기
        JButton programing2RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        programing2RollBackButton.addActionListener(e -> {
            panelPrograming2.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        programing2RollBackButton.setFont(mainFont);
        programing2RollBackButton.setBounds(155, 105, 80, 80);
        programing2RollBackButton.setContentAreaFilled(false);
        panelPrograming2.add(programing2RollBackButton);

        //설문조사 4
        JLabel programingSurvey4 = new JLabel();
        programingSurvey4.setText("질문 4");
        programingSurvey4.setFont(BigFont);
        programingSurvey4.setBounds(280, 120, 100, 70);
        panelPrograming2.add(programingSurvey4);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택4_1|선택4_2|선택4_3";
        ansarr = str.split("\\|");
        //설문조사 4의 선택지 1
        JCheckBox programingSurvey4Ans1 = new JCheckBox();
        programingSurvey4Ans1.setText(ansarr[0]);
        programingSurvey4Ans1.setFont(mainFont);
        programingSurvey4Ans1.setBounds(330, 190, 150, 50);
        programingSurvey4Ans1.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey4Ans1);
        //설문조사 4의 선택지 2
        JCheckBox programingSurvey4Ans2 = new JCheckBox();
        programingSurvey4Ans2.setText(ansarr[1]);
        programingSurvey4Ans2.setFont(mainFont);
        programingSurvey4Ans2.setBounds(500, 190, 150, 50);
        programingSurvey4Ans2.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey4Ans2);
        //설문조사 4의 선택지 3
        JCheckBox programingSurvey4Ans3 = new JCheckBox();
        programingSurvey4Ans3.setText(ansarr[2]);
        programingSurvey4Ans3.setFont(mainFont);
        programingSurvey4Ans3.setBounds(650, 190, 150, 50);
        programingSurvey4Ans3.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey4Ans3);

        //설문조사 5
        JLabel programingSurvey5 = new JLabel();
        programingSurvey5.setText("질문 5");
        programingSurvey5.setFont(BigFont);
        programingSurvey5.setBounds(280, 270, 100, 70);
        panelPrograming2.add(programingSurvey5);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택5_1|선택5_2|선택5_3";
        ansarr = str.split("\\|");
        //설문조사 5의 선택지 1
        JCheckBox programingSurvey5Ans1 = new JCheckBox();
        programingSurvey5Ans1.setText(ansarr[0]);
        programingSurvey5Ans1.setFont(mainFont);
        programingSurvey5Ans1.setBounds(330, 340, 150, 50);
        programingSurvey5Ans1.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey5Ans1);
        //설문조사 5의 선택지 2
        JCheckBox programingSurvey5Ans2 = new JCheckBox();
        programingSurvey5Ans2.setText(ansarr[1]);
        programingSurvey5Ans2.setFont(mainFont);
        programingSurvey5Ans2.setBounds(500, 340, 150, 50);
        programingSurvey5Ans2.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey5Ans2);
        //설문조사 5의 선택지 3
        JCheckBox programingSurvey5Ans3 = new JCheckBox();
        programingSurvey5Ans3.setText(ansarr[2]);
        programingSurvey5Ans3.setFont(mainFont);
        programingSurvey5Ans3.setBounds(650, 340, 150, 50);
        programingSurvey5Ans3.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey5Ans3);

        //설문조사 6
        JLabel programingSurvey6 = new JLabel();
        programingSurvey6.setText("질문 6");
        programingSurvey6.setFont(BigFont);
        programingSurvey6.setBounds(280, 420, 100, 70);
        panelPrograming2.add(programingSurvey6);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택6_1|선택6_2|선택6_3";
        ansarr = str.split("\\|");
        //설문조사 6의 선택지 1
        JCheckBox programingSurvey6Ans1 = new JCheckBox();
        programingSurvey6Ans1.setText(ansarr[0]);
        programingSurvey6Ans1.setFont(mainFont);
        programingSurvey6Ans1.setBounds(330, 490, 150, 50);
        programingSurvey6Ans1.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey6Ans1);
        //설문조사 6의 선택지 2
        JCheckBox programingSurvey6Ans2 = new JCheckBox();
        programingSurvey6Ans2.setText(ansarr[1]);
        programingSurvey6Ans2.setFont(mainFont);
        programingSurvey6Ans2.setBounds(500, 490, 150, 50);
        programingSurvey6Ans2.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey6Ans2);
        //설문조사 6의 선택지 3
        JCheckBox programingSurvey6Ans3 = new JCheckBox();
        programingSurvey6Ans3.setText(ansarr[2]);
        programingSurvey6Ans3.setFont(mainFont);
        programingSurvey6Ans3.setBounds(650, 490, 150, 50);
        programingSurvey6Ans3.setContentAreaFilled(false);
        panelPrograming2.add(programingSurvey6Ans3);

        //최종 제출 버튼
        JButton programing2NextButton = new JButton();
        programing2NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(programingSurvey4Ans1.isSelected()) flag++;
            if(programingSurvey4Ans2.isSelected()) flag++;
            if(programingSurvey4Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey5Ans1.isSelected()) flag++;
                if (programingSurvey5Ans2.isSelected()) flag++;
                if (programingSurvey5Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (programingSurvey6Ans1.isSelected()) flag++;
                if (programingSurvey6Ans2.isSelected()) flag++;
                if (programingSurvey6Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (flag == 1) {
                //유저들의 레벨 관리, 임시로 1 설정
                Long programingLevel = Long.parseLong(Integer.toString(1));
                //관심분야 관련 사항 서버로 전송
                var userProgramingValues_programing = new HashMap<String, Long>() {{
                    put("user_id", user_id);
                    put("interested_id", interest_selected);
                    put("level", programingLevel);
                }};
                var userProgramingValues_programing_objectMapper = new ObjectMapper();
                try {
                    String requestBody = userProgramingValues_programing_objectMapper.writeValueAsString(userProgramingValues_programing);
                    System.out.println(requestBody);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                dispose();
            }
        });
        programing2NextButton.setText("Final Submit");
        programing2NextButton.setFont(mainFont);
        programing2NextButton.setBounds(620, 600, 160, 50);
        panelPrograming2.add(programing2NextButton);

        //이전 페이지 index 버튼
        JButton programing2Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        programing2Index1Button.addActionListener(e -> {
            panelPrograming2.setVisible(false);
            panelPrograming1.setVisible(true);
        });
        programing2Index1Button.setFont(mainFont);
        programing2Index1Button.setBounds(170, 185, 70, 50);
        programing2Index1Button.setContentAreaFilled(false);
        panelPrograming2.add(programing2Index1Button);

        //현재 페이지 index 버튼
        JButton programing2Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        programing2Index2Button.addActionListener(e -> {

        });
        programing2Index2Button.setFont(mainFont);
        programing2Index2Button.setBounds(170, 235, 70, 50);
        programing2Index2Button.setContentAreaFilled(false);
        panelPrograming2.add(programing2Index2Button);

        //****************************************************************************************************************************************************************

        //취업 패널 - 설문조사 1
        //관심분야 선택 전으로 돌아가기
        JButton employRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        employRollBackButton.addActionListener(e -> {
            panelEmploy1.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        employRollBackButton.setFont(mainFont);
        employRollBackButton.setBounds(155, 105, 80, 80);
        employRollBackButton.setContentAreaFilled(false);
        panelEmploy1.add(employRollBackButton);

        //설문조사의 질문과 선택지는 서버에서 api로 string을 받아서 사용한다.
        //설문조사 1
        JLabel employSurvey1 = new JLabel();
        employSurvey1.setText("질문 1");
        employSurvey1.setFont(BigFont);
        employSurvey1.setBounds(280, 120, 100, 70);
        panelEmploy1.add(employSurvey1);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택1_1|선택1_2|선택1_3";
        ansarr = str.split("\\|");
        //설문조사 1의 선택지 1
        JCheckBox employSurvey1Ans1 = new JCheckBox();
        employSurvey1Ans1.setText(ansarr[0]);
        employSurvey1Ans1.setFont(mainFont);
        employSurvey1Ans1.setBounds(330, 190, 150, 50);
        employSurvey1Ans1.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey1Ans1);
        //설문조사 1의 선택지 2
        JCheckBox employSurvey1Ans2 = new JCheckBox();
        employSurvey1Ans2.setText(ansarr[1]);
        employSurvey1Ans2.setFont(mainFont);
        employSurvey1Ans2.setBounds(500, 190, 150, 50);
        employSurvey1Ans2.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey1Ans2);
        //설문조사 1의 선택지 3
        JCheckBox employSurvey1Ans3 = new JCheckBox();
        employSurvey1Ans3.setText(ansarr[2]);
        employSurvey1Ans3.setFont(mainFont);
        employSurvey1Ans3.setBounds(650, 190, 150, 50);
        employSurvey1Ans3.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey1Ans3);

        //설문조사 2
        JLabel employSurvey2 = new JLabel();
        employSurvey2.setText("질문 2");
        employSurvey2.setFont(BigFont);
        employSurvey2.setBounds(280, 270, 100, 70);
        panelEmploy1.add(employSurvey2);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택2_1|선택2_2|선택2_3";
        ansarr = str.split("\\|");
        //설문조사 2의 선택지 1
        JCheckBox employSurvey2Ans1 = new JCheckBox();
        employSurvey2Ans1.setText(ansarr[0]);
        employSurvey2Ans1.setFont(mainFont);
        employSurvey2Ans1.setBounds(330, 340, 150, 50);
        employSurvey2Ans1.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey2Ans1);
        //설문조사 2의 선택지 2
        JCheckBox employSurvey2Ans2 = new JCheckBox();
        employSurvey2Ans2.setText(ansarr[1]);
        employSurvey2Ans2.setFont(mainFont);
        employSurvey2Ans2.setBounds(500, 340, 150, 50);
        employSurvey2Ans2.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey2Ans2);
        //설문조사 2의 선택지 3
        JCheckBox employSurvey2Ans3 = new JCheckBox();
        employSurvey2Ans3.setText(ansarr[2]);
        employSurvey2Ans3.setFont(mainFont);
        employSurvey2Ans3.setBounds(650, 340, 150, 50);
        employSurvey2Ans3.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey2Ans3);

        //설문조사 3
        JLabel employSurvey3 = new JLabel();
        employSurvey3.setText("질문 3");
        employSurvey3.setFont(BigFont);
        employSurvey3.setBounds(280, 420, 100, 70);
        panelEmploy1.add(employSurvey3);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택3_1|선택3_2|선택3_3";
        ansarr = str.split("\\|");
        //설문조사 3의 선택지 1
        JCheckBox employSurvey3Ans1 = new JCheckBox();
        employSurvey3Ans1.setText(ansarr[0]);
        employSurvey3Ans1.setFont(mainFont);
        employSurvey3Ans1.setBounds(330, 490, 150, 50);
        employSurvey3Ans1.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey3Ans1);
        //설문조사 3의 선택지 2
        JCheckBox employSurvey3Ans2 = new JCheckBox();
        employSurvey3Ans2.setText(ansarr[1]);
        employSurvey3Ans2.setFont(mainFont);
        employSurvey3Ans2.setBounds(500, 490, 150, 50);
        employSurvey3Ans2.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey3Ans2);
        //설문조사 3의 선택지 3
        JCheckBox employSurvey3Ans3 = new JCheckBox();
        employSurvey3Ans3.setText(ansarr[2]);
        employSurvey3Ans3.setFont(mainFont);
        employSurvey3Ans3.setBounds(650, 490, 150, 50);
        employSurvey3Ans3.setContentAreaFilled(false);
        panelEmploy1.add(employSurvey3Ans3);

        //다음 버튼
        JButton employ1NextButton = new JButton();
        employ1NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(employSurvey1Ans1.isSelected()) flag++;
            if(employSurvey1Ans2.isSelected()) flag++;
            if(employSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey2Ans1.isSelected()) flag++;
                if (employSurvey2Ans2.isSelected()) flag++;
                if (employSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey3Ans1.isSelected()) flag++;
                if (employSurvey3Ans2.isSelected()) flag++;
                if (employSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelEmploy1.setVisible(false);
                panelEmploy2.setVisible(true);
            }
        });
        employ1NextButton.setText("Next");
        employ1NextButton.setFont(mainFont);
        employ1NextButton.setBounds(700, 600, 80, 50);
        panelEmploy1.add(employ1NextButton);

        //현재 페이지 index 버튼
        JButton employ1Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        employ1Index1Button.addActionListener(e -> {
        });
        employ1Index1Button.setFont(mainFont);
        employ1Index1Button.setBounds(170, 185, 70, 50);
        employ1Index1Button.setContentAreaFilled(false);
        panelEmploy1.add(employ1Index1Button);

        //다음 페이지 index 버튼
        JButton employ1Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        employ1Index2Button.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(employSurvey1Ans1.isSelected()) flag++;
            if(employSurvey1Ans2.isSelected()) flag++;
            if(employSurvey1Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey2Ans1.isSelected()) flag++;
                if (employSurvey2Ans2.isSelected()) flag++;
                if (employSurvey2Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey3Ans1.isSelected()) flag++;
                if (employSurvey3Ans2.isSelected()) flag++;
                if (employSurvey3Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                panelEmploy1.setVisible(false);
                panelEmploy2.setVisible(true);
            }
        });
        employ1Index2Button.setFont(mainFont);
        employ1Index2Button.setBounds(170, 235, 70, 50);
        employ1Index2Button.setContentAreaFilled(false);
        panelEmploy1.add(employ1Index2Button);

        //프로그래밍 패널 - 설문조사 2
        //관심분야 선택 전으로 돌아가기
        JButton employ2RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        employ2RollBackButton.addActionListener(e -> {
            panelEmploy2.setVisible(false);
            panel2.setVisible(true);
            interest_selected = Long.parseLong(Integer.toString(0));
        });
        employ2RollBackButton.setFont(mainFont);
        employ2RollBackButton.setBounds(155, 105, 80, 80);
        employ2RollBackButton.setContentAreaFilled(false);
        panelEmploy2.add(employ2RollBackButton);

        //설문조사 4
        JLabel employSurvey4 = new JLabel();
        employSurvey4.setText("질문 4");
        employSurvey4.setFont(BigFont);
        employSurvey4.setBounds(280, 120, 100, 70);
        panelEmploy2.add(employSurvey4);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택4_1|선택4_2|선택4_3";
        ansarr = str.split("\\|");
        //설문조사 4의 선택지 1
        JCheckBox employSurvey4Ans1 = new JCheckBox();
        employSurvey4Ans1.setText(ansarr[0]);
        employSurvey4Ans1.setFont(mainFont);
        employSurvey4Ans1.setBounds(330, 190, 150, 50);
        employSurvey4Ans1.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey4Ans1);
        //설문조사 4의 선택지 2
        JCheckBox employSurvey4Ans2 = new JCheckBox();
        employSurvey4Ans2.setText(ansarr[1]);
        employSurvey4Ans2.setFont(mainFont);
        employSurvey4Ans2.setBounds(500, 190, 150, 50);
        employSurvey4Ans2.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey4Ans2);
        //설문조사 4의 선택지 3
        JCheckBox employSurvey4Ans3 = new JCheckBox();
        employSurvey4Ans3.setText(ansarr[2]);
        employSurvey4Ans3.setFont(mainFont);
        employSurvey4Ans3.setBounds(650, 190, 150, 50);
        employSurvey4Ans3.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey4Ans3);

        //설문조사 5
        JLabel employSurvey5 = new JLabel();
        employSurvey5.setText("질문 5");
        employSurvey5.setFont(BigFont);
        employSurvey5.setBounds(280, 270, 100, 70);
        panelEmploy2.add(employSurvey5);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택5_1|선택5_2|선택5_3";
        ansarr = str.split("\\|");
        //설문조사 5의 선택지 1
        JCheckBox employSurvey5Ans1 = new JCheckBox();
        employSurvey5Ans1.setText(ansarr[0]);
        employSurvey5Ans1.setFont(mainFont);
        employSurvey5Ans1.setBounds(330, 340, 150, 50);
        employSurvey5Ans1.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey5Ans1);
        //설문조사 5의 선택지 2
        JCheckBox employSurvey5Ans2 = new JCheckBox();
        employSurvey5Ans2.setText(ansarr[1]);
        employSurvey5Ans2.setFont(mainFont);
        employSurvey5Ans2.setBounds(500, 340, 150, 50);
        employSurvey5Ans2.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey5Ans2);
        //설문조사 5의 선택지 3
        JCheckBox employSurvey5Ans3 = new JCheckBox();
        employSurvey5Ans3.setText(ansarr[2]);
        employSurvey5Ans3.setFont(mainFont);
        employSurvey5Ans3.setBounds(650, 340, 150, 50);
        employSurvey5Ans3.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey5Ans3);

        //설문조사 6
        JLabel employSurvey6 = new JLabel();
        employSurvey6.setText("질문 6");
        employSurvey6.setFont(BigFont);
        employSurvey6.setBounds(280, 420, 100, 70);
        panelEmploy2.add(employSurvey6);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택6_1|선택6_2|선택6_3";
        ansarr = str.split("\\|");
        //설문조사 6의 선택지 1
        JCheckBox employSurvey6Ans1 = new JCheckBox();
        employSurvey6Ans1.setText(ansarr[0]);
        employSurvey6Ans1.setFont(mainFont);
        employSurvey6Ans1.setBounds(330, 490, 150, 50);
        employSurvey6Ans1.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey6Ans1);
        //설문조사 6의 선택지 2
        JCheckBox employSurvey6Ans2 = new JCheckBox();
        employSurvey6Ans2.setText(ansarr[1]);
        employSurvey6Ans2.setFont(mainFont);
        employSurvey6Ans2.setBounds(500, 490, 150, 50);
        employSurvey6Ans2.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey6Ans2);
        //설문조사 6의 선택지 3
        JCheckBox employSurvey6Ans3 = new JCheckBox();
        employSurvey6Ans3.setText(ansarr[2]);
        employSurvey6Ans3.setFont(mainFont);
        employSurvey6Ans3.setBounds(650, 490, 150, 50);
        employSurvey6Ans3.setContentAreaFilled(false);
        panelEmploy2.add(employSurvey6Ans3);

        //최종 제출 버튼
        JButton employ2NextButton = new JButton();
        employ2NextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            int flag = 0;
            if(employSurvey4Ans1.isSelected()) flag++;
            if(employSurvey4Ans2.isSelected()) flag++;
            if(employSurvey4Ans3.isSelected()) flag++;
            if(flag == 0){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(flag > 1){
                JOptionPane.showMessageDialog(null, "질문4의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey5Ans1.isSelected()) flag++;
                if (employSurvey5Ans2.isSelected()) flag++;
                if (employSurvey5Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if(flag == 1) {
                flag = 0;
                if (employSurvey6Ans1.isSelected()) flag++;
                if (employSurvey6Ans2.isSelected()) flag++;
                if (employSurvey6Ans3.isSelected()) flag++;
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (flag > 1) {
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (flag == 1) {
                //유저들의 레벨 관리, 임시로 1 설정
                Long employLevel = Long.parseLong(Integer.toString(1));
                //관심분야 관련 사항 서버로 전송
                var userEmployValues_employ = new HashMap<String, Long>() {{
                    put("user_id", user_id);
                    put("interested_id", interest_selected);
                    put("level", employLevel);
                }};
                var userEmployValues_employ_objectMapper = new ObjectMapper();
                try {
                    String requestBody = userEmployValues_employ_objectMapper.writeValueAsString(userEmployValues_employ);
                    System.out.println(requestBody);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }

                dispose();
            }
        });
        employ2NextButton.setText("Final Submit");
        employ2NextButton.setFont(mainFont);
        employ2NextButton.setBounds(620, 600, 160, 50);
        panelEmploy2.add(employ2NextButton);

        //이전 페이지 index 버튼
        JButton employ2Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        employ2Index1Button.addActionListener(e -> {
            panelEmploy2.setVisible(false);
            panelEmploy1.setVisible(true);
        });
        employ2Index1Button.setFont(mainFont);
        employ2Index1Button.setBounds(170, 185, 70, 50);
        employ2Index1Button.setContentAreaFilled(false);
        panelEmploy2.add(employ2Index1Button);

        //현재 페이지 index 버튼
        JButton employ2Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        employ2Index2Button.addActionListener(e -> {

        });
        employ2Index2Button.setFont(mainFont);
        employ2Index2Button.setBounds(170, 235, 70, 50);
        employ2Index2Button.setContentAreaFilled(false);
        panelEmploy2.add(employ2Index2Button);
    }

    //myPanel정의 후 사용
    static class myPanel1 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background2.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    static class myPanel2 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background3.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    static class myPanel3 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background4.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
