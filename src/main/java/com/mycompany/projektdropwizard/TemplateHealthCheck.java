package com.mycompany.projektdropwizard;

import com.codahale.metrics.health.HealthCheck;

/**
 * Trieda kontroly spravnosti templatu
 *
 * @author Mato&Pato&Niko
 */
public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    /**
     * Konstruktor
     *
     * @param template
     */
    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    /**
     * Overenie
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
