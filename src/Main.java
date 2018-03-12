//Φουρτούνης Νίκος
//icsd13195
class MyThread extends Thread {

	public int number1;
	public int number2;
	private int multiply;

	// constructor method
	public MyThread(int multiply) {
		this.multiply = multiply;
	}

	// compute and store in the array the specified number squared
	public void run() {
		for (int i = 0; i < 199; i++) {
			if (i % 2 == 1) {
				for (int y = 0; y < 199; y++) {
					if (y % 2 == 1) {
						if (multiply == i * y) {
							number1 = i;
							number2 = y;
							break;
						}
					}
				}
			}
		}
	}

}

public class Main {

	public static void main(String[] args) {
		// Ftiaxnw pinaka me ta pilika pou thelw na upologistoun
		int[] array = { 24795, 17955, 20265, 18887 };
		// Ftiaxnw ta 4 thread kai dinw se kathe ena stoixeio apo ton pinaka
		MyThread t1 = new MyThread(array[0]);
		MyThread t2 = new MyThread(array[1]);
		MyThread t3 = new MyThread(array[2]);
		MyThread t4 = new MyThread(array[3]);
		// Ksekinaw xronometrhsh
		long startTime = System.nanoTime();
		// Ksekinaw ta thread
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// Ftiaxnw try me join olwn twn threads gia na perimenw na teleiwsoun ola
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {

		}
		// Teleiwnw thn xronometrhsh
		long endTime = System.nanoTime();
		long threadsTotalTime = endTime - startTime;
		// Emfanizw thn diafora ths xronometrhshs alla kai ta noumera pou ftiaxnoyn to
		// piliko
		System.out.println("Time to calculate with threads:" + threadsTotalTime);
		System.out.println(array[0] + "=" + t1.number1 + "*" + t1.number2);
		System.out.println(array[1] + "=" + t2.number1 + "*" + t2.number2);
		System.out.println(array[2] + "=" + t3.number1 + "*" + t3.number2);
		System.out.println(array[3] + "=" + t4.number1 + "*" + t4.number2);
		// Kanw to idio alla me synchronized kwdika
		startTime = System.nanoTime();
		MyThread t5 = new MyThread(array[0]);
		MyThread t6 = new MyThread(array[1]);
		MyThread t7 = new MyThread(array[2]);
		MyThread t8 = new MyThread(array[3]);
		// Dhladh perimenw na teleiwsei kathe thread kai meta ksekinaw to epomeno
		// Afto to katafernw me thn xrhsh twn ksexwristwn joins
		t5.start();
		try {
			t5.join();
		} catch (Exception e) {

		}
		t6.start();
		try {
			t6.join();
		} catch (Exception e) {

		}
		t7.start();
		try {
			t7.join();
		} catch (Exception e) {

		}
		t8.start();
		try {
			t8.join();
		} catch (Exception e) {

		}
		endTime = System.nanoTime();
		// Emfanizw ton xrono pou phre alla kai thn diafora twn 2 tropwn (dhladh me
		// multithreading kai seiriakhs ekteleshs)
		long SynchonizedTotalTime = endTime - startTime;
		System.out.println("Time to calculate with synchronized:" + SynchonizedTotalTime);
		System.out.println("Threads were faster than Synchronized by:" + (SynchonizedTotalTime - threadsTotalTime));
		System.out.println(array[0] + "=" + t5.number1 + "*" + t5.number2);
		System.out.println(array[1] + "=" + t6.number1 + "*" + t6.number2);
		System.out.println(array[2] + "=" + t7.number1 + "*" + t7.number2);
		System.out.println(array[3] + "=" + t8.number1 + "*" + t8.number2);
	}
}
