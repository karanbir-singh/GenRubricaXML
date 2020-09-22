import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = builder.parse(new File("D:\\Karanbir\\5AI 2020-2021\\TPI\\Sistemi distribuiti\\Prog. XML\\Rubrica\\rubrica.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        System.out.print("========================");
        NodeList nList = document.getElementsByTagName("Utente");

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                System.out.println("Nome: " + el.getElementsByTagName("Nome")
                        .item(0).getTextContent());
                System.out.println("Cognome: " + el.getElementsByTagName("Cognome")
                        .item(0).getTextContent());
                System.out.println("Email: " + el.getElementsByTagName("Email")
                        .item(0).getTextContent());
                System.out.println("Num. di telefono: " + el.getElementsByTagName("Numero")
                        .item(0).getTextContent());
            }
        }
        System.out.print("========================");
    }
}
