import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Report {
    /** The resulting PDF file. */
    public static final String RESULT = "HitTable.pdf";
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main() throws DocumentException, IOException {
    	// step 1
        Document document = new Document(PageSize.A5.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfPTable table = new PdfPTable(2);
        // a long phrase
        Phrase p = new Phrase("This is the first report i got.");
        PdfPCell cell = new PdfPCell(p);
        // the prhase is wrapped
        table.addCell("Report details");
        cell.setNoWrap(false);
        table.addCell(cell);
        
        // the phrase isn't wrapped
        table.addCell("First");
        cell.setNoWrap(true);
        table.addCell(cell);
        // a long phrase with newlines
        p = new Phrase(
          " The System stores and manages both the security staff and the clients");
        cell = new PdfPCell(p);
        // the phrase fits the fixed height
        table.addCell("It has various sections that can be accessed from different parent forms");
        cell.setFixedHeight(72f);
        table.addCell(cell);
        // the phrase doesn't fit the fixed height
        table.addCell("For example the staff table can be accessed by pressing on the staff button on the home page");
        cell.setFixedHeight(36f);
        table.addCell(cell);
        // The minimum height is exceeded
        table.addCell("The Clients field can be accessed by pressing the cients button on the home page");
        cell = new PdfPCell(new Phrase("More improvements are to come"));
        cell.setMinimumHeight(36f);
        table.addCell(cell);
        // The last row is extended
        table.setExtendLastRow(true);
        table.addCell("Thank you");
        table.addCell(cell);
        document.add(table);
        
        ////////open the file//////////
        if(Desktop.isDesktopSupported()){
        try{
            File myfile = new File("HitTable.pdf");
            Desktop.getDesktop().open(myfile);//for ubuntu replace this line with , Runtime.getRuntime().exec("evince " + "OnlyBseStudents.pdf");  //evince is a pdf opening prog in ubuntu
            /**
             * but if the above does not work, for higher oubuntu versions like in 
             * apache netbeans 31 and above then replece the whole of the try block
             * with
             *   new ProcessBuilder("xdg-open", new File(OnlyBcsStudents.pdf").getAbsolutePath()).start();
             * 
             */

        }catch(IOException ex){
            }
        }
        /////////////////
        
        // step 5
        document.close();
    }
    
    // open the pdf file in which the tabl is
    
    
}