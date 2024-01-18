package institute.Plan_22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import java.awt.Frame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class fr1 extends JFrame {
    int i,j,k,a,b;
	private JPanel contentPane;
	JButton b_AddGroup = new JButton("+ \u0413\u0440\u0443\u043F\u0430");
	JButton button = new JButton("+ \u041F\u0456\u0434\u0433\u0440\u0443\u043F\u0430");
	JButton btnNewButton = new JButton("\u0420\u0435\u0434\u0430\u0433\u0443\u0432\u0430\u0442\u0438");
	JButton btnAddOK = new JButton("+\u041E\u0441\u0432\u0456\u0442\u043D\u044F \u043A\u043E\u043C\u043F\u043E\u043D\u0435\u043D\u0442\u0430");
	JPanel pan_itog = new JPanel();
	
	MouseListener Selection;
	ActionListener Delete0;
	private final JButton btnSave = new JButton("Save");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fr1 frame = new fr1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fr1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {  SaveData();
			}
		});
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(0, 0, 1800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
			b_AddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.tmp=-1; v.d_A_Group.show();
				if (v.tmp==-1) { contentPane.add(v.G.get(v.G.size()-1).pan); v.G.get(v.G.size()-1).text.addMouseListener(Selection); rasstanovka(); }
				
			
			}
		});
		Delete0 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean flag0=false;
				for(i=0;i<v.G.size();i++){
					if (flag0) break;
					
					for(j=0;j<v.G.get(i).P.size();j++){
						if (flag0) break;
							  
							  for(k=0;k<v.G.get(i).P.get(j).D.size();k++){  
							    if (arg0.getSource()==v.G.get(i).P.get(j).D.get(k).del){
							    	contentPane.remove(v.G.get(i).P.get(j).D.get(k).pan);
							    	v.G.get(i).P.get(j).D.remove(k); flag0=true; break;
							    }
							  }
							
					  }
						
						
					}
			 rasstanovka(); //v.raschet_subgroup(v.Sel_G, v.Sel_P);    
			}
		};
		
		Selection = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setVisible(true);
				for(i=0;i<v.G.size();i++){
					if (arg0.getSource()==v.G.get(i).text)
					{v.G.get(i).pan.setBackground(Color.white); if (v.Sel!=0) ChangeSelected(); v.Sel=1; v.Sel_G=i;
					button.setVisible(true); btnAddOK.setVisible(false);  return; }
				
				for(j=0;j<v.G.get(i).P.size();j++){
					if (arg0.getSource()==v.G.get(i).P.get(j).text)
					{v.G.get(i).P.get(j).pan.setBackground(Color.white); if (v.Sel!=0) ChangeSelected(); v.Sel=2; v.Sel_P=j; v.Sel_G=i;
					button.setVisible(false);  btnAddOK.setVisible(true);  return; }
				}
				}
			}
		};
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.tmp=-3; v.d_A_Group.show();
				if (v.tmp==-3) { contentPane.add(v.G.get(v.Sel_G).P.get(v.G.get(v.Sel_G).P.size()-1).pan);
				                 contentPane.add(v.G.get(v.Sel_G).P.get(v.G.get(v.Sel_G).P.size()-1).panend);
				                 v.G.get(v.Sel_G).P.get(v.G.get(v.Sel_G).P.size()-1).text.addMouseListener(Selection); rasstanovka(); }
				
				
			}
		});
		
		b_AddGroup.setBounds(143, 0, 93, 20);
		contentPane.add(b_AddGroup);
		
		
		button.setVisible(false);
		button.setBounds(246, 0, 93, 20);
		contentPane.add(button);
		
		btnNewButton.addActionListener(new ActionListener() {   // �����������
			public void actionPerformed(ActionEvent arg0) {
				v.tmp=5;
				v.d_A_Group.show();
				rasstanovka();
			}
		});
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(640, 0, 113, 20);
		contentPane.add(btnNewButton);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData();
			}
		});
		btnSave.setBounds(0, 0, 74, 20);
		
		contentPane.add(btnSave);
		
		JButton btnNewButton_1 = new JButton("Options");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.d_options.show();
			}
		});
		btnNewButton_1.setBounds(791, 0, 93, 23);
		contentPane.add(btnNewButton_1);
		
		btnAddOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 v.tmp=-1;	v.d_A_OK.show();
			 if (v.tmp==-1) { contentPane.add(v.G.get(v.Sel_G).P.get(v.Sel_P).D.get(v.G.get(v.Sel_G).P.get(v.Sel_P).D.size()-1).pan);
			 v.G.get(v.Sel_G).P.get(v.Sel_P).D.get(v.G.get(v.Sel_G).P.get(v.Sel_P).D.size()-1).text.addMouseListener(Selection); 
			 v.G.get(v.Sel_G).P.get(v.Sel_P).D.get(v.G.get(v.Sel_G).P.get(v.Sel_P).D.size()-1).pan.addMouseListener(Selection); 
			 v.G.get(v.Sel_G).P.get(v.Sel_P).D.get(v.G.get(v.Sel_G).P.get(v.Sel_P).D.size()-1).del.addActionListener(Delete0);
			 rasstanovka(); v.raschet_subgroup(v.Sel_G, v.Sel_P);    }
			}
		});
		btnAddOK.setVisible(false);
		btnAddOK.setBounds(342, 0, 162, 20);
		contentPane.add(btnAddOK);
		
		pan_itog.setBackground(Color.LIGHT_GRAY);
		pan_itog.setBounds(0, 690, 1800, 150);
		pan_itog.setLayout(null);
		contentPane.add(pan_itog);
		
		for(i=0;i<4;i++){
			for(j=0;j<8;j++){
				v.t_itog[i][j]= new JTextField();
				
				v.t_itog[i][j].setEditable(false);	v.t_itog[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				v.t_itog[i][j].setBounds(1030+j*40, 40+i*25, 30, 20);
				pan_itog.add(v.t_itog[i][j]);
				
			}
		} 
		
		try(DataInputStream dos = new DataInputStream(new FileInputStream("nastroiki22"))){   //OPEN NASTROIKI
			for(i=0;i<8;i++) 	v.n_week[i]=dos.readInt(); 
			v.n_Kr_min=dos.readFloat();
			v.n_Kr_krat=dos.readFloat();
			v.n_Kr_sem=dos.readInt();
			v.n_Max_Ch_sem=dos.readInt();
			
				dos.close();
				
				}
				catch (IOException ex){
					setTitle(""+ex.getMessage());
				}
		
		
			try(DataInputStream dos = new DataInputStream(new FileInputStream("datafile22"))){   //OPEN
			int pp,dd,dd_data, w = dos.readInt();
			if (w>0){ 
			for(i=0;i<w;i++){
				v.Group tmp = new v.Group();
				tmp.New();
				tmp.nazva= dos.readUTF();
				
				
			
		   	    pp = dos.readInt();
		   	     for(j=0;j<pp;j++){
					 v.SubGroup tmpS = new v.SubGroup();
					 tmpS.New();
					 tmpS.nazva = dos.readUTF();
					
				    
				     
				     dd = dos.readInt();//  dos.writeInt(v.G.get(i).P.get(j).D.size());
				     for(k=0;k<dd;k++){  //  for(k=0;k<v.G.get(i).P.get(j).D.size();k++){
				    	 v.Discipline tmpD = new v.Discipline();
				    	 tmpD.New();
				    	 tmpD.nazva= dos.readUTF(); // dos.writeUTF(v.G.get(i).P.get(j).D.get(k).nazva);
				    	 tmpD.text.setText(tmpD.nazva);  tmpD.del.addActionListener(Delete0);
				    	 dd_data = dos.readInt(); //  dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.size());
				    	 for(a=0;a<dd_data; a++){  //  for(a=0;a<v.G.get(i).P.get(j).D.get(k).D_data.size();a++){
							v.Discipline_data tmpDD = new v.Discipline_data();
							tmpDD.New();
							
							tmpDD.kr_rgr.setSelectedIndex(dos.readInt()); // dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.get(a).kr_rgr.getSelectedIndex());
							 tmpDD.kredit.setText(dos.readUTF()); // dos.writeUTF(v.G.get(i).P.get(j).D.get(k).D_data.get(a).kredit.getText());
							 tmpDD.numG = dos.readInt();
							 tmpDD.numP = dos.readInt();
							 tmpDD.pan.setLocation(280, 0);   tmpD.pan.add(tmpDD.pan); tmpD.D_data.add(tmpDD);
							
					  }
				    	 contentPane.add(tmpD.pan);
				    	 tmpS.D.add(tmpD);
				    	
					  }
				     contentPane.add(tmpS.pan);  contentPane.add(tmpS.panend);
				     tmpS.text.addMouseListener(Selection);
				    tmp.P.add(tmpS);
				  //   v.G.get(v.G.size()-1).P.add(tmpS);
				   
				   //  contentPane.add( v.G.get(v.G.size()-1).P.get(v.G.get(v.G.size()-1).P.size()-1).pan);
				    // v.G.get(v.G.size()-1).P.get(v.G.get(v.G.size()-1).P.size()-1).text.addMouseListener(Selection);
				    
				     
				     
				  }
				
				  v.G.add(tmp);
				  contentPane.add(tmp.pan);//	contentPane.add(v.G.get(v.G.size()-1).pan);
					v.G.get(v.G.size()-1).text.addMouseListener(Selection);
					 if (pp!=0) v.G.get(v.G.size()-1).del.setVisible(false);
						
						
				}
			rasstanovka(); v.flag=true;
			
			for(i=0;i<v.G.size();i++){
				for(j=0;j<v.G.get(i).P.size();j++)
					v.raschet_subgroup(i, j);
			}
			
			} 
			
				dos.close();
				}
				catch (IOException ex){
					setTitle(""+ex.getMessage());
				}
		 
	
	}
	void rasstanovka(){
		int y=30;
		for(i=0;i<v.G.size();i++){
		v.G.get(i).text.setText((i+1)+" "+v.G.get(i).nazva);	v.G.get(i).pan.setLocation(0, y); v.G.get(i).del.setVisible(v.G.get(i).P.size()==0);   y+=20;
		  for(j=0;j<v.G.get(i).P.size();j++){
			
				  v.G.get(i).P.get(j).text.setText((i+1)+"."+(j+1)+" "+v.G.get(i).P.get(j).nazva);	v.G.get(i).P.get(j).pan.setLocation(0, y);
				  v.G.get(i).P.get(j).del.setVisible(v.G.get(i).P.get(j).D.size()==0);  y+=20;
				  
				  for(k=0;k<v.G.get(i).P.get(j).D.size();k++){  
				  v.G.get(i).P.get(j).D.get(k).nomer.setText((i+1)+"."+(j+1)+"."+(k+1));	v.G.get(i).P.get(j).D.get(k).pan.setLocation(0, y); y+=35;
		  }
				  v.G.get(i).P.get(j).panend.setLocation(0, y); y+=35;
		  }
			
			
		}
		// setSize(getWidth()+1, getHeight());
			
		repaint();
	}
	void ChangeSelected(){
		if (v.Sel==1)  v.G.get(v.Sel_G).pan.setBackground(Color.yellow);
		if (v.Sel==2)  v.G.get(v.Sel_G).P.get(v.Sel_P).pan.setBackground(Color.CYAN);
		
		repaint();
	}
	void SaveData(){
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("datafile22"))){   //SAVE
			dos.writeInt(v.G.size()); 
			if (v.G.size()>0){
			for(i=0;i<v.G.size();i++){
			dos.writeUTF(v.G.get(i).nazva);
				dos.writeInt(v.G.get(i).P.size());
				  for(j=0;j<v.G.get(i).P.size();j++){
					  dos.writeUTF(v.G.get(i).P.get(j).nazva);
					  /////
					  dos.writeInt(v.G.get(i).P.get(j).D.size());
					  for(k=0;k<v.G.get(i).P.get(j).D.size();k++){
						  dos.writeUTF(v.G.get(i).P.get(j).D.get(k).nazva);
						  dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.size());
						  for(a=0;a<v.G.get(i).P.get(j).D.get(k).D_data.size();a++){
							  dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.get(a).kr_rgr.getSelectedIndex());
							  dos.writeUTF(v.G.get(i).P.get(j).D.get(k).D_data.get(a).kredit.getText());
							  dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.get(a).numG);
							  dos.writeInt(v.G.get(i).P.get(j).D.get(k).D_data.get(a).numP);
					  }
					  }
					  
				  } 
					
					
					
				}
			}
				dos.close();
				}
				catch (IOException ex){
					setTitle(""+ex.getMessage());
				}
			
	}
}
