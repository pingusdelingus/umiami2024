package lab13;

public class WordFisherTester {
	
	public static void main(String[] args) {
		
		WordFisher alice = new WordFisher("texts/carroll-alice.txt", "stopwords.txt");
		
		WordFisher moby = new WordFisher("texts/moby-dick.txt", "stopwords.txt");

		//*****getWordCount() Tests*****
		//The total number of words in Moby Dick is 218,619. Alice has 27,336.
		//The word count may be off by 1 depending on your Operating System. You will receive full credit if you are off by 1 word.
		

		//*****getNumUniqueWords() Tests*****
		//The total number of unique words in Moby Dick is 17,139 and Alice 2,570. 
		//The word count may be off by 1 depending on your Operating System. You will receive full credit if you are off by 1 word.

		//*****getFrequency(String word) Tests*****
		//The word “whale” occurs 1,226 times in Moby Dick! 
		//“handkerchief”  occurs 5 times in Moby Dick 
		//"handkerchief" does not occur in Alice (thus, returns -1).  

		//*****pruneVocabulary() Tests*****
		//After pruning, getWordCount() on Moby Dick returns 110,717 words; Alice  returns 12,241
		//The word count may be off by 1 depending on your Operating System. You will receive full credit if you are off by 1 word. 

		//*****getTopWords(int n) Tests*****
		//When calling getTopWords(10) on the pruned vocabulary of Moby Dick, the  following list is returned: [whale, one, like, upon, man, ship, ahab, ye, sea, old]

		//*****common PopularWords(int n, WordFisher other) Tests*****
		//Calling this method on the pruned Moby Dick with pruned Alice and  n = 20 gives [one, like, would, time]

	}
}
