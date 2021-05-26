package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyAnnotation {
	@MethodDetails(comments = "This is an annotation message", date = "May 26, 2021")
	public void display() {
		System.out.println("Display");
	}
	
	public static void main(String[] args) {
        try{
            for(Method method : MyAnnotation.class.getMethods()){
                if(method.isAnnotationPresent(MethodDetails.class)){
                    try{
                        for(Annotation annotation : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method '" + method + "' :: " + annotation);
                        }
                        MethodDetails info = method.getAnnotation(MethodDetails.class);
                        if(info.revision() == 1){
                            System.out.println("Method with revision 1 :: " + method);
                        }
                    } catch ( Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        } catch(SecurityException e){
            e.printStackTrace();
        }
    }
}
