package oxm.model;

/**
 * Created by bf50 on 2016/1/13.
 */
public class Settings {
    private boolean fooEnabled;

    public boolean isFooEnabled() {
        return fooEnabled;
    }

    public void setFooEnabled(boolean fooEnabled) {
        this.fooEnabled = fooEnabled;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "fooEnabled=" + fooEnabled +
                '}';
    }
}
