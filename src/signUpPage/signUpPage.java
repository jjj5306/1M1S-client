package signUpPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import loginPage.loginPage;

@SuppressWarnings("serial")
public class signUpPage extends JFrame {
    private int interest_selected = 0; //유저 관심 분야, 순서대로 운동, 프로그래밍, 취업
    private Font BigFont = new Font("나눔고딕", Font.PLAIN, 30);
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);
    private Font smallFont = new Font("나눔고딕", Font.PLAIN, 15);
    private myPanel1 panel1 = new myPanel1();
    private myPanel2 panel2 = new myPanel2();
    private myPanel3 panelExcercise1 = new myPanel3();
    private myPanel3 panelExcercise2 = new myPanel3();
    private myPanel3 panelPrograming = new myPanel3();
    private myPanel3 panelEmploy = new myPanel3();

    public signUpPage() {
        //프레임 설정
        setVisible(true);
        setTitle("1M1S");
        add(panel1);
        add(panel2);
        add(panelExcercise1);
        add(panelExcercise2);
        add(panelPrograming);
        add(panelEmploy);
        setLayout(null);
        setResizable(false);
        setSize(1100, 824);
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
        panelExcercise1.setSize(1100, 824);
        panelExcercise1.setLayout(null);
        panelExcercise1.setVisible(false);
        panelExcercise2.setSize(1100, 824);
        panelExcercise2.setLayout(null);
        panelExcercise2.setVisible(false);
        //프로그래밍 분야 설문조사 패널
        panelPrograming.setSize(1100, 824);
        panelPrograming.setLayout(null);
        panelPrograming.setVisible(false);
        //취업준비 설문조사 패널
        panelEmploy.setSize(1100, 824);
        panelEmploy.setLayout(null);
        panelEmploy.setVisible(false);

        //****************************************************************************************************************************************************************

        //패널1
        //패널1 되돌아가기 버튼
        JButton rollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        rollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        rollBackButton.setFont(ButtonFont);
        rollBackButton.setBounds(155, 105, 80, 80);
        rollBackButton.setContentAreaFilled(false);
        panel1.add(rollBackButton);

        //이름 입력받기
        Label nameLabel = new Label();
        nameLabel.setText("Name");
        nameLabel.setFont(ButtonFont);
        nameLabel.setBounds(320, 200, 60, 30);
        panel1.add(nameLabel);
        TextField nameText = new TextField();
        nameText.setFont(ButtonFont);
        nameText.setBounds(390, 200, 100, 30);
        panel1.add(nameText);

        //성별 입력받기
        JCheckBox manBox = new JCheckBox();
        manBox.setText("man");
        manBox.setFont(ButtonFont);
        manBox.setBounds(580, 200, 70, 30);
        panel1.add(manBox);
        JCheckBox womanBox = new JCheckBox();
        womanBox.setText("woman");
        womanBox.setFont(ButtonFont);
        womanBox.setBounds(660, 200, 97, 30);
        panel1.add(womanBox);

        //닉네임 입력받기
        Label nicknameLabel = new Label();
        nicknameLabel.setText("Nickname : ");
        nicknameLabel.setFont(ButtonFont);
        nicknameLabel.setBounds(320, 260, 95, 30);
        panel1.add(nicknameLabel);
        TextField nickNameText = new TextField();
        nickNameText.setFont(ButtonFont);
        nickNameText.setBounds(430, 260, 100, 30);
        panel1.add(nickNameText);

        //이메일 입력받기
        Label emailIdLabel = new Label();
        emailIdLabel.setText("E-mail");
        emailIdLabel.setFont(ButtonFont);
        emailIdLabel.setBounds(320, 320, 70, 30);
        panel1.add(emailIdLabel);
        TextField emailText = new TextField();
        emailText.setFont(ButtonFont);
        emailText.setBounds(400, 320, 300, 30);
        panel1.add(emailText);

        //아이디 입력받기
        Label userIdLabel = new Label();
        userIdLabel.setText("User ID");
        userIdLabel.setFont(ButtonFont);
        userIdLabel.setBounds(320, 380, 70, 30);
        panel1.add(userIdLabel);
        TextField userIdText = new TextField();
        userIdText.setFont(ButtonFont);
        userIdText.setBounds(400, 380, 100, 30);
        panel1.add(userIdText);

        //비밀번호
        Label passwdLabel = new Label();
        passwdLabel.setText("PASSWORD");
        passwdLabel.setFont(ButtonFont);
        passwdLabel.setBounds(320, 440, 125, 30);
        panel1.add(passwdLabel);
        TextField passwdText = new TextField();
        passwdText.setFont(ButtonFont);
        passwdText.setBounds(460, 440, 220, 30);
        passwdText.setEchoChar('*');
        panel1.add(passwdText);

        //비밀번호 확인
        Label passwd2Label = new Label();
        passwd2Label.setText("PASSWORD Check");
        passwd2Label.setFont(ButtonFont);
        passwd2Label.setBounds(320, 500, 190, 30);
        panel1.add(passwd2Label);
        TextField passwd2Text = new TextField();
        passwd2Text.setFont(ButtonFont);
        passwd2Text.setBounds(525, 500, 220, 30);
        passwd2Text.setEchoChar('*');
        panel1.add(passwd2Text);

        //제출 버튼 누른 후 아래의 사항들 체크
            //필드별 빈칸
            //성별 두 개 선택했는지 체크
            //아이디, 닉네임, 폰, 이메일 중복체크
            //확인, 비밀번호, 비밀번호 확인 같은지 체크
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    //DB에 JSON형식으로 넘겨준다.
                    var values = new HashMap<String, String>() {{
                        put("name", nameText.getText());
                        if (manBox.isSelected()) put("gender", "man");
                        else put("gender", "woman");
                        put("nickname", nickNameText.getText());
                        put("email", emailText.getText());
                        put("username", userIdText.getText());
                        put("password", passwdText.getText());
                    }};
                    var objectMapper = new ObjectMapper();
                    try {
                        String requestBody = objectMapper.writeValueAsString(values);
                        System.out.println(requestBody);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                    //다음 패널로 이동
                    panel1.setVisible(false);
                    panel2.setVisible(true);
                }
            }
        });
        nextButton.setFont(ButtonFont);
        nextButton.setBounds(550, 600, 120, 50);
        panel1.add(nextButton);
        //이메일 포맷확인은 보류

        //****************************************************************************************************************************************************************

        //패널 2
        //이전 설문조사로 되돌아가기 버튼
        JButton rollBackButton2 = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        rollBackButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                panel1.setVisible(true);
            }
        });
        rollBackButton2.setFont(ButtonFont);
        rollBackButton2.setBounds(155, 105, 80, 80);
        rollBackButton2.setContentAreaFilled(false);
        panel2.add(rollBackButton2);

        //안내 글
        JLabel text = new JLabel();
        text.setText("관심 분야를 선택해주세요!");
        text.setFont(BigFont);
        text.setBounds(300 ,180, 500, 70);
        panel2.add(text);

        //운동 선택 버튼
        JButton excerciseButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\excercise.png")));
        excerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelExercise로 전환
                panel2.setVisible(false);
                panelExcercise1.setVisible(true);
                interest_selected = 1;
            }
        });
        excerciseButton.setFont(ButtonFont);
        excerciseButton.setBounds(300, 310, 150, 150);
        excerciseButton.setContentAreaFilled(false);
        panel2.add(excerciseButton);
        JLabel excerciseLabel = new JLabel();
        excerciseLabel.setText("운동");
        excerciseLabel.setFont(ButtonFont);
        excerciseLabel.setBounds(355, 470, 60, 30);
        panel2.add(excerciseLabel);

        //프로그래밍 선택 버튼
        JButton programingButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\programing.png")));
        programingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelPrograming로 전환
                panel2.setVisible(false);
                panelPrograming.setVisible(true);
                interest_selected = 2;
            }
        });
        programingButton.setFont(ButtonFont);
        programingButton.setBounds(480, 310, 150, 150);
        programingButton.setContentAreaFilled(false);
        panel2.add(programingButton);
        JLabel programingLabel = new JLabel();
        programingLabel.setText("프로그래밍");
        programingLabel.setFont(ButtonFont);
        programingLabel.setBounds(505, 470, 150, 30);
        panel2.add(programingLabel);

        //취업 선택 버튼
        JButton employButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\employ.png")));
        employButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panelEmploy로 전환
                panel2.setVisible(false);
                panelEmploy.setVisible(true);
                interest_selected = 3;
            }
        });
        employButton.setFont(ButtonFont);
        employButton.setBounds(660, 310, 150, 150);
        employButton.setContentAreaFilled(false);
        panel2.add(employButton);
        JLabel employLabel = new JLabel();
        employLabel.setText("취업 준비");
        employLabel.setFont(ButtonFont);
        employLabel.setBounds(695, 470, 120, 30);
        panel2.add(employLabel);

        //****************************************************************************************************************************************************************

        //각 관심분야별 패널 부분
        //운동 패널 - 설문조사 1
        //관심분야 선택 전으로 돌아가기
        JButton excercise1RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        excercise1RollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExcercise1.setVisible(false);
                panel2.setVisible(true);
                interest_selected = 0;
            }
        });
        excercise1RollBackButton.setFont(ButtonFont);
        excercise1RollBackButton.setBounds(155, 105, 80, 80);
        excercise1RollBackButton.setContentAreaFilled(false);
        panelExcercise1.add(excercise1RollBackButton);

        //설문조사의 질문과 선택지는 서버에서 api로 string을 받아서 사용한다.
        //설문조사 1
        JLabel excerciseSurvey1 = new JLabel();
        excerciseSurvey1.setText(new String("질문 1"));
        excerciseSurvey1.setFont(BigFont);
        excerciseSurvey1.setBounds(280, 120, 100, 70);
        panelExcercise1.add(excerciseSurvey1);
        //이 부분도 api로 |로 구분된 string을 받는다.
        String str = "선택1_1|선택1_2|선택1_3";
        String[] ansarr = str.split("\\|");
        //설문조사 1의 선택지 1
        JCheckBox excerciseSurvey1Ans1 = new JCheckBox();
        excerciseSurvey1Ans1.setText(ansarr[0]);
        excerciseSurvey1Ans1.setFont(ButtonFont);
        excerciseSurvey1Ans1.setBounds(330, 190, 150, 50);
        excerciseSurvey1Ans1.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey1Ans1);
        //설문조사 1의 선택지 2
        JCheckBox excerciseSurvey1Ans2 = new JCheckBox();
        excerciseSurvey1Ans2.setText(ansarr[1]);
        excerciseSurvey1Ans2.setFont(ButtonFont);
        excerciseSurvey1Ans2.setBounds(500, 190, 150, 50);
        excerciseSurvey1Ans2.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey1Ans2);
        //설문조사 1의 선택지 3
        JCheckBox excerciseSurvey1Ans3 = new JCheckBox();
        excerciseSurvey1Ans3.setText(ansarr[2]);
        excerciseSurvey1Ans3.setFont(ButtonFont);
        excerciseSurvey1Ans3.setBounds(650, 190, 150, 50);
        excerciseSurvey1Ans3.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey1Ans3);

        //설문조사 2
        JLabel excerciseSurvey2 = new JLabel();
        excerciseSurvey2.setText(new String("질문 2"));
        excerciseSurvey2.setFont(BigFont);
        excerciseSurvey2.setBounds(280, 270, 100, 70);
        panelExcercise1.add(excerciseSurvey2);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택2_1|선택2_2|선택2_3";
        ansarr = str.split("\\|");
        //설문조사 2의 선택지 1
        JCheckBox excerciseSurvey2Ans1 = new JCheckBox();
        excerciseSurvey2Ans1.setText(ansarr[0]);
        excerciseSurvey2Ans1.setFont(ButtonFont);
        excerciseSurvey2Ans1.setBounds(330, 340, 150, 50);
        excerciseSurvey2Ans1.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey2Ans1);
        //설문조사 2의 선택지 2
        JCheckBox excerciseSurvey2Ans2 = new JCheckBox();
        excerciseSurvey2Ans2.setText(ansarr[1]);
        excerciseSurvey2Ans2.setFont(ButtonFont);
        excerciseSurvey2Ans2.setBounds(500, 340, 150, 50);
        excerciseSurvey2Ans2.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey2Ans2);
        //설문조사 2의 선택지 3
        JCheckBox excerciseSurvey2Ans3 = new JCheckBox();
        excerciseSurvey2Ans3.setText(ansarr[2]);
        excerciseSurvey2Ans3.setFont(ButtonFont);
        excerciseSurvey2Ans3.setBounds(650, 340, 150, 50);
        excerciseSurvey2Ans3.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey2Ans3);

        //설문조사 3
        JLabel excerciseSurvey3 = new JLabel();
        excerciseSurvey3.setText(new String("질문 3"));
        excerciseSurvey3.setFont(BigFont);
        excerciseSurvey3.setBounds(280, 420, 100, 70);
        panelExcercise1.add(excerciseSurvey3);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택3_1|선택3_2|선택3_3";
        ansarr = str.split("\\|");
        //설문조사 3의 선택지 1
        JCheckBox excerciseSurvey3Ans1 = new JCheckBox();
        excerciseSurvey3Ans1.setText(ansarr[0]);
        excerciseSurvey3Ans1.setFont(ButtonFont);
        excerciseSurvey3Ans1.setBounds(330, 490, 150, 50);
        excerciseSurvey3Ans1.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey3Ans1);
        //설문조사 3의 선택지 2
        JCheckBox excerciseSurvey3Ans2 = new JCheckBox();
        excerciseSurvey3Ans2.setText(ansarr[1]);
        excerciseSurvey3Ans2.setFont(ButtonFont);
        excerciseSurvey3Ans2.setBounds(500, 490, 150, 50);
        excerciseSurvey3Ans2.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey3Ans2);
        //설문조사 3의 선택지 3
        JCheckBox excerciseSurvey3Ans3 = new JCheckBox();
        excerciseSurvey3Ans3.setText(ansarr[2]);
        excerciseSurvey3Ans3.setFont(ButtonFont);
        excerciseSurvey3Ans3.setBounds(650, 490, 150, 50);
        excerciseSurvey3Ans3.setContentAreaFilled(false);
        panelExcercise1.add(excerciseSurvey3Ans3);
        //다음 버튼
        JButton excercise1NextButton = new JButton();
        excercise1NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //선택지 잘 선택 했는지 체크
                int flag = 0, check = 0;
                if(excerciseSurvey1Ans1.isSelected()) flag++;
                if(excerciseSurvey1Ans2.isSelected()) flag++;
                if(excerciseSurvey1Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey2Ans1.isSelected()) flag++;
                if(excerciseSurvey2Ans2.isSelected()) flag++;
                if(excerciseSurvey2Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey3Ans1.isSelected()) flag++;
                if(excerciseSurvey3Ans2.isSelected()) flag++;
                if(excerciseSurvey3Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                if(check == 0) {
                    panelExcercise1.setVisible(false);
                    panelExcercise2.setVisible(true);
                }
            }
        });
        excercise1NextButton.setText("Next");
        excercise1NextButton.setFont(ButtonFont);
        excercise1NextButton.setBounds(700, 600, 80, 50);
        panelExcercise1.add(excercise1NextButton);

        //현재 페이지 index 버튼
        JButton excercise1Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        excercise1RollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        excercise1Index1Button.setFont(ButtonFont);
        excercise1Index1Button.setBounds(170, 185, 70, 50);
        excercise1Index1Button.setContentAreaFilled(false);
        panelExcercise1.add(excercise1Index1Button);

        //다음 페이지 index 버튼
        JButton excercise1Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        excercise1Index2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //선택지 잘 선택 했는지 체크
                int flag = 0, check = 0;
                if(excerciseSurvey1Ans1.isSelected()) flag++;
                if(excerciseSurvey1Ans2.isSelected()) flag++;
                if(excerciseSurvey1Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문1의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문1의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey2Ans1.isSelected()) flag++;
                if(excerciseSurvey2Ans2.isSelected()) flag++;
                if(excerciseSurvey2Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문2의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey3Ans1.isSelected()) flag++;
                if(excerciseSurvey3Ans2.isSelected()) flag++;
                if(excerciseSurvey3Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문3의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                if(check == 0) {
                    panelExcercise1.setVisible(false);
                    panelExcercise2.setVisible(true);
                }
            }
        });
        excercise1Index2Button.setFont(ButtonFont);
        excercise1Index2Button.setBounds(170, 235, 70, 50);
        excercise1Index2Button.setContentAreaFilled(false);
        panelExcercise1.add(excercise1Index2Button);

        //****************************************************************************************************************************************************************
        //운동 패널 - 설문조사 2
        //관심분야 선택 전으로 돌아가기
        JButton excercise2RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        excercise2RollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExcercise2.setVisible(false);
                panel2.setVisible(true);
                interest_selected = 0;
            }
        });
        excercise2RollBackButton.setFont(ButtonFont);
        excercise2RollBackButton.setBounds(155, 105, 80, 80);
        excercise2RollBackButton.setContentAreaFilled(false);
        panelExcercise2.add(excercise2RollBackButton);

        //설문조사 4
        JLabel excerciseSurvey4 = new JLabel();
        excerciseSurvey4.setText(new String("질문 4"));
        excerciseSurvey4.setFont(BigFont);
        excerciseSurvey4.setBounds(280, 120, 100, 70);
        panelExcercise2.add(excerciseSurvey4);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택4_1|선택4_2|선택4_3";
        ansarr = str.split("\\|");
        //설문조사 4의 선택지 1
        JCheckBox excerciseSurvey4Ans1 = new JCheckBox();
        excerciseSurvey4Ans1.setText(ansarr[0]);
        excerciseSurvey4Ans1.setFont(ButtonFont);
        excerciseSurvey4Ans1.setBounds(330, 190, 150, 50);
        excerciseSurvey4Ans1.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey4Ans1);
        //설문조사 4의 선택지 2
        JCheckBox excerciseSurvey4Ans2 = new JCheckBox();
        excerciseSurvey4Ans2.setText(ansarr[1]);
        excerciseSurvey4Ans2.setFont(ButtonFont);
        excerciseSurvey4Ans2.setBounds(500, 190, 150, 50);
        excerciseSurvey4Ans2.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey4Ans2);
        //설문조사 1의 선택지 3
        JCheckBox excerciseSurvey4Ans3 = new JCheckBox();
        excerciseSurvey4Ans3.setText(ansarr[2]);
        excerciseSurvey4Ans3.setFont(ButtonFont);
        excerciseSurvey4Ans3.setBounds(650, 190, 150, 50);
        excerciseSurvey4Ans3.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey4Ans3);

        //설문조사 5
        JLabel excerciseSurvey5 = new JLabel();
        excerciseSurvey5.setText(new String("질문 5"));
        excerciseSurvey5.setFont(BigFont);
        excerciseSurvey5.setBounds(280, 270, 100, 70);
        panelExcercise2.add(excerciseSurvey5);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택5_1|선택5_2|선택5_3";
        ansarr = str.split("\\|");
        //설문조사 5의 선택지 1
        JCheckBox excerciseSurvey5Ans1 = new JCheckBox();
        excerciseSurvey5Ans1.setText(ansarr[0]);
        excerciseSurvey5Ans1.setFont(ButtonFont);
        excerciseSurvey5Ans1.setBounds(330, 340, 150, 50);
        excerciseSurvey5Ans1.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey5Ans1);
        //설문조사 5의 선택지 2
        JCheckBox excerciseSurvey5Ans2 = new JCheckBox();
        excerciseSurvey5Ans2.setText(ansarr[1]);
        excerciseSurvey5Ans2.setFont(ButtonFont);
        excerciseSurvey5Ans2.setBounds(500, 340, 150, 50);
        excerciseSurvey5Ans2.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey5Ans2);
        //설문조사 5의 선택지 3
        JCheckBox excerciseSurvey5Ans3 = new JCheckBox();
        excerciseSurvey5Ans3.setText(ansarr[2]);
        excerciseSurvey5Ans3.setFont(ButtonFont);
        excerciseSurvey5Ans3.setBounds(650, 340, 150, 50);
        excerciseSurvey5Ans3.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey5Ans3);

        //설문조사 6
        JLabel excerciseSurvey6 = new JLabel();
        excerciseSurvey6.setText(new String("질문 6"));
        excerciseSurvey6.setFont(BigFont);
        excerciseSurvey6.setBounds(280, 420, 100, 70);
        panelExcercise2.add(excerciseSurvey6);
        //이 부분도 api로 |로 구분된 string을 받는다.
        str = "선택6_1|선택6_2|선택6_3";
        ansarr = str.split("\\|");
        //설문조사 6의 선택지 1
        JCheckBox excerciseSurvey6Ans1 = new JCheckBox();
        excerciseSurvey6Ans1.setText(ansarr[0]);
        excerciseSurvey6Ans1.setFont(ButtonFont);
        excerciseSurvey6Ans1.setBounds(330, 490, 150, 50);
        excerciseSurvey6Ans1.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey6Ans1);
        //설문조사 6의 선택지 2
        JCheckBox excerciseSurvey6Ans2 = new JCheckBox();
        excerciseSurvey6Ans2.setText(ansarr[1]);
        excerciseSurvey6Ans2.setFont(ButtonFont);
        excerciseSurvey6Ans2.setBounds(500, 490, 150, 50);
        excerciseSurvey6Ans2.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey6Ans2);
        //설문조사 6의 선택지 3
        JCheckBox excerciseSurvey6Ans3 = new JCheckBox();
        excerciseSurvey6Ans3.setText(ansarr[2]);
        excerciseSurvey6Ans3.setFont(ButtonFont);
        excerciseSurvey6Ans3.setBounds(650, 490, 150, 50);
        excerciseSurvey6Ans3.setContentAreaFilled(false);
        panelExcercise2.add(excerciseSurvey6Ans3);

        //다음 버튼
        JButton excercise2NextButton = new JButton();
        excercise2NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //선택지 잘 선택 했는지 체크
                int flag = 0, check = 0;
                if(excerciseSurvey4Ans1.isSelected()) flag++;
                if(excerciseSurvey4Ans2.isSelected()) flag++;
                if(excerciseSurvey4Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문4의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문4의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey5Ans1.isSelected()) flag++;
                if(excerciseSurvey5Ans2.isSelected()) flag++;
                if(excerciseSurvey5Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문5의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }

                flag = 0;
                if(excerciseSurvey6Ans1.isSelected()) flag++;
                if(excerciseSurvey6Ans2.isSelected()) flag++;
                if(excerciseSurvey6Ans3.isSelected()) flag++;
                if(flag == 0){
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }else if(flag > 1){
                    JOptionPane.showMessageDialog(null, "질문6의 선택지를 하나만 체크해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                    check = 1;
                }
                if(check == 0) {
                    //db에 정보 보내기

                    dispose();
                }
            }
        });
        excercise2NextButton.setText("Next");
        excercise2NextButton.setFont(ButtonFont);
        excercise2NextButton.setBounds(700, 600, 80, 50);
        panelExcercise2.add(excercise2NextButton);

        //이전 페이지 index 버튼
        JButton excercise2Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index1.png")));
        excercise2Index1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExcercise2.setVisible(false);
                panelExcercise1.setVisible(true);
            }
        });
        excercise2Index1Button.setFont(ButtonFont);
        excercise2Index1Button.setBounds(170, 185, 70, 50);
        excercise2Index1Button.setContentAreaFilled(false);
        panelExcercise2.add(excercise2Index1Button);

        //다음 페이지 index 버튼
        JButton excercise2Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        excercise2Index2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        excercise2Index2Button.setFont(ButtonFont);
        excercise2Index2Button.setBounds(170, 235, 70, 50);
        excercise2Index2Button.setContentAreaFilled(false);
        panelExcercise2.add(excercise2Index2Button);




        //****************************************************************************************************************************************************************

        //프로그래밍 패널
        //관심분야 선택 전으로 돌아가기
        JButton programingRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        programingRollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrograming.setVisible(false);
                panel2.setVisible(true);
                interest_selected = 0;
            }
        });
        programingRollBackButton.setFont(ButtonFont);
        programingRollBackButton.setBounds(155, 105, 80, 80);
        programingRollBackButton.setContentAreaFilled(false);
        panelPrograming.add(programingRollBackButton);

        //****************************************************************************************************************************************************************

        //취업 패널
        //관심분야 선택 전으로 돌아가기
        JButton employRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\rollback.png")));
        employRollBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEmploy.setVisible(false);
                panel2.setVisible(true);
                interest_selected = 0;
            }
        });
        employRollBackButton.setFont(ButtonFont);
        employRollBackButton.setBounds(155, 105, 80, 80);
        employRollBackButton.setContentAreaFilled(false);
        panelEmploy.add(employRollBackButton);
    }

    //myPanel정의 후 사용
    class myPanel1 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background2.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    class myPanel2 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background3.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    class myPanel3 extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background4.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
