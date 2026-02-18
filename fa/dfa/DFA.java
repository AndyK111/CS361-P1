package fa.dfa;

import fa.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unused convert", "FieldCanBeLocal"}) //Remove when fully implemented
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
        return false;
    }

    @Override
    public DFA swap(char symb1, char symb2)
    {
        return null;
    }

    @Override
    public boolean addState(String name)
    {
        return false;
    }

    @Override
    public boolean setFinal(String name)
    {
        return false;
    }

    @Override
    public boolean setStart(String name)
    {
        return false;
    }

    @Override
    public void addSigma(char symbol)
    {

    }

    @Override
    public boolean accepts(String s)
    {
        return false;
    }

    @Override
    public Set<Character> getSigma()
    {
        return Set.of();
    }

    @Override
    public State getState(String name)
    {
        return null;
    }

    @Override
    public boolean isFinal(String name)
    {
        return false;
    }

    @Override
    public boolean isStart(String name)
    {
        return false;
    }
    //endregion
}
