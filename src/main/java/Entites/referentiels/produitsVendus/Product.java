package Entites.referentiels.produitsVendus;

public class Product {

	private String pname;
	private int pid,pqte,sid,psid,ptid;
	private float price;
	
	public Product(int pid,String pname, float price, int pqte, int sid, int psid, int ptid) {
		this.pid = pid;
		this.pname = pname;
		this.price=price;
		this.pqte = pqte;
		this.sid = sid;
		this.psid = psid;
		this.ptid = ptid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPqte() {
		return pqte;
	}

	public void setPqte(int pqte) {
		this.pqte = pqte;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPsid() {
		return psid;
	}

	public void setPsid(int psid) {
		this.psid = psid;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	

	
}
