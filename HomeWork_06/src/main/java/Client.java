import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    int clientID;
    String surname;
    String firstname;
    String patronymic;
    String fullname;
    Date dateOfBirsday;

    protected void setClient(int clientID, String surname,  String firstname,  String patronymic,  Date dateOfBirsday) {
        this.clientID = clientID;
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.fullname = surname + " " + firstname + " " + patronymic;
        this.dateOfBirsday = dateOfBirsday;
    }

    protected String getClientInfo () {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        return  "ID: " + this.clientID + " - ФИО: " +
                this.surname + " " + this.firstname + " " + this.patronymic + " Дата рождения: (" +
                dateFormat.format(this.dateOfBirsday) + ")";
    }

    void printClient() {
        System.out.println(getClientInfo());
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "ФИО = " + this.fullname;
    }

    @Override
    public int hashCode() {
        return this.fullname == null ? 0 : this.fullname.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;

        Client otherClient = (Client) other;

        return this.fullname.equals(otherClient.fullname);
    }
}
