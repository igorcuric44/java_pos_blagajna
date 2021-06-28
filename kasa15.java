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
import java.util.Vector;
import javax.swing.JPasswordField;

public class kasa15 {
   


  
   public static void main(String[] args){
    JFrame frame = new JFrame("CuricsoftdevelopmentTECH");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
   Container con=frame.getContentPane();
    JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel2.setBackground(Color.gray);
      //panel.setSize(600,300);
      GridLayout layout = new GridLayout(11,1);
      layout.setHgap(10);
      layout.setVgap(10);

      panel2.setLayout(layout);
      JButton buton1=new JButton("BLAGAJNA");       
      JButton buton2=new JButton("UNOS"); 
      JButton buton3=new JButton("SLADISTE"); 
      JButton buton4=new JButton("UNOS SIFARA"); 
      JButton buton5=new JButton("SIFRARNIK");
      JButton buton6=new JButton("POPUNA SKLADISTA");
      JButton buton7=new JButton("BRISANJE ARTIKLA");
      JButton buton8=new JButton("PROMIJENA CIJENE");
      JButton buton9=new JButton("DJELATNICI");
      JButton buton10=new JButton("POSTAVKE");
      JButton buton11=new JButton("IZLAZ");
      
      
      
      
buton1.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 new blagajnax(buton1);
 buton1.setEnabled(false);
  }
  }); 
buton2.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 new unos(buton2);
 buton2.setEnabled(false);
  }
  }); 
buton3.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new skladiste(buton3);
 	buton3.setEnabled(false);
  }
  }); 

buton4.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new unossifara(buton4);
 	buton4.setEnabled(false);
  }
  }); 


buton5.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new sifrarnik(buton5);
 	buton5.setEnabled(false);
  }
  }); 

buton6.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new skladisnica(buton6);
 	buton6.setEnabled(false);
  }
  }); 

buton7.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new brisanje(buton7);
 	buton7.setEnabled(false);
  }
  }); 

buton8.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new procijene(buton8);
 	buton8.setEnabled(false);
  }
  }); 

buton9.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new djelatnici(buton9);
 	buton9.setEnabled(false);
  }
  }); 

buton10.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 
 	new postavke(buton10);
 	buton10.setEnabled(false);
  }
  });


buton11.addActionListener(new ActionListener(){
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

      panel2.add(buton1);
      panel2.add(buton2); 
      panel2.add(buton3); 
      panel2.add(buton4); 
      panel2.add(buton5);
      panel2.add(buton6); 
      panel2.add(buton7);
      panel2.add(buton8); 
      panel2.add(buton9);
      panel2.add(buton10);
      panel2.add(buton11);
      
      JLabel label=new JLabel("IZLAZ");
      Font myFontx= new Font("Serif", Font.ITALIC | Font.BOLD, 18);
	label.setFont(myFontx);
      panel1.add(label);
      
      
Connection c=null;
Statement stmt=null;
try {
      Class.forName("org.sqlite.JDBC");
c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

  stmt = c.createStatement();
  
  String str="SELECT poduzece FROM poduzece;";

ResultSet rs = stmt.executeQuery(str);
rs.next();

String st=rs.getString(1);
System.out.println(st);
 label.setText(st); 
  
stmt.close();
     
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  

      
      con.add(panel1,BorderLayout.NORTH);
      con.add(panel2, BorderLayout.CENTER);      

  
    frame.setSize(300,600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}

class blagajnax {
JButton buton1;
JFrame blagajnax;
JPanel panel;
JLabel ime,zaporka;
JTextField txtime;
JButton potvrdi,odustani;
JPasswordField txtzaporka;
public blagajnax(JButton buton1)
{
this.buton1=buton1;
blagajnax=new JFrame("blagajnax");
Container con=blagajnax.getContentPane();
panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(3,2,30,20);
panel.setLayout(layout);
Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);

ime=new JLabel("Unesi ime");ime.setFont(myFont);
txtime=new JTextField(15);txtime.setFont(myFont);
zaporka=new JLabel("Unesi zaporka");zaporka.setFont(myFont);
txtzaporka=new JPasswordField(15);txtzaporka.setFont(myFont);
txtzaporka.setEchoChar('*');

potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);
panel.add(ime);
panel.add(txtime);
panel.add(zaporka);
panel.add(txtzaporka);




panel.add(potvrdi);
panel.add(odustani);

con.add(panel);

blagajnax.setSize(300,200);
blagajnax.setVisible(true);
blagajnax.setLocationRelativeTo(null);

blagajnax.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           blagajnax.dispose();
           buton1.setEnabled(true);
         }        
      });   

odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  blagajnax.dispose();
  buton1.setEnabled(true);
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

Connection c = null;
    Statement stmt = null;
String txtimex=txtime.getText().toString();
String txtzaporkax=txtzaporka.getText().toString();
 try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

      stmt = c.createStatement();

String str="SELECT * FROM djelatnici where ime='"+txtimex+"' and zaporka='"+txtzaporkax+"';";

ResultSet rs = stmt.executeQuery(str);
rs.next();
String[] t=new String[5];
t[0]=rs.getString(1);
t[1]=rs.getString(2);
t[2]=rs.getString(3);
t[3]=rs.getString(4);
t[4]=rs.getString(5);

System.out.println(t[0]+" "+t[1]+" "+t[2]+" "+t[3]+" "+t[4]);

blagajnax.dispose();
new blagajna(buton1,t);


rs.close();
stmt.close();
     
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getMessage() );
     JOptionPane.showMessageDialog(blagajnax, "Pogreska sa zaporkom");
//System.exit(0);
    }
    System.out.println("Records created successfully");
  }


}






class blagajna {
JButton buton1;
JFrame blagajna;
JPanel panel1,panel2,panelx;
GridLayout layout,layoutx;
JButton button1,button2;
JLabel labelx1,labelx2,labelx3,labelx4,labely1,
labely2,labely3,labely4;
DateFormat dateFormat;
DateFormat timeFormat;
Date time; 
String Date,Time;
String str="";
int s=0,ss=0; 
Connection c = null;
Statement stmt = null;
String[] t=null;
float suma=0;

public blagajna(JButton buton1,String[] p)
{
System.out.println("+++"+p[0]+" "+p[1]+" "+p[2]+" "+p[3]+" "+p[4]);
this.buton1=buton1;
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
labelx3=new JLabel("RACUN :",JLabel.CENTER);labelx3.setFont(myFont); 
labelx4=new JLabel("OPERATOR :",JLabel.CENTER);labelx4.setFont(myFont);  
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
time = new Date();
Date = dateFormat.format(time);
Time = timeFormat.format(time);
labely1.setText(Date);
labely2.setText(Time);

//labely4.setText(p[1]+" "+p[2]);
labely4.setText(String.format("%s %s(%s)",p[1],p[2],p[0]));

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
           buton1.setEnabled(true);
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
t[3]=String.format("%s",(rs.getDouble(4)+rs.getDouble(8)));
t[4]=String.format("%.2f",(rs.getDouble(5)+rs.getDouble(9)));;
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
model.setValueAt(String.format("%.2f",cijena),model.getRowCount()-1, 6);
}else
JOptionPane.showMessageDialog(blagajna,"ocito nisi nista ukuco");
str="";


    }    
 
 if (key == KeyEvent.VK_SPACE) {
      System.out.println("SPACE ");
String xx0,xx2;
for(int si=0;si<= model.getRowCount()-1;si++){
xx0=model.getValueAt(si, 0).toString();
String xx1=model.getValueAt(si, 1).toString();
xx2=model.getValueAt(si, 2).toString();
String xx3=model.getValueAt(si, 3).toString();
String xx4=model.getValueAt(si, 4).toString();
String xx5=model.getValueAt(si, 5).toString();
String xx6=model.getValueAt(si, 6).toString();

System.out.println("++++"+xx0+" "+xx1+" "+xx2+" "+xx3+" "+xx4+" "+xx5+" "+xx6+" ");

Connection c = null;
Statement stmt = null;
 try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
String str="SELECT id1,id2,mjera1,mjera2 FROM sifrarnik where id="+xx0+";";

ResultSet rs = stmt.executeQuery(str);
rs.next();

int id1=rs.getInt(1);
int id2=rs.getInt(2);
double mjera1=rs.getDouble(3);
double mjera2=rs.getDouble(4);

if(id1!=0){
String str1="SELECT kolicina FROM skladiste where id="+id1+";";
rs = stmt.executeQuery(str1);
rs.next();

double kol=Float.parseFloat(xx2);
double kolicina=rs.getDouble(1);
double kolicinax=0.0f;

kolicinax=kolicina-mjera1*kol;

String sqlx = "update skladiste set kolicina="+kolicinax+" where id="+id1+";";
stmt.executeUpdate(sqlx);
System.out.println("++++"+kolicina+" ");

}


if(id2!=0){
String str1="SELECT kolicina FROM skladiste where id="+id2+";";
rs = stmt.executeQuery(str1);
rs.next();
double kol=Float.parseFloat(xx2);
double kolicina=rs.getDouble(1);
double kolicinax=0.0f;

kolicinax=kolicina-mjera1*kol;

String sqlx = "update skladiste set kolicina="+kolicinax+" where id="+id2+";";
stmt.executeUpdate(sqlx);
System.out.println("++++"+kolicina+" ");


}


System.out.println(" "+id1+" "+id2);
rs.close();


stmt.close();
c.close();
} catch ( Exception e ) {
      System.err.println( e.getMessage() );
     JOptionPane.showMessageDialog(blagajna, "Pogreska sa zaporkom");
//System.exit(0);
}




}

