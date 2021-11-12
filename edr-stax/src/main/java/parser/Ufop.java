package parser;

public class Ufop {

	private int id;

    private String name;

    private String shortName;

    private String opf;

    private String edrpou;

    private String address;

    private String stan;

    private String foundingDocumentNum;
    
    private String contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getOpf() {
		return opf;
	}

	public void setOpf(String opf) {
		this.opf = opf;
	}

	public String getEdrpou() {
		return edrpou;
	}

	public void setEdrpou(String edrpou) {
		this.edrpou = edrpou;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getFoundingDocumentNum() {
		return foundingDocumentNum;
	}

	public void setFoundingDocumentNum(String foundingDocumentNum) {
		this.foundingDocumentNum = foundingDocumentNum;
	}
	
	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Ufop [id=" + id + ", name=" + name + ", shortName=" + shortName + ", opf=" + opf + ", edrpou=" + edrpou
				+ ", address=" + address + ", stan=" + stan + ", foundingDocumentNum=" + foundingDocumentNum
				+ ", contacts=" + contacts + "]";
	}

}
