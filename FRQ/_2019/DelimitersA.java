package APCSA.FRQ._2019;
/**
 * https://runestone.academy/runestone/books/published/csjava/Unit8-ArrayList/2019delimitersQ3a.html
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.*;
public class DelimitersA
{

    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object were open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings
     */
    public DelimitersA (String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimtersList(String[] tokens)
    {
        /* to be implemented in part a */
    	ArrayList<String> delimtersList = new ArrayList<String>();
    	Stack<String> theStack = new Stack<String>();
    	int currentTokenIndex = 0;
    	int previousTokenIndex = 0;
    			
    	
    	return delimtersList;
    }

    public static void main(String[] args)
    {
    	DelimitersA d1 = new DelimitersA("(", ")");
        String[] tokens = {"(", "x + y", ")", " * 5" };
        ArrayList<String> res1 = d1.getDelimtersList(tokens);
        System.out.println("It should print [(, )] and it prints" + res1);

        DelimitersA d2 = new DelimitersA("<q>", "</q>");
        String[] tokens2 = {"<q>", "yy", "</q>", "zz", "</q>"};
        ArrayList<String> res2 = d2.getDelimtersList(tokens2);
        System.out.println("It should print [<q>, </q>, </q>] and it prints" + res2);


    }
}
