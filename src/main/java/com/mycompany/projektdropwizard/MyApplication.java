package com.mycompany.projektdropwizard;

import io.dropwizard.views.ViewBundle;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Hlavna spustacia trieda programu Registracia vsetkych resources
 *
 * @author Mato&Pato&Niko
 */
public class MyApplication extends Application<MyConfiguration> {

    /**
     * Session factory
     */
    public static SessionFactory buildSessionFactory;
    /**
     * Spustacie argumenty
     */
    static String[] myargs = new String[2];

    /**
     * Spustacia metoda programu
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        myargs[0] = "server";
       myargs[1] = "C:\\Users\\Mato\\Desktop\\ProjektDropWizard\\src\\main\\java\\com\\mycompany\\projektdropwizard\\configuration.yml";
        org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration();
        conf.configure();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        buildSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        //new MyApplication().run(args);
        new MyApplication().run(myargs);

    }

    @Override
    public String getName() {
        return "my-conf";
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<MyConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(MyConfiguration configuration) {

                return super.getViewConfiguration(configuration); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     * Konfiguracia dropwizard. Registracia resources
     *
     * @param configuration
     * @param environment
     * @throws Exception
     */
    @Override
    public void run(MyConfiguration configuration, Environment environment) throws Exception {
        final DevicesResource resource = new DevicesResource((configuration.getName()), configuration.getIP());
        final DataResource resourceData = new DataResource((configuration.getDevice()), configuration.getDate(), configuration.getData(), configuration.getData());
        final UserResource resourceUser = new UserResource((configuration.getDevice()), configuration.getDate());

        final DevicesResource resourceDevice = new DevicesResource((configuration.getDevice()), configuration.getDate());

        final HtmlResource html = new HtmlResource();
        final HtmlIndexResource htmlIndex = new HtmlIndexResource();
        final HtmlDeviceResource htmlDevices = new HtmlDeviceResource();
        final HtmlDataResource htmlData = new HtmlDataResource();
        final HtmlUserResource htmlUser = new HtmlUserResource();
        final HtmlSensorResource htmlSensor = new HtmlSensorResource();

        final TemplateHealthCheck healthCheck
                = new TemplateHealthCheck(configuration.getName());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(resourceData);
        environment.jersey().register(resourceUser);
        environment.jersey().register(resourceDevice);

        environment.jersey().register(html);
        environment.jersey().register(htmlIndex);
        environment.jersey().register(htmlData);
        environment.jersey().register(htmlDevices);
        environment.jersey().register(htmlUser);
        environment.jersey().register(htmlSensor);

        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new BasicAuth())
                .setAuthorizer(new BasicAuthorizer())
                .setRealm("LOGIN")
                .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));

    }

}
