package fa.dfa;
import fa.State;

import java.util.HashMap;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class DFAState<S> extends State
{
    HashMap<S, DFAState<S>> transitionMap;

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
    public void setTransition(Object key, DFAState<S> destination) throws IllegalStateException
    {
        throw new UnsupportedOperationException("TODO: Implement setTransition");
    }

    /**
     * Clears a transition key->destination pair from this nodes transition function.
     * @param key                       The character consumed in a transition
     * @throws IllegalStateException    Thrown when there is an attempt to clear a key/destination pair that does not exist
     */
    public void clearTransition(Object key) throws IllegalStateException
    {
        throw new UnsupportedOperationException("TODO: Implement clearTransition");
    }

    /**
     * Returns the DFAState object that results from a transition
     * @param key                       The character consumed in a transition
     * @return                          The DFAState that results when traversing a particular transition
     * @throws NoSuchElementException   Thrown when there is an attempt to get the destination of a key/destination pair that does not exist
     */
    public DFAState<S> getTransition(Object key) throws NoSuchElementException
    {
        throw new UnsupportedOperationException("TODO: Implement getTransition");
    }

    /**
     * Checks whether a key/destination pair exists, given the key.
     * @param key   The character consumed in a transition
     * @return      True if there is a key/destination pair defined for this key
     */
    public boolean hasTransition(Object key)
    {
        throw new UnsupportedOperationException("TODO: Implement hasTransition");
    }

    /**
     * Removes all key/destination pairs from this nodes transition function
     */
    public void clearAllTransitions()
    {
        throw new UnsupportedOperationException("TODO: Implement clearAllTransitions");
    }
    //endregion
}
