package institute.Plan_22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Dialog.ModalityType;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class A_OK extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtJhjhj;
	int i,j,k;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			A_OK dialog = new A_OK();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public A_OK() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				for(i=v.OK_data.size()-1;i>-1;i--) getContentPane().remove(v.OK_data.get(i).pan);
				v.OK_data.clear();
			}
			@Override
			public void windowActivated(WindowEvent arg0) {
				v.Discipline_data tmp = new v.Discipline_data();
				tmp.New();
				v.OK_data.add(tmp);
				v.OK_data.get(0).pan.setLocation(0, 90);
				contentPanel.add(v.OK_data.get(0).pan);
			    v.d_A_OK.setSize(v.d_A_OK.getWidth()+1, v.d_A_OK.getHeight());
				//repaint();
				
			}
		});
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 935, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtJhjhj = new JTextField();
		txtJhjhj.setText("jhjhj");
		txtJhjhj.setBounds(10, 31, 476, 20);
		contentPanel.add(txtJhjhj);
		txtJhjhj.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041D\u0430\u0437\u0432\u0430 \u041E\u041A");
		lblNewLabel.setBounds(10, 11, 92, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u0406\u0441\u043F\u0438\u0442/\u0417\u0430\u043B\u0456\u043A       \u041A\u0420/\u0420\u0413\u0420/(\u0420\u0420)    \u041A\u0440\u0435\u0434\u0438\u0442\u0438     \u0417\u0430\u0433\u0430\u043B\u044C\u043D\u0438\u0439 \u043E\u0431\u0441\u044F\u0433    \u0412\u0441\u044C\u043E\u0433\u043E      \u041B\u0435\u043A\u0446\u0456\u0457      \u041F\u0440\u0430\u043A\u0442\u0438\u043A\u0430     \u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0456     \u0421\u0430\u043C\u043E\u0441\u0442\u0456\u0439\u043D\u0456");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 73, 909, 14);
		contentPanel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(524, 31, 66, 20);
		contentPanel.add(comboBox);
		for(i=1;i<9;i++) comboBox.addItem(i);
		
		JLabel label_1 = new JLabel("\u0421\u0435\u043C\u0435\u0441\u0442\u0440");
		label_1.setBounds(524, 11, 92, 14);
		contentPanel.add(label_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u0417\u0430\u043B\u0456\u043A");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) chckbxNewCheckBox.setText("�����"); else chckbxNewCheckBox.setText("����");
			}
		});
		chckbxNewCheckBox.setBounds(17, 182, 60, 23);
		contentPanel.add(chckbxNewCheckBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(99, 183, 66, 20);
		contentPanel.add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		
		
		
		
		spinner.setModel(new SpinnerNumberModel(91, 30, 300, 1));
		spinner.setBounds(631, 183, 49, 20);
		contentPanel.add(spinner);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(181, 183, 49, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(266, 183, 49, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(352, 183, 49, 20);
		contentPanel.add(textField_2);
		
		JComboBox comboBox_2 = new JComboBox();
		
		comboBox_2.setBounds(411, 183, 49, 20);
		contentPanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(470, 183, 49, 20);
		contentPanel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(550, 183, 49, 20);
		contentPanel.add(comboBox_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtJhjhj.getText().trim().equals("")) return;
						
						
		                if (v.tmp==-1){  // new Discipline
							
						v.Discipline tmp = new v.Discipline();
						tmp.New();
						tmp.nazva=txtJhjhj.getText(); tmp.text.setText(tmp.nazva); 

                        for(i=0;i<v.OK_data.size();i++)
                        {
                        v.Discipline_data tmpD = new v.Discipline_data();
                        tmpD.New();
                        tmpD.is_zal.setSelected(v.OK_data.get(i).is_zal.isSelected());
                        
                        tmpD.kr_rgr.setSelectedIndex(v.OK_data.get(i).kr_rgr.getSelectedIndex());
                        tmpD.kredit.setText(v.OK_data.get(i).kredit.getText());
                        tmpD.A_all.setText(v.OK_data.get(i).A_all.getText());
                        tmpD.A_zag.setText(v.OK_data.get(i).A_zag.getText());
                        tmpD.A_Lek.setSelectedIndex(v.OK_data.get(i).A_Lek.getSelectedIndex());
                        tmpD.A_Pr.setSelectedIndex(v.OK_data.get(i).A_Pr.getSelectedIndex());
                        tmpD.A_Lab.setSelectedIndex(v.OK_data.get(i).A_Lab.getSelectedIndex());
                        tmpD.A_Sam.setValue(v.OK_data.get(i).A_Sam.getValue());
                        tmpD.semestr.setSelectedIndex(comboBox.getSelectedIndex());
                        
                        tmpD.pan.setLocation(280, 0);
                        
                        tmp.pan.add(tmpD.pan);
                        tmp.D_data.add(tmpD);
                    	 }
						
					
					//	tmp.pan.add(tmp.D_data.get(0).pan);
                        
						v.G.get(v.Sel_G).P.get(v.Sel_P).D.add(tmp);
					
						}
						
						if (v.tmp==5){  //  EDIT
		               }
						
						txtJhjhj.setText("");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						v.tmp=-2; dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
