package loginPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import signUpPage.signUpPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import mainPage.mainPage;

@SuppressWarnings("serial")
public class loginPage extends JFrame{
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);;
    private myPanel loginpanel = new myPanel();

    public loginPage(mainPage p){
        setTitle("1M1S");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1100, 824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(loginpanel);

        //패널 설정
        loginpanel.setVisible(true);
        loginpanel.setSize(1100, 824);
        loginpanel.setLayout(null);

        //아이디 입력
        Label idLabel = new Label();
        idLabel.setText("USER ID");
        idLabel.setFont(ButtonFont);
        idLabel.setBounds(390, 230, 88, 30);
        loginpanel.add(idLabel);

        TextField idText = new TextField();
        idText.setFont(ButtonFont);
        idText.setBounds(390, 265, 370, 30);
        loginpanel.add(idText);

        //비밀번호 입력
        Label pwdLabel = new Label();
        pwdLabel.setText("PASSWORD");
        pwdLabel.setFont(ButtonFont);
        pwdLabel.setBounds(390, 310, 125, 30);
        loginpanel.add(pwdLabel);

        TextField pwdText = new TextField();
        pwdText.setFont(ButtonFont);
        pwdText.setBounds(390, 345, 370, 30);
        pwdText.setEchoChar('*');
        loginpanel.add(pwdText);

        //로그인 버튼
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }else if(pwdText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }else{
                    var values = new HashMap<String, String>() {{
                        put("username", idText.getText());
                        put("password", pwdText.getText());
                    }};
                    var objectMapper = new ObjectMapper();
                    try {
                        String requestBody = objectMapper.writeValueAsString(values);
                        System.out.println(requestBody);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                    //임시 로그인
                    if(!(idText.getText().equals("aaa"))) {
                        JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "Message", JOptionPane.ERROR_MESSAGE);
                        idText.setText("");
                        pwdText.setText("");
                    } else if(!(pwdText.getText().equals("bbb123"))){
                        JOptionPane.showMessageDialog(null, "틀린 비밀번호입니다.", "Message", JOptionPane.ERROR_MESSAGE);
                        pwdText.setText("");
                    } else{
                        p.setVisible(true);
                        //현재 프레임만 끄기
                        dispose();
                    }
                }
            }
        });
        loginButton.setFont(ButtonFont);
        loginButton.setBounds(390, 385, 180, 80);
        loginpanel.add(loginButton);

        //회원가입 버튼
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPage signUp = new signUpPage();
                signUp.setVisible(true);
            }
        });

        signUpButton.setFont(ButtonFont);
        signUpButton.setBounds(580, 385, 180, 80);
        loginpanel.add(signUpButton);

    }

    //myPanel정의 후 사용
    class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\loginPage\\background1.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }

}
