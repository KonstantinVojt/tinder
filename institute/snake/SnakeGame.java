package institute.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener{
    private final int SIZE = 600;
    private final int BOX_SIZE = 16;
    private final int ALL_BOXES = 680;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_BOXES];
    private int[] y = new int[ALL_BOXES];
    private int boxes;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private Image box;
    private Image apple;
    private int record = 0;

    public SnakeGame(){
        setBackground(Color.GREEN);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
//        setSize(SIZE, SIZE);
    }

    public void initGame(){
        boxes = 3;
        for (int i = 0; i < boxes; i++) {
            x[i] = 48 - i*BOX_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250,this);
        timer.start();
        createApple();
    }

    public void createApple(){
        appleX = new Random().nextInt(20)*BOX_SIZE;
        appleY = new Random().nextInt(20)*BOX_SIZE;
    }

    public void loadImages(){

        BufferedImage coloredDot1 = new BufferedImage(BOX_SIZE, BOX_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics g1 = coloredDot1.getGraphics();
        g1.setColor(Color.RED); // Change color as needed
        g1.fillRect(0, 0, BOX_SIZE, BOX_SIZE);
        box = coloredDot1;

        BufferedImage coloredDot2 = new BufferedImage(BOX_SIZE, BOX_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = coloredDot2.getGraphics();
        g2.setColor(Color.BLUE); // Change color as needed
        g2.fillRect(0, 0, BOX_SIZE, BOX_SIZE);
        apple = coloredDot2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < boxes; i++) {
                g.drawImage(box,x[i],y[i],this);
            }
        } else{
            String str = "Game Over";
            //Font f = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.red);
            // g.setFont(f);
            g.drawString(str,SIZE/2,SIZE/2);
        }

        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < boxes; i++) {
                g.drawImage(box,x[i],y[i],this);
            }
        } else{
            String recordStr = "Your Record: " + record;
            //Font f = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.black);
            // g.setFont(f);
            g.drawString(recordStr,SIZE/2,SIZE/2 + 20);
        }
    }


    public void move(){
        for (int i = boxes; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -= BOX_SIZE;
        }
        if(right){
            x[0] += BOX_SIZE;
        } if(up){
            y[0] -= BOX_SIZE;
        } if(down){
            y[0] += BOX_SIZE;
        }
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            boxes++;
            if (boxes > record) {
                record = boxes;
            }
            createApple();
        }
    }

    public void checkCollisions(){
        for (int i = boxes; i >0 ; i--) {
            if(i>4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }
        }

        if(x[0]>SIZE){
            inGame = false;
        }
        if(x[0]<0){
            inGame = false;
        }
        if(y[0]>SIZE){
            inGame = false;
        }
        if(y[0]<0){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            move();

        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }


}




