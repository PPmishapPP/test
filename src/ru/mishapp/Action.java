package ru.mishapp;

public enum Action {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    UNKNOWN('u');

    private final char value;

    Action(char value){
        this.value = value;
    }

    public static Action getAction(char value) {
        for (Action action : values()){
            if (action.value == value){
                return action;
            }
        }
        return UNKNOWN;
    }
}
