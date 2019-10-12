import java.util.ArrayList;

public class Couple<I> {
	private ArrayList<MooreMachine<?,I>> inputs = new ArrayList<>();
	private ArrayList<MooreMachine<I,?>> outputs = new ArrayList<>();

	private ArrayList<I> output = new ArrayList<>();
	private ArrayList<String> outputString = new ArrayList<>();

	private boolean verbose = false;

	public void pipe() {
		output.clear();
		outputString.clear();
		for (MooreMachine<?,I> i : inputs) {
			output.add(i.lambda());
			if(verbose) {
				outputString.add("║" + i.toString() + " lambda = " + output.get(output.size()-1));
			}
		}
	}

	public void deltas() {
		outputString.clear();
		for (MooreMachine<I,?> o : outputs) {
			o.delta(output);
			if(verbose) {
				outputString.add("║" + o.toString() + " ran delta");
			}
		}
	}

	public void addInput(MooreMachine<?,I> in) {
		inputs.add(in);
	}

	public void addOutput(MooreMachine<I,?> out) {
		outputs.add(out);
	}

	public ArrayList<String> getOutput() {
		return outputString;
	}

	public ArrayList<I> get() {
		return output;
	}

	public void verbose() {
		verbose = !verbose;
	}
}
