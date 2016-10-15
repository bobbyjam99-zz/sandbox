package org.bobbyjam;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextModeTest {


    @Test
    public void simpleText() {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.TEXT);
        resolver.setSuffix(".txt");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        Map<String, Object> params = new HashMap<>();
        params.put("name", "bobbyjam99");
        final IContext context = new Context(Locale.getDefault(), params);

        assertThat(engine.process("hello", context), is("Hello World bobbyjam99!"));
    }

    @Test
    public void stringTemplateResolver() {

        StringTemplateResolver resolver = new StringTemplateResolver();
        resolver.setTemplateMode(TemplateMode.TEXT);
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        Map<String, Object> params = new HashMap<>();
        params.put("name", "bobbyjam99");
        final IContext context = new Context(Locale.getDefault(), params);

        assertThat(engine.process("Hello World [(${name})]!", context), is("Hello World bobbyjam99!"));
    }
}
