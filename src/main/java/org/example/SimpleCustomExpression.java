package org.example;

import mx.kenzie.foundation.Type;
import org.byteskript.skript.api.Library;
import org.byteskript.skript.api.note.ForceExtract;
import org.byteskript.skript.api.syntax.SimpleExpression;
import org.byteskript.skript.compiler.CommonTypes;
import org.byteskript.skript.lang.element.StandardElements;
import org.byteskript.skript.lang.handler.StandardHandlers;

/**
 * This expression returns a value from an existing Java method.
 */
public class SimpleCustomExpression extends SimpleExpression {
    
    public SimpleCustomExpression(Library provider) {
        super(provider, StandardElements.EXPRESSION, "my [cool] expression %String%");
        handlers.put(StandardHandlers.GET, findMethod(this.getClass(), "getLength", String.class));
    }
    
    /**
     * The return type of this expression
     */
    @Override
    public Type getReturnType() {
        return CommonTypes.STRING;
    }
    
    /**
     * This provides the functionality of the expression.
     * The inputs will be put into the method parameters.
     *
     * The @ForceExtract annotation tells the compiler to move this method
     * into the compiled script - so your addon isn't needed as a dependency when running
     */
    @ForceExtract
    public static Number getLength(String string) {
        return string.length();
    }
    
    
}
