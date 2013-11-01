import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Test {
	public ArrayList<DataStuff> testsubjects=new ArrayList<DataStuff>();
	public HashMap<Integer,String> dictionary=new HashMap<Integer, String>();
	public void run(){
		getDictionary();
		getTestSubjects();
		runTest();
		getOutput();

	}

	private void runTest() {
		for(DataStuff d: testsubjects){
			FileReader file=null;
			try {
				file = new FileReader(d.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Scanner reader=new Scanner(file);
			String next;
			while(reader.hasNext()){
				next=reader.next();
				DynamicPart(next,0,next.length(),d);
			}
		}
	}

	

	private void DynamicPart(String next, int start, int end, DataStuff d) {
		if(end==start||start<0){
			d.canwork=false;
			return;
		}
		int key=next.substring(start,end).hashCode();
		if(dictionary.containsKey(key)){
			start+=next.length();
			return;
		}else{
			if(start!=0){
				DynamicPart(next,start-1,end,d);
			}	
			DynamicPart(next,start,end-1,d);
		}
		
		
		
		
	}

	private void getOutput() {
		for(DataStuff d: testsubjects){
			System.out.print(d.name);
			if(d.canwork){
				System.out.println(" is a corrupted text file that can be made into words");
			}else{
				System.out.println(" is not a corrupted text file and can not be made into words");
			}
		}

	}

	public void getTestSubjects() {
		FileReader file=null;
		try {
			file = new FileReader("src/testsubjects.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner reader=new Scanner(file);
		while(reader.hasNext()){
			testsubjects.add(new DataStuff(reader.nextLine()));
		}

	}


	private void getDictionary() {
		FileReader file=null;
		try {
			file = new FileReader("src/Dictionary.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner reader=new Scanner(file);
		String word;
		int key;
		while(reader.hasNext()){
			word=reader.next();
			key = word.hashCode();
			dictionary.put(key,word);
		}

	}
}
