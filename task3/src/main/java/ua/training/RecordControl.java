package ua.training;

import java.io.InputStream;
import java.time.DateTimeException;
import java.util.Scanner;

/**
 * Class which controls the process of Record instance filling
 *
 * @author Roman Prokopenko.
 */
public class RecordControl {

    private InputStream inputStream;
    private View view;

    /**
     * Constructor with parameters
     *
     * @param inputStream reference to main control InputStream
     * @param view        reference to View
     */
    public RecordControl(InputStream inputStream, View view) {
        this.inputStream = inputStream;
        this.view = view;
    }

    /**
     * Creates new Record instance, then controls the process of data input.
     *
     * @return Record instance with user filled fields
     */
    public Record getInput() {
        Record record = new Record();
        Scanner sc = new Scanner(inputStream);

        //user full name input
        record.setName(inputStringWithScanner(sc, Record.NAME_REGEX,
                View.NAME_INPUT_MESSAGE, View.NAME_RULE_MESSAGE));
        record.setSurname(inputStringWithScanner(sc, Record.NAME_REGEX,
                View.SURNAME_INPUT_MESSAGE, View.NAME_RULE_MESSAGE));
        record.setPatronymic(inputStringWithScanner(sc, Record.NAME_REGEX,
                View.PATRONYMIC_INPUT_MESSAGE, View.NAME_RULE_MESSAGE));

        record.setNickname(inputStringWithScanner(sc, Record.NICK_NAME_REGEX,
                View.NICKNAME_INPUT_MESSAGE, View.NICKNAME_RULE_MESSAGE));
        record.setComment(inputStringWithScanner(sc, Record.ANY_DATA_REGEX,
                View.COMMENT_INPUT_MESSAGE, View.COMMENT_RULE_MESSAGE));
        record.setUserGroup(inputStringWithScanner(sc, Record.GROUP_REGEX,
                View.GROUP_INPUT_MESSAGE, View.GROUP_RULE_MESSAGE));

        //phones
        record.setHomePhone(inputStringWithScanner(sc, Record.PHONE_REGEX,
                View.HOME_PHONE_INPUT_MESSAGE, View.PHONE_RULE_MESSAGE));
        record.setFirstMobilePhone(inputStringWithScanner(sc, Record.PHONE_REGEX,
                View.MOBILE_PHONE_INPUT_MESSAGE, View.PHONE_RULE_MESSAGE));

        //optional second mobile phone
        if (additionalInput(sc, View.OFFER_SECOND_MOBILE_PHONE_MESSAGE,
                View.OFFER_RULE_MESSAGE)) {
            record.setSecondMobilePhone(inputStringWithScanner(sc,
                    Record.PHONE_REGEX, View.MOBILE_PHONE_INPUT_MESSAGE,
                    View.PHONE_RULE_MESSAGE));
        }

        record.setEmail(inputStringWithScanner(sc, Record.EMAIL_REGEX,
                View.EMAIL_INPUT_MESSAGE, View.EMAIL_RULE_MESSAGE));
        record.setSkype(inputStringWithScanner(sc, Record.SKYPE_REGEX,
                View.SKYPE_INPUT_MESSAGE, View.SKYPE_RULE_MESSAGE));

        //address
        record.setPostcode(inputStringWithScanner(sc, Record.POST_CODE_REGEX,
                View.POSTCODE_INPUT_MESSAGE, View.POSTCODE_RULE_MESSAGE));
        record.setCity(inputStringWithScanner(sc, Record.CITY_REGEX,
                View.CITY_INPUT_MESSAGE, View.CITY_RULE_MESSAGE));
        record.setStreet(inputStringWithScanner(sc, Record.STREET_REGEX,
                View.STREET_INPUT_MESSAGE, View.STREET_RULE_MESSAGE));
        record.setHouseNumber(inputStringWithScanner(sc, Record.HOUSE_NUMBER_REGEX,
                View.HOUSE_NUMBER_INPUT_MESSAGE, View.HOUSE_NUMBER_RULE_MESSAGE));
        record.setApartmentNumber(inputStringWithScanner(sc,
                Record.APARTMENT_NUMBER_REGEX, View.APARTMENT_NUMBER_INPUT_MESSAGE,
                View.APARTMENT_NUMBER_RULE_MESSAGE));

        //date
        try {
            record.setRecordAddTime(inputStringWithScanner(sc,
                    Record.DATE_REGEX, View.ADD_DATE_INPUT_MESSAGE,
                    View.DATE_RULE_MESSAGE));
            record.setRecordUpdateTime(inputStringWithScanner(sc,
                    Record.DATE_REGEX, View.UPDATE_DATE_INPUT_MESSAGE,
                    View.DATE_RULE_MESSAGE));
        } catch (DateTimeException ex) {
            view.printMessage(View.ERROR);
        }
        return record;
    }

    /**
     * Reads data whith Scanner sc. If data matches to regularExpression
     * returns it, else reads data again. Outputs inputMessage and
     * ruleMessage to {@link View}
     *
     * @param sc                Scanner
     * @param regularExpression regex
     * @param inputMessage      String message
     * @param ruleMessage       String message
     * @return
     */
    private String inputStringWithScanner(Scanner sc, String regularExpression,
                                          String inputMessage, String ruleMessage) {
        view.printMessage(inputMessage);
        view.printMessage(ruleMessage);
        String input = sc.nextLine();
        while (!input.matches(regularExpression)) {
            view.printMessage(ruleMessage);
            input = sc.nextLine();
        }
        return input;
    }

    /**
     * Outputs message, allows user to chose between Yes or No
     *
     * @param sc           Scanner
     * @param inputMessage String message
     * @param ruleMessage  String message
     * @return user answer
     */
    private boolean additionalInput(Scanner sc, String inputMessage, String ruleMessage) {
        //view.printMessage(message);
        String yesOrNoRegex = "^[YNs]$";
        String result = inputStringWithScanner(sc, yesOrNoRegex, inputMessage, ruleMessage);
        switch (result) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                return false;
        }
    }
}
