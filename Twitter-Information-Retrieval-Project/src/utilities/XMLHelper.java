package utilities;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import data.Tweet;

public class XMLHelper {
	
    public static void saveTweets(ArrayList<Tweet> tweets) throws Exception {
            // create an XMLOutputFactory
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            // create XMLEventWriter
            XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream("tweets.xml"));
            // create an EventFactory
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            // create and write Start Tag
            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);

            for (Tweet tweet : tweets) {		
	            // create config open tag
	            StartElement startElement = eventFactory.createStartElement("",
	                            "", "tweet");
	            eventWriter.add(startElement);
	            eventWriter.add(end);
	            // Write the different nodes
	            createNode(eventWriter, "id", tweet.getId() + "");
	            createNode(eventWriter, "author", tweet.getAuthor());
	            createNode(eventWriter, "content", tweet.getContent());
	            createNode(eventWriter, "date", tweet.getDate());
	
	            eventWriter.add(eventFactory.createEndElement("", "", "tweet"));
	            eventWriter.add(end);
	            eventWriter.add(eventFactory.createEndDocument());
            
    		}
            eventWriter.close();
    }

    private static void createNode(XMLEventWriter eventWriter, String name,
                    String value) throws XMLStreamException {

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            XMLEvent tab = eventFactory.createDTD("\t");
            // create Start node
            StartElement sElement = eventFactory.createStartElement("", "", name);
            eventWriter.add(tab);
            eventWriter.add(sElement);
            // create Content
            Characters characters = eventFactory.createCharacters(value);
            eventWriter.add(characters);
            // create End node
            EndElement eElement = eventFactory.createEndElement("", "", name);
            eventWriter.add(eElement);
            eventWriter.add(end);

    }
}
