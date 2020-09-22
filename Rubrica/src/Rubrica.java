import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Rubrica {
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) {

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("rubrica.xml"));

            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            bufferedWriter.write("<Rubrica>");

            addNewClient("Azelio","Dellucci","AzelioDellucci@armyspy.com","0337 7985120");
            addNewClient("Giancarlo","Siciliani","GiancarloSiciliani@rhyta.com","0333 3191552");
            addNewClient("Beniamino","Trentini","BeniaminoTrentini@armyspy.com","0352 9416282");
            addNewClient("Dalia","Ferrari","DaliaFerrari@rhyta.com","0319 5765343");

            bufferedWriter.write("</Rubrica>");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewClient(String nome, String cognome, String email, String numero) {
        try {
            bufferedWriter.write("<Utente>" +
                    "<Nome>" + nome + "</Nome>" +
                    "<Cognome>" + cognome + "</Cognome>" +
                    "<Email>" + email + "</Email>" +
                    "<Numero>" + numero + "</Numero>" +
                    "</Utente>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
