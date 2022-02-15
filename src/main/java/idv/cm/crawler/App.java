package idv.cm.crawler;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import ptt.crawler.Reader;
import ptt.crawler.Reader.Callback;
import ptt.crawler.model.Article;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Reader reader = new Reader();
			articleAsync(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void test(Reader reader) {

		try {

			List<Article> result = reader.getList("Gossiping");
			final Gson gson = new Gson();

			for (final Article str : result) {
				reader.getBody(str, new Callback() {
					@Override
					public void succeeded(Article article) {
						gson.toJson(str);
					}

					@Override
					public void failed(Article article) {
						gson.toJson("no result");

					}
				});
//				str.setBody(bdoyContent);

			}
			System.out.println(gson);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	static void articleAsync(Reader reader) {
		try {
			List<Article> result = reader.getList("Gossiping");
			for (Article article : result) {
				reader.getBody(article, new Reader.Callback() {

					@Override
					public void succeeded(Article article) {
						System.out.println(Thread.currentThread().getId());
						System.out.println(article.getBody());

					}

					@Override
					public void failed(Article article) {
						System.out.println("failed");

					}
				});
			}

		} catch (IOException e) {

		} catch (ParseException e) {
			
		}
	}

}
