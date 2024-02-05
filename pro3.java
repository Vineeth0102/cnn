import java.io.*;
public class pro3 {

    public static void main(String args[])throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter message bits: ");
		String message = br.readLine();
		System.out.print("Enter generator: ");
		String generator = br.readLine();
		int data[] = new int[message.length() + generator.length() - 1];
		int divisor[] = new int[generator.length()];
		for(int i=0;i<message.length();i++)
			data[i] = Integer.parseInt(message.charAt(i)+"");
		for(int i=0;i<generator.length();i++)
			divisor[i] = Integer.parseInt(generator.charAt(i)+"");

		for(int i=0;i<message.length();i++){
			if(data[i]==1)
				for(int j=0;j<divisor.length;j++)
					data[i+j] ^= divisor[j];
		}


		System.out.print("The checksum code is: ");
		for(int i=0;i<message.length();i++)
			data[i] = Integer.parseInt(message.charAt(i)+"");
		for(int i=0;i<data.length;i++) 
			System.out.print(data[i]);
		System.out.println();

		System.out.print("Enter checksum code: ");
		message = br.readLine();
		System.out.print("Enter generator: ");
    	generator = br.readLine();
		data = new int[message.length() + generator.length() - 1];
		divisor = new int[generator.length()];
		for(int i=0;i<message.length();i++)
			data[i] = Integer.parseInt(message.charAt(i)+"");
		for(int i=0;i<generator.length();i++)
			divisor[i] = Integer.parseInt(generator.charAt(i)+"");

		for(int i=0;i<message.length();i++) {
			if(data[i]==1)
				for(int j=0;j<divisor.length;j++)
					data[i+j] ^= divisor[j];
		}

		boolean valid = true;
		for(int i=0;i<data.length;i++)
			if(data[i]==1){
				valid = false;
				break;
		}

		if(valid==true) 
			System.out.println("Data stream is valid");
		else 
			System.out.println("Data stream is invalid. CRC error occurred.");

		br.close();
	}
}
