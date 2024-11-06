package src.constants;

public enum Action {
    APART("apart"), BOOK("book"), STOP("stop");

    private final String keyWord;

    Action(String keyWord) {
        this.keyWord = keyWord;
    }
}
