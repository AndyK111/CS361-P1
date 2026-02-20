****************
* Project 1: DFA
* Class: CS361
* Date: 2/20/26
* Andy Kempf, Sam Kleman
****************
OVERVIEW:
This program models a deterministic finite automata using individual objects to represent
each state and their respective transitions, stored together using a hash map. 

INCLUDED FILES:

* README - this file
* DFA.java - class representing the DFA as a whole
* DFAInterface.java - outlines functionality
* DFAState.java - represents an individual state in the DFA
* FAInterface.java - outlines functionality (for a general FA)
* State.java - simple abstract class outlining state objects
* DFATest.java - driver class demonstrating functionality

COMPILING AND RUNNING:
From the root directory, first compile the driver class + dependencies using:
$ javac ./test/dfa/DFATest.java

Then, run the compiled program using the following:
$ java ./test/dfa/DFATest.java

Results are output to the console.

PROGRAM DESIGN AND IMPORTANT CONCEPTS:
This is the sort of information someone who really wants to
understand your program - possibly to make future enhancements -
would want to know.
Explain the main concepts and organization of your program so that
the reader can understand how your program works. This is not a repeat
of javadoc comments or an exhaustive listing of all methods, but an
explanation of the critical algorithms and object interactions that make
up the program.
Explain the main responsibilities of the classes and interfaces that make
up the program. Explain how the classes work together to achieve the
program
goals. If there are critical algorithms that a user should understand,
explain them as well.
If you were responsible for designing the program's classes and choosing
how they work together, why did you design the program this way? What, if
anything, could be improved?

TESTING:
In order to make sure our program worked as expected, we utilized the 
JUnit tests in DFATest.java, creating multiple instances of DFAs
with differing specifications to ensure robust functionality across
multiple different configurations. 

DISCUSSION:
Discuss the issues you encountered during programming (development)
and testing. What problems did you have? What did you have to research
and learn on your own? What kinds of errors did you get? How did you
fix them?
What parts of the project did you find challenging? Is there anything
that finally "clicked" for you in the process of working on this project?
EXTRA CREDIT:
If the project had opportunities for extra credit that you attempted,
be sure to call it out so the grader does not overlook it.

SOURCES:
All sources used outside of lecture notes, slides, and the textbook need
to
be cited here. If you used websites, used GenAI, asked your dad or your
boss
or your roommate for help then you must cite those resources. I am not
concerned if you use proper APA or MLA or another format as long as you
include
all relevant information. If it is a person or GenAI that you referenced,
be
sure to include who you talked to (or which AI you accessed), when you
talked
to them, and what help they provided (e.g. Student, Awesome. Private
communication, 21 January 2026. Discussed how polymorphism allows the
return
types of methods implemented in a class to be different from the class
specified
in the interface as long as the <type in implementation> “is-a” <type in
interface>.)
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
