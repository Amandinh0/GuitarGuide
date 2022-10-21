import java.util.Arrays;

public class notes {

    final private String Notes[] = {"A","A#", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#"};
    private int note;
    String[] currentScale = new String [8]; // save the most recent scale, helpful for chords
    public notes(){
        //empty
    }

    //get methods
    public void getMajorNotes(String a){
        setMajorNotes(a);
        System.out.print("The " + a + " major notes are: ");
        printTheScale(currentScale);
    }

    public void getMinorNotes(String a){
        setMinorNotes(a);
        System.out.print("The " + a + " minor notes are: ");
        printTheScale(currentScale);
    }
    public void getMajorChord(String n){
        setMajorNotes(n);
        System.out.print("The " +n+ " major chord notes are: ");
        System.out.println(currentScale[0] + ", "+ currentScale[2]+ ", "+ currentScale[4]);
    }

    public void getMinorChord(String n){
        setMinorNotes(n);
        System.out.print("The " +n+ " minor chord notes are: ");
        System.out.println(currentScale[0] + ", "+ currentScale[2]+ ", "+ currentScale[4]);
    }

    //setter methods
    //setMajorNotes(a) sets the currentScale[] to a major scale of 'a'
    public void setMajorNotes(String a){
        note = findIndexof(a);
        currentScale[0]= Notes[note];
        currentScale[currentScale.length-1] = Notes[note];
        for (int i = 1; i <= 6; i++) {
            if (i != 3) {
                currentScale[i] = wholestep(note);
            } else {
                currentScale[i] = halfStep(note);
            }
        }
    }
    //setMinorNotes(a) sets the currentScale[] to a minor scale of 'a'
    public void setMinorNotes(String a){
        note = findIndexof(a);
        currentScale[0]= Notes[note];
        currentScale[currentScale.length-1] = Notes[note];
        for(int i = 1; i <= 6;i++){
            if(i!=2 && i!=5){
                currentScale[i] = wholestep(note);
            }
            else{
                currentScale[i] = halfStep(note);
            }
        }
    }
    public int findIndexof(String a){
        int start = 0;
        for(int i = 0;i < Notes.length; i++){
            if(a.equals(Notes[i])){
                start = i;
            }
        }
        return start;
    }

    //wholestep() returns a note 2 notes from the current and wraps around
    // the end of the notes of array
    public String wholestep(int n){
        int starting_note = n;
        if(starting_note == 10) {
            note = 0;
            return Notes[0];
        }
        else if(starting_note == 11) {
            note = 1;
            return Notes[1];
        }
        else {
            note += 2;
            return Notes[n + 2];
        }

    }
     // halfstep() returns a note 1 note from a current and
    // wraps around the end of notes of array
    public  String halfStep(int n){
        int starting_note = n;
        if(starting_note == 11) {
            note = 0;
            return Notes[0];
        }
        else{
            note += 1;
            return Notes[starting_note + 1];
        }

    }

    public void printTheScale(String [] a) {
        System.out.print(a[0]);
        for(int i = 1; i < a.length; i++){
            System.out.print(", " + a[i]);
        }
        System.out.println();
    }

    public void printNaturalNotes(){
        System.out.print(Notes[0]);
        for(int i = 1; i < Notes.length; i++){
            System.out.print(", "+Notes[i]);
        }
        System.out.println();
    }
}
