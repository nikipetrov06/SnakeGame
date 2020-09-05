public class User {

    private Long id;
    private String username;
    private int highScore;

    public User(Long id, String username, int highScore) {
        this.id = id;
        this.username = username;
        this.highScore = highScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
