import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class guessTheConsonantGame implements ActionListener{

    String[] constonants = {"Ka","Kha","Ga","Gha","Ca","Cha","Ja","Jha","Tta","Ttha","Dda","Ddha","Nna","Ta","Tha","Da","Dha","Na","Pa","Pha","Ba","Bha","Ma","Ya","Ra","La","Lla","Va","Sha","Ssa","Sa","Ha","Ksa","Gna"};

    JPanel panel;
    JPanel panelPopUp;
    TextField wrongAnswer;
    TextField correctAnswer;
    JButton[] btn = new JButton[34];
    JFrame popUpFrame;
    JLabel label;
    ImageIcon image;
    int random_int;
    public guessTheConsonantGame(){

        JFrame frame = new JFrame();
        popUpFrame = new JFrame();

        popUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();

        Random rand = new Random();
        int upperBound = 34;
        random_int = rand.nextInt(upperBound)+1;
        System.out.println(random_int);

        setImage(random_int);

        label.setIcon(image);

        frame.add(label);

        frame.setVisible(true);

        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        popUpFrame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));


        panel = new JPanel();
        panelPopUp = new JPanel();
        panelPopUp.setPreferredSize(new Dimension(400,400));

        wrongAnswer = new TextField();
        wrongAnswer.setFont(new Font("Consolas",Font.PLAIN,25));
        wrongAnswer.setForeground(Color.WHITE);
        wrongAnswer.setBackground(Color.RED);
        wrongAnswer.setText("Wrong, try again!");
        correctAnswer = new TextField();
        correctAnswer.setFont(new Font("Consolas",Font.PLAIN,25));

        correctAnswer.setForeground(Color.WHITE);
        correctAnswer.setBackground(new Color(0x06400));
        correctAnswer.setText("Correct!");

        panel.setPreferredSize(new Dimension(480,180));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());
        popUpFrame.pack();
        popUpFrame.setSize(250,100);
        popUpFrame.add(panelPopUp);
        popUpFrame.setVisible(false);

        for(int i=0;i<constonants.length;i++){
            btn[i] = new JButton(constonants[i]);
            btn[i].setBounds(0,0,20,20);
            panel.add(btn[i]);
            btn[i].addActionListener(this);
        }
        frame.pack();
        frame.setSize(520,550);
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn[random_int-1]){
            for(int j=0;j<constonants.length;j++){
                if(e.getSource()==btn[j]){
                    System.out.println("Correct, you clicked: "+constonants[j]+". Nice!");
                }
            }
            panelPopUp.remove(wrongAnswer);
            panelPopUp.add(correctAnswer);
            popUpFrame.setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(3);
                panelPopUp.remove(correctAnswer);
                popUpFrame.setVisible(false);
            } catch(InterruptedException ex){}
        }
        else {
            for(int j=0;j<constonants.length;j++){
                if(e.getSource()==btn[j]){
                    System.out.println("Nope, you clicked: "+constonants[j]+". Try again");
                }
            }
            panelPopUp.remove(correctAnswer);
            panelPopUp.add(wrongAnswer);
            popUpFrame.setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(3);
                panelPopUp.remove(wrongAnswer);
                popUpFrame.setVisible(false);
            } catch(InterruptedException ex){}
        }
    }

    public void setImage(int randomInt){
        switch(randomInt){
            case 1:
                image = new ImageIcon("constonantSymbols/Ka.png");
                label.setIcon(image);
                break;
            case 2:
                image = new ImageIcon("constonantSymbols/Kha.png");
                label.setIcon(image);
                break;
            case 3:
                image = new ImageIcon("constonantSymbols/Ga.png");
                label.setIcon(image);
                break;
            case 4:
                image = new ImageIcon("constonantSymbols/Gha.png");
                label.setIcon(image);
                break;
            case 5:
                image = new ImageIcon("constonantSymbols/Ca.png");
                label.setIcon(image);
                break;
            case 6:
                image = new ImageIcon("constonantSymbols/Cha.png");
                label.setIcon(image);
                break;
            case 7:
                image = new ImageIcon("constonantSymbols/Ja.png");
                label.setIcon(image);
                break;
            case 8:
                image = new ImageIcon("constonantSymbols/Jha.png");
                label.setIcon(image);
                break;
            case 9:
                image = new ImageIcon("constonantSymbols/Tta.png");
                label.setIcon(image);
                break;
            case 10:
                image = new ImageIcon("constonantSymbols/Ttha.png");
                label.setIcon(image);
                break;
            case 11:
                image = new ImageIcon("constonantSymbols/Dda.png");
                label.setIcon(image);
                break;
            case 12:
                image = new ImageIcon("constonantSymbols/Ddha.png");
                label.setIcon(image);
                break;
            case 13:
                image = new ImageIcon("constonantSymbols/Nna.png");
                label.setIcon(image);
                break;
            case 14:
                image = new ImageIcon("constonantSymbols/Ta.png");
                label.setIcon(image);
                break;
            case 15:
                image = new ImageIcon("constonantSymbols/Tha.png");
                label.setIcon(image);
                break;
            case 16:
                image = new ImageIcon("constonantSymbols/Da.png");
                label.setIcon(image);
                break;
            case 17:
                image = new ImageIcon("constonantSymbols/Dha.png");
                label.setIcon(image);
                break;
            case 18:
                image = new ImageIcon("constonantSymbols/Na.png");
                label.setIcon(image);
                break;
            case 19:
                image = new ImageIcon("constonantSymbols/Pa.png");
                label.setIcon(image);
                break;
            case 20:
                image = new ImageIcon("constonantSymbols/Pha.png");
                label.setIcon(image);
                break;
            case 21:
                image = new ImageIcon("constonantSymbols/Ba.png");
                label.setIcon(image);
                break;
            case 22:
                image = new ImageIcon("constonantSymbols/Bha.png");
                label.setIcon(image);
                break;
            case 23:
                image = new ImageIcon("constonantSymbols/Ma.png");
                label.setIcon(image);
                break;
            case 24:
                image = new ImageIcon("constonantSymbols/Ya.png");
                label.setIcon(image);
                break;
            case 25:
                image = new ImageIcon("constonantSymbols/Ra.png");
                label.setIcon(image);
                break;
            case 26:
                image = new ImageIcon("constonantSymbols/La.png");
                label.setIcon(image);
                break;
            case 27:
                image = new ImageIcon("constonantSymbols/Lla.png");
                label.setIcon(image);
                break;
            case 28:
                image = new ImageIcon("constonantSymbols/Va.png");
                label.setIcon(image);
                break;
            case 29:
                image = new ImageIcon("constonantSymbols/Sha.png");
                label.setIcon(image);
                break;
            case 30:
                image = new ImageIcon("constonantSymbols/Ssa.png");
                label.setIcon(image);
                break;
            case 31:
                image = new ImageIcon("constonantSymbols/Sa.png");
                label.setIcon(image);
                break;
            case 32:
                image = new ImageIcon("constonantSymbols/Ha.png");
                label.setIcon(image);
                break;
            case 33:
                image = new ImageIcon("constonantSymbols/Ksa.png");
                label.setIcon(image);
                break;
            case 34:
                image = new ImageIcon("constonantSymbols/Gna.png");
                label.setIcon(image);
                break;
        }

    }




}
