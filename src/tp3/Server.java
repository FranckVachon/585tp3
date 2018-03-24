package tp3;    

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import observerPattern.Subject;

public final class Server extends Subject {
	//Based on code submitted as accepted on stack overflow question #11640025, regarding httpHandler structure
    private static final Server server = new Server();

    private Server() {}
    
    //####################### endpoint et paramètres associés à chacun ##########
    private static String creationSalleURI = "/creationSalle";
    private static String salleNomParam = "salleNom";
   
    private static String creationUsagerURI = "/creationUsager";
    private static String usagerNomParam = "username";
    private static String usagerPasswordParam = "password";

    
    //####################### FIND endpoint et param ###########

    private static int inetSocketPort = 8000;
    

    public static Server getInstance() {
        return server;
    }
	
    public static void main(String[] args) throws Exception {
    	/*So this is our main - starts the server to listen on port inetSocketPort*/
        HttpServer server = HttpServer.create(new InetSocketAddress(inetSocketPort), 0);
        
        
        //################ CONTEXT CREATION
        //createContext. Must be a subdomain /mySubDom. Then every request to that subdomain will be redirect to the designated handler
        server.createContext(creationSalleURI, new CreationSalleHandler());
        server.createContext(creationUsagerURI, new CreationUsagerHandler());

        //################ CONTEXT CREATION

        server.setExecutor(null); // creates a default executor
        server.start();
        

        System.out.println("Serveur online @ " + server.getAddress());
        System.out.println("Context " + creationSalleURI + " actif");

    }

static class CreationSalleHandler implements HttpHandler {
	/*Gérer la création d'une nouvelle salle*/
    @Override
    public void handle(HttpExchange t) throws IOException {
        //localhost:inetSocketPort/creationSalle?salleNom=testNom
   	
        Map<String, String> params = parseQueryString(t.getRequestURI().getQuery()); 
        
        //Creer la nouvelle salle & attacher au observer pattern
        server.attachSalle(new Salle(params.get(salleNomParam), server.getSalleCount()));

        
        //#######################BEGIN DEBUG PRINT
        String lineREturn = "\n";
        String response = "Creation d'une nouvelle salle";
        String response2 = salleNomParam + ": " + params.get(salleNomParam)+ " nmb total salles: " + server.getSalleCount();
        //System.out.println(response);
        //System.out.println(response2);
        t.sendResponseHeaders(200, response.length() + lineREturn.length() + response2.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.write(lineREturn.getBytes());
        os.write(response2.getBytes());
        os.close();
        //################### END DEBUG PRINT
    }
}

static class CreationUsagerHandler implements HttpHandler {

	/*Gérer la création d'une nouvel usager*/
    @Override
    public void handle(HttpExchange t) throws IOException {
        //localhost:inetSocketPort/creationUsager?username=billybob&password=secrepass
   	
        Map<String, String> params = parseQueryString(t.getRequestURI().getQuery()); 
        
        //Creer nouvel usager & attacher au observer pattern
        server.attachUsager(new User(params.get(usagerNomParam), params.get(usagerPasswordParam), server.getUserCount()));

        
        //#######################BEGIN DEBUG PRINT
        String lineREturn = "\n";
        String response = "Creation d'une nouvel usager";
        String response2 = usagerNomParam + ": " + params.get(usagerNomParam) + " pass: " + params.get(usagerPasswordParam) + " nmb total usagers: " + server.getUserCount();
        System.out.println(response);
        System.out.println(response2);
        t.sendResponseHeaders(200, (response).length() + lineREturn.length() + response2.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.write(lineREturn.getBytes());
        os.write(response2.getBytes());
        os.close();
        //################### END DEBUG PRINT

}
}
    
public static Map<String, String> parseQueryString(String qs) {
	/**
	 * Prends en entrée un string, qui represente l'ensemble de la query qui a été envoyé au serveur
	 * En extrait les params avec "&" et les fous dans un hashmap
	 * */
    Map<String, String> result = new HashMap<>();
    if (qs == null)
        return result;

    int last = 0, next, l = qs.length();
    while (last < l) {
        next = qs.indexOf('&', last);
        if (next == -1)
            next = l;

        if (next > last) {
            int eqPos = qs.indexOf('=', last);
            try {
                if (eqPos < 0 || eqPos > next)
                    result.put(URLDecoder.decode(qs.substring(last, next), "utf-8"), "");
                else
                    result.put(URLDecoder.decode(qs.substring(last, eqPos), "utf-8"), URLDecoder.decode(qs.substring(eqPos + 1, next), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e); // will never happen, utf-8 support is mandatory for java
            }
        }
        last = next + 1;
    }
    return result;
}
    
}



