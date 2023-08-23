package Actitime;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDatafromPdf {

	public static void main(String[] args) throws Throwable {
		
		File file = new File("./src/main/resources/Pankaj Kumar - 18.10.2022.cleaned.pdf");
		PDDocument doc = PDDocument.load(file);
		
		//page count
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		//Read Content
		PDFTextStripper pdfdata = new PDFTextStripper();
		/*String data = pdfdata.getText(doc);
		System.out.println(data);*/
		
		//print particular page data
		/*pdfdata.setStartPage(2);
		String data = pdfdata.getText(doc);
		System.out.println(data);*/
		
		//print multiple page data
		pdfdata.setStartPage(1);
		pdfdata.setEndPage(2);
		String data = pdfdata.getText(doc);
		System.out.println(data);
		
		
	}

}
//update this
