import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.Type;
public class ClassDeclaretionViewer{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("�������������У�");
            System.out.println("java ClassDeclaretionViewer ***");
            System.out.println("*** : ������Ҫ���ҵ�������������");
            return;
        }
        for(String className : args){
            Class<?> clazz = null;
            try{
                clazz = Class.forName(className);
            }catch(ClassNotFoundException e){
                System.out.println("δ�ҵ����࣡");
            }
            ClassDeclaretionViewer.showAll(clazz);
        }
    }

    public static void showAll(Class<?> clazz){
        ClassDeclaretionViewer classViewer = null;
        classViewer = new ClassDeclaretionViewer();
        classViewer.showInit(clazz);
        classViewer.showTypeVariables(clazz);
        classViewer.showInterfaces(clazz);
        classViewer.showConstructors(clazz);
        classViewer.showMethods(clazz);
        classViewer.showFields(clazz);
        classViewer.showClass(clazz);
        classViewer.showSuperClass(clazz);
        classViewer.showAnnotations(clazz);
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
        for(Constructor constructor : constructors){
            System.out.print("\t" + Modifier.toString(constructor.getModifiers()) + 
                                " " + constructor.getName() + "(");
            Class[] iParametrer = constructor.getParameterTypes();
            int classLeng = iParametrer.length;
            for(int i=0; i<classLeng; i++){
                System.out.print(Modifier.toString(iParametrer[i].getModifiers()) + 
                                iParametrer[i].getName());
                if(i != classLeng-1){
                    System.out.print(" ; ");
                }
            }
            System.out.println(")");
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
        for(Method iMethod: methods){
            System.out.print("\t" + Modifier.toString(iMethod.getModifiers()) + 
                                " " + iMethod.getReturnType().getName() + " " +
                                iMethod.getName() + "(");
            Class[] iParametrer = iMethod.getParameterTypes();
            int classLeng = iParametrer.length;
            
            for(int i=0; i<classLeng; i++){
                System.out.print(Modifier.toString(iParametrer[i].getModifiers()) + 
                                iParametrer[i].getName());
                if(i != classLeng-1){
                    System.out.print(" ; ");
                }
            }
            System.out.println(")");
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
        for(Field iField: fields){
            System.out.println("\t" + Modifier.toString(iField.getModifiers()) +
                                " " + iField.getType() + " " + iField.getName() + 
                                ";");
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
        if(inClazzLeng <= 5 ){
            for(Class iClass : inClazz){
                System.out.println("\t" + iClass.getCanonicalName());
            }
        }else{
            System.out.println("\t" + "�ڲ�����࣬��" + inClazzLeng +"��");
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