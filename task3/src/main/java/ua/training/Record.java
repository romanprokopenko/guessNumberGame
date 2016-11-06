package ua.training;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Roman Prokopenko on 06.11.2016.
 */
public class Record {
    public static final String NAME_REGEX = "^[A-Z][a-z]+$";
    public static final String NICK_NAME_REGEX = "^[a-zA-Z]\\w{5,14}$";
    public static final String PHONE_REGEX = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String SKYPE_REGEX = "^[a-zA-Z][a-zA-Z0-9_\\-\\,\\.]{5,31}";
    public static final String POST_CODE_REGEX = "^\\d{5}";
    public static final String CITY_REGEX = "^[A-Z][a-z]+(?:[\\s-][a-zA-Z]+)*$";
    public static final String STREET_REGEX = "^[A-Z][a-z]+(?:[\\s-][a-zA-Z]+)* (?:street|boulevard|avenue)$";
    public static final String HOUSE_NUMBER_REGEX = "^[1-9]\\d{1,2}(\\/[1-9]\\d{1,2})?$";
    public static final String APARTMENT_NUMBER_REGEX = "^[1-9]\\d{1,2}?$";
    public static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    public static final String ANY_DATA_REGEX = ".*";
    public static final String GROUP_REGEX = "^(FAMILY|WORK|STUDY)$";

    private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String comment;
    private Group userGroup;
    private String homePhone;
    private String firstMobilePhone;
    private String secondMobilePhone;
    private String email;
    private String skype;
    private String postcode;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private LocalDate recordAddTime;
    private LocalDate recordUpdateTime;

    /**
     * Sets {@link Group} userGroup from String value
     *
     * @param userGroup string that converts to Group
     */
    public void setUserGroup(String userGroup) {
        this.userGroup = Group.valueOf(userGroup);
    }

    /**
     * Returns a short form of name generated from name and surname
     *
     * @return string with short form of name
     */
    public String getFullName() {
        return this.surname + " " + this.name.substring(0, 1) + ".";
    }

    /**
     * Returns a string with that contains postcode, city, street,
     * house number and apartment number
     *
     * @return full address
     */
    public String getFullAddress() {
        return this.postcode + " " + this.city + " " + this.street
                + " " + this.houseNumber + " " + this.apartmentNumber;
    }

    /**
     * Sets record add date from input string
     *
     * @param recordAddTime string entered by user
     * @throws DateTimeException when date is incorrect
     */
    public void setRecordAddTime(String recordAddTime) throws DateTimeException {
        String dateFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        this.recordAddTime = LocalDate.parse(recordAddTime, formatter);
    }

    /**
     * Sets record update date from input string
     *
     * @param recordUpdateTime string entered by user
     * @throws DateTimeException when date is incorrect
     */
    public void setRecordUpdateTime(String recordUpdateTime) throws DateTimeException {
        String dateFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        this.recordUpdateTime = LocalDate.parse(recordUpdateTime, formatter);
    }

    /**
     * Generates a string that contains from record fields
     *
     * @return string representation of Record
     */
    @Override
    public String toString() {
        String dateFormat = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return getFullName() + System.lineSeparator() + getComment()
                + System.lineSeparator() + getUserGroup().toString() +
                System.lineSeparator() + getHomePhone() + System.lineSeparator() +
                getFirstMobilePhone() + System.lineSeparator() +
                ((getSecondMobilePhone() != null) ? getSecondMobilePhone() : "") +
                System.lineSeparator() + getEmail() + " " + getSkype() +
                System.lineSeparator() +
                getFullAddress() + System.lineSeparator() +
                getRecordAddTime().format(formatter) +
                System.lineSeparator() + getRecordUpdateTime().format(formatter);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getUserGroup() {
        return userGroup;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getFirstMobilePhone() {
        return firstMobilePhone;
    }

    public void setFirstMobilePhone(String firstMobilePhone) {
        this.firstMobilePhone = firstMobilePhone;
    }

    public String getSecondMobilePhone() {
        return secondMobilePhone;
    }

    public void setSecondMobilePhone(String secondMobilePhone) {
        this.secondMobilePhone = secondMobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public LocalDate getRecordAddTime() {
        return recordAddTime;
    }

    public LocalDate getRecordUpdateTime() {
        return recordUpdateTime;
    }
}
