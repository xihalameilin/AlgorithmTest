# IOC

- 核心是反射，通过反射给注入

```java
public class UserController {
    @Autowired
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
}


UserController userController = new UserController();
      Field[] fields = userController.getClass().getDeclaredFields();
      Stream.of(fields).forEach(field -> {
          Autowired autowired = field.getAnnotation(Autowired.class);
          if(autowired != null){
              //设置访问权限?
              field.setAccessible(true);
              Class<?> type = field.getType();
              try {
                  Object o = type.newInstance();
                  field.set(userController,o);
              } catch (InstantiationException e) {
                  e.printStackTrace();
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
              }

          }
      });
```

![image-20210107201103124](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20210107201103124.png)

- 定义`bean`信息可以有`xml`、注解等形式，所以要有统一的读取工具`BeanDefinitionReader`

- `BeanDefinition` ->`BeanFactory` ->`map`存放实例化对象

- `spring`生态的扩展性在上述流程之间增加了处理器（增强器）`BeanFactoryPostProcessor`

  与`BeanPostProcessor`,`springboot`的自动装配就是处理器完成的

  ```java
  public interface BeanPostProcessor {
      //先实例化再初始化
      @Nullable
      default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
          return bean;
      }
  
      @Nullable
      default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
          return bean;
      }
  }
  
  ```

  ![image-20210107204357322](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20210107204357322.png)

- `FactoryBean`：创建复杂对象

- `Environment`系统属性与环境

- 观察者模式，一系列的监听器，用来完成在不同阶段的的不同处理工作

- `refresh`方法，在`AbstractApplicationContext`里面

  ```java
  public void refresh() throws BeansException, IllegalStateException {
          synchronized(this.startupShutdownMonitor) {
              this.prepareRefresh();//准备工作
              ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
              //准备BeanFactory
              // DefaultListableBeanFactory
              //loadBeanDefinitions(beanFactory )把definition读到factory
              
              
              this.prepareBeanFactory(beanFactory);
              //准备工厂一些参数
  
              try {
                  this.postProcessBeanFactory(beanFactory);
                  //默认空的
                  
                  this.invokeBeanFactoryPostProcessors(beanFactory);
                  //实例化并执行所有注册的BeanFactroyPostProcessor beans
                  
                  this.registerBeanPostProcessors(beanFactory);
                  //实例化并注册所有BeanPostProcessor beans
                  
                  this.initMessageSource();
                  //国际化处理
                  
                  this.initApplicationEventMulticaster();
                  //初始化广播器（多播器）
                  
                  this.onRefresh();
                  //空的
                  
                  this.registerListeners();
                  //注册监听器到多播器
                  
                  this.finishBeanFactoryInitialization(beanFactory);
                  //实例化
                  //beanFactory.preInstantiateSingletons()
                  
                  this.finishRefresh();
                  //清场
              } catch (BeansException var9) {
                  if (this.logger.isWarnEnabled()) {
                      this.logger.warn("Exception encountered during context initialization - cancelling refresh attempt: " + var9);
                  }
  
                  this.destroyBeans();
                  this.cancelRefresh(var9);
                  throw var9;
              } finally {
                  this.resetCommonCaches();
              }
  
          }
      }
  
  ```

  