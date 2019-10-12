import java.util.ArrayList;

public class Network<I,O> implements MooreMachine<I,O> {
	private ArrayList<Couple<?>> couples = new ArrayList<Couple<?>>();
	private MooreMachine<I,?> input;
	private MooreMachine<?,O> output;

	private int currentTick = 0;
	private int ticks;

	private ArrayList<String> coupleOutput = new ArrayList<>();
	private boolean verbose = false;

	private final int LINEWIDTH = 30;

	public Network(MooreMachine<I,?> in, MooreMachine<?,O> out, int t) {
		output = out;
		input = in;

		ticks = t;
	}

	public O lambda() {
		return output.lambda();
	}

	public void delta(ArrayList<I> in) {
		for(int tick = 0; tick < ticks; tick++) {
			if(verbose) {
				String tickCounter = "Tick " + currentTick;
				int left = (LINEWIDTH-tickCounter.length())/2;
				int right = (LINEWIDTH-tickCounter.length())%2 == 0 ? left : left + 1;

				System.out.println("\n╔" + line("═", left) + tickCounter + line("═", right) + "╗");
			}

			for(Couple<?> c : couples) {
				c.pipe();
				if(verbose) {
					coupleOutput.addAll(c.getOutput());
				}
			}
			
			input.delta(in);
			if(verbose) {
				coupleOutput.add("║" + input.toString() + " ran delta");
			}

			for(Couple<?> c : couples) {
				c.deltas();
				if(verbose) {
					coupleOutput.addAll(c.getOutput());
				}
			}

			if(verbose) {
				for(String s : coupleOutput) {
					int right = LINEWIDTH-s.length();
					System.out.println(s + line(" ", right) + " ║");
				}
				System.out.println("╚" + line("═", LINEWIDTH) + "╝");
			}
			
			coupleOutput.clear();
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

	public void step(int t) {
		ticks = t;
	}

	private String line(String c, int num) {
		String ret = "";
		for(int i = 0; i < num; i++) {
			ret += c;
		}
		return ret;
	}
}
