
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private String goals;
    private String assists;

    public void setName(String name) {
        this.name = name;
    }
    
    public void setNationality(String nat) {
        this.nationality = nat;
    }
    
    public void setTeam(String team) {
        this.name = team;
    }
    
    public void setGoals(String goals) {
        this.name = goals;
    }
    
    public void setAssists(String assists) {
        this.name = assists;
    }

    public String getName() {
        return name;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String getGoals() {
        return goals;
    }
    
    public String getAssists() {
        return assists;
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
