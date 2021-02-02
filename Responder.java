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
        HashSet<String>largeInputFirst = keyCreator("i have an error");
        // Second HashSet                 
        HashSet<String>largeInputSecond = keyCreator("my computer crashed"); 
        // Third HashSet 
        HashSet<String> largeInputThird = keyCreator("my screen shows the error 404");
        // Fourth HashSet  
        HashSet<String> largeInputFourth = keyCreator("my program is really slow");
        
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
        //ANTIGUO QUE FUNCIONABA CON PALABRAS SUELTAS
        
        /*Iterator<String> userInputs = userInput.iterator();
        while (userInputs.hasNext()){
            String keyWord = userInputs.next();
            if (possibleResponses.containsKey(keyWord)){       
                returnedString = possibleResponses.get(keyWord);
                 // PROBLEMA
                 // si introduces "404 error" te devuelve el valor de la clave error y no el de 404, no se por que.
                 // solo me ha funcionado con esta solucion, las demas no me salian                  
            }
        }*/

   
        if (possibleResponses.containsKey(userInput)){       
            returnedString = possibleResponses.get(userInput);
        }
        else {
            returnedString = responses.get(random.nextInt(responses.size()));
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
