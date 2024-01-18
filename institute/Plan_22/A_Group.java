package institute.Plan_22;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class A_Group extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Group dialog = new A_Group();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public A_Group() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (v.tmp==-1){ setTitle("��������� ���� �����"); return; }
				if (v.tmp==-3){ setTitle("��������� ���� �������"); return; }
				if (v.tmp==5){
					switch (v.Sel){
					case 2:	setTitle("����������� �������"); textField.setText(v.G.get(v.Sel_G).P.get(v.Sel_P).nazva);
					break;
					case 1: setTitle("����������� �����"); textField.setText(v.G.get(v.Sel_G).nazva);
					break;
			}}}
		});
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 616, 163);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 40, 553, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.tmp=-2; dispose();
			}
		});
		btnNewButton.setBounds(485, 90, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().equals("")) return;
				
				if (v.tmp==-1){  // new Group
					
					v.Group tmp = new v.Group();
					tmp.New(); tmp.nazva=textField.getText(); tmp.text.setText(tmp.nazva);
					v.G.add(tmp);
				}
                if (v.tmp==-3){  // new SubGroup
					
					v.SubGroup tmp = new v.SubGroup();
					tmp.New(); tmp.nazva=textField.getText(); tmp.text.setText(tmp.nazva); 
					v.G.get(v.Sel_G).P.add(tmp);
					
				}
				
				if (v.tmp==5){  
                switch (v.Sel){
                case 2: v.G.get(v.Sel_G).P.get(v.Sel_P).nazva=textField.getText();  v.G.get(v.Sel_G).P.get(v.Sel_P).text.setText(textField.getText());
				   break;
                case 1:	v.G.get(v.Sel_G).nazva=textField.getText();  v.G.get(v.Sel_G).text.setText(textField.getText());
                       break;
               
								
				}}
				textField.setText("");
				dispose();
			}
		});
		btnNewButton_1.setBounds(386, 90, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		

	}
}
