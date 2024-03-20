package HospitalManagementSystem.HospitalManagementSystem.Controller;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a (HH:mm)");

    // Method to get available time slots
    public static List<String> getAvailableTimeSlots(List<String> allAppointments) throws ParseException {
        List<String> availableTimeSlots = new ArrayList<>();

        // Create a calendar instance for the current date
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 10); // Set the start time to 10 am
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		// End time for appointments (6 pm)
		Calendar endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY, 18);
		endTime.set(Calendar.MINUTE, 0);
		endTime.set(Calendar.SECOND, 0);
		endTime.set(Calendar.MILLISECOND, 0);

		// Loop through time slots every half hour
		while (calendar.before(endTime)) {
		    String timeSlot = dateFormat.format(calendar.getTime());
		    
		    // Check if the time slot is available (not in the list of booked appointments)
		    if (!allAppointments.contains(timeSlot)) {
		        availableTimeSlots.add(timeSlot);
		    }

		    // Move to the next half-hour slot
		    calendar.add(Calendar.MINUTE, 30);
		}

        return availableTimeSlots;
    }
}
