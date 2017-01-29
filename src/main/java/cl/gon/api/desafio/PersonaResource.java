/*
 * @author Gonzalo Diaz <devel@gon.cl>
 */

package cl.gon.api.desafio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persona")
public class PersonaResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persona calcularEdad(Persona p) {
        return p.calcularEdad(p.fechaNacimiento);
    }

}
