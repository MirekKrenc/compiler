package frontend.informix;

import frontend.EofToken;
import frontend.Parser;
import frontend.Scanner;
import frontend.Token;
import message.Message;
import message.MessageType;

public class InformixParserTD extends Parser {

    public InformixParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();

        while (!((token = nextToken()) instanceof EofToken))
        {

        }

        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        sendMessage(new Message(MessageType.PARSER_SUMMARY,
                new Number[] {
                        token.getLineNum(),
                        getErrorCount(),
                        elapsedTime
                }));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }
}
