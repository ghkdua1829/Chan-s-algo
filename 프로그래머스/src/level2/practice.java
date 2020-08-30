package level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+b);

	}

}

class Home {
	String name;

	public Home(String name) {
		super();
		this.name = name;
	}

}

class Person extends Home {
	int money;

	public Person(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int money) {
		super(name);

		this.money = money;
	}

	
}
