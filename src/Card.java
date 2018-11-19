import javax.swing.*;

public class Card extends JLabel {
    private static String path;

    private int id;
    private JLabel label;


    private boolean matched = false;
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setJlabel(JLabel label){this.label = label;}

    public JLabel getJlabel(){return label;}




   public void setPath(String path)
    {
        this.path = path;
    }
    public static String getPath()
    {
        return path;
    }

    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }

    public void getJlabel(JLabel label) {
    }
}
