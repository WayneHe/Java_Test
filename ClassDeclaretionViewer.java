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
            System.out.println("请如下输入运行：");
            System.out.println("java ClassDeclaretionViewer ***");
            System.out.println("*** : 输入你要查找的类名（含包）");
            return;
        }
        for(String className : args){
            Class<?> clazz = null;
            try{
                clazz = Class.forName(className);
            }catch(ClassNotFoundException e){
                System.out.println("未找到该类！");
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
        System.out.println("包：\n\t" + clazz.getPackage());
        System.out.println("类名：\n\t" + clazz.getCanonicalName());
        System.out.println("类的修饰符：\n\t" + Modifier.toString(clazz.getModifiers()));
    }
    public void showTypeVariables(Class<?> clazz){
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("类的泛型参数：\n");
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
        System.out.println("类所实现的接口：");
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
        System.out.println("类的构造方法：");
        int construtorLeng = constructors.length;
        if(construtorLeng  == 0){
            System.out.println("该类无构造方法。");
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
        System.out.println("类的方法：");
        int methodLeng = methods.length;
        if(methodLeng == 0){
            System.out.print("该类未定义方法。");
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
        System.out.println("类的成员变量：");
        int fieldLeng = fields.length;
        if(fieldLeng == 0){
            System.out.println("该类未定义成员变量。");
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
        System.out.println("类的内部类：");
        int inClazzLeng = inClazz.length;
        if(inClazzLeng == 0){
            System.out.println("该类无内部类");
            return ;
        }
        if(inClazzLeng <= 5 ){
            for(Class iClass : inClazz){
                System.out.println("\t" + iClass.getCanonicalName());
            }
        }else{
            System.out.println("\t" + "内部类过多，共" + inClazzLeng +"个");
        }
    }

    public void showSuperClass(Class<?> clazz){
        Type superClass = clazz.getGenericSuperclass();
        System.out.print("类的直接继承类：\n\t");
        if(superClass != null){
            System.out.println(superClass);
        }else{
            System.out.println("null");
        }
    }

    public void showAnnotations(Class<?> clazz){
        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("类的注解：\n\t");
        if(annotations.length != 0){
            for(Annotation annotation : annotations){
                System.out.println("\t" + annotation);
            }
        }else{
            System.out.println("null");
        }
    }
}