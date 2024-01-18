package institute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Exam extends JFrame {
    private JPanel contentPane;

    private List<List<Object>> tableData = new ArrayList<>();
    private String[] dataTypes = {"Text", "Number", "Date", "Dropdown"};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Exam frame = new Exam();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Exam() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Додати");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnNewButton.setBounds(880, 13, 97, 25);
        contentPane.add(btnNewButton);


        JPanel panel = new JPanel();
        panel.setBounds(12, 55, 965, 50);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton_1 = new JButton("Переглянути записи");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNewButton_1.setBounds(845, 13, 97, 25);
        panel.add(btnNewButton_1);
    }

//    private void createAndShowGUI() {
//        JFrame frame = new JFrame("Country Data Table");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//
//        int maxFields = 10;
//
//        for (int i = 0; i < maxFields; i++) {
//            JLabel label = new JLabel("Field " + (i + 1));
//            JTextField textField = new JTextField(10);
//            JComboBox<String> dataTypeComboBox = new JComboBox<>(dataTypes);
//            JCheckBox enabledCheckBox = new JCheckBox("Enabled");
//
//            dataTypeComboBox.setSelectedIndex(0);
//
//            enabledCheckBox.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textField.setEnabled(enabledCheckBox.isSelected());
//                }
//            });
//
//            panel.add(label, gbc);
//            gbc.gridx++;
//            panel.add(textField, gbc);
//            gbc.gridx++;
//            panel.add(dataTypeComboBox, gbc);
//            gbc.gridx++;
//            panel.add(enabledCheckBox, gbc);
//            gbc.gridx = 0;
//            gbc.gridy++;
//        }
//
//        JButton addRecordButton = new JButton("Add Record");
//        JButton deleteRecordButton = new JButton("Delete Record");
//        JButton addFieldButton = new JButton("Add Field");
//        JButton deleteFieldButton = new JButton("Delete Field");
//
//        addRecordButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addRecord();
//            }
//        });
//
//        deleteRecordButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteRecord();
//            }
//        });
//
//        addFieldButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addField();
//            }
//        });
//
//        deleteFieldButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteField();
//            }
//        });
//
//        panel.add(addRecordButton, gbc);
//        gbc.gridy++;
//        panel.add(deleteRecordButton, gbc);
//        gbc.gridy++;
//        panel.add(addFieldButton, gbc);
//        gbc.gridy++;
//        panel.add(deleteFieldButton, gbc);
//
//        frame.getContentPane().add(panel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    private void addRecord() {
//        List<Object> record = new ArrayList<>();
//        for (int i = 0; i < dataTypes.length; i++) {
//            record.add(null);
//        }
//        tableData.add(record);
//        System.out.println("Record added: " + record);
//    }
//
//    private void deleteRecord() {
//        if (!tableData.isEmpty()) {
//            tableData.remove(tableData.size() - 1);
//            System.out.println("Last record deleted.");
//        } else {
//            System.out.println("No records to delete.");
//        }
//    }
//
//    private void addField() {
//        if (tableData.isEmpty()) {
//            System.out.println("Add at least one record before adding fields.");
//            return;
//        }
//
//        for (List<Object> record : tableData) {
//            record.add(null);
//        }
//        System.out.println("Field added to all records.");
//    }
//
//    private void deleteField() {
//        if (tableData.isEmpty()) {
//            System.out.println("No records to delete fields from.");
//            return;
//        }
//
//        for (List<Object> record : tableData) {
//            if (!record.isEmpty()) {
//                record.remove(record.size() - 1);
//            }
//        }
//        System.out.println("Last field deleted from all records.");
//    }
}
