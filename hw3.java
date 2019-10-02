import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
		String command = "";

		Scanner sc = new Scanner(System.in);

		XOR x1 = new XOR();
		Memory m = new Memory();

		while(sc.hasNextLine()) {
			command = sc.nextLine();
			if(command.compareTo("exit") == 0) {
				break;
			}
			x1.delta(command.charAt(0) == '1', command.charAt(1) == '1');
			System.out.println("X1 lambda=" + x1.lambda());
			m.delta(command.charAt(2) == '1');
			System.out.println("M lambda=" + m.lambda());
		}
	}
}
