import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.sql.*;
import javax.swing.table.*;
import java.util.Vector;

public class kasa4 {
   


  
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
      JButton buton4=new JButton("UNOS SIFARA"); 
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

buton4.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new unossifara();
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
    frame.setLocationRelativeTo(null);
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
unos=new JFrame("unos");

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

con.add(panel);
unos.setSize(300,400);
unos.setLocationRelativeTo(null); 
unos.setVisible(true);

unos.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           unos.dispose();
         }        
      }); 
      
odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  unos.dispose();
  }
  });   

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  potvrdi();
  }
  }); 



}

public  void potvrdi() 
{

Connection c=null;
Statement stmt=null;
int txtsifrax=Integer.parseInt(txtsifra.getText().toString());
String txtartiklx=txtartikl.getText().toString();
float txtmjerax=Float.parseFloat(txtmjera.getText().toString());
float txtkolicinax=Float.parseFloat(txtkolicina.getText().toString());
float txtpdvx=Float.parseFloat(txtpdv.getText().toString());
float txtcijenax=Float.parseFloat(txtcijena.getText().toString());
    try {
      Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

  stmt = c.createStatement();


 String sql = "INSERT INTO skladiste (id,artikl,pdv,kolicina,mjera,cijena) VALUES "+
 "("+txtsifrax+", '"+txtartiklx+"',"+txtpdvx+","+
 txtkolicinax+","+txtmjerax+","+txtcijenax+");"; 
      stmt.executeUpdate(sql);
           
 stmt.close();
     
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }







}







class skladiste {
JFrame skladiste;
public skladiste()
{
skladiste=new JFrame("skladiste");
JPanel panel = new JPanel();
Container con=skladiste.getContentPane();
Vector<Vector> data = new Vector<Vector>();
Connection c = null;
Statement st = null;
Vector<String> col = new Vector<String>();
try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      st = c.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM skladiste;");
ResultSetMetaData rsMetaData = rs.getMetaData();      
int numberOfColumns = rsMetaData.getColumnCount();
for (int ii = 1; ii < numberOfColumns + 1; ii++) 
      col.addElement(rsMetaData.getColumnName(ii));

while (rs.next()) {
Vector<String> t= new Vector<String>();
      for (int i = 1; i < numberOfColumns + 1; i++) {
        t.addElement(rs.getString(i));
      }
data.addElement(t);
    }
 
rs.close();
st.close();
c.close();

}catch(Exception e){
System.err.println( e.getMessage() );
      System.exit(0);
}


DefaultTableModel model  = new DefaultTableModel(data,col); 
JTable table = new JTable(model);
alignRight(table,0);
alignRight(table,2);
alignRight(table,3);
alignRight(table,4);
alignRight(table,5);

Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 13);
table.setFont(myFont);
JTableHeader header = table.getTableHeader();
header.setFont(myFont);
JScrollPane pane = new JScrollPane(table);
con.add(pane);


skladiste.setSize(700,800);
skladiste.setLocationRelativeTo(null); 
skladiste.setVisible(true);
skladiste.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           skladiste.dispose();
         }        
      });   
}
private void alignRight(JTable table, int column) {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
}


}

class unossifara {
JFrame unossofara;
public unossifara()
{
unossofara=new JFrame("Unos sifara");
unossofara.setSize(400,400);
unossofara.setLocationRelativeTo(null); 
unossofara.setVisible(true);
unossofara.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           unossofara.dispose();
         }        
      });   
}}


