package seedu.address.model.meeting;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

//@@author AyushChatto
/**
 * Represents a value that the user has scheduled with the client.
 * Guarantees: immutable.
 */
public class Meeting {

    public static final String MESSAGE_MEETING_CONSTRAINTS =
            "Meeting should only contain a date and time in DD/MM/YY HHMM format";

    public static final String MEETING_VALIDATION_REGEX = "\\d{10}";
    public static final String NO_MEETING = "0000000000";
    public static final String NO_MEETING_MSG = "No meeting scheduled";

    public final String value;

    /**
     * Constructs a {@code Meeting}.
     *
     * @param meeting A valid value time.
     */
    public Meeting(String meeting) {
        requireNonNull(meeting);
        checkArgument(isValidMeeting(meeting), MESSAGE_MEETING_CONSTRAINTS);
        value = meeting;
    }

    /**
     * Formats meetings to meet the standard entry format by removing special characters
     */
    public static String formatMeeting(String uneditedMeeting) {
        String editedMeeting = "";
        for (int i = 0; i < uneditedMeeting.length(); i++) {
            if (Character.isDigit(uneditedMeeting.charAt(i))) {
                editedMeeting += uneditedMeeting.charAt(i);
            }
        }
        return editedMeeting;
    }

    /**
     * Returns true if a given string is a valid value.
     */
    public static boolean isValidMeeting(String test) {
        if (test.equals(NO_MEETING)) {
            return true;
        } else if (test.matches(MEETING_VALIDATION_REGEX)) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyy");
                LocalDate.parse(test.substring(0,6), df);
                return true;
            } catch (DateTimeException e) {
                return false;
            }
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        if (value.equals(NO_MEETING)) {
            return NO_MEETING_MSG;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" " + value.substring(0,2) + "/"
                + value.substring(2,4) + "/"
                + value.substring(4,6) + " at "
                + value.substring(6,8)
                + value.substring(8,10));
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Meeting // instanceof handles nulls
                && value.equals(((Meeting) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
