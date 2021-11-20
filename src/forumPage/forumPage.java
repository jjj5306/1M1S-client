package forumPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.*;
import java.util.Map;

import db.*;


@SuppressWarnings("serial")
public class forumPage extends JFrame {
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);
    private myPanel panelForumGeneral = new myPanel();
    private myPanel panelForumExcercise = new myPanel();
    private myPanel panelForumPrograming = new myPanel();
    private myPanel panelForumEmploy = new myPanel();
    private myPanel2 panelAddPost = new myPanel2();
    private int interest = 0; //관심분야, 1, 2, 3 순서대로 운동, 프로그래밍, 취업 0인 경우 자유 게시판 글
    private String[] header = {"id", "interest", "title", "content"}; //table header

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
        add(panelAddPost);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 설정
        //ForumGeneral이 가장 먼저 보이고, 이는 자유게시판패널이다.
        panelForumGeneral.setSize(1100, 824);
        panelForumGeneral.setLayout(null);
        panelForumGeneral.setVisible(true);
        //ForumExcercise, 운동게시판
        panelForumExcercise.setSize(1100, 824);
        panelForumExcercise.setLayout(null);
        panelForumExcercise.setVisible(false);
        //ForumPrograming,  프로그래밍게시판
        panelForumPrograming.setSize(1100, 824);
        panelForumPrograming.setLayout(null);
        panelForumPrograming.setVisible(false);
        //ForumEmply,  취업게시판
        panelForumEmploy.setSize(1100, 824);
        panelForumEmploy.setLayout(null);
        panelForumEmploy.setVisible(false);
        //게시글 추가하는 패널
        panelAddPost.setSize(1100, 824);
        panelAddPost.setLayout(null);
        panelAddPost.setVisible(false);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************        //패널 자유게시판

        //창 끄기 버튼

        //테이블 설정
        DefaultTableModel general_dtm = new DefaultTableModel(0, 0);
        JTable generalTable = new JTable(general_dtm);
        //칼럼 만들기
        general_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        generalTable.getColumn("id").setWidth(0);
        generalTable.getColumn("id").setMinWidth(0);
        generalTable.getColumn("id").setMaxWidth(0);
        generalTable.getColumn("interest").setWidth(0);
        generalTable.getColumn("interest").setMinWidth(0);
        generalTable.getColumn("interest").setMaxWidth(0);
        generalTable.getColumn("title").setWidth(250);
        generalTable.getColumn("title").setMinWidth(250);
        generalTable.getColumn("title").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        generalTable.getTableHeader().setReorderingAllowed(false);
        generalTable.getTableHeader().setReorderingAllowed(false);
        //스크롤팬 설정
        JScrollPane generalForumScrollPane = new JScrollPane(generalTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        generalForumScrollPane.setVisible(true);
        generalForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumGeneral.add(generalForumScrollPane);

        //자유게시판 갱신 버튼
        JButton generalForumGeneralButton = new JButton();
        generalForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable(Long.valueOf(0), general_dtm);
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
                interest = 1;
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
                interest = 2;
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
                interest = 3;
                panelForumGeneral.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        generalForumEmployButton.setText("취업게시판");
        generalForumEmployButton.setFont(ButtonFont);
        generalForumEmployButton.setBounds(459, 20, 150, 80);
        generalForumEmployButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_generalPage = new JButton();
        addPostButton_generalPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumGeneral.setVisible(false);
                panelAddPost.setVisible(true);
            }
        });
        addPostButton_generalPage.setText("글쓰기");
        addPostButton_generalPage.setFont(ButtonFont);
        addPostButton_generalPage.setBounds(964, 100, 120, 80);
        addPostButton_generalPage.setContentAreaFilled(true);
        panelForumGeneral.add(addPostButton_generalPage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 운동게시판
        //창 끄기 버튼

        //테이블 설정
        DefaultTableModel excercise_dtm = new DefaultTableModel(0, 0);
        JTable excerciseTable = new JTable(excercise_dtm);
        //칼럼 만들기
        excercise_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        excerciseTable.getColumn("id").setWidth(0);
        excerciseTable.getColumn("id").setMinWidth(0);
        excerciseTable.getColumn("id").setMaxWidth(0);
        excerciseTable.getColumn("interest").setWidth(0);
        excerciseTable.getColumn("interest").setMinWidth(0);
        excerciseTable.getColumn("interest").setMaxWidth(0);
        excerciseTable.getColumn("title").setWidth(250);
        excerciseTable.getColumn("title").setMinWidth(250);
        excerciseTable.getColumn("title").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        excerciseTable.getTableHeader().setReorderingAllowed(false);
        excerciseTable.getTableHeader().setReorderingAllowed(false);
        //스크롤팬 설정
        JScrollPane excerciseForumScrollPane = new JScrollPane(excerciseTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        excerciseForumScrollPane.setVisible(true);
        excerciseForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumExcercise.add(excerciseForumScrollPane);

        //자유게시판 전환 버튼
        JButton excerciseForumGeneralButton = new JButton();
        excerciseForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interest = 0;
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
                updateTable(Long.valueOf(1), excercise_dtm);
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
                interest = 2;
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
                interest = 3;
                panelForumExcercise.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        excerciseForumEmployButton.setText("취업게시판");
        excerciseForumEmployButton.setFont(ButtonFont);
        excerciseForumEmployButton.setBounds(459, 20, 150, 80);
        excerciseForumEmployButton.setContentAreaFilled(false);
        panelForumExcercise.add(excerciseForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_excercisePage = new JButton();
        addPostButton_excercisePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumExcercise.setVisible(false);
                panelAddPost.setVisible(true);
            }
        });
        addPostButton_excercisePage.setText("글쓰기");
        addPostButton_excercisePage.setFont(ButtonFont);
        addPostButton_excercisePage.setBounds(964, 100, 120, 80);
        addPostButton_excercisePage.setContentAreaFilled(true);
        panelForumExcercise.add(addPostButton_excercisePage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 프로그래밍
        //창 끄기 버튼

        //테이블 설정
        DefaultTableModel programing_dtm = new DefaultTableModel(0, 0);
        JTable programingTable = new JTable(programing_dtm);
        //칼럼 만들기
        programing_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        programingTable.getColumn("id").setWidth(0);
        programingTable.getColumn("id").setMinWidth(0);
        programingTable.getColumn("id").setMaxWidth(0);
        programingTable.getColumn("interest").setWidth(0);
        programingTable.getColumn("interest").setMinWidth(0);
        programingTable.getColumn("interest").setMaxWidth(0);
        programingTable.getColumn("title").setWidth(250);
        programingTable.getColumn("title").setMinWidth(250);
        programingTable.getColumn("title").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        programingTable.getTableHeader().setReorderingAllowed(false);
        programingTable.getTableHeader().setReorderingAllowed(false);;
        //스크롤팬 설정
        JScrollPane programingForumScrollPane = new JScrollPane(programingTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        programingForumScrollPane.setVisible(true);
        programingForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumPrograming.add(programingForumScrollPane);

        //자유게시판 전환 버튼
        JButton programingForumGeneralButton = new JButton();
        programingForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interest = 0;
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
                interest = 1;
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
                updateTable(Long.valueOf(2), programing_dtm);
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
                interest = 3;
                panelForumPrograming.setVisible(false);
                panelForumEmploy.setVisible(true);
            }
        });
        programingForumEmployButton.setText("취업게시판");
        programingForumEmployButton.setFont(ButtonFont);
        programingForumEmployButton.setBounds(459, 20, 150, 80);
        programingForumEmployButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_programingPage = new JButton();
        addPostButton_programingPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumPrograming.setVisible(false);
                panelAddPost.setVisible(true);
            }
        });
        addPostButton_programingPage.setText("글쓰기");
        addPostButton_programingPage.setFont(ButtonFont);
        addPostButton_programingPage.setBounds(964, 100, 120, 80);
        addPostButton_programingPage.setContentAreaFilled(true);
        panelForumPrograming.add(addPostButton_programingPage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 취업게시판
        //창 끄기 버튼

        //테이블 설정
        DefaultTableModel employ_dtm = new DefaultTableModel(0, 0);
        JTable employTable = new JTable(employ_dtm);
        //칼럼 만들기
        employ_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        employTable.getColumn("id").setWidth(0);
        employTable.getColumn("id").setMinWidth(0);
        employTable.getColumn("id").setMaxWidth(0);
        employTable.getColumn("interest").setWidth(0);
        employTable.getColumn("interest").setMinWidth(0);
        employTable.getColumn("interest").setMaxWidth(0);
        employTable.getColumn("title").setWidth(250);
        employTable.getColumn("title").setMinWidth(250);
        employTable.getColumn("title").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        generalTable.getTableHeader().setReorderingAllowed(false);
        generalTable.getTableHeader().setReorderingAllowed(false);
        //스크롤팬 설정
        JScrollPane employForumScrollPane = new JScrollPane(employTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        employForumScrollPane.setVisible(true);
        employForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumEmploy.add(employForumScrollPane);

        //자유게시판 전환 버튼
        JButton employForumGeneralButton = new JButton();
        employForumGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interest = 0;
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
                interest = 1;
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
                interest = 2;
                panelForumEmploy.setVisible(false);
                panelForumPrograming.setVisible(true);
            }
        });
        employForumProgramingButton.setText("프로그래밍");
        employForumProgramingButton.setFont(ButtonFont);
        employForumProgramingButton.setBounds(310, 20, 150, 80);
        employForumProgramingButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumProgramingButton);

        //취업 갱신 버튼
        JButton employForumEmployButton = new JButton();
        employForumEmployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable(Long.valueOf(3), employ_dtm);
            }
        });
        employForumEmployButton.setText("취업게시판");
        employForumEmployButton.setFont(ButtonFont);
        employForumEmployButton.setBounds(459, 20, 150, 80);
        employForumEmployButton.setContentAreaFilled(true);
        panelForumEmploy.add(employForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_employPage = new JButton();
        addPostButton_employPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelForumEmploy.setVisible(false);
                panelAddPost.setVisible(true);
            }
        });
        addPostButton_employPage.setText("글쓰기");
        addPostButton_employPage.setFont(ButtonFont);
        addPostButton_employPage.setBounds(964, 100, 120, 80);
        addPostButton_employPage.setContentAreaFilled(true);
        panelForumEmploy.add(addPostButton_employPage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //제목 입력받기
        JLabel addPostTitlLabel = new JLabel();
        addPostTitlLabel.setText("제목");
        addPostTitlLabel.setFont(ButtonFont);
        addPostTitlLabel.setBounds(50, 135, 100, 50);
        panelAddPost.add(addPostTitlLabel);
        JTextField addPostTitlTextField = new JTextField();
        addPostTitlTextField.setFont(ButtonFont);
        addPostTitlTextField.setBounds(110, 140, 500, 40);
        panelAddPost.add(addPostTitlTextField);

        //카테고리 선택
        JComboBox<String> addPostCategoryBox = new JComboBox();
        addPostCategoryBox.setModel(new DefaultComboBoxModel(new String[] {"자유게시판", "운동게시판", "프로그래밍", "취업게시판"}));
        addPostCategoryBox.setFont(ButtonFont);
        addPostCategoryBox.setBounds(630, 140, 130, 40);
        panelAddPost.add(addPostCategoryBox);

        //내용 입력받기
        JLabel addPostContentLabel = new JLabel();
        addPostContentLabel.setText("내용");
        addPostContentLabel.setFont(ButtonFont);
        addPostContentLabel.setBounds(50, 200, 100, 50);
        panelAddPost.add(addPostContentLabel);
        JTextArea addPostContentTextArea = new JTextArea(10, 10);
        addPostContentTextArea.setFont(ButtonFont);
        addPostContentTextArea.setLineWrap(true);
        JScrollPane scrollAddPostContent = new JScrollPane(addPostContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAddPostContent.setBounds(110, 220, 800, 550);
        scrollAddPostContent.setVisible(true);
        panelAddPost.add(scrollAddPostContent);

        //제출하기
        JButton addPostSubmitButton = new JButton();
        addPostSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addPostTitlTextField.getText().length() > 1000){
                    JOptionPane.showMessageDialog(null, "최대 1000자까지 작성 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
                }else{
                    int interest = addPostCategoryBox.getSelectedIndex();
                    switch (interest){
                        case 0: addTable(Long.valueOf(addPostCategoryBox.getSelectedIndex()), general_dtm, addPostTitlTextField.getText(), addPostContentTextArea.getText());
                            panelAddPost.setVisible(false);
                            panelForumGeneral.setVisible(true);
                            addPostTitlTextField.setText("");
                            addPostContentTextArea.setText("");
                            break;
                        case 1:addTable(Long.valueOf(addPostCategoryBox.getSelectedIndex()), excercise_dtm, addPostTitlTextField.getText(), addPostContentTextArea.getText());
                            panelAddPost.setVisible(false);
                            panelForumExcercise.setVisible(true);
                            addPostTitlTextField.setText("");
                            addPostContentTextArea.setText("");
                            break;
                        case 2:addTable(Long.valueOf(addPostCategoryBox.getSelectedIndex()), programing_dtm, addPostTitlTextField.getText(), addPostContentTextArea.getText());
                            panelAddPost.setVisible(false);
                            panelForumPrograming.setVisible(true);
                            addPostTitlTextField.setText("");
                            addPostContentTextArea.setText("");
                            break;
                        case 3:addTable(Long.valueOf(addPostCategoryBox.getSelectedIndex()), employ_dtm, addPostTitlTextField.getText(), addPostContentTextArea.getText());
                            panelAddPost.setVisible(false);
                            panelForumEmploy.setVisible(true);
                            addPostTitlTextField.setText("");
                            addPostContentTextArea.setText("");
                            break;
                    }

                }
            }
        });
        addPostSubmitButton.setText("제출");
        addPostSubmitButton.setFont(ButtonFont);
        addPostSubmitButton.setBounds(940, 690, 120, 80);
        addPostSubmitButton.setContentAreaFilled(true);
        panelAddPost.add(addPostSubmitButton);

    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시판 업데이트 함수
    void updateTable(Long interest, DefaultTableModel dtm){

    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시판 글 추가 함수
    void addTable(Long interest, DefaultTableModel dtm, String title, String content){
        try {
            //request보내기
            //user_id DB에서 받아오기
            int user_id = 1;
            //request 보낼 url
            String uri = "http://localhost:8080/api/user" + user_id + "/post";
            //request body
            Post post = new Post(interest, title, content);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String requestBody = objectMapper.writeValueAsString(post);
                System.out.println(requestBody);
                //request header
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(uri))
                        .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                        .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                        .build();
                //DB에 정보만 보내고 새로고침 함수를 호출한다.
                updateTable(interest, dtm);
            } catch (JsonProcessingException ex) {
                System.out.println("서버 요청 오류");
                ex.printStackTrace();
            }
        }catch(Exception e){
            System.out.println("서버 응답 오류");
        }



    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    class myPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\background5.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    class myPanel2 extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\background6.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
