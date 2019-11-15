package com.worldremit.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import static org.aeonbits.owner.Config.LoadType.MERGE;
import static org.aeonbits.owner.Config.Sources;

@Config.LoadPolicy(MERGE)
@Sources({"classpath:application.properties"})
public interface Configuration extends Config {
    Configuration CONFIGURATION = ConfigFactory.create(Configuration.class, System.getProperties(), System.getenv());

    @Key("host.url")
    String getHostUrl();

    @Key("browser.type")
    String getDriverBrowserType();

}
