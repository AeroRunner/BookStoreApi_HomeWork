package configs.web_configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${host}.properties"})

public interface BrowserDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browserName();

    @Key("version")
    @DefaultValue("113")
    String browserVersion();

    @Key("remoteWebDriver")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    String remoteWebDriver();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();


}
