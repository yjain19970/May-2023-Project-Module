import httpClient.Client;
import rest.RestClient;
import rest.exception.RetrofitClientException;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, RetrofitClientException {

        if( args.length == 0 || args.length >1 ){
            throw new IllegalArgumentException("Wrong number of args passed");
        }

        Client c = new Client();
        String value = args[0];
        switch (value) {
            case "print":
                System.out.println("Hello world!");
                break;
            case "http":
                try{
                    RestClient restClient = new RestClient();
                    var apiResponse =  restClient
                            .getJsonPlaceHolderAPI()
                            .getPhotos().execute();
                    apiResponse.body().forEach(photo -> {
                        System.out.println(photo.getUrl() + "\n");
                    });
                } catch(Exception e){
                    // log any thing, you can here
                    throw new RetrofitClientException("Exception");
                }


        }

    }
}

/**
 *
 *
 *
 * Question: JSONPlaceholder typicode API, /photos (GET ---> REST )
 *  --> from your Java code you need to call that API, and parse the response.
 *  --> you should have proper model which adheres to the response of /photos
 *
 *
 *  Requirements: The code should be modular, can use design patters  (if required)
 *  Should be very very easy, not have much complexities involved
 *
 *  submissions: /rest
 *                  / models --> have the model there
 *           As a interviewer, I can pass any argument to your code and on the basis if arg, you should
 *           decide whether to call JSONPlaceholder OR NOT.
 *
 *
 *
 *
 * -------------------------------------------------------------------
 *
 * Assignment:2
 *
 * you want to use retrofit  + gson
 * you need to download all the photos to their dedicated albums
 *
 * download the photos and save the photos in their respective albums (create albums as direct.)
 * --> just save 2 photos in each album :: 50 photos, 50%1 50%2 ; save --those photos only in your albums
 *
 *
 *
 *
 *  output:
 *    1:
 *      photo1
 *      photo2
 *   2:
 *      photo51
 *      photo52
 *   .
 *   .
 *   .
 *   .
 *   .
 *
 *
 *
 * Submission:
 * same way, create a repo, share the URL on the google form
 *
 *
 *
 *
 *
 *
 *
 */