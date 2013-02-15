package webservice;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;


/**
 * @author Vanc Levstik
 * 
 * Webservice JAX-RS class
 */
public class ReconWSApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ReconWSResource.class);
        return classes;
    }
}