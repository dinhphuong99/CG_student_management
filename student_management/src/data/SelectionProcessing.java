package data;

import data.EnterData;
import data.FileHandling;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SelectionProcessing {
    public static void studentRank(String fileName, ArrayList<Student> listSt){
        System.out.println("Student rank");
        for (int i = 0; i < listSt.size(); i++) {
            for (int j = i + 1; j < listSt.size(); j++) {
                if (listSt.get(i).getMediumScore() < listSt.get(j).getMediumScore()) {
                    Collections.swap(listSt, i, j);
                }
            }
        }
        FileHandling.saveFile(fileName,listSt);
        System.out.println("ID\tName\t\t Score 1\tScore 2\tScore 3\tScore 4\tMediumScore\n");
        for (Student student : listSt) {
            System.out.println(student.getAllInfo());
        }
    }

    public static void editStudentGrades(String fileName, ArrayList<Student> listSt){
        System.out.println("Edit student grades");
        System.out.println("Enter student ID to edit score: ");
        int checkID = EnterData.enterInteger();
        for (Student student : listSt) {
            if (student.getID() == checkID) {
                int choiceEditSc;
                while (true) {
                    System.out.println("1. Edit first time score");
                    System.out.println("2. Edit second time score");
                    System.out.println("3. Edit third time score");
                    System.out.println("4. Edit forth time score");
                    System.out.println("0. Exit");
                    System.out.println("Old name: " + student.getNameStudent() + "\n"
                            + "Old first score: " + student.getScore1() + "\n"
                            + "Old second score: " + student.getScore2() + "\n"
                            + "Old third score: " + student.getScore3() + "\n"
                            + "Old fourth score: " + student.getScore4() + "\n");
                    System.out.println("Enter your choice: ");
                    choiceEditSc = EnterData.enterInteger();
                    if (choiceEditSc == 0) {
                        student.setMediumScore();
                        FileHandling.saveFile(fileName,listSt);
                        break;
                    }

                    float newScore;
                    switch (choiceEditSc) {
                        case 1 -> {
                            System.out.println("Enter new first score: ");
                            newScore = EnterData.enterScore();
                            student.setScore1(newScore);
                        }
                        case 2 -> {
                            System.out.println("Enter new second score: ");
                            newScore = EnterData.enterScore();
                            student.setScore2(newScore);
                        }
                        case 3 -> {
                            System.out.println("Enter new third score: ");
                            newScore = EnterData.enterScore();
                            student.setScore3(newScore);
                        }
                        case 4 -> {
                            System.out.println("Enter new fourth score: ");
                            newScore = EnterData.enterScore();
                            student.setScore4(newScore);
                        }
                        default -> System.out.println("No choice!");
                    }
                }
            }
        }
    }

    public static void viewTheList(ArrayList<Student> listSt){
        System.out.println("View the list");
        System.out.println("ID\tName\t\t Score 1 | Score 2 | Score 3 | Score 4 | MediumScore\n");
        for (Student student : listSt) {
            System.out.println(student.getAllInfo());
        }
    }

    public static void addStudent(String fileName, ArrayList<Student> listSt){
        String name;
        System.out.println("Add students");
        Student student = new Student();
        int IDNewAdd = -1;
        if (listSt.size() == 0)
            IDNewAdd = 0;
        else {
            for (int i = 0; IDNewAdd == -1; i++) {
                for (Student value : listSt) {
                    if (i != value.getID()) {
                        IDNewAdd = i;
                    }

                    if (i == value.getID()) {
                        IDNewAdd = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(IDNewAdd);
        System.out.println("Add name student: ");
        name = new Scanner(System.in).nextLine();
        listSt.add(0, student);
        listSt.get(0).setID(IDNewAdd);

//                    boolean pattern = Pattern.matches("[^0-9]",name);//".*[0-9]. \\.[{(*+?^$|*]}]"
////                    Matcher matcher = pattern.matcher(name);

//                    while (!(name)) {
//                        System.out.println("Names ivalid");
//                        System.out.println("Re-enter the name: ");
//                        name = new Scanner(System.in).nextLine();
//
        listSt.get(0).setNameStudent(name);
        FileHandling.saveFile(fileName,listSt);
        System.out.println("Successfully added a student");
    }

    public static void editStudentInformation(String fileName, ArrayList<Student> listSt){
        System.out.println("Edit student information");
        System.out.println("Enter student ID: ");
        int checkIdInfo = EnterData.enterInteger();
        for (Student student : listSt) {
            if (student.getID() == checkIdInfo) {
                int choiceEditInfo;
                while (true) {
                    System.out.println("1. Edit Name");
                    System.out.println("0. Exit");
                    System.out.println("Old ID: " + student.getID() + "\n"
                            + "Old name: " + student.getNameStudent() + "\n");

                    System.out.println("Enter your choice: ");
                    choiceEditInfo = EnterData.enterInteger();
                    if (choiceEditInfo == 0) {
                        FileHandling.saveFile(fileName,listSt);
                        break;
                    }

                    switch (choiceEditInfo) {
                        case 1:
                            System.out.println("Enter new name: ");
                            String newName = new Scanner(System.in).next();
                            student.setNameStudent(newName);
                            break;
                        default:
                            System.out.println("No choice!");
                    }
                }
            }
        }
    }

    public static void deleteAStudent(String fileName, ArrayList<Student> listSt){
        System.out.println("Delete a student");
        System.out.println("Enter the ID: ");
        int removeID = EnterData.enterInteger();
        int temp = -1;
        for (int i = 0; i < listSt.size(); i++) {
            if (listSt.get(i).getID() == removeID) {
                temp = i;
                break;
            }
        }
        if (temp == -1) {
            System.out.println("This ID is not available");
        } else
            listSt.remove(temp);
        FileHandling.saveFile(fileName,listSt);
        System.out.println("Remove successfully");
    }

    public static void addStudentGrades(String fileName, ArrayList<Student> listSt){
        System.out.println("Add student grades");
        System.out.println("Enter student ID: ");
        int enterID = EnterData.enterInteger();
        for (Student student : listSt) {
            if (student.getID() == enterID) {
                int choiceAddSc;
                while (true) {
                    System.out.println("1. Add first time score");
                    System.out.println("2. Add second time score");
                    System.out.println("3. Add third time score");
                    System.out.println("4. Add forth time score");
                    System.out.println("0. Exit");
                    System.out.println("Name: " + student.getNameStudent() + "\n");

                    System.out.println("Enter your choice: ");
                    choiceAddSc = EnterData.enterInteger();
                    if (choiceAddSc == 0) {
                        student.setMediumScore();
                        FileHandling.saveFile(fileName,listSt);
                        break;
                    }

                    float newScore;
                    switch (choiceAddSc) {
                        case 1 -> {
                            System.out.println("Enter first score: ");
                            newScore = EnterData.enterScore();
                            student.setScore1(newScore);
                        }
                        case 2 -> {
                            System.out.println("Enter second score: ");
                            newScore = EnterData.enterScore();
                            student.setScore2(newScore);
                        }
                        case 3 -> {
                            System.out.println("Enter third score: ");
                            newScore = EnterData.enterScore();
                            student.setScore3(newScore);
                        }
                        case 4 -> {
                            System.out.println("Enter fourth score: ");
                            newScore = EnterData.enterScore();
                            student.setScore4(newScore);
                        }
                        default -> System.out.println("No choice!");
                    }
                }
            }
        }
    }
}
