import java.lang.Math;
import java.util.Scanner;
public class task_1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 100;
		int random_num = (int)(Math.random()*(max-min+1)+min); ;
		//System.out.println(b);
		  System.out.println("Guess The Number Between 0 to 100 : ");
		  int attemtps = 0;
		  boolean flag = true;
		  
		  while(flag){
		  System.out.print("Enter The Number : ");
		  int num = sc.nextInt();
		  
		  if(num == random_num){
		  	attemtps++;
		  	System.out.println("Right Guess......");
		  	System.out.println("Total Attemps : "+attemtps);
		  	flag = false;
		  	
		  }
		  else if(num > random_num){
		  	attemtps++;
		  	System.out.println("Your entered number is Larger......");
		  }
		  else{
		  	attemtps++;
		  	System.out.println("Your entered number is Smaller .....");
		  }
		  }
	}
}