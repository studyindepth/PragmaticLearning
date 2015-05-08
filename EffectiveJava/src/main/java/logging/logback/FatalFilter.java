package logging.logback;

import java.util.Arrays;

import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.MarkerFilter;
import ch.qos.logback.core.spi.FilterReply;

public class FatalFilter extends MarkerFilter {

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        System.out.println(logger);
        System.out.println(marker);
        System.out.println(format);
        System.out.println(level);
        System.out.println(Arrays.toString(params));
        System.out.println(t);
        return super.decide(marker, logger, level, format, params, t);
    }
}
