#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ErrorMessageUtils {
    private static Config config;
    private static Config fileconfig;
    static{
        config = ConfigFactory.load("errmsg");
        fileconfig = ConfigFactory.parseFile(new File("/data/config/errmsg"));
        config = fileconfig.withFallback(config);
    }

    public static String getErrmsg(String key){
        return config.getString(key);
    }
}
