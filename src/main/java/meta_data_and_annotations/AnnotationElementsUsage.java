package meta_data_and_annotations;

import meta_data_and_annotations.customannotations.ClassTypeElement;
import meta_data_and_annotations.customannotations.DefaultElements;
import meta_data_and_annotations.customannotations.DirectAssignmentElement;


@DefaultElements
@DirectAssignmentElement("Added to Annotation element")
@ClassTypeElement(AccountWorker.class)
public class AnnotationElementsUsage {

    public static void main(String[] args) {
        Class<?> a = AnnotationElementsUsage.class;
        DefaultElements def = a.getAnnotation(DefaultElements.class);
        //Will be true as we have default value as true
        System.out.println("Default element value is : " + def.useDefault());

        DirectAssignmentElement dir = a.getAnnotation(DirectAssignmentElement.class);
        //As we assigned the value directly since the method is value() the output will be false
        System.out.println("Direct element value is : " + dir.value());

        ClassTypeElement cls = a.getAnnotation(ClassTypeElement.class);
        Class<?> awClass = cls.value();
        System.out.println("Element value retrieved from the Class type element is : " + awClass.getSimpleName());

    }

}
