package org.example;

import mx.kenzie.foundation.Type;
import org.byteskript.skript.api.Library;
import org.byteskript.skript.api.note.ForceExtract;
import org.byteskript.skript.api.syntax.Effect;
import org.byteskript.skript.api.syntax.SimpleExpression;
import org.byteskript.skript.compiler.CommonTypes;
import org.byteskript.skript.lang.element.StandardElements;
import org.byteskript.skript.lang.handler.StandardHandlers;

/**
 * This expression returns a value from an existing Java method.
 */
public class SimpleCustomEffect extends Effect {
    
    public SimpleCustomEffect(Library provider) {
        super(provider, StandardElements.EFFECT, "my [cool] effect %String% and %Number%");
        handlers.put(StandardHandlers.RUN, findMethod(this.getClass(), "doSomething", String.class, Number.class));
    }
    
    /**
     * This provides the functionality of the effect.
     * The inputs will be put into the method parameters.
     *
     * The @ForceExtract annotation tells the compiler to move this method
     * into the compiled script - so your addon isn't needed as a dependency when running
     */
    @ForceExtract
    public static void doSomething(String string, Number number) {
        System.out.println("Hello, the string is " + string);
        System.out.println("And the number is " + number);
    }
    
    
}
