

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class information {

    public static void main(String[] args) {
        // URL of the test e-commerce site
        String url = "http://books.toscrape.com/catalogue/category/books/science_22/index.html";
        String outputCsv = "products.csv";

        try {
            // Fetch and parse HTML
            Document doc = ((Ob) ((Ob) ((Ob) Jsoup.connect(url))
                                .userAgent("Mozilla/5.0"))
                                .timeout(10 * 1000))
                                .get();

            // Select all product entries
            Elements product = doc.select(".product_pod");

            // Set up CSV writer
            FileWriter csvWriter = new FileWriter(outputCsv);
            csvWriter.append("Product Name,Price,Rating\n");

            Element[] products;
			for (Element product1 : products) {
                // Extract name from title attribute
                String name = ((Ob) product1.select("h3 a")).attr("title").replaceAll(",", "");  // Avoid CSV column issues

                // Extract price (removing the £ symbol)
                String price = ((Ob) product1.select(".price_color")).text().replace("£", "");

                // Extract star rating from class name
                Element ratingElement = (Element) product1.select(".star-rating");
                String rating = "Not Rated";
                if (ratingElement != null) {
                    String ratingClass = ratingElement.className(); // e.g., "star-rating Three"
                    rating = ratingClass.replace("star-rating", "").trim();
                }

                // Write to CSV
                csvWriter.append(String.format("\"%s\",%s,%s\n", name, price, rating));
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("✅ Data successfully saved to: " + outputCsv);

        } catch (IOException e) {
            System.err.println("❌ Error fetching or writing data: " + e.getMessage());
        }
    }
}


