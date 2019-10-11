import java.util.ArrayList;

public class Couple<I> {
	private ArrayList<MooreMachine<?,I>> inputs = new ArrayList<>();
	private ArrayList<MooreMachine<I,?>> outputs = new ArrayList<>();
	private ArrayList<I> output = new ArrayList<>();
	private boolean verbose = false;

	public void pipe() {
		output.clear();
		for (MooreMachine<?,I> i : inputs) {
			output.add(i.lambda());
			if(verbose) {
				System.out.println(i.toString() + " lambda = " + output.get(output.size()-1));
			}
		}
	}

	public void deltas() {
		for (MooreMachine<I,?> o : outputs) {
			o.delta(output);
			if(verbose) {
				System.out.println(o.toString() + " ran delta");
			}
		}
	}

	public void addInput(MooreMachine<?,I> in) {
		inputs.add(in);
	}

	public void addOutput(MooreMachine<I,?> out) {
		outputs.add(out);
	}

	public ArrayList<I> get() {
		return output;
	}

	public void verbose() {
		verbose = !verbose;
	}
}
