package main;

import data.EnterData;
import data.FileHandling;
import data.SelectionProcessing;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class List{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<Student> listSt;
        String fileName = "D:\\Intellij\\CodeGymBT\\New folder\\" +
                "CG_student_management\\student_management\\src\\data\\file\\listStudent.txt";
        FileHandling.createFile(fileName);
        listSt = FileHandling.readFile(fileName);
        int choice;

        while (true) {
            System.out.println("Menu");
            System.out.println("1. View the list");
            System.out.println("2. Add students");
            System.out.println("3. Edit student information");
            System.out.println("4. Delete a student");
            System.out.println("5. Enter student scores");
            System.out.println("6. Edit student grades");
            System.out.println("7. Student rank");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            choice = EnterData.enterInteger();
//            String choiceStr = "" + choice;
//
//            while (!checkNumberInterger(choiceStr)){
//                System.out.println("Enter number integer");
//                choice = scanner.nextInt();
//                choiceStr = "" + choice;
//            }

            switch (choice) {
                case 1 -> SelectionProcessing.viewTheList(listSt);
                case 2 -> SelectionProcessing.addStudent(fileName, listSt);
                case 3 -> SelectionProcessing.editStudentInformation(fileName, listSt);
                case 4 -> SelectionProcessing.deleteAStudent(fileName, listSt);
                case 5 -> SelectionProcessing.addStudentGrades(fileName, listSt);
                case 6 -> SelectionProcessing.editStudentGrades(fileName,listSt);
                case 7 -> SelectionProcessing.studentRank(fileName,listSt);
                case 0 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
        }
    }
//    public static boolean checkName(String name) {
//        String regex = "^([a-zA-Z]+(\\s)[a-zA-Z]+)+$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(name);
//        return matcher.matches();
//    }

//    public static  <T extends Object> String checkType(T object) {
//        if (object instanceof Integer)
//            return "Integer";
//        else if(object instanceof Double)
//            return "Double";
//        else if(object instanceof Float)
//            return "Float";
//        else if(object instanceof List)
//            return "List";
//
//        return "Continue";
//    }
}
