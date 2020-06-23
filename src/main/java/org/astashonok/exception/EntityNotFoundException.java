package org.astashonok.exception;

import java.io.Serializable;

public class EntityNotFoundException extends Exception implements Serializable {

    private String message;

    public EntityNotFoundException(){
        this("Entity is not available!");
    }

    public EntityNotFoundException(String message){
        this.message = System.currentTimeMillis() + ": " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}


