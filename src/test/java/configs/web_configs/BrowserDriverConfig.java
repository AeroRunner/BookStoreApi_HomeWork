package configs.web_configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${host}.properties"})

public interface BrowserDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String setBrowser();

    @Key("version")
    @DefaultValue("100")
    String browserVersion();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    String setRemoteUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String setBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();


}
