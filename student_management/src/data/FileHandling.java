package data;

import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    public static void createFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList readFile(String fileName){
        ArrayList <Student> listSt = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words=data.split(",");

                Student student = new Student();
                for (int i = 0; i < words.length; i++) {
                    switch (i) {
                        case 0 -> student.setID(Integer.parseInt(words[0]));
                        case 1 -> student.setNameStudent(words[1]);
                        case 2 -> student.setScore1(Float.parseFloat(words[2]));
                        case 3 -> student.setScore2(Float.parseFloat(words[3]));
                        case 4 -> student.setScore3(Float.parseFloat(words[4]));
                        case 5 -> student.setScore4(Float.parseFloat(words[5]));
                    }
                }
                student.setMediumScore();
                listSt.add(student);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return listSt;
    }

    public static void saveFile(String fileName, ArrayList<Student> listSt){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            StringBuilder strTemp = new StringBuilder();
            for (Student student : listSt) {
                strTemp.append(student.getID()).
                        append(",").append(student.getNameStudent()).
                        append(",").append(student.getScore1()).
                        append(",").append(student.getScore2()).
                        append(",").append(student.getScore3()).
                        append(",").append(student.getScore1()).
                        append("\n");
            }
            myWriter.write(strTemp.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
