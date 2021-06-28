import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

public class kasa2 {
   private JFrame frame;


  
   public static void main(String[] args){
      JFrame frame = new JFrame("CuricsoftdevelopmentTECH");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
   Container con=frame.getContentPane();
      JPanel panel = new JPanel();
      panel.setBackground(Color.gray);
      //panel.setSize(600,300);
      GridLayout layout = new GridLayout(6,1);
      layout.setHgap(10);
      layout.setVgap(10);

      panel.setLayout(layout);
      JButton buton1=new JButton("BLAGAJNA");       
      JButton buton2=new JButton("UNOS"); 
      JButton buton3=new JButton("SLADISTE"); 
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
 new unos();
  }
  }); 
buton3.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new skladiste();
  }
  }); 

buton6.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 System.exit(0);
  }
  }); 

frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
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
      
  
    frame.setSize(200,300);
    frame.setVisible(true);
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

class unos {
JFrame unos;
JPanel panel;
JLabel sifra,artikl,pdv,kolicina,mjera,cijena;
JTextField txtsifra,txtartikl,txtpdv,txtkolicina,txtmjera,txtcijena;
JButton potvrdi,odustani;


public unos()
{
unos=new JFrame("primka");
Container con=unos.getContentPane();
panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(7,2,30,20);
panel.setLayout(layout);

Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 14);


sifra=new JLabel("Unesi sifru");sifra.setFont(myFont);
txtsifra=new JTextField(15);txtsifra.setFont(myFont);
artikl=new JLabel("Unesi artikl");artikl.setFont(myFont);
txtartikl=new JTextField(15);txtartikl.setFont(myFont);
pdv=new JLabel("Unesi pdv");pdv.setFont(myFont);
txtpdv=new JTextField(15);txtpdv.setFont(myFont);
kolicina=new JLabel("Unesi kolicinu");kolicina.setFont(myFont);
txtkolicina=new JTextField(15);txtkolicina.setFont(myFont);
mjera=new JLabel("Unesi mjeru");mjera.setFont(myFont);
txtmjera=new JTextField(15);txtmjera.setFont(myFont);
cijena=new JLabel("Unesi cijenu");cijena.setFont(myFont);
txtcijena=new JTextField(15);txtcijena.setFont(myFont);
potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);

panel.add(sifra);
panel.add(txtsifra);
panel.add(artikl);
panel.add(txtartikl);
panel.add(pdv);
panel.add(txtpdv);
panel.add(kolicina);
panel.add(txtkolicina);
panel.add(mjera);
panel.add(txtmjera);
panel.add(cijena);
panel.add(txtcijena);


panel.add(potvrdi);
panel.add(odustani);
unos.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           unos.dispose();
         }        
      });   

con.add(panel);
unos.setSize(300,400);
unos.setVisible(true);;

}





}






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



