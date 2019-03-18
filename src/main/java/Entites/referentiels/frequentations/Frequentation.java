package Entites.referentiels.frequentations;

public class Frequentation {

    public int getIdFrequentation() {
        return idFrequentation;
    }

    public void setIdFrequentation(int idFrequentation) {
        this.idFrequentation = idFrequentation;
    }

    public int getIdPortique() {
        return idPortique;
    }

    public void setIdPortique(int idPortique) {
        this.idPortique = idPortique;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    private int idFrequentation;
    private int idPortique;
    private int idClient;
    private String entryDate;

}
