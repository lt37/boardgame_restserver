package fr.univtln.m2dapm.boardgame.restserver;

import com.google.gson.Gson;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.lang.invoke.MethodHandles;

/**
 * Hello world!
 */

@ApplicationPath("/rest")
public class App extends Application {
    @SuppressWarnings("unused")
    private static final Class[] shadeHack = {org.apache.log4j.RollingFileAppender.class,
            org.apache.log4j.ConsoleAppender.class,
            PatternLayout.class};

    //Set the logger with the real class name.
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        logger.info("App started.");
        logger.debug("About to talk :");
        System.out.println("Hello world !");
        Player player = new Player();
        player.setLoginName("boop");
        player.setEncryptedPassword("bap");
        String json = new Gson().toJson(player);
        System.out.println(json);
    }
}
