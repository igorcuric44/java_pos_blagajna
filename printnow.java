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

public class printnow {

    public static void main(String[] args) {
        final PrinterJob job = PrinterJob.getPrinterJob();

        Printable contentToPrint = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.setFont(new Font("Monospaced", Font.BOLD, 8));

                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                } //Only one page

                
g2d.drawString("Caffe kod praseta",0, 24); 
g2d.drawString("=======================================",0,32);
g2d.drawString("=======================================",0,46); 
                return PAGE_EXISTS;
            }
        };

        PageFormat pageFormat = new PageFormat();
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        Paper pPaper = pageFormat.getPaper();
        pPaper.setImageableArea(0, 0, pPaper.getWidth() , pPaper.getHeight() -2);
        pageFormat.setPaper(pPaper);

        job.setPrintable(contentToPrint, pageFormat);

        try {
            job.print();
        } catch (PrinterException e) {
            System.err.println(e.getMessage());
        }
    }
}