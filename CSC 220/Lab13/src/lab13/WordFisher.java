package lab13;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
//hm.containskey , hm.get, hm.put, hm.put , hm.remove, hm.size

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The WordFisher class analyzes word frequency in a text file, allowing for 
 * operations such as pruning stopwords and finding common popular words.
 */
public class WordFisher {

    /**
     * A map containing words as keys and their occurrence frequencies as values.
     */
    public HashMap<String, Integer> vocabulary;

    /**
     * A list of stopwords to exclude from word frequency analysis.
     */
    public List<String> stopwords;

    /**
     * The file path of the input text file.
     */
    private String inputTextFile;

    /**
     * The file path of the stopwords file.
     */
    private String stopwordsFile;

    /**
     * Constructs a WordFisher object and initializes its state.
     *
     * @param inputTextFile  the path to the text file for analysis
     * @param stopwordsFile  the path to the file containing stopwords
     */
    WordFisher(String inputTextFile, String stopwordsFile) {
        this.inputTextFile = inputTextFile;
        this.stopwordsFile = stopwordsFile;

        buildVocabulary();
        getStopwords();
    }

	/**
     * Reads stopwords from the specified stopwords file and stores them in the 
     * stopwords list.
     */
    public void getStopwords() {
        stopwords = new ArrayList<String>();
        String word;

        try {
            BufferedReader input = new BufferedReader(new FileReader(stopwordsFile));
            while ((word = input.readLine()) != null) {
                stopwords.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Builds the vocabulary by reading words from the input text file and 
     * counting their frequencies.
     */
    public void buildVocabulary() {
        vocabulary = new HashMap<String, Integer>();
        try {
        	String reader = new String(Files.readAllBytes(Paths.get(inputTextFile)));
            String[] allWords = reader.split("\\s+");
            for (String word : allWords) {
            	word = word.toLowerCase();
            	word.replaceAll("[^a-zA-Z0-9 ]", "");
            	
            	if (vocabulary.containsKey(word)) {
            		Integer old = vocabulary.get(word);
            		vocabulary.put(word, old + 1);
            	}else {
            		vocabulary.put(word, 1);
            	}
            	
            }
            
        }catch(IOException e) {
        	e.printStackTrace();
        }
       
        
//        if (vocabulary.containsKey(word)) {
//        	vocabulary.set
//        }
        
        
        // TODO: Part 1
        // By the end of this method, vocabulary should map each word to the number of
        // times it occurs in inputTextFile.
        // Therefore, as you iterate over words, increase the value that the word maps
        // to in vocabulary by 1.
        // If it's not in the vocabulary, then add it with an occurrence of 1.
        // Use getStopwords as an example of reading from files.

    }


    /**
     * Returns the total number of words in the input text file based on the 
     * vocabulary.
     *
     * @return the total word count
     */
    public int getWordCount() {
        // TODO: Part 2
        // HINT: This can be calculated using vocabulary.
    	
        return vocabulary.size();
    }

    /**
     * Returns the number of unique words in the vocabulary.
     *
     * @return the number of unique words
     */
    public int getNumUniqueWords() {
        // TODO: Part 3
        // HINT: This should be the same as the number of keys in vocabulary.
    	int count = 0;
    	for (String key : vocabulary.keySet()) {
    		count++;
    	}
        return count;
    }

    /**
     * Returns the frequency of a specific word in the vocabulary.
     *
     * @param word  the word whose frequency is to be returned
     * @return the frequency of the word, or -1 if the word is not in the vocabulary
     */
    public int getFrequency(String word) {
        if (vocabulary.containsKey(word)) {
            // TODO: Part 4
            // HINT: Should be one simple line of code. Think about what vocabulary stores.
        	return vocabulary.get(word);
        }
        return -1;
    }

    /**
     * Removes all stopwords from the vocabulary.
     */
    public void pruneVocabulary() {
        // TODO: Part 5
    	for (String stopword : stopwords) {
    		vocabulary.remove(stopword);
    	}
    }

    /**
     * Retrieves the top n words from the vocabulary based on their frequency.
     *
     * @param n  the number of top words to retrieve
     * @return a list of the top n words
     */
    public ArrayList<String> getTopWords(int n) {
        ArrayList<String> topWords = new ArrayList<String>();
        
        WordNodeComparator comp = new WordNodeComparator();
        PriorityQueue<WordNode> pq = new PriorityQueue<WordNode>(this.vocabulary.size(), comp );
        for(String w : this.vocabulary.keySet()) {
        	WordNode nw = new WordNode(w, this.vocabulary.get(w));
        	 pq.offer(nw);
        }// end of for 
        
        for (int index = 0; index < n; index++) {
        	topWords.add(pq.poll().getWord());
        	
        }// end of for
        
        
        
        
        // TODO: Part 6

        return topWords;
    }

    /**
     * Finds the common popular words between this WordFisher instance and another.
     *
     * @param n     the number of top words to consider
     * @param other another WordFisher instance to compare with
     * @return a list of common popular words
     */
    public ArrayList<String> commonPopularWords(int n, WordFisher other) {
        ArrayList<String> commonPopWords = new ArrayList<String>();

        // TODO: Part 7

        return commonPopWords;
    }
    
    public class WordNodeComparator implements Comparator<WordNode>{
    	
    	
    	public int compare(WordNode wn1, WordNode wn2) {
    		return (int) wn1.getFreq() - wn2.getFreq(); 
    	}
    }

    public class WordNode   {
    	private String word;
    	private int freq;
    	
    	public WordNode(String aword, int somefreq) {
    		this.word = aword;
    		this.freq = somefreq;
    	}
    	
    	public int getFreq() {
    		return this.freq;
    	}
    	
    	public String getWord() {
    		return this.word;
    	}
    	/*
    	@Override
    	@params
    		
    	*/
    	public int equals(WordNode wn){
    		if (this.freq - wn.freq ==0) {
    			return 0;
    		}else if (this.freq - wn.freq > 0) {
    			return 1;
    		}else {
    			return -1;
    		}
    	}
    	
    	
    }// end of WordNode class
    
}