int rows = model.getRowCount();

 
 
for(int i = rows - 1; i >=0; i--)
{
   model.removeRow(i);
   label3.setText(String.format("%.2f",0f));
   suma=0f;
}

time = new Date();
Date = dateFormat.format(time);
Time = timeFormat.format(time);
labely1.setText(Date);
labely2.setText(Time);


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
JButton buton2;
JFrame unos;
JPanel panel;
JLabel sifra,artikl,pdv,kolicina,mjera,cijena;
JTextField txtsifra,txtartikl,txtpdv,txtkolicina,txtmjera,txtcijena;
JButton potvrdi,odustani;


public unos(JButton buton2)
{
this.buton2=buton2;
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
           buton2.setEnabled(true);
         }        
      }); 
      
odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  unos.dispose();
  buton2.setEnabled(true);
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
JButton buton3;
JFrame skladiste;
public skladiste(JButton buton3)
{
this.buton3=buton3;
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
           buton3.setEnabled(true);
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
JButton buton4;
JFrame unossifara;
Container con;
JPanel panel1,panel2;
JScrollPane pane;
JLabel sifra,usluga,id1,pdv1,mjera1,cijena1,id2,pdv2,mjera2,cijena2;
JTextField txtsifra,txtusluga,txtid1,txtpdv1,txtmjera1,txtcijena1,txtid2,txtpdv2,txtmjera2,txtcijena2;;
JButton potvrdi,odustani; 
JRadioButton rbutton1,rbutton2;

public unossifara(JButton buton4)
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
           buton4.setEnabled(true);
         }        
      }); 
      
 odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  unossifara.dispose();
  buton4.setEnabled(true);
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
JButton buton5;
JFrame sifrarnik;
public sifrarnik(JButton buton5)
{
this.buton5=buton5;
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
           buton5.setEnabled(true);
         }        
      });   
}
private void alignRight(JTable table, int column) {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
}


}


class skladisnica {
JButton buton6;
JFrame skladisnica;
JPanel panel;
JButton potvrdi,odustani;
JLabel sifra,kolicina;
JTextField txtsifra,txtkolicina;

public skladisnica(JButton buton6)
{
this.buton6=buton6;
skladisnica=new JFrame("skladisnica");

Container con=skladisnica.getContentPane();
panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(3,2,30,15);
panel.setLayout(layout);

Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);

sifra=new JLabel("Unesi sifru");sifra.setFont(myFont);
txtsifra=new JTextField(15);txtsifra.setFont(myFont);
kolicina=new JLabel("Unesi kolicinu");kolicina.setFont(myFont);
txtkolicina=new JTextField(15);txtkolicina.setFont(myFont);


potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);

