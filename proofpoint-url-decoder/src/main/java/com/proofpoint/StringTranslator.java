/**
 * Modified version for Python's String Translations for Java found at: https://blog.thecskr.in/post/pythons-string-translations-for-java/
 *
 * * Java equivalent of Python's makeTrans and translate method.
 * * Used by ProofpointDecoderHelper to decode proofpoint urls.
 *
 */

package com.proofpoint;

import java.util.HashMap;
import java.util.Map;

public class StringTranslator {
    private Map<Character, Character> translationMap;

    /**
     * Replaces '-_' to '%/' in the string and adds them to translationMap.
     * Currently only supports v2 proofpoint urls.
     */
    protected StringTranslator() {

        String from = "-_";
        String to = "%/";
        translationMap = new HashMap<Character, Character>();

        if (from.length() != to.length())
            throw new IllegalArgumentException("The from and to strings must be of the same length");

        for (int i = 0; i < from.length(); i++)
            translationMap.put(from.charAt(i), to.charAt(i));
    }

    /**
     * @return string by replacing '-_' to '%/' from passed in string.
     */

    protected String makeTrans(String str) {
        StringBuilder buffer = new StringBuilder(str);

        for (int i = 0; i < buffer.length(); i++) {
            Character ch = buffer.charAt(i);
            Character replacement = translationMap.get(ch);
            if (replacement != null)
                buffer.replace(i, i + 1, "" + replacement);
        }

        return buffer.toString();
    }

    protected String translate(String str, String deleteChars) {
        StringBuilder buffer = new StringBuilder(str);
        char[] deletions = deleteChars.toCharArray();
        for (char ch : deletions) {
            int index;
            if ((index = buffer.indexOf("" + ch)) != -1)
                buffer.deleteCharAt(index);
        }

        return makeTrans(buffer.toString());
    }
}