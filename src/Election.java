import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class ElectionData {
    LinkedList<String> ballot = new LinkedList<String>();
    // LinkedList<String> votes = new LinkedList<String>();
    HashMap<String, Integer> firstChoice = new HashMap<>();
    HashMap<String, Integer> secondChoice = new HashMap<>();
    HashMap<String, Integer> thirdChoice = new HashMap<>();


    Scanner keyboard = new Scanner(System.in);

    ElectionData() {
        this.ballot.add("Gompei");
        this.ballot.add("Husky");
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.println(s);
        }
    }
    public void processVotes(String one, String two, String three)
    {

        firstChoice.put(one, firstChoice.get(one) +1);
        secondChoice.put(two , secondChoice.get(two) +1);
        thirdChoice.put(three, thirdChoice.get(three) +1);
    }
    public void addCandidate(String cand) throws CandidateExistsException{
        if(!ballot.contains(cand)){
            ballot.add(cand);
            firstChoice.put(cand, 0);
            secondChoice.put(cand , 0);
            thirdChoice.put(cand, 0);
        }
        else
            throw new CandidateExistsException(cand);
    }
    public void screen() {
        this.printBallot();
        System.out.println("Who is your first choice?");
        String candidate = keyboard.next();
        firstChoice.put(candidate,0);
        System.out.println("Who is your second choice?");
        String candidate2 = keyboard.next();
        secondChoice.put(candidate2,0);
        System.out.println("Who is your third choice?");
        String candidate3 = keyboard.next();
        thirdChoice.put(candidate3,0);
        System.out.printf("You voted for \n    1. %s \n    2. %s \n    3. %s\n", candidate, candidate2, candidate3);
    }

    public int countVotes(String forcand) {
        /*int numvotes = 0;
        for (String s : votes) {
            if (s.equals(forcand))
                numvotes = numvotes+1;
        }
        return numvotes;*/
        return 1;
    }

    public static void main(String[] args) {
        ElectionData el = new ElectionData();
        el.screen();

    }
}