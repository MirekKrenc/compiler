package frontend;

import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

import static message.MessageType.SOURCE_LINE;

public class Source implements MessageProducer {
    public static final char EOL = '\n';
    public static final char EOF = (char)0;
    private static int FIRST_TIME_PROCESS = -2;
    private static int START_NEXT_LINE_READ = -1;

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPos;

    private MessageHandler messageHandler;


    public Source(BufferedReader reader) throws IOException {
        this.reader = reader;
        this.lineNum = 0;
        this.currentPos = FIRST_TIME_PROCESS;
        this.messageHandler = new MessageHandler();
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getPosition() {
        return currentPos;
    }

    public char currentChar() throws Exception
    {
        if (currentPos == FIRST_TIME_PROCESS) //first time
        {
            readLine();
            return nextChar();
        }
        else if (line == null)
        {
            return EOF;
        }
        else if ((currentPos == START_NEXT_LINE_READ || currentPos == line.length()))
        {
            return EOL;
        }
        else if (currentPos > line.length())
        {
            readLine();
            return nextChar();
        }
        else
        {
            return line.charAt(currentPos);
        }
    }

    public char nextChar() throws Exception
    {
        ++currentPos;
        return currentChar();
    }

    public char peekChar() throws Exception
    {
        currentChar();
        if (line == null)
        {
            return EOF;
        }

        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    public void readLine() throws Exception
    {
        line = reader.readLine();
        currentPos = START_NEXT_LINE_READ;

        if (line != null)
        {
            ++lineNum;
        }

        if (line != null)
        {
            sendMessage(new Message(SOURCE_LINE,
                    new Object[] {lineNum, line}));
        }
    }

    public void close() throws Exception
    {
        if (reader != null)
        {
            try {
                reader.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
