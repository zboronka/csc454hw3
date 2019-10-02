public class XOR implements MooreMachine {
	private boolean state = false;

	public boolean lambda() {
		return state;
	}

	public void delta(boolean ...b) {
		state = b[0] ^ b[1];
	}
}
