package vladimir.savin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vladimir.savin.config.AppConfig;
import vladimir.savin.services.HtmlUniqueWordsHandler;
import vladimir.savin.services.UniqueWordsHandler;

/*This is the main class of the App.*/
public class UniqueWordsCounter {

    /*Method checks the amount of passed arguments and exits program with message if amount
    is less than 1 or greater than 2. Then it creates Spring Application context and launches
     the application logic.*/
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        if(args.length < 1 || args.length > 2) {

            System.out.println("Please specify URL and (optionally) directory to save file");

            System.exit(1);
        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UniqueWordsHandler handler = context.getBean("htmlUniqueWordsHandler", HtmlUniqueWordsHandler.class);

        String filePath = args.length == 2? args[1] : "";

        handler.saveAndCount(args[0], filePath);

    }
}
