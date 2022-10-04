package db2;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.HashSet;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javax.xml.stream.events.StartElement;

public class XMLCoAutor extends DefaultHandler {
    
    HashSet<String> coAutores;
    private StringBuilder elementValue;
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        elementValue = new StringBuilder();
        
    }
    
    @Override
    public void startDocument() throws SAXException{
        coAutores = new HashSet<>();
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if (qName.equals("na")) coAutores.add(elementValue.toString());
    } 
    
    public HashSet getCoAutores(){
        return coAutores;
    }
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException{
       SAXParserFactory factory = SAXParserFactory.newInstance();
       SAXParser saxParser = factory.newSAXParser();
       XMLCoAutor TesteParser = new XMLCoAutor();
       saxParser.parse("8332.xml", TesteParser);
       TesteParser.getCoAutores().stream().forEach(System.out::println);
    }
    
}
