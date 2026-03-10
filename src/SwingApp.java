import Available_Bytes_Check.Available;
import ChunkBasedReading.Chunk_Reading;
import FileUploadRead.UploadRead;
import File_Summary_Report.File_summary;
import Mark_Reset.Mark;
import Safe_Closing_of_Streams.Safe_Closing;
import Search_Analyze.Search;
import Skip_Data.Skip;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class SwingApp extends JFrame {
    private JTextField fileField;
    private JTextArea outputArea;
    private JButton browseButton;

    public SwingApp() {
        setTitle("File Reader & Analyzer - Premium Edition");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Modern Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(245, 245, 250));

        // Redirect System.out to outputArea
        redirectSystemOut();

        // Top Panel for File Selection
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        
        fileField = new JTextField();
        fileField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        browseButton = new JButton("Select File...");
        browseButton.setFocusPainted(false);
        
        JLabel titleLabel = new JLabel("File Reader Analyzer");
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(new JLabel("Path: "), BorderLayout.WEST);
        topPanel.add(fileField, BorderLayout.CENTER);
        topPanel.add(browseButton, BorderLayout.EAST);

        // Center Panel for Output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBackground(new Color(30, 30, 35));
        outputArea.setForeground(new Color(220, 220, 220));
        outputArea.setCaretColor(Color.WHITE);
        outputArea.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 200)), 
            "Analysis Console", 0, 0, 
            new Font("Segoe UI", Font.ITALIC, 12), new Color(100, 100, 120))
        );

        // Right Panel for Operations
        JPanel sidePanel = new JPanel(new GridLayout(10, 1, 10, 10));
        sidePanel.setOpaque(false);
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 20, 20));

        String[] ops = {
            "Open and Read File",
            "Read in Small Chunks",
            "Skip Content Demo",
            "Search Keyword",
            "Mark / Reset Demo",
            "Bytes Available",
            "File Summary",
            "Safe Stream Close",
            "Clear Console",
            "Exit Program"
        };

        for (int i = 0; i < ops.length; i++) {
            JButton btn = new JButton(ops[i]);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setFocusPainted(false);
            final int choice = i + 1;
            btn.addActionListener(e -> handleOperation(choice));
            sidePanel.add(btn);
        }

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);

        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                fileField.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });
    }

    private void redirectSystemOut() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                SwingUtilities.invokeLater(() -> {
                    outputArea.append(String.valueOf((char) b));
                    outputArea.setCaretPosition(outputArea.getDocument().getLength());
                });
            }
            @Override
            public void write(byte[] b, int off, int len) {
                String str = new String(b, off, len);
                SwingUtilities.invokeLater(() -> {
                    outputArea.append(str);
                    outputArea.setCaretPosition(outputArea.getDocument().getLength());
                });
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    private void handleOperation(int choice) {
        String path = fileField.getText();
        // Pehle: JOptionPane.WARNING_VALUE (Galat)
// Ab: JOptionPane.WARNING_MESSAGE (Sahi)

        if ((path == null || path.trim().isEmpty()) && choice <= 8) {
            JOptionPane.showMessageDialog(this, "Please select/enter a file path first!", "Missing Path", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (choice) {
            case 9: outputArea.setText(""); return;
            case 10: System.exit(0); return;
        }

        outputArea.append("\n>>> EXECUTING ACTION: " + choice + "\n");
        
        new Thread(() -> {
            try {
                switch (choice) {
                    case 1: UploadRead.userupload(path); break;
                    case 2: Chunk_Reading.byte_reader(path); break;
                    case 3: Skip.skip_data(path); break;
                    case 4: 
                        String kw = JOptionPane.showInputDialog(this, "Enter keyword to search:");
                        if (kw != null) Search.Search_analyze(path, kw);
                        break;
                    case 5: Mark.mark_reset(path); break;
                    case 6: Available.Available_Check(path); break;
                    case 7: File_summary.Report(path); break;
                    case 8: Safe_Closing.Closing(path); break;
                }
            } catch (Exception ex) {
                System.out.println("\n[UI ERROR] Operation failed: " + ex.getMessage());
            }
            outputArea.append("\n>>> ACTION COMPLETED.\n");
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingApp().setVisible(true);
        });
    }
}
