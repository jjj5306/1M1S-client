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
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);
    private Font smallFont = new Font("나눔고딕", Font.PLAIN, 15);
    private myPanel panel1 = new myPanel();
    private myPanel panel2 = new myPanel();

    public signUpPage() {
        //프레임 설정
        setTitle("1M1S");
        add(panel1);
        setLayout(null);
        setResizable(false);
        setSize(1100, 824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //패널 설정
        //패널1에서 회원가입 기본 정보입력 받기
        panel1.setSize(1100, 824);
        panel1.setLayout(null);
        panel1.setVisible(true);

        panel2.setSize(1100, 824);
        panel2.setLayout(null);
        panel2.setVisible(false);

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


        //제출 버튼 누른 후
        //필드별 빈칸 체크
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
                    add(panel2);
                    panel2.setVisible(true);
                }
            }
        });
        nextButton.setFont(ButtonFont);
        nextButton.setBounds(550, 600, 120, 50);
        panel1.add(nextButton);
        //이메일 포맷확인은 보류


        //패널 2~...에서 설문조사 정보 입력받기
        //다 하고 마지막 제출때  setVisible(false);

    }

    //myPanel정의 후 사용
    class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
