import java.util.Scanner;

public class task_2{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num_of_sub = 0;
		int avg = 0;
		int total = 0;
		
		System.out.println("Enter Total Number of Subjects : ");
		num_of_sub = sc.nextInt();
		
		int marks[] = new int [num_of_sub];
		
		for(int i = 0;i < num_of_sub;i++){
			System.out.println("Enter Subject - "+(i+1)+" Marks : ");
			marks[i] = sc.nextInt();
		}
		
		
		for(int i = 0;i < num_of_sub;i++){
			System.out.println(marks[i]);
			total = total + marks[i];
		}
		
		System.out.println("Total Marks : "+total);
		avg = total/num_of_sub;
		
		System.out.println("Average of Marks : "+avg);
		
		int cnt = 0;
		for(int i = 0;i < num_of_sub;i++){
			if(marks[i] >= 40){
				cnt++;
			}
		}
		
		if(avg < 40){
			System.out.println("Better Luck Next Time.....");
		}
		else{
			if(cnt == num_of_sub){
				
				if(avg >= 40 && avg <=60){
					System.out.println("Grade : C");
				}
				else if(avg > 60 && avg <= 80){
					System.out.println("Grade : B");
				}
				else{
					System.out.println("Grade : A");
				}
			}
			else{
				System.out.println("Better Luck Next Time.....");
			}
		}
	}
}