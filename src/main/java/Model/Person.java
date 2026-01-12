package Model;

public record Person(
        String name,
        String occupation
) {

    public String toString(){
        return String.format("%s %s", this.name, this.occupation);
    }
}
