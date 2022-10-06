package backend.compiler;

import backend.Backend;
import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageType;

import static message.MessageType.COMPILER_SUMMARY;

public class CodeGenerator extends Backend
{

    public void process(ICode iCode, SymTab symTab)
            throws Exception
    {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int instructionCount = 0;

        // Send the compiler summary message.
        sendMessage(new Message(COMPILER_SUMMARY,
                new Number[] {instructionCount,
                        elapsedTime}));
    }
}
