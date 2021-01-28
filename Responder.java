import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
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
    private HashMap<String, String> possibleResponses;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        responses = new ArrayList();
        possibleResponses = new HashMap<>();
        responses.add("Sorry about that. We are looking what could have caused the problem");
        responses.add("We are looking what could have generated the error.");
        responses.add("That sounds interesting. Tell me more...");
        responses.add("We are calling a tecnician to solve your problem.");
        responses.add("Is the error called '404'?");
        
        possibleResponses.put("error", "Try to restart the computer and our program please");
        possibleResponses.put("crash", "Is the screen going red? Try re-installing the software to solve the problem");
        possibleResponses.put("404", "Maybe your internet conexion is not as fast as our software needs");
        possibleResponses.put("slow", "Do you have more tha 4GB os ram? Our software needs at least 4GB to work.");  
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String userInput)
    {
        String returnedString = "";
        if (possibleResponses.containsKey(userInput)){       
            returnedString = possibleResponses.get(userInput);
        }
        else {
            returnedString = responses.get(random.nextInt(responses.size()));
        }
        return returnedString;
    }
}
