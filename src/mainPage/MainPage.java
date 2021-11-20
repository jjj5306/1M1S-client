package mainPage;

import loginPage.loginPage;
import forumPage.forumPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class mainPage extends JFrame {
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);;
    public myPanel mainpanel = new myPanel();

    public mainPage() {
        //프레임 설정
        setTitle("1M1S");
        setVisible(false);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainpanel);

        //**************************************************************************************************************

        //패널 설정
        mainpanel.setSize(1100, 824);
        mainpanel.setLayout(null);
        mainpanel.setVisible(true);

        //**************************************************************************************************************

        //마이페이지 버튼 설정
        JButton button1 = new JButton("회원 정보");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //여기에 마이 페이지로 이동하는 부분 작성
                JOptionPane.showMessageDialog(null, "마이페이지로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button1.setFont(ButtonFont);
        button1.setBounds(0, 0, 200, 110);
        mainpanel.add(button1);

        //시간관리 버튼 설정
        JButton button2 = new JButton("시간 관리");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //여기에 시간관리 페이지로 이동하는 부분 작성
                JOptionPane.showMessageDialog(null, "시간관리로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button2.setFont(ButtonFont);
        button2.setBounds(0, 110, 200, 110);
        mainpanel.add(button2);

        //랭킹 버튼 설정
        JButton button3 = new JButton("랭킹");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //여기에 랭킹 페이지로 이동하는 부분 작성
                JOptionPane.showMessageDialog(null, "랭킹으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button3.setFont(ButtonFont);
        button3.setBounds(0, 220, 200, 110);
        mainpanel.add(button3);

        //그룹 버튼 설정
        JButton button4 = new JButton("그룹");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //여기에 그룹 페이지로 이동하는 부분 작성
                JOptionPane.showMessageDialog(null, "그룹으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button4.setFont(ButtonFont);
        button4.setBounds(0, 330, 200, 110);
        mainpanel.add(button4);

        //게시판 버튼 설정
        JButton button5 = new JButton("게시판");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "게시판으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
                forumPage forum = new forumPage();
            }
        });
        button5.setFont(ButtonFont);
        button5.setBounds(0, 440, 200, 110);
        mainpanel.add(button5);

        //커리큘럼 버튼 설정
        //게시판 버튼 설정
        JButton button6 = new JButton("커리큘럼");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "커리큘럼으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button6.setFont(ButtonFont);
        button6.setBounds(0, 550, 200, 250);
        mainpanel.add(button6);
    }

    class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\mainPage\\background1.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }

    public static void main(String[] args) {
        mainPage p = new mainPage();
        loginPage loginP = new loginPage(p);
    }
}
