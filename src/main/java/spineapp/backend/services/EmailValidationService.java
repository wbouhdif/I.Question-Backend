package spineapp.backend.services;

import spineapp.backend.exceptions.EmailInvalidException;

import java.util.regex.Pattern;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

public class EmailValidationService {

    /**
     * Checks whether given email address is valid or not.
     * @param emailAddress String of email address to be checked.
     * @throws EmailInvalidException
     * In case the email in question is found to be invalid an EmailInvalidException is thrown.
     */
    public static void validateEmailAddress(String emailAddress) throws EmailInvalidException{
        String[] splitAddress = splitAddress(emailAddress);

        String local = splitAddress[0];
        String domain = splitAddress[1];

        String regexPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        if (!patternMatches(emailAddress, regexPattern) || !checkIfDomainExists(domain)) {
            throw new EmailInvalidException(emailAddress);
        }

    }

    /**
     * Checks whether given email address matches given regex pattern.
     * @param emailAddress String of email address to be matched to the regex pattern.
     * @param regexPattern String of regex pattern to be matched to the email address.
     * @return
     * Returns true if given email address matches given regex pattern.
     * Returns false if given email address does not match given regex pattern.
     */
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    /**
     * Splits given email address on the @.
     * @param emailAddress String of email address to be split.
     * @return
     * Returns array of strings containing the split email address.
     */
    public static String[] splitAddress(String emailAddress) {
        return emailAddress.split("@");
    }

    /**
     * Checks if given domain exists.
     * @param domain String domain to be checked.
     * @return
     * Returns true when given domain exists.
     * Returns false when given domain does not exist.
     */
    private static boolean checkIfDomainExists(String domain) {
        final Lookup dnsLookup;
        try {
            dnsLookup = new Lookup(domain, Type.MX);
        } catch (TextParseException e) {
            throw new RuntimeException(e);
        }

        Record[] mxRecords = dnsLookup.run();

        return mxRecords != null;
    }

}
