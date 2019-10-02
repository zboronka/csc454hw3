public class Memory implements MooreMachine {
	private boolean q1 = false;
	private boolean q2 = false;

	public boolean lambda() {
		return q1;
	}

	public void delta(boolean ...b) {
		q1 = q2;
		q2 = b[0];
	}
}
