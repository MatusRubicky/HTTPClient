import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matusrubicky on 18.2.2015.
 */
public class ChatServer {

    public static void main(String[] args){
        try {
            ExecutorService es = Executors.newCachedThreadPool();

            ServerSocket ss = new ServerSocket(8000);
          while(true) {
              Socket soket = ss.accept();
              ServerVlakno vlakno = new ServerVlakno(soket);
              es.execute(vlakno);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
