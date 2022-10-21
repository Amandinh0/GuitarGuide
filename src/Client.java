import java.util.Scanner;

public class Client {
    static notes user = new notes();

    public static void main(String[] args) {
        startProgram();
        while(goAgain()){
            startProgram();
        }
    }

    public static void startProgram(){
        String inputNote;
        int inputTask;
        System.out.println("The 12 widely used notes are" );
        user.printNaturalNotes();
        inputNote = ScanANote();
        System.out.println("Chose one of the options");
        System.out.println("Find a major scale : Enter 1");
        System.out.println("Find a minor scale : Enter 2");
        System.out.println("Find a major chord : Enter 3");
        System.out.println("Find a minor chord : Enter 4");

        inputTask = ScanATask();
        switch(inputTask){
            case 1:
                user.getMajorNotes(inputNote);
                break;

            case 2:
                user.getMinorNotes(inputNote);
                break;

            case 3:
                user.getMajorChord(inputNote);
                break;

            case 4:
                user.getMinorChord(inputNote);
                break;

            default:
                System.out.println("Error");
                break;
        }
    }

    public static String ScanANote(){
        System.out.println("Pick a note you want a scale or a chord for.");
        System.out.println("Enter a note");
        Scanner input = new Scanner(System.in);
        String note = input.next();
        while(!note.equals("A") && !note.equals("A#") &&!note.equals("B") &&!note.equals("C") &&!note.equals("C#") &&
                !note.equals("D") &&!note.equals("Eb") &&!note.equals("E") &&!note.equals("F") &&!note.equals("F#") &&
                !note.equals("G") &&!note.equals("G#")){
            System.out.println("Please enter a valid note");
            System.out.println("Pick a notes you want a scale or chord for.");
            System.out.println("Enter a note");
            note = input.next();
        }
        return note;
    }

    public static int ScanATask(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you input");
        int task = input.nextInt();
        while(task != 1 && task != 2 && task != 3 && task != 4 ){
            System.out.println("Invalid choice");
            System.out.print("Please enter your choice again:");
            task = input.nextInt();
        }
        return task;
    }

    public static boolean goAgain(){
        System.out.println("Do you want to go again?(y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        while((!(answer.equals("y"))) && (!(answer.equals("n")))){
            System.out.println("Invalid Input");
            System.out.println("Enter again.");
            System.out.println("Do you want to go again?(y/n)");
            answer = input.next();
        }
        switch(answer){
            case "y":
                return true;

            case "n":
                return false;

        }
        return false;
    }
}
