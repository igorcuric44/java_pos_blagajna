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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class kasa9 {
   


  
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
      
  
    frame.setSize(300,400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}
class blagajna {
JFrame blagajna;
JPanel panel1,panel2,panelx;
GridLayout layout,layoutx;
JButton button1,button2;
JLabel labelx1,labelx2,labelx3,labelx4,labely1,
labely2,labely3,labely4;
DateFormat dateFormat;
DateFormat timeFormat;
String str="";
int s=0,ss=0; 
Connection c = null;
Statement stmt = null;
String[] t=null;
float suma=0;
public blagajna()
{
blagajna=new JFrame("blagajna");
Container contentPane = blagajna.getContentPane();
layout = new GridLayout(0,3);
layoutx = new GridLayout(4,2);
panel1 = new JPanel();
panel2 = new JPanel(new BorderLayout());
panel1.setPreferredSize(new Dimension(100, 100));
layout.setHgap(10);
layout.setVgap(10);
panel1.setLayout(layout);
panelx=new JPanel();  
panelx.setLayout(layoutx);
Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 14);
labelx1=new JLabel("DATUM :",JLabel.CENTER);labelx1.setFont(myFont);  
labelx2=new JLabel("VRIJEME :",JLabel.CENTER);labelx2.setFont(myFont);   
labelx3=new JLabel("labelx3",JLabel.CENTER);labelx3.setFont(myFont); 
labelx4=new JLabel("labelx4",JLabel.CENTER);labelx4.setFont(myFont);  
labely1=new JLabel("labely1",JLabel.CENTER);labely1.setFont(myFont); 
labely2=new JLabel("labely2",JLabel.CENTER);labely2.setFont(myFont);  
labely3=new JLabel("labely3",JLabel.CENTER);labely3.setFont(myFont);
labely4=new JLabel("labely4",JLabel.CENTER);labely4.setFont(myFont); 
panelx.add(labelx1);panelx.add(labely1);
panelx.add(labelx2);panelx.add(labely2);
panelx.add(labelx3);panelx.add(labely3);
panelx.add(labelx4);panelx.add(labely4);
panelx.setFont(myFont);  

dateFormat = new SimpleDateFormat("dd/MM/yyyy");
timeFormat = new SimpleDateFormat("HH:mm:ss");
Date time = new Date();
String Date = dateFormat.format(time);
String Time = timeFormat.format(time);
labely1.setText(Date);
labely2.setText(Time);


JLabel label2=new JLabel("",JLabel.CENTER); 
JLabel label3=new JLabel("",JLabel.CENTER);
Font myFont2 = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
label3.setFont(myFont2);


panel1.add(panelx);
panel1.add(label2);
panel1.add(label3);

button1=new JButton("Stisni");
button2=new JButton("Print");


String data[][] = null;
  String col[] = {"Id","Artikl","Kolicina","Mjera","Cijena","Pdv","Iznos"};
DefaultTableModel model = new DefaultTableModel(data,col);
JTable table = new JTable(model);
JScrollPane scrollPane = new JScrollPane(table);
Font myFont1 = new Font("Serif", Font.ITALIC | Font.BOLD, 13);
table.setFont(myFont1);
JTableHeader header = table.getTableHeader();
header.setFont(myFont1);


blagajna.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           blagajna.dispose();
         }        
      }); 

scrollPane.addKeyListener(new KeyAdapter() {
  public void keyPressed(KeyEvent evt) {
  int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER && s==0) {
      System.out.println("Check for key characters: " +str);
try{     
t=new String[7];
Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:baza.db");
stmt = c.createStatement();

String strx="SELECT * FROM sifrarnik where id="+str+";";

ResultSet rs = stmt.executeQuery(strx);


t[0]=rs.getString(1);
t[1]=rs.getString(2);
t[2]="1";
//t[3]=rs.getString(4);
t[3]=rs.getString(4);
t[4]=rs.getString(5);
t[5]=rs.getString(6);
t[6]="7";


rs.close();
stmt.close();
c.close();
model.addRow(t);

}catch ( Exception ex ) {
      JOptionPane.showMessageDialog(blagajna,"artikla s tom sifrom nema");
}

s=1;




    }

if(key!=KeyEvent.VK_ENTER){
s=0;
ss=0;
}

if (key == KeyEvent.VK_ENTER && s==1) {
     
    if(model.getRowCount()>0){ 
      str="";
      System.out.println("Check for key characters: " +str);
      
ss++;
float cijena=ss*Float.parseFloat(t[4]);
suma+=Float.parseFloat(t[4]);
label3.setText(String.format("%.2f",suma));
model.setValueAt(ss,model.getRowCount()-1, 2);
model.setValueAt(cijena,model.getRowCount()-1, 6);
}else
JOptionPane.showMessageDialog(blagajna,"ocito nisi nista ukuco");
str="";


    }    
 
 if (key == KeyEvent.VK_SPACE) {
      System.out.println("SPACE ");
int rows = model.getRowCount(); 
for(int i = rows - 1; i >=0; i--)
{
   model.removeRow(i);
   label3.setText(String.format("%.2f",0f));
   suma=0f;
}
    } 
    
    if (evt.getKeyChar() == '0') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="0";
    }
    if (evt.getKeyChar() == '1') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="1";
    }
    if (evt.getKeyChar() == '2') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="2";
    }
    if (evt.getKeyChar() == '3') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="3";
    }
    if (evt.getKeyChar() == '4') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="4";
    }
   if (evt.getKeyChar() == '5') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="5";
    } 
    if (evt.getKeyChar() == '6') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="6";
    }
    if (evt.getKeyChar() == '7') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="7";
    }
    if (evt.getKeyChar() == '8') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="8";
    }
    if (evt.getKeyChar() == '9') {
      System.out.println(" characters: " + evt.getKeyChar());
      str+="9";
    }
    
    }
    
    
    
    public boolean isFocusTraversable() {
    return true;
  }
    
    
    });
scrollPane.setFocusable(true);


scrollPane.addMouseListener(new CustomMouseListener(scrollPane));

button1.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 if(model.getRowCount()>0){	
String x0=model.getValueAt(model.getRowCount() - 1, 6).toString();
String x1=label3.getText();

float xx0=Float.parseFloat(x0);
float xx1=Float.parseFloat(x1);
suma=xx1-xx0;
label3.setText(String.format("%.2f",suma));

System.out.println(x0+" "+x1+" "+suma);


model.removeRow(model.getRowCount() - 1);
}else
JOptionPane.showMessageDialog(blagajna,"ocito je sve obrisano");
  }
  }); 


panel2.add(button1,BorderLayout.WEST);
panel2.add(button2);

contentPane.add(scrollPane, BorderLayout.CENTER);      
contentPane.add(panel1, BorderLayout.NORTH);
contentPane.add(panel2, BorderLayout.SOUTH);        

blagajna.setSize(800,600);
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

