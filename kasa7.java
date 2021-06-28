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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class kasa7 {
   


  
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
      JButton buton5=new JButton("SIFRARNIK");
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


buton5.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new sifrarnik();
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
            frame.dispose();
         }        
      });    

      panel.add(buton1);
      panel.add(buton2); 
      panel.add(buton3); 
      panel.add(buton4); 
      panel.add(buton5); 
      panel.add(buton6); 
      
      con.add(panel);
      
  
    frame.setSize(200,400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}
class blagajna {
JFrame blagajna;
JPanel panel1,panel2;
GridLayout layout;
JButton button1,button2; 
public blagajna()
{
blagajna=new JFrame("blagajna");
Container contentPane = blagajna.getContentPane();
layout = new GridLayout(0,3);
panel1 = new JPanel();
panel2 = new JPanel(new BorderLayout());
panel1.setPreferredSize(new Dimension(100, 50));
layout.setHgap(10);
layout.setVgap(10);
panel1.setLayout(layout);
JLabel label1=new JLabel("PROX1",JLabel.CENTER);       
JLabel label2=new JLabel("PROX1",JLabel.CENTER); 
JLabel label3=new JLabel("PROX1",JLabel.CENTER);
panel1.add(label1);
panel1.add(label2);
panel1.add(label3);

button1=new JButton("Stisni");
button2=new JButton("Print");


String data[][] = null;
  String col[] = {"Sifra","Artikl","Mjera","Kolicina","PDV","Cijena"};
DefaultTableModel model = new DefaultTableModel(data,col);
JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);

blagajna.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           blagajna.dispose();
         }        
      }); 

scrollPane.addKeyListener(new KeyAdapter() {
  public void keyPressed(KeyEvent evt) {
  int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
      System.out.println("Check for key characters: " );
      String[] t=new String[6];
t[0]="1";
t[1]="2";
t[2]="3";
//t[3]=rs.getString(4);
t[3]="4";
t[4]="5";
t[5]="6";

model.addRow(t);
    }
    if (evt.getKeyChar() == '0') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '1') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '2') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '3') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '4') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
   if (evt.getKeyChar() == '5') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    } 
    if (evt.getKeyChar() == '6') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '7') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '8') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyChar() == '9') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    
    }
    
    
    
    public boolean isFocusTraversable() {
    return true;
  }
    
    
    });
scrollPane.setFocusable(true);
//scrollPane.requestFocus();

scrollPane.addMouseListener(new CustomMouseListener(scrollPane));

/*
scrollPane.addMouseListener(new MouseListener()
{
public void mouseClicked(MouseEvent e) {  
        System.out.println("Mouse Clicked");
        scrollPane.requestFocus(); 
    }
public void mouseExited(MouseEvent e) { }    
public void mouseEntered(MouseEvent e) {  }  
public void mouseReleased(MouseEvent e) {  }
public void mousePressed(MouseEvent e) {  }       
});
*/


panel2.add(button1,BorderLayout.WEST);
panel2.add(button2);

contentPane.add(scrollPane, BorderLayout.CENTER);      
contentPane.add(panel1, BorderLayout.NORTH);
contentPane.add(panel2, BorderLayout.SOUTH);        

blagajna.setSize(700,600);
blagajna.setVisible(true);
blagajna.setLocationRelativeTo(null);
blagajna.setResizable(false);

}


}


class CustomMouseListener implements MouseListener {
JScrollPane scrollPane;
public CustomMouseListener(JScrollPane s1)
{
scrollPane=s1;
}
      public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked++");
        scrollPane.requestFocus(); 
      }
      public void mousePressed(MouseEvent e) {
      }
      public void mouseReleased(MouseEvent e) {
      }
      public void mouseEntered(MouseEvent e) {
      }
      public void mouseExited(MouseEvent e) {
      }
   }



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
unos.setResizable(false);

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
skladiste.setResizable(false);
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
JFrame unossifara;
Container con;
JPanel panel1,panel2;
JScrollPane pane;
JLabel sifra,usluga,id1,pdv1,mjera1,cijena1,id2,pdv2,mjera2,cijena2;
JTextField txtsifra,txtusluga,txtid1,txtpdv1,txtmjera1,txtcijena1,txtid2,txtpdv2,txtmjera2,txtcijena2;;
JButton potvrdi,odustani; 
JRadioButton rbutton1,rbutton2;

