import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class List {
    static ArrayList<Student> listSt = new ArrayList();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createFile("listStudent.txt");
        readFile("listStudent.txt");

        int choice = -1;

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

            choice = enterInteger();
//            String choiceStr = "" + choice;
//
//            while (!checkNumberInterger(choiceStr)){
//                System.out.println("Enter number integer");
//                choice = scanner.nextInt();
//                choiceStr = "" + choice;
//            }

            switch (choice) {
                case 1 -> {
                    System.out.println("View the list");
                    System.out.println("ID\tName\t\t Score 1 | Score 2 | Score 3 | Score 4 | MediumScore\n");
                    for (Student student : listSt) {
                        System.out.println(student.getAllInfo());
                    }
                }
                case 2 -> {
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
//                    }
                    listSt.get(0).setNameStudent(name);
                    saveFile("listStudent.txt");
                    System.out.println("Successfully added a student");
                }
                case 3 -> {
                    System.out.println("Edit student information");
                    System.out.println("Enter student ID: ");
                    int checkIdInfo = enterInteger();
                    for (Student student : listSt) {
                        if (student.getID() == checkIdInfo) {
                            int choiceEditInfo = -1;
                            while (true) {
                                System.out.println("1. Edit Name");
                                System.out.println("0. Exit");
                                System.out.println("Old ID: " + student.getID() + "\n"
                                        + "Old name: " + student.getNameStudent() + "\n");

                                System.out.println("Enter your choice: ");
                                choiceEditInfo = enterInteger();
                                if (choiceEditInfo == 0) {
                                    saveFile("listStudent.txt");
                                    break;
                                }

                                switch (choiceEditInfo) {
                                    case 1:
                                        System.out.println("Enter new name: ");
                                        String newName = scanner.next();
                                        student.setNameStudent(newName);
                                        break;
                                    default:
                                        System.out.println("No choice!");
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Delete a student");
                    System.out.println("Enter the ID: ");
                    int removeID = enterInteger();
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
                    saveFile("listStudent.txt");
                    System.out.println("Remove successfully");
                }
                case 5 -> {
                    System.out.println("Add student grades");
                    System.out.println("Enter student ID: ");
                    int enterID = enterInteger();
                    for (Student student : listSt) {
                        if (student.getID() == enterID) {
                            int choiceAddSc = -1;
                            while (true) {
                                System.out.println("1. Add first time score");
                                System.out.println("2. Add second time score");
                                System.out.println("3. Add third time score");
                                System.out.println("4. Add forth time score");
                                System.out.println("0. Exit");
                                System.out.println("Name: " + student.getNameStudent() + "\n");

                                System.out.println("Enter your choice: ");
                                choiceAddSc = enterInteger();
                                if (choiceAddSc == 0) {
                                    student.setMediumScore();
                                    saveFile("listStudent.txt");
                                    break;
                                }

                                float newScore;
                                switch (choiceAddSc) {
                                    case 1 -> {
                                        System.out.println("Enter first score: ");
                                        newScore = enterFloat();
                                        student.setScore1(newScore);
                                    }
                                    case 2 -> {
                                        System.out.println("Enter second score: ");
                                        newScore = enterFloat();
                                        student.setScore2(newScore);
                                    }
                                    case 3 -> {
                                        System.out.println("Enter third score: ");
                                        newScore = enterFloat();
                                        student.setScore3(newScore);
                                    }
                                    case 4 -> {
                                        System.out.println("Enter fourth score: ");
                                        newScore = enterFloat();
                                        student.setScore4(newScore);
                                    }
                                    default -> System.out.println("No choice!");
                                }
                            }
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Edit student grades");
                    System.out.println("Enter student ID to edit score: ");
                    int checkID = enterInteger();
                    for (Student student : listSt) {
                        if (student.getID() == checkID) {
                            int choiceEditSc = -1;
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
                                choiceEditSc = enterInteger();
                                if (choiceEditSc == 0) {
                                    student.setMediumScore();
                                    saveFile("listStudent.txt");
                                    break;
                                }

                                float newScore;
                                switch (choiceEditSc) {
                                    case 1 -> {
                                        System.out.println("Enter new first score: ");
                                        newScore = enterFloat();
                                        student.setScore1(newScore);
                                    }
                                    case 2 -> {
                                        System.out.println("Enter new second score: ");
                                        newScore = enterFloat();
                                        student.setScore2(newScore);
                                    }
                                    case 3 -> {
                                        System.out.println("Enter new third score: ");
                                        newScore = enterFloat();
                                        student.setScore3(newScore);
                                    }
                                    case 4 -> {
                                        System.out.println("Enter new fourth score: ");
                                        newScore = enterFloat();
                                        student.setScore4(newScore);
                                    }
                                    default -> System.out.println("No choice!");
                                }
                            }
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Student rank");
                    for (int i = 0; i < listSt.size(); i++) {
                        for (int j = i + 1; j < listSt.size(); j++) {
                            if (listSt.get(i).getMediumScore() < listSt.get(j).getMediumScore()) {
                                Collections.swap(listSt, i, j);
                            }
                        }
                    }
                    saveFile("listStudent.txt");
                    System.out.println("ID\tName\t\t Score 1\tScore 2\tScore 3\tScore 4\tMediumScore\n");
                    for (Student student : listSt) {
                        System.out.println(student.getAllInfo());
                    }
                }
                case 0 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
        }
    }

    public static void saveFile(String fileName){
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

    public static void readFile(String fileName){
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
    }

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

    public static int enterInteger(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("The input value must be an integer!");
            choice = enterInteger();
        }
        return choice;
    }

    public static float enterFloat(){
        float choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("The input value must be a real number!");
            choice = enterFloat();
        }
        return choice;
    }
}
