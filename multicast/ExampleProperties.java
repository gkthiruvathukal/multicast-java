import java.io.*;
import java.util.*;

public class ExampleProperties {

  private static String fileName = "example.properties";

  public static ExampleProperties getExampleProperties() throws IOException {
    Properties defaults = new Properties();
    defaults.put("multicast-address","230.0.0.2");
    defaults.put("port","4447");
    Properties properties = new Properties(defaults);
    Reader r = new FileReader(fileName);
    properties.load(r);
    r.close();
    return new ExampleProperties(properties);
  }

  private Properties properties;

  public ExampleProperties(Properties properties) {
    this.properties = properties;
  }

  public int getPort() {
    return Integer.parseInt( properties.getProperty("port") );
  }

  public String getMulticastAddress() {
    return properties.getProperty("multicast-address");
  }

}
