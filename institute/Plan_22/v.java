package institute.Plan_22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class v {
  public static int tmp, Sel_D, Sel_P, Sel_G, Sel=0, pan_Width=1600;
  public static boolean flag=false;
  public static Random rnd = new Random();
  public static A_Group d_A_Group = new A_Group();
  public static A_OK d_A_OK = new A_OK();
  public static options d_options = new options();
  public static ArrayList<Group> G = new ArrayList<Group>();
  public static ArrayList<Discipline_data> OK_data = new ArrayList<Discipline_data>();
 
  public static int[] n_week = new int[8];
  public static float n_Kr_min, n_Kr_krat;
  public static int n_Kr_sem, n_Max_Ch_sem;
  
  public static JTextField[][] t_itog = new JTextField[4][8];
 
  
  public static class Group{
	  public JPanel pan = new JPanel();
	  public JLabel text = new JLabel();
	  public String nazva;
	  public JButton del = new JButton();
	  public ArrayList<SubGroup> P = new ArrayList<SubGroup>();
	  
	  public void New(){
		  pan.setSize(pan_Width, 20); pan.setBackground(Color.yellow); pan.setLayout(null);
		  del.setBounds(pan_Width-31, 1, 30, 18); pan.add(del); del.setBackground(Color.black);
		  text.setHorizontalAlignment(SwingConstants.CENTER); pan.add(text); text.setBounds(0, 0, pan_Width, 20); 
		  
	  } 
  }
public static class SubGroup{
	  public JPanel pan = new JPanel();
	  public JPanel panend = new JPanel();
	  public JLabel text = new JLabel();
	  public String nazva;
	  public JButton del = new JButton();
	  public JTextField kredit = new JTextField();
	  public JTextField A_zag = new JTextField();
	  public JTextField A_all = new JTextField();
	  public JTextField A_Lek = new JTextField();
	  public JTextField A_Pr = new JTextField();
	  public JTextField A_Lab = new JTextField();
	  public JTextField A_Sam = new JTextField();
	  public ArrayList<Discipline> D = new ArrayList<Discipline>();
	  
	  public void New(){
		  pan.setSize(pan_Width, 20); pan.setBackground(Color.CYAN); pan.setLayout(null); 
		  panend.setSize(pan_Width, 35); panend.setBackground(Color.GRAY); panend.setLayout(null); 
		  del.setBounds(pan_Width-31, 1, 30, 18); pan.add(del); del.setBackground(Color.black);
		  text.setHorizontalAlignment(SwingConstants.CENTER); pan.add(text); text.setBounds(0, 0, pan_Width, 20); 
		  
		  //pan_END
		  kredit.setBounds(181+280, 7, 49, 20); panend.add(kredit); kredit.setEditable(false); kredit.setHorizontalAlignment(SwingConstants.CENTER);
		  A_zag.setBounds(266+280, 7, 49, 20); panend.add(A_zag); A_zag.setEditable(false); A_zag.setHorizontalAlignment(SwingConstants.CENTER);
		  A_all.setBounds(352+280, 7, 49, 20); panend.add(A_all); A_all.setEditable(false); A_all.setHorizontalAlignment(SwingConstants.CENTER);
		  A_Lek.setBounds(411+280, 7, 49, 20); panend.add(A_Lek); A_Lek.setEditable(false); A_Lek.setHorizontalAlignment(SwingConstants.CENTER);
		  A_Pr.setBounds(470+280, 7, 49, 20); panend.add(A_Pr);   A_Pr.setEditable(false); A_Pr.setHorizontalAlignment(SwingConstants.CENTER);
		  A_Lab.setBounds(550+280, 7, 49, 20); panend.add(A_Lab);  A_Lab.setEditable(false);  A_Lab.setHorizontalAlignment(SwingConstants.CENTER);
		  A_Sam.setBounds(631+280, 7, 49, 20); panend.add(A_Sam);  A_Sam.setEditable(false); A_Sam.setHorizontalAlignment(SwingConstants.CENTER);
			
		  
	  } 
  }
public static class Discipline{
	  public JPanel pan = new JPanel();
	  public JLabel text = new JLabel();
	  public JLabel nomer = new JLabel();
	  public String nazva;
	  public JButton del = new JButton();
	  public ArrayList<Discipline_data> D_data = new ArrayList<Discipline_data>();
	  
	  public void New(){
		  pan.setSize(pan_Width, 35); pan.setBackground(Color.PINK); pan.setLayout(null); 
		  del.setBounds(pan_Width-31, 8, 30, 18); pan.add(del); del.setBackground(Color.black);
		  pan.add(text); text.setBounds(55, 0, 200, 35); 
		  pan.add(nomer); nomer.setBounds(5, 0, 50, 35); 
		  
	  } 
}
public static class Discipline_data{
	  public JPanel pan = new JPanel();
	  public JTextField hours = new JTextField();
	  public int numG, numP;
	  public JCheckBox is_zal = new JCheckBox("����");
	  public JComboBox kr_rgr = new JComboBox();
	  public JComboBox semestr = new JComboBox();
	  public JTextField kredit = new JTextField();
	  public JTextField A_zag = new JTextField();
	  public JTextField A_all = new JTextField();
	  public JComboBox A_Lek = new JComboBox();
	  public JComboBox A_Pr = new JComboBox();
	  public JComboBox A_Lab = new JComboBox();
	  public JSpinner A_Sam = new JSpinner();
	  public ActionListener IZ, ChCh;
	  public ChangeListener S_ChCh;
	  
	  public void New(){
		  IZ = new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (is_zal.isSelected()) is_zal.setText("�����"); else is_zal.setText("����");
				}
			};
		ChCh = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (v.flag)	proverka();
				}
			};
		S_ChCh = new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if (v.flag)	proverka();
				}
			};
			
		  numG=v.Sel_G; numP=v.Sel_P;
		  pan.setSize(pan_Width, 35); pan.setBackground(Color.magenta); pan.setLayout(null); 
		  is_zal.setBounds(18, 6, 60, 23); pan.add(is_zal); is_zal.addActionListener(IZ);
		  kr_rgr.setBounds(100, 7, 66, 20); pan.add(kr_rgr); kr_rgr.addItem("���"); kr_rgr.addItem("��"); kr_rgr.addItem("���"); kr_rgr.addItem("(��)"); kr_rgr.setSelectedIndex(0);
		  semestr.setBounds(1100, 7, 49, 20); pan.add(semestr); for(int i=1;i<9;i++) semestr.addItem(i); semestr.addActionListener(ChCh); 
		  pan.add(hours); hours.setBounds(750, 7, 30, 20); hours.setEditable(false); hours.setHorizontalAlignment(SwingConstants.CENTER);
				 
		  kredit.setBounds(181, 7, 49, 20); pan.add(kredit); kredit.setEditable(false); kredit.setHorizontalAlignment(SwingConstants.CENTER);
		  A_zag.setBounds(266, 7, 49, 20); pan.add(A_zag); A_zag.setEditable(false); A_zag.setHorizontalAlignment(SwingConstants.CENTER);
		  A_all.setBounds(352, 7, 49, 20); pan.add(A_all); A_all.setEditable(false); A_all.setHorizontalAlignment(SwingConstants.CENTER);
		  A_Lek.setBounds(411, 7, 49, 20); pan.add(A_Lek); A_Lek.addActionListener(ChCh); 
		  A_Pr.setBounds(470, 7, 49, 20); pan.add(A_Pr);  A_Pr.addActionListener(ChCh); 
		  A_Lab.setBounds(550, 7, 49, 20); pan.add(A_Lab);   A_Lab.addActionListener(ChCh); 
		  for(int i=0; i<91; i+=15){
			  if (i%10==0) {
				  A_Lek.addItem(i); A_Pr.addItem(i); A_Lab.addItem(i);
			  } else {
				  A_Lek.addItem(i-1); A_Pr.addItem(i-1); A_Lab.addItem(i-1);
				  A_Lek.addItem(i+1); A_Pr.addItem(i+1); A_Lab.addItem(i+1);
			  }
		  }
		  A_Lek.setSelectedIndex(0); A_Pr.setSelectedIndex(0); A_Lab.setSelectedIndex(0);
		  A_Sam.setModel(new SpinnerNumberModel(91, 30, 300, 1)); A_Sam.setBounds(631, 7, 49, 20); pan.add(A_Sam); A_Sam.addChangeListener(S_ChCh); 
			  
	//   0  14   16    30   44   46     60    64    66   90 
			 
	   
	 
}   void proverka(){
	if (A_Lek.getItemCount()==0 || A_Pr.getItemCount()==0 || A_Lab.getItemCount()==0) return;
	int ww=(int)A_Lek.getSelectedItem()+(int)A_Pr.getSelectedItem()+(int)A_Lab.getSelectedItem();
	A_all.setText(""+ww);
	ww+=(int)A_Sam.getValue();
	A_zag.setText(""+ww);
	float qq = ww/30f;
	kredit.setText(""+qq);
	if (qq<v.n_Kr_min || qq%v.n_Kr_krat!=0){ kredit.setBackground(Color.red); kredit.setForeground(Color.white);}
	   else { kredit.setBackground(Color.white); kredit.setForeground(Color.black);}
	kredit.setCaretPosition(0);
	
	int num = (int)semestr.getSelectedItem(); hours.setLocation(750+(num-1)*40, 7);
	hours.setText(""+(int)Math.round(Integer.valueOf((A_all.getText()))/15f));
	
	
	
	v.raschet_subgroup(numG, numP);
    }
	  
}
public static void raschet_subgroup(int G1, int P1)
{  int[] s =  {0,0,0,0,0,0};
   float f=0;
   if (v.G.get(G1).P.size()>0 && 
		   v.G.get(G1).P.get(P1).D.size()>0){
	   for(int i=0;i<v.G.get(G1).P.get(P1).D.size();i++){
   
	 for(int j=0;j<v.G.get(G1).P.get(P1).D.get(i).D_data.size();j++){
		 f+=Float.valueOf(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).kredit.getText());
	//	 s[0]+=Integer.valueOf(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_zag.getText());
	//	 s[1]+=Integer.valueOf(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_all.getText());
		 s[2]+=(int)(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_Lek.getSelectedItem());
		 s[3]+=(int)(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_Pr.getSelectedItem());
		 s[4]+=(int)(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_Lab.getSelectedItem());
		 s[5]+=(int)(v.G.get(G1).P.get(P1).D.get(i).D_data.get(j).A_Sam.getValue());
     }
    }
	   }
	v.G.get(G1).P.get(P1).kredit.setText(f+"");
	v.G.get(G1).P.get(P1).A_zag.setText(s[0]+"");
	v.G.get(G1).P.get(P1).A_all.setText(s[1]+"");
	v.G.get(G1).P.get(P1).A_Lek.setText(s[2]+"");
	v.G.get(G1).P.get(P1).A_Pr.setText(s[3]+"");
	v.G.get(G1).P.get(P1).A_Lab.setText(s[4]+"");
	v.G.get(G1).P.get(P1).A_Sam.setText(s[5]+"");
	
	if (f<v.n_Kr_min || f%v.n_Kr_krat!=0){ v.G.get(G1).P.get(P1).kredit.setBackground(Color.red); v.G.get(G1).P.get(P1).kredit.setForeground(Color.white);}
	   else { v.G.get(G1).P.get(P1).kredit.setBackground(Color.white); v.G.get(G1).P.get(P1).kredit.setForeground(Color.black);}
	v.G.get(G1).P.get(P1).kredit.setCaretPosition(0);
	}
}
