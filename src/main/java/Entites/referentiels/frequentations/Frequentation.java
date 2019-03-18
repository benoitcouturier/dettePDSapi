package Entites.referentiels.frequentations;
import java.util.Date;

public class Frequentation {

    public int getIdFrequentation() {
        return idFrequentation;
    }

    public void setIdFrequentation(int idFrequentation) {
        this.idFrequentation = idFrequentation;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setdateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    private int idFrequentation;
    private int idMagasin;
    private int idClient;
    private Date dateEntree;

}
