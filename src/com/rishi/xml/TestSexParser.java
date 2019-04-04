package com.rishi.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestSexParser {
public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {
	// create documnet
	DocumentBuilderFactory docfact = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = docfact.newDocumentBuilder();
	Document document = builder.newDocument();
	
	// create xml 
	Element cars =document.createElement("Cars");
	
	Element supercars =document.createElement("Supercars");
	supercars.setAttribute("company", "ferrari");
	
	cars.appendChild(supercars);

	Element carname ;
	carname=document.createElement("Carname");
	carname.setAttribute("type", "formulaOne");
	carname.setTextContent("Formula 101");
	
	supercars.appendChild(carname);
	
	carname = document.createElement("Carname");
	carname.setAttribute("type", "sports");
	carname.setTextContent("Formula 202");
	
	supercars.appendChild(carname);

	TransformerFactory factory = TransformerFactory.newInstance();
	Transformer trns = factory.newTransformer();
}
}
