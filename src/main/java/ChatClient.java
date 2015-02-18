import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class ChatClient{
    public static void main(String[] args){
        Socket soket = null;

        try {
            soket = new Socket("localhost", 8000);
            OutputStream os = soket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            InputStream is = soket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            Scanner citac = new Scanner(System.in);
            while(true) {
                String riadok = citac.nextLine();
                if ("exit".equals(riadok))
                    break;
                pw.println(riadok);
                pw.flush();
            }

            //ako v terminali
            pw.println("GET / HTTP/1.1");
            pw.println("Host: www.ics.upjs.sk");
            pw.println();
            //spláchne sokety, netreba zabúdať
            pw.flush();

            while(true){
                String riadok = br.readLine();
                if (riadok == null) {
                    break;
                }
                System.out.println(riadok);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (soket != null) {
                try {
                    soket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}