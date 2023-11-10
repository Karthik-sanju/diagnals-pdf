//package watermarkpdf.pdf;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//
//import org.apache.pdfbox.pdmodel.PDPage;
//
//
//
//import java.io.File;
//
//import java.io.IOException;
//
//import java.util.ArrayList;
//
//import java.util.List;
//
//
//
//
//public class PDFInsert {
//
//    public static void insertPDF(String mainPDFPath, String insertPDFPath, String outputPDFPath) {
//
//        try {
//
//            PDDocument mainDocument = PDDocument.load(new File(mainPDFPath));
//
//            PDDocument insertDocument = PDDocument.load(new File(insertPDFPath));
//
//
//
//
//            // Get the pages from the insert PDF
//
//            List<PDPage> insertPages = (List<PDPage>) insertDocument.getDocumentCatalog().getPages();
//
//
//
//
//            // Create a list to hold the pages of the resulting PDF
//
//            List<PDPage> combinedPages = new ArrayList<PDPage>();
//
//
//
//
//            // Add the pages of the main PDF to the combined list
//
//            for (PDPage page : mainDocument.getPages()) {
//
//                combinedPages.add(page);
//
//            }
//
//
//
//
//            // Add the pages of the insert PDF to the combined list
//
//            combinedPages.addAll(insertPages);
//
//
//
//
//            // Create a new document with the combined pages
//
//            PDDocument combinedDocument = new PDDocument();
//
//            combinedDocument.addPage(combinedPages.get(0)); // Add the first page
//
//
//
//
//            // Add the remaining pages
//
//            for (int i = 1; i < combinedPages.size(); i++) {
//
//                combinedDocument.addPage(combinedPages.get(i));
//
//            }
//
//
//
//
//            // Save the combined document to the output file
//
//            combinedDocument.save(outputPDFPath);
//
//
//
//
//            // Close the documents
//
//            mainDocument.close();
//
//            insertDocument.close();
//
//            combinedDocument.close();
//
//
//
//
//            System.out.println("PDFs successfully combined.");
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//    }
//
//
//
//
//    public static void main(String[] args) {
//
//        String mainPDFPath = "main.pdf"; // Path to the main PDF file
//
//        String insertPDFPath = "insert.pdf"; // Path to the PDF to be inserted
//
//        String outputPDFPath = "output.pdf"; // Path to the output PDF file
//
//
//
//
//        insertPDF(mainPDFPath, insertPDFPath, outputPDFPath);
//
//    }
//
//}