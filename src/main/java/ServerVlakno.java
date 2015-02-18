import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by matusrubicky on 18.2.2015.
 */
public class ServerVlakno implements Runnable {

    private Socket soket;

    public ServerVlakno(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {

        InputStream is = null;
        try {
            is = soket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while(true){
                String riadok = br.readLine();
                if (riadok == null)
                    break;
                System.out.println(soket.getInetAddress()+": "+riadok);
                System.out.println(riadok);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
