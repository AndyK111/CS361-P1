package fa.dfa;

import fa.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        this.nameMap = new HashMap<>();
        this.alphabet = new HashSet<>();
        this.finalStates = new HashSet<>();
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

        from.setTransition(onSymb, to);
        return true;
    }

    @Override
    public boolean accepts(String s)
    {
        throw new UnsupportedOperationException("TODO: Implement accepts");
    }

    @Override
    public DFA swap(char symb1, char symb2)
    {
        throw new UnsupportedOperationException("TODO: Implement swap");
    }

    @Override
    public boolean addState(String name)
    {
        if (nameMap.get(name) == null)
        {
            DFAState<Character> newState = new DFAState<>("name");
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
        return Set.of();
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
    //endregion
}
