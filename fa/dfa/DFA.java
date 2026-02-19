package fa.dfa;
import fa.State;
import java.util.*;

@SuppressWarnings({"unused convert", "FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
//Remove when fully implemented
public class DFA implements DFAInterface
{
    //region Fields
    final private Map<String, DFAState<Character>> nameMap; //"Q", But also serves to map names -> state objects
    final private Set<Character> alphabet;                      //sigma
    private DFAState<Character> initialState;             //"q0"
    final private Set<DFAState<Character>> finalStates;                    //"F"
    //endregion

    //region Constructors
    public DFA()
    {
        this.nameMap = new LinkedHashMap<>();
        this.alphabet = new LinkedHashSet<>();
        this.finalStates = new LinkedHashSet<>();
    }
    //endregion

    //region Methods
    @Override
    public boolean addTransition(String fromState, String toState, char onSymb)
    {
        if (!alphabet.contains(onSymb)) return false; //Short-circuit check that onSymb is in alphabet/sigma

        DFAState<Character> from = nameMap.get(fromState);
        DFAState<Character> to = nameMap.get(toState);
        if (from == null || to == null) return false; //Short-circuit check for existence of both states

        if (from.hasTransition(onSymb)) from.clearTransition(onSymb);
        from.setTransition(onSymb, to);
        return true;
    }

    @Override
    public boolean accepts(String s)
    {
        DFAState<Character> currentState = initialState;

        for (Character c : s.toCharArray())
        {
            if (currentState.hasTransition(c))
            {
                currentState = currentState.getTransition(c);
            }
            else return false; //Short-circuit undefined transition
        }

        //Check if on final state
        return finalStates.contains(currentState);
    }

    @Override
    /**
	 * Creates a deep copy of this DFA
	 * which transitions labels are
	 * swapped between symbols symb1
	 * and symb2.
	 * @return a copy of this DFA
	 */
    public DFA swap(char symb1, char symb2)
    {
        DFA result = new DFA();
        for(char c : this.getSigma()){//Σ
            result.addSigma(c);
        }
        for(DFAState<Character> state : this.nameMap.values()){//Q
            result.addState(state.getName());
        }
        result.setStart(this.initialState.getName());//q0
        for(DFAState<Character> state : this.finalStates){//F
            result.setFinal(state.getName());
        }
        for(DFAState<Character> fromState : this.nameMap.values()){//δ
            for(char c : this.alphabet){
                if(fromState.hasTransition(c)){
                    DFAState<Character> toState = fromState.getTransition(c);
                    char currentTransition = c;
                    //check to see if current transition is one of our targets + swap if so
                    if(c == symb1) currentTransition = symb2;
                    else if(c == symb2) currentTransition = symb1;
                    result.addTransition(fromState.getName(), toState.getName(), currentTransition);
                }
            }
        }
        return result;
    }

    @Override
    public boolean addState(String name)
    {
        if (nameMap.get(name) == null)
        {
            DFAState<Character> newState = new DFAState<>(name);
            nameMap.put(name, newState);
            return true;
        }
        return false;
    }

    @Override
    public boolean setFinal(String name)
    {
        DFAState<Character> state = nameMap.get(name);
        if (state == null) return false; //Short-circuit check for existence

        finalStates.add(state);
        return true;
    }

    @Override
    public boolean setStart(String name)
    {
        DFAState<Character> state = nameMap.get(name);
        if (state == null) return false; //Short-circuit check for existence

        initialState = state;
        return true;
    }

    @Override
    public void addSigma(char symbol)
    {
        alphabet.add(symbol);
    }

    @Override
    public Set<Character> getSigma()
    {
        return alphabet;
    }

    @Override
    public State getState(String name)
    {
        return nameMap.get(name);
    }

    @Override
    public boolean isFinal(String name)
    {
        DFAState<Character> state = nameMap.get(name);
        if (state == null) return false; //Short-circuit check for existence

        return finalStates.contains(state);
    }

    @Override
    public boolean isStart(String name)
    {
        DFAState<Character> state = nameMap.get(name);
        if (state == null) return false; //Short-circuit check for existence

        return (initialState == state);
    }

    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        Set<String> nameSet = nameMap.keySet();

        //Build the Q section
        StringJoiner Q = new StringJoiner(" ", "{", "}");
        for (String s : nameSet)
        {
            Q.add(s);
        }
        toReturn.append("Q=").append(Q).append("\n");

        //Build the Sigma section
        StringJoiner sigma = new StringJoiner(" ", "{", "}");
        for (Character c : alphabet)
        {
            sigma.add(c.toString());
        }
        toReturn.append("Sigma = ").append(sigma).append("\n");

        //Build the delta section
        toReturn.append("delta =\n");
        //Prints the legend of alphabet on top row
        for (Character c : alphabet)
        {
            toReturn.append("\t").append(c);
        }
        toReturn.append("\n");

        //Prints a row of connections on each character here
        for (DFAState<Character> s : nameMap.values())
        {
            toReturn.append(s.getName());
            for (Character c : alphabet)
            {
                if (s.hasTransition(c))
                {
                    toReturn.append("\t").append(s.getTransition(c).getName());
                }
            }
            toReturn.append("\n");
        }

        //Build the q0 section
        toReturn.append("q0 = ");
        toReturn.append(initialState);
        toReturn.append("\n");

        //Build the F section
        StringJoiner F = new StringJoiner(" ", "{", "}");
        for (DFAState<Character> s : finalStates)
        {
            F.add(s.toString());
        }
        toReturn.append("F=");
        toReturn.append(F).append("\n");

        return toReturn.toString();
    }
    //endregion
}
