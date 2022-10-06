package backend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

public abstract class Backend implements MessageProducer {

    protected static MessageHandler messageHandler;
    static {
        messageHandler = new MessageHandler();
    }
    protected SymTab symTab;
    protected ICode iCode;

    public abstract void process(ICode iCode, SymTab symTab) throws Exception;

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
