//This part of the program is for learning the 1st Gujarati Barakhadi, it will also help you to learn the Barakhadi symbols.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class guessTheBarakhadiSymbolGame implements ActionListener{
    public volatile boolean correct = false;
    String[] barakhadiSymbols = {"Ka","Kaa","Ki","Kee","Ku","Koo","Kae","Kai","Ko","Kau","Kum","Ka-ha"};
    JPanel panel;
    JPanel panelPopUp;
    TextField wrongAnswer;
    TextField correctAnswer;
    JButton[] btn = new JButton[12];
    JFrame popUpFrame;
    JLabel label;
    ImageIcon image;
    int random_int;

    public guessTheBarakhadiSymbolGame(){
        int amountOfPlays = Main.plays;
        int[] randomNums = new int[amountOfPlays];
        for(int k=1;k<=amountOfPlays;k++) {
            correct = false;
            JFrame frame = new JFrame();
            popUpFrame = new JFrame();
            popUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            label = new JLabel();

            Random rand = new Random();
            int upperBound = 12;
            random_int = rand.nextInt(upperBound) + 1;

            if(k!=1&&random_int==randomNums[k-2]&&random_int<35){
                random_int+=1;
            } else if(k!=1&&random_int==randomNums[k-2]&&random_int==35){
                random_int-=1;
            }
            randomNums[k-1]=random_int;
            System.out.println(random_int);
            longBarakhadiAnswer(random_int);

            setImage(random_int);
            label.setIcon(image);

            frame.add(label);
            frame.setVisible(true);
            frame.getContentPane().setBackground(new Color(0x123456));
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            popUpFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            panel = new JPanel();
            panelPopUp = new JPanel();
            panelPopUp.setPreferredSize(new Dimension(400, 400));

            wrongAnswer = new TextField();
            wrongAnswer.setFont(new Font("Consolas", Font.PLAIN, 25));
            wrongAnswer.setForeground(Color.WHITE);
            wrongAnswer.setBackground(Color.RED);
            wrongAnswer.setText("Wrong, try again!");
            correctAnswer = new TextField();
            correctAnswer.setFont(new Font("Consolas", Font.PLAIN, 25));

            correctAnswer.setForeground(Color.WHITE);
            correctAnswer.setBackground(new Color(0x06400));
            correctAnswer.setText("Correct!");

            panel.setPreferredSize(new Dimension(480, 70));
            panel.setBackground(Color.lightGray);
            panel.setLayout(new FlowLayout());
            popUpFrame.pack();
            popUpFrame.setSize(250, 100);
            popUpFrame.add(panelPopUp);
            popUpFrame.setVisible(false);

            for (int i = 0; i < barakhadiSymbols.length; i++) {
                btn[i] = new JButton(barakhadiSymbols[i]);
                btn[i].setBounds(0, 0, 20, 20);
                panel.add(btn[i]);
                btn[i].addActionListener(this);
            }
            frame.pack();
            frame.setSize(520, 470);
            frame.add(panel);

            while(!correct){
            }
            if(correct==true&&k<amountOfPlays){
                System.out.println("Onto the next barakhadi symbol, you have done "+(k)+" out of "+amountOfPlays);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            } else{
                System.out.println("You have completed the "+amountOfPlays+" barakhadi symbol tests!");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                System.exit(0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn[random_int-1]){
            for(int j=0;j<barakhadiSymbols.length;j++){
                if(e.getSource()==btn[j]){
                    System.out.println("Correct, you clicked: "+barakhadiSymbols[j]+". Nice!");
                    correct = true;
                }
            }
            panelPopUp.remove(wrongAnswer);
            panelPopUp.add(correctAnswer);
            popUpFrame.setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(1);
                panelPopUp.remove(correctAnswer);
                popUpFrame.setVisible(false);
            } catch(InterruptedException ex){}
        }
        else {
            for(int j=0;j<barakhadiSymbols.length;j++){
                if(e.getSource()==btn[j]){
                    System.out.println("Nope, you clicked: "+barakhadiSymbols[j]+". Try again");
                }
            }
            panelPopUp.remove(correctAnswer);
            panelPopUp.add(wrongAnswer);
            popUpFrame.setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(1);
                panelPopUp.remove(wrongAnswer);
                popUpFrame.setVisible(false);
            } catch(InterruptedException ex){}
        }
    }

    public void setImage(int randomInt){
        switch(randomInt){
            case 1:
                image = new ImageIcon("barakhadiSymbols/Ka.png");
                label.setIcon(image);
                break;
            case 2:
                image = new ImageIcon("barakhadiSymbols/Kaa.png");
                label.setIcon(image);
                break;
            case 3:
                image = new ImageIcon("barakhadiSymbols/Ki.png");
                label.setIcon(image);
                break;
            case 4:
                image = new ImageIcon("barakhadiSymbols/Kee.png");
                label.setIcon(image);
                break;
            case 5:
                image = new ImageIcon("barakhadiSymbols/Ku.png");
                label.setIcon(image);
                break;
            case 6:
                image = new ImageIcon("barakhadiSymbols/Koo.png");
                label.setIcon(image);
                break;
            case 7:
                image = new ImageIcon("barakhadiSymbols/Kae.png");
                label.setIcon(image);
                break;
            case 8:
                image = new ImageIcon("barakhadiSymbols/Kai.png");
                label.setIcon(image);
                break;
            case 9:
                image = new ImageIcon("barakhadiSymbols/Ko.png");
                label.setIcon(image);
                break;
            case 10:
                image = new ImageIcon("barakhadiSymbols/Kau.png");
                label.setIcon(image);
                break;
            case 11:
                image = new ImageIcon("barakhadiSymbols/Kum.png");
                label.setIcon(image);
                break;
            case 12:
                image = new ImageIcon("barakhadiSymbols/Ka-ha.png");
                label.setIcon(image);
                break;
        }
    }
    public static void longBarakhadiAnswer(int selectedSymbol){
        if(selectedSymbol==1){
            System.out.println("Kano KAY NAY kaar");
        } else if(selectedSymbol==2){
            System.out.println("Kano KAA NO Kaa");
        } else if(selectedSymbol==3){
            System.out.println("Kano RUS VAY Kee");
        } else if(selectedSymbol==4){
            System.out.println("Kano DIR GAY Keee");
        } else if(selectedSymbol==5){
            System.out.println("Kano RASA VARU Koo");
        } else if(selectedSymbol==6){
            System.out.println("Kano DIR GUVAROH Koooo");
        } else if(selectedSymbol==7){
            System.out.println("Kano EK MATRA Kayy");
        } else if(selectedSymbol==8){
            System.out.println("Kano BIR MATRA Kiyee");
        } else if(selectedSymbol==9){
            System.out.println("Kano KARNO EK MATRA Kohh");
        } else if(selectedSymbol==10){
            System.out.println("Kano KARNO BIR MATRA Kowh");
        } else if(selectedSymbol==11){
            System.out.println("Kano MATTE MEERO Kumm");
        } else if(selectedSymbol==12){
            System.out.println("Kano VISA GAYO Ka-har");
        }

    }
}
