import jakarta.servlet.AsyncContext;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import java.io.IOException;

public class ReadingListener implements ReadListener {
    private ServletInputStream input = null; 
    private AsyncContext ac = null; 
    public ReadingListener(ServletInputStream in, AsyncContext c) {
        input = in; 
        ac = c; 
    }
     @Override 
    public void onDataAvailable() throws IOException { 
    } 
    @Override
    public void onAllDataRead() throws IOException 
    {  
        ac.complete(); 
    } 
    @Override
    public void onError(final Throwable t) 
    {  
        ac.complete(); 
        
    }
    
}
