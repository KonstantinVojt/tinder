package institute.tetris;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class fr1 extends JFrame {

	private JPanel contentPane;
	byte i,j,k,fig,col,fig2;
	boolean f=false,f1,f2;
	int Score;
	Timer timer;
	JButton[][] b = new JButton[10][40];
	Random rnd = new Random();
	Color[] c = {Color.yellow, Color.green, Color.red, Color.blue, Color.pink, Color.orange, Color.cyan, Color.gray, Color.lightGray};
    byte[][] w=new byte[4][2];
    byte[][] w2=new byte[4][2];
    boolean[][] q=new boolean[10][40];
    JButton btnNewButton = new JButton("start");

	JButton[][] nextFigureGrid = new JButton[4][4];

	void showNextFigure() {
		// Clear the nextFigureGrid
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				nextFigureGrid[i][j].setBackground(Color.white);
			}
		}

		// Display the next figure on nextFigureGrid
		switch (fig) {
			case 0: // Line
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[1][3].setBackground(c[col]);
				break;
			case 1: // Square
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][2].setBackground(c[col]);
				break;
			case 2: // L-Shape
				nextFigureGrid[0][1].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][2].setBackground(c[col]);
				break;
			case 3: // T-Shape
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				break;
			case 4: // L-Shape Inverted
				nextFigureGrid[0][2].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[2][2].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				break;
			case 5: // S-Shape
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][2].setBackground(c[col]);
				break;
			case 6: // S-Shape Inverted
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				break;
			case 7: // Stairs
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[3][1].setBackground(c[col]);
				break;
			case 8: // Stairs Inverted
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[3][0].setBackground(c[col]);
				break;
			case 9: // Stick
				nextFigureGrid[0][1].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[3][1].setBackground(c[col]);
				break;
			case 10: // Stick Inverted
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[1][3].setBackground(c[col]);
				break;
			case 11: // L-Shape Mirrored
				nextFigureGrid[0][1].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				break;
			case 12: // T-Shape Mirrored
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[0][1].setBackground(c[col]);
				break;
			case 13: // S-Shape Mirrored
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[0][1].setBackground(c[col]);
				nextFigureGrid[0][2].setBackground(c[col]);
				break;
			case 14: // S-Shape Inverted Mirrored
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				break;
			case 15: // Stick Mirrored
				nextFigureGrid[0][1].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[3][1].setBackground(c[col]);
				break;
			case 16: // Stick Inverted Mirrored
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[1][2].setBackground(c[col]);
				nextFigureGrid[1][3].setBackground(c[col]);
				break;
			case 17: // Stairs Mirrored
				nextFigureGrid[1][0].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[3][1].setBackground(c[col]);
				break;
			case 18: // Stairs Inverted Mirrored
				nextFigureGrid[1][1].setBackground(c[col]);
				nextFigureGrid[2][1].setBackground(c[col]);
				nextFigureGrid[2][0].setBackground(c[col]);
				nextFigureGrid[3][0].setBackground(c[col]);
				break;
			default:
				break;
		}
	}

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//timer.stop();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (f==false) return;
				if (arg0.getKeyCode()==KeyEvent.VK_Q){
					for (i=0; i<4; i++) {
						w2[i][0] = w[i][0];
						w2[i][1] = w[i][1];
					}
					fig2 = fig;
					switch (fig){
						case 1: fig = 2; w[0] [0]++; w[0] [1]--; break;
						case 2: fig = 1; w[0] [0]--; w[0] [1]++; break;
						case 3: fig = 5; break;
						case 4: fig = 3; w[0][1]++; break;
						case 5: fig = 6; break;
						case 6: fig = 4; w[0] [1]--; break;
						case 7: fig = 10; w[0] [1]--; break;
						case 8: fig = 7; w[0] [0]--; break;
						case 9: fig = 8; w[0] [1]--; break;
						case 10: fig = 9; w[0] [0]++; w[0] [1]--; break;
						case 11: fig = 12; w[0] [1]++; w[0] [1]--; break;
						case 12: fig = 13; w[0] [1]--; w[0][1]++; break;
						case 13: fig = 14; w[0] [0]++; w[0] [1]--; break;
						case 14: fig = 11; w[0] [0]--; w[0][1]++; break;
						case 15: fig = 16; w[0] [1]--; break;
						case 16: fig = 15; w[0][1]++; break;
						case 17: fig = 18; w[0] [1]--; break;
						case 18: fig = 17; w[0][1]--; break;
					}


					Plus3();
					if (Perev()==false) {
						fig=fig2;
						for (int i = 0; i < 4; i++) {
						w[i][0] = w2[i][0];
						w[i][1] = w2[i][1];
					}
					} else  {
						for (int i = 0; i < 4; i++) {
						b[w2[i][0]][w2[i][1]].setBackground(Color.white);
					}

						for (int i = 0; i < 4; i++) {
							b[w[i][0]][w[i][1]].setBackground(c[col]);
						}

					 }

					}
				if (arg0.getKeyCode()==KeyEvent.VK_LEFT){
					if (w[0][0]==0) return;
					for(i=0;i<4;i++) if (q[w[i][0]-1][w[i][1]]) return;
					Movement(1);
					}
				if (arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					for(i=0;i<4;i++) if (w[i][0]==9 || q[w[i][0]+1][w[i][1]]) return;
					Movement(2);
					}
				if (arg0.getKeyCode()==KeyEvent.VK_SPACE){
					j=1;
					while(w[0][1]+j<39 && q[w[0][0]][w[0][1]+j+1]==false &&
							w[1][1]+j<39 && q[w[1][0]][w[1][1]+j+1]==false &&
									w[2][1]+j<39 && q[w[2][0]][w[2][1]+j+1]==false &&
											w[3][1]+j<39 && q[w[3][0]][w[3][1]+j+1]==false)
					{
						j++;
					}
					for(i=0;i<4;i++) {
						b[w[i][0]][w[i][1]].setBackground(Color.white);
						b[w[i][0]][w[i][1]+j].setBackground(c[col]);
						q[w[i][0]][w[i][1]+j]=true;
					}
				   f1=true;	NewFigure();
				}
				
			}
		});

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				nextFigureGrid[i][j] = new JButton();
				nextFigureGrid[i][j].setBounds(400 + i * 15, 100 + j * 15, 15, 15);
				nextFigureGrid[i][j].setEnabled(false);
				contentPane.add(nextFigureGrid[i][j]);
			}
		}
		
		btnNewButton.addActionListener(new ActionListener() {   // START
			public void actionPerformed(ActionEvent arg0) {
				 contentPane.setFocusable(true); contentPane.requestFocus(); Score=0;
				for(i=0;i<10;i++){
					for(j=0;j<40;j++){
							b[i][j].setBackground(Color.white); q[i][j]=false;
					}
				}
				f=true;
				NewFigure();
				for(i=0;i<4;i++) 	 b[w[i][0]][w[i][1]].setBackground(c[col]);
				timer.start();
			}
		});
		
		
		btnNewButton.setBounds(355, 23, 89, 23);
		contentPane.add(btnNewButton);
		
		for(i=0;i<10;i++){
			for(j=0;j<40;j++){
				b[i][j]=new JButton();
				b[i][j].setBounds(i*15, j*15, 15, 15);
			//	b[i][j].setBackground(Color.white);
				b[i][j].setEnabled(false);
				contentPane.add(b[i][j]);
			}
		}
		timer=new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		 if (f==false) return;
		 
		 
		 Movement(0);
		
			}
		});
	}

	void NewFigure(){
		PerevirkaScore();
		fig=(byte)rnd.nextInt(19);  
		col=(byte)rnd.nextInt(c.length);
		switch (fig){
		case 0: case 2: case 3: case 4: case 7: case 8: case 9: case 11: case 12: case 14: case 16: case 17:  w[0][0]=4; w[0][1]=0; break;
		case 1: w[0][0]=3; w[0][1]=0; break;
		case 5: case 6: case 13: case 15: case 18: w[0][0]=4; w[0][1]=1; break;
		case 10: w[0][0]=4; w[0][1]=2; break;
          }
		showNextFigure();
		Plus3();
	}

	void Plus3(){
		switch (fig){
		case 0: w[1][0]=(byte)(w[0][0]+1);  w[1][1]=(byte)(w[0][1]); 
		        w[2][0]=(byte)(w[0][0]);    w[2][1]=(byte)(w[0][1]+1);
		        w[3][0]=(byte)(w[0][0]+1);  w[3][1]=(byte)(w[0][1]+1); break;
		case 1: w[1][0]=(byte)(w[0][0]+1);  w[1][1]=(byte)(w[0][1]); 
                w[2][0]=(byte)(w[0][0]+2);  w[2][1]=(byte)(w[0][1]);
                w[3][0]=(byte)(w[0][0]+3);  w[3][1]=(byte)(w[0][1]); break;
		case 2: w[1][0]=(byte)(w[0][0]);  w[1][1]=(byte)(w[0][1]+1); 
                w[2][0]=(byte)(w[0][0]);    w[2][1]=(byte)(w[0][1]+2);
                w[3][0]=(byte)(w[0][0]);  w[3][1]=(byte)(w[0][1]+3); break;
		case 3: w[1][0]=(byte)(w[0][0]+1);  w[1][1]=(byte)(w[0][1]); 
                w[2][0]=(byte)(w[0][0]+2);    w[2][1]=(byte)(w[0][1]);
                w[3][0]=(byte)(w[0][0]+1);  w[3][1]=(byte)(w[0][1]+1); break;
		case 4: w[1][0] = (byte) (w[0][0]);   w[1][1] = (byte) (w[0][1]+1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]);   w[3][1] = (byte) (w[0][1]+2); break;
case 5: w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]-1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]+1); w[3][1] = (byte) (w[0][1]+1); break;
case 6: w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]-1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]); break;
case 7: w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+2); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]+1); break;
case 8: w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]);   w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]);   w[3][1] = (byte) (w[0][1]+2); break;
case 9: w[1][0] = (byte) (w[0][0]);   w[1][1] = (byte) (w[0][1]+1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]+1); break;
case 10:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]-1);
        w[3][0] = (byte) (w[0][0]+1); w[3][1] = (byte) (w[0][1]-2); break;
