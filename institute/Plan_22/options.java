package institute.Plan_22;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class options extends JDialog {

	private final JPanel contentPanel = new JPanel();
    JLabel[] Lsem = new JLabel[8];
    JSpinner[]  Ssem = new JSpinner[8];
    int i;
	JSpinner spinner_2 = new JSpinner();
	JSpinner spinner = new JSpinner();
	JSpinner spinner_3 = new JSpinner();
	
			
	JSpinner spinner_1 = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			options dialog = new options();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public options() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				for(i=0;i<8;i++) 	Ssem[i].setValue(v.n_week[i]); 
				spinner.setValue(v.n_Kr_min);
				spinner_1.setValue(v.n_Kr_krat);
				spinner_2.setValue(v.n_Kr_sem);
				spinner_3.setValue(v.n_Max_Ch_sem);
			}
		});
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 513, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 562, 69);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u041C\u0456\u043D\u0456\u043C\u0430\u043B\u044C\u043D\u0430 \u043A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u043A\u0440\u0435\u0434\u0438\u0442\u0456\u0432 \u0432 \u041E\u041A");
		lblNewLabel.setBounds(81, 89, 205, 14);
		contentPanel.add(lblNewLabel);
		
		spinner.setModel(new SpinnerNumberModel(new Float(4.5), new Float(1.5), new Float(24), new Float(0.5)));
		spinner.setBounds(10, 86, 61, 20);
		contentPanel.add(spinner);
		spinner_1.setModel(new SpinnerNumberModel(new Float(1.5), new Float(0.5), new Float(3), new Float(0.5)));
		spinner_1.setBounds(10, 114, 61, 20);
		contentPanel.add(spinner_1);
		
		JLabel label = new JLabel("\u041A\u0440\u0430\u0442\u043D\u0456\u0441\u0442\u044C \u043A\u0440\u0435\u0434\u0438\u0442\u0456\u0432 \u0432 \u041E\u041A");
		label.setBounds(81, 117, 205, 14);
		contentPanel.add(label);
		
		spinner_2.setModel(new SpinnerNumberModel(30, 15, 60, 1));
		spinner_2.setBounds(10, 141, 61, 20);
		contentPanel.add(spinner_2);
		
		JLabel label_1 = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u043A\u0440\u0435\u0434\u0438\u0442\u0456\u0432 \u0432 \u0441\u0435\u043C\u0435\u0441\u0442\u0440\u0456");
		label_1.setBounds(81, 144, 205, 14);
		contentPanel.add(label_1);
		
			spinner_3.setModel(new SpinnerNumberModel(22, 16, 40, 2));
		spinner_3.setBounds(10, 166, 61, 20);
		contentPanel.add(spinner_3);
		
		JLabel label_2 = new JLabel("\u041C\u0430\u043A\u0441\u0438\u043C\u0443\u043C \u0433\u043E\u0434\u0438\u043D \u0443 \u0441\u0435\u043C\u0435\u0441\u0442\u0440\u0456");
		label_2.setBounds(81, 169, 205, 14);
		contentPanel.add(label_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("nastroiki22"))){   //SAVE
							for(i=0;i<8;i++) 	dos.writeInt(v.n_week[i]=(int)Ssem[i].getValue()); 
							dos.writeFloat(v.n_Kr_min=(float)spinner.getValue());
							dos.writeFloat(v.n_Kr_krat=(float)spinner_1.getValue());
							dos.writeInt(v.n_Kr_sem=(int)spinner_2.getValue());
							dos.writeInt(v.n_Max_Ch_sem=(int)spinner_3.getValue());
							
								dos.close();
								dispose();
								}
								catch (IOException ex){
									setTitle(""+ex.getMessage());
								}
							
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		for(i=0;i<8;i++){
			Lsem[i] = new JLabel(i+1+"");
			Ssem[i] = new JSpinner();
			Lsem[i].setBounds(30+i*60, 10, 35, 15);
			Ssem[i].setBounds(10+i*60, 35, 45, 20);
			Ssem[i].setModel(new SpinnerNumberModel(15, 8, 20, 1));
			panel.add(Lsem[i]); panel.add(Ssem[i]);
		}
		
	}
}
