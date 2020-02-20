import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class JsonService {
    private String apikey;

    public void init(){
        try {
            URLConnection connection = new URL("urk").openConnection();
            InputStream is = connection.getInputStream();
        }catch (Exception e){
            return;
        }
    }


}