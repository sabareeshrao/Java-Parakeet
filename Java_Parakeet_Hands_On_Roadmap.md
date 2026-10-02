# Java-Parakeet — Hands-on Full-Stack Project Roadmap

**Learning source:** *Full Stack Development with Spring Boot 3 and React*, 4th edition, Juha Hinkula (uploaded PDF; chapters 1–17).  
**Your local workspace:** `C:\Users\sabar\OneDrive\Desktop\Java_Practice`  
**GitHub:** https://github.com/sabareeshrao/Java-Parakeet  
**Development IDE:** IntelliJ IDEA only; use its integrated terminal and browser developer tools.  
**JDK:** Microsoft OpenJDK 21, as selected by you. **Build:** Maven, not the book's Gradle.  
**Product:** A car inventory/ownership management system, growing from Java skeleton into a Spring Boot REST API and then a React + TypeScript frontend.  
**Verified remote starting state (2026-10-01):** GitHub repository is empty; no tracked files or commits. Your local workspace has not been inspected.  
**Important:** The 2023 book uses Spring Boot 3.1, Java 17, Gradle, Eclipse, and React 18. Our deliberate adaptations are Maven, IntelliJ, Java 21 and appropriately compatible dependency versions. For lessons involving newer tools, check compatibility before copying old configuration. These changes are not claims about the book.

## Working agreement

1. Each task has an ID (`3.07`) and a concrete change to make yourself in IntelliJ.
2. We do not declare any task complete from your description alone. We verify the matching files/commit/CI on GitHub; terminal-only outcomes may require you to paste logs or screenshots.
3. We do not restart or overwrite your existing project to imitate a chapter example. We apply the book's concepts incrementally to the current repository.
4. Challenge delivery format: **Goal → Why it matters → Prerequisites → Exact IntelliJ/files/actions → Expected behavior → Tests/verification → Deliverable → Git commit message → Review questions.** A hint comes before a full solution; solutions only when you ask or become blocked.
5. Commit after each coherent milestone, not after every keystroke; keep credentials, actual `.env` files, target output, node_modules, and IDE caches out of Git.
6. At the start of a next-challenge request, review the last commit and changed files on `main`; use the remote code as evidence, and call out work not yet pushed. Verify all unfinished prerequisites before choosing the next task.
7. The author’s example implementation is a study reference, not your repository’s present state. No task below is marked complete until reviewed.

## Planned root structure (adapt to existing files rather than deleting/recreating)

```text
Java_Practice/                       # existing IntelliJ Maven project directory
├── pom.xml                          # Spring Boot backend, Maven
├── mvnw / mvnw.cmd                   # Maven wrapper, if present/added
├── src/
│   ├── main/java/<your-base-package>/
│   │   ├── ...Application.java
│   │   ├── domain/                   # Car, Owner, AppUser
│   │   ├── repository/               # CarRepository, OwnerRepository, AppUserRepository
│   │   ├── service/                  # business and authentication services
│   │   ├── security/                 # JWT/security configuration
│   │   └── config/                   # OpenAPI and other configuration
│   ├── main/resources/application.properties
│   └── test/java/<your-base-package>/
├── frontend/                         # React + TypeScript + Vite, added later
├── docs/
│   ├── progress.md                   # evidence-backed task tracker
│   └── decisions.md                  # book → your project adaptations
├── .gitignore
├── .env.example                      # safe placeholders only, later
└── README.md
```

The folder and Java package names above are **proposals**, not claims about files already on your computer. We decide the actual package after reading your first push.

---

## Stage 0 — Recover your existing local project and establish the source of truth (project preflight; extra to book)

