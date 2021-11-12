package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class UfopParser {

	private Ufop ufop;

	private int eventType;

	private boolean isExecutivePower;

	private boolean isActivityKinds;

	private boolean isBranch;

	private boolean isPredessor;

	private boolean isAssignee;

	public void parse(String fileName) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
			eventType = reader.getEventType();
			while (reader.hasNext()) {
				ufopHandler(reader);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	private void ufopHandler(XMLStreamReader reader) throws XMLStreamException {
		eventType = reader.next();

		if (eventType == XMLEvent.START_ELEMENT) {
			if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.SUBJECT.name())) {
				ufop = new Ufop();
			} else if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.BRANCHES.name())) {
				isBranch = true;
			} else if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.EXECUTIVE_POWER.name())) {
				isExecutivePower = true;
			} else if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.ACTIVITY_KINDS.name())) {
				isActivityKinds = true;
			} else if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.PREDECESSORS.name())) {
				isPredessor = true;
			}else if (reader.getName().getLocalPart().equalsIgnoreCase(UfopNmaeTag.ASSIGNEES.name())) {
				isAssignee = true;
			}
			startElement(reader.getName().getLocalPart(), reader);
		} else if (eventType == XMLEvent.END_ELEMENT) {
			endElemnt(reader.getName().getLocalPart());
		}

	}

	private void startElement(String qName, XMLStreamReader reader) throws XMLStreamException {
		if (!isAssignee && !isExecutivePower && !isBranch && !isPredessor && !isActivityKinds
				&& qName.equalsIgnoreCase(UfopNmaeTag.NAME.name())) {
			ufop.setName(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.SHORT_NAME.toString())) {
			ufop.setShortName(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.OPF.name())) {
			ufop.setOpf(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.EDRPOU.name())) {
			ufop.setEdrpou(reader.getElementText());
		} else if (!isBranch && qName.equalsIgnoreCase(UfopNmaeTag.ADDRESS.name())) {
			ufop.setAddress(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.STAN.name())) {
			ufop.setStan(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.FOUNDING_DOCUMENT_NUM.name())) {
			ufop.setFoundingDocumentNum(reader.getElementText());
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.CONTACTS.name())) {
			ufop.setContacts(reader.getElementText());
		}
	}

	private void endElemnt(String qName) {
		if (qName.equalsIgnoreCase(UfopNmaeTag.SUBJECT.name())) {
			System.out.println(ufop);
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.BRANCHES.name())) {
			isBranch = false;
		}else if (qName.equalsIgnoreCase(UfopNmaeTag.EXECUTIVE_POWER.name())) {
        	isExecutivePower = false;
    	}else if (qName.equalsIgnoreCase(UfopNmaeTag.ACTIVITY_KINDS.name())) {
			isActivityKinds = false;
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.PREDECESSORS.name())) {
			isPredessor = false;
		} else if (qName.equalsIgnoreCase(UfopNmaeTag.ASSIGNEES.name())) {
			isAssignee = false;
		}
	}

}
