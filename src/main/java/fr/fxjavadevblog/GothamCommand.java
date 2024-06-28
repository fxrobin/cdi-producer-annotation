package fr.fxjavadevblog;


import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@TopCommand
@Command(name = "greeting", mixinStandardHelpOptions = true)
@Slf4j
@QuarkusMain
@RequiredArgsConstructor
public class GothamCommand implements Runnable, QuarkusApplication {

    final CommandLine.IFactory factory; 

    final GothmanJustice gothamJustice;
     

    @Parameters(paramLabel = "<name>", defaultValue = "Java Apprentice", description = "Your name.")
    String name;

    @Override
    public void run() {
        log.info("Hello, {}!", name);
        log.info("gothamJustice: {}", gothamJustice);
    }

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this, factory).execute(args);
    }

}
