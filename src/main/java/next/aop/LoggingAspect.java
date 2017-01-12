package next.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 강홍구 on 2017-01-12.
 */

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("within(next.dao..*)")
    public void loggingForDao (JoinPoint jp) {
        Object[] args = jp.getArgs();

        for (Object arg : args ) {
            LOGGER.debug(arg + "");
        }
    }

}
