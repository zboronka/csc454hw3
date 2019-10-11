import java.util.ArrayList;

public class Memory implements MooreMachine<Boolean, Boolean> {
	private Boolean q1 = false;
	private Boolean q2 = false;

	public Boolean lambda() {
		return q1;
	}

	public void delta(ArrayList<Boolean> b) {
		q1 = q2;
		q2 = b.get(0);
	}
}
