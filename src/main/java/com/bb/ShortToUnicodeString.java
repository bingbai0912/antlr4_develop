package com.bb;

/**
 * Created by baibing on 12/16/17.
 * Convert short array inits like {1,2,3} to "\u0001\u0002\u0003"
 */
public class ShortToUnicodeString extends DemoBaseListener {
    /** Translate { to " */
    @Override
    public void enterInit(DemoParser.InitContext ctx) {
        System.out.print('"');
    }

    /** Translate } to " */
    @Override
    public void exitInit(DemoParser.InitContext ctx) {
        System.out.print('"');
    }

    /** Translate integers to 4-digit hexadecimal strings prefixed with   \\u */
    @Override
    public void enterValue(DemoParser.ValueContext ctx) {
        // Assumes no nested array initializers
        int value = Integer.valueOf(ctx.INT().getText());
//        System.out.printf("\\u%04x", value);
        System.out.print(value);
    }
}
