package de.whs.ni37900.fpr.praktikum.sheet4.aufgabe1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ClassDescriber {
    public static void main(String[] args) {
        new ClassDescriber().describeSTDInOut();
    }

    public void describeSTDInOut() {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(describeNamed(scanner.next()));
        scanner.close();
    }

    public String describeNamed(final String name) {
        try {
            return describeClass(Class.forName(name));
        } catch (ClassNotFoundException e) {
            return String.format("Class %s not found!%n", name);
        }
    }

    public String describeClass(final Class toDescribe) {
        return String.format("class %s %s{%n%s%n%s%n%s}%n", toDescribe.getName(), describeSuper(toDescribe), describeFields(toDescribe), describeConstructors(toDescribe), describeMethods(toDescribe));
    }

    public String describeSuper(final Class toDescribe) {
        Class superclass = toDescribe.getSuperclass();
        if (superclass == null || superclass.equals(Object.class)) {
            return "";
        }
        return String.format("extends %s ", superclass.getName());
    }

    public String describeFields(final Class toDescribe) {
        StringBuilder sb = new StringBuilder();
        for (Field field : toDescribe.getDeclaredFields()) {
            sb.append("\t");
            sb.append(describeField(field));
        }

        return sb.toString();
    }

    private String describeField(final Field toDescribe) {
        return String.format("%s%s %s;%n", describeModifiers(toDescribe.getModifiers()), toDescribe.getType().getName(), toDescribe.getName());
    }

    public String describeConstructors(final Class toDescribe) {
        StringBuilder sb = new StringBuilder();
        for (Constructor constructor : toDescribe.getDeclaredConstructors()) {
            sb.append("\t");
            sb.append(describeConstructor(constructor));
        }

        return sb.toString();
    }

    private String describeConstructor(final Constructor toDescribe) {
        return String.format("%s%s(%s);%n", describeModifiers(toDescribe.getModifiers()), toDescribe.getName(), describeParameters(toDescribe.getParameterTypes()));
    }

    public String describeMethods(final Class toDescribe) {
        StringBuilder sb = new StringBuilder();
        for (Method method : toDescribe.getMethods()) {
            sb.append("\t");
            sb.append(describeMethod(method));
        }

        return sb.toString();
    }

    private String describeMethod(final Method toDescribe) {
        return String.format("%s%s %s(%s);%n", describeModifiers(toDescribe.getModifiers()), toDescribe.getReturnType().getName(), toDescribe.getName(), describeParameters(toDescribe.getParameterTypes()));
    }

    private String describeParameters(final Class[] toDescribe) {
        return String.join(" ", Arrays.stream(toDescribe).map(Class::getName).toArray(String[]::new));
    }

    private String describeModifiers(final int toDescribe) {
        StringBuilder sb = new StringBuilder();
        for (NamedModifier namedModifier : NamedModifier.ordered) {
            if ((namedModifier.value & toDescribe) != 0) {
                sb.append(namedModifier.name);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private record NamedModifier(int value, String name) {
        static final NamedModifier[] ordered = new NamedModifier[]{new NamedModifier(Modifier.PUBLIC, "public"), new NamedModifier(Modifier.PRIVATE, "private"), new NamedModifier(Modifier.PROTECTED, "protected"), new NamedModifier(Modifier.STATIC, "static"), new NamedModifier(Modifier.ABSTRACT, "abstract"), new NamedModifier(Modifier.INTERFACE, "interface"), new NamedModifier(Modifier.FINAL, "final"), new NamedModifier(Modifier.NATIVE, "native"), new NamedModifier(Modifier.STRICT, "strict"), new NamedModifier(Modifier.SYNCHRONIZED, "synchronized"), new NamedModifier(Modifier.TRANSIENT, "transient"), new NamedModifier(Modifier.VOLATILE, "volatile"),};
    }
}
