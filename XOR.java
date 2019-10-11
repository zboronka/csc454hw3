import java.util.ArrayList;

public class XOR implements MooreMachine<Boolean, Boolean> {
	private Boolean state = false;

	public Boolean lambda() {
		return state;
	}

	public void delta(ArrayList<Boolean> b) {
		state = b.get(0) ^ b.get(1);
	}
}
