package resolver;

import java.util.HashMap;
import org.omnifaces.util.Messages.Resolver;

public class MapFormatResolver implements Resolver {

    @Override
    public String getMessage(String string, Object... os) {
        HashMap params = (HashMap<String, String>) os[0];
        return MapFormat.format(string, params);
    }

}
