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
        largeInputSecond = new HashSet<>();
        largeInputThird = new HashSet<>();
        largeInputFourth = new HashSet<>();
        
        responses.add("Sorry about that. We are looking what could have caused the problem");
        responses.add("We are looking what could have generated the error.");
        responses.add("That sounds interesting. Tell me more...");
        responses.add("We are calling a tecnician to solve your problem.");
        responses.add("Is the error called '404'?");
        
        // First HashSet
        String first = "i have an error";                  
        String[] firstSplited = first.split(" ");  
        largeInputFirst = new HashSet<>();
        for (String word : firstSplited){
            largeInputFirst.add(word);
        }
        
        // Second HashSet
        String second = "my computer crashed";                  
        String[] secondSplited = second.split(" ");  
        largeInputSecond = new HashSet<>();
        for (String word : secondSplited){
            largeInputSecond.add(word);
        }
        
        // Third HashSet
        String third = "my screen shows the number 404";                  
        String[] thirdSplited = third.split(" ");  
        largeInputThird = new HashSet<>();
        for (String word : thirdSplited){
            largeInputThird.add(word);
        }
        
        // Fourth HashSet
        String fourth = "my program is really slow";                  
        String[] fourthSplited = fourth.split(" ");  
        largeInputFourth = new HashSet<>();
        for (String word : fourthSplited){
            largeInputFourth.add(word);
        }
        
        possibleResponses.put(largeInputFirst, "Try to restart the computer and our program please");
        possibleResponses.put(largeInputSecond, "Is the screen going red? Try re-installing the software to solve the problem");
        possibleResponses.put(largeInputThird, "Maybe your internet conexion is not as fast as our software needs");
        possibleResponses.put(largeInputFourth, "Do you have more tha 4GB os ram? Our software needs at least 4GB to work.");  
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String returnedString = null;
        /*Iterator<String> userInputs = userInput.iterator();
        while (userInputs.hasNext()){
            String keyWord = userInputs.next();
            if (possibleResponses.containsKey(keyWord)){       
                returnedString = possibleResponses.get(keyWord);
                 * PROBLEMA
                 * si introduces "404 error" te devuelve el valor de la clave error y no el de 404, no se por que.
                 * solo me ha funcionado con esta solucion, las demas no me salian
                  
            }

        }*/

        /*if (possibleResponses.containsKey(userInput.iterator().next())){       
        /*    returnedString = possibleResponses.get(userInput.iterator().next());
        }*/
        if (possibleResponses.containsKey(userInput)){       
            returnedString = possibleResponses.get(userInput);
        }
        else {
            returnedString = responses.get(random.nextInt(responses.size()));
        }

        return returnedString;        
    }
}
