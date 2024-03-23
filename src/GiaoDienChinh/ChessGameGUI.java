package GiaoDienChinh;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGameGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton playWithComputerButton;
    private JButton twoPlayerButton;
    private JButton settingsButton;
    private JFrame settingsFrame;
    private JPanel settingsPanel;
    private JButton backButton;
    private JSlider volumeSlider;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> chessTypeComboBox;

    public ChessGameGUI() {
        prepareGUI();
        addMainPanelComponents();
        //addSettingsPanelComponents();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Game Cờ Tướng");
        mainFrame.setSize(960, 500);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.setIconImage(new ImageIcon("Path/Anhnen/logo.png").getImage());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        //mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.setLayout(new OverlayLayout(mainPanel));

        playWithComputerButton = new JButton("Chơi với máy");
        twoPlayerButton = new JButton("Hai người chơi");
        settingsButton = new JButton("Cài đặt");

        playWithComputerButton = new JButton("Chơi với máy");
        playWithComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle play with computer logic
            }
        });

        twoPlayerButton = new JButton("Hai người chơi");
        twoPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle two player logic
            }
        });

        settingsButton = new JButton("Cài đặt");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị cài đặt
                showSettings();

            }
        });
        settingsFrame = new JFrame("Cài đặt");
        settingsFrame.setSize(500, 400);
        settingsFrame.setLayout(new GridLayout(1, 1));
        settingsFrame.setIconImage(new ImageIcon("Path/Anhnen/setting.png").getImage());
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(4, 1));

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        colorComboBox = new JComboBox<>(new String[]{"Black", "White"});
        chessTypeComboBox = new JComboBox<>(new String[]{"Standard", "Custom"});

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
        });
    }

    private void addMainPanelComponents() {
        // Chèn ảnh nền
        ImageIcon backgroundImage = new ImageIcon("Path/Anhnen/anhnen.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        mainPanel.add(backgroundLabel);


        // Tạo một JPanel để chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 20)); // Căn chỉnh các nút theo lưới

        // Tạo một BoxLayout để căn chỉnh các nút theo chiều dọc
        BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(buttonLayout);

        // Thêm các nút vào buttonPanel
        buttonPanel.add(Box.createVerticalGlue()); // Để căn chỉnh các nút lên giữa
        buttonPanel.add(playWithComputerButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Đặt khoảng cách giữa các nút
        buttonPanel.add(twoPlayerButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(settingsButton);
        buttonPanel.add(Box.createVerticalGlue());


        // Tùy chỉnh các nút
        playWithComputerButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        twoPlayerButton.setFont(new Font("Arial", Font.BOLD, 16));
        settingsButton.setFont(new Font("Arial", Font.BOLD, 16));

        playWithComputerButton.setBackground(Color.RED);
        twoPlayerButton.setBackground(Color.BLUE);
        settingsButton.setBackground(Color.ORANGE);

        // Đặt kích thước ưu tiên cho nút
        playWithComputerButton.setPreferredSize(new Dimension(200, 150));
        twoPlayerButton.setPreferredSize(new Dimension(100, 150));
        settingsButton.setPreferredSize(new Dimension(100, 150));

        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.add(buttonPanel);
        // Đặt vị trí của buttonPanel trong ảnh nền
        mainFrame.add(mainPanel);
    }
    private void showSettings() {
        JFrame settingsFrame = new JFrame("Cài đặt");
        settingsFrame.setSize(500, 400);
        settingsFrame.setLayout(new GridLayout(1, 1));
        settingsFrame.setIconImage(new ImageIcon("Path/Anhnen/setting.png").getImage());
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(4, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
        });

        JLabel volumeLabel = new JLabel("Âm lượng:");
        JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        JLabel colorLabel = new JLabel("Màu:");
        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Black", "White"});
        JLabel chessTypeLabel = new JLabel("Chess Type:");
        JComboBox<String> chessTypeComboBox = new JComboBox<>(new String[]{"Standard", "Custom"});

        settingsPanel.add(volumeLabel);
        settingsPanel.add(volumeSlider);
        settingsPanel.add(colorLabel);
        settingsPanel.add(colorComboBox);
        settingsPanel.add(chessTypeLabel);
        settingsPanel.add(chessTypeComboBox);
        settingsPanel.add(backButton);

        settingsFrame.add(settingsPanel);
        settingsFrame.setVisible(true);
        mainFrame.setVisible(false);
    }


    public void showGUI() {

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ChessGameGUI chessGame = new ChessGameGUI();
                chessGame.showGUI();
            }
        });
    }
}

