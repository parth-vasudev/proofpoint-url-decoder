/**
 * Helper class to decode Proofpoint URL's.
 *
 * * Helper is called to decode the url.
 * it could throw an {@link java.io.UnsupportedEncodingException}.
 *
 * * @author  Parth Vasudev
 */

package com.proofpoint;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ProofpointURLDecoderHelper extends StringTranslator {

    private final String PROOFPOINT_ENDPOINT = "proofpoint.com";
    private final String STARTING_INDEX = "u=";
    private final String ENDING_INDEX = "&d=";

    /**
     * Helper method to decode Proofpoint URL's.
     *
     * * @returns decoded url.
     * @throws RuntimeException if url is invalid or empty.
     *
     * * @author  Parth Vasudev
     */
    public String decodeProofpointUrl(String url) throws UnsupportedEncodingException {
        if(url.isEmpty() || !url.contains(PROOFPOINT_ENDPOINT))
            throw new RuntimeException("Either target string is empty or is not a proofpoint url");

        if(!url.contains(STARTING_INDEX) || !url.contains(ENDING_INDEX))
            throw new RuntimeException("Not a valid proofpoint URL. Missing values for 'u=' and 'd='." );

        StringTranslator stringTranslator = new StringTranslator();
        String decodedUrl = stringTranslator.makeTrans(url);
        decodedUrl = decodedUrl.substring(decodedUrl.indexOf(STARTING_INDEX)+2, decodedUrl.indexOf(ENDING_INDEX));
        decodedUrl = new StringTranslator().makeTrans(decodedUrl);

        decodedUrl = URLDecoder.decode(decodedUrl, "UTF-8");
        return decodedUrl.substring(0, decodedUrl.indexOf("%22"));
    }
}