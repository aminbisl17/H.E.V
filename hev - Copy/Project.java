import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class Project extends JFrame implements MouseListener {

         JTextField txtfield;
         static JLabel[] label = new JLabel[4];
         JLabel angryBot, happyBot, rageBot, bot;
          // audio
File file1, file2;;
          Clip clip1, clip2;

          public void audio(){
            file1 = new File("");
          }
    public Project() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(500, 200, 530, 320);
        this.getContentPane().setBackground(Color.lightGray);
        this.setTitle("SoldierBot");

        ImageIcon botImg = new ImageIcon("abot.png");
        // audio 1
        file1 = new File("bigFart.wav");
        AudioInputStream as1 = AudioSystem.getAudioInputStream(file1);
        clip1 = AudioSystem.getClip();
        clip1.open(as1);
        FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);

        //audio 2
        file2 = new File("dammit.wav");
        AudioInputStream as2 = AudioSystem.getAudioInputStream(file2);
        clip2 = AudioSystem.getClip();
        clip2.open(as2);
        FloatControl gainControl2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl2.setValue(-20.0f);

        txtfield = new JTextField();
        txtfield.setBounds(55, 10, 400, 50);
        txtfield.setEditable(false);
        txtfield.setFocusable(false);

        angryBot = new JLabel(botImg);
        angryBot.setBounds(65, 100, 80, 90);

        happyBot = new JLabel(botImg);
        happyBot.setBounds(165, 100, 80, 90);

        rageBot = new JLabel(botImg);
        rageBot.setBounds(265, 100, 80, 90);

        bot = new JLabel(botImg);
        bot.setBounds(365, 100, 80, 90);

        label[0] = angryBot;
        label[1] = happyBot;
        label[2] = rageBot;
        label[3] = bot;

        for(int i = 0; i < 4; i++){
            label[i].addMouseListener(this);
            label[i].setOpaque(true);
            this.add(label[i]);
        }
        this.add(txtfield);
        this.add(angryBot);
        this.add(happyBot);
        this.setVisible(true);
    }
public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    new Project();
}
@Override
public void mouseClicked(MouseEvent e) {
       
    // angrybot button...
    if (e.getSource() == angryBot){
     clip1.start();
     clip1.setMicrosecondPosition(10);
     txtfield.setText("\t\tdiarrhea");
    }
    // happybot button...
    if (e.getSource() == happyBot){
    clip2.start(); // dammit.wav
    clip2.setMicrosecondPosition(10);

    txtfield.setText("\t\tdammit!!");
    }
    /*
     * Coming soon............
     */
}
@Override
public void mousePressed(MouseEvent e) {
for (int i =0; i < 4; i++){
    if(e.getSource() == label[i]){
        label[i].setSize(90, 100);
    }
}
}

@Override
public void mouseReleased(MouseEvent e) {
for (int i =0; i < 4; i++){
    if(e.getSource() == label[i]){
        label[i].setSize(80, 90);
    }
}
}

@Override
public void mouseEntered(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {  
}
}