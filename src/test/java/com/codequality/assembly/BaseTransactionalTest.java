package com.codequality.assembly;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public abstract class BaseTransactionalTest extends BaseIntegrationTest {
}
