package configs.web_configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${host}.properties"})
public interface BrowserDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("FIREFOX")
    String getBrowserName();
    @Key("version")
    @DefaultValue("98")
    String getBrowserVersion();
    @Key("remote")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    String getRemoteWebDriver();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();


}
