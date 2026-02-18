package fa.dfa;
import fa.State;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class DFAState<S> extends State
{
    private final Map<S, DFAState<S>> transitionMap;

    /**
     * Creates a new instance of DFAState given a name
     * @param name  The name of this particular node
     */
    public DFAState(String name)
    {
        super(name); //Construct parent
        transitionMap = new HashMap<>();
    }

    //region Transition Function Methods

    /**
     * Adds a transition key->destination pair to this nodes transition function.
     * @param key                       The character consumed in the transition
     * @param destination               The node that the transition will result in
     * @throws IllegalStateException    Thrown when there is an attempt to override an existing key/destination pair
     */
    public void setTransition(S key, DFAState<S> destination) throws UnsupportedOperationException
    {
        if (transitionMap.containsKey(key)) throw new UnsupportedOperationException("Attempted to override existing delta");

        transitionMap.put(key, destination);
    }

    /**
     * Clears a transition key->destination pair from this nodes transition function.
     * @param key                       The character consumed in a transition
     * @throws IllegalStateException    Thrown when there is an attempt to clear a key/destination pair that does not exist
     */
    public void clearTransition(S key) throws IllegalStateException
    {
        if (!transitionMap.containsKey(key)) throw new UnsupportedOperationException("Attempted to clear non-existent delta");

        transitionMap.remove(key);
    }

    /**
     * Returns the DFAState object that results from a transition
     * @param key                       The character consumed in a transition
     * @return                          The DFAState that results when traversing a particular transition
     * @throws NoSuchElementException   Thrown when there is an attempt to get the destination of a key/destination pair that does not exist
     */
    public DFAState<S> getTransition(S key) throws NoSuchElementException
    {
        if (!transitionMap.containsKey(key)) throw new NoSuchElementException("Attempted to get non-existent delta");

        return transitionMap.get(key);
    }

    /**
     * Checks whether a key/destination pair exists, given the key.
     * @param key   The character consumed in a transition
     * @return      True if there is a key/destination pair defined for this key
     */
    public boolean hasTransition(S key)
    {
        return transitionMap.containsKey(key);
    }

    /**
     * Removes all key/destination pairs from this nodes transition function
     */
    public void clearAllTransitions()
    {
        transitionMap.clear();
    }
    //endregion
}
