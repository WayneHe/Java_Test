import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.Type;
public class ClassDeclaretionViewer{
    public static void main(String[] args){
        Class<?> clazz = null;
        try{
            clazz = Class.forName("java.util.ArrayList");
        }catch(ClassNotFoundException e){
            System.out.println("δ�ҵ����࣡");
        }
        ClassDeclaretionViewer classDeclaretionViewer = new ClassDeclaretionViewer();
        classDeclaretionViewer.showInit(clazz);
        classDeclaretionViewer.showTypeVariables(clazz);
        classDeclaretionViewer.showInterfaces(clazz);
        classDeclaretionViewer.showSuperClass(clazz);
        classDeclaretionViewer.showAnnotations(clazz);
    }

    public void showInit(Class<?> clazz){
        System.out.println("����Ϊ��\n\t" + clazz.getCanonicalName());
        System.out.println("������η���\n\t" + Modifier.toString(clazz.getModifiers()));
    }
    public void showTypeVariables(Class<?> clazz){
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("��ķ��Ͳ���Ϊ��\n");
        if(typeVariables.length != 0){
            for(TypeVariable<?> typeVariable :typeVariables){
                System.out.println("\t" + typeVariable);
            }
        }else{
            System.out.println("null");
        }
    }
    public void showInterfaces(Class<?> clazz){
        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.print("����ʵ�ֵĽӿ�Ϊ��\n");
        if(interfaces.length != 0){
            for(Type type : interfaces){
                System.out.println("\t" + type);
            }
        }else{
            System.out.println("null");
        }
    }

    public void showSuperClass(Class<?> clazz){
        Type superClass = clazz.getGenericSuperclass();
        System.out.print("���ֱ�Ӽ̳���Ϊ��\n\t");
        if(superClass != null){
            System.out.println(superClass);
        }else{
            System.out.println("null");
        }
    }

    public void showAnnotations(Class<?> clazz){
        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("���ע��Ϊ��\n\t");
        if(annotations.length != 0){
            for(Annotation annotation : annotations){
                System.out.println("\t" + annotation);
            }
        }else{
            System.out.println("null");
        }
    }
}