panel.add(kolicina);
panel.add(txtkolicina);
panel.add(sifra);
panel.add(txtsifra);


panel.add(potvrdi);
panel.add(odustani);

con.add(panel);
skladisnica.setSize(300,150);
skladisnica.setLocationRelativeTo(null); 
skladisnica.setVisible(true);
skladisnica.setResizable(false);

skladisnica.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           skladisnica.dispose();
           buton6.setEnabled(true);
         }        
      }); 
      
odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  skladisnica.dispose();
  buton6.setEnabled(true);
  }
  });   

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  potvrdiy();
  }
  }); 

}

public void potvrdiy(){
System.out.println("potvrda");

Connection c = null;
Statement stmt = null;
int txtsifrax=Integer.parseInt(txtsifra.getText().toString());
float txtkolicinax=Float.parseFloat(txtkolicina.getText().toString());

try{
Class.forName("org.sqlite.JDBC");
c=DriverManager.getConnection("jdbc:sqlite:baza.db");
System.out.println("Opened database successfully");

stmt = c.createStatement();

String str="SELECT kolicina FROM skladiste where id="+txtsifrax+";";

ResultSet rs = stmt.executeQuery(str);
rs.next();

String st=rs.getString(1);
System.out.println(st);

float txtkolicinab=Float.parseFloat(st);

txtkolicinab=txtkolicinab+txtkolicinax;

String sqlx = "UPDATE skladiste set kolicina="+txtkolicinab+" where id="+txtsifrax+";";
stmt.executeUpdate(sqlx);


rs.close();
stmt.close();
c.close();
}catch(Exception e) {

}
}


}

class brisanje {
JButton buton7;
JFrame brisanje;
JPanel panel;
JButton potvrdi,odustani;
JLabel sifra;
JTextField txtsifra;

public brisanje(JButton buton7)
{
this.buton7=buton7;
brisanje=new JFrame("Brisanje artikla");

Container con=brisanje.getContentPane();
panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(2,2,30,15);
panel.setLayout(layout);

Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);

sifra=new JLabel("Unesi sifru");sifra.setFont(myFont);
txtsifra=new JTextField(15);txtsifra.setFont(myFont);


potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);


panel.add(sifra);
panel.add(txtsifra);


panel.add(potvrdi);
panel.add(odustani);

con.add(panel);
brisanje.setSize(300,150);
brisanje.setLocationRelativeTo(null); 
brisanje.setVisible(true);
brisanje.setResizable(false);

brisanje.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           brisanje.dispose();
           buton7.setEnabled(true);
         }        
      }); 
      
odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  brisanje.dispose();
  buton7.setEnabled(true);
  }
  });   

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  potvrdiy();
  }
  }); 

}

public void potvrdiy(){
System.out.println("potvrda");

Connection c = null;
Statement stmt = null;
int txtsifrax=Integer.parseInt(txtsifra.getText().toString());

try{
Class.forName("org.sqlite.JDBC");
c=DriverManager.getConnection("jdbc:sqlite:baza.db");
System.out.println("Opened database successfully");

stmt = c.createStatement();

String sqlx = "delete from skladiste  where id="+txtsifrax+";";
stmt.executeUpdate(sqlx);



stmt.close();
c.close();
}catch(Exception e) {

}
}


}



class procijene {
JButton buton8;
JFrame procijene;
JPanel panel;
JButton potvrdi,odustani;
JLabel sifra,cijena;
JTextField txtsifra,txtcijena;

public procijene(JButton buton8)
{
this.buton8=buton8;
procijene=new JFrame("Promijena cijene");

Container con=procijene.getContentPane();
panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(3,2,30,15);
panel.setLayout(layout);

Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);

sifra=new JLabel("Unesi sifru");sifra.setFont(myFont);
txtsifra=new JTextField(15);txtsifra.setFont(myFont);
cijena=new JLabel("Unesi cijenu");cijena.setFont(myFont);
txtcijena=new JTextField(15);txtcijena.setFont(myFont);

potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);


panel.add(sifra);
panel.add(txtsifra);
panel.add(cijena);
panel.add(txtcijena);

panel.add(potvrdi);
panel.add(odustani);

