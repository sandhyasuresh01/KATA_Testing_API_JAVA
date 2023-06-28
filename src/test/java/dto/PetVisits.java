package dto;

public class PetVisits {
    private int id;
    private String date;
    private String description;
    private int pet;

    public PetVisits(int id, String date, String description, int pet) {
        super();
        this.id = id;
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    public PetVisits() {
        super();
    }

    @Override
    public String toString() {
        return "PetVisits [id=" + id + ", date=" + date + ", description=" + description + ", pet=" + pet + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPet() {
        return pet;
    }

    public void setPet(int pet) {
        this.pet = pet;
    }
}