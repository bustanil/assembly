package com.codequality.assembly;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {
        "classpath:com/codequality/assembly/spring/assembly-core.xml"
})
public abstract class BaseIntegrationTest extends AbstractJUnit4SpringContextTests {
}
