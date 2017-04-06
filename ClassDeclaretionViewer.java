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
            System.out.println("û���ҵ����࣡");
        }
        System.out.println("���ı�׼���ƣ�" + clazz.getCanonicalName());
        System.out.println("�������η���" + Modifier.toString(clazz.getModifiers()));

        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("���ķ��Ͳ�����");
        if(typeVariables.length != 0){
            for(TypeVariable<?> typeVariable :typeVariables){
                System.out.println(typeVariable + "\t");
            }
        }else{
            System.out.println("��");
        }

        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.println("����ʵ�ֵĽӿڣ�");
        if(interfaces.length != 0){
            for(Type type : interfaces){
                System.out.println("\t" + type);
            }
        }else{
            System.out.println("��");
        }

        Type superClass = clazz.getGenericSuperclass();
        System.out.print("����ֱ�Ӽ̳��ࣺ");
        if(superClass != null){
            System.out.println(superClass);
        }else{
            System.out.println("��");
        }

        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("����ע�⣺");
        if(annotations.length != 0){
            for(Annotation annotation : annotations){
                System.out.println("\t" + annotation);
            }
        }else{
            System.out.println("��");
        }
    }
}