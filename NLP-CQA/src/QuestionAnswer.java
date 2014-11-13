import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class QuestionAnswer {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			for (File file : new File("/home/amal/Downloads/NewCategoryIdentification/xml").listFiles()) 
			{
			  System.out.println("-----------------------");
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  //System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			  NodeList nodeLst = doc.getElementsByTagName("Question");
			//  System.out.println("Allquestions");

			  for (int s = 0; s < nodeLst.getLength(); s++) {

			    Node fstNode = nodeLst.item(s);
			    
			    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
			  
			           Element fstElmnt = (Element) fstNode;
			      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("Subject");
			      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
			      NodeList fstNm = fstNmElmnt.getChildNodes();
			      System.out.println("Question : "  + ((Node) fstNm.item(0)).getNodeValue());
			      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("ChosenAnswer");
			      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
			      NodeList lstNm = lstNmElmnt.getChildNodes();
			      if((lstNm.item(0))!=null)
			      System.out.println("Chosen Answer : " + ((Node) lstNm.item(0)).getNodeValue());
			    }

			  }
			  
			  }
			System.out.println("over parsing files");
			}catch (Exception e) {
			    e.printStackTrace();
			  }
	}
	

}
