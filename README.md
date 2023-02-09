[![CI](https://github.com/kimgoetzke/Practice-Basic-CI/actions/workflows/basic-ci-workflow.yml/badge.svg?branch=main)](https://github.com/kimgoetzke/Practice-Basic-CI/actions/workflows/basic-ci-workflow.yml)

# Basic CI Project

This repository was created to practice building a basic CI pipeline with GitHub Actions, Gradle, Java and Docker.

## How it works
### Feature workflow

Branches created with a name starting with `feature-` trigger the GitHub Actions feature workflow (see `basic-ci-feature-workflow.yml`).
1. Request a runner with Ubuntu
2. Set up Java
3. Validate Gradle wrapper 
2. Build application, run all tests and build scan 
3. Upload Gradle build reports and attach as artifact to action 
4. Upload Jacoco test coverage reports and attach as artifact to action 
5. Create Docker images and upload to DockerHub
6. Run Trivy vulnerability scan and fail if critical vulnerabilities detected*
7. Upload vulnerability scan results as artifact to action

A new Docker image `feature-{name}_v{github.run_number}` is created and `feature-{name}_latest` is overwritten.

### Main/release workflow

Only branches with the `feature-` prefix are permitted to push to main. Changes to main trigger workflow `basic-ci-workflow.yml`.
1. Request a runner with Ubuntu, set up Java, and validate Gradle wrapper 
2. Request a runner with Ubuntu
2. Set up Java
3. Validate Gradle wrapper
2. Build application, run all tests and build scan
3. Create Docker images and upload to DockerHub 
4. Create a release on GitHub
5. Use content of `latest_release_notes.txt` as release notes body

A new Docker image `main_v{github.run_number}` is created and `main_latest` is overwritten. Release is named `v{github.run_number}`.

### Branch protection
![ci-diagram.svg](ci-diagram.svg)