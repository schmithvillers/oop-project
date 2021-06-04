
public class Signin {
private String cid,psw,fname,lname,line1,line2,city,state,pin;
public Signin()
{
	super();
}
public Signin(String cid, String psw)
{
	this.cid=cid;
	this.psw=psw;
	
}
public Signin (String fname,String lname,String line1,String line2, String city, String state, String pin,String cid,String psw) {

	this.fname=fname;
	this.lname=lname;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
	this.state = state;
	this.pin=pin;
	this.cid=cid;
	this.psw=psw;
	}
public Signin (String ID,String line1,String line2, String city, String state, String pin) {
	this.cid=ID;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
	this.state = state;
	this.pin=pin;
	}
public String getCid()
{
	return cid;
}
public void setCid(String cid)
{
	this.cid=cid;
}
public String getPsw()
{
	return psw;
}
public void setPsw(String psw)
{
	this.psw=psw;
}
public String getPin()
{
	return pin;
}
public void setPin(String pin)
{
	this.pin=pin;
}
public String getLine1() {
	return line1;
}

public void setLine1(String line1) {
	this.line1=line1;
}

public String getLine2() {
	return line2;
}

public void setLine2(String line2) {
	this.line2=line2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city=city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state=state;
}
public void setFname(String fname)
{
	this.fname=fname;
}
public String getFname()
{
	return fname;
}
public void setLname(String lname)
{
	this.lname=lname;
}
public String getLname()
{
	return lname; 
}
}