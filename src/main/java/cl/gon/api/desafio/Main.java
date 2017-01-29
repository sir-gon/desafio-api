package cl.gon.api.desafio;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ext.ContextResolver;



/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
      try {
          System.out.println("JSON with MOXy Jersey Example App");

          final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), createApp());
          Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
              @Override
              public void run() {
                  server.shutdownNow();
              }
          }));
          server.start();

          System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

          Thread.currentThread().join();

          return server;
      } catch (IOException | InterruptedException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }

      return null;
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
    }

    public static ResourceConfig createApp() {
        return new ResourceConfig()
                .packages("cl.gon.api.desafio")
                .register(createMoxyJsonResolver());
    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
      final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
      Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
      namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
      moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
      return moxyJsonConfig.resolver();
  }
}
