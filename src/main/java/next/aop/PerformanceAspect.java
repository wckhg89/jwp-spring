package next.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by 강홍구 on 2017-01-12.
 */

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("within(next..*)")
    public Object checkPerformance (ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        // start stopwatch
        stopWatch.start();
        Object retVal = pjp.proceed();
        // stop stopwatch
        stopWatch.stop();
        LOGGER.debug("Execution Time : {}", stopWatch.toString());

        return retVal;

    }
}
