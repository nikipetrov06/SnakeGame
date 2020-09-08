
import java.util.ArrayList;
import java.util.List;

public class Lobby {

    private int index;

    private int freePlaces;

    private List<User> users;

    public Lobby() {
        this.freePlaces = 1;
        this.users = new ArrayList<>(2);
    }

    public Lobby(int index) {
        super();
        this.index = index;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public int getIndex() {
        return index;
    }
}
