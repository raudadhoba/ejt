
package ejb;

import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;


@Singleton
@LocalBean
public class CountServletHitsBean {

    private int hitCount;

    public synchronized int getCount() {
        return hitCount++; // Return current count, then increment
    }
}
