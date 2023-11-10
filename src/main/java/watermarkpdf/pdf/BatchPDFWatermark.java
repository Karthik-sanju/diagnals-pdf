package watermarkpdf.pdf;
import java.util.Scanner;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.pdmodel.PDPage;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

import org.apache.pdfbox.pdmodel.font.PDType1Font;




public class BatchPDFWatermark {

    public static void addWatermarkToFolder(String inputFolderPath, String outputFolderPath, String watermarkText) {

    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input folder path: ");
        String inputFolderPath1 = scanner.nextLine();
       System.out.print("Enter the output folder path: ");
        String outputFolderPath1 = scanner.nextLine(); 
        System.out.print("Enter the watermark text: ");
        String watermarkText1 = scanner.nextLine();
    

        scanner.close();
    
    		
    	
        try {

            File inputFolder = new File(inputFolderPath1);

            File[] pdfFiles = inputFolder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".pdf");
				}
			});


            if (pdfFiles == null)
            {

                System.out.println("No PDF files found in the input folder.");

                return;

            }



            for (File inputFile : pdfFiles) 
            {

                String outputFilePath = outputFolderPath1 + File.separator + "watermarked_" + inputFile.getName();

                addWatermark(inputFile.getAbsolutePath(), outputFilePath, watermarkText1);

            }


            System.out.println("Watermark added to all PDF files in the folder.");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }




    public static void addWatermark(String inputFilePath, String outputFilePath, String watermarkText) {

        try {

            PDDocument document = PDDocument.load(new File(inputFilePath));

            int pageCount = document.getNumberOfPages();


            for (int i = 0; i < pageCount; i++) {

                PDPage page = document.getPage(i);

                PDRectangle mediaBox = page.getMediaBox();

                float pageWidth = mediaBox.getWidth();

                float pageHeight = mediaBox.getHeight();



                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);

                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 48);

                //contentStream.setOpacity(0.5f); // Adjust opacity as needed

                contentStream.beginText();

                contentStream.newLineAtOffset(pageWidth / 4, pageHeight / 4); // Adjust watermark position

                contentStream.showText(watermarkText);

                contentStream.endText();

                contentStream.close();

            }




            document.save(outputFilePath);

            document.close();

            System.out.println("Watermark added to: " + outputFilePath);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }




    public static void main(String[] args) {

        String inputFolderPath = "input_folder"; // Replace with the path to your input folder

        String outputFolderPath = "output_folder"; // Replace with the desired output folder path

        String watermarkText = "Watermark Text"; // Replace with your watermark text




        addWatermarkToFolder(inputFolderPath, outputFolderPath, watermarkText);

    }

}