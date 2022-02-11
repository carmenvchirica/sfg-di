package ch.springframework.sfgdi.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("I'm in the LifeCycleDemoBean constructor!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - destroy()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware - setBeanName(). My bean name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware - setBeanFactory() ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware - setApplicationContext(): " + applicationContext.getBeanDefinitionNames());

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("#PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("#PreDestroy");
    }

    public void beforeInit() {
        System.out.println("#beforeInit");
    }

    public void afterInit() {
        System.out.println("#afterInit");
    }


}
