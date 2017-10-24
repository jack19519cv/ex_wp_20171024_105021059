import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Mainframe extends JFrame{

    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 500,frmH=400 ;
    private JMenuBar jmb = new JMenuBar();
    private  JMenu jmF = new JMenu("File");
    private  JMenu jmSet = new JMenu("Set");
    private  JMenu jmGame = new JMenu("Game");
    private  JMenu jmAbout = new JMenu("About");
    private  JMenuItem jmItemExit = new JMenuItem("Exit");
    private  JMenuItem jmItemLoto = new JMenuItem("Loto");
    private  JLabel jlb[] = new JLabel[6];
    private  JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();
    private JPanel Jp= new JPanel(new GridLayout(1,6,3,3));
    private JPanel Jp1= new JPanel(new GridLayout(1,2,3,3));
    private JButton Jbtn1 = new JButton("Close");
    private JButton Jbtn2 = new JButton("General");
    private Random rnd = new Random(System.currentTimeMillis());
    private  int data[] = new int[6];
    private Container cp;
    public Mainframe(){

        init();
    }
    private void init(){
            this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
              //  log.setVisible(true);
            }
        });
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setJMenuBar(jmb);
        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);

        jmF.add(jmItemExit);
        jmGame.add(jmItemLoto);
        jmItemExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemLoto.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jif.setBounds(0,0,300,120);
        cp = jif.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(Jp,BorderLayout.CENTER);
        cp.add(Jp1,BorderLayout.SOUTH);
     Jp1.add(Jbtn1);
        Jp1.add(Jbtn2);
Jbtn1.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        jif.dispose();
    }
});


         jmItemLoto.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jdp.add(jif);
                 jif.setVisible(true);
             }
         });
        jmItemExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
    public void Loto(){

       boolean b=true;
       int i=0,j=0;
        while(i<6){

             while (i<j&&b){
                 jlb[i]=new JLabel(Integer.toString(data[i]));
                 if(jlb[i].getText().equals(data[i])||jlb[i].getText().equals("")){
                b=false;
                 }

                 j++;

             }
           i++ ;
        }

    }

}
