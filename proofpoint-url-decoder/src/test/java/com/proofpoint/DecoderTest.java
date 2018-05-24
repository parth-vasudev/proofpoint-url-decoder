package com.proofpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class DecoderTest {

    @Test
    public void validUrlTest() throws UnsupportedEncodingException {

        String link = "https://urldefense.proofpoint.com/v2/url?u=https-3A__www.github.com-2522-2C-2522linkTags-2522-3Anull&d=DwICaQ&c=0YLnzTkWOdJlub_y7qAx8Q&r=uHbqmSNzd-rHt8bWEkTBl-zIre65Vb01Qm3CMg5MWlg&m=9Y7k_y00F0B7LiZZkkFkG2YLcHobeaP6e4tVLAgiouM&s=Ff3db-lLksFlzwW4cvrVM0UrghRVyxzCCCKDt9tOo9I&e=}}";

        ProofpointURLDecoderHelper helper = new ProofpointURLDecoderHelper();
        String decoded = helper.decodeProofpointUrl(link);
        System.out.println(decoded);
        Assert.assertEquals(decoded, "https://www.github.com");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void invalidUrlTest() throws UnsupportedEncodingException {

        String link = "https://urldefense.proofpoint.com/v2/url?&d=DwICaQ&c=0YLnzTkWOdJlub_y7qAx8Q&r=uHbqmSNzd-rHt8bWEkTBl-zIre65Vb01Qm3CMg5MWlg&m=9Y7k_y00F0B7LiZZkkFkG2YLcHobeaP6e4tVLAgiouM&s=Ff3db-lLksFlzwW4cvrVM0UrghRVyxzCCCKDt9tOo9I&e=}}";

        ProofpointURLDecoderHelper helper = new ProofpointURLDecoderHelper();
        helper.decodeProofpointUrl(link);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void emptyUrlTest() throws UnsupportedEncodingException {

        ProofpointURLDecoderHelper helper = new ProofpointURLDecoderHelper();
        helper.decodeProofpointUrl("");
    }
}
