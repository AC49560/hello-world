package fdsm_Mav101.a;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.tinylog.Level;
import org.tinylog.Logger;
import org.tinylog.format.PrintfStyleFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        long start = System.currentTimeMillis();
		long nstart = System.nanoTime();
		
	Instant istart = Instant.now();
	
	LocalDateTime ldtstart = LocalDateTime.now();

	
		Logger.debug("Program Started");	
		
		
		
		App.info("1Hello World!");
		App.printf("2Hello %s!", "World");
		
		
		 Logger.trace("Hello World!");
		 Logger.debug("Hello World!");
		 Logger.info("Hello World!");
		 Logger.warn("Hello World!");
		 Logger.error("Hello World!");
		 
		 int a = 5;
		 int b = 0;
		 
				
		 Logger.trace("Divide {} by {}", a, b);
		 Logger.debug("Divide {} by {}", a, b);
		 Logger.info("Divide {} by {}", a, b);
		 Logger.warn("Divide {} by {}", a, b);
		 Logger.error("Divide {} by {}", a, b);
		 
		 //int count = 0;
		 //int count = 1;
		 int count = 22;
		 
		 Logger.trace("There {0#are no files|1#is one file|1<are {} files}", count);
		 Logger.debug("There {0#are no files|1#is one file|1<are {} files}", count);
		 Logger.info("There {0#are no files|1#is one file|1<are {} files}", count);
		 Logger.warn("There {0#are no files|1#is one file|1<are {} files}", count);
		 Logger.error("There {0#are no files|1#is one file|1<are {} files}", count);
		 
		 
		 String value = "Some value";
		 
		 Logger.trace("Curly brackets as placeholder {} or escaped '{}'", value);
		 Logger.debug("Curly brackets as placeholder {} or escaped '{}'", value);
		 Logger.info("Curly brackets as placeholder {} or escaped '{}'", value);
		 Logger.warn("Curly brackets as placeholder {} or escaped '{}'", value);
		 Logger.error("Curly brackets as placeholder {} or escaped '{}'", value);
		 
		 Logger.trace(LocalDate.now());
		 Logger.debug(LocalDate.now());
		 Logger.info(LocalDate.now());
		 Logger.warn(LocalDate.now());
		 Logger.error(LocalDate.now());
		 
		 Logger.trace(LocalTime.now());
		 Logger.debug(LocalTime.now());
		 Logger.info(LocalTime.now());
		 Logger.warn(LocalTime.now());
		 Logger.error(LocalTime.now());
		 
		 
		 Logger.tag("Parallprocess").trace("sys Hello World!");
		 Logger.tag("SYSTEM").debug("sys Hello World!");
		 Logger.tag("SYSTEM").info("sys Hello World!");
		 Logger.tag("SYSTEM").warn("sys Hello World!");
		 Logger.tag("SYSTEM").error("sysHello World!");
		 
		 long end = System.currentTimeMillis();
		 
		 long elapsedTime = end - start;
		 
		 Logger.debug("Program Finished. Elapsed Time was: " + elapsedTime + " MillSeconds.");
		 long nend = System.nanoTime();
		 long nelapsedTime = nend - nstart;
		 
		 Logger.debug("Program Finished. Elapsed Time was: " + nelapsedTime + " NanoSeconds.");
		 
		 Instant iend = Instant.now();
		 Duration timeElapsed = Duration.between(istart, iend);
		 
		 
		 Logger.debug("Program Finished. Elapsed Time was: " +  timeElapsed.toMillis() +" MilliSeconds" );
		
		 
		 LocalDateTime ldtend = LocalDateTime.now();
		 

		 long ldtelapsed = ChronoUnit.HOURS.between(ldtstart, ldtend);
		 
		 
		 String localDateString = Duration.between(ldtstart, ldtend).toString();
		 
		 Logger.debug("Program Finished. Elapsed Time was: " +  ldtelapsed );
		 Logger.debug("Program Finished. Elapsed Time was: " +  localDateString );

        
    }
    
    private static final LoggingProvider provider = ProviderRegistry.getLoggingProvider();

    // Example: MyLogger.info("Hello World!")
    public static void info(String message) {
        provider.log(
            2,          // depth in stack trace
            null,       // optional tag
            Level.INFO, // severity level
            null,       // exception or any other kind of throwable
            null,       // message formatter for arguments
            message     // message to log
        );
    }

    // Example: MyLogger.printf("Hello %s!", "World")
    public static void printf(String message, Object... arguments) {
        PrintfStyleFormatter formatter = new PrintfStyleFormatter(Locale.ENGLISH);
        provider.log(2, null, Level.INFO, null, formatter, message, arguments);
    }

    // Example: MyLogger.error(ex)
    public static void error(Throwable exception) {
        provider.log(2, null, Level.ERROR, exception, null, null);
    }

}
