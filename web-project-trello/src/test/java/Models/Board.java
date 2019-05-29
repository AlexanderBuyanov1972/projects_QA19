package Models;

public class Board {
    String boardName;

    public Board() {
    }

    public String getBoardName() {
        return boardName;
    }

    public void withBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                '}';
    }
}
