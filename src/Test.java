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
				DynamicPart(next,0,d);
			}
		}
	}

	

	private void DynamicPart(String next, int start, DataStuff d) {
		if(next.length()==0){
			d.canwork=false;
			return;
		}
		Integer key=7;
		for (int i=0; i < next.length(); i++) {
		    key = key*31+next.charAt(i);
		};
		
		if(dictionary.containsKey(key)){
			start+=next.length()-1;
			return;
		}else{
			DynamicPart(next.substring(0,next.length()-2), start, d);
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
		while(reader.hasNext()){
			word=reader.next();
			Integer key=7;
			for (int i=0; i < word.length(); i++) {
			    key = key*31+word.charAt(i);
			};
			dictionary.put(key,word);
		}

	}
}
