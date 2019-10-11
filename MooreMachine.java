import java.util.ArrayList;

interface MooreMachine<I,O> {
	O lambda();
	void delta(ArrayList<I> input);
}
