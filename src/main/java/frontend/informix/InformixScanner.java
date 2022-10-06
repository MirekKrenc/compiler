package frontend.informix;

import frontend.EofToken;
import frontend.Scanner;
import frontend.Source;
import frontend.Token;

import static frontend.Source.EOF;

public class InformixScanner extends Scanner {

    public InformixScanner(Source source) {
        super(source);
    }

    @Override
    protected Token extractToken() throws Exception {
        Token token;

        if (currentChar() == EOF)
        {
            token = new EofToken(source);
        }
        else
        {
            token = new Token(source);
        }

        return token;
    }
}
