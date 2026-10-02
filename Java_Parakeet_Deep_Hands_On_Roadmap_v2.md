# Java-Parakeet — Deep Hands-on Challenge Roadmap (Version 2)

**Total:** 644 numbered micro-challenges across 19 stages (preflight + 17 book chapters + optional extensions).  
**Primary source:** *Full Stack Development with Spring Boot 3 and React*, 4th ed., Juha Hinkula, uploaded as `Java.pdf`.  
**Your environment:** Windows, IntelliJ IDEA, Microsoft OpenJDK 21, Maven, `C:\Users\sabar\OneDrive\Desktop\Java_Practice`.  
**Remote checkpoint:** [Java-Parakeet](https://github.com/sabareeshrao/Java-Parakeet). **Previous remote inspection:** empty, no commits on October 1, 2026. This does **not** verify the contents of your local disk or any later push.  
**Important source distinction:** Chapters 1–17 and the Car/Owner full-stack application come from the uploaded book. Its original examples use Eclipse, Gradle, JDK 17, Spring Boot 3.1, React 18 and a 2023-era library ecosystem. IntelliJ, Maven, JDK 21, per-step break/fix drills, and Stage 18 are **our implementation choices**, not claims about the book. Check current compatibility at implementation time.  

## How to read and use this roadmap

- **Each checkbox is one observable developer action, investigation, or proof**, not an entire chapter disguised as a task. No checkmark is automatic. A concept exercise is passed by an explanation rooted in *your* code or visible logs.
- **Use this order:** inspect what is already there → understand why → type/edit yourself → run/test → trace source dependencies → break a safe example and repair it → commit a coherent milestone. Not every checkbox is a code change, and no one should introduce intentional failures to production systems.
- **Labels:** `[Inspect]` read existing code/config; `[Concept]` explain with concrete code; `[Build]` create/edit; `[Trace]` follow the real execution path; `[Verify]` prove an outcome; `[Break/fix]` use a temporary safe failure to learn diagnostics; `[Git checkpoint]` capture code/review evidence.
- **No fake progress:** GitHub verifies files, diffs, committed tests and CI; local terminal/IDE outcomes require a screenshot, pasted output or run log because remote code alone cannot prove execution.
- **No needless restarts:** do not regenerate your initial project or erase any local files; inspect before migrating the Maven model. `frontend/` joins the existing repo later.
- **No premature solution dumps:** when you ask for the next task, I should first give the challenge, motivation, precise IntelliJ location/files, outcome, 1–3 hints, and acceptance proof. Provide full working implementation only when requested or after your attempt.
- **One commit per coherent milestone**, not every checkbox. Before any status update, re-check the current GitHub `main` and last commits instead of trusting stale state.
- **Avoid historical dependency traps:** exact Spring Boot/Node/MUI/JWT/library versions from the book may be outdated; keep subject matter book-aligned while checking compatibility for your actual environment.

## Task naming

A micro-task has a stable ID such as `3.017` (Stage 3, 17th action). It will never mean "finished" until its evidence exists. A topic can involve a chain of files even when the action changes only one file. Gate verification closes the stage.

## Execution trace we will eventually build

```text
Browser → React component → typed API helper → HTTP request
                                      ↓
                             Spring Security / JWT
                                      ↓
                        Controller or Spring Data REST
                                      ↓
                              Service / Repository
                                      ↓
                            JPA / Hibernate / JDBC
                                      ↓
                                  MariaDB
```

The exact path depends on whether a request uses an explicit controller or a Spring Data REST export; we trace what is actually committed rather than assuming every arrow is used for every route.

---

## Stage 0 — Understand and preserve the existing project

**Scope:** Preflight (extra; before book Ch. 1). **Printed pages:** not in book.  
**Continuity:** `local Java_Practice` → `actual Maven model` → `working Java run` → `safe Git commit` → `remote main`.  

- [ ] **0.001** `[Inspect]` In IntelliJ choose File → Open and select the existing `C:\Users\sabar\OneDrive\Desktop\Java_Practice` folder, not a newly generated replacement.
- [ ] **0.002** `[Verify]` Verify the Project tool window shows the exact folder and whether `pom.xml` exists at its root.
- [ ] **0.003** `[Inspect]` Open IntelliJ Project Structure and record the selected SDK vendor and version; distinguish project SDK from module SDK.
- [ ] **0.004** `[Inspect]` Open the Maven tool window; determine whether IntelliJ imported the project as Maven or merely opened a directory.
- [ ] **0.005** `[Inspect]` Look for `src/main/java`, `src/test/java`, `src/main/resources`, and the existing entry-point class; record missing folders rather than inventing files.
- [ ] **0.006** `[Inspect]` Open `pom.xml` and locate `modelVersion`, `groupId`, `artifactId`, `version` and `packaging` if present.
- [ ] **0.007** `[Concept]` Explain how Maven coordinates identify a module and how Maven source folders differ from ordinary Java directories.
- [ ] **0.008** `[Inspect]` Locate any configured Java release/source/target setting in `pom.xml`; compare it with the project JDK.
- [ ] **0.009** `[Inspect]` Read the current dependency list and determine whether this is plain Java or Spring Boot already; do not convert it yet.
- [ ] **0.010** `[Build]` Open IntelliJ Terminal in the confirmed project root and run `pwd` (PowerShell: `Get-Location`) to prove the active directory.
- [ ] **0.011** `[Build]` Run `java -version`, capture the JVM version, and determine whether it is the selected Microsoft OpenJDK 21.
- [ ] **0.012** `[Build]` Run `javac -version` to distinguish compiler availability from runtime availability.
- [ ] **0.013** `[Build]` Run `mvn -version` OR `./mvnw.cmd -version` if a wrapper exists; identify the Java runtime Maven actually uses.
- [ ] **0.014** `[Break/fix]` If IntelliJ SDK and Maven Java versions differ, trace `JAVA_HOME` and the Maven runner JRE settings before changing configuration.
- [ ] **0.015** `[Inspect]` Look for an existing `main(String[] args)` entry point; determine how IntelliJ identifies a runnable Java class.
- [ ] **0.016** `[Verify]` Run the existing entry point if present; record the actual console message or exception and exit behavior.
- [ ] **0.017** `[Break/fix]` If Java reports no suitable main method or compilation failure, identify the exact source/classpath cause without resetting the project.
- [ ] **0.018** `[Inspect]` Check whether `.git/` exists by running `git status` from the confirmed root.
- [ ] **0.019** `[Inspect]` Run `git remote -v` and record whether `origin` already points to `https://github.com/sabareeshrao/Java-Parakeet.git`.
- [ ] **0.020** `[Inspect]` Run `git branch --show-current`; do not assume the local branch is `main`.
- [ ] **0.021** `[Inspect]` Inspect `.gitignore` and check treatment of `target/`, `node_modules/`, credentials, machine-local IDE files, and useful shared IDE configuration.
- [ ] **0.022** `[Build]` Write a short README describing what currently exists—not what later chapters will add.
- [ ] **0.023** `[Build]` Create `docs/decisions.md` recording our intentional adaptation: book uses Eclipse/Gradle/Java 17; this implementation uses IntelliJ/Maven/JDK 21.
- [ ] **0.024** `[Build]` Create `docs/progress.md` with the initial task state marked `unverified`, `in progress`, or `verified` as appropriate.
- [ ] **0.025** `[Build]` Initialize Git only if needed, keeping all existing files untouched.
- [ ] **0.026** `[Build]` Configure `origin` only if absent or incorrect; inspect before using any command that changes a remote.
- [ ] **0.027** `[Verify]` Run `git status --short` and examine every proposed staged file for accidental secrets or generated binaries.
- [ ] **0.028** `[Break/fix]` If `.env`, passwords, keys, or build output are staged, unstage/exclude them before creating any commit.
- [ ] **0.029** `[Build]` Commit the actual existing source as a baseline; use a descriptive, truthful commit message.
- [ ] **0.030** `[Build]` Push the verified branch to the user's remote; avoid `--force` and avoid rewriting unrelated history.
- [ ] **0.031** `[Verify]` Open the remote tree/commit and compare its `pom.xml` and source layout to the local project.
- [ ] **0.032** `[Trace]` Write a short execution trace: launch configuration → `main` method → console output.
- [ ] **0.033** `[Git checkpoint]` Record the verified commit SHA, SDK/Maven versions and a screenshot or terminal log reference in `docs/progress.md`.

**Gate 0:** Real local work appears on GitHub; JDK/Maven versions and baseline behavior are documented. No source is discarded.

---

## Stage 1 — From plain Java to a running Spring Boot backend

**Scope:** Book Ch. 1: Environment and tools — backend. **Printed pages:** 1–20.  
**Continuity:** `JDK` → `Maven pom.xml` → `Spring Boot application` → `embedded Tomcat` → `logs/config`.  

- [ ] **1.001** `[Concept]` Explain source `.java` → compiler → `.class` bytecode → JVM using an actual class from the repo.
- [ ] **1.002** `[Build]` Use IntelliJ Terminal to compile/run an isolated tiny Java class once; observe source file versus class file.
- [ ] **1.003** `[Inspect]` Locate the exact Java release in `pom.xml`; verify the book’s JDK 17 baseline is adapted consciously to your JDK 21.
- [ ] **1.004** `[Concept]` Compare a Maven project with a Spring Boot application; understand why one is a build system and the other is a framework.
- [ ] **1.005** `[Inspect]` Read the book’s Gradle plugin/dependency example and identify the corresponding Maven parent, BOM, dependencies and plugins conceptually.
- [ ] **1.006** `[Inspect]` Check the intended Spring Boot version against JDK 21 and relevant library compatibility before editing `pom.xml`.
- [ ] **1.007** `[Build]` Modify the existing Maven model in place to adopt Spring Boot without deleting the original project or `.git` directory.
- [ ] **1.008** `[Build]` Choose a base package and explain why the main application class should live above component subpackages.
- [ ] **1.009** `[Build]` Add Spring Web starter dependency with Maven syntax.
- [ ] **1.010** `[Inspect]` Locate transitive dependencies in IntelliJ's Maven dependency viewer and identify embedded Tomcat.
- [ ] **1.011** `[Build]` Add Spring Boot DevTools as a development-only dependency with suitable packaging scope.
- [ ] **1.012** `[Verify]` Trigger Maven reload in IntelliJ and confirm all chosen artifacts resolve without red imports.
- [ ] **1.013** `[Break/fix]` If Maven says it cannot find a dependency, examine coordinates, Maven repository access, and version management.
- [ ] **1.014** `[Build]` Create or adapt the application entry class under the chosen base package; preserve existing public classes.
- [ ] **1.015** `[Concept]` Explain the difference between plain `main` and Spring Boot's application bootstrap method.
- [ ] **1.016** `[Inspect]` Highlight the imports for `SpringApplication` and `SpringBootApplication`; explain which JAR supplies each.
- [ ] **1.017** `[Build]` Annotate the application class with `@SpringBootApplication`.
- [ ] **1.018** `[Build]` Call `SpringApplication.run(YourApplication.class, args)` from `main`.
- [ ] **1.019** `[Trace]` Trace `main` → auto-configuration → application context → embedded web server startup.
- [ ] **1.020** `[Verify]` Run using IntelliJ's green run control; identify a successful startup line and configured port in the Run console.
- [ ] **1.021** `[Break/fix]` Diagnose an application startup failure by reading the FIRST meaningful `Caused by:` and the bottom exception message.
- [ ] **1.022** `[Build]` Run using Maven `spring-boot:run` from IntelliJ Terminal (or the project's wrapper) and compare behavior to IDE launch.
- [ ] **1.023** `[Verify]` Visit `http://localhost:8080/`; distinguish `404` with a running web server from connection refused/no server.
- [ ] **1.024** `[Concept]` Explain why a server may be healthy even when no controller maps `/` yet.
- [ ] **1.025** `[Build]` Open or create `src/main/resources/application.properties` and document its purpose.
- [ ] **1.026** `[Build]` Add an SLF4J logger to the application; log a descriptive startup message after bootstrap.
- [ ] **1.027** `[Inspect]` Inspect level, timestamp, logger name and message in an actual console line.
- [ ] **1.028** `[Build]` Set one package-specific logging level; confirm exactly which messages appear.
- [ ] **1.029** `[Break/fix]` Intentionally use a higher logging threshold and show why debug messages disappear, then restore desired settings.
- [ ] **1.030** `[Build]` Set `server.port=8081` in properties and restart; observe the actual port change.
- [ ] **1.031** `[Verify]` Compare responses from `localhost:8080` and `localhost:8081` for the current running state.
- [ ] **1.032** `[Break/fix]` Start a second server on the same port; capture the address-in-use failure, then stop the extra process and restore normal startup.
- [ ] **1.033** `[Concept]` Explain developer restart versus full JVM restart, and why IntelliJ compilation can affect DevTools behavior.
- [ ] **1.034** `[Build]` Modify a harmless class, trigger a compile, and observe whether DevTools restarts the application in your actual IntelliJ settings.
- [ ] **1.035** `[Inspect]` Identify the purpose of the Maven wrapper scripts if present; do not install Maven globally merely to satisfy the book.
- [ ] **1.036** `[Build]` Run Maven `test` then `package`; locate the created target artifact and observe test execution counts.
- [ ] **1.037** `[Concept]` Explain why `target/` should be ignored and source `pom.xml` should be committed.
- [ ] **1.038** `[Inspect]` Inspect how MariaDB will later fit; identify database server, schema, user and JDBC driver as separate components.
- [ ] **1.039** `[Build]` Verify whether MariaDB is installed locally; postpone credentials and persistent schema until Stage 3.
- [ ] **1.040** `[Trace]` Draw the working path: IntelliJ → Maven → app class → Spring → Tomcat → browser request → log.
- [ ] **1.041** `[Git checkpoint]` Push the working baseline and record a running-app screenshot or textual console proof in progress notes.

**Gate 1:** Existing project runs as a Spring Boot app from both IntelliJ and Maven; developer logging and port behavior are demonstrated.

---

## Stage 2 — Dependency injection, starting with an ordinary Java object

**Scope:** Book Ch. 2: Dependency injection. **Printed pages:** 21–26.  
**Continuity:** `manual new` → `constructor parameter` → `Spring bean` → `component scan` → `mockable interface`.  

- [ ] **2.001** `[Concept]` Explain what a dependency is using a car-related class, without using any annotations.
- [ ] **2.002** `[Build]` Create a small `CarFormatter` that formats a car description; use a temporary ordinary Java example before JPA exists.
- [ ] **2.003** `[Build]` Create a consumer that directly instantiates `new CarFormatter()`; run and inspect output.
- [ ] **2.004** `[Trace]` Trace which class owns creation and which class owns behavior in the direct-instantiation example.
- [ ] **2.005** `[Break/fix]` Replace the formatter with another implementation and observe which consumer source lines need editing.
- [ ] **2.006** `[Build]` Refactor consumer constructor to accept the formatter instead of creating it inside the consumer.
- [ ] **2.007** `[Concept]` Distinguish a constructor parameter (injection) from a field holding the dependency.
- [ ] **2.008** `[Verify]` Run the manually injected variant and confirm it produces the same user-visible output.
- [ ] **2.009** `[Build]` Create a `CarDescriptionService` interface to describe the formatter contract.
- [ ] **2.010** `[Build]` Implement the interface with an ordinary Java class; avoid using Spring yet.
- [ ] **2.011** `[Build]` Create a small fake implementation and inject it in a simple test or demo.
- [ ] **2.012** `[Trace]` Trace the interface dispatch: caller → interface method → selected implementation.
- [ ] **2.013** `[Concept]` Explain why constructor injection is suitable for required dependencies and setter injection for optional ones.
- [ ] **2.014** `[Build]` Write an optional-setter variant and compare what happens before any setter is called.
- [ ] **2.015** `[Concept]` Explain object lifetime and bean ownership at a beginner level; define Spring's ApplicationContext.
- [ ] **2.016** `[Build]` Convert the concrete service into a Spring-managed bean with `@Service`.
- [ ] **2.017** `[Build]` Create a second Spring-managed component that receives the service via its constructor.
- [ ] **2.018** `[Inspect]` Confirm both classes lie under the application's component scan root package.
- [ ] **2.019** `[Verify]` Launch Spring and demonstrate the injected method running in a safe startup/demo hook.
- [ ] **2.020** `[Break/fix]` Move a demo bean temporarily outside component scanning and observe the missing-bean error; restore it.
- [ ] **2.021** `[Break/fix]` Remove the annotation on an implementation temporarily, inspect missing bean diagnostics, then restore it.
- [ ] **2.022** `[Concept]` Compare `@Component`, `@Service`, `@Repository`, `@Controller` as Spring stereotypes; don't add unused classes for vocabulary alone.
- [ ] **2.023** `[Concept]` Explain how a single constructor is injected without an explicit `@Autowired` in the common case.
- [ ] **2.024** `[Break/fix]` Create two candidate beans of the same interface in a controlled experiment; inspect ambiguity and resolve it deliberately.
- [ ] **2.025** `[Build]` Write a small test that instantiates the consumer directly with a fake implementation.
- [ ] **2.026** `[Verify]` Run that test without bootstrapping a whole web server and explain why it is faster.
- [ ] **2.027** `[Trace]` Draw the flow: component scan → bean registration → dependency graph → consumer method call.
- [ ] **2.028** `[Git checkpoint]` Commit the exercised service, consumer, and focused test; remove throwaway demo code or isolate it clearly.

**Gate 2:** Two classes collaborate through constructor injection; Spring supplies the real implementation and a unit test supplies a fake.

---

## Stage 3 — JPA persistence and relational modeling

**Scope:** Book Ch. 3: ORM, JPA, Hibernate, MariaDB. **Printed pages:** 27–60.  
**Continuity:** `Car Java object` ↔ `JPA entity` ↔ `database table`; `Owner 1 → N Cars`.  

- [ ] **3.001** `[Concept]` Explain in your own words why a Java object is not automatically a relational table row.
- [ ] **3.002** `[Concept]` Distinguish ORM technique, JPA API/specification, Hibernate provider and JDBC driver.
- [ ] **3.003** `[Inspect]` Find Spring Data JPA and H2 dependencies from the book and translate them into Maven declarations.
- [ ] **3.004** `[Build]` Add Spring Data JPA starter to `pom.xml` and reload Maven.
- [ ] **3.005** `[Build]` Add H2 as a development/test database and observe which additional artifacts Maven resolves.
- [ ] **3.006** `[Inspect]` Create or inspect the `domain`/`entity` package below your actual base package; avoid premature package renames.
- [ ] **3.007** `[Build]` Create `Car.java` with only a class declaration first; build once to prove the package is correct.
- [ ] **3.008** `[Build]` Add `brand`, `model`, `color`, `registrationNumber`, `modelYear`, `price` as fields with correct Java types.
- [ ] **3.009** `[Concept]` Explain why a business identifier such as registration number differs from a generated technical primary key.
- [ ] **3.010** `[Build]` Add `Long id` with `@Id` and `@GeneratedValue` using `jakarta.persistence` imports.
- [ ] **3.011** `[Build]` Add `@Entity` and compile; determine which table Hibernate expects to create.
- [ ] **3.012** `[Build]` Write no-argument and field-based constructors and explain why ORM needs the no-argument form.
- [ ] **3.013** `[Build]` Generate getters and setters through IntelliJ; inspect one method rather than accepting the generated code blindly.
- [ ] **3.014** `[Break/fix]` Temporarily remove the no-argument constructor and note the observed runtime failure before restoring it.
- [ ] **3.015** `[Build]` Set a column rule via `@Column` for one field and observe schema implications.
- [ ] **3.016** `[Build]` Configure an H2 connection and enable SQL logging in local application properties.
- [ ] **3.017** `[Verify]` Start Spring and locate schema creation statements in the console.
- [ ] **3.018** `[Trace]` Map each Java field to a corresponding DB column and `id` to primary key in a two-column diagram.
- [ ] **3.019** `[Build]` Create `CarRepository` extending the appropriate Spring Data repository interface for `Car` and `Long`.
- [ ] **3.020** `[Concept]` Explain why an interface can provide persistence behavior through Spring Data without you implementing SQL.
- [ ] **3.021** `[Build]` Inject `CarRepository` into a startup runner or dedicated seed component via constructor injection.
- [ ] **3.022** `[Build]` Save one car through `repository.save(...)`.
- [ ] **3.023** `[Verify]` Read it back by ID and log its brand/model; verify fields match the inserted object.
- [ ] **3.024** `[Build]` Persist several cars through `saveAll(...)` and query all rows.
- [ ] **3.025** `[Build]` Add one derived query `findByBrand...` or matching method from the book; inspect naming semantics.
- [ ] **3.026** `[Break/fix]` Misspell a derived query property in a temporary branch/experiment, inspect startup validation error, then correct it.
- [ ] **3.027** `[Build]` Write a second query with more than one condition and verify expected results against seed data.
- [ ] **3.028** `[Concept]` Explain why `Optional` helps express a missing result; practice absent ID lookup.
- [ ] **3.029** `[Build]` Create `Owner.java` with a generated key and book-appropriate name fields.
- [ ] **3.030** `[Build]` Create `OwnerRepository` and seed two owners before cars.
- [ ] **3.031** `[Concept]` Model one owner to many cars using a handwritten example of 1→N row relationships.
- [ ] **3.032** `[Build]` Add `@ManyToOne` and owner reference in `Car.java`.
- [ ] **3.033** `[Build]` Add `@OneToMany(mappedBy="owner")` collection in `Owner.java` and explain which side owns the foreign key.
- [ ] **3.034** `[Break/fix]` Test what happens when `mappedBy` names the wrong Java property, then repair it.
- [ ] **3.035** `[Build]` Update car constructors and seed routines to connect each car to a saved owner.
- [ ] **3.036** `[Verify]` Query cars and inspect their `owner_id` or equivalent generated foreign key in database.
- [ ] **3.037** `[Verify]` Fetch a particular owner and account for the number of associated cars without assuming eager loading.
- [ ] **3.038** `[Concept]` Explain LAZY versus EAGER and why serialization can accidentally traverse entity relationships.
- [ ] **3.039** `[Break/fix]` Demonstrate or discuss JSON recursion when two sides of a bidirectional relationship are serialized naively.
- [ ] **3.040** `[Concept]` Define delete/update cascade behavior; do not use `CascadeType.ALL` by habit.
- [ ] **3.041** `[Build]` Create a focused test for saving a car-owner relation and retrieving it.
- [ ] **3.042** `[Verify]` Restart Spring with H2 memory storage; observe loss of in-memory data and state why.
- [ ] **3.043** `[Inspect]` Verify MariaDB server, connection port and whether a dedicated app database/account exists.
- [ ] **3.044** `[Build]` Create a named MariaDB schema dedicated to this project using a database client/terminal.
- [ ] **3.045** `[Build]` Create a least-privilege development user and ensure credentials are NOT committed.
- [ ] **3.046** `[Build]` Add MariaDB JDBC driver runtime dependency to Maven.
- [ ] **3.047** `[Build]` Configure a local/dev profile or externalized environment variables for JDBC URL, user and password.
- [ ] **3.048** `[Break/fix]` Use a deliberately bad connection setting to see the actual JDBC connection error; restore it.
- [ ] **3.049** `[Verify]` Connect Spring Boot to MariaDB and inspect generated schema/DDL in logs or DB explorer.
- [ ] **3.050** `[Verify]` Run the same seed and repository queries against MariaDB; compare SQL dialect/identity behavior.
- [ ] **3.051** `[Verify]` Restart the backend and verify the data remains after application restart.
- [ ] **3.052** `[Concept]` Explain why automatic schema generation is convenient for practice but migrations matter later.
- [ ] **3.053** `[Inspect]` Inspect duplicates caused by naive seed-on-every-restart behavior; choose a safe seed strategy.
- [ ] **3.054** `[Trace]` Draw service/runner → repository proxy → JPA/Hibernate → JDBC → MariaDB → rows → returned entities.
- [ ] **3.055** `[Git checkpoint]` Commit entities, repositories, safe development config, persistence tests and setup notes; omit passwords.

**Gate 3:** Cars, owners and their foreign-key relationship persist and can be queried after restarting Spring Boot.

---

## Stage 4 — HTTP resources, database endpoints and OpenAPI

**Scope:** Book Ch. 4: REST and API documentation. **Printed pages:** 61–84.  
**Continuity:** `HTTP request` → `Spring routing` → `repository` → `JSON response` → `OpenAPI docs`.  

- [ ] **4.001** `[Concept]` Explain client/server, HTTP request, HTTP response and the meaning of a resource URL.
- [ ] **4.002** `[Concept]` Distinguish GET/POST/PUT/PATCH/DELETE with car inventory operations.
- [ ] **4.003** `[Build]` Write one minimal `@RestController` GET endpoint independent of JPA.
- [ ] **4.004** `[Verify]` Call the endpoint using browser or IntelliJ HTTP client and inspect response body and status.
- [ ] **4.005** `[Break/fix]` Change the URL path and observe 404 versus an application failing to start.
- [ ] **4.006** `[Concept]` Explain `@RequestMapping`, `@GetMapping`, URI parameters, path variables and request bodies.
- [ ] **4.007** `[Build]` Accept a query parameter in a harmless demo endpoint and inspect type conversion.
- [ ] **4.008** `[Break/fix]` Send a badly typed parameter and inspect client error response; correct the input.
- [ ] **4.009** `[Build]` Expose a single car response manually and identify how Spring serializes an object to JSON.
- [ ] **4.010** `[Build]` Add the Maven equivalent of Spring Data REST to existing dependencies.
- [ ] **4.011** `[Inspect]` Examine whether `CarRepository` and `OwnerRepository` are exported before changing configuration.
- [ ] **4.012** `[Build]` Set `spring.data.rest.basePath=/api` to match the book’s resource prefix.
- [ ] **4.013** `[Verify]` Request `/api` and identify advertised car/owner links.
- [ ] **4.014** `[Inspect]` Request `/api/cars`; locate `_embedded`, `_links`, content types and the cars array in HAL JSON.
- [ ] **4.015** `[Concept]` Explain HAL and why the backend response is not necessarily a bare `Car[]`.
- [ ] **4.016** `[Verify]` Create a car using POST and check the expected success code/location or returned body for the actual stack.
- [ ] **4.017** `[Verify]` GET the created resource and compare IDs/field values.
- [ ] **4.018** `[Verify]` Update an allowed field with the appropriate HTTP method and verify a subsequent GET reflects it.
- [ ] **4.019** `[Verify]` Delete a test resource and verify a subsequent lookup fails as expected.
- [ ] **4.020** `[Break/fix]` Try an invalid ID and distinguish not-found from bad request and server error.
- [ ] **4.021** `[Break/fix]` Try invalid JSON and inspect parser/status response without mistaking it for a database issue.
- [ ] **4.022** `[Build]` Exercise a repository filtering/search endpoint based on the query methods already implemented.
- [ ] **4.023** `[Verify]` Open the HTTP response headers and inspect Content-Type and location/hypermedia links where available.
- [ ] **4.024** `[Concept]` Explain why exposing every repository directly may be undesirable for sensitive entities.
- [ ] **4.025** `[Build]` Configure explicit exposure boundaries for public resources, especially when AppUser is added later.
- [ ] **4.026** `[Build]` Add springdoc OpenAPI UI dependency in Maven using a version verified compatible with chosen Spring Boot.
- [ ] **4.027** `[Build]` Create an `OpenApiConfig` bean with API title, version and description.
- [ ] **4.028** `[Build]` Configure documentation URL paths deliberately in properties.
- [ ] **4.029** `[Verify]` Open Swagger UI and test one GET endpoint from its interactive interface.
- [ ] **4.030** `[Verify]` Retrieve JSON OpenAPI description and locate a car-related path/method.
- [ ] **4.031** `[Break/fix]` Simulate a misconfigured swagger path and repair it using logs/config instead of guessing.
- [ ] **4.032** `[Trace]` Trace browser/HTTP-client request → handler or repository exporter → JPA → DB → HAL serializer → browser.
- [ ] **4.033** `[Git checkpoint]` Push executable API examples and a short `docs/api.md` endpoint inventory.

**Gate 4:** Car and Owner resources are reachable and documented; create/read/update/delete can be verified with status and database checks.

---

## Stage 5 — Authentication, authorization, JWT and secure requests

**Scope:** Book Ch. 5: Backend security. **Printed pages:** 85–122.  
**Continuity:** `anonymous request` → `filter chain` → `user service` → `login` → `JWT` → `authorized CRUD`.  

- [ ] **5.001** `[Concept]` Separate authentication (identity) from authorization (permission) using car inventory users.
- [ ] **5.002** `[Concept]` Identify password, password hash, access token, role and authority as different concepts.
- [ ] **5.003** `[Build]` Add Spring Security and Spring Security test dependencies in Maven.
- [ ] **5.004** `[Verify]` Start the server and observe default protection before adding custom configuration.
- [ ] **5.005** `[Inspect]` Inspect which route now redirects to login or returns unauthorized for your chosen request client.
- [ ] **5.006** `[Concept]` Explain security filter chain position relative to controller/repository routing.
- [ ] **5.007** `[Build]` Create `AppUser` JPA entity with generated ID, unique username, encoded password and role.
- [ ] **5.008** `[Build]` Create `AppUserRepository` with a lookup by username returning `Optional`.
- [ ] **5.009** `[Verify]` Test save/find behavior of a user without logging or returning the stored password hash.
- [ ] **5.010** `[Build]` Create an appropriate `UserDetailsService` implementation backed by repository access.
- [ ] **5.011** `[Concept]` Explain why the authentication layer should not compare raw password strings to database fields.
- [ ] **5.012** `[Build]` Wire a password encoder and create a deliberately known local demo user via safe development setup.
- [ ] **5.013** `[Verify]` Check the stored value differs from plaintext and validation succeeds for the original password.
- [ ] **5.014** `[Break/fix]` Test a wrong password and confirm authentication fails without leaking whether account or password was incorrect.
- [ ] **5.015** `[Build]` Create a `SecurityConfig` class with explicit `SecurityFilterChain` bean.
- [ ] **5.016** `[Concept]` Explain `permitAll`, `authenticated` and authority/role matching before adding route rules.
- [ ] **5.017** `[Build]` Define a login entry point that is reachable without a token.
- [ ] **5.018** `[Build]` Require authentication for the application API routes by default.
- [ ] **5.019** `[Verify]` GET a protected endpoint anonymously and record the exact status for this client.
- [ ] **5.020** `[Verify]` Compare authenticated versus anonymous requests using the same URL and method.
- [ ] **5.021** `[Concept]` Read JWT header.payload.signature structure and distinguish signed from encrypted data.
- [ ] **5.022** `[Inspect]` Choose a JWT library/version supported by the project instead of copying 2023 dependency versions blindly.
- [ ] **5.023** `[Build]` Create a token service capable of signing tokens with locally supplied secret key material.
- [ ] **5.024** `[Concept]` Explain why a JWT signing key cannot be safely hardcoded into GitHub source.
- [ ] **5.025** `[Build]` Issue a token with subject and expiry after successful credential verification.
- [ ] **5.026** `[Verify]` Inspect a development token payload without exposing sensitive key material; verify claim names and expiration.
- [ ] **5.027** `[Break/fix]` Modify one character of a valid token and verify signature validation rejects it.
- [ ] **5.028** `[Break/fix]` Test an expired token and confirm rejection without bypassing expiration checks.
- [ ] **5.029** `[Build]` Implement a request authentication filter that extracts a Bearer token when present.
- [ ] **5.030** `[Build]` Verify the token signature, subject and expiration before populating the security context.
- [ ] **5.031** `[Trace]` Trace authorization for an inbound GET: headers → filter → SecurityContext → access rule → endpoint.
- [ ] **5.032** `[Break/fix]` Omit the `Bearer ` prefix and observe intentional authentication failure.
- [ ] **5.033** `[Break/fix]` Pass a malformed token and ensure the error path does not disclose stack traces or secrets.
- [ ] **5.034** `[Build]` Create clear unauthorized/forbidden API error handling appropriate to the stack.
- [ ] **5.035** `[Concept]` Distinguish HTTP 401 (not authenticated) from 403 (authenticated but not permitted).
- [ ] **5.036** `[Build]` Define at least two user roles with meaningful permissions for inventory management.
- [ ] **5.037** `[Verify]` Test that a limited role cannot perform a protected edit/delete operation.
- [ ] **5.038** `[Verify]` Test that an authorized role can perform the same operation successfully.
- [ ] **5.039** `[Build]` Inspect whether owner/user repositories are exported to REST and prevent unintended account-data disclosure.
- [ ] **5.040** `[Concept]` Explain CSRF as a browser attack and distinguish it from cross-origin resource sharing.
- [ ] **5.041** `[Build]` Configure narrowly scoped CORS for the future local frontend origin; avoid global wildcard plus credentials.
- [ ] **5.042** `[Verify]` Send an OPTIONS/preflight request when applicable and inspect allowed headers/methods/origin.
- [ ] **5.043** `[Concept]` Explain the book’s OAuth2 concepts separately from the JWT flow; treat OAuth2 integration as a contained optional exercise.
- [ ] **5.044** `[Break/fix]` Create a negative test for accessing `/api/cars` with no/invalid token and a positive test with valid token.
- [ ] **5.045** `[Git checkpoint]` Commit security configuration, protected test fixtures and documentation; check staged output for tokens/passwords/keys.

**Gate 5:** Unauthenticated car access fails, valid credentials grant permitted access, and role checks are enforced server-side.

---

## Stage 6 — Backend tests that prove both behavior and security

**Scope:** Book Ch. 6: Testing the backend. **Printed pages:** 123–135.  
**Continuity:** `business rule` → `unit test`; `repository` → `database test`; `HTTP/security` → `integration test`.  

- [ ] **6.001** `[Concept]` Compare a Java unit test, Spring context test, JPA slice test and HTTP integration test.
- [ ] **6.002** `[Inspect]` Inspect `src/test/java` package structure and map it to the main package.
- [ ] **6.003** `[Inspect]` Check Maven test plugins and JUnit/Mockito dependencies resolved by Spring Boot test starter.
- [ ] **6.004** `[Build]` Write a minimal JUnit 5 test with arrange/act/assert structure.
- [ ] **6.005** `[Break/fix]` Make one assertion deliberately fail; read expected/actual output in IntelliJ Test Runner.
- [ ] **6.006** `[Build]` Choose a small deterministic car business rule (for example, registration input normalization) for red-green-refactor.
- [ ] **6.007** `[Build]` Write the failing test before implementing the rule.
- [ ] **6.008** `[Build]` Implement the minimum production code required for the test to pass.
- [ ] **6.009** `[Build]` Refactor duplicate code and rerun the same test; compare resulting behavior.
- [ ] **6.010** `[Concept]` Explain a Mockito mock versus a real repository connected to a test database.
- [ ] **6.011** `[Build]` Mock CarRepository for one service test and verify returned result rather than internal implementation details only.
- [ ] **6.012** `[Build]` Test behavior when the repository returns an absent record via `Optional.empty()`.
- [ ] **6.013** `[Build]` Create a Spring Data repository test with isolated data fixtures.
- [ ] **6.014** `[Verify]` Persist, retrieve and count known rows while avoiding reliance on user’s real development data.
- [ ] **6.015** `[Build]` Write an HTTP test asserting valid car GET status and relevant JSON fields.
- [ ] **6.016** `[Build]` Write an HTTP test for invalid JSON or invalid input and inspect error mapping.
- [ ] **6.017** `[Build]` Write a security test asserting unauthorized access to protected routes.
- [ ] **6.018** `[Build]` Write a role-based test asserting forbidden behavior for insufficient privileges.
- [ ] **6.019** `[Break/fix]` Disable a crucial authorization rule temporarily; check a relevant test fails, then restore it.
- [ ] **6.020** `[Inspect]` Verify tests use isolated profile/DB settings and do not mutate a production database.
- [ ] **6.021** `[Build]` Run one test from IntelliJ gutter and then run the full suite using Maven `test`.
- [ ] **6.022** `[Verify]` Open test report and record pass/fail counts, skipped tests and duration.
- [ ] **6.023** `[Break/fix]` Investigate flaky/ordering-dependent tests by running methods in different orders where applicable.
- [ ] **6.024** `[Concept]` Explain test data ownership, cleanup and why tests should not depend on prior manual inserts.
- [ ] **6.025** `[Trace]` Trace a mock-based unit test without server startup versus an end-to-end HTTP test through Spring filters.
- [ ] **6.026** `[Git checkpoint]` Push test suite and report its evidence-backed status; do not mark gate passed if a test is failing.

**Gate 6:** Maven test suite is green, validates real business behavior, and catches selected invalid/security cases.

---

## Stage 7 — Front-end toolchain without abandoning the existing repository

**Scope:** Book Ch. 7: Frontend setup. **Printed pages:** 139–151.  
**Continuity:** `Node/npm` → `frontend/ package.json` → `Vite dev server` → `React root render`.  

- [ ] **7.001** `[Inspect]` Run `node -v` and `npm -v` from the existing IntelliJ terminal; record the installed versions.
- [ ] **7.002** `[Concept]` Explain Node.js as a JavaScript runtime and npm as a dependency/package script manager.
- [ ] **7.003** `[Concept]` Distinguish `package.json`, lockfile, installed `node_modules/`, and source files.
- [ ] **7.004** `[Inspect]` Inspect the book’s frontend tool choices; note VS Code can be replaced by IntelliJ without changing React concepts.
- [ ] **7.005** `[Inspect]` Determine a current Node/Vite pairing compatible with selected React and TypeScript versions before creating project.
- [ ] **7.006** `[Build]` Create `frontend/` under existing Java project root; explicitly avoid nested `.git` repositories.
- [ ] **7.007** `[Build]` Initialize Vite React starter (with TypeScript now or tracked conversion later) under `frontend/`.
- [ ] **7.008** `[Verify]` Confirm `frontend/package.json` exists and contains named dev/build scripts.
- [ ] **7.009** `[Build]` Run `npm install` once in frontend; inspect the dependency lockfile.
- [ ] **7.010** `[Inspect]` Confirm `node_modules/` remains ignored by Git and `package-lock.json` is tracked.
- [ ] **7.011** `[Build]` Run `npm run dev` and observe actual local server URL and terminal readiness.
- [ ] **7.012** `[Verify]` Open app in browser; identify whether the visible text came from index HTML or React component.
- [ ] **7.013** `[Inspect]` Open `index.html` and locate the root element mounting the application.
- [ ] **7.014** `[Inspect]` Find frontend entry file (`main.jsx` or `main.tsx`) and the React root render call.
- [ ] **7.015** `[Trace]` Trace browser → HTML → module import → React root → App component → rendered DOM.
- [ ] **7.016** `[Build]` Replace the default template content with a neutral Java-Parakeet inventory title.
- [ ] **7.017** `[Build]` Change one stylesheet property and observe hot update in browser without full server rebuild.
- [ ] **7.018** `[Break/fix]` Temporarily introduce an invalid module import; read Vite error overlay, then restore it.
- [ ] **7.019** `[Break/fix]` Use a wrong relative path for a component and locate the file resolution error in IntelliJ/browser.
- [ ] **7.020** `[Inspect]` Open browser Console and Network panels; identify source maps and failed asset requests.
- [ ] **7.021** `[Build]` Set up a convenient IntelliJ npm run configuration if the edition supports it, otherwise keep terminal command.
- [ ] **7.022** `[Git checkpoint]` Commit clean frontend skeleton separately from any downloaded binaries or build artifacts.

**Gate 7:** React starter runs under the same Java-Parakeet repo; the learner can identify entry files and debug the development server.

---

## Stage 8 — React fundamentals through the inventory domain

**Scope:** Book Ch. 8: React basics and hooks. **Printed pages:** 153–198.  
**Continuity:** `JS expressions` → `components/props` → `state/events` → `effects/refs` → `forms/context`.  

- [ ] **8.001** `[Concept]` Explain `const` versus `let` for state preparation and data transformation.
- [ ] **8.002** `[Build]` Define a small mock array of car objects with realistic fields matching backend entities.
- [ ] **8.003** `[Concept]` Practice an arrow function by mapping car data to readable labels.
- [ ] **8.004** `[Build]` Use object destructuring to extract `brand` and `model` without changing mock objects.
- [ ] **8.005** `[Build]` Use template literals to combine fields into a display string.
- [ ] **8.006** `[Concept]` Explain JSX expression braces and distinguish JavaScript values from HTML literal text.
- [ ] **8.007** `[Build]` Create `CarCard` as a standalone component rendering a single mock car.
- [ ] **8.008** `[Verify]` Render exactly one card; inspect component tree and browser DOM output.
- [ ] **8.009** `[Build]` Create `CarList` and import `CarCard`; keep filenames and export/import names consistent.
- [ ] **8.010** `[Trace]` Trace import path from `App` to `CarList` to `CarCard`.
- [ ] **8.011** `[Break/fix]` Temporarily mismatch a named/default export, inspect error and fix the import.
- [ ] **8.012** `[Build]` Pass a `car` object as a prop and show model/brand in child component.
- [ ] **8.013** `[Concept]` Explain immutable props and one-way data flow through parent → child.
- [ ] **8.014** `[Break/fix]` Attempt to mutate a prop in a controlled example and explain why child should request updates through a callback instead.
- [ ] **8.015** `[Build]` Render multiple cars with `Array.map` and a stable unique key.
- [ ] **8.016** `[Break/fix]` Swap array order and explain how an unstable index key could confuse list identity.
- [ ] **8.017** `[Build]` Introduce `useState` for a selected car and update it from a click handler.
- [ ] **8.018** `[Verify]` Select two different cars; verify the detail display updates without page refresh.
- [ ] **8.019** `[Build]` Define a derived count from current array rather than duplicating count into separate state.
- [ ] **8.020** `[Concept]` Explain render, re-render, event handler and why updating an ordinary local variable does not refresh UI.
- [ ] **8.021** `[Build]` Add a search box whose value is controlled by React state.
- [ ] **8.022** `[Build]` Filter local car array case-insensitively using current search state.
- [ ] **8.023** `[Verify]` Show empty-results message when filter matches nothing.
- [ ] **8.024** `[Build]` Render explicit loading, error, empty and success states using conditional JSX.
- [ ] **8.025** `[Build]` Add a button that simulates temporary loading and returns to normal state.
- [ ] **8.026** `[Concept]` Explain how React batches compatible state updates.
- [ ] **8.027** `[Build]` Use functional state updates for repeated click/count operations.
- [ ] **8.028** `[Build]` Create a car draft form with controlled text fields.
- [ ] **8.029** `[Build]` Add controlled numeric inputs for `modelYear` and `price`, preserving typing behavior before conversion.
- [ ] **8.030** `[Verify]` Prevent accidental form submission/reload and show validation feedback.
- [ ] **8.031** `[Build]` Show a list preview of the draft car without saving to backend yet.
- [ ] **8.032** `[Build]` Create a focused `useEffect` example for synchronization with external browser/document behavior.
- [ ] **8.033** `[Concept]` Distinguish render calculations from effectful actions and why every state change does not need `useEffect`.
- [ ] **8.034** `[Build]` Add an effect cleanup and observe it when a demo component unmounts.
- [ ] **8.035** `[Build]` Use `useRef` to focus the first invalid form field after a submit attempt.
- [ ] **8.036** `[Trace]` Trace click → handler → state update → component re-render → DOM update.
- [ ] **8.037** `[Build]` Extract common state logic into a `useCarSearch` or similarly meaningful custom hook.
- [ ] **8.038** `[Verify]` Use the custom hook in a second view to prove behavior is reused instead of copied.
- [ ] **8.039** `[Concept]` Explain React Context as shared dependency transport and when plain props are simpler.
- [ ] **8.040** `[Build]` Add a small genuinely shared setting such as display currency/compact-view preference via Context.
- [ ] **8.041** `[Break/fix]` Temporarily remove the matching Provider and inspect what behavior the consumer receives; restore setup.
- [ ] **8.042** `[Build]` Split presentational UI from stateful components only where it reduces repetition.
- [ ] **8.043** `[Verify]` Use React DevTools if available to inspect the component hierarchy and state changes.
- [ ] **8.044** `[Git checkpoint]` Commit coherent mock-data React views and note exactly what is not yet connected to backend.

**Gate 8:** A small but interactive inventory UI works using local mock data, with components and state traceable through source files.

---

## Stage 9 — TypeScript as a contract between the React UI and Spring API

**Scope:** Book Ch. 9: TypeScript. **Printed pages:** 199–218.  
**Continuity:** `JavaScript values` → `types/interfaces` → `typed component props` → `typed API shape`.  

- [ ] **9.001** `[Concept]` Explain that TypeScript checks source before build and JavaScript still runs in the browser.
- [ ] **9.002** `[Build]` Create a small standalone `.ts` file practicing `string`, `number`, `boolean` and typed arrays.
- [ ] **9.003** `[Build]` Write a typed function that formats a registration number and returns a string.
- [ ] **9.004** `[Break/fix]` Pass a number where a string is required; inspect compiler error then repair it.
- [ ] **9.005** `[Build]` Create a union type for a UI status such as loading/success/error.
- [ ] **9.006** `[Build]` Use optional fields in a temporary car draft type; distinguish optional from nullable.
- [ ] **9.007** `[Concept]` Compare `interface` and `type` alias without inventing a hard rule that one is always better.
- [ ] **9.008** `[Build]` Create `types/Car.ts` or equivalent with API fields `brand`, `model`, `color`, `registrationNumber`, `modelYear`, `price`.
- [ ] **9.009** `[Build]` Create an `Owner` type reflecting the actual backend response fields.
- [ ] **9.010** `[Inspect]` Inspect GET `/api/cars` and identify whether JPA/HAL response contains `_embedded`, `_links`, and stable IDs.
- [ ] **9.011** `[Build]` Define a wrapper type for actual HAL response if retaining Spring Data REST.
- [ ] **9.012** `[Trace]` Trace a Spring entity field → JSON property → TypeScript type → component prop.
- [ ] **9.013** `[Build]` Type `CarCard` props and remove redundant untyped property access.
- [ ] **9.014** `[Build]` Type the `useState` car list and selected car state.
- [ ] **9.015** `[Build]` Type a form change handler with appropriate React event type.
- [ ] **9.016** `[Break/fix]` Assign a `string` form input directly to a numeric model property; inspect type error and create deliberate conversion.
- [ ] **9.017** `[Build]` Type an async fetch helper with `Promise<...>` for its actual resolved payload.
- [ ] **9.018** `[Concept]` Explain compile-time types cannot validate dishonest or malformed network JSON at runtime.
- [ ] **9.019** `[Build]` Use a narrow runtime guard or schema validator for critical external data as an optional improvement.
- [ ] **9.020** `[Build]` If starter was JavaScript, migrate source files gradually from `.jsx` to `.tsx` and resolve imports one by one.
- [ ] **9.021** `[Inspect]` Inspect `tsconfig` options affecting JSX and strictness; record current configuration rather than blindly toggling flags.
- [ ] **9.022** `[Build]` Run `tsc --noEmit` or project's typecheck script and correct diagnostics.
- [ ] **9.023** `[Build]` Run production frontend build and verify emitted browser JS works.
- [ ] **9.024** `[Git checkpoint]` Commit verified types separately enough that API shape changes remain visible in Git diff.

**Gate 9:** The React frontend type-checks with explicit Car and Owner models and no unchecked blanket `any` workaround.

---

## Stage 10 — Async API calls, failures, caching and race conditions

**Scope:** Book Ch. 10: REST consumption from React. **Printed pages:** 219–249.  
**Continuity:** `Promise` → `fetch/axios` → `typed endpoint` → `loading/error` → `query cache`.  

- [ ] **10.001** `[Concept]` Explain Promise pending, fulfilled, rejected with one simple async example.
- [ ] **10.002** `[Build]` Use a delayed Promise and log the order of synchronous versus asynchronous output.
- [ ] **10.003** `[Build]` Call one public practice API with `fetch` and inspect status and returned body.
- [ ] **10.004** `[Inspect]` Open browser Network entry and compare HTTP response status with JavaScript Promise state.
- [ ] **10.005** `[Break/fix]` Request an invalid URL; distinguish fetch network errors from HTTP 404 status.
- [ ] **10.006** `[Build]` Rewrite one promise chain using `async`/`await` and `try`/`catch`.
- [ ] **10.007** `[Build]` Try Axios with the same endpoint and compare error handling/conversion behavior.
- [ ] **10.008** `[Concept]` Document the primary app API client choice instead of mixing two clients arbitrarily.
- [ ] **10.009** `[Inspect]` Study the book’s GitHub/OpenWeather examples and identify public endpoints versus API-key-backed requests.
- [ ] **10.010** `[Concept]` Explain why frontend environment variables are visible in shipped bundles and cannot protect secrets.
- [ ] **10.011** `[Build]` Define local development base URL via supported Vite environment variable convention.
- [ ] **10.012** `[Build]` Build a dedicated typed `getCars()` helper in an API module, not inside every presentational component.
- [ ] **10.013** `[Inspect]` Inspect actual `/api/cars` HAL response and locate `_embedded.cars` precisely.
- [ ] **10.014** `[Build]` Map the API wrapper to a clear UI array while preserving per-resource URL/ID required for updates.
- [ ] **10.015** `[Trace]` Trace `CarList` → API helper → `fetch` → Tomcat → Spring Data REST → DB → response parser → component.
- [ ] **10.016** `[Build]` Use initial loading state while a GET request is in progress.
- [ ] **10.017** `[Build]` Show a meaningful recoverable error state when request rejects.
- [ ] **10.018** `[Build]` Handle successful but empty results distinctly from a failed request.
- [ ] **10.019** `[Break/fix]` Stop Spring Boot and inspect browser Network + UI failure; restart and retest without refresh hacks.
- [ ] **10.020** `[Build]` Add an explicit retry action tied to the fetch/query boundary.
- [ ] **10.021** `[Build]` Simulate a slow request and a fast subsequent request using controllable test responses.
- [ ] **10.022** `[Break/fix]` Demonstrate how an old slow response can overwrite newer search results if requests are unmanaged.
- [ ] **10.023** `[Build]` Apply abort/cancellation or query-key differentiation to prevent stale display where appropriate.
- [ ] **10.024** `[Build]` Install the compatible TanStack Query version and create a query client provider.
- [ ] **10.025** `[Build]` Convert car fetch into a `useQuery` call with a deliberate query key.
- [ ] **10.026** `[Concept]` Explain query cache versus component state and why they solve different problems.
- [ ] **10.027** `[Build]` Configure one data freshness/refetch behavior and observe actual network traffic.
- [ ] **10.028** `[Break/fix]` Use a wrong query key intentionally and inspect stale/wrong-data behavior before correcting it.
- [ ] **10.029** `[Build]` Invalidate or refetch after a simulated data change; verify UI reflects new server state.
- [ ] **10.030** `[Verify]` Refresh browser and check persistent DB data appears without hardcoded mock objects.
- [ ] **10.031** `[Git checkpoint]` Commit API module, async UI states and tests/notes of network outcomes.

**Gate 10:** Frontend can fetch real cars, show errors correctly, and refresh stale data after mutations.

---

## Stage 11 — Third-party UI components and routing

**Scope:** Book Ch. 11: AG Grid, MUI, React Router. **Printed pages:** 251–280.  
**Continuity:** `npm dependency` → `component import` → `grid` → `theming` → `route navigation`.  

- [ ] **11.001** `[Concept]` Explain a UI library versus a framework versus a package manager.
- [ ] **11.002** `[Inspect]` Read current installation/version documentation for AG Grid, MUI and router appropriate to chosen React version.
- [ ] **11.003** `[Build]` Install AG Grid dependencies in frontend as a standalone comparison lab.
- [ ] **11.004** `[Build]` Render the mock car data with AG Grid in a separate demo view.
- [ ] **11.005** `[Verify]` Sort by model and identify whether the grid sorted locally.
- [ ] **11.006** `[Verify]` Filter by brand and inspect the resulting row set.
- [ ] **11.007** `[Build]` Test grid pagination and change page size.
- [ ] **11.008** `[Break/fix]` Feed a column field name absent from data and inspect blank cells, then repair mapping.
- [ ] **11.009** `[Inspect]` Compare how the book uses AG Grid earlier but MUI Data Grid later; select production grid deliberately.
- [ ] **11.010** `[Build]` Install MUI and styling dependencies compatible with existing project.
- [ ] **11.011** `[Build]` Render a Material UI Button next to an existing plain HTML button.
- [ ] **11.012** `[Concept]` Explain component props as a customization API without confusing them with CSS classes.
- [ ] **11.013** `[Build]` Render MUI Typography, container and Paper for a basic layout.
- [ ] **11.014** `[Build]` Experiment with MUI theme colors and spacing without hardcoding every component style.
- [ ] **11.015** `[Build]` Create a mock inventory table/grid view with appropriate car columns.
- [ ] **11.016** `[Build]` Install React Router and introduce a browser router at the app root.
- [ ] **11.017** `[Build]` Add a route for `/cars` and a home route in the same app.
- [ ] **11.018** `[Build]` Add a navigation link that changes route without a full page refresh.
- [ ] **11.019** `[Break/fix]` Enter an unknown route and display a not-found view.
- [ ] **11.020** `[Verify]` Refresh directly on the `/cars` URL; note any dev-server/future deployment route fallback needs.
- [ ] **11.021** `[Trace]` Trace browser address → router match → page component → API/helper or mock data → grid.
- [ ] **11.022** `[Inspect]` Inspect dependency tree for duplicate or unnecessary packages from experiments.
- [ ] **11.023** `[Build]` Remove unused view from the production entry path or isolate it as a clearly named lab component.
- [ ] **11.024** `[Git checkpoint]` Push navigation and UI dependency changes with a reproducible `npm install` lockfile.

**Gate 11:** Component library experiments are working and the car inventory view is navigable; unused experiments are isolated.

---

## Stage 12 — Design the real combined application before changing security rules

**Scope:** Book Ch. 12: Start full-stack development. **Printed pages:** 283–291.  
**Continuity:** `user stories` → `UI mockup` → `backend contract` → `cross-origin request` → `real inventory screen`.  

- [ ] **12.001** `[Concept]` Explain acceptance criteria and why one mockup can prevent repeated UI rework.
- [ ] **12.002** `[Build]` Write user story for listing cars with specific fields and loading behavior.
- [ ] **12.003** `[Build]` Define a user story for filtering, sorting and changing pages.
- [ ] **12.004** `[Build]` Define user story for creating a car with form validation and owner assignment requirements.
- [ ] **12.005** `[Build]` Define user story for updating a car and retaining its identity.
- [ ] **12.006** `[Build]` Define user story for confirming deletion and showing feedback.
- [ ] **12.007** `[Build]` Define user story for exporting visible or all cars; decide scope before implementation.
- [ ] **12.008** `[Build]` Sketch page header, toolbar, table, add modal, edit modal, delete confirmation and login entry.
- [ ] **12.009** `[Inspect]` Compare mockup controls against the book’s sample car-list and modal screenshots.
- [ ] **12.010** `[Build]` Create a field mapping table: UI label → React property → JSON name → `Car` Java property → DB column.
- [ ] **12.011** `[Inspect]` Compare actual backend JSON to the typed frontend `Car` model.
- [ ] **12.012** `[Break/fix]` Identify one deliberate mismatch and show how UI silently fails or type-check catches it; restore names.
- [ ] **12.013** `[Build]` Document local backend/frontend ports and expected web origins.
- [ ] **12.014** `[Build]` Run backend and frontend simultaneously in IntelliJ, keeping both terminals/consoles visible.
- [ ] **12.015** `[Inspect]` Inspect actual cross-origin request in browser Network and distinguish CORS from HTTP authorization error.
- [ ] **12.016** `[Concept]` Explain origin = scheme + host + port using the two running local servers.
- [ ] **12.017** `[Inspect]` Read existing backend security policy before temporarily enabling development integration.
- [ ] **12.018** `[Build]` Configure a narrowly constrained dev-only integration route/profile if the book temporarily removes security.
- [ ] **12.019** `[Break/fix]` Confirm a production-like profile never inherits the insecure development-only access rule accidentally.
- [ ] **12.020** `[Build]` Make the frontend page call the real API and render known records.
- [ ] **12.021** `[Verify]` Compare a visible model/year/price against MariaDB rows to confirm data is not still mock-only.
- [ ] **12.022** `[Verify]` Stop backend and show frontend error state; restart and recover.
- [ ] **12.023** `[Trace]` Trace user URL → React page → API module → Spring security → repository → MariaDB → grid rows.
- [ ] **12.024** `[Git checkpoint]` Push UI mockup/contracts and document what security must be restored in Chapter 16.

**Gate 12:** The car list page demonstrates live backend data from the same repository and a documented development-only security posture.

---

## Stage 13 — Build real create/read/update/delete flows

**Scope:** Book Ch. 13: Adding CRUD functionality. **Printed pages:** 293–337.  
**Continuity:** `MariaDB data` → `GET + grid` → `DELETE` → `POST` → `PUT/PATCH` → `CSV`.  

- [ ] **13.001** `[Inspect]` Read the backend `/api/cars` output and identify its actual HAL `_embedded.cars` location.
- [ ] **13.002** `[Inspect]` Inspect car resource URLs in `_links.self.href` and decide how UI will identify rows independent of visible registration.
- [ ] **13.003** `[Build]` Write a single typed mapper converting HAL car records to view models with explicit stable IDs or URLs.
- [ ] **13.004** `[Break/fix]` Handle a missing `_embedded` collection as empty instead of crashing on undefined.
- [ ] **13.005** `[Build]` Create a dedicated `CarListPage` component and connect its fetch/query hook.
- [ ] **13.006** `[Build]` Create grid columns for brand, model, color, registration number, model year and price.
- [ ] **13.007** `[Verify]` Compare rendered values with a known persisted car from MariaDB.
- [ ] **13.008** `[Build]` Give MUI Data Grid a stable row identifier that does not change when sorting or filtering.
- [ ] **13.009** `[Break/fix]` Delete/reorder rows in local test data to reveal why the array index is an unsafe identity.
- [ ] **13.010** `[Build]` Add a visibly distinct loading state while GET is pending.
- [ ] **13.011** `[Build]` Add empty state for an empty car result.
- [ ] **13.012** `[Build]` Add error UI with retry on a failed GET.
- [ ] **13.013** `[Build]` Enable pagination and identify whether it is client-side or server-side for current backend.
- [ ] **13.014** `[Verify]` Change page and page size; verify correct number of cars and row identities.
- [ ] **13.015** `[Build]` Enable sorting on year and price columns.
- [ ] **13.016** `[Verify]` Sort both ascending and descending and verify numeric values sort numerically, not lexicographically.
- [ ] **13.017** `[Build]` Enable a brand/model filter or appropriate MUI grid filter.
- [ ] **13.018** `[Verify]` Combine filter + sort + page and verify changes do not drop or duplicate records.
- [ ] **13.019** `[Concept]` Explain the difference between state for grid controls and server-fetched query data.
- [ ] **13.020** `[Build]` Add a delete icon/button per row with an accessible title.
- [ ] **13.021** `[Concept]` Explain why DELETE should target the persisted resource ID/URL, not a user-editable brand or registration.
- [ ] **13.022** `[Build]` Create an API helper `deleteCar(idOrUrl)` with the actual backend endpoint contract.
- [ ] **13.023** `[Build]` Add a confirmation dialog displaying enough car information to prevent deleting the wrong row.
- [ ] **13.024** `[Break/fix]` Cancel the dialog and verify Network shows no DELETE request.
- [ ] **13.025** `[Build]` Trigger DELETE only after explicit confirmation.
- [ ] **13.026** `[Verify]` Inspect request method, path and backend response status in Network panel.
- [ ] **13.027** `[Break/fix]` Try to delete an already-deleted resource and show a non-success outcome without corrupting the list.
- [ ] **13.028** `[Build]` Show a success Snackbar after confirmed successful delete.
- [ ] **13.029** `[Build]` Show an error Snackbar after a failed DELETE while preserving the still-existing row.
- [ ] **13.030** `[Build]` Invalidate the cars query after successful mutation so list reflects server state.
- [ ] **13.031** `[Verify]` Reload browser and verify deleted row remains absent from database-driven data.
- [ ] **13.032** `[Build]` Add an Add Car button opening a modal or dialog.
- [ ] **13.033** `[Build]` Create controlled inputs for brand, model, color and registration number.
- [ ] **13.034** `[Build]` Create controlled numeric inputs for model year and price.
- [ ] **13.035** `[Build]` Decide owner selection UI against the actual owner API contract.
- [ ] **13.036** `[Build]` Prevent empty required fields and show field-level validation errors.
- [ ] **13.037** `[Break/fix]` Enter letters into numeric fields and verify invalid values do not silently become zero.
- [ ] **13.038** `[Break/fix]` Enter malformed/duplicate registration information and observe current backend validation; note gaps for extension phase.
- [ ] **13.039** `[Build]` Build a POST payload using explicit field mapping instead of serializing the whole UI state object accidentally.
- [ ] **13.040** `[Inspect]` Inspect submitted JSON shape and `Content-Type` in browser Network tab.
- [ ] **13.041** `[Verify]` Create a car and confirm the server provides or exposes a durable identifier.
- [ ] **13.042** `[Build]` Close/reset the add form after confirmed success, not before server response.
- [ ] **13.043** `[Verify]` Verify new car appears without reloading the entire webpage.
- [ ] **13.044** `[Verify]` Restart backend and verify newly created car persists.
- [ ] **13.045** `[Build]` Introduce Edit button for each row, referencing the selected persisted car.
- [ ] **13.046** `[Build]` Prepopulate the shared form with selected car's current fields; avoid mixing edit and add defaults.
- [ ] **13.047** `[Build]` Preserve the row's persisted ID and selected resource URL through edit state.
- [ ] **13.048** `[Build]` Send PUT/PATCH according to the actual Spring Data REST resource contract.
- [ ] **13.049** `[Verify]` Edit a price or color and check both immediate grid update and subsequent GET.
- [ ] **13.050** `[Break/fix]` Cause one failed update and confirm the UI does not incorrectly display a success Snackbar.
- [ ] **13.051** `[Break/fix]` Edit a car while stale server data exists; observe result and document future concurrency-control improvement.
- [ ] **13.052** `[Build]` Use a single reusable `CarForm` where it reduces duplication without merging unrelated concerns.
- [ ] **13.053** `[Trace]` Trace Add: button → dialog state → input state → validator → POST → repository → MariaDB → invalidated query → grid.
- [ ] **13.054** `[Trace]` Trace Edit: row selection → form initial data → PATCH → response → refetch → updated row.
- [ ] **13.055** `[Trace]` Trace Delete: row → confirmation → DELETE → response → refetch → missing row.
- [ ] **13.056** `[Build]` Add a CSV export action and decide whether it exports displayed page, filtered set or full data set.
- [ ] **13.057** `[Build]` Write CSV headers matching user-visible inventory labels.
- [ ] **13.058** `[Build]` Correctly escape commas, double quotes and embedded newlines in exported values.
- [ ] **13.059** `[Verify]` Open exported CSV in a text editor and inspect actual delimiters/quoted strings.
- [ ] **13.060** `[Break/fix]` Include a test car with a comma or quote in its model text to test escape logic.
- [ ] **13.061** `[Concept]` Explain why exporting a paginated table may omit database rows unless the intended scope is explicit.
- [ ] **13.062** `[Verify]` Perform a complete real-data create → fetch → update → export → delete demonstration.
- [ ] **13.063** `[Git checkpoint]` Commit CRUD page, API mutations and related tests; include a short screen/demo checklist.

**Gate 13:** A real car can be listed, created, edited, deleted and exported, with correct UI state, response statuses, and database persistence.

---

## Stage 14 — Make the interface consistent and accessible

**Scope:** Book Ch. 14: Styling with MUI. **Printed pages:** 339–349.  
**Continuity:** `functioning CRUD` → `MUI controls` → `feedback/error styles` → `keyboard + responsive UI`.  

- [ ] **14.001** `[Inspect]` Inspect every plain HTML control in the existing inventory page and identify the corresponding MUI component, if helpful.
- [ ] **14.002** `[Build]` Convert the main Add button to MUI Button with appropriate variant and labeling.
- [ ] **14.003** `[Build]` Replace row action buttons with suitably named IconButton components.
- [ ] **14.004** `[Concept]` Explain why an icon alone should have an accessible name.
- [ ] **14.005** `[Build]` Add a delete-related icon with descriptive tooltip and correct hit target.
- [ ] **14.006** `[Build]` Introduce MUI TextField for brand and model with controlled value/onChange.
- [ ] **14.007** `[Build]` Introduce suitable numeric TextField handling for model year/price with explicit conversion.
- [ ] **14.008** `[Build]` Connect helper text and error flags to actual validation state.
- [ ] **14.009** `[Verify]` Tab through form in logical order without using the mouse.
- [ ] **14.010** `[Build]` Make Save disabled or busy during in-flight mutation to prevent duplicate submission.
- [ ] **14.011** `[Break/fix]` Double-click save rapidly and confirm the code does not issue unintended duplicate POST requests.
- [ ] **14.012** `[Build]` Use consistent spacing and typography for title, toolbar, grid and dialogs.
- [ ] **14.013** `[Build]` Style empty/loading/error views as distinct user states.
- [ ] **14.014** `[Build]` Make confirmation modal readable and ensure destructive action is visually distinguishable.
- [ ] **14.015** `[Verify]` Press Escape to close a non-submitting dialog where supported, and confirm no database mutation.
- [ ] **14.016** `[Verify]` Test focus return to the triggering button after modal close where component behavior allows.
- [ ] **14.017** `[Build]` Inspect a narrow browser viewport and adjust overflow or responsive layout without hiding table actions.
- [ ] **14.018** `[Verify]` Inspect a desktop viewport to verify no unnecessary horizontal scroll or clipped controls.
- [ ] **14.019** `[Build]` Consolidate repeated style values through theme/layout utilities where appropriate.
- [ ] **14.020** `[Break/fix]` Disable or remove a CSS rule temporarily to identify which component owns a layout behavior, then restore it.
- [ ] **14.021** `[Verify]` Re-run full CRUD smoke path and confirm visual changes did not break events or requests.
- [ ] **14.022** `[Git checkpoint]` Push style changes with before/after screenshots but no generated minified build output.

**Gate 14:** The CRUD flow remains functional while the UI gains consistent, tested visual and keyboard behavior.

---

## Stage 15 — Test UI behavior and whole-system boundaries

**Scope:** Book Ch. 15: React testing. **Printed pages:** 351–367.  
**Continuity:** `component test` → `mocked network test` → `user interaction` → `browser-to-DB smoke`.  

- [ ] **15.001** `[Concept]` Explain what a frontend component test can prove without starting backend.
- [ ] **15.002** `[Concept]` Compare Jest, Vitest and React Testing Library roles; select a runner appropriate to current Vite stack.
- [ ] **15.003** `[Inspect]` Check dependencies and scripts already present before installing overlapping test tooling.
- [ ] **15.004** `[Build]` Install/configure Vitest and React Testing Library with a browser-like DOM environment as needed.
- [ ] **15.005** `[Build]` Create a test setup file to register cleanup and user-facing DOM assertions if appropriate.
- [ ] **15.006** `[Build]` Write a render test asserting visible page title or button label.
- [ ] **15.007** `[Verify]` Run one test from IntelliJ and the terminal; compare output/results.
- [ ] **15.008** `[Break/fix]` Change expected text intentionally; inspect assertion diff then repair.
- [ ] **15.009** `[Build]` Create a fixture with two cars matching typed frontend API shape.
- [ ] **15.010** `[Build]` Mock the request boundary to return the two cars deterministically.
- [ ] **15.011** `[Build]` Assert table rows show expected brand and model values.
- [ ] **15.012** `[Build]` Test loading spinner/placeholder before mocked request resolves.
- [ ] **15.013** `[Build]` Test the empty message for zero cars.
- [ ] **15.014** `[Build]` Test an API error and the visible retry control.
- [ ] **15.015** `[Build]` Test search/filter interaction by typing into the real input.
- [ ] **15.016** `[Verify]` Assert matching rows remain and unrelated rows disappear.
- [ ] **15.017** `[Build]` Test Add button opens form and focuses first relevant control.
- [ ] **15.018** `[Build]` Test form prevents submission when required fields are missing.
- [ ] **15.019** `[Build]` Test valid input causes intended add mutation payload to be sent once.
- [ ] **15.020** `[Build]` Test that a successful add causes visible list refresh.
- [ ] **15.021** `[Build]` Test editing pre-populates an existing car rather than a blank draft.
- [ ] **15.022** `[Build]` Test edit mutation uses persisted ID/URL and modified field values.
- [ ] **15.023** `[Build]` Test delete confirmation cancel path never sends DELETE.
- [ ] **15.024** `[Build]` Test confirmed delete calls the correct resource URL and removes row after success.
- [ ] **15.025** `[Build]` Test rejected mutations preserve data and display error message.
- [ ] **15.026** `[Build]` Test CSV exporting fields and escape rules on comma/quote fixture.
- [ ] **15.027** `[Concept]` Explain why direct test of internal hooks is usually less useful than testing visible behavior.
- [ ] **15.028** `[Inspect]` Identify one browser-to-API-to-database test case that mock-based tests cannot validate.
- [ ] **15.029** `[Build]` Execute a manual or automated smoke test against isolated test DB using actual backend + frontend.
- [ ] **15.030** `[Break/fix]` Demonstrate a caught regression by temporarily breaking a field mapping, then restore it.
- [ ] **15.031** `[Build]` Run all frontend tests followed by production build command.
- [ ] **15.032** `[Git checkpoint]` Record test counts and build status in progress notes and push reproducible test scripts.

**Gate 15:** Automated tests cover loading/empty/errors and CRUD interactions; production frontend build succeeds.

---

## Stage 16 — Connect React login to the backend JWT contract

**Scope:** Book Ch. 16: Securing the full-stack app. **Printed pages:** 369–388.  
**Continuity:** `login form` → `token response` → `authenticated API client` → `role-controlled UI` → `logout`.  

- [ ] **16.001** `[Inspect]` Review actual Stage 5 SecurityFilterChain and confirm final API paths are not publicly exposed.
- [ ] **16.002** `[Build]` Turn off development-only unprotected access without removing legitimate CORS config.
- [ ] **16.003** `[Verify]` Request GET `/api/cars` without auth and capture an expected unauthorized response.
- [ ] **16.004** `[Concept]` Explain why authentication is checked on server regardless of whether UI hides a button.
- [ ] **16.005** `[Build]` Create React `LoginPage` component with username/password controlled inputs.
- [ ] **16.006** `[Build]` Validate missing inputs locally without reporting password details in UI.
- [ ] **16.007** `[Build]` Create typed API helper for the backend login request path and JSON body.
- [ ] **16.008** `[Inspect]` Inspect the actual backend login response to identify token header/body field; do not guess field name.
- [ ] **16.009** `[Build]` Submit a known valid local user and inspect successful login response.
- [ ] **16.010** `[Break/fix]` Submit bad credentials and display generic, user-friendly failure message.
- [ ] **16.011** `[Concept]` Separate transient password field state, session authentication state and server authorization.
- [ ] **16.012** `[Inspect]` Review token storage tradeoffs (memory, session storage, HttpOnly cookie alternative) and document selected approach.
- [ ] **16.013** `[Build]` Save a token only in the intended scoped session mechanism; do not include it in Git or console logs.
- [ ] **16.014** `[Build]` Centralize Bearer authorization header attachment in the API client/helper.
- [ ] **16.015** `[Verify]` GET car list as an authenticated user and confirm backend permits it.
- [ ] **16.016** `[Verify]` Inspect Network request headers while avoiding screenshots/sharing of actual token value.
- [ ] **16.017** `[Break/fix]` Remove token and verify the same endpoint fails without silently falling back to public access.
- [ ] **16.018** `[Break/fix]` Pass an altered token and verify rejected request triggers a safe UI response.
- [ ] **16.019** `[Build]` Respond to a 401 from an expired token by clearing stale UI authentication state and prompting login.
- [ ] **16.020** `[Concept]` Explain token expiration and why local UI state is not a proof of identity.
- [ ] **16.021** `[Build]` Add route gating to direct navigation into a protected inventory page.
- [ ] **16.022** `[Verify]` Reload on a protected URL with and without a valid session and inspect results.
- [ ] **16.023** `[Build]` Hide/disable unauthorized mutation buttons based on known role only as UX, not security enforcement.
- [ ] **16.024** `[Verify]` Attempt the same mutation with insufficient role directly using an HTTP client and verify backend blocks it.
- [ ] **16.025** `[Build]` Extract repeated error/auth response handling out of the create/edit/delete handlers.
- [ ] **16.026** `[Build]` Add a logout control that clears token/session information and query cache where appropriate.
- [ ] **16.027** `[Verify]` After logout, revisit `/cars` and confirm fresh protected API calls are not authorized.
- [ ] **16.028** `[Verify]` Log in again and verify previous database changes still exist (logout does not delete data).
- [ ] **16.029** `[Break/fix]` Simulate backend becoming unavailable mid-session and provide a useful retry/error instead of a false invalid-password message.
- [ ] **16.030** `[Trace]` Trace login: form → POST login → authenticate user → JWT issue → session state → Authorization header → filter → role policy → repository.
- [ ] **16.031** `[Build]` Run frontend and backend security tests together.
- [ ] **16.032** `[Git checkpoint]` Commit integration and exact failure-matrix results without sharing any secrets or sensitive credentials.

**Gate 16:** Protected CRUD works only for valid users and server-side roles; logout/expired tokens behave predictably.

---

## Stage 17 — Package and deploy safely, then containerize

**Scope:** Book Ch. 17: AWS, Netlify, Docker. **Printed pages:** 389–415.  
**Continuity:** `Maven JAR` → `runtime configuration` → `hosted DB` → `AWS API` → `Netlify UI` → `Docker`.  

- [ ] **17.001** `[Concept]` Explain deployment components: compiled backend, DB server, built frontend and configuration/secrets.
- [ ] **17.002** `[Inspect]` Check actual Maven packaging/plugins and identify executable Spring Boot JAR goal.
- [ ] **17.003** `[Build]` Run `mvn clean test` or wrapper equivalent; do not package known-failing tests as a passing release.
- [ ] **17.004** `[Build]` Build Maven release artifact with `package` and locate real `target/*.jar` filename.
- [ ] **17.005** `[Verify]` Launch executable JAR from terminal and confirm Spring startup without IntelliJ Run configuration.
- [ ] **17.006** `[Break/fix]` Run JAR with invalid DB credentials in controlled environment and identify root connection exception.
- [ ] **17.007** `[Build]` Externalize datasource URL, username and password so they are not hardcoded in packaged code.
- [ ] **17.008** `[Build]` Build frontend with appropriate npm build script and identify `dist/` output.
- [ ] **17.009** `[Verify]` Preview production frontend build locally and test direct route navigation.
- [ ] **17.010** `[Concept]` Explain difference between development Vite server and static production files.
- [ ] **17.011** `[Inspect]` Decide hosting options/cost limits before provisioning any paid services; AWS/Netlify are the book's examples, not mandatory paid choices.
- [ ] **17.012** `[Inspect]` Choose DB strategy (managed MariaDB-compatible instance or hosted VM) and document backup and connectivity constraints.
- [ ] **17.013** `[Build]` Provision an isolated deployment database and a limited-privilege app user if you elect to deploy.
- [ ] **17.014** `[Break/fix]` Verify DB cannot be accessed from arbitrary public clients unless explicitly required and protected.
- [ ] **17.015** `[Build]` Configure backend deployment environment variables/secrets through host mechanisms.
- [ ] **17.016** `[Build]` Deploy running backend service to supported AWS hosting option (book-aligned example) under chosen account.
- [ ] **17.017** `[Verify]` Read production backend health/availability status from a safe endpoint and log sample.
- [ ] **17.018** `[Build]` Configure HTTPS on public API endpoint before sending authentication credentials.
- [ ] **17.019** `[Build]` Restrict production CORS origins to the actual frontend domain(s).
- [ ] **17.020** `[Break/fix]` Attempt an unexpected origin or unauthenticated mutation and observe rejection appropriate to security design.
- [ ] **17.021** `[Build]` Deploy built React assets to Netlify (book-aligned example) with correct build directory.
- [ ] **17.022** `[Build]` Configure production API base URL at frontend build time as intended.
- [ ] **17.023** `[Build]` Configure fallback/redirect for client-side routes to avoid 404 on direct navigation.
- [ ] **17.024** `[Verify]` Open deployed login and car page over HTTPS.
- [ ] **17.025** `[Verify]` Perform real create → read → edit → delete from deployed browser with non-production test data.
- [ ] **17.026** `[Verify]` Ensure expected unauthorized request remains blocked after deployment.
- [ ] **17.027** `[Inspect]` Check deployment logs for leaked DB connection string, JWT signing keys or user credentials; fix if present.
- [ ] **17.028** `[Concept]` Explain image versus container, JDK build versus JRE runtime, and published network port.
- [ ] **17.029** `[Build]` Create a Dockerfile using a suitable current Java runtime base and the built executable JAR.
- [ ] **17.030** `[Build]` Build Docker image and inspect build output and approximate image contents.
- [ ] **17.031** `[Build]` Run container locally using environment variables rather than embedding secrets in the image.
- [ ] **17.032** `[Verify]` Hit same API using container port mapping and confirm requests reach service.
- [ ] **17.033** `[Break/fix]` Stop database while container runs and inspect failure/readiness handling.
- [ ] **17.034** `[Build]` Optionally create Compose configuration for backend + MariaDB local development; exclude literal secrets.
- [ ] **17.035** `[Build]` Document a reproducible local build/run/deploy procedure in README or runbook.
- [ ] **17.036** `[Build]` Document how to stop cloud resources and avoid unexpected costs.
- [ ] **17.037** `[Build]` Document a basic rollback using previous deployment artifact and DB backup considerations.
- [ ] **17.038** `[Git checkpoint]` Push Dockerfile, deploy configuration examples and runbook but no environment secret values.

**Gate 17:** Release artifact runs locally, chosen hosted backend/frontend communicate securely, and documented rollback/stop steps exist.

---

## Stage 18 — Professional extensions and portfolio review

**Scope:** Outside the book — optional extensions. **Printed pages:** not in book.  
**Continuity:** `CI` → `validation` → `DTO/service` → `migrations` → `observability` → `portfolio evidence`.  

- [ ] **18.001** `[Concept]` Explain why these additions go beyond the book instead of silently rewriting its syllabus.
- [ ] **18.002** `[Build]` Create a GitHub Actions build workflow triggered on pull requests.
- [ ] **18.003** `[Build]` Build/test Maven backend in CI under documented Java version.
- [ ] **18.004** `[Build]` Install dependencies and test/build frontend in CI under documented Node version.
- [ ] **18.005** `[Break/fix]` Commit a deliberately failing test to a temporary branch and verify CI actually blocks a merge.
- [ ] **18.006** `[Build]` Add validation annotations to car/owner inputs with clear error messages.
- [ ] **18.007** `[Build]` Test missing brand, impossible model year, negative price and invalid foreign key using API tests.
- [ ] **18.008** `[Concept]` Explain Java entity versus request/response DTO and the tradeoffs of exposing persistence classes.
- [ ] **18.009** `[Build]` Introduce DTOs at an API boundary where persistence details should stay internal.
- [ ] **18.010** `[Build]` Introduce explicit service layer for a real inventory rule and trace controller → service → repository.
- [ ] **18.011** `[Verify]` Prove service rules through focused tests.
- [ ] **18.012** `[Build]` Define a consistent JSON error response and central exception handler where using explicit controllers.
- [ ] **18.013** `[Verify]` Check authentication errors and validation errors do not leak stack traces.
- [ ] **18.014** `[Concept]` Explain DB schema evolution; compare H2 auto-DDL approach with Flyway/Liquibase migrations.
- [ ] **18.015** `[Build]` Write first migration for a controlled test environment and document existing-schema transition.
- [ ] **18.016** `[Build]` Apply a new migration and verify fresh and existing DBs reach expected schema.
- [ ] **18.017** `[Break/fix]` Make an invalid migration in a disposable database and inspect migration failure safeguards.
- [ ] **18.018** `[Build]` Run an isolated integration test against MariaDB container if environment supports it.
- [ ] **18.019** `[Build]` Introduce structured logging/correlation identifiers only where they improve tracing real requests.
- [ ] **18.020** `[Build]` Add a dependency update checklist/security scan appropriate to the repository.
- [ ] **18.021** `[Build]` Draw a final architecture picture with Java method names and arrowed dependencies from repo.
- [ ] **18.022** `[Build]` Write README startup steps with exact commands confirmed against actual repo, not guessed boilerplate.
- [ ] **18.023** `[Build]` Document API endpoints and expected auth rules in a concise API table.
- [ ] **18.024** `[Build]` Create a developer walkthrough of one create/edit/delete trace with filenames, methods and DB effects.
- [ ] **18.025** `[Build]` Prepare an interview narrative based only on features actually implemented, with no invented company experience.
- [ ] **18.026** `[Verify]` Rebuild the project from a clean checkout and document any missing prerequisites.
- [ ] **18.027** `[Git checkpoint]` Tag a verified milestone after tests, startup and real CRUD demonstration all pass.

**Gate 18:** Optional refinements are backed by tests, documented architectural decisions and a reproducible demonstration.

---

## Individual challenge delivery contract (for our future turns)

```text
CHALLENGE ID: <stage.microtask>
Book link: Chapter + printed page/heading where applicable
Developer story: Why this change is needed in the current product
State of repo: What I verified from the latest GitHub files/commit
Prerequisites: Which verified earlier task/file this depends on
Expected outcome: What the user or program will be able to do
IntelliJ directions: Exact existing file/package/window/terminal operation
Your assignment: 1–3 small actions (not the complete final code)
Code connection: Caller → callee → dependency → effect on persisted data/UI
Definition of Done: Observable positive test/result
Failure drill: Safe specific negative case and what it teaches
Evidence: Commit/diff + local console or browser result when relevant
Questions: Why this file? Why this method? What breaks if removed?
Next: Only after verifying the current task
```

### Fully specified example: Stage 0, task 0.001

**Developer story:** An existing folder is described as an empty Java practice workspace, but it may already contain the starter Maven project. Building a duplicate project would create confusion and destroy continuity.

**Your mission:** In IntelliJ IDEA choose **File → Open** and select `C:\Users\sabar\OneDrive\Desktop\Java_Practice`. Wait for indexing/import. Do not select **New Project**, do not delete files, and do not add a second nested Maven root. In the Project tool window, identify the actual project root; look specifically for `pom.xml` and `src`. Open IntelliJ's integrated terminal and compare the terminal working directory to the folder you opened.

**Expected evidence:** A screenshot of the Project tool window, plus either a terminal path or a Git push allowing inspection of the exact structure. If `pom.xml` is absent, that is a finding, not a failure: the next challenge adapts to what really exists.

**Trace question:** Why does IntelliJ opening a folder not by itself guarantee the project was imported as a Maven model? **Failure example:** opening a parent folder while terminal commands run in a child `src` directory—how would that affect `mvn test`?

**Finish condition:** The root and current files are known and no data was overwritten. Then move to task `0.002`.

## Review and learning rules

1. On **next**, review latest remote status first, tell the user whether the previous task is verified, and issue exactly one next micro-challenge (or a naturally grouped set if the user asks for a set).
2. The user types the code in IntelliJ; I guide but do not claim to see their screen, run their local JDK, or confirm unpushed files.
3. For any method we touch, cover: **what it does; why this file owns it; its arguments/return; who invokes it; downstream effects; test; what fails when it is wrong.**
4. Mark user-specific adaptations distinctly from the book. The book is a syllabus and source of coding examples, not a claim that our Java 21/Maven code matches the author character-for-character.
5. If the actual GitHub project diverges, revise the **implementation path**, not the verified chapter objective; preserve history and avoid rewriting already working code.
6. Never commit credentials, signing secrets or local DB passwords. Deployment steps can incur costs: request account/provider preferences before provisioning anything chargeable.
7. Stop at the earliest failing gate and diagnose it before continuing. Do not mark tests passed based on code inspection alone.
