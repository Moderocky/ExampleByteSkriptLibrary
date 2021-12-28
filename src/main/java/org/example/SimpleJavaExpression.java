package org.example;

import mx.kenzie.foundation.Type;
import org.byteskript.skript.api.Library;
import org.byteskript.skript.api.syntax.SimpleExpression;
import org.byteskript.skript.compiler.CommonTypes;
import org.byteskript.skript.lang.element.StandardElements;
import org.byteskript.skript.lang.handler.StandardHandlers;

/**
 * This expression returns a value from an existing Java method.
 */
public class SimpleJavaExpression extends SimpleExpression {
    
    public SimpleJavaExpression(Library provider) {
        super(provider, StandardElements.EXPRESSION, "example expression");
        handlers.put(StandardHandlers.GET, findMethod(System.class, "lineSeparator"));
    }
    
    /**
     * The return type of this expression
     */
    @Override
    public Type getReturnType() {
        return CommonTypes.STRING;
    }
    
}
