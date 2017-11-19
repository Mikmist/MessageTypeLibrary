package net.zhspace;

import net.zhspace.AddressObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zino Holwerda
 * Date: 10/23/2017.
 */
public class Message implements Serializable{

    private static final long serialVersionUID = 2L;

    private byte[] data;

    /**
     * A message constructor that creates a Message object
     * @param message the message or object that needs to be send
     * @param returnAddress the address from which the message was send
     * @param type the type of message
     */
    public Message(Object message, AddressObject returnAddress, int type) {
        try {
            List<Object> list = new ArrayList<>();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
            list.add(type);
            list.add(returnAddress);
            list.add(message);
            out.writeObject(list);
            data = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getData() {
        return data;
    }

    /* TYPE LOGIC
     * type 0: Client message requesting a check on server version number.
     * type 1: Server message sending the client the current version.
     * type 2: UNDEFINED.
     */
}
