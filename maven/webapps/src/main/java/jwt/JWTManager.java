package jwt;

import java.util.Date;

import org.jboss.logging.Logger;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class JWTManager {

	private static final JWSAlgorithm algorithm = JWSAlgorithm.HS256;
	private static final String issuer = "webapp";
	private static final TemporalAmount TOKEN_VALIDITY = Duration.ofHours(4L);
	private static final Logger logger = Logger.getLogger(JWTFilter.class);

	private final byte[] sharedKey = null;
	private static JWTManager instance;

	private JWTManager() {
		generateSharedKey();
	}

	public String createToken(Long id) {
		try {
			MACSigner signer = new MACSigner(new byte[32]);
			JWTClaimsSet set = new JWTClaimsSet.Builder().issuer(issuer).expirationTime(getExpirationPeriod())
					.claim("id", id).build();
			SignedJWT sign = new SignedJWT(new JWSHeader(algorithm), set);
			sign.sign(signer);
			return sign.serialize();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public boolean verifyToken(String token) {
		try {
			SignedJWT sign = SignedJWT.parse(token);
			JWSVerifier verifier = new MACVerifier(sharedKey);
			Date expiryDate = (Date) sign.getJWTClaimsSet().getExpirationTime();
			if (sign.verify(verifier) && expiryDate.before(new Date())) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	private Date getExpirationPeriod() {
		Instant now = Instant.now();
		Date expiryDate = Date.from(now.plus(TOKEN_VALIDITY));
		return expiryDate;
	}

	private void generateSharedKey() {
		SecureRandom random = new SecureRandom();
		random.nextBytes(sharedKey);
	}

	public static JWTManager getInstance() {
		if (instance == null) {
			synchronized (JWTManager.class) {
				if (instance == null)
					instance = new JWTManager();
			}
		}
		return instance;
	}
}
