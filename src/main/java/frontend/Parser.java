package frontend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

public abstract class Parser implements MessageProducer {
    protected static SymTab symTab;
    protected static MessageHandler messageHandler;

    static {
        symTab = null;
        messageHandler = new MessageHandler();
    }

    protected Scanner scanner;
    protected ICode icode;

    protected Parser(Scanner scanner)
    {
        this.scanner = scanner;
        this.icode = null;
    }

    public SymTab getSymTab() {
        return symTab;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ICode getIcode() {
        return icode;
    }

    public abstract void parse() throws Exception;

    public abstract int getErrorCount();

    public Token currentToken()
    {
        return scanner.currentToken();
    }

    public Token nextToken() throws Exception
    {
        return scanner.nextToken();
    }
    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
    }

}
