import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.JobAttributes;
import java.awt.geom.Line2D;
import javax.swing.JOptionPane;
import java.awt.print.*;
import java.awt.*;

class printnow2{
public static void main(String[] args)
{
final PrinterJob job = PrinterJob.getPrinterJob();
       Printable contentToPrint = new Printable(){
       @Override
        public int print(Graphics graphics, PageFormat pf, int page) throws PrinterException 
        {
           if (page > 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		/* Now we perform our rendering */
 
		g2d.setFont(new Font("Roman", 0, 8));
		g2d.drawString("Hello world !", 0, 10);
 		g2d.drawString("Hello world !", 0, 20);
		g2d.drawString("+++++++++++++++++++++++", 0, 30);
		return PAGE_EXISTS;

           
         }
       };
PageFormat pageFormat = new PageFormat();
        pageFormat.setOrientation(PageFormat.PORTRAIT);
/*
        Paper pPaper = pageFormat.getPaper();
        pPaper.setImageableArea(0, 0, pPaper.getWidth() , pPaper.getHeight() -2);
        pageFormat.setPaper(pPaper);

*/       
       job.setPrintable(contentToPrint,pageFormat);
       //You can show a print dialog before printing by job by wrapping the following blocks with a conditional statement if(job.printDialog()){...}
       try 
       {
           job.print();
       } catch (PrinterException e) 
       {
           System.err.println(e.getMessage());
       }

 }

}