package app;

import javax.swing.JFileChooser;
import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

public class PDFtoCSV {

    public static void main(String[] args) throws Exception {

        System.out.println("MENU");
        System.out.println(
                "Choose one opcion :\n\t 1: Split PDF \n\t 2: Convert all files on directory \n\t 3: Open tabula ");

        Scanner pick = new Scanner(System.in);

        int y = pick.nextInt();

     do{

     
        switch (y) {
        case 1:
            if (y == 1) {
            /*
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);        
                int y = 1;
                while (y != 0) {
                PDDocument document = PDDocument.load(new File(chooser.getSelectedFile().getAbsolutePath()));    
        
                    Splitter spl = new Splitter();        
                    List<PDDocument> Pages = spl.split(document);
                    Iterator<PDDocument> iterator = Pages.listIterator();
        
                    int i = 0;
        
                    System.out.println("Qual é a pagina  ");
                    Scanner scanner = new Scanner(System.in);                                                       
                    y = scanner.nextInt();
                    while (iterator.hasNext()) {

                        i++;
                        PDDocument pd = iterator.next();
                        if (i == y) {  
                            String NewPath = (chooser.getSelectedFile().getPath() + "" + i + ".pdf");
                            pd.save(NewPath);
                            try (PDDocument document2 = PDDocument.load(new File(NewPath))) {
        
                                document2.getClass();
        
                                if (!document2.isEncrypted()) {                                                     
        
                                    PDFTextStripperByArea stripper2 = new PDFTextStripperByArea();
                                    stripper2.setSortByPosition(true);
                                    PDFTextStripper tStripper2 = new PDFTextStripper();
                                    String pdfFileInText2 = tStripper2.getText(document2);
                    
        
                                }
                            document2.close();
                            }
                        }
        
                    }

                }
                */
            }
                break;
            

        case 2:

            if (y == 2) {

                JFileChooser chooserdir = new JFileChooser();
                chooserdir.setCurrentDirectory(new java.io.File("."));
                chooserdir.setDialogTitle("InPut");
                chooserdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooserdir.setAcceptAllFileFilterUsed(false);

                chooserdir.showOpenDialog(null);
                String path = chooserdir.getSelectedFile().getAbsolutePath();

                System.out.println(path);
                
                
                String command = String.format("java -jar tabula-1.0.3-jar-with-dependencies.jar -p all -a 49.459,12.272,753.047,583.472 -b %s",path);
                Runtime.getRuntime().exec(command);

                JFileChooser chooserdirOut = new JFileChooser();
                chooserdirOut.setCurrentDirectory(new java.io.File("."));
                chooserdirOut.setDialogTitle("OutPut");
                chooserdirOut.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooserdirOut.setAcceptAllFileFilterUsed(false);

                chooserdirOut.showOpenDialog(null);
                String pathOut = chooserdirOut.getSelectedFile().getAbsolutePath();

                System.out.println(pathOut);

                File folder = new File(path);
                File[] reader = folder.listFiles();
              
                for (File currentFile : reader) {

                    String fileName = currentFile.getName();
                  
                    if (fileName.contains("csv")) {
                 
                        System.out.println(fileName);
                        String command1 = String.format("mv %s/%s %s", path, fileName, pathOut);
                        Runtime.getRuntime().exec(command1);

                    }
                }

            }
            break;

            case 3:
                if(y==3){

                    Runtime.getRuntime().exec("java -Dfile.encoding=utf-8 -Xms256M -Xmx1024M -jar tabula.jar");
                    // Aguardar um bocado e dar refresh 

                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new java.net.URI("http://127.0.0.1:8080/"));
                 
                    }

                }
             break;
            }

            System.out.println("MENU");
            System.out
                    .println("Choose one opcion :\n\t 1: Split PDF \n\t 2: Convert all directori \n\t 3: Open tabula ");

            Scanner pick2 = new Scanner(System.in);

            y = pick2.nextInt();

        } while (y > 0 && y < 4);

}
}