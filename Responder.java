import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
    private HashMap<HashSet<String>, String> possibleResponses;
    private HashSet<String> largeInputFirst;
    private HashSet<String> largeInputSecond;
    private HashSet<String> largeInputThird;
    private HashSet<String> largeInputFourth;
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
        
        // First HashSet
        largeInputFirst = keyCreator("i have an error");
        // Second HashSet                 
        largeInputSecond = keyCreator("my computer crashed"); 
        // Third HashSet 
        largeInputThird = keyCreator("my screen shows the error 404");
        // Fourth HashSet  
        largeInputFourth = keyCreator("my program is really slow");
        
        possibleResponses.put(largeInputFirst, "Try to restart the computer and our program please");
        possibleResponses.put(largeInputSecond, "Is the screen going red? Try re-installing the software to solve the problem");
        possibleResponses.put(largeInputThird, "Maybe your internet conexion is not as fast as our software needs");
        possibleResponses.put(largeInputFourth, "Do you have more tha 4GB of ram? Our software needs at least 4GB to work.");  
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String returnedString = null;
                
        int counter = 0;
        int whatToReturn = 0;
        Iterator<HashSet<String>> possibleResponsesIterator = possibleResponses.keySet().iterator();
        while (possibleResponsesIterator.hasNext()){
            HashSet<String> possibleResponsesHashSet = possibleResponsesIterator.next();
            for (String key : possibleResponsesHashSet){
                if(userInput.contains(key)){                   
                    counter++;                                   
                }  
            }
            if (counter > whatToReturn){
                returnedString = possibleResponses.get(possibleResponsesHashSet);
                whatToReturn = counter;
            }              
            else if(whatToReturn == 0) {
                returnedString = responses.get(random.nextInt(responses.size()));
            }
            counter = 0;
        }        
        return returnedString;        
    }
    
    private HashSet<String> keyCreator(String fullInput){                   
        String[] fullInputSplited = fullInput.split(" ");  
        HashSet<String> fullInputToHashSet = new HashSet<>();
        for (String word : fullInputSplited){
            fullInputToHashSet.add(word);
        }
        return fullInputToHashSet;
    }
}
