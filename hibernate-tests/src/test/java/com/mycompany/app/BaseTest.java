package com.mycompany.app;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.mycompany.app.datasource.sql.QueryCountInfo;
import com.mycompany.app.datasource.sql.QueryCountInfoHolder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TestExecutionListeners({
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class
})
public abstract class BaseTest {

    @AfterClass
    public static void after() {
        QueryCountInfo queryInfo = QueryCountInfoHolder.getQueryInfo();
        System.out.println("");
        System.out.println("###SQL COUNT " + queryInfo.countAll() + " ###");
    }
}
