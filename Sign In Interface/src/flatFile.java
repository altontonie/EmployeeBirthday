import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class flatFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File employeeRepository = new File("employeeBirthday.txt");
		String emailService = "smtp.gmail.com";
		BirthdayService birthdayService = new BirthdayService(employeeRepository,emailService);
		birthdayService.sendGreeting(today());		
	}

	private static String today() {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("MM/dd").format(Calendar.getInstance().getTime());
		return date;
	}

}
