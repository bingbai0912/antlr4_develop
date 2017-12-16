package com.bb;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by baibing on 12/16/17.
 */

public class HelloAntlr4 {

    public static void main(String[] args) {
        System.out.println("hello Antlr4");
        try{
            runAntlr4();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void runAntlr4() throws IOException{
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream("{1,2,3}".getBytes()));
        // create a lexer that feeds off of input CharStream
        DemoLexer lexer = new DemoLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        DemoParser parser = new DemoParser(tokens);
        ParseTree tree = parser.init(); // begin parsing at init rule

        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new ShortToUnicodeString(), tree);
        System.out.println(); // print a \n after translation

    }

}
