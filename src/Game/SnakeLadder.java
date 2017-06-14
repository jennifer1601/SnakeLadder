package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class MovingObj extends JPanel implements ActionListener,KeyListener{
    int dice = 1;
    Timer t = new Timer(500,this);
    int mdice = 1;
    Random bot = new Random();
    int x1 = 25, y1 = 650, square =1;
    int x2 = -5, y2 = 620, x3 = 35, y3 = 630;
    int x4 = -5, y4 = 650;
    int turn = 0;
    int row = 0;
    int column = 0;
    int row1 = 1;
    int column1 = 1;
    int row2 = 1;
    int column2 = 1;
    int row3 = 1;
    int column3 = 1;
    int row4 = 1;
    int column4 = 1;
    int xCoor , yCoor;
    boolean plusturn = true;
    boolean membal = false;
    boolean rank = true;
    int j=2;
    
    
    public MovingObj(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D background = new Rectangle2D.Double(0,0,2000,1000);
        g2.setPaint(Color.PINK);
        g2.fill(background);
        Image map = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/SnakeLadder.jpg")).getImage();
        g.drawImage(map, 0, 0, 700, 700, this);
        Image title = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/snakeladdertitle.png")).getImage();
        g.drawImage(title,720,20,300,300,this);
        Image space = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/space.png")).getImage();
        g.drawImage(space,620,350,500,200,this);
        Image p1 = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/p1.gif")).getImage();
        g.drawImage(p1,x1,y1,50,50,this);
        Image p2 = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/p2.gif")).getImage();
        g.drawImage(p2,x2,y2,50,50,this);
        Image p3 = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/p3.gif")).getImage();
        g.drawImage(p3,x3,y3,40,40,this);
        Image p4 = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/p4.gif")).getImage();
        g.drawImage(p4,x4,y4,50,50,this);
        Image dicepic = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/dice" + mdice + ".png")).getImage();
        g.drawImage(dicepic,820,450,100,100,this);
        Image turntext = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/turn.png")).getImage();
        g.drawImage(turntext,750,550,150,150,this);
        Image turnpic = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/p" + turn + ".gif")).getImage();
        g.drawImage(turnpic,860,545,70,70,this);
        Image logo = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/uph.png")).getImage();
        g.drawImage(logo,675,610,370,100,this);
        Image name = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/nama.png")).getImage();
        g.drawImage(name,10,690,300,70,this);
        Image NIM = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/NIM.png")).getImage();
        g.drawImage(NIM,300,690,350,60,this);
        Image kelas = new ImageIcon(this.getClass().getClassLoader().getResource("Picture/class.png")).getImage();
        g.drawImage(kelas,750,690,300,60,this);
    }
    public void start(){
        if(plusturn == true)turn++;
        plusturn = true;
         membal = false;
        if(turn>4)turn=1;
        if(turn == 1){
            xCoor = x1;
            yCoor = y1;
            row = row1;
            column = column1;
        }
        if(turn == 2){
            xCoor = x2;
            yCoor = y2;
            row = row2;
            column = column2;
        }
        if(turn == 3){
            xCoor = x3;
            yCoor = y3;
            row = row3;
            column = column3;
        }
        if(turn == 4){
            xCoor = x4;
            yCoor = y4;
            row = row4;
            column = column4;
        }
    }
    
    
    public void actionPerformed(ActionEvent e) {
        repaint();
        checkmove();
    }
    
    public void checkmove(){
        if(row%2==1){
            if(column < 10 && dice>0){
                xCoor = xCoor + 70;
                column++;
                dice--;
                Sounds.hop();
            }
            else if(column == 10 && dice > 0){
                Sounds.hop();
                yCoor = yCoor - 70;
                row++;
                dice--;
            }
        }
        else if(row%2==0&&row!=10){
            if(column > 1 && dice>0){
                xCoor = xCoor - 70;
                column--;
                dice--;
                Sounds.hop();
                
            }
            else if(column == 1 && dice > 0){
                yCoor = yCoor - 70;
                row++;
                dice--;
                Sounds.hop();
            }
        }

        if(row == 1 && column == 8 && dice == 0){ // ladder 8
            row = 4;
            column = 10;
            xCoor = xCoor + 140;
            yCoor = yCoor - 210;
            Sounds.ladder();
        }
        if(row == 1 && column == 8 && dice == 0){ // ladder 8
            row = 4;
            column = 10;
            xCoor = xCoor + 140;
            yCoor = yCoor - 210;
            Sounds.ladder();
        }
        if(row == 7 && column == 6 && dice == 0){ // ladder 66
            row = 9;
            column = 7;
            xCoor = xCoor + 70;
            yCoor = yCoor - 140;
            Sounds.ladder();
        }
        if(row == 3 && column == 4 && dice == 0){ //snake 24
            row = 1;
            column = 1;
            xCoor = xCoor - 210;
            yCoor = yCoor + 140;
            Sounds.snake();
        }
        if(row == 9 && column == 8 && dice == 0){ //snake 88
            row = 7;
            column = 7;
            xCoor = xCoor - 70;
            yCoor = yCoor + 140;
            Sounds.snake();
        }
        if(row == 2 && column == 6 && dice == 0){ // ladder 15
            row = 10;
            column = 4;
            xCoor = xCoor - 140;
            yCoor = yCoor - 560;
            Sounds.ladder();
        }
        if(row == 6 && column == 6 && dice == 0){ //snake 55
            row = 2;
            column = 8;
            xCoor = xCoor + 140;
            yCoor = yCoor + 280;
            Sounds.snake();
        }
        if(row == 8 && column == 10 && dice == 0){ //snake 71
            row = 3;
            column = 9;
            xCoor = xCoor - 70;
            yCoor = yCoor + 350;
            Sounds.snake();
        }
        if(row == 10 && column == 2 && dice == 0){ //snake 99
            row = 1;
            column = 6;
            xCoor = xCoor + 280;
            yCoor = yCoor + 630;
            Sounds.snake();
        }
        if(row == 5 && column == 2 && dice == 0){ // ladder 42
            row = 9;
            column = 1;
            xCoor = xCoor -70;
            yCoor = yCoor - 280;
            Sounds.ladder();
        }
        if (row >= 10 && dice > 0) {
            if (!membal) {
                if (column > 1) {
                    xCoor = xCoor - 70;
                    column--;
                    dice--;
                    Sounds.hop();
                } else if (column <= 1) {
                    xCoor = xCoor + 70;
                    column++;
                    dice--;
                    membal = true;
                    Sounds.hop();
                }
            } else {
                xCoor = xCoor + 70;
                column++;
                dice--;
                Sounds.hop();
                if (dice == 0) {
                    membal = false;
                }
            }
        }
        if(row == 10 && column == 1 && dice == 0){
            if(rank==true){
                Sounds.cheer();
                switch(turn){
                    case 1:
                        new P1().setVisible(true);
                        rank = false;
                        break;
                    case 2:
                        new P2().setVisible(true);
                        rank = false;
                        break;
                    case 3:
                        new P3().setVisible(true);
                        rank = false;
                        break;
                    case 4:
                        new P4().setVisible(true);
                        rank = false;
                        break;
                }
            }           
        }
        
        if(mdice == 6 && dice == 0){
            plusturn = false;
        }
        if(turn == 1){
            x1 = xCoor;
            y1 = yCoor;
            row1 = row;
            column1 = column;
        }
        if(turn == 2){
            x2 = xCoor;
            y2 = yCoor;
            row2 = row;
            column2 = column;
        }
        if(turn == 3){
            x3 = xCoor;
            y3 = yCoor;
            row3 = row;
            column3 = column;
        }
        if(turn == 4){
            x4 = xCoor;
            y4 = yCoor;
            row4 = row;
            column4 = column;
        }
    }

    public void keyTyped(KeyEvent ke) {
        
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE){
            mdice = bot.nextInt(6)+1;
            dice = mdice;
            start();
        }
    }

    public void keyReleased(KeyEvent ke) {
    }
}
public class SnakeLadder extends javax.swing.JFrame {

    /**
     * Creates new form SnakeLadder
     */
    public SnakeLadder() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        JFrame frm = new JFrame();
        MovingObj img = new MovingObj();
        frm.add(img);
        frm.setSize(1050,800);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setTitle("Snake and Ladder");
        frm.setResizable(true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null); // centre position
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
