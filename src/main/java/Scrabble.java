import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private String inputArray;
    private char[] stringArray;
    private Character[] doubleLetter;
    private Character[] tripleLetter;
    private Boolean yesDoubleLetter = false;
    private int doubleLetterScore = 2;
    private Boolean yesTripleLetter = false;
    private int tripleLetterScore = 3;
    public Scrabble(String inputString) {
        this.inputArray = inputString;
    }
    public Scrabble(String inputString,Character[] doubleL,Character[] tripleL,Boolean doubleWord,Boolean tripleWord) {
        this.inputArray = inputString;
        this.doubleLetter = doubleL;
        this.tripleLetter = tripleL;
        this.yesDoubleLetter = doubleWord;
        this.yesTripleLetter = tripleWord;
    }
    public int score(){
        if(checkArray())
            return 0;
        return scoreRecorder();
    }
    public boolean checkArray(){
        if(this.inputArray == null)
            return true;
        return this.inputArray.equals("");
    }
    public int scoreRecorder(){
        int finalScore=0;
        finalScore = addAllScores();
        finalScore *= extraScoreRecorderForWords();
        finalScore += extraScoreRecorderForLetters();
        return finalScore;
    }
    public int addAllScores(){
        Map<Character,Integer> map = mapHolder();
        int score=0;
        this.stringArray=inputArray.toUpperCase().toCharArray();
        for(char character:this.stringArray){score += map.get(character);}
        return score;
    }
    public int extraScoreRecorderForWords(){
        if(this.yesDoubleLetter)
            return doubleLetterScore;
        if(this.yesTripleLetter)
                return tripleLetterScore;
        return 1;
    }
    public int extraScoreRecorderForLetters(){
        int finalExtraScore=0;
        if(this.doubleLetter != null){finalExtraScore+=getDoubleLetterScore();}
        if(this.tripleLetter != null){finalExtraScore+=getTripleLetterScore();}
        return finalExtraScore;
    }
    public int getDoubleLetterScore(){
        Map<Character,Integer> map = mapHolder();
        int doubleExtraScore = 0;
        for(Character eachChar:doubleLetter)
             doubleExtraScore+= map.get(eachChar);
        return doubleExtraScore;
    }
    public int getTripleLetterScore(){
        Map<Character,Integer> map = mapHolder();
        int tripleExtraScore = 0;
        for(Character eachChar:tripleLetter)
            tripleExtraScore +=2* map.get(eachChar);
        return tripleExtraScore;
    }
    public Map<Character,Integer> mapHolder(){
        Map<Character,Integer> alphabetsMap = new HashMap<Character,Integer>();
        alphabetsMap.put('A',1);    alphabetsMap.put('E',1);    alphabetsMap.put('I',1);
        alphabetsMap.put('O',1);    alphabetsMap.put('U',1);    alphabetsMap.put('L',1);
        alphabetsMap.put('N',1);    alphabetsMap.put('R',1);    alphabetsMap.put('S',1);
        alphabetsMap.put('T',1);    alphabetsMap.put('D',2);    alphabetsMap.put('G',2);
        alphabetsMap.put('B',3);    alphabetsMap.put('C',3);    alphabetsMap.put('M',3);
        alphabetsMap.put('P',3);    alphabetsMap.put('F',4);    alphabetsMap.put('H',4);
        alphabetsMap.put('V',4);    alphabetsMap.put('W',4);    alphabetsMap.put('Y',4);
        alphabetsMap.put('K',5);    alphabetsMap.put('J',8);    alphabetsMap.put('X',8);
        alphabetsMap.put('Q',10);   alphabetsMap.put('Z',10);
        return alphabetsMap;
    }
}
