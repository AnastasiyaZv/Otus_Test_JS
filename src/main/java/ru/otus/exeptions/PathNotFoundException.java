package ru.otus.exeptions;

public class PathNotFoundException extends RuntimeException{

    public PathNotFoundException (){
        super("Path on page class not found");
    }
}
