package db2;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.HashSet;

public class XMLMeioComunicacao extends DefaultHandler {
    
    HashSet<String> MeiosComunicacao;
    private StringBuilder elementValue;
    String teste;
    
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
        MeiosComunicacao = new HashSet<>();
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if (qName.equals("journal") || qName.equals("booktitle")){ 
            MeiosComunicacao.add(elementValue.toString());
        }
        
    } 

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
       
    public HashSet getMeiosComunicacao(){
        return MeiosComunicacao;
    }
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException{
       SAXParserFactory factory = SAXParserFactory.newInstance();
       SAXParser saxParser = factory.newSAXParser();
       XMLMeioComunicacao TesteParser = new XMLMeioComunicacao();
       saxParser.parse("8332.xml", TesteParser);
       TesteParser.getMeiosComunicacao().stream().forEach(System.out::println);
    }
    
}
