import java.util.ArrayList;

public class Network<I,O> implements MooreMachine<I,O> {
	private ArrayList<Couple<?>> couples = new ArrayList<Couple<?>>();
	private MooreMachine<I,?> input;
	private Couple<O> output;
	private int currentTick = 0;
	private int ticks;
	private boolean verbose = false;

	public Network(MooreMachine<I,?> in, Couple<O> out, int t) {
		output = out;
		output.pipe();
		input = in;

		ticks = t;
	}

	public O lambda() {
		return output.get().get(0);
	}

	public void delta(ArrayList<I> in) {
		input.delta(in);
		if(verbose) {
			System.out.println(input.toString() + " ran delta");
		}

		for(int tick = 0; tick < ticks; tick++) {
			if(verbose) {
				System.out.println("\n===============Tick " + currentTick + "===============");
			}
			for (Couple<?> c : couples) {
				c.pipe();
			}
			
			for (Couple<?> c : couples) {
				c.deltas();
			}
			
			currentTick++;
		}
	}

	public void addCouple(Couple<?> couple) {
		couples.add(couple);
	}

	public void verbose() {
		verbose = !verbose;
		for (Couple<?> c : couples) {
			c.verbose();
		}
	}

	public void step() {
		ticks = ticks == 3 ? 1 : 3;
	}
}
