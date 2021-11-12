import parser.UfopParser;

public class Main {

	public static void main(String[] args) {
		String fileName = "d:\\17.1-EX_XML_EDR_UO_FULL_25.10.2021.xml";
        UfopParser ufopParser = new UfopParser();
        ufopParser.parse(fileName);
	}

}