public unossifara()
{
unossifara=new JFrame("Unos sifara");
con=unossifara.getContentPane();
panel1= new JPanel();
panel1.setPreferredSize( new Dimension( 250, 500 ) );
panel1.setBorder(BorderFactory.createTitledBorder("panel1"));

panel2= new JPanel();
panel2.setBorder(BorderFactory.createTitledBorder("panel2"));


//GridLayout layout = new GridLayout(1,3);
//con.setLayout(layout);
GridLayout layout = new GridLayout(11,2,5,15);
panel1.setLayout(layout);
sifra=new JLabel("Unesi sifru");
txtsifra=new JTextField(10);
usluga=new JLabel("Unesi uslugu");
txtusluga=new JTextField(10);
usluga=new JLabel("Unesi uslugu");
txtusluga=new JTextField(10);
id1=new JLabel("Unesi id1");
txtid1=new JTextField(10);
pdv1=new JLabel("Unesi pdv1");
txtpdv1=new JTextField(10);
mjera1=new JLabel("Unesi mjera1");
txtmjera1=new JTextField(10);
cijena1=new JLabel("Unesi cijena1");
txtcijena1=new JTextField(10);

id2=new JLabel("Unesi id2");
txtid2=new JTextField(10);
pdv2=new JLabel("Unesi pdv2");
txtpdv2=new JTextField(10);
mjera2=new JLabel("Unesi mjera2");
txtmjera2=new JTextField(10);
cijena2=new JLabel("Unesi cijena2");
txtcijena2=new JTextField(10);

potvrdi=new JButton("Potvrdi");
odustani=new JButton("Odustani");

panel1.add(sifra);
panel1.add(txtsifra);
panel1.add(usluga);
panel1.add(txtusluga);
panel1.add(id1);
panel1.add(txtid1);
panel1.add(pdv1);
panel1.add(txtpdv1);
panel1.add(mjera1);
panel1.add(txtmjera1);
panel1.add(cijena1);
panel1.add(txtcijena1);

panel1.add(id2);
panel1.add(txtid2);
panel1.add(pdv2);
panel1.add(txtpdv2);
panel1.add(mjera2);
panel1.add(txtmjera2);
panel1.add(cijena2);
panel1.add(txtcijena2);
panel1.add(potvrdi);
panel1.add(odustani);

rbutton1 = new JRadioButton("id1");
rbutton2 = new JRadioButton("id2");
ButtonGroup colorButtonGroup = new ButtonGroup();
colorButtonGroup.add(rbutton1);
colorButtonGroup.add(rbutton2);
rbutton1.setSelected(true);
panel2.add(rbutton1);
panel2.add(rbutton2);

Vector<Vector> data = new Vector<Vector>();
Vector<String> col = new Vector<String>();
Connection c = null;
Statement st = null;
try {
Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:baza.db");
st = c.createStatement();
ResultSet rs = st.executeQuery("SELECT id,artikl,pdv FROM skladiste;");

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
JTable table = new JTable(model){
      public boolean isCellEditable(int rowIndex, int vColIndex) {
        return false;
      }
    };


table.setRowSelectionAllowed(true);
pane = new JScrollPane(table);

pane.setBorder(BorderFactory.createTitledBorder("panel3"));
pane.setPreferredSize( new Dimension( 350, 500 ) );

unossifara.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           unossifara.dispose();
         }        
      }); 
      
 odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  unossifara.dispose();
  }
  });   
 ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);      
table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
 String str1=table.getValueAt(table.getSelectedRow(), 0).toString();
 String str2=table.getValueAt(table.getSelectedRow(), 2).toString();
 
 JOptionPane.showMessageDialog(unossifara,str1+" "+str2);
 if(rbutton1.isSelected()){
txtid1.setText(str1);
txtpdv1.setText(str2);
}else if(rbutton2.isSelected()){
txtid2.setText(str1);
txtpdv2.setText(str2);
}
        }
        
    });
  
con.add(panel1,BorderLayout.WEST);
con.add(panel2,BorderLayout.CENTER);
con.add(pane,BorderLayout.EAST);

unossifara.setSize(700,500);
unossifara.setResizable(false);
unossifara.setLocationRelativeTo(null); 
unossifara.setVisible(true);

odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  unossifara.dispose();
  }
  });  

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  potvrdix();
  }
  }); 


}

public void potvrdix(){
Connection c=null;
Statement stmt=null;
int txtsifrax=Integer.parseInt(txtsifra.getText().toString());
String txtuslugax=txtusluga.getText().toString();
int txtid1x=Integer.parseInt(txtid1.getText().toString());
float txtpdv1x=Float.parseFloat(txtpdv1.getText().toString());
float txtmjera1x=Float.parseFloat(txtmjera1.getText().toString());
float txtcijena1x=Float.parseFloat(txtcijena1.getText().toString());

int txtid2x=Integer.parseInt(txtid2.getText().toString());
float txtpdv2x=Float.parseFloat(txtpdv2.getText().toString());
float txtmjera2x=Float.parseFloat(txtmjera2.getText().toString());
float txtcijena2x=Float.parseFloat(txtcijena2.getText().toString());
    try {
      Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

  stmt = c.createStatement();

String sql=null;

if(txtid2x!=0){
 sql = "INSERT INTO sifrarnik "+ " (id,artikl,id1,mjera1,cijena1,pdv1,id2,mjera2,cijena2,pdv2)" +
 "VALUES ("+txtsifrax+",'"+txtuslugax+"',"+txtid1x+","+
 txtmjera1x+","+txtcijena1x+","+txtpdv1x+","+
 txtid2x+","+txtmjera2x+","+txtcijena2x+","+txtpdv2x+");";
 }
 else if(txtid2x==0){
 sql = "INSERT INTO sifrarnik "+ " (id,artikl,id1,mjera1,cijena1,pdv1,id2,mjera2,cijena2,pdv2)" +
 "VALUES ("+txtsifrax+",'"+txtuslugax+"',"+txtid1x+","+
 txtmjera1x+","+txtcijena1x+","+txtpdv1x+",0,0.0,0.0,0.0);";
 
 } 
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




class sifrarnik {
JFrame sifrarnik;
public sifrarnik()
{
sifrarnik=new JFrame("sifrarnik");
JPanel panel = new JPanel();
Container con=sifrarnik.getContentPane();
Vector<Vector> data = new Vector<Vector>();
Connection c = null;
Statement st = null;
Vector<String> col = new Vector<String>();
try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      st = c.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM sifrarnik;");
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


sifrarnik.setSize(800,800);
sifrarnik.setResizable(false);
sifrarnik.setLocationRelativeTo(null); 
sifrarnik.setVisible(true);
sifrarnik.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           sifrarnik.dispose();
         }        
      });   
}
private void alignRight(JTable table, int column) {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
}


}

