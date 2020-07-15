package pl.byteit.mbankscraper.operation.mbank.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

class StartSecondFactorAuthenticationRequest {

	private static final String SCA_AUTHORIZATION_DISPOSABLE_URL = "sca/authorization/disposable";

	@JsonProperty("Data")
	private final SecondFactorAuthenticationIdentifier secondFactorAuthenticationIdentifier;

	@JsonProperty("Method")
	private final String method;

	@JsonProperty("Url")
	private final String url;

	private StartSecondFactorAuthenticationRequest(SecondFactorAuthenticationIdentifier identifier, String method, String url) {
		this.secondFactorAuthenticationIdentifier = identifier;
		this.method = method;
		this.url = url;
	}

	static StartSecondFactorAuthenticationRequest withId(SecondFactorAuthenticationIdentifier identifier) {
		return new StartSecondFactorAuthenticationRequest(identifier, "POST", SCA_AUTHORIZATION_DISPOSABLE_URL);
	}

}
