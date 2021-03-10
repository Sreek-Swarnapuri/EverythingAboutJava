package string;

public class StringBufferUsage {

    public static void main(String[] args) {

        //String Buffer is thread safe
        StringBuffer stringBuffer = new StringBuffer("Sreek");
        stringBuffer.append(" Swarnapuri");

        //Passing reference to another method for changing String buffer
        appendString(stringBuffer);

        //Replacing certain characters
        stringBuffer.replace(0,5,"Pandu");

        System.out.println(stringBuffer);
    }

    static void appendString(StringBuffer buffer) {
        buffer.append(" Pandadu");
    }

}
