package dvx.company.springboot.domain;

public class Anime {
    private String name;
    private String sponsor;


    public Anime(String name, String sponsor) {
        this.name = name;
        this.sponsor = sponsor;
    }

    public Anime() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