- [ ] **0.01** Open `C:\Users\sabar\OneDrive\Desktop\Java_Practice` in IntelliJ; confirm whether `pom.xml`, `src/main/java`, and `src/test/java` already exist.
- [ ] **0.02** Inspect the New Project choices you described: project name, base package, Java language, Maven build, and Microsoft OpenJDK 21; record the actual values without assuming.
- [ ] **0.03** Run a minimal Java `main` class already generated, if present, and capture console output.
- [ ] **0.04** Run `java -version` and the Maven version command (`mvn -version` or `./mvnw -version` if a wrapper exists) from IntelliJ Terminal. Ensure it sees JDK 21.
- [ ] **0.05** Open `pom.xml`; identify `<groupId>`, `<artifactId>`, `<version>`, Java configuration, and current dependencies.
- [ ] **0.06** Add/review a Java-and-Node-aware `.gitignore` that excludes `.idea/` machine-specific state, `target/`, `node_modules/`, and private secrets (without blindly excluding useful shared project configuration).
- [ ] **0.07** Add a short `README.md` identifying the app, tools, and current run command.
- [ ] **0.08** Check whether the local folder is already a Git repo using `git status`; initialize only if required and link it to `https://github.com/sabareeshrao/Java-Parakeet.git`.
- [ ] **0.09** Make the first commit of your **existing** source and push `main`; resolve any Git remote/upstream/authentication issue without deleting files.
- [ ] **0.10** Review the remote tree, initial commit, project build file, and commit history together. Record the first verified checkpoint in `docs/progress.md`.

**Gate 0:** Remote `main` contains the real IntelliJ project. A working run/build is demonstrated. **Suggested commit:** `chore: establish Java Practice Maven project`.

## Stage 1 — Book Chapter 1: Backend environment, build system, first Spring Boot launch (printed pages 1–20)

