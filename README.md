# kanna

gradle with kotlin spring boot etc.

## gradle knowledge base

### build.gradle.kts

```bash
Here’s a section-by-section breakdown of what each part of your `build.gradle.kts` does:

1. Import  
   - `import com.google.protobuf.gradle.id`  
     Pulls in the `id("grpc")` helper extension for the Protobuf plugin.

2. plugins {…}  
   Applies Gradle plugins:  
   - `kotlin("jvm")` + `plugin.spring` → Kotlin + Spring support  
   - `org.springframework.boot` → Boot tasks (jar, run, etc.)  
   - `io.spring.dependency-management` → Maven-style BOM imports  
   - `org.graalvm.buildtools.native` → Native-image build support  
   - `com.google.protobuf` → Protobuf code generation

3. group / version  
   Sets your project’s Maven coordinates (`groupId` / `version`).

4. java { toolchain {…} }  
   Configures the JDK version (21) used to compile and run the code.

5. configurations {…}  
   Makes `compileOnly` extend from `annotationProcessor` so annotation-only deps (e.g. Lombok) are available at compile-time but excluded from the runtime classpath.

6. repositories {…}  
   Declares where Gradle should fetch dependencies (here, Maven Central).

7. extra["springGrpcVersion"]  
   Defines a custom property for the Spring-gRPC BOM version, so you can reuse it in `dependencyManagement`.

8. dependencies {…}  
   Lists all your artifacts by configuration:  
   - `implementation` → runtime + compile  
   - `compileOnly` → compile-only (no runtime)  
   - `developmentOnly` → only on the dev classpath  
   - `runtimeOnly` → only at runtime  
   - `annotationProcessor` → code-gen at compile time  
   - `testImplementation` / `testRuntimeOnly` → for tests

9. dependencyManagement { imports {…} }  
   Imports the Spring-gRPC BOM to align versions of all related gRPC artifacts automatically.

10. kotlin { compilerOptions {…} }  
    Adds Kotlin compiler arguments (`-Xjsr305=strict`) for stricter null-safety checks.

11. protobuf {…}  
    Configures the Protobuf plugin:  
    - `protoc` → compiler artifact  
    - `plugins.grpc` → gRPC codegen plugin  
    - `generateProtoTasks` → applies plugin options (e.g. omit Jakarta annotations)

12. tasks.withType<Test> { useJUnitPlatform() }  
    Instructs Gradle to run tests with JUnit Platform (JUnit 5).
```