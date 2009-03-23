package org.restlet.ext.script.internal;

import java.io.Writer;

import javax.script.ScriptEngineManager;

import org.restlet.ext.script.ScriptedTextRepresentation;

/**
 * This is the type of the "container" variable exposed to the script. The name
 * is set according to {@link ScriptedTextRepresentation#containerVariableName}.
 * 
 * @author Tal Liron
 * @see ScriptedTextRepresentation
 */
public class ScriptedTextRepresentationContainer {
    private final Writer writer;

    private final Writer errorWriter;

    public ScriptedTextRepresentationContainer(Writer writer, Writer errorWriter) {
        this.writer = writer;
        this.errorWriter = errorWriter;
    }

    /**
     * Same as {@link #getWriter()}, for standard error.
     * 
     * @return The error writer
     */
    public Writer getErrorWriter() {
        return this.errorWriter;
    }

    /**
     * This is the {@link ScriptEngineManager} used to create the script engine.
     * Scripts may use it to get information about what other engines are
     * available.
     * 
     * @return The script engine manager
     */
    public ScriptEngineManager getScriptEngineManager() {
        return ScriptedTextRepresentation.scriptEngineManager;
    }

    /**
     * Allows the script direct access to the {@link Writer}. This should rarely
     * be necessary, because by default the standard output for your scripting
     * engine would be directed to it, and the scripting platform's native
     * method for printing should be preferred. However, some scripting
     * platforms may not provide adequate access or may otherwise be broken.
     * 
     * @return The writer
     */
    public Writer getWriter() {
        return this.writer;
    }
}
