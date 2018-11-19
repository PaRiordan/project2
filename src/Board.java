import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board extends JFrame implements ActionListener {
    public List<Card> cards;
    private JLabel selectedCard;
    private JLabel c1;
    private JLabel c2;
    private Timer t;
    private List<JLabel> cardLabels = new ArrayList<>();
    private List<JButton> buttons = new ArrayList();


    public Board() {

        setTitle("Puzzle ");
        setLocation(550, 20); //location on screen
        setSize(1080, 920); // size
        setResizable(false); // stops the ability to resize window
        setLocationRelativeTo(null); // set location to center of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the x button to stop the program
        setVisible(true); //Make it visible


        // reating my Jpanal layout
        // JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new GridLayout(4, 4));

        // creating a list of values so that i can shuffle them
        List<Integer> cardId = new ArrayList<>();
        int value = 8;
        for (int i = 0; i < value; i++) {
            cardId.add(i);
            cardId.add(i);
        }
        Collections.shuffle(cardId);
        JPanel cardPanel = new JPanel();

        cardPanel.setLayout(new GridLayout(4, 4));

        // an ArrayList of path ways
        List<String> pathList = new ArrayList<>();
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\AceHearts.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\AceHearts.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\AceClubs.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\AceClubs.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\KingSpades.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\KingSpades.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\KingDiamonds.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\KingDiamonds.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\QueenHearts.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\QueenHearts.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\QueenSpades.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\QueenSpades.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\JackDiamonds.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\JackDiamonds.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\JackClubs.png");
        pathList.add("C:\\Users\\Patrick Riordan\\IdeaProjects\\MemoryMuscle\\out\\Images\\JackClubs.png");
       Collections.shuffle(pathList);

        Container con = getContentPane();

        int gbCount = 1;
        for (int i = 0; i < 16; i++) { // create a loop of square buttons
            JButton gameButton = new JButton();
            gameButton.setText("" + gbCount);
            gbCount++;
            cardPanel.add(gameButton);
            gameButton.addActionListener(this);
            buttons.add(gameButton);

            JLabel cardlabel = new JLabel();

            ImageIcon icon = new ImageIcon(pathList.get(i));
            cardlabel.setIcon(icon);

            //System.out.print("b"+gameButton.getText());
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);  //https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
            cardlabel.setBorder(border);

            cardlabel.setVisible(false);

            cardPanel.add(cardlabel, BorderLayout.CENTER);
            cardLabels.add(cardlabel);

        }

        con.add(cardPanel);


    } // end of board

    public void cardImage(JLabel label, Card card) {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(card.getPath()).getImage());
        label.setIcon(imageIcon);

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0;i <16;i++){

            if (e.getSource()== buttons.get(i)){

                cardLabels.get(i).setVisible(true);
              //  selectedCard = cardLabels.get(i);
              //  doTurn();
              //  JOptionPane.showMessageDialog(null,c1);
            }

              //  selectedCard = cardLabels.get(i);
              //  doTurn();
              //  JOptionPane.showMessageDialog(null,c2);


            }

        }

    

    public void doTurn() {
        if (c1 == null && c2 == null) {
            c1 = selectedCard;
           // c1.setText(String.valueOf(c1.getId()));
            if (c1 != null && c1 != selectedCard && c2 == null){
                c2 = selectedCard;
                //c2.setText(String.valueOf(c2.getId()));


            }
        }

    }

    public void checkCards(){
        if (c1.getIcon() == c2.getDisabledIcon()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            //c1.setMatched(true); //flags the button as having been matched
            //c2.setMatched(true);
           // if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

      //  else{
            //c1.setText(""); //'hides' text
          //  c2.setText("");
        //}
        //c1 = null; //reset c1 and c2
        //c2 = null;
    }





 //end of board






/*
        for (int i = 0; i < 4; i++) { // create a loop of square buttons


            for (int j = 0; j < 4; j++) {

                Card c = new Card();
                c.setId(cardId.get(j));

                JLabel cardlabel = new JLabel();
                cardlabels.add(cardlabel);

                System.out.print(cardlabels);

                cardlabel.setText("" + cardId);
                //counter.add(i);
                labels.add(cardlabel);
                buttonPanel.add(cardlabel,BorderLayout.CENTER);

                //count++;



            }//end of second for
        }//end of first for
        //  Collections.shuffle(counter);
        // System.out.print(counter);


*/