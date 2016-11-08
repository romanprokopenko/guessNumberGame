package ua.training;

/**
 * Class which used to interact with player
 *
 * @author Roman Prokopenko
 */
public class View {

    public static final String NAME_INPUT_MESSAGE = "Enter name.";
    public static final String SURNAME_INPUT_MESSAGE = "Enter surname.";
    public static final String PATRONYMIC_INPUT_MESSAGE = "Enter patronymic.";
    public static final String NAME_RULE_MESSAGE = "Must contain only letters," +
            " first letter must be capitalized";
    public static final String NICKNAME_INPUT_MESSAGE = "Enter nickname.";
    public static final String NICKNAME_RULE_MESSAGE = "Must contain from" +
            " 6 to 15 alphanumeric characters, first character is a letter";
    public static final String COMMENT_INPUT_MESSAGE = "Enter comment.";
    public static final String COMMENT_RULE_MESSAGE = "May contain any character";
    public static final String GROUP_INPUT_MESSAGE = "Enter record group.";
    public static final String GROUP_RULE_MESSAGE = "Input must contain" +
            " FAMILY|WORK|STUDY";
    public static final String HOME_PHONE_INPUT_MESSAGE = "Enter your home number.";
    public static final String PHONE_RULE_MESSAGE = "Must be formatted" +
            " as ###-###-##-##";
    public static final String MOBILE_PHONE_INPUT_MESSAGE = "Enter your" +
            " mobile number.";
    public static final String OFFER_SECOND_MOBILE_PHONE_MESSAGE = "Do" +
            " you want to add second mobile phone?";
    public static final String OFFER_RULE_MESSAGE = "Enter Y/N";
    public static final String EMAIL_INPUT_MESSAGE = "Enter email.";
    public static final String EMAIL_RULE_MESSAGE = "Must contain only" +
            " alphanumerical characters,.,- and one @";
    public static final String SKYPE_INPUT_MESSAGE = "Enter skype.";
    public static final String SKYPE_RULE_MESSAGE = "Must contain from 6 to" +
            " 32 alphanumerical characters,.,-,. and begin with letter";
    public static final String POSTCODE_INPUT_MESSAGE = "Enter postcode.";
    public static final String POSTCODE_RULE_MESSAGE = "Must contain 5 numbers";
    public static final String CITY_INPUT_MESSAGE = "Enter city name.";
    public static final String CITY_RULE_MESSAGE = "Must start with capital" +
            " letter, may contain blank space or -";
    public static final String STREET_INPUT_MESSAGE = "Enter street name.";
    public static final String STREET_RULE_MESSAGE = "Must start with capital" +
            " letter, may contain blank space or -." +
            "Must end with street|boulevard|avenue";
    public static final String HOUSE_NUMBER_INPUT_MESSAGE = "Enter house number.";
    public static final String HOUSE_NUMBER_RULE_MESSAGE = "Must be a number" +
            " from 1 to 999 and may contain /";
    public static final String APARTMENT_NUMBER_INPUT_MESSAGE = "Enter apartment" +
            " number.";
    public static final String APARTMENT_NUMBER_RULE_MESSAGE = "Must be a number" +
            " from 1 to 999";
    public static final String ADD_DATE_INPUT_MESSAGE = "Enter record add date.";
    public static final String UPDATE_DATE_INPUT_MESSAGE = "Enter record update date.";
    public static final String DATE_RULE_MESSAGE = "Date must be formatted" +
            " as dd/mm/yyyy";
    public static final String ERROR = "error";


    /**
     * Prints message to System.out
     *
     * @param message any string
     */
    public void printMessage(String message) {
        System.out.println(message);
    }


}
