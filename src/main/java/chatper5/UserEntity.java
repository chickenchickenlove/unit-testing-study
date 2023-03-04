package chatper5;

public class UserEntity {

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String normalizedName(String name) {
        return name.length() > 50 ? name.substring(0, 50) : name;
    }

}