con.add(panel);
procijene.setSize(300,150);
procijene.setLocationRelativeTo(null); 
procijene.setVisible(true);
procijene.setResizable(false);

procijene.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           procijene.dispose();
           buton8.setEnabled(true);
         }        
      }); 
      
odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  procijene.dispose();
  buton8.setEnabled(true);
  }
  });   

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  potvrdiy();
  }
  }); 

}

public void potvrdiy(){
System.out.println("potvrda");

Connection c = null;
Statement stmt = null;

float txtcijenax=Float.parseFloat(txtcijena.getText().toString());
int txtsifrax=Integer.parseInt(txtsifra.getText().toString());

try{
Class.forName("org.sqlite.JDBC");
c=DriverManager.getConnection("jdbc:sqlite:baza.db");
System.out.println("Opened database successfully");

stmt = c.createStatement();

String sqlx = "update skladiste set cijena="+txtcijenax+" where id="+txtsifrax+";";
stmt.executeUpdate(sqlx);



stmt.close();
c.close();
}catch(Exception e) {

}
}


}




class djelatnici {
JButton buton9;
JFrame djelatnici;
JPanel panel;
JLabel id_djelatnika,oib,ime,prezime,zaporka;
JTextField id_djelatnikatxt,oibtxt,imetxt,prezimetxt,zaporkatxt;
JButton potvrdi,odustani;
public djelatnici(JButton buton9)
{
this.buton9=buton9;
djelatnici=new JFrame("djelatnici");

panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(6,2,30,20);
panel.setLayout(layout);
Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
panel.setFont(myFont);

id_djelatnika=new JLabel("Unesi id_djelanika");id_djelatnika.setFont(myFont);
id_djelatnikatxt=new JTextField(15);id_djelatnikatxt.setFont(myFont);
oib=new JLabel("Unesi oib");oib.setFont(myFont);
oibtxt=new JTextField(15);oibtxt.setFont(myFont);
ime=new JLabel("Unesi ime");ime.setFont(myFont);
imetxt=new JTextField(15);imetxt.setFont(myFont);
prezime=new JLabel("Unesi prezime");prezime.setFont(myFont);
prezimetxt=new JTextField(15);prezimetxt.setFont(myFont);
zaporka=new JLabel("Unesi zaporku");zaporka.setFont(myFont);
zaporkatxt=new JTextField(15);zaporkatxt.setFont(myFont);
potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);
panel.add(id_djelatnika);
panel.add(id_djelatnikatxt);
panel.add(oib);
panel.add(oibtxt);
panel.add(ime);
panel.add(imetxt);
panel.add(prezime);
panel.add(prezimetxt);
panel.add(zaporka);
panel.add(zaporkatxt);

panel.add(potvrdi);
panel.add(odustani);



djelatnici.add(panel);
djelatnici.setSize(400,400);
djelatnici.setVisible(true);
djelatnici.setLocationRelativeTo(null);


odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  djelatnici.dispose();
  buton9.setEnabled(true);
  }
  }); 

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 potvrdi();
  }
  }); 

djelatnici.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           djelatnici.dispose();
           buton9.setEnabled(true);
         }        
      });   
}



public  void potvrdi()
{

Connection c = null;
    Statement stmt = null;
int xid_djelatnikatxt=Integer.parseInt(id_djelatnikatxt.getText().toString());
String xoibtxt=oibtxt.getText().toString();
String ximetxt=imetxt.getText().toString();
String xprezimetxt=prezimetxt.getText().toString();
String xzaporkatxt=zaporkatxt.getText().toString();
 try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

      stmt = c.createStatement();

 String sql = "INSERT INTO djelatnici (id_djelatnik,ime,prezime,oib,zaporka) " +
              "VALUES ("+xid_djelatnikatxt+",'"+ximetxt+"','"+xprezimetxt+"','"+xoibtxt+"','"+xzaporkatxt+"');"; 
stmt.executeUpdate(sql);



stmt.close();
     
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getMessage() );
     JOptionPane.showMessageDialog(djelatnici, "Greska");
//System.exit(0);
    }
    System.out.println("Records created successfully");
  }


}



