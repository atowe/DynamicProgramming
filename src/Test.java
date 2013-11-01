import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	public ArrayList<DataStuff> testsubjects;
	
	
	public void run(){
		getDictionary();
		getTestSubjects();
		runTest();
		getOutput();
		
	}

	private void runTest() {
		
		
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
		
		
	}
}
