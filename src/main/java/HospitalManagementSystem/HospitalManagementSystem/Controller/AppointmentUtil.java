package HospitalManagementSystem.HospitalManagementSystem.Controller;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a (HH:mm)");


    public static List<String> getAvailableTimeSlots(List<String> allAppointments) throws ParseException {
        List<String> availableTimeSlots = new ArrayList<>();


		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);


		Calendar endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY, 18);
		endTime.set(Calendar.MINUTE, 0);
		endTime.set(Calendar.SECOND, 0);
		endTime.set(Calendar.MILLISECOND, 0);


		while (calendar.before(endTime)) {
		    String timeSlot = dateFormat.format(calendar.getTime());
		    

		    if (!allAppointments.contains(timeSlot)) {
		        availableTimeSlots.add(timeSlot);
		    }


		    calendar.add(Calendar.MINUTE, 30);
		}

        return availableTimeSlots;
    }
}
