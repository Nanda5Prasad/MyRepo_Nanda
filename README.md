# Selenium Java Framework — IntelliJ IDEA

A Maven-based Selenium framework designed to run directly from IntelliJ IDEA or the command line.

## Open in IntelliJ IDEA

1. Install **JDK 17+** and IntelliJ IDEA.
2. Select **File → Open** and choose the repository folder.
3. Open `pom.xml` and select **Load Maven Project**.
4. Set **Project SDK** to JDK 17:
   - **File → Project Structure → Project → SDK**
   - Set **Language level** to 17.
5. Let IntelliJ import Maven dependencies.
6. Right-click `HomePageTest.java` and select **Run**.

No manual driver download is required. WebDriverManager resolves the browser driver automatically.

## Run from IntelliJ Maven panel

Open the Maven tool window, then run:

```text
Lifecycle → clean → test
```

To pass properties, use **Run → Edit Configurations → Maven** and set:

```text
clean test -Dbrowser=chrome -DbaseUrl=https://example.com -Dheadless=true
```

## Run from terminal

```bash
mvn clean test
```

## Supported properties

| Property | Default | Description |
|---|---|---|
| `browser` | `chrome` | `chrome`, `firefox`, or `edge` |
| `baseUrl` | `https://example.com` | Application URL |
| `headless` | `true` | Run without opening a browser window |

## Project structure

```text
src/main/java     framework code, configuration, driver factory, base pages
src/test/java     test base, page objects, test cases
pom.xml           Maven dependencies and test configuration
.editorconfig     consistent formatting in IntelliJ and other IDEs
```

The project follows Maven conventions, so IntelliJ automatically recognizes `src/main` as production code and `src/test` as test code.
