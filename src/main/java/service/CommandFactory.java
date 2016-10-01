package service;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory instance = new CommandFactory();
    private Map<String, Command> comMap = new HashMap<String, Command>();

    private CommandFactory() {
        comMap.put("login", new LoginCommand());
        comMap.put("registration", new RegistrationCommand());
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        return comMap.get(commandName);
    }
}
