package com;

import com.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Configuration
@EnableJpaRepositories
@EnableAspectJAutoProxy
@EnableAsync
public class Config {
    /*private ApplicationContext applicationContext;

    @Autowired
    public Config(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // C:\Program Files\Java\jdk-11.0.14\bin\jconsole.exe
    @PostConstruct
    public void initJMC() throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        SchedulerService sc = applicationContext.getBean(SchedulerService.class);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.service:type=SchedulerService");
        mbs.registerMBean(sc, name);
    }*/
}
