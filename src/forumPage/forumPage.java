package forumPage;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class forumPage extends JFrame {
    private final Font mainFont = new Font("나눔고딕", Font.PLAIN, 20);
    private final Font smallFont = new Font("나눔고딕", Font.PLAIN, 17);
    private final Font tinyFont = new Font("나눔고딕", Font.PLAIN, 13);
    private final Font bigFont = new Font("나눔고딕", Font.PLAIN, 25);
    private final Font giantFont = new Font("나눔고딕", Font.BOLD, 35);
    private final myPanel panelForumGeneral = new myPanel();
    private final myPanel panelForumExercise = new myPanel();
    private final myPanel panelForumPrograming = new myPanel();
    private final myPanel panelForumEmploy = new myPanel();
    private final myPanel2 panelAddPost = new myPanel2();
    private final myPanel panelClickPost = new myPanel();
    private final myPanel2 panelModifyPost = new myPanel2();
    //user_id DB에서 받아오기.
    private final Long user_id = (long)1;
    private int interest = 0; //관심분야, 1, 2, 3 순서대로 운동, 프로그래밍, 취업 0인 경우 자유 게시판 글
    private String post_id;

    //테이블 선언
    private DefaultTableModel general_dtm = new DefaultTableModel(0, 0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable generalTable = new JTable(general_dtm);

    private DefaultTableModel exercise_dtm = new DefaultTableModel(0, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable exerciseTable = new JTable(exercise_dtm);

    private DefaultTableModel programing_dtm = new DefaultTableModel(0, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable programingTable = new JTable(programing_dtm);

    private DefaultTableModel employ_dtm = new DefaultTableModel(0, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable employTable = new JTable(employ_dtm);

    private DefaultTableModel comment_dtm = new DefaultTableModel(0, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable commentTable = new JTable(comment_dtm);
    private JScrollPane commentScrollPane;

    public forumPage() {
        //프레임 설정
        setTitle("1M1S-forum");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panelForumGeneral);
        add(panelForumExercise);
        add(panelForumPrograming);
        add(panelForumEmploy);
        add(panelAddPost);
        add(panelClickPost);
        add(panelModifyPost);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 설정
        //ForumGeneral이 가장 먼저 보이고, 이는 자유게시판패널이다.
        panelForumGeneral.setSize(1100, 824);
        panelForumGeneral.setLayout(null);
        panelForumGeneral.setVisible(true);
        //Forumexercise, 운동게시판
        panelForumExercise.setSize(1100, 824);
        panelForumExercise.setLayout(null);
        panelForumExercise.setVisible(false);
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
        //게시글 클릭 패널
        panelClickPost.setSize(1100, 824);
        panelClickPost.setLayout(null);
        panelClickPost.setVisible(false);
        //게시글 수정 패널
        panelModifyPost.setSize(1100, 824);
        panelModifyPost.setLayout(null);
        panelModifyPost.setVisible(false);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //테이블 설정
        //table header
        String[] header = {"id", "interest", "title", "content"};

        //자유테이블 설정
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
        //마우스 이벤트 추가
        generalTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane generalForumScrollPane = new JScrollPane(generalTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        generalForumScrollPane.setVisible(true);
        generalForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumGeneral.add(generalForumScrollPane);

        //운동테이블 설정
        //칼럼 만들기
        exercise_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        exerciseTable.getColumn("id").setWidth(0);
        exerciseTable.getColumn("id").setMinWidth(0);
        exerciseTable.getColumn("id").setMaxWidth(0);
        exerciseTable.getColumn("interest").setWidth(0);
        exerciseTable.getColumn("interest").setMinWidth(0);
        exerciseTable.getColumn("interest").setMaxWidth(0);
        exerciseTable.getColumn("title").setWidth(250);
        exerciseTable.getColumn("title").setMinWidth(250);
        exerciseTable.getColumn("title").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        exerciseTable.getTableHeader().setReorderingAllowed(false);
        exerciseTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        exerciseTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane exerciseForumScrollPane = new JScrollPane(exerciseTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        exerciseForumScrollPane.setVisible(true);
        exerciseForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumExercise.add(exerciseForumScrollPane);

        //프로그래밍테이블 설정
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
        programingTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        programingTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane programingForumScrollPane = new JScrollPane(programingTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        programingForumScrollPane.setVisible(true);
        programingForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumPrograming.add(programingForumScrollPane);

        //취업테이블 설정
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
        employTable.getTableHeader().setReorderingAllowed(false);
        employTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        employTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane employForumScrollPane = new JScrollPane(employTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        employForumScrollPane.setVisible(true);
        employForumScrollPane.setBounds(25, 110, 850, 650);
        panelForumEmploy.add(employForumScrollPane);

        //댓글테이블 설정
        //칼럼 만들기
        String[] header2 = {"comment_id", "user_id", "content"};
        comment_dtm.setColumnIdentifiers(header2);
        //comment_id
        commentTable.getColumn("comment_id").setWidth(0);
        commentTable.getColumn("comment_id").setMinWidth(0);
        commentTable.getColumn("comment_id").setMaxWidth(0);
        commentTable.getColumn("user_id").setWidth(100);
        commentTable.getColumn("user_id").setMinWidth(100);
        commentTable.getColumn("user_id").setMaxWidth(100);
        //컬럼 크기, 위치 조절 불가
        commentTable.getTableHeader().setReorderingAllowed(false);
        commentTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        commentTable.addMouseListener(new MyMouseListener2());
        //스크롤팬 설정
        commentScrollPane = new JScrollPane(commentTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        commentScrollPane.setVisible(true);
        commentScrollPane.setBounds(35, 505, 800, 190);
        panelClickPost.add(commentScrollPane);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************        //패널 자유게시판

        //창 끄기 버튼

        //포럼페이지를 키자마자 자유게시판 테이블이 생성되고 동시에 게시판을 업데이트한다.
        updatePost(general_dtm);

        //자유게시판 갱신 버튼
        JButton generalForumGeneralButton = new JButton();
        generalForumGeneralButton.addActionListener(e -> {
            interest = 0;
            updatePost(general_dtm);
        });
        generalForumGeneralButton.setText("자유게시판");
        generalForumGeneralButton.setFont(mainFont);
        generalForumGeneralButton.setBounds(12, 20, 150, 80);
        generalForumGeneralButton.setContentAreaFilled(true);
        panelForumGeneral.add(generalForumGeneralButton);

        //운동게시판 전환 버튼
        JButton generalForumExerciseButton = new JButton();
        generalForumExerciseButton.addActionListener(e -> {
            interest = 1;
            panelForumGeneral.setVisible(false);
            panelForumExercise.setVisible(true);
            updatePost(exercise_dtm);
        });
        generalForumExerciseButton.setText("운동게시판");
        generalForumExerciseButton.setFont(mainFont);
        generalForumExerciseButton.setBounds(161, 20, 150, 80);
        generalForumExerciseButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumExerciseButton);

        //프로그래밍 전환 버튼
        JButton generalForumProgramingButton = new JButton();
        generalForumProgramingButton.addActionListener(e -> {
            interest = 2;
            panelForumGeneral.setVisible(false);
            panelForumPrograming.setVisible(true);
            updatePost(programing_dtm);
        });
        generalForumProgramingButton.setText("프로그래밍");
        generalForumProgramingButton.setFont(mainFont);
        generalForumProgramingButton.setBounds(310, 20, 150, 80);
        generalForumProgramingButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumProgramingButton);

        //취업 전환 버튼
        JButton generalForumEmployButton = new JButton();
        generalForumEmployButton.addActionListener(e -> {
            interest = 3;
            panelForumGeneral.setVisible(false);
            panelForumEmploy.setVisible(true);
            updatePost(employ_dtm);
        });
        generalForumEmployButton.setText("취업게시판");
        generalForumEmployButton.setFont(mainFont);
        generalForumEmployButton.setBounds(459, 20, 150, 80);
        generalForumEmployButton.setContentAreaFilled(false);
        panelForumGeneral.add(generalForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_generalPage = new JButton();
        addPostButton_generalPage.addActionListener(e -> {
            panelForumGeneral.setVisible(false);
            panelAddPost.setVisible(true);
        });
        addPostButton_generalPage.setText("글쓰기");
        addPostButton_generalPage.setFont(mainFont);
        addPostButton_generalPage.setBounds(964, 100, 120, 80);
        addPostButton_generalPage.setContentAreaFilled(true);
        panelForumGeneral.add(addPostButton_generalPage);


        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 운동게시판
        //창 끄기 버튼

        //자유게시판 전환 버튼
        JButton exerciseForumGeneralButton = new JButton();
        exerciseForumGeneralButton.addActionListener(e -> {
            interest = 0;
            panelForumExercise.setVisible(false);
            panelForumGeneral.setVisible(true);
            updatePost(general_dtm);
        });
        exerciseForumGeneralButton.setText("자유게시판");
        exerciseForumGeneralButton.setFont(mainFont);
        exerciseForumGeneralButton.setBounds(12, 20, 150, 80);
        exerciseForumGeneralButton.setContentAreaFilled(false);
        panelForumExercise.add(exerciseForumGeneralButton);

        //운동게시판 갱신 버튼
        JButton exerciseForumExerciseButton = new JButton();
        exerciseForumExerciseButton.addActionListener(e -> {
            interest = 1;
            updatePost(exercise_dtm);
       });
        exerciseForumExerciseButton.setText("운동게시판");
        exerciseForumExerciseButton.setFont(mainFont);
        exerciseForumExerciseButton.setBounds(161, 20, 150, 80);
        exerciseForumExerciseButton.setContentAreaFilled(true);
        panelForumExercise.add(exerciseForumExerciseButton);

        //프로그래밍 전환 버튼
        JButton exerciseForumProgramingButton = new JButton();
        exerciseForumProgramingButton.addActionListener(e -> {
            interest = 2;
            panelForumExercise.setVisible(false);
            panelForumPrograming.setVisible(true);
            updatePost(programing_dtm);
        });
        exerciseForumProgramingButton.setText("프로그래밍");
        exerciseForumProgramingButton.setFont(mainFont);
        exerciseForumProgramingButton.setBounds(310, 20, 150, 80);
        exerciseForumProgramingButton.setContentAreaFilled(false);
        panelForumExercise.add(exerciseForumProgramingButton);

        //취업 전환 버튼
        JButton exerciseForumEmployButton = new JButton();
        exerciseForumEmployButton.addActionListener(e -> {
            interest = 3;
            panelForumExercise.setVisible(false);
            panelForumEmploy.setVisible(true);
            updatePost(employ_dtm);
        });
        exerciseForumEmployButton.setText("취업게시판");
        exerciseForumEmployButton.setFont(mainFont);
        exerciseForumEmployButton.setBounds(459, 20, 150, 80);
        exerciseForumEmployButton.setContentAreaFilled(false);
        panelForumExercise.add(exerciseForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_exercisePage = new JButton();
        addPostButton_exercisePage.addActionListener(e -> {
            panelForumExercise.setVisible(false);
            panelAddPost.setVisible(true);
        });
        addPostButton_exercisePage.setText("글쓰기");
        addPostButton_exercisePage.setFont(mainFont);
        addPostButton_exercisePage.setBounds(964, 100, 120, 80);
        addPostButton_exercisePage.setContentAreaFilled(true);
        panelForumExercise.add(addPostButton_exercisePage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 프로그래밍
        //창 끄기 버튼

        //자유게시판 전환 버튼
        JButton programingForumGeneralButton = new JButton();
        programingForumGeneralButton.addActionListener(e -> {
            interest = 0;
            panelForumPrograming.setVisible(false);
            panelForumGeneral.setVisible(true);
            updatePost(general_dtm);
        });
        programingForumGeneralButton.setText("자유게시판");
        programingForumGeneralButton.setFont(mainFont);
        programingForumGeneralButton.setBounds(12, 20, 150, 80);
        programingForumGeneralButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumGeneralButton);

        //운동게시판 전환 버튼
        JButton programingForumExerciseButton = new JButton();
        programingForumExerciseButton.addActionListener(e -> {
            interest = 1;
            panelForumPrograming.setVisible(false);
            panelForumExercise.setVisible(true);
            updatePost(exercise_dtm);
        });
        programingForumExerciseButton.setText("운동게시판");
        programingForumExerciseButton.setFont(mainFont);
        programingForumExerciseButton.setBounds(161, 20, 150, 80);
        programingForumExerciseButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumExerciseButton);

        //프로그래밍 업데이트 버튼
        JButton programingForumProgramingButton = new JButton();
        programingForumProgramingButton.addActionListener(e -> {
            interest = 2;
            updatePost(programing_dtm);
        });
        programingForumProgramingButton.setText("프로그래밍");
        programingForumProgramingButton.setFont(mainFont);
        programingForumProgramingButton.setBounds(310, 20, 150, 80);
        programingForumProgramingButton.setContentAreaFilled(true);
        panelForumPrograming.add(programingForumProgramingButton);

        //취업 전환 버튼
        JButton programingForumEmployButton = new JButton();
        programingForumEmployButton.addActionListener(e -> {
            interest = 3;
            panelForumPrograming.setVisible(false);
            panelForumEmploy.setVisible(true);
            updatePost(employ_dtm);
        });
        programingForumEmployButton.setText("취업게시판");
        programingForumEmployButton.setFont(mainFont);
        programingForumEmployButton.setBounds(459, 20, 150, 80);
        programingForumEmployButton.setContentAreaFilled(false);
        panelForumPrograming.add(programingForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_programingPage = new JButton();
        addPostButton_programingPage.addActionListener(e -> {
            panelForumPrograming.setVisible(false);
            panelAddPost.setVisible(true);
        });
        addPostButton_programingPage.setText("글쓰기");
        addPostButton_programingPage.setFont(mainFont);
        addPostButton_programingPage.setBounds(964, 100, 120, 80);
        addPostButton_programingPage.setContentAreaFilled(true);
        panelForumPrograming.add(addPostButton_programingPage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 취업게시판
        //창 끄기 버튼

        //자유게시판 전환 버튼
        JButton employForumGeneralButton = new JButton();
        employForumGeneralButton.addActionListener(e -> {
            interest = 0;
            panelForumEmploy.setVisible(false);
            panelForumGeneral.setVisible(true);
            updatePost(general_dtm);
        });
        employForumGeneralButton.setText("자유게시판");
        employForumGeneralButton.setFont(mainFont);
        employForumGeneralButton.setBounds(12, 20, 150, 80);
        employForumGeneralButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumGeneralButton);

        //운동게시판 전환 버튼
        JButton employForumExerciseButton = new JButton();
        employForumExerciseButton.addActionListener(e -> {
            interest = 1;
            panelForumEmploy.setVisible(false);
            panelForumExercise.setVisible(true);
            updatePost(exercise_dtm);
        });
        employForumExerciseButton.setText("운동게시판");
        employForumExerciseButton.setFont(mainFont);
        employForumExerciseButton.setBounds(161, 20, 150, 80);
        employForumExerciseButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumExerciseButton);

        //프로그래밍 전환 버튼
        JButton employForumProgramingButton = new JButton();
        employForumProgramingButton.addActionListener(e -> {
            interest = 2;
            panelForumEmploy.setVisible(false);
            panelForumPrograming.setVisible(true);
            updatePost(programing_dtm);
        });
        employForumProgramingButton.setText("프로그래밍");
        employForumProgramingButton.setFont(mainFont);
        employForumProgramingButton.setBounds(310, 20, 150, 80);
        employForumProgramingButton.setContentAreaFilled(false);
        panelForumEmploy.add(employForumProgramingButton);

        //취업 갱신 버튼
        JButton employForumEmployButton = new JButton();
        employForumEmployButton.addActionListener(e -> {
            interest = 3;
            updatePost(employ_dtm);
        });
        employForumEmployButton.setText("취업게시판");
        employForumEmployButton.setFont(mainFont);
        employForumEmployButton.setBounds(459, 20, 150, 80);
        employForumEmployButton.setContentAreaFilled(true);
        panelForumEmploy.add(employForumEmployButton);

        //글쓰기 버튼
        JButton addPostButton_employPage = new JButton();
        addPostButton_employPage.addActionListener(e -> {
            panelForumEmploy.setVisible(false);
            panelAddPost.setVisible(true);
        });
        addPostButton_employPage.setText("글쓰기");
        addPostButton_employPage.setFont(mainFont);
        addPostButton_employPage.setBounds(964, 100, 120, 80);
        addPostButton_employPage.setContentAreaFilled(true);
        panelForumEmploy.add(addPostButton_employPage);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //글 추가 패널
        //되돌아가기 버튼
        JButton addPostPageRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\rollback.png")));
        addPostPageRollBackButton.addActionListener(e -> {
            switch (interest) {
                case 0 -> {
                    panelAddPost.setVisible(false);
                    panelForumGeneral.setVisible(true);
                    updatePost(general_dtm);
                }
                case 1 -> {
                    panelAddPost.setVisible(false);
                    panelForumExercise.setVisible(true);
                    updatePost(exercise_dtm);
                }
                case 2 -> {
                    panelAddPost.setVisible(false);
                    panelForumPrograming.setVisible(true);
                    updatePost(programing_dtm);
                }
                case 3 -> {
                    panelAddPost.setVisible(false);
                    panelForumEmploy.setVisible(true);
                    updatePost(employ_dtm);
                }
            }
        });
        addPostPageRollBackButton.setFont(mainFont);
        addPostPageRollBackButton.setBounds(1000, 110, 80, 80);
        addPostPageRollBackButton.setContentAreaFilled(false);
        panelAddPost.add(addPostPageRollBackButton);

        //제목 입력받기
        JLabel addPostTitlLabel = new JLabel();
        addPostTitlLabel.setText("제목");
        addPostTitlLabel.setFont(mainFont);
        addPostTitlLabel.setBounds(50, 135, 100, 50);
        panelAddPost.add(addPostTitlLabel);
        JTextField addPostTitleTextField = new JTextField();
        addPostTitleTextField.setFont(mainFont);
        addPostTitleTextField.setBounds(110, 140, 500, 40);
        panelAddPost.add(addPostTitleTextField);

        //카테고리 선택
        JComboBox<String> addPostCategoryBox = new JComboBox();
        addPostCategoryBox.setModel(new DefaultComboBoxModel(new String[] {"자유게시판", "운동게시판", "프로그래밍", "취업게시판"}));
        addPostCategoryBox.setFont(mainFont);
        addPostCategoryBox.setBounds(630, 140, 130, 40);
        panelAddPost.add(addPostCategoryBox);

        //내용 입력받기
        JLabel addPostContentLabel = new JLabel();
        addPostContentLabel.setText("내용");
        addPostContentLabel.setFont(mainFont);
        addPostContentLabel.setBounds(50, 200, 100, 50);
        panelAddPost.add(addPostContentLabel);
        JTextArea addPostContentTextArea = new JTextArea(10, 10);
        addPostContentTextArea.setFont(mainFont);
        addPostContentTextArea.setLineWrap(true);
        JScrollPane scrollAddPostContent = new JScrollPane(addPostContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAddPostContent.setBounds(110, 220, 800, 550);
        scrollAddPostContent.setVisible(true);
        panelAddPost.add(scrollAddPostContent);

        //제출하기
        JButton addPostSubmitButton = new JButton();
        addPostSubmitButton.addActionListener(e -> {
            if(addPostTitleTextField.equals("")){
                JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(addPostContentTextArea.getText().equals("")){
                JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(addPostTitleTextField.getText().length() > 256){
                JOptionPane.showMessageDialog(null, "최대 256자까지 작성 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
            }else{
                switch (interest) {
                    case 0 -> {
                        addPost(general_dtm, addPostTitleTextField.getText(), addPostContentTextArea.getText());
                        panelAddPost.setVisible(false);
                        panelForumGeneral.setVisible(true);
                        addPostTitleTextField.setText("");
                        addPostContentTextArea.setText("");
                    }
                    case 1 -> {
                        addPost(exercise_dtm, addPostTitleTextField.getText(), addPostContentTextArea.getText());
                        panelAddPost.setVisible(false);
                        panelForumExercise.setVisible(true);
                        addPostTitleTextField.setText("");
                        addPostContentTextArea.setText("");
                    }
                    case 2 -> {
                        addPost(programing_dtm, addPostTitleTextField.getText(), addPostContentTextArea.getText());
                        panelAddPost.setVisible(false);
                        panelForumPrograming.setVisible(true);
                        addPostTitleTextField.setText("");
                        addPostContentTextArea.setText("");
                    }
                    case 3 -> {
                        addPost(employ_dtm, addPostTitleTextField.getText(), addPostContentTextArea.getText());
                        panelAddPost.setVisible(false);
                        panelForumEmploy.setVisible(true);
                        addPostTitleTextField.setText("");
                        addPostContentTextArea.setText("");
                    }
                }
            }
        });
        addPostSubmitButton.setText("제출");
        addPostSubmitButton.setFont(mainFont);
        addPostSubmitButton.setBounds(940, 690, 120, 80);
        addPostSubmitButton.setContentAreaFilled(true);
        panelAddPost.add(addPostSubmitButton);
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시판 업데이트 함수
    void updatePost(DefaultTableModel dtm){
        dtm.setRowCount(0); //테이블 초기화
        try{
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            //request보내기
            String uri = "http://localhost:8080/api/post?interest_id=" + interest;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))  // 위에서 만든 URI
                    .GET()  // HTTP 메소드, body 지정(GET의 경우 생략 가능)
                    .build();

            // 위에서 생성한 request를 보내고, 받은 response를 저장
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // responseBody to Post Class Array
            Post[] posts = mapper.readValue(response.body(), Post[].class);

            // Jtable에 일정 추가
            for(Post p : posts) {
                dtm.addRow(new Object[] {p.getId(), p.getInterest(), p.getTitle(), p.getContent()});
            }
        }catch(Exception e){
             System.out.println("게시글 업데이트 오류");
             e.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시판 글 추가 함수
    void addPost(DefaultTableModel dtm, String title, String content) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper objectMapper = new ObjectMapper();

            //request 보내기
            String uri = "http://localhost:8080/api/user/" + user_id + "/post";
            //request body
            Post post = new Post((long) interest, title, content);
            String requestBody = objectMapper.writeValueAsString(post);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                    .build();

            //response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //update
            updatePost(dtm);
        } catch (Exception ex) {
            System.out.println("글 추가 오류");
            ex.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //글 클릭 함수
    void clickPost(JTable table){
        //글을 클릭하면 panelClickPost패널의 컴포넌트 모두 지우고 요청이 들어온 게시글의 정보를 받아서 panelClickPost패널에 추가한다.
        panelClickPost.removeAll();
        panelClickPost.revalidate();
        panelClickPost.repaint();
        panelClickPost.setSize(1100, 824);
        panelClickPost.setLayout(null);
        panelClickPost.setVisible(true);

        //되돌아가기 버튼
        JButton clickPageRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\rollback.png")));
        clickPageRollBackButton.addActionListener(e -> {
            switch (interest) {
                case 0 -> {
                    panelClickPost.setVisible(false);
                    panelForumGeneral.setVisible(true);
                    updatePost(general_dtm);
                }
                case 1 -> {
                    panelClickPost.setVisible(false);
                    panelForumExercise.setVisible(true);
                    updatePost(exercise_dtm);
                }
                case 2 -> {
                    panelClickPost.setVisible(false);
                    panelForumPrograming.setVisible(true);
                    updatePost(programing_dtm);
                }
                case 3 -> {
                    panelClickPost.setVisible(false);
                    panelForumEmploy.setVisible(true);
                    updatePost(employ_dtm);
                }
            }
        });
        clickPageRollBackButton.setFont(mainFont);
        clickPageRollBackButton.setBounds(985, 110, 82, 82);
        clickPageRollBackButton.setContentAreaFilled(false);
        panelClickPost.add(clickPageRollBackButton);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpClient client = HttpClient.newHttpClient();

            int row = table.getSelectedRow();
            post_id = String.valueOf(table.getValueAt(row, 0));

            //request 보내기
            String uri = "http://localhost:8080/api/post/" + post_id;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                    .GET()
                    .build();

            //response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //responsebody to Post Clas
            Post apost = objectMapper.readValue(response.body(), Post.class);

            //apost의 내용을 패널에 출력
            //카테고리
            String category = switch (interest) {
                case 0 -> "자유게시판";
                case 1 -> "운동게시판";
                case 2 -> "프로그래밍";
                case 3 -> "취업게시판";
                default -> "";
            };
            JLabel clickPostCategoryLabel = new JLabel();
            clickPostCategoryLabel.setText(category);
            clickPostCategoryLabel.setFont(giantFont);
            clickPostCategoryLabel.setBounds(23, 23, 800, 50);
            panelClickPost.add(clickPostCategoryLabel);

            //제목 출력
            JLabel clickPostTitleLabel = new JLabel();
            clickPostTitleLabel.setText(apost.getTitle());
            clickPostTitleLabel.setFont(bigFont);
            clickPostTitleLabel.setBounds(35, 105, 800, 50);
            panelClickPost.add(clickPostTitleLabel);

            //내용 출력
            JTextArea clickPostContentTextArea = new JTextArea(10, 10);
            clickPostContentTextArea.setFont(smallFont);
            clickPostContentTextArea.setLineWrap(true);
            clickPostContentTextArea.setEditable(false);
            clickPostContentTextArea.setText(apost.getContent());
            JScrollPane scrollClickPostContent = new JScrollPane(clickPostContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollClickPostContent.setBounds(35, 165, 800, 340);
            scrollClickPostContent.setVisible(true);
            panelClickPost.add(scrollClickPostContent);

            //글 수정하기
            if(Objects.equals(user_id, apost.getMember().getId())) {
                try {
                    //글 수정 버튼
                    JButton modifyButton = new JButton("글 수정");
                    modifyButton.addActionListener(e -> {
                        panelClickPost.setVisible(false);
                        panelModifyPost.setVisible(true);
                        modifyPost(apost);
                    });
                    modifyButton.setFont(mainFont);
                    modifyButton.setBounds(970, 210, 110, 80);
                    modifyButton.setContentAreaFilled(false);
                    panelClickPost.add(modifyButton);

                } catch (Exception ex) {
                    System.out.println("글 수정 함수 호출 오류");
                    ex.printStackTrace();
                }

                try {
                    //글 삭제 버튼
                    JButton deleteButton = new JButton("글 삭제");
                    deleteButton.addActionListener(e -> {
                        int confirmDelete = JOptionPane.showConfirmDialog(null,
                                "글을 삭제하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);

                        if(confirmDelete == 0){
                            HttpClient client1 = HttpClient.newHttpClient();

                            //request 보내기
                            String uri1 = "http://localhost:8080/api/user/" + user_id + "/post/" + post_id;
                            HttpRequest request1 = HttpRequest.newBuilder()
                                    .uri(URI.create(uri1))
                                    .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                                    .DELETE() //Delete는 body없어도 동작
                                    .build();

                            try {
                                //response
                                HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());

                                //패널전환
                                switch (interest) {
                                    case 0 -> {
                                        updatePost(general_dtm);
                                        panelForumGeneral.setVisible(true);
                                        panelClickPost.setVisible(false);
                                    }
                                    case 1 -> {
                                        updatePost(exercise_dtm);
                                        panelForumExercise.setVisible(true);
                                        panelClickPost.setVisible(false);
                                    }
                                    case 2 -> {
                                        updatePost(programing_dtm);
                                        panelForumPrograming.setVisible(true);
                                        panelClickPost.setVisible(false);
                                    }
                                    case 3 -> {
                                        updatePost(employ_dtm);
                                        panelForumEmploy.setVisible(true);
                                        panelClickPost.setVisible(false);
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("글 삭제 응답오류");
                                ex.printStackTrace();
                            }
                        }
                    });
                    deleteButton.setFont(mainFont);
                    deleteButton.setBounds(970, 310, 110, 80);
                    deleteButton.setContentAreaFilled(false);
                    panelClickPost.add(deleteButton);

                } catch (Exception ex) {
                    System.out.println("글 삭제 오류");
                    ex.printStackTrace();
                }
            }

            //댓글테이블 추가
            panelClickPost.add(commentScrollPane);
            updateComment();

            //댓글쓰기
            JTextArea addCommentTextArea = new JTextArea(10, 10);
            addCommentTextArea.setFont(tinyFont);
            addCommentTextArea.setLineWrap(true);
            JScrollPane scrollAddComment = new JScrollPane(addCommentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollAddComment.setBounds(35, 695, 740, 60);
            scrollAddComment.setVisible(true);
            panelClickPost.add(scrollAddComment);

            //댓글쓰기버튼
            JButton addCommentButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\comment.png")));
            addCommentButton.addActionListener(e -> {
                if(!addCommentTextArea.equals("")){
                    addComment(addCommentTextArea.getText());
                    addCommentTextArea.setText("");
                    comment_dtm.fireTableDataChanged();
                }
            });
            addCommentButton.setFont(mainFont);
            addCommentButton.setBounds(775, 695, 60, 60);
            addCommentButton.setContentAreaFilled(false);
            panelClickPost.add(addCommentButton);


        } catch (Exception ex) {
            System.out.println("글 클릭 오류");
            ex.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시글 테이블 클릭 이벤트
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount() == 2 ){
                switch (interest) {
                    case 0 -> {
                        panelForumGeneral.setVisible(false);
                        clickPost(generalTable);
                    }
                    case 1 -> {
                        panelForumExercise.setVisible(false);
                        clickPost(exerciseTable);
                    }
                    case 2 -> {
                        panelForumPrograming.setVisible(false);
                        clickPost(programingTable);
                    }
                    case 3 -> {
                        panelForumEmploy.setVisible(false);
                        clickPost(employTable);
                    }
                }
            }
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시글 수정하는 패널
    private void modifyPost(Post post){
        //패널 초기화
        panelModifyPost.removeAll();
        panelModifyPost.revalidate();
        panelModifyPost.repaint();
        panelModifyPost.setSize(1100, 824);
        panelModifyPost.setLayout(null);
        panelModifyPost.setVisible(true);

        //되돌아가기 버튼
        JButton modifyPostPageRollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\rollback.png")));
        modifyPostPageRollBackButton.addActionListener(e -> {
            panelModifyPost.setVisible(false);
            panelClickPost.setVisible(true);
        });
        modifyPostPageRollBackButton.setFont(mainFont);
        modifyPostPageRollBackButton.setBounds(1000, 110, 80, 80);
        modifyPostPageRollBackButton.setContentAreaFilled(false);
        panelModifyPost.add(modifyPostPageRollBackButton);

        //제목 수정
        JLabel modifyPostTitleLabel = new JLabel();
        modifyPostTitleLabel.setText("제목");
        modifyPostTitleLabel.setFont(mainFont);
        modifyPostTitleLabel.setBounds(50, 135, 100, 50);
        panelModifyPost.add(modifyPostTitleLabel);
        JTextField modifyPostTitleTextField = new JTextField();
        modifyPostTitleTextField.setFont(mainFont);
        modifyPostTitleTextField.setBounds(110, 140, 500, 40);
        modifyPostTitleTextField.setText(post.getTitle());
        panelModifyPost.add(modifyPostTitleTextField);

        //내용 수정
        JLabel modifyPostContentLabel = new JLabel();
        modifyPostContentLabel.setText("내용");
        modifyPostContentLabel.setFont(mainFont);
        modifyPostContentLabel.setBounds(50, 200, 100, 50);
        panelModifyPost.add(modifyPostContentLabel);
        JTextArea modifyPostContentTextArea = new JTextArea(10, 10);
        modifyPostContentTextArea.setFont(mainFont);
        modifyPostContentTextArea.setLineWrap(true);
        modifyPostContentTextArea.setText(post.getContent());
        JScrollPane scrollModifyPostContent = new JScrollPane(modifyPostContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollModifyPostContent.setBounds(110, 220, 800, 550);
        scrollModifyPostContent.setVisible(true);
        panelModifyPost.add(scrollModifyPostContent);

        //수정 제출 버튼
        JButton modifyPostSubmitButton = new JButton();
        modifyPostSubmitButton.addActionListener(e -> {
            if(modifyPostTitleTextField.equals("")){
                JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(modifyPostContentTextArea.getText().equals("")){
                JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }else if(modifyPostTitleTextField.getText().length() > 256){
                JOptionPane.showMessageDialog(null, "최대 256자까지 작성 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    HttpClient client = HttpClient.newHttpClient();

                    //request 보내기
                    String uri = "http://localhost:8080/api/user/" + user_id + "/post/" + post.getId();
                    //request body
                    Post modifyPost = new Post((long)interest, modifyPostTitleTextField.getText(), modifyPostContentTextArea.getText());
                    String requestBody = objectMapper.writeValueAsString(modifyPost);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                            .build();

                    //response
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    modifyPostTitleTextField.setText("");
                    modifyPostContentTextArea.setText("");

                    switch (interest) {
                        case 0 -> {
                            panelModifyPost.setVisible(false);
                            panelForumGeneral.setVisible(true);
                            updatePost(general_dtm);
                        }
                        case 1 -> {
                            panelModifyPost.setVisible(false);
                            panelForumExercise.setVisible(true);
                            updatePost(exercise_dtm);
                        }
                        case 2 -> {
                            panelModifyPost.setVisible(false);
                            panelForumPrograming.setVisible(true);
                            updatePost(programing_dtm);
                        }
                        case 3 -> {
                            panelModifyPost.setVisible(false);
                            panelForumEmploy.setVisible(true);
                            updatePost(employ_dtm);
                        }
                    }
                }catch (Exception exception){
                    System.out.println("글 수정 오류");
                    exception.printStackTrace();
                }
            }
        });
        modifyPostSubmitButton.setText("수정하기");
        modifyPostSubmitButton.setFont(mainFont);
        modifyPostSubmitButton.setBounds(930, 690, 130, 80);
        modifyPostSubmitButton.setContentAreaFilled(true);
        panelModifyPost.add(modifyPostSubmitButton);
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //댓글 업데이트
    private void updateComment() {
        comment_dtm.setRowCount(0); //테이블 초기화
        try{
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            //request보내기
            String uri = "http://localhost:8080/api/post/" + post_id + "/comment";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))  // 위에서 만든 URI
                    .GET()  // HTTP 메소드, body 지정(GET의 경우 생략 가능)
                    .build();

            // 위에서 생성한 request를 보내고, 받은 response를 저장
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // responseBody to Post Class Array
            Comment[] comments = mapper.readValue(response.body(), Comment[].class);

            // Jtable에 일정 추가
            for(Comment c : comments) {
                comment_dtm.addRow(new Object[] {c.getId(), c.getMember().getId(), c.getContent()});
            }
        }catch(Exception e){
            System.out.println("댓글 업데이트 오류");
            e.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //댓글 쓰기
    private void addComment(String content) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper objectMapper = new ObjectMapper();

            //request 보내기
            String uri = "http://localhost:8080/api/user/" + user_id + "/comment?post_id=" + post_id;
            //request body
            Comment comment = new Comment(content);
            String requestBody = objectMapper.writeValueAsString(comment);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                    .build();

            //response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //update
            updateComment();
        } catch (Exception ex) {
            System.out.println("댓글 추가 오류");
            ex.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //댓글 테이블 클릭 이벤트
    private class MyMouseListener2 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int row = commentTable.getSelectedRow();
                Long comment_id = (Long)comment_dtm.getValueAt(row, 0);
                Long commentUser_id = (Long) comment_dtm.getValueAt(row, 1);
                if(commentUser_id == user_id){
                    int confirmDelete = JOptionPane.showConfirmDialog(null,
                            "댓글을 삭제하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
                    if(confirmDelete == 0){
                        HttpClient client = HttpClient.newHttpClient();
                        //request 보내기
                        String uri = "http://localhost:8080/api/user/" + user_id + "/comment/" + comment_id;
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(uri))
                                .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                                .DELETE() //Delete는 body없어도 동작
                                .build();

                        try {
                            //response
                            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                            //업데이트
                            updateComment();
                            comment_dtm.fireTableDataChanged();
                        } catch (Exception ex) {
                            System.out.println("댓글 삭제 응답오류");
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    static class myPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\background5.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
    static class myPanel2 extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\forumPage\\background6.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