case 11:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+2); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]);   w[3][1] = (byte) (w[0][1]+1); break;
case 12:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]+1); w[3][1] = (byte) (w[0][1]+2); break;
case 13:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+2); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]-1); break;
case 14:w[1][0] = (byte) (w[0][0]);   w[1][1] = (byte) (w[0][1]+1); 
        w[2][0] = (byte) (w[0][0]);   w[2][1] = (byte) (w[0][1]+2);
        w[3][0] = (byte) (w[0][0]+1); w[3][1] = (byte) (w[0][1]+2); break;
case 15:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]-1);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]-1); break;
case 16:w[1][0] = (byte) (w[0][0]);   w[1][1] = (byte) (w[0][1]+1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]+1); w[3][1] = (byte) (w[0][1]+2); break;
case 17:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]+1);
        w[3][0] = (byte) (w[0][0]+2); w[3][1] = (byte) (w[0][1]+1); break;
case 18:w[1][0] = (byte) (w[0][0]+1); w[1][1] = (byte) (w[0][1]-1); 
        w[2][0] = (byte) (w[0][0]+1); w[2][1] = (byte) (w[0][1]);
        w[3][0] = (byte) (w[0][0]);   w[3][1] = (byte) (w[0][1]+1); break;
		}
	}
	void Movement(int m){
		if (m==0){
		for(i=0;i<4;i++) {
			if (w[i][1]==39 ||  q[w[i][0]][w[i][1]+1]){
				for(j=0;j<4;j++) q[w[j][0]][w[j][1]]=true;
			f1=true;	NewFigure(); break;
			}
         }}
		if (f1==false){
		 for(i=0;i<4;i++) 	 b[w[i][0]][w[i][1]].setBackground(Color.white);
		
		 for(i=0;i<4;i++) {
			switch (m){
			case 0: w[i][1]++; break;
			case 1: w[i][0]--; break;
			case 2: w[i][0]++; break;
			}
		 }
		 } else f1=false;
		 for(i=0;i<4;i++) 	 b[w[i][0]][w[i][1]].setBackground(c[col]);
	}
	void PerevirkaScore(){
		for(i=0;i<40;i++){
			f2=true;
			for(j=0;j<10;j++){
				if (q[j][i]==false){f2=false; break; }
			}
			if (f2){
				Score++;  setTitle("Score: "+Score);
				for(int x=i-1;x>-1;x--){
					for(j=0;j<10;j++){
						q[j][x+1]=q[j][x]; b[j][x+1].setBackground(b[j][x].getBackground());
				}
				}
			}
		}
	}

	boolean Perev(){
		for(i=0;i<4;i++){
			if (w[i][0]<0 || w[i][0]>9 || w[i][1]<0 || w[i][1]>39 || q[w[i][0]][w[i][1]]) return false;
		}
		return true;
	}
}
