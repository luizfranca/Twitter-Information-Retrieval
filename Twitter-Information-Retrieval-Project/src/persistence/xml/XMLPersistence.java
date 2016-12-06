package persistence.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;

import data.Tweet;

/*
 * source: http://www.vogella.com/tutorials/JavaXML/article.html#xml_overview
 * 
 */

public class XMLPersistence {

	static final String ID = "id";
	static final String AUTHOR = "author";
	static final String CONTENT = "content";
	static final String DATE = "date";
	static final String TWEET = "tweet";

	public static ArrayList<Tweet> readTweet() {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream("tweets.xml");
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Tweet tweet = null;
//			System.out.println(eventReader.nextEvent().toString());
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
//				System.out.println(event.toString());
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == (TWEET)) {
						tweet = new Tweet();
						// We read the attributes from this tag and add the date
						// attribute to our object

					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart().equals(AUTHOR)) {
							event = eventReader.nextEvent();
							tweet.setAuthor(event.asCharacters().getData());
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart().equals(CONTENT)) {
						event = eventReader.nextEvent();
						tweet.setContent(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(DATE)) {
						event = eventReader.nextEvent();
						tweet.setDate(event.asCharacters().getData());
						continue;
					}

				} 
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (TWEET)) {
						
						tweets.add(tweet);
					}
					
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		return tweets;
	}

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
		
		eventWriter.add(end);
		StartElement startDoc = eventFactory.createStartElement("", "", "tweets");
		eventWriter.add(startDoc);
		eventWriter.add(end);
		for (Tweet tweet : tweets) {
			// create config open tag
			StartElement startElement = eventFactory.createStartElement("", "", "tweet");
			eventWriter.add(startElement);
			eventWriter.add(end);
			// Write the different nodes
			createNode(eventWriter, "id", tweet.getId() + "");
			createNode(eventWriter, "author", tweet.getAuthor());
			createNode(eventWriter, "content", tweet.getContent());
			createNode(eventWriter, "date", tweet.getDate());

			eventWriter.add(eventFactory.createEndElement("", "", "tweet"));
			eventWriter.add(end);
			

		}
//		StartElement endDoc = eventFactory.createStartElement("", "", "tweets");
//		eventWriter.add(endDoc);
		
		eventWriter.add(eventFactory.createEndDocument());
		
		eventWriter.close();
	}

	private static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

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
