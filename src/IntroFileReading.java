import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IntroFileReading {
	public static void main(String[] args) {
		String FileString = readFile();
		int numStudents = howManySubs(FileString, "name");
		Student[] studentsList = CreateStudentList(numStudents, FileString);
	}
	static String readFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("File.txt"));
			String line = br.readLine();
			String contents = "";
			while (line!=null) {
				contents+=line;
				line = br.readLine();
			}
			br.close();
			return contents;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ("No such file");
		} catch (IOException e) {
			e.printStackTrace();
			return ("IDK what you did");
		}
	}
	static int howManySubs(String s, String toFind) {
		int count = 0;
		int currIndex = 0;
		while (currIndex!=-1) {
			currIndex = s.indexOf(toFind, currIndex);
			if(currIndex !=-1 ) {
				count++;
				currIndex += toFind.length();
			}
		}
		return count;
	}
	static Student[] CreateStudentList(int numStudents, String list) {
		Student[] students = new Student[numStudents];
		int count = 0;
		int currIndex = 0;
		while (currIndex!=-1) {
			currIndex = list.indexOf("name", currIndex);
			if(currIndex !=-1 ) {
				String tempStr = "";
				for(int i = currIndex+7; i<list.length(); i++) {
					if(list.charAt(i)=='"')
						break;
					tempStr+=list.charAt(i);
				}
				students[count].setName(tempStr);
				//TODO: Add loops for level and location, not just student names
				count++;
				currIndex += "name".length();
			}
		}
		
		for (int i = 0; i < numStudents; i++) {
			String studName = "";
			String studLocation = "";
			int studLvl = 0;
		}
		return students;
	}
}
