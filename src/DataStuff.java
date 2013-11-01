
public class DataStuff {
public String name;
public String file;
public boolean canwork;
	DataStuff(String s){
		name=s;
		file="src/subjects/"+s+".txt";
		canwork=true;
	}
}
