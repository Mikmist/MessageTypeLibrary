package net.zhspace;

import java.io.Serializable;

/**
 * @author Zino Holwerda
 * Date: 9/22/2017.
 */
public class ConsoleMessage implements Serializable {

    private static long serialVersionUID = 42L;

    private Object message;
    private String name = null;

    public ConsoleMessage(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
