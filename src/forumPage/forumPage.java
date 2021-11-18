package forumPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class forumPage extends JFrame {
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);
    private myPanel panelForumGeneral = new myPanel();
    private myPanel panelForumExcercise = new myPanel();
    private myPanel panelForumPrograming = new myPanel();
    private myPanel panelForumEmploy = new myPanel();

    public forumPage() {
        //프레임 설정
        setTitle("1M1S-forum");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panelForumGeneral);
        add(panelForumExcercise);
        add(panelForumPrograming);
        add(panelForumEmploy);

        //**************************************************************************************************************

        //패널 설정
        //ForumGeneral이 가장 먼저 보이고, 이는 자유게시판패널이다.
        panelForumGeneral.setSize(1100, 824);
        panelForumGeneral.setLayout(null);
        panelForumGeneral.setVisible(true);
        //ForumExcercise에서 운동게시판
        panelForumExcercise.setSize(1100, 824);
        panelForumExcercise.setLayout(null);
        panelForumExcercise.setVisible(false);
        //ForumPrograming에서 프로그래밍게시판
        panelForumPrograming.setSize(1100, 824);
        panelForumPrograming.setLayout(null);
        panelForumPrograming.setVisible(false);
        //ForumEmply에서 취업게시판
        panelForumEmploy.setSize(1100, 824);
        panelForumEmploy.setLayout(null);
        panelForumEmploy.setVisible(false);

        //**************************************************************************************************************

        //패널 자유게시판
        //창 끄기 버튼
        //자유게시판 갱신 버튼
        JButton generalForumGeneralButton = new JButton();
        generalForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //게시판 업데이트
            }
        });
        generalForumGeneralButton.setText("자유게시판");
        generalForumGeneralButton.setFont(ButtonFont);
        generalForumGeneralButton.setBounds(12, 20, 150, 80);
        generalForumGeneralButton.setContentAreaFilled(true);
        panelForumGeneral.add(generalForumGeneralButton);

        //운동게시판 전환 버튼
        JButton generalForumExcerciseButton = new JButton();
        generalForumExcerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumGeneral.setVisible(false);
                panelForumExcercise.setVisible(true);
            }
        });
        generalForumExcerciseButton.setText("운동게시판");
        generalForumExcerciseButton.setFont(ButtonFont);
        generalForumExcerciseButton.setBounds(161, 20, 150, 80);
        generalForumExcerciseButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumExcerciseButton);

        //프로그래밍 전환 버튼
        JButton generalForumProgramingButton = new JButton();
        generalForumProgramingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumGeneral.setVisible(false);
                panelForumPrograming.setVisible(true);
            }
        });
        generalForumProgramingButton.setText("프로그래밍");
        generalForumProgramingButton.setFont(ButtonFont);
        generalForumProgramingButton.setBounds(310, 20, 150, 80);
        generalForumProgramingButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumProgramingButton);

        //취업 전환 버튼
        JButton generalForumEmployButton = new JButton();
        generalForumEmployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumGeneral.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        generalForumEmployButton.setText("취업게시판");
        generalForumEmployButton.setFont(ButtonFont);
        generalForumEmployButton.setBounds(459, 20, 150, 80);
        generalForumEmployButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumEmployButton);

        //**************************************************************************************************************

        //패널 운동게시판
        //창 끄기 버튼
        //자유게시판 전환 버튼
        JButton excerciseForumGeneralButton = new JButton();
        excerciseForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumExcercise.setVisible(false);
                panelForumGeneral.setVisible(true);
            }
        });
        excerciseForumGeneralButton.setText("자유게시판");
        excerciseForumGeneralButton.setFont(ButtonFont);
        excerciseForumGeneralButton.setBounds(12, 20, 150, 80);
        excerciseForumGeneralButton.setContentAreaFilled(false);
        panelForumExcercise.add(excerciseForumGeneralButton);

        //운동게시판 갱신 버튼
        JButton excerciseForumExcerciseButton = new JButton();
        excerciseForumExcerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //게시판 업데이트
           }
        });
        excerciseForumExcerciseButton.setText("운동게시판");
        excerciseForumExcerciseButton.setFont(ButtonFont);
        excerciseForumExcerciseButton.setBounds(161, 20, 150, 80);
        excerciseForumExcerciseButton.setContentAreaFilled(true);
        panelForumExcercise.add(excerciseForumExcerciseButton);

        //프로그래밍 전환 버튼
        JButton excerciseForumProgramingButton = new JButton();
        excerciseForumProgramingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumExcercise.setVisible(false);
                panelForumPrograming.setVisible(true);
            }
        });
        excerciseForumProgramingButton.setText("프로그래밍");
        excerciseForumProgramingButton.setFont(ButtonFont);
        excerciseForumProgramingButton.setBounds(310, 20, 150, 80);
        excerciseForumProgramingButton.setContentAreaFilled(false);
        panelForumExcercise.add(excerciseForumProgramingButton);

        //취업 전환 버튼
        JButton excerciseForumEmployButton = new JButton();
        excerciseForumEmployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumExcercise.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        excerciseForumEmployButton.setText("취업게시판");
        excerciseForumEmployButton.setFont(ButtonFont);
        excerciseForumEmployButton.setBounds(459, 20, 150, 80);
        excerciseForumEmployButton.setContentAreaFilled(false);
        panelForumExcercise.add(excerciseForumEmployButton);

        //**************************************************************************************************************

        //패널 프로그래밍
        //창 끄기 버튼
        //자유게시판 전환 버튼
        JButton programingForumGeneralButton = new JButton();
        programingForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumPrograming.setVisible(false);
                panelForumGeneral.setVisible(true);
            }
        });
        programingForumGeneralButton.setText("자유게시판");
        programingForumGeneralButton.setFont(ButtonFont);
        programingForumGeneralButton.setBounds(12, 20, 150, 80);
        programingForumGeneralButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumGeneralButton);

        //운동게시판 전환 버튼
        JButton programingForumExcerciseButton = new JButton();
        programingForumExcerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumPrograming.setVisible(false);
                panelForumExcercise.setVisible(true);
            }
        });
        programingForumExcerciseButton.setText("운동게시판");
        programingForumExcerciseButton.setFont(ButtonFont);
        programingForumExcerciseButton.setBounds(161, 20, 150, 80);
        programingForumExcerciseButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumExcerciseButton);

        //프로그래밍 업데이트 버튼
        JButton programingForumProgramingButton = new JButton();
        programingForumProgramingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //게시판 업데이트
            }
        });
        programingForumProgramingButton.setText("프로그래밍");
        programingForumProgramingButton.setFont(ButtonFont);
        programingForumProgramingButton.setBounds(310, 20, 150, 80);
        programingForumProgramingButton.setContentAreaFilled(true);
        panelForumPrograming.add(programingForumProgramingButton);

        //취업 전환 버튼
        JButton programingForumEmployButton = new JButton();
        programingForumEmployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumPrograming.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        programingForumEmployButton.setText("취업게시판");
        programingForumEmployButton.setFont(ButtonFont);
        programingForumEmployButton.setBounds(459, 20, 150, 80);
        programingForumEmployButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumEmployButton);

        //**************************************************************************************************************

        //패널 취업게시판
        //창 끄기 버튼
        //자유게시판 전환 버튼
        JButton employForumGeneralButton = new JButton();
        employForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumEmploy.setVisible(false);
                panelForumGeneral.setVisible(true);
            }
        });
        employForumGeneralButton.setText("자유게시판");
        employForumGeneralButton.setFont(ButtonFont);
        employForumGeneralButton.setBounds(12, 20, 150, 80);
        employForumGeneralButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumGeneralButton);

        //운동게시판 전환 버튼
        JButton employForumExcerciseButton = new JButton();
        employForumExcerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumEmploy.setVisible(false);
                panelForumExcercise.setVisible(true);
            }
        });
        employForumExcerciseButton.setText("운동게시판");
        employForumExcerciseButton.setFont(ButtonFont);
        employForumExcerciseButton.setBounds(161, 20, 150, 80);
        employForumExcerciseButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumExcerciseButton);

        //프로그래밍 전환 버튼
        JButton employForumProgramingButton = new JButton();
        employForumProgramingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumEmploy.setVisible(false);
                panelForumPrograming.setVisible(true);
            }
        });
        employForumProgramingButton.setText("프로그래밍");
        employForumProgramingButton.setFont(ButtonFont);
        employForumProgramingButton.setBounds(310, 20, 150, 80);
        employForumProgramingButton.setContentAreaFilled(true);
        panelForumEmploy.add(employForumProgramingButton);

        //취업 갱신 버튼
        JButton employForumEmployButton = new JButton();
        employForumEmployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //게시판 업데이트
            }
        });
        employForumEmployButton.setText("취업게시판");
        employForumEmployButton.setFont(ButtonFont);
        employForumEmployButton.setBounds(459, 20, 150, 80);
        employForumEmployButton.setContentAreaFilled(true);
        panelForumEmploy.add(employForumEmployButton);

    }

    class myPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\background5.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