class postavke {
JButton buton10;
JFrame postavke;
JPanel panel;
JLabel poduzece,ime,prezime,adresa,mjesto,oib,telefon;
JTextField poduzecetxt,imetxt,prezimetxt,adresatxt,mjestotxt,oibtxt,telefontxt;
JButton potvrdi,odustani;
public postavke(JButton buton10)
{
this.buton10=buton10;
postavke=new JFrame("postavke");

panel = new JPanel();
panel.setBackground(Color.gray);
GridLayout layout = new GridLayout(8,2,30,20);
panel.setLayout(layout);
Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
panel.setFont(myFont);

poduzece=new JLabel("Unesi poduzece");poduzece.setFont(myFont);
poduzecetxt=new JTextField(15);poduzecetxt.setFont(myFont);
ime=new JLabel("Unesi ime");ime.setFont(myFont);
imetxt=new JTextField(15);imetxt.setFont(myFont);
prezime=new JLabel("Unesi prezime");prezime.setFont(myFont);
prezimetxt=new JTextField(15);prezimetxt.setFont(myFont);
adresa=new JLabel("Unesi adresu");adresa.setFont(myFont);
adresatxt=new JTextField(15);adresatxt.setFont(myFont);
mjesto=new JLabel("Unesi mjesto");mjesto.setFont(myFont);
mjestotxt=new JTextField(15);mjestotxt.setFont(myFont);
oib=new JLabel("Unesi oib");oib.setFont(myFont);
oibtxt=new JTextField(15);oibtxt.setFont(myFont);
telefon=new JLabel("Unesi telefon");telefon.setFont(myFont);
telefontxt=new JTextField(15);telefontxt.setFont(myFont);



potvrdi=new JButton("Potvrdi");potvrdi.setFont(myFont);
odustani=new JButton("odustani");odustani.setFont(myFont);

panel.add(poduzece);
panel.add(poduzecetxt);
panel.add(ime);
panel.add(imetxt);
panel.add(prezime);
panel.add(prezimetxt);
panel.add(adresa);
panel.add(adresatxt);
panel.add(mjesto);
panel.add(mjestotxt);
panel.add(oib);
panel.add(oibtxt);
panel.add(telefon);
panel.add(telefontxt);

panel.add(potvrdi);
panel.add(odustani);



postavke.add(panel);
postavke.setSize(400,400);
postavke.setVisible(true);
postavke.setLocationRelativeTo(null);


odustani.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
  postavke.dispose();
  buton10.setEnabled(true);
  }
  }); 

potvrdi.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent ae){
 potvrdi();
  }
  }); 

postavke.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           postavke.dispose();
           buton10.setEnabled(true);
         }        
      });   
}



public  void potvrdi()
{

Connection c = null;
Statement stmt = null;
String xpoduzecetxt=poduzecetxt.getText().toString();
String ximetxt=imetxt.getText().toString();
String xprezimetxt=prezimetxt.getText().toString();
String xadresatxt=adresatxt.getText().toString();
String xmjestotxt=mjestotxt.getText().toString();
String xoibtxt=oibtxt.getText().toString();
String xtelefontxt=telefontxt.getText().toString();

 try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:baza.db");
      
      System.out.println("Opened database successfully");

      stmt = c.createStatement();

 String sql = "drop table if exists poduzece; "+
 	      "create table poduzece (" +
              "poduzece text not null,"+
              "ime text not null,"+
              "prezime text not null,"+
              "adresa text not null,"+
              "mjesto text not null,"+
              "oib text not null,"+
              "telefon text not null)";
              stmt.executeUpdate(sql);

sql="insert into poduzece (poduzece,ime,prezime,"+
     "adresa,mjesto,oib,telefon) values ('"+xpoduzecetxt+"','"+
     ximetxt+"','"+xprezimetxt+"','"+xadresatxt+"','"+
     xmjestotxt+"','"+xoibtxt+"','"+xtelefontxt+"');";
stmt.executeUpdate(sql);
stmt.close();
     
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getMessage() );
     JOptionPane.showMessageDialog(postavke, "Greska");
//System.exit(0);
    }
    System.out.println("Records created successfully");
  }


}



