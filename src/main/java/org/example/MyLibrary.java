package org.example;

import org.byteskript.skript.api.Library;
import org.byteskript.skript.api.ModifiableLibrary;
import org.byteskript.skript.compiler.CompileState;
import org.byteskript.skript.runtime.Skript;


/**
 * The main class of the library where syntax is registered.
 */
public class MyLibrary extends ModifiableLibrary implements Library {
    
    /**
     * We can register our syntax here.
     */
    public MyLibrary() {
        super("my_library");
        registerSyntax(CompileState.STATEMENT,
            new SimpleJavaExpression(this)
        );
    }
    
    public static void main(String[] args) {
        System.out.println("This goes in the libraries/ directory!");
    }
    
    /**
     * Called by ByteSkript to load the library
     */
    public static void load(Skript skript) {
        skript.registerLibrary(new MyLibrary());
    }
    
}
