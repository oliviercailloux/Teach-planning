package teachPlanning;

public class Teaching {
	String name;
	int cm, td, tp, cmtd, grp;
public Teaching(String name, int cm, int td, int tp, int cmtd, int grp) {
	this.name=name;
	this.cm=cm;
	this.td=td;
	this.tp=tp;
	this.cmtd=cmtd;
	this.grp=grp;
	// TODO Auto-generated constructor stub
}
public int getCm() {
	return cm;
}
public int getCmtd() {
	return cmtd;
}
public int getGrp() {
	return grp;
}
public String getName() {
	return name;
}
public int getTd() {
	return td;
}
public int getTp() {
	return tp;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
