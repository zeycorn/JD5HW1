package Core;

import GoogleLogger.GLoggerManager;

public class GLoggerManagerAdapter implements LoggerService{

	@Override
	public void logToSystem(String message) {

		GLoggerManager manager = new GLoggerManager();
		manager.log(message);
	}

}
