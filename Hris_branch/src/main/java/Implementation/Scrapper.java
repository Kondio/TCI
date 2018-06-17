package Implementation;
import Entities.Item;
import Entities.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This Scrapper class offers
 * data extraction from the web pages
 * provided from the Crawler it holds
 * <p></p>
 * @author: Filip Zamfirov
 * @since 2018-06-11
 */
public class Scrapper {


    private WebCrawler webCrawler;
    private ArrayList<Document> objectsToScrape;


    public Scrapper(String baseUrl) throws IOException {
        this.webCrawler= new WebCrawler(baseUrl);
        //It is important to craw through the website first!
        webCrawler.craw();
        objectsToScrape = webCrawler.getHTMLFromLink();
    }

    /**
     *The method ScrapeInformation scrapes information for all the Items in the links found by the crawler
     * @return The method returns a ArrayList containing Entities of Movies,Books and Music
     * @throws IOException
     */
    public ArrayList<Item> ScrapeInformation() throws IOException {
        ArrayList<Item> result = new ArrayList<Item>();

        for(Document temp:objectsToScrape){

            //Skip all the non-Item pages
            if(temp.location().contains("details")){
                Element innerHTML = temp.body().getElementsByClass("media-details").first();
                String objname = innerHTML.select("h1").first().text();
                ArrayList<Element> tablesElements = innerHTML.select("table").first().select("tr");


                String elementName = tablesElements.get(0).select("th").first().text();
                String elementContent = tablesElements.get(0).select("td").first().text();
                Item item=null;

                if(elementName.equals("Category") && elementContent.equals("Music")){
                    item = new Music();
                    item.setName(objname);
                }
                //TODO other types

                for (int y=1;y<tablesElements.size();y++){
                    elementName = tablesElements.get(y).select("th").first().text();
                    elementContent = tablesElements.get(y).select("td").first().text();
                    if(item instanceof Music){
                        switch (elementName){
                            case "Genre":
                                item.setGenre(elementContent);
                                break;
                            case "Format":
                                item.setFormat(elementContent);
                                break;
                            case "Year":
                                item.setYear(Integer.parseInt(elementContent));
                                break;
                            case "Artist":
                                ((Music) item).setArtist(elementContent);
                                break;
                        }
                    }
                }
                result.add(item);
            }
        }
        return result;
            }

    /**
     * This method provides Scraping functionality for a specific Item
     * @param Name is the String name of a singular item
     * @return the Item Entity found from the Name parameter
     * @throws IOException
     */
    public Item ScrapeInformationFromName(String Name) throws IOException {

        for(Document temp:objectsToScrape){
            //Skip all the non-Item pages
            if(temp.location().contains("details")){
                Element innerHTML = temp.body().getElementsByClass("media-details").first();
                String objname = innerHTML.select("h1").first().text();
                ArrayList<Element> tablesElements = innerHTML.select("table").first().select("tr");

            if(objname.equals(Name)){

                String elementName = tablesElements.get(0).select("th").first().text();
                String elementContent = tablesElements.get(0).select("td").first().text();
                Item item=null;

                if(elementName.equals("Category") && elementContent.equals("Music")){
                    item = new Music();
                    item.setName(objname);
                }
                //TODO other types

                for (int y=1;y<tablesElements.size();y++){
                    elementName = tablesElements.get(y).select("th").first().text();
                    elementContent = tablesElements.get(y).select("td").first().text();
                    if(item instanceof Music){
                        switch (elementName){
                            case "Genre":
                                item.setGenre(elementContent);
                                break;
                            case "Format":
                                item.setFormat(elementContent);
                                break;
                            case "Year":
                                item.setYear(Integer.parseInt(elementContent));
                                break;
                            case "Artist":
                                ((Music) item).setArtist(elementContent);
                                break;
                        }
                    }
                }
                return item;
            }
        }
    }
        return null;
}
}
