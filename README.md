****************
* Project 1: DFA
* Class: CS361
* Date: 2/20/26
* Andy Kempf, Sam Kleman
****************
# OVERVIEW:
This program models a deterministic finite automata using individual objects to represent
each state and their respective transitions, stored together using a hash map. 

# INCLUDED FILES:

* README - this file
* DFA.java - class representing the DFA as a whole
* DFAInterface.java - outlines functionality
* DFAState.java - represents an individual state in the DFA
* FAInterface.java - outlines functionality (for a general FA)
* State.java - simple abstract class outlining state objects
* DFATest.java - driver class demonstrating functionality

# COMPILING AND RUNNING:
From the root directory, first compile the driver class + dependencies using:
$ javac ./test/dfa/DFATest.java

Then, run the compiled program using the following:
$ java ./test/dfa/DFATest.java

Results are output to the console.

# PROGRAM DESIGN AND IMPORTANT CONCEPTS:
The program can be divided into two classes that do the heavy lifting, DFA & DFAState. State is a generic class so if someone wishes they could use it with an alphabet of whatever object they chose. Within the class is a HashTable that is responsible for forming the transition function of any given node. The DFA class holds the responsibility of containing the total number of nodes, what the alphabet for these nodes is, and the ability to actually traverse between the nodes. It is important here that a LinkedHashMap is used because it will preserve the order of elements added to it, so when it comes time to print data out, we are able to do so in the proper order.

# TESTING:
In order to make sure our program worked as expected, we utilized the 
JUnit tests in DFATest.java, creating multiple instances of DFAs
with differing specifications to ensure robust functionality across
multiple different configurations. 

# DISCUSSION:
DFA's themselves are fairly simple machines, the specification for what a DFA does and how it does it is relatively tight. I would say the most difficult part of the project (for me) was the toString method. The logic and data organization that needed to happen to actually make the DFA function was fairly straight forward. We can provide the DFAState with a character, it will do a check on a hash table, and give us the node that we should go to next, after doing that until we exhaust the input, we simply need to check if the current node is contained within the final stated set.

The hardest part of this project, by far (for me) was the toString method. Not because it was technically difficult but because it was a very specific format that was required and matching that exactly proved to be somewhat difficult. 

# SOURCES:
- 2/18/26 : Asked chatGPT if there was an equivalent to HashSet/HashMap that preserved the order of elements inserted. That is how I found out about LinkedHashSet/LinkedHashMap.
--------------------------------------------------------------------------
--
All content in a README file is expected to be written in clear English
with
proper grammar, spelling, and punctuation. If you are not a strong writer,
be sure to get someone else to help you with proofreading. Consider all
project
documentation to be professional writing for your boss and/or potential
customers.
Annotations
