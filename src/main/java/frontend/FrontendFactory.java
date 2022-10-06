package frontend;

import frontend.informix.InformixParserTD;
import frontend.informix.InformixScanner;
import frontend.pascal.PascalParserTD;
import frontend.pascal.PascalScanner;

public class FrontendFactory {
    
    public static Parser createParser(String language, String type,
                                      Source source)
            throws Exception
    {
        if (language.equalsIgnoreCase("Pascal") &&
                type.equalsIgnoreCase("top-down"))
        {
            Scanner scanner = new PascalScanner(source);
            return new PascalParserTD(scanner);
        }
        else if (language.equalsIgnoreCase("Informix") &&
                type.equalsIgnoreCase("top-down"))
        {
            Scanner scanner = new InformixScanner(source);
            return new InformixParserTD(scanner);
        }
        else if (!language.equalsIgnoreCase("Pascal")
        && !language.equalsIgnoreCase("Informix"))
        {
            throw new Exception("Parser factory: Invalid language ‘" +
                    language + "‘");
        }
        else {
            throw new Exception("Parser factory: Invalid type ‘" +
                    type + "‘");
        }
    }
    
}
