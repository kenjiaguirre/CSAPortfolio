public class WordMatch{
    
    String secret;
    
    public WordMatch(String word){
        secret = word;
    }
    
    public int scoreGuess(String guess){
        int count = 0;
        for(int i = 0; i <= (secret.length()-guess.length()); i++){
            if(guess.equals(secret.substring(i,i+guess.length()))){
                count++;
            }
        }
        return count * guess.length() * guess.length();
    }
    
    public String findBetterGuess(String guess1, String guess2){
        
        if(scoreGuess(guess1)>scoreGuess(guess2)){
            return guess1;
        }
        else if(scoreGuess(guess1)<scoreGuess(guess2)){
            return guess2;
        }
        else{
            if(guess1.compareTo(guess2)<0){
                return guess2;
            }
            else{
                return guess1;
            }
        }
    }
    
    public String getSecret(){
        return secret;
    }
    
}
