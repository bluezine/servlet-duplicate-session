package kr.co.bluezine.duplicate.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Duplicate Session Listener
 * @author Kisig Ian Seo
 */
public class DuplicateSessionListener implements HttpSessionListener, HttpSessionAttributeListener
{
	private static int mode = DuplicateSessionCode.EXIST_BLOCK;
	public static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		// Nothing
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		HttpSession session = se.getSession();
		if (session.getAttribute(DuplicateSessionCode.SESSION_IDENTITY_KEY) != null)
		{
			if (session.getAttribute("block") == null)
				sessions.remove(session.getAttribute(DuplicateSessionCode.SESSION_IDENTITY_KEY));
		}
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event)
	{
		HttpSession session = event.getSession();
		String sessionName = event.getName();

		if (sessionName.equals(DuplicateSessionCode.SESSION_IDENTITY_KEY))
		{
			String sessionValue = (String) event.getValue();
			if (sessions.containsKey(sessionValue))
			{
				if (mode == DuplicateSessionCode.EXIST_BLOCK)
				{
					sessions.get(sessionValue).invalidate();
					sessions.put(sessionValue, session);
				}
				else if (mode == DuplicateSessionCode.NOT_EXIST_BLOCK)
				{
					session.setAttribute("block", true);
					session.invalidate();
				}
			}
			else
			{
				sessions.put(sessionValue, session);
			}
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event)
	{

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event)
	{

	}
}
