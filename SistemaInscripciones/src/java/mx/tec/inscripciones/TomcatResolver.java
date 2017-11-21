package mx.tec.inscripciones;

import com.github.mustachejava.MustacheResolver;

import java.io.Reader;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

public class TomcatResolver implements MustacheResolver {
    private final ServletContext context;
    private final String rootDirectory;

    public TomcatResolver(ServletContext context, String rootDirectory) {
        this.context = context;
        this.rootDirectory = rootDirectory;
    }
    
    @Override
    public Reader getReader(String resName) {
        return new InputStreamReader(context.getResourceAsStream(rootDirectory + resName));
    }
}