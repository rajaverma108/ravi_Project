package InterviewQuestions.InternetReletedPrograms;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Runner {
    public static void main(String[] args) throws IOException {
//        gettingIPAddressOfMachine();
        gettingIPAddressOfSite();
//        gettingURlOFSite();
//        openNotepadWithJava();

    }

    private static void gettingIPAddressOfSite() {
        try {
            InetAddress inetAddress =
                    InetAddress.getByName("www.razorsql.com");
            System.out.println("HostName : "+inetAddress.getHostName());
            System.out.println("HostAddress : "+inetAddress.getHostAddress());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void gettingURlOFSite() {
        try {
            URL url = new URL("https://razorsql.com/articles/postgresql_jdbc_connect.html");
            System.out.println("protocol : "+url.getProtocol());
            System.out.println("HostName : "+url.getHost());
            System.out.println("PortNumber : "+url.getPort());
            System.out.println("FileName : "+url.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void openNotepadWithJava() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("NotePad");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void gettingIPAddressOfMachine() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
    }
}
