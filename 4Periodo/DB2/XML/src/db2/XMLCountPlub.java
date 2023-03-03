package db2;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class XMLCountPlub extends DefaultHandler {
    private int contadorPub;
    
    @Override
    public void startDocument() throws SAXException{
        contadorPub = 0;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if (qName.equals("title")) contadorPub++;
    } 
    
    public int getNumeroPublicacoes(){
        return contadorPub;
    }
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException{
       SAXParserFactory factory = SAXParserFactory.newInstance();
       SAXParser saxParser = factory.newSAXParser();
       XMLCountPlub TesteParser = new XMLCountPlub();
       saxParser.parse("8332.xml", TesteParser);
       System.out.println ( "#pubs: " + TesteParser.getNumeroPublicacoes());
    }
}