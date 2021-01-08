package ioc;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class MyTest {
  public static void main(String[] args) {
      UserController userController = new UserController();
      Field[] fields = userController.getClass().getDeclaredFields();
      Stream.of(fields).forEach(field -> {
          Autowired autowired = field.getAnnotation(Autowired.class);
          if(autowired != null){
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
    System.out.println(userController.getUserService());
  }
}
