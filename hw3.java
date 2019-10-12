import java.util.Scanner;
import java.util.ArrayList;

public class hw3 {
	private static final String PROMPT = "\u001b[32mnet_in# \u001b[39;49m";
	public static void main(String[] args) {
		String command = "";
		boolean step = false;
		ArrayList<Boolean> input = new ArrayList<Boolean>();

		Scanner sc = new Scanner(System.in);

		XOR xor1 = new XOR();
		XOR xor2 = new XOR();
		Memory m = new Memory();

		Couple<Boolean> one = new Couple<>();
		one.addInput(xor1);
		one.addInput(m);
		one.addOutput(xor2);

		Couple<Boolean> two = new Couple<>();
		two.addInput(xor2);
		two.addOutput(m);

		Network<Boolean,Boolean> net = new Network<>(xor1, xor2, 3);
		net.addCouple(one);
		net.addCouple(two);

		System.out.print(PROMPT);
		while(sc.hasNextLine()) {
			input.clear();
			command = sc.nextLine();
			if(command.compareTo("exit") == 0) {
				break;
			}
			else if(command.compareTo("verbose") == 0) {
				net.verbose();
			}
			else if(command.compareTo("step") == 0) {
				int t = step ? 3 : 1;
				net.step(t);
				step = !step;
			}
			else {
				input.add(command.charAt(0) == '1');
				input.add(command.charAt(1) == '1');

				System.out.println("Network lambda = " + net.lambda());
				net.delta(input);
			}

			System.out.print(PROMPT);
		}
	}
}
