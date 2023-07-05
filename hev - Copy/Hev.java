import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

 public class Hev extends JFrame implements ActionListener {

    hevaudio audio = new hevaudio();
    JProgressBar bar;
    JTextField textfield;
    JButton sumbit;

    Hev() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        sumbit = new JButton("Sumbit");
        textfield = new JTextField();
        bar = new JProgressBar(0, 65);
        JLabel label = new JLabel(new ImageIcon("hlhevcharger.jpg"));
    
    this.setDefaultCloseOperation(Hev.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    this.setBounds(550, 100, 500, 730);
    this.setIconImage(new ImageIcon("hliconv3.png").getImage());
    this.setTitle("hev charger".toUpperCase());

    label.setOpaque(true);
    label.setBounds(0,0,500,700);

    bar.setBounds(263, 176, 204,122);
    bar.setStringPainted(true);

    textfield.setBounds(267, 392, 100, 41);

    sumbit.setBounds(367,392,100,41);
    sumbit.addActionListener(this);
    sumbit.setFocusable(false);

    this.add(bar);
    this.add(sumbit);
    this.add(label);
    this.add(textfield);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    audio.welcome();
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
        new Hev();
    }

    public void actionPerformed(ActionEvent e){
    if(e.getSource() == sumbit){
        int number = Integer.parseInt(textfield.getText());
        if (number >= 0 && number <= 65){
            checkNumber(number);
                 bar.setValue(number);
                 number = number / 14;
                 try {
                    audio.accepted();
                } catch (UnsupportedAudioFileException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (LineUnavailableException e1) {
                    e1.printStackTrace();
                }
        }
        else { try { audio.denied();} 
        catch (UnsupportedAudioFileException e1){ 
            e1.printStackTrace(); } 
            catch (IOException e1) {
            e1.printStackTrace();
        }   catch (LineUnavailableException e1) {
            e1.printStackTrace();
        }

    }
}
    }
    public void checkNumber(int number){
        if (number >= 0 && number <= 15){bar.setForeground(Color.black);}
        if (number >= 15 && number <= 25){bar.setForeground(Color.red);}
        if (number >= 25 && number <= 35){bar.setForeground(Color.orange);}
        if (number >= 35 && number <= 45){bar.setForeground(Color.yellow);}
        if (number >= 45 && number <= 55){bar.setForeground(new Color(0, 255, 51));}
        if (number >= 55 && number <= 65){bar.setForeground(new Color(0, 102, 0));}
    }
}

