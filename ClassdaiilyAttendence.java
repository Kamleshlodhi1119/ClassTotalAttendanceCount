import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
 //code written by kamlesh lodhi cse
public class  ClassdaiilyAttendence {
    public static void main(String[] args) {
    String name="";
    System.out.println("This code is written by kamlesh lodhi form IMEC sagar");
    List<String> words1 = new ArrayList<>();
    List<String> Result = new ArrayList<>();
    List<Integer> Result2 = new ArrayList<>();
 
    File file1 = new File("C:\\Users\\hp\\Desktop\\Mycode\\StudentsTotal.txt");
     // Enter total  student full name withot space as a text file and give the path of that text file here

    try {
      Scanner scanner = new Scanner(file1);
      
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
         
        String[] lineWords = line.split(" ");
       
        for (String word1 : lineWords) {
          words1.add(word1);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // System.out.println(words1);//print total no of student in the class
    for(int k=0;k<words1.size();k++){
     name =words1.get(k);   
        int Tpresent = 0;
     // Enter the folder location where the all attendance are save and make sure that all textfile contain student full name  is without space ( like kamleshlodhi ) but the next student name seprate by space 
        File folder = new File("C:\\Users\\hp\\Desktop\\Mycode\\java\\Attendences2024");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] words = line.split(" ");
                        for (String word : words) {
                            if (word.equalsIgnoreCase(name)) {
                                Tpresent++;
                            }
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                
            }
        }
         Result.add(name);
        Result2.add(Tpresent);
    }

 
    for (int i = 0; i <Result2.size() - 1; i++) {
        for (int j = 0; j < Result2.size() - i - 1; j++) {
            if (Result2.get(j) < Result2.get(j + 1)) {
                int temp = Result2.get(j);
                Result2.set(j, Result2.get(j + 1));
                Result2.set(j + 1, temp);

                String temp2 = Result.get(j);
                Result.set(j, Result.get(j+1));
                Result.set(j+1, temp2);
            }
        }
    }
    for( int i=0;i<Result.size();i++){
System.out.print(Result.get(i)+" ");
System.out.println(Result2.get(i));}
}

    public ClassdaiilyAttendence() {
    }
}
