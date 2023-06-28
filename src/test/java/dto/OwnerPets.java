package dto;
import java.util.Arrays;

public class OwnerPets{
    private int id;
    private String name;
    private String birthDate;
    private PetType type;
    private int owner;
    private PetVisits[] visits;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public PetType getType() {
        return type;
    }
    public void setType(PetType type) {
        this.type = type;
    }
    public int getOwner() {
        return owner;
    }
    public void setOwner(int owner) {
        this.owner = owner;
    }
    public PetVisits[] getVisits() {
        return visits;
    }
    public void setVisits(PetVisits[] visits) {
        this.visits = visits;
    }
    public OwnerPets(int id, String name, String birthDate, PetType type, int owner, PetVisits[] visits) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
        this.visits = visits;
    }
    @Override
    public String toString() {
        return "OwnerPets [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", type=" + type + ", owner="
                + owner + ", visits=" + Arrays.toString(visits) + "]";
    }
    public OwnerPets() {
        super();
    }
}