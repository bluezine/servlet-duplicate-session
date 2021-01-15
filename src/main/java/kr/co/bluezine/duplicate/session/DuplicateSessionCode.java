package kr.co.bluezine.duplicate.session;

/**
 * Duplicate Session Code
 * @author Kisig Ian Seo
 */
public class DuplicateSessionCode
{

	/**
	 * Existing user session invalidate
	 * <p>
	 * 1 - Logged (User:A) => 1 - Login (User:B) => A User invalidate
	 */
	public static final int EXIST_BLOCK = 0;

	/**
	 * Not existing user session invalidate
	 * <p>
	 * 1 - Logged (User:A) => 1 - Login (User:B) => B User invalidate
	 */
	public static final int NOT_EXIST_BLOCK = 1;

	/**
	 * Session Identity Key
	 */
	public static final String SESSION_IDENTITY_KEY = "id";
}