- [ ] **1.01** Distinguish JDK, `javac`, JVM, source files, class files, and Java version from an actual terminal output.
- [ ] **1.02** Compare the book's Gradle tasks/dependency declarations to equivalent Maven lifecycle goals and `pom.xml` declarations.
- [ ] **1.03** Choose a Spring Boot 3.x version compatible with JDK 21 after checking its official compatibility matrix; record why the book's Spring Boot 3.1 example is not being copied blindly.
- [ ] **1.04** Convert the existing root Maven Java project into a Spring Boot backend **in place**, preserving Git history, group/package structure and application files when practical.
- [ ] **1.05** Add the equivalent of the book's Spring Web and Spring Boot DevTools starters in Maven.
- [ ] **1.06** Find/create the application entry point; inspect `@SpringBootApplication`, `main(String[] args)`, and `SpringApplication.run(...)`.
- [ ] **1.07** Run the application from IntelliJ; locate the embedded server start message and any errors in Run/Debug console.
- [ ] **1.08** Run the application from Maven in the IntelliJ terminal; compare IDE launch versus CLI launch.
- [ ] **1.09** Try modifying/saving a development class and observe whether DevTools restarts the application (depending on IntelliJ's compile-on-save setup).
- [ ] **1.10** Add an SLF4J logger and verify an INFO message; adjust a logging level in `application.properties` and examine the output.
- [ ] **1.11** Demonstrate how `server.port` affects startup and how to diagnose a port-already-in-use error.
- [ ] **1.12** Install/verify MariaDB locally or via a local container for the later persistence stage; do not commit root/admin database credentials.

**Gate 1:** A Spring Boot backend launches cleanly under Maven/JDK 21, logs are understood, and the commit is pushed. **Suggested commit:** `feat: bootstrap Spring Boot backend with Maven`.

## Stage 2 — Book Chapter 2: Dependency injection (printed pages 21–26)

- [ ] **2.01** Create a minimal Java example where a class constructs its own dependency; identify tight coupling.
- [ ] **2.02** Refactor the example to constructor injection; explain which class creates the dependency and which consumes it.
- [ ] **2.03** Contrast mandatory constructor injection with optional setter injection through a small exercise.
- [ ] **2.04** Add a Spring-managed `@Service` bean connected to the car-inventory business context.
- [ ] **2.05** Inject the service into a second bean through its constructor and demonstrate component scanning.
- [ ] **2.06** Compare `@Service`, `@Repository`, `@Component`, `@Configuration`, and `@Autowired` in the actual project; do not add unnecessary annotations just to display them.
- [ ] **2.07** Replace a concrete dependency with an interface or test double to demonstrate how DI improves testability.

**Gate 2:** Spring creates and injects the service, and you can explain the dependency path. **Suggested commit:** `feat: practice Spring dependency injection`.

## Stage 3 — Book Chapter 3: JPA, Hibernate, Car/Owner entities, repositories, MariaDB (printed pages 27–60)

- [ ] **3.01** Explain ORM vs JPA specification vs Hibernate implementation, using the future Car table as the example.
- [ ] **3.02** Add Maven dependencies for Spring Data JPA and a development-only in-memory H2 database.
- [ ] **3.03** Create a `Car` entity with `id`, `brand`, `model`, `color`, `registrationNumber`, `modelYear`, and `price`.
- [ ] **3.04** Add JPA identity annotations, default and field-based constructors, getters, and setters; verify the correct `jakarta.persistence` imports.
- [ ] **3.05** Inspect generated schema/SQL logging; identify how class fields become database columns.
- [ ] **3.06** Create `CarRepository` and use `save`, `saveAll`, `findAll`, and `findById` in a small startup data exercise.
- [ ] **3.07** Add derived finder exercises such as searching by brand; check results with seeded example cars.
- [ ] **3.08** Create the `Owner` entity and `OwnerRepository`.
- [ ] **3.09** Map the one-owner-to-many-cars relationship with `@ManyToOne`, `@OneToMany`, and the appropriate `mappedBy` field.
- [ ] **3.10** Seed owners first, then associate and save cars; inspect foreign keys and confirm data retrieval.
- [ ] **3.11** Explore how entity relationships affect JSON serialization and cascade/deletion behavior; avoid destructive defaults without understanding them.
- [ ] **3.12** Set up a MariaDB database for the application with a dedicated application user; keep actual credentials out of Git.
- [ ] **3.13** Switch persistence configuration from H2 to MariaDB and prove records persist after an application restart.
- [ ] **3.14** Run manual repository queries and verify row counts, relationships, schema, and startup logs.

**Gate 3:** You can restart Spring Boot and read real `Car` records associated with `Owner` in MariaDB. **Suggested commit:** `feat: persist cars and owners with JPA`.

## Stage 4 — Book Chapter 4: RESTful API and API documentation (printed pages 61–84)

- [ ] **4.01** Understand resources, HTTP methods, request/response payloads, status codes, and JSON with car inventory examples.
- [ ] **4.02** Implement a small `@RestController` endpoint to examine request routing independently of database persistence.
- [ ] **4.03** Add Spring Data REST to `pom.xml` and configure the API base path, adapting the book's Gradle dependency to Maven.
- [ ] **4.04** Expose `CarRepository` and `OwnerRepository` resources deliberately; inspect the generated `/api` entry point.
- [ ] **4.05** Inspect HAL responses, `_embedded`, `_links`, and the difference from a plain JSON array.
- [ ] **4.06** Make GET requests to list cars, retrieve one car, and view owner-related links.
- [ ] **4.07** Make POST requests with sample car data and verify a persisted record and meaningful HTTP response.
- [ ] **4.08** Make PATCH/PUT and DELETE requests; verify which semantics the exposed resource supports.
- [ ] **4.09** Explore query methods, sorting, paging, and REST exposure boundaries on the repositories.
- [ ] **4.10** Add `springdoc-openapi` with a version compatible with the chosen Spring Boot release; configure API title, description, and version.
- [ ] **4.11** Open Swagger UI, inspect endpoint documentation, and perform at least one `Try it out` request.
- [ ] **4.12** Write a brief `docs/api.md` containing URLs, request examples, status codes, and an API response sample.

**Gate 4:** CRUD calls from a client work against MariaDB and the API is discoverable/documented. **Suggested commit:** `feat: expose documented car inventory API`.

## Stage 5 — Book Chapter 5: Spring Security, JWT, roles and OAuth2 concepts (printed pages 85–122)

- [ ] **5.01** Add Spring Security and its testing support in Maven; observe the default authentication behavior.
- [ ] **5.02** Trace a request through a Spring Security filter chain and distinguish authentication from authorization.
- [ ] **5.03** Create `AppUser` fields for username, password hash, role, and persistent identity.
- [ ] **5.04** Create `AppUserRepository` with user lookup by username.
- [ ] **5.05** Implement a `UserDetailsService`/adapter and constructor injection needed for authentication.
- [ ] **5.06** Hash seeded passwords with a supported password encoder; never store plaintext application passwords.
- [ ] **5.07** Configure a `SecurityFilterChain` with a public login endpoint and protected API endpoints.
- [ ] **5.08** Implement a JWT issuing component and a login endpoint; use a securely managed key, suitable signing algorithm and expiry.
- [ ] **5.09** Validate incoming JWT signatures, expiry and claims with an authentication filter or supported security configuration.
- [ ] **5.10** Verify the negative cases: no token, malformed token, expired token, and insufficient role.
- [ ] **5.11** Configure roles/authorities and test at least one role-specific access rule.
- [ ] **5.12** Configure the required CORS policy for the frontend development origin; distinguish CORS from authentication and CSRF.
- [ ] **5.13** Explore the book's OAuth2 section as an optional integration experiment without replacing JWT login accidentally.

**Gate 5:** Expected 200/201, 401, and 403 responses can be demonstrated for relevant users and requests. **Suggested commit:** `feat: secure API with role-aware JWT authentication`.

## Stage 6 — Book Chapter 6: Backend testing and TDD (printed pages 123–135)

- [ ] **6.01** Identify unit tests, repository integration tests, HTTP integration tests, and which dependencies each requires.
- [ ] **6.02** Set up Spring Boot Test/JUnit 5 with Maven and understand `src/test/java` conventions.
- [ ] **6.03** Write a failing-first test for a small pure-Java business rule, implement the behavior, and refactor.
- [ ] **6.04** Test constructor-injected service behavior using a test double/mock for the repository.
- [ ] **6.05** Write a data/repository test for saving and finding cars with controlled test data.
- [ ] **6.06** Test a valid API request including status, JSON body, and persisted result.
- [ ] **6.07** Test unauthorized and forbidden API requests with Spring Security test utilities.
- [ ] **6.08** Keep test credentials and database config isolated from production configuration.
- [ ] **6.09** Run tests using IntelliJ and Maven (`mvn test` or wrapper equivalent); fix failures before committing.

**Gate 6:** Test suite passes locally; security and persistence have repeatable checks. **Suggested commit:** `test: cover Spring Boot backend behavior`.

## Stage 7 — Book Chapter 7: Frontend environment and React startup (printed pages 139–151)

- [ ] **7.01** Install or verify an appropriate Node.js LTS and npm toolchain in IntelliJ Terminal.
- [ ] **7.02** Describe the role of Node.js, npm, package.json, package-lock.json, and node_modules.
- [ ] **7.03** Create the first frontend app **inside the existing repo** as `frontend/`; do not make a separate Git repository within it.
- [ ] **7.04** Choose a Vite + React starter that will be compatible with the TypeScript conversion in Chapter 9; record deviations from the book.
- [ ] **7.05** Open frontend source in IntelliJ IDEA and run npm scripts using its terminal.
- [ ] **7.06** Inspect the entry HTML, JavaScript/TypeScript entry point, and root React component.
- [ ] **7.07** Edit visible application text/styles, view browser live update, and identify the dev server port.
- [ ] **7.08** Use browser DevTools and IntelliJ debugging/logs to diagnose a simple frontend error.

**Gate 7:** Browser shows a locally running React app; `frontend/` is tracked with dependency lockfile and no `node_modules/`. **Suggested commit:** `feat: initialize React frontend in monorepo`.

## Stage 8 — Book Chapter 8: React fundamentals (printed pages 153–198)

- [ ] **8.01** Decompose a static car-inventory landing page into reusable React components.
- [ ] **8.02** Understand JavaScript constants, variables, arrow functions, destructuring and template literals through small frontend examples.
- [ ] **8.03** Create and import components; inspect JSX return trees and their rendered HTML.
- [ ] **8.04** Pass car details via props and explain one-way data flow.
- [ ] **8.05** Store dynamic UI data in component state with `useState`.
- [ ] **8.06** Implement conditional rendering for loading, error, empty, and populated states.
- [ ] **8.07** Render car lists from an array; use stable keys and verify list changes.
- [ ] **8.08** Add event handlers for a selected car, search query, and basic button clicks.
- [ ] **8.09** Add a controlled form and validate a sample car's inputs without submitting to the backend yet.
- [ ] **8.10** Use `useEffect` for an external synchronization example and understand cleanup.
- [ ] **8.11** Use `useRef` to manage a DOM input or other non-rendering value where appropriate.
- [ ] **8.12** Build one custom hook to reuse stateful frontend behavior.
- [ ] **8.13** Explore React Context for a genuinely shared setting; explain why not every prop belongs in Context.
- [ ] **8.14** Demonstrate React state batching and functional updates with an observed behavior.

**Gate 8:** The inventory UI renders local car data; props, events, forms and hooks can be explained from actual components. **Suggested commit:** `feat: practice reusable React inventory components`.

## Stage 9 — Book Chapter 9: TypeScript and typed React (printed pages 199–218)

- [ ] **9.01** Identify the difference between runtime JavaScript and compile-time TypeScript checks.
- [ ] **9.02** Practice basic types, interfaces/types, optional properties, unions, and typed arrays.
- [ ] **9.03** Type a function's parameters, object return shape, and asynchronous results.
- [ ] **9.04** Define a `Car` frontend type mirroring the API response, accounting for backend-generated links separately if HAL is retained.
- [ ] **9.05** Type component props and React state.
- [ ] **9.06** Type form and click events and avoid blanket use of `any`.
- [ ] **9.07** Convert any earlier JavaScript components to `.tsx` incrementally if they were not created in TypeScript initially.
- [ ] **9.08** Run the TypeScript checker and frontend build; resolve incompatibilities introduced by conversion.

**Gate 9:** React compiles with typed component props and a documented `Car` API type. **Suggested commit:** `refactor: type React frontend with TypeScript`.

## Stage 10 — Book Chapter 10: Calling REST APIs from React (printed pages 219–249)

- [ ] **10.01** Use a Promise to explain pending/fulfilled/rejected results and error handling.
- [ ] **10.02** Call a public practice endpoint with `fetch()`; inspect request, response, and JSON parsing.
- [ ] **10.03** Rewrite the flow with `async`/`await` and `try`/`catch`.
- [ ] **10.04** Compare `fetch` with Axios using a small focused experiment; choose one primary client for the app.
- [ ] **10.05** Reproduce a simplified public API exercise inspired by the book's OpenWeather/GitHub API examples (avoid embedding API keys).
- [ ] **10.06** Create a typed API client for your backend's `/api/cars` endpoint, including its HAL wrapper if applicable.
- [ ] **10.07** Implement visible loading, failure and retry states.
- [ ] **10.08** Demonstrate a stale-response/race-condition scenario and fix it using cancellation or query state management.
- [ ] **10.09** Add TanStack/React Query and manage caching, loading and invalidation according to its installed version.
- [ ] **10.10** Keep API origins and optional external service keys in appropriately scoped environment variables; understand which frontend variables become public.

**Gate 10:** React can fetch and display backend car data and recover from an API failure. **Suggested commit:** `feat: consume car API with typed React queries`.

## Stage 11 — Book Chapter 11: React component libraries (printed pages 251–280)

- [ ] **11.01** Evaluate adding a third-party dependency against app requirements; examine package version and documentation.
- [ ] **11.02** Install and render AG Grid in a small experimental inventory view.
- [ ] **11.03** Try at least one grid behavior (sort/filter/pagination) and compare it conceptually with the MUI Data Grid used in the later book chapters.
- [ ] **11.04** Install and configure Material UI (MUI) and the libraries required by selected components.
- [ ] **11.05** Build an inventory layout with MUI containers, typography, buttons, and a table/grid.
- [ ] **11.06** Install React Router and add two navigable routes to the same frontend app.
- [ ] **11.07** Add a fallback route and test direct URL navigation or refresh.
- [ ] **11.08** Remove or isolate unused experiment components so they do not bloat the production inventory view.

**Gate 11:** Styled navigation and a table/grid render without console errors. **Suggested commit:** `feat: add UI components and routing`.

## Stage 12 — Book Chapter 12: Full-stack integration planning (printed pages 283–291)

- [ ] **12.01** Define a user story for viewing the car list and acceptance criteria for paging, sorting, and filtering.
- [ ] **12.02** Define user stories for adding, editing, deleting and CSV export.
- [ ] **12.03** Sketch the car list view and add/edit modal before changing application code.
- [ ] **12.04** Compare the current frontend schema/API client to the backend response shape.
- [ ] **12.05** Start backend and frontend together and inspect cross-origin network requests.
- [ ] **12.06** Configure a **development-only** permitted origin or profile for early integration; retain the secure baseline separately and explicitly rather than accidentally leaving the final API public.
- [ ] **12.07** Verify that the React app can read a real seeded car record from the backend.
- [ ] **12.08** Record the final car-list UI specification and reconcile against the book's mock-up.

**Gate 12:** Both apps start together and the agreed interface is sketched and backed by real API data. **Suggested commit:** `chore: prepare full-stack car inventory integration`.

## Stage 13 — Book Chapter 13: Complete car inventory CRUD UI (printed pages 293–337)

- [ ] **13.01** Make a reusable API response mapper if Spring Data REST exposes `_embedded.cars` and hypermedia URLs.
- [ ] **13.02** Build a car list page with columns for brand, model, color, registration, year and price.
- [ ] **13.03** Display fetched cars in MUI Data Grid with stable row identification.
- [ ] **13.04** Add paging and verify both page changes and total-record behavior.
- [ ] **13.05** Add sorting and filtering; note whether they happen client-side or server-side.
- [ ] **13.06** Handle empty, loading, transient error, and successful states in the grid.
- [ ] **13.07** Add a delete action connected to the backend, with a confirmation modal.
- [ ] **13.08** Display success/failure toast or Snackbar feedback after deletion.
- [ ] **13.09** Invalidate/refetch the query after a successful deletion so the UI is consistent with the database.
- [ ] **13.10** Build a controlled modal form for adding a car.
- [ ] **13.11** Validate required fields and numeric values before posting.
- [ ] **13.12** Persist the new car through the API and refresh the grid without a page reload.
- [ ] **13.13** Reuse the form for editing an existing car and prepopulate existing values.
- [ ] **13.14** Submit an update and verify it survives page reload/backend restart.
- [ ] **13.15** Add CSV export and check headers, escaping, and exported row values.
- [ ] **13.16** Review requests in browser Network panel and fix any silent/duplicate/misrouted calls.

**Gate 13:** Full add/list/edit/delete/CSV flows work against database-backed data. **Suggested commit:** `feat: complete React car inventory CRUD`.

## Stage 14 — Book Chapter 14: Refine frontend with MUI (printed pages 339–349)

- [ ] **14.01** Replace inconsistent native buttons with suitable MUI Button components.
- [ ] **14.02** Add meaningful icons and icon buttons with accessible labels.
- [ ] **14.03** Replace or refine car form inputs with MUI TextField components and validation messages.
- [ ] **14.04** Style layout, spacing, typography, alignment and empty/error states consistently.
- [ ] **14.05** Inspect the UI at narrow and wide browser sizes.
- [ ] **14.06** Verify keyboard access to controls, modal close behavior and focus visibility.
- [ ] **14.07** Remove CSS duplication and make the inventory view visually coherent.

**Gate 14:** Consistent, usable inventory forms and controls. **Suggested commit:** `style: refine inventory UI with MUI`.

## Stage 15 — Book Chapter 15: React tests and end-to-end thinking (printed pages 351–367)

- [ ] **15.01** Explain unit, component, integration and end-to-end test boundaries for the frontend.
- [ ] **15.02** Understand where Jest, React Testing Library and Vitest fit; select a compatible test runner for the actual Vite setup.
- [ ] **15.03** Configure Vitest and React Testing Library with a DOM-like testing environment.
- [ ] **15.04** Write a basic rendering test with a meaningful user-facing assertion.
- [ ] **15.05** Test the car list loading and empty states.
- [ ] **15.06** Mock the API/query boundary to test success and failure render states deterministically.
- [ ] **15.07** Fire a button/event interaction and assert the resulting visible behavior.
- [ ] **15.08** Test add/edit/delete validation or confirmation flows without depending on a live database.
- [ ] **15.09** Outline or implement one end-to-end scenario covering browser-to-API-to-database behavior.
- [ ] **15.10** Run tests plus the optimized frontend build before the commit.

**Gate 15:** A repeatable frontend test suite passes, including an interaction test. **Suggested commit:** `test: cover car inventory frontend`.

## Stage 16 — Book Chapter 16: Integrate secured frontend login (printed pages 369–388)

- [ ] **16.01** Restore the protected backend endpoints using the secure configuration from Chapter 5.
- [ ] **16.02** Observe/interpret the expected 401 response from an unauthenticated React API request.
- [ ] **16.03** Create a controlled login form for username and password.
- [ ] **16.04** Submit credentials to the backend login endpoint and handle rejected credentials.
- [ ] **16.05** Handle the returned JWT using an explicitly documented session approach; treat frontend storage as a security trade-off rather than a universal default.
- [ ] **16.06** Include the token in authorized API requests without duplicating auth logic in every component.
- [ ] **16.07** Handle expired/invalid token responses by prompting reauthentication.
- [ ] **16.08** Protect route visibility and role-based UI behaviors while recognizing the backend remains the authority.
- [ ] **16.09** Add logout and clear relevant in-memory/session data.
- [ ] **16.10** Retest CRUD: valid login, invalid login, no login, logout, and insufficient privilege.

**Gate 16:** Authenticated UI can perform authorized CRUD; unauthorized access is denied by backend. **Suggested commit:** `feat: integrate secure React login`.

## Stage 17 — Book Chapter 17: Packaging, hosting and Docker (printed pages 389–415)

- [ ] **17.01** Explain deployment components: frontend build, backend executable JAR, database and environment secrets.
- [ ] **17.02** Package the Spring Boot backend with Maven (`mvn clean package`, or the project's Maven wrapper).
- [ ] **17.03** Run the packaged JAR locally and confirm environment-specific properties work.
- [ ] **17.04** Create a production frontend build with npm and test the output locally.
- [ ] **17.05** Provision a MariaDB deployment or managed database; decide credential, networking and backup strategy before loading data.
- [ ] **17.06** Deploy the backend to a suitable AWS service (book's deployment provider), choosing an appropriate supported Java runtime.
- [ ] **17.07** Configure HTTPS, database secrets and allowed frontend origins; avoid exposing database connections publicly.
- [ ] **17.08** Deploy the React build to Netlify (book's frontend provider).
- [ ] **17.09** Configure production API URL, routing fallback and login/cookie/token behavior for the deployed origin.
- [ ] **17.10** Test a real browser CRUD operation and one expected unauthorized response against the deployed environment.
- [ ] **17.11** Create a Dockerfile for the Spring Boot backend with a suitable JRE base and minimal runtime contents.
- [ ] **17.12** Run the backend container locally; if useful, add a development Compose setup with MariaDB.
- [ ] **17.13** Document start/stop/deploy/rollback steps and expected provider charges before enabling paid cloud resources.

**Gate 17:** Full-stack app is accessible through the chosen deployment, can be built/run as a JAR and in Docker, and has a written runbook. **Suggested commit:** `chore: package and document full-stack deployment`.

## Stage 18 — Optional professional extensions (NOT asserted as book chapters)

- [ ] **18.01** Add GitHub Actions workflow that runs backend build/tests and frontend build/tests on pull requests.
- [ ] **18.02** Add input validation with helpful API errors, constraints, and negative tests.
- [ ] **18.03** Add explicit service layer for inventory rules and data-transfer objects where needed.
- [ ] **18.04** Add database schema migrations (Flyway or Liquibase) and stop relying on automatic schema updates for deployment.
- [ ] **18.05** Add structured API error handling and correlation/logging basics.
- [ ] **18.06** Build reproducible integration tests with an isolated MariaDB container where supported.
- [ ] **18.07** Refine secrets/config practices, least-privilege user roles, dependency checks and documentation.
- [ ] **18.08** Build an interview portfolio: architectural diagram, endpoints table, source trace, demo script, and project challenges discussed.

**Gate 18:** Additional professional practices with traceable tests and documentation. **Suggested commit:** `chore: add production-readiness checks`.

---

## How I will assign one task (example; do not mark as complete)

**Challenge 0.01 — Verify your IntelliJ starter project**  
**Scenario:** You have created a Maven Java project locally, but the remote repository is still empty. We need to establish what really exists before adding Spring Boot.  
**Your action:** Open the exact local folder in IntelliJ, show the root Project tool window, identify `pom.xml`, `src/main/java` and the main class (if present); open the IntelliJ terminal and run `git status`, `java -version`, and `mvn -version` (or the wrapper equivalent).  
**Success criterion:** You can identify the actual source root, dependency coordinates, running Java version and current Git status.  
**Evidence to send:** Push the files to `main` and say **“Review 0.01–0.10”**; if the push is blocked, provide the terminal error.  
**What I will review:** remote tree, Maven POM, `.gitignore`, file/package placement, first commit and any missing prerequisites.  
**What I will NOT assume:** That a paragraph describing IntelliJ's Create dialog proves the local files exist; or that the GitHub repository mirrors your local working tree.

## Review / next-challenge protocol

For every **“Review my repo”** or **“Next challenge”** request:

1. Read `main`'s current tree and recent commits in `sabareeshrao/Java-Parakeet`.
2. Inspect new/modified implementation and test files, not only the commit message.
3. Reconcile the task ID(s) against verified code and execution evidence; give **Verified / Needs evidence / Incomplete** for the relevant milestones.
4. State what the new code does, why it exists, which earlier classes it depends on, which later feature will use it, and any bugs or inconsistencies.
5. Give exactly one next hands-on challenge at the current skill level, with instructions and a clear definition of done.
6. Update a progress file only after you explicitly ask for changes to be written to GitHub; merely reading and reviewing does not modify your repo.

**Book attribution:** Parts I–III, 17-chapter sequence and the core car database / React CRUD / security / deployment flow are grounded in the uploaded book. Task granularity, stage 0, stage 18, Maven adaptations, and specific acceptance gates are project-planning additions.
