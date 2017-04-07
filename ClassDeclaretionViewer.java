import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        classDeclaretionViewer.showConstructors(clazz);
        classDeclaretionViewer.showMethods(clazz);
        classDeclaretionViewer.showFields(clazz);
        classDeclaretionViewer.showClass(clazz);
        classDeclaretionViewer.showSuperClass(clazz);
        classDeclaretionViewer.showAnnotations(clazz);
    }

    public void showInit(Class<?> clazz){
        System.out.println("����\n\t" + clazz.getPackage());
        System.out.println("������\n\t" + clazz.getCanonicalName());
        System.out.println("������η���\n\t" + Modifier.toString(clazz.getModifiers()));
    }
    public void showTypeVariables(Class<?> clazz){
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("��ķ��Ͳ�����\n");
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
        System.out.println("����ʵ�ֵĽӿڣ�");
        if(interfaces.length != 0){
            for(Type type : interfaces){
                System.out.println("\t" + type);
            }
        }else{
            System.out.println("null");
        }
    }

    public void showConstructors(Class<?> clazz){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("��Ĺ��췽����");
        int construtorLeng = constructors.length;
        if(construtorLeng  == 0){
            System.out.println("�����޹��췽����");
            return ;
        }
    }
    public void showMethods(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("��ķ�����");
        int methodLeng = methods.length;
        if(methodLeng == 0){
            System.out.print("����δ���巽����");
            return ;
        }
    }
    public void showFields(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("��ĳ�Ա������");
        int fieldLeng = fields.length;
        if(fieldLeng == 0){
            System.out.println("����δ�����Ա������");
            return ;
        }
    }
    public void showClass(Class<?> clazz){
        Class[] inClazz = clazz.getDeclaredClasses();
        System.out.println("����ڲ��ࣺ");
        int inClazzLeng = inClazz.length;
        if(inClazzLeng == 0){
            System.out.println("�������ڲ���");
            return ;
        }
    }

    public void showSuperClass(Class<?> clazz){
        Type superClass = clazz.getGenericSuperclass();
        System.out.print("���ֱ�Ӽ̳��ࣺ\n\t");
        if(superClass != null){
            System.out.println(superClass);
        }else{
            System.out.println("null");
        }
    }

    public void showAnnotations(Class<?> clazz){
        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("���ע�⣺\n\t");
        if(annotations.length != 0){
            for(Annotation annotation : annotations){
                System.out.println("\t" + annotation);
            }
        }else{
            System.out.println("null");
        }
    }
}