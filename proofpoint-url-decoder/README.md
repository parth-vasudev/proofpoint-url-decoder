# Proofpoint URL Decoder

*Disclaimer: This small Java utility decodes proofpoint URL's something similar to Python's Utility:  ```https://help.proofpoint.com/@api/deki/files/177/URLDefenseDecode.py?revision=1```
Pass in the url to Helper method and it returns the decoded url.


## Maven Dependency Information
```bash
<dependency>
    <groupId>com.proofpoint</groupId>
    <artifactId>proofpoint-url-decoder</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Installation
```bash
mvn clean compile install
```

## Usage
ENCODED_URL is the (String) url that need to be decoded.
```bash
ProofpointURLDecoderHelper helper = new ProofpointURLDecoderHelper();
String decoded = helper.decodeProofpointUrl({ENCODED_URL});
```