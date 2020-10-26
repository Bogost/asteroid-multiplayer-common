package edu.bo.app.asteroid_multiplayer_common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XmlLoader {

    private Document doc;

    public XmlLoader(String filePath) throws ParserConfigurationException, SAXException, IOException {
        File config = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(config);
        doc.getDocumentElement()
           .normalize();
    }

    public String getValue(String... nodePath) {
        String returnValue;
        if (nodePath.length == 1) {
            returnValue = doc.getElementsByTagName(nodePath[0])
                             .item(0)
                             .getTextContent();
        } else {
            Element element = (Element) doc.getElementsByTagName(nodePath[0])
                                           .item(0);
            if (element == null) {
                System.out.println("błąd");
            }
            for (int i = 1; i < nodePath.length - 1; i++) {
                element = (Element) element.getElementsByTagName(nodePath[i])
                                           .item(0);
            }
            returnValue = element.getElementsByTagName(nodePath[nodePath.length - 1])
                                 .item(0)
                                 .getTextContent();
        }
        return returnValue;
    }
}
