/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.utils;

import com.bookstore.dtos.userDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author tranv
 */
public class XMLUtilities {

    public static XMLStreamReader parseFileToStAXCursor(InputStream is) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        return reader;
    }

    public static String getNodeStaXVale(XMLStreamReader reader, String elementName,
            String nameSpaceURI, String attName) throws XMLStreamException {
        if (reader != null) {
            while (reader.hasText()) {
                int cursor = reader.getEventType();
                if (cursor == XMLStreamConstants.START_ELEMENT) {
                    String tagName = reader.getLocalName();
                    if (tagName.equals(elementName)) {
                        String result = reader.getAttributeValue(nameSpaceURI, attName);
                        return result;
                    }
                }
                reader.next();
            }
        }
        return null;
    }

    //for searching
    public static XMLEventReader parseFileToStAXInterator(InputStream is) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLEventReader reader = factory.createXMLEventReader(is);
        return reader;
    }

    //get attribute of a node
    public static String getNodeStAXValue(XMLEventReader reader, String elementName,
            String nameSpaceURI, String attrName) throws XMLStreamException {
        if (reader != null) {
            while (reader.hasNext()) {
                XMLEvent event = reader.peek();
                if (event.isStartElement()) {
                    StartElement startElement = (StartElement) event;
                    if (startElement.getName().getLocalPart().equals(elementName)) {
                        Attribute attr = startElement.getAttributeByName(new QName(nameSpaceURI, attrName));
                        if (attr != null) {
                            String value = attr.getValue();
                            return value;
                        }

                    }
                }
                reader.next();
            }
        }
        return null;
    }

    //get text node of a element
    public static String getTextStAXContext(XMLEventReader reader, String elementName) throws XMLStreamException {
        if (reader != null) {
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = (StartElement) event;
                    if (startElement.getName().getLocalPart().equals(elementName)) {
                        event = reader.nextEvent();
                        Characters chars = (Characters) event;
                        String value = chars.getData();
                        reader.nextEvent();
                        return value;
                    }
                }

            }
        }
        return "";
    }
//
//    public static boolean insertNodeinStAXusingJAXB(String id, String fullName, String userName,
//            String password, String realPath, String xmlFileName) {
//        InputStream is = null;
//        OutputStream os = null;
//        XMLEventReader reader = null;
//        XMLEventWriter writer = null;
//
//        try {
//            XMLInputFactory xif = XMLInputFactory.newFactory();
//            is = new FileInputStream(realPath + xmlFileName);
//            reader = xif.createXMLEventReader(is);
//
//            XMLOutputFactory xof = XMLOutputFactory.newFactory();
//            os = new FileOutputStream(realPath + xmlFileName + ".new");
//            writer = xof.createXMLEventWriter(os);
//
//            JAXBContext jaxb = JAXBContext.newInstance(userDTO.class);
//            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
//            Marshaller marshaller = jaxb.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//
//            while (reader.hasNext()) {
//                //add equals to
//                if (reader.peek().isEndElement() && reader.peek().asEndElement().getName().getLocalPart().equals()) {
//                    // new User
//                    marshaller.marshal("user", writer);
//                    writer.add(reader.nextEvent());
//                } else {
//                    writer.add(reader.nextEvent());
//                }
//            }
//            writer.flush();
//            writer.close();
//            is.close();
//            os.close();
//            //xoa file cu
//            File file = new File(realPath + xmlFileName);
//            file.delete();
//            file = null;
//            //doi ten file
//            file = new File(realPath + xmlFileName + ".new");
//            file.renameTo(new File(realPath + xmlFileName));
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

}
