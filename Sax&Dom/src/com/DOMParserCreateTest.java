package com;

	import java.io.File;
	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	 
	/**
	 * This class is used to create XML document using DOM parser.
	 
	 */
	public class DOMParserCreateTest {
		public static void main(String args[]) {
			try {
			//File Path
			String filePath = "D:\\class.xml";
	 
			//Create DocumentBuilderFactory object.
			DocumentBuilderFactory dbFactory = 
	        DocumentBuilderFactory.newInstance();
	 
			//Get DocumentBuilder object.
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	 
			//Get Document object.
			Document document = dBuilder.newDocument();
	 
			//Define root element.
			Element rootElement = document.createElement("class");
			document.appendChild(rootElement);
	 
			//Define students element.
			Element students = document.createElement("students");
			rootElement.appendChild(students);
	 
			//Set attribute to element.
			Attr attr = document.createAttribute("className");
			attr.setValue("MCA");
			students.setAttributeNode(attr);
	 
			//Define StudentName elements.
			Element student1 = document.createElement("studentName");
			student1.appendChild(document.createTextNode("sayali"));
			students.appendChild(student1);
	 
			Element student2 = document.createElement("studentName");
			student2.appendChild(document.createTextNode("payal"));
			students.appendChild(student2);
	 
			//Write content into XML file.
			TransformerFactory transformerFactory = 
			                     TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);
	 
			//For console Output.
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);			
		    } catch (Exception e) {
			e.printStackTrace();
		  }
	       }
	}

