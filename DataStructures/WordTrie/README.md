## This project contains sample implementation of a Word Trie in java
**The project is developed using Apache Netbeans IDE 10.0, Java 8, Windows 10**

## Features:
   - [X] Thread safe
   - [X] Different types of word look-ups

## Methods:
   - insert(value)
     * Inserts the given value in WordTrie
   - search(value)
     * Search for the given word in WordTrie
   - searchAll(value)
     * Search if the given word exists entirely in WordTrie 
     * For example: WordTrie: ["Anything", "No"]
       * searchAll("Any")  returns true as it exists entirely albeit in a separate word
       * searchAll("Nope") returns false as it doesn't exists entirely
   - delete(value)
     * Delete the word with given value
    - getAllWords()
     * Get all the words stored in WordTrie
    

    