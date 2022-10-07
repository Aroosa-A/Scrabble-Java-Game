# Scrabble Challenge - this time in Java!

* Never played Scrabble game so to understand the logic of extended criteria I got help from previous cohort engineer Waqas Parvaiz's pull request
````
Because there was no test for checking string is not alphabets so didn't check for it
 but could check it inside checkArray method.
 addAllScores() method is adding total score of all alphabets
 extraScoreRecorderForWords() method is checking if inpuString is doubleWord it makes input string 2 times of its total score
 if inpuString is tripleWord it will make it three times of total original score.
 extraScoreRecorderForLetters() checks if inputString have doubleLetter character it calls
 getDoubleLetterScore() method which evatually calculate extra score by adding the
 character value one time extra.
 and if word is tripleWord it will call getTripleLetterScore() method which will 
 add doubles value(two times of initial value of letter) in total score
````