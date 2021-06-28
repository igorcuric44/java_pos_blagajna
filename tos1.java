import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tos1 {
   private JFrame mainFrame;
 private JPanel controlPanel;

   public tos1(){
      prepareGUI();
   }

   public static void main(String[] args){
      tos1 swingLayoutDemo = new tos1();  
      swingLayoutDemo.showGridLayoutDemo();       
   }
      
   private void prepareGUI(){
      mainFrame = new JFrame("BLAGAJNA Curicsoftdevelopment");
      mainFrame.setSize(300,400);
      

         


      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
     
      

   
      
   }
   
   private void showGridLayoutDemo(){
      
Container con=mainFrame.getContentPane();
      JPanel panel = new JPanel();
      panel.setBackground(Color.gray);
      //panel.setSize(600,300);
      GridLayout layout = new GridLayout(6,1);
      layout.setHgap(10);
      layout.setVgap(10);
      
      panel.setLayout(layout);
      JButton buton1=new JButton("SLADISTE");        
      JButton buton2=new JButton("BLAGAJNA"); 
      JButton buton3=new JButton("PRIMKA"); 
      JButton buton4=new JButton("BLAGAJNA"); 
      JButton buton5=new JButton("PRIMKA");
      JButton buton6=new JButton("IZLAZ");
buton1.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 new blagajna();
  }
  }); 
buton2.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 new skladiste();
  }
  }); 
buton3.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 new primka();
  }
  }); 

buton6.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 System.exit(0);
  }
  }); 



      panel.add(buton1);
      panel.add(buton2); 
      panel.add(buton3); 
      panel.add(buton4); 
      panel.add(buton5); 
      panel.add(buton6); 
      
      con.add(panel);
      mainFrame.setVisible(true);  
   }
}
class blagajna {
JFrame blagajna;
public blagajna()
{
blagajna=new JFrame("blagajna");
blagajna.setSize(500,400);
blagajna.setVisible(true);
blagajna.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           blagajna.dispose();
         }        
      });   
}}

class skladiste {
JFrame skladiste;
public skladiste()
{
skladiste=new JFrame("skladiste");
skladiste.setSize(400,400);
skladiste.setVisible(true);
skladiste.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           skladiste.dispose();
         }        
      });   
}}

class primka {
JFrame primka;
public primka()
{
primka=new JFrame("primka");
primka.setSize(400,400);
primka.setVisible(true);
primka.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           primka.dispose();
         }        
      });   
}





}



