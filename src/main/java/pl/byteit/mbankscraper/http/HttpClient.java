package pl.byteit.mbankscraper.http;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.function.Function;

public interface HttpClient {

	RequestBuilder post(String url);

	RequestBuilder get(String url);

	interface RequestBuilder {
		RequestBuilder withJsonBody(Object body);

		RequestBuilder withHeader(Header header);

		RequestBuilder withResponsePreprocessor(Function<String, String> responsePreprocessor);

		void perform();

		<T> T perform(Class<T> responseType);

		<T> T perform(TypeReference<T> responseType);
	}
}
