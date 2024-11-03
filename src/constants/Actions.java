package src.constants;

public enum Actions {
    APART("apart"), BOOK("book"), STOP("stop");

    private final String keyWord;

    Actions(String keyWord) {
        this.keyWord = keyWord;
    }
}
