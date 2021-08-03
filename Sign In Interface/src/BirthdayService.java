import java.io.*;
import java.util.Scanner;

public class BirthdayService {

	private String service;
	private File file;
	
	public BirthdayService(File fl, String emailService) {
		// TODO Auto-generated constructor stub
		this.service = emailService;
		this.file = fl;
	}
	
	
	public void sendGreeting(String date) {
		
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				System.out.println("Searching");
				String data = read.nextLine();
				try {
					String[] arr = data.split("\t");
					if(arr.length>0) {
						String[] personBdae = arr[2].split("/",2);
						if(personBdae[1].equals(date) ) {
							System.out.println("Birthday");
							JavaMail.sendMail(arr[1], arr[3], service);
						}
					}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception when searching BDAE");
				}
			}
			read.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception when reading file");
		}
	}

}
