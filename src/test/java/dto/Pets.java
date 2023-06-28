package dto;

import java.util.Arrays;

public class Pets {
    private int id;
    private String name;
    private String birthDate;
    private PetType type;
    private PetOwners owner;
    private PetVisits[] visits;

    public Pets() {
        super();
    }

    public Pets(int id, String name, String birthDate, PetType type, PetOwners owner, PetVisits[] visits) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
        this.visits = visits;
    }

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

    public PetOwners getOwner() {
        return owner;
    }

    public void setOwner(PetOwners owner) {
        this.owner = owner;
    }

    public PetVisits[] getVisits() {
        return visits;
    }

    public void setVisits(PetVisits[] visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Pets [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", type=" + type + ", owner=" + owner
                + ", visits=" + Arrays.toString(visits) + "]";
    }
}
