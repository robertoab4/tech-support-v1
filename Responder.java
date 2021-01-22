import java.util.ArrayList;
import java.util.Random;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */

public class Responder
{
    private Random random;
    private ArrayList<String> responses;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        responses = new ArrayList();
        responses.add("Sorry about that.");
        responses.add("We are looking what could have generated the error.");
        responses.add("That sounds interesting. Tell me more...");
        responses.add("Is the error called '404'?");
        responses.add("We are calling a tecnician to solve your problem.");        
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return responses.get(random.nextInt(responses.size()));
    }
}
