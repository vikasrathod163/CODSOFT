import java.lang.Math;
import java.util.Scanner;
public class task_1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 1;
		int max = 100;
		int i = 0;
		int limit = 10;
		int wins = 0;
		
		System.out.println("Enter the no of rounds.... : ");
		int round = sc.nextInt();

		while (i < round) {
			System.out.println("Round : " + (i + 1));
			int random_num = (int)(Math.random() * (max - min + 1) + min);

			
			System.out.println("Guess The Number Between 1 to 100 : ");
			int attempts = 0;
			boolean flag = true;

			while (flag) {
				while (attempts < limit) {
					System.out.print("Enter The Number : ");
					int num = sc.nextInt();

					if (num == random_num) {
						attempts++;
						System.out.println("Right Guess......");
						System.out.println("Total Attemps : " + attempts);
						wins++;

						flag = false;
						break;
					} else if (num > random_num) {
						attempts++;
						System.out.println("too high .....");
					} else {
						attempts++;
						System.out.println("too low .....");
					}
				}
				if (attempts == limit && flag == true) {
					System.out.println("You Lost...limit for attempts was " + limit);
					flag = false;
					break;
				}

			}
			i++;
		}

		System.out.println("You have won " + wins + " Round out of " + round + " Rounds");

	}
}
