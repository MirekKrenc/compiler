package backend.interpreter;

import backend.Backend;
import intermediate.ICode;
import intermediate.SymTab;
import message.Message;

import static message.MessageType.INTERPRETER_SUMMARY;

public class Executor extends Backend
{

    @Override
    public void process(ICode iCode, SymTab symTab)
            throws Exception
    {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int executionCount = 0;
        int runtimeErrors = 0;
        // Send the interpreter summary message.
        sendMessage(new Message(INTERPRETER_SUMMARY,
                new Number[] {executionCount,
                        runtimeErrors,
                        elapsedTime}));
    }
}
