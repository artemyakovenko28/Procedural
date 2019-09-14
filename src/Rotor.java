import java.util.List;

public class Rotor {

    private List<Character> chars;
    private List<Integer> contacts;
    private List<Integer> positions;

    public Rotor() {
    }

    public Rotor(List<Character> chars, List<Integer> contacts, List<Integer> positions) {
        this.chars = chars;
        this.contacts = contacts;
        this.positions = positions;
    }

    public List<Character> getChars() {
        return chars;
    }

    public void setChars(List<Character> chars) {
        this.chars = chars;
    }

    public List<Integer> getContacts() {
        return contacts;
    }

    public void setContacts(List<Integer> contacts) {
        this.contacts = contacts;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }
}