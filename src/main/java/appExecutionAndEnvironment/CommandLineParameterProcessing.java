package appExecutionAndEnvironment;

public class CommandLineParameterProcessing {

    //We can pass command line arguments which can be accessed by the String array 'args'
    public static void main(String[] args) {

        if(args.length<1){
            System.out.println("No arguments provided");
        }
        else {
            for(String word: args)
                System.out.println(word);
        }

    }

}